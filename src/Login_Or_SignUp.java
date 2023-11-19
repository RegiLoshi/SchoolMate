import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Login_Or_SignUp implements ActionListener{
    private JFrame loginOrSignUp_Frame;
    private JButton signIn;
    private JButton signUp;
    private JTextField email;
    private JPasswordField password;
    private JButton reset;
    private JLabel email_label;
    private JLabel password_label;
    private JLabel welcome_label;
    private JToggleButton studentButton;
    private JToggleButton teacherButton;
    private JLabel lblNewLabel_4;
    private String role;
    private ButtonGroup group;
    private JLabel logo;
    private JLabel slogan;
    private ImageIcon icon;
    private String db_url = "jdbc:mysql://localhost:3306/student_java_app";
    private String db_username = "root";
    private String db_password = "11112003";
    private int studentId;
    private String name;
	private String surname;
	private String department;
	private int age;
	private Date date_of_birth;
	private String gender; 
	private String bio;
	private String date_joined;
	
    public Login_Or_SignUp() {
        initializeComponents();
        setComponentPropertiesAndListeners();
        addComponentsAndConfigureFrame();
    }

    private void initializeComponents() {
    	icon = new ImageIcon(".//img/logo_woth_colors_student-2.png");
        email = new JTextField();
        email.setLocation(431, 161);
        email.setSize(343, 40);
        reset = new JButton("Reset");
        reset.setLocation(496, 354);
        reset.setSize(176, 29);
        signIn = new JButton("Log In");
        signIn.setBackground(new Color(85, 107, 47));
        signIn.setBounds(496, 313, 176, 29);
        signUp = new JButton("Sign Up");
        signUp.setBounds(496, 423, 176, 29);

        email_label = new JLabel("Email:");
        email_label.setLabelFor(email);
        email_label.setHorizontalAlignment(SwingConstants.LEFT);
        email_label.setBounds(432, 118, 61, 23);

        password_label = new JLabel("Password:");
        password_label.setBounds(431, 220, 86, 16);

        password = new JPasswordField();
        password.setBounds(431, 248, 343, 40);
        password_label.setLabelFor(password);

        welcome_label = new JLabel("WELCOME");
        welcome_label.setFont(new Font("Lucida Grande", Font.PLAIN, 31));
        welcome_label.setForeground(new Color(85, 107, 47));
        welcome_label.setHorizontalAlignment(SwingConstants.CENTER);
        welcome_label.setBounds(496, 6, 194, 37);

        studentButton = new JToggleButton("Student");
        studentButton.setBounds(599, 90, 141, 23);
        

        group = new ButtonGroup();
        group.add(studentButton);
        
        
        lblNewLabel_4 = new JLabel("Choose role:");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setBounds(523, 55, 136, 16);

        loginOrSignUp_Frame = new JFrame();
        loginOrSignUp_Frame.setIconImage(icon.getImage());
        loginOrSignUp_Frame.setResizable(false);
        loginOrSignUp_Frame.setTitle("Connect!");
        loginOrSignUp_Frame.getContentPane().setLayout(null);
        loginOrSignUp_Frame.getContentPane().add(signIn);
        loginOrSignUp_Frame.getContentPane().add(signUp);
        loginOrSignUp_Frame.getContentPane().add(email);
        loginOrSignUp_Frame.getContentPane().add(reset);
        loginOrSignUp_Frame.getContentPane().add(email_label);
        loginOrSignUp_Frame.getContentPane().add(password_label);
        loginOrSignUp_Frame.getContentPane().add(password);
        
        
        teacherButton = new JToggleButton("Teacher");
        teacherButton.setBounds(446, 90, 141, 23);        
        group.add(teacherButton);
        loginOrSignUp_Frame.getContentPane().add(teacherButton);
        loginOrSignUp_Frame.getContentPane().add(welcome_label);
        loginOrSignUp_Frame.getContentPane().add(studentButton);
        loginOrSignUp_Frame.getContentPane().add(lblNewLabel_4);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(85, 107, 47));
        panel.setBounds(0, -11, 400, 500);
        loginOrSignUp_Frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        logo = new JLabel("New label");
        logo.setIcon(new ImageIcon("/Users/regiloshi/Downloads/logo_woth_colors_student-2.png"));
        logo.setBounds(117, 144, 154, 90);
        panel.add(logo);
        
        slogan = new JLabel("Connecting Classrooms, Bridging Futures");
        slogan.setLabelFor(logo);
        slogan.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        slogan.setForeground(new Color(255, 255, 255));
        slogan.setBounds(68, 246, 294, 53);
        panel.add(slogan);
    }

    private void setComponentPropertiesAndListeners() {
        signIn.addActionListener(this);
        signUp.addActionListener(this);
        reset.addActionListener(this);
        studentButton.addActionListener(this);
        teacherButton.addActionListener(this);
}

    private void addComponentsAndConfigureFrame() {
        loginOrSignUp_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginOrSignUp_Frame.setVisible(true);
        loginOrSignUp_Frame.setBounds(350, 200, 800, 500);
    }

    private void performLogin() {
    	if(!(studentButton.isSelected() || teacherButton.isSelected())) {
    		JOptionPane.showMessageDialog(loginOrSignUp_Frame, "Select a role!", "Alert", JOptionPane.WARNING_MESSAGE);
    	}
    	else {
    	if(studentButton.isSelected()) {
    		role = "student";
    	}
    	if(teacherButton.isSelected()) {
    		teacherButton.setBackground(new Color(85, 107, 47));
    		role = "teacher";
    	}
        String enteredEmail = email.getText().trim();
        char[] charPassword = password.getPassword();
        String enteredPassword = String.copyValueOf(charPassword);
        enteredPassword = enteredPassword.trim();
        String query = "Select * from login where email = '" + enteredEmail + "' && pass = '" + enteredPassword + "' && role = '" + role + "'";
        
        
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e) {
        	
        	e.printStackTrace();
        }
        try {
        	Connection connection = DriverManager.getConnection(db_url, db_username , db_password);
        	Statement statement = connection.createStatement();
        	ResultSet result = statement.executeQuery (query);
        	if(result.next()) {
        		if(role.equals("student")) {
                JOptionPane.showMessageDialog(loginOrSignUp_Frame, "Successful Login");
                getUserInfo(enteredEmail , enteredPassword , role);
                new App(studentId , name , surname , age , date_of_birth , department , gender , enteredEmail , enteredPassword , bio , date_joined);
                loginOrSignUp_Frame.dispose();
            }else if(role.equals("teacher")) {
            	JOptionPane.showMessageDialog(loginOrSignUp_Frame, "Successful Login");
                getUserInfo(enteredEmail , enteredPassword , role);
                new Teacher_app(studentId , name , surname , age , date_of_birth , department , gender , enteredEmail , enteredPassword , bio , date_joined);
                loginOrSignUp_Frame.dispose();
            }
        	}else {
                JOptionPane.showMessageDialog(loginOrSignUp_Frame, "Account Not Found!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }catch (SQLException e) {
        	e.printStackTrace();
        }   
    	}
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signIn) {
            performLogin();
        } else if (e.getSource() == reset) {
            email.setText("");
            password.setText("");
            JOptionPane.showMessageDialog(loginOrSignUp_Frame, "Reset Successful!");
        } else if (e.getSource() == studentButton) {
            role = "student";
        } else if (e.getSource() == teacherButton) {
            role = "teacher";
        }else if (e.getSource() == signUp) {
        	new Sign_Up();
        	loginOrSignUp_Frame.dispose();
        }
    }
    public void getUserInfo(String email , String password , String role) {
    	try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
    		if(role.equals("student")) {
    	Statement statement = connection.createStatement();
    	String query = "SELECT students.* FROM students INNER JOIN login ON students.student_id = login.id where email = '" + email + "' && pass = '" + password + "' && role = '" + role + "'";
    	ResultSet result = statement.executeQuery (query);
    	while(result.next())
    	{
    		studentId = result.getInt("student_id");
    		name = result.getString("name");
    		surname = result.getString("surname");
    		age = result.getInt("age");
    		date_of_birth = result.getDate("birthdate");
    		department = result.getString("departament");
    		gender = result.getString("gender");
    	}
    	Connection connection2 = DriverManager.getConnection(db_url, db_username , db_password);
    	Statement statement2 = connection2.createStatement();
    	String query2 = "SELECT * FROM login where email = '" + email + "' && pass = '" + password + "' && role = '" + role + "'";
    	ResultSet result2 = statement2.executeQuery (query2);
    	while(result2.next())
    	{
    	bio = result2.getString("bio");
    	date_joined = result2.getString("date_joined");
    	date_joined = date_joined.substring(0, 10);
    	}
    		}else if(role.equals("teacher")) {
    	    	Statement statement = connection.createStatement();
    	    	String query = "SELECT teachers.* FROM teachers INNER JOIN login ON teachers.teacher_id = login.id where email = '" + email + "' && pass = '" + password + "' && role = '" + role + "'";
    	    	ResultSet result = statement.executeQuery (query);
    	    	while(result.next())
    	    	{
    	    		studentId = result.getInt("teacher_id");
    	    		name = result.getString("name");
    	    		surname = result.getString("surname");
    	    		age = result.getInt("age");
    	    		date_of_birth = result.getDate("birthdate");
    	    		department = result.getString("departament");
    	    		gender = result.getString("gender");
    	    	}
    	    	Connection connection2 = DriverManager.getConnection(db_url, db_username , db_password);
    	    	Statement statement2 = connection2.createStatement();
    	    	String query2 = "SELECT * FROM login where email = '" + email + "' && pass = '" + password + "' && role = '" + role + "'";
    	    	ResultSet result2 = statement2.executeQuery (query2);
    	    	while(result2.next())
    	    	{
    	    	bio = result2.getString("bio");
    	    	date_joined = result2.getString("date_joined");
    	    	date_joined = date_joined.substring(0, 10);
    	    	}
    		}		
    	}catch(SQLException e) {
    		e.printStackTrace();
}
    }
}

