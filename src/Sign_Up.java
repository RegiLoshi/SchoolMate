import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.time.LocalDate;
//database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import java.sql.Date;


public class Sign_Up {
    private JLabel logo;
    private JLabel slogan;
    private JLabel welcome_label1;
    private int age;
    private JFrame frame;
    private JLabel name_label;
    private JTextField txtName;
    private JTextField txtSurname;
    private JDateChooser dateChooser;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton sign_up_button;
    private JButton reset_button;
    private JLabel surname_label;
    private JLabel gender_label;
    private ButtonGroup gender;
    private ButtonGroup role_group;
    private JButton log_in_button;
    private JCheckBox check_student;
    private JCheckBox check_teacher;
    private JCheckBox male_checkbox;
    private JCheckBox female_checkbox;
    private JCheckBox prefer_not_to_say_checkbox;
    private JComboBox<String> departament_combobox;
    private String gender_chosen;
    DateTimeFormatter dateFormatterInput = DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.ENGLISH);
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String role;
    private String db_url = "jdbc:mysql://localhost:3306/student_java_app";
    private String db_username = "root";
    private String db_password = "11112003";

    public Sign_Up() {
        initialize();
        setComponentPropertiesAndListeners();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(350, 100, 800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(85, 107, 47));
        panel.setBounds(0, -11, 400, 700);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // Logo
        logo = new JLabel("New label");
        logo.setIcon(new ImageIcon("/Users/regiloshi/Downloads/logo_woth_colors_student-2.png"));
        logo.setBounds(117, 218, 154, 90);
        panel.add(logo);

        // Slogan
        slogan = new JLabel("Connecting Classrooms, Bridging Futures");
        slogan.setLabelFor(logo);
        slogan.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        slogan.setForeground(new Color(255, 255, 255));
        slogan.setBounds(59, 320, 294, 53);
        panel.add(slogan);

        // Welcome Label
        welcome_label1 = new JLabel("WELCOME");
        welcome_label1.setForeground(new Color(85, 107, 47));
        welcome_label1.setHorizontalAlignment(SwingConstants.CENTER);
        welcome_label1.setFont(new Font("Lucida Grande", Font.PLAIN, 31));
        welcome_label1.setBounds(496, 6, 194, 37);
        frame.getContentPane().add(welcome_label1);

        // Name Label
        name_label = new JLabel("Name:");
        name_label.setBounds(426, 51, 61, 16);
        frame.getContentPane().add(name_label);

        // Name TextField
        txtName = new JTextField();
        txtName.setBounds(423, 77, 343, 40);
        frame.getContentPane().add(txtName);
        txtName.setColumns(10);

        // Surname Label
        surname_label = new JLabel("Surname:");
        surname_label.setBounds(426, 118, 61, 16);
        frame.getContentPane().add(surname_label);

        // Surname TextField
        txtSurname = new JTextField();
        txtSurname.setBounds(423, 134, 343, 40);
        frame.getContentPane().add(txtSurname);
        txtSurname.setColumns(10);

        // Gender Label
        gender_label = new JLabel("Gender:");
        gender_label.setBounds(426, 172, 61, 16);
        frame.getContentPane().add(gender_label);

        // Male Checkbox
        male_checkbox = new JCheckBox("Male");
        male_checkbox.setBounds(426, 188, 128, 23);
        frame.getContentPane().add(male_checkbox);

        // Female Checkbox
        female_checkbox = new JCheckBox("Female");
        female_checkbox.setBounds(425, 212, 128, 23);
        frame.getContentPane().add(female_checkbox);

        // I prefer not to say Checkbox
        prefer_not_to_say_checkbox = new JCheckBox("I prefer not to say");
        prefer_not_to_say_checkbox.setBounds(426, 235, 168, 23);
        frame.getContentPane().add(prefer_not_to_say_checkbox);

        // Email Label
        JLabel email_label = new JLabel("Email:");
        email_label.setBounds(426, 314, 61, 16);
        frame.getContentPane().add(email_label);

        // Email TextField
        txtEmail = new JTextField();
        txtEmail.setBounds(423, 332, 343, 40);
        frame.getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        // Password Label
        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setBounds(426, 369, 83, 16);
        frame.getContentPane().add(lblNewLabel_2);

        // Password TextField
        txtPassword = new JPasswordField();
        txtPassword.setBounds(426, 387, 343, 40);
        frame.getContentPane().add(txtPassword);

        // Study Program Label
        JLabel lblNewLabel_3 = new JLabel("Departament:");
        lblNewLabel_3.setBounds(426, 425, 127, 16);
        frame.getContentPane().add(lblNewLabel_3);

        // Role Label
        JLabel role_lebel = new JLabel("Role:");
        role_lebel.setBounds(426, 499, 61, 16);
        frame.getContentPane().add(role_lebel);

        // Student Checkbox
        check_student = new JCheckBox("Student");
        check_student.setBounds(426, 516, 128, 23);
        frame.getContentPane().add(check_student);

        // Teacher Checkbox
        check_teacher = new JCheckBox("Teacher");
        check_teacher.setBounds(426, 543, 128, 23);
        frame.getContentPane().add(check_teacher);

        // Date Of Birth Label
        JLabel date_of_birth_label = new JLabel("Date Of Birth:");
        date_of_birth_label.setBounds(426, 261, 95, 16);
        frame.getContentPane().add(date_of_birth_label);

        // Gender Button Group
        gender = new ButtonGroup();
        gender.add(male_checkbox);
        gender.add(prefer_not_to_say_checkbox);
        gender.add(female_checkbox);

        // Role Button Group
        role_group = new ButtonGroup();
        role_group.add(check_teacher);
        role_group.add(check_student);

        // Sign Up Button
        sign_up_button = new JButton("Sign Up");
        sign_up_button.setBounds(426, 578, 176, 29);
        frame.getContentPane().add(sign_up_button);

        // Reset Button
        reset_button = new JButton("Reset");
        reset_button.setBounds(590, 578, 176, 29);
        frame.getContentPane().add(reset_button);

        // Log In Button
        log_in_button = new JButton("Log In");
        log_in_button.setBounds(514, 619, 176, 29);
        frame.getContentPane().add(log_in_button);

        // Date Of Birth DateChooser
        dateChooser = new JDateChooser();
        dateChooser.setBounds(426, 276, 340, 26);
        frame.getContentPane().add(dateChooser);
        
        //departament chooser
        String[] departments = {"Choose Department", "SWE1", "SWE2", "SWE3", "CEN1", "CEN2", "CEN3", "ECE1", "ECE2", "ECE3"};
        departament_combobox = new JComboBox<>(departments);
        departament_combobox.setBounds(426, 453, 343, 40);
        frame.getContentPane().add(departament_combobox);
    }

	    private String fieldChecker() {
	try {
	    if (txtName.getText().isBlank()) {
	        return "Name Field Is Empty";
	    }
	    if (txtSurname.getText().isBlank()) {
	        return "Surname Field Is Empty";
	    }
	    if(!male_checkbox.isSelected() && !female_checkbox.isSelected() && !prefer_not_to_say_checkbox.isSelected()){
	        return "Please Select Your Gender";
	    }
	    LocalDate birthday = dateChooser.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //parses data to check format
	    LocalDate currentDate = LocalDate.now(); //gets time now to check if birthdate will be in the future
	    if (birthday.isAfter(currentDate)) {
	        return "Date is in the future";
	    }
	    if (txtEmail.getText().isBlank()) {
	        return "Email Field Is Empty";
	    }
	    if (!(txtEmail.getText().contains("@"))){
	        return "Enter A Valid Email";
	    }
	    if (String.copyValueOf(txtPassword.getPassword()).isBlank()) {
	        return "Password Field Is Empty";
	    }
	    if (String.copyValueOf(txtPassword.getPassword()).length() < 8){
	        return "Password Length must be minimum 8";
	    }
	    if(departament_combobox.getSelectedItem().toString().isBlank() || departament_combobox.getSelectedIndex() == 0) {
	        return "Departament not chosen";
	    }
	    if(!check_student.isSelected() && !check_teacher.isSelected()){
	        return "Please Choose One Of The Roles";
	    }
	    return "successful";
	} catch (DateTimeParseException e) {
	    return "Invalid date format";
	}
	}
    private void setComponentPropertiesAndListeners() {
        sign_up_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try{
                    if(fieldChecker().equals("successful")){
                    create_account();
                    }else{
                        throw new Exception(fieldChecker());
                    }
                    }catch (Exception error){
                        JOptionPane.showMessageDialog(frame,"Account Creation Failed.\n Error: " + error, "Error" , JOptionPane.ERROR_MESSAGE);
                    }
            }
        });

        reset_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtName.setText("");
                txtSurname.setText("");
                txtEmail.setText("");
                txtPassword.setText("");
                departament_combobox.setSelectedIndex(0);
                check_student.setSelected(false);
                check_teacher.setSelected(false);
                male_checkbox.setSelected(false);
                female_checkbox.setSelected(false);
                prefer_not_to_say_checkbox.setSelected(false);

                JOptionPane.showMessageDialog(frame, "Reset Successful!");
            }
        });

        log_in_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login_Or_SignUp();
                frame.dispose();
            }
        });
    }
    private void create_account() {
    	
    	
    	String dateOfBirthText = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
    	LocalDate parsedDate = LocalDate.parse(dateOfBirthText, dateFormatterInput);
        String formattedDate = parsedDate.format(dateFormatter);
        LocalDate dateOfBirth = LocalDate.parse(formattedDate, dateFormatter);
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        age = period.getYears();
        
        
    	String enteredEmail = txtEmail.getText().trim();
        char[] charPassword = txtPassword.getPassword();
        String enteredPassword = String.copyValueOf(charPassword);
        String query = "INSERT INTO login (email, pass, role) VALUES (?, ?, ?)";
        if(check_student.isSelected()) {
        	role = "student";
        }
        else {
        	role = "teacher";
        }
        enteredPassword = enteredPassword.trim();
        try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
            String checkQuery = "SELECT id FROM login WHERE email = ? AND role = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, enteredEmail);
            checkStatement.setString(2, role);

            ResultSet result = checkStatement.executeQuery();

            if (result.next()) {
                JOptionPane.showMessageDialog(frame, "Email Already Exists!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                // Email doesn't exist, proceed with account creation
                String insertQuery = "INSERT INTO login (email, pass, role) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery , Statement.RETURN_GENERATED_KEYS);
                insertStatement.setString(1, enteredEmail);
                insertStatement.setString(2, enteredPassword);
                insertStatement.setString(3, role);

                int rowsAffected = insertStatement.executeUpdate();

                if (rowsAffected > 0) {
                	ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                	if (generatedKeys.next()) {
                        int generatedId = generatedKeys.getInt(1);
                        createProfile(generatedId);
                    JOptionPane.showMessageDialog(frame, "Account Successfully Created.", "Successful", JOptionPane.DEFAULT_OPTION);
                    frame.dispose();
                    new Login_Or_SignUp();
                	}
                	} else {
                    // Insertion failed
                    JOptionPane.showMessageDialog(frame, "Account Creation Failed.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void createProfile(int id) {
    	if(male_checkbox.isSelected()) {
    		gender_chosen = "Male";
    	}else if(female_checkbox.isSelected()) {
    		gender_chosen = "Female";
    	}else {
    		gender_chosen = "Not Specified";
    	}
        try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
            String department = departament_combobox.getItemAt(departament_combobox.getSelectedIndex());
            String insertQuery;
            
            if (check_student.isSelected()) {
                insertQuery = "INSERT INTO students (student_id, name, surname, age, birthdate, departament , gender) VALUES (?, ?, ?, ?, ?, ? , ?)";
            } else{
                insertQuery = "INSERT INTO teachers (teacher_id, name, surname, age, birthdate, departament , gender) VALUES (?, ?, ?, ?, ?, ? , ?)";
            }
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setInt(1, id);
            insertStatement.setString(2, txtName.getText());
            insertStatement.setString(3, txtSurname.getText());
            insertStatement.setInt(4, age);
            insertStatement.setObject(5, new java.sql.Date(dateChooser.getDate().getTime()));
            insertStatement.setString(6, department);
            insertStatement.setString(7, gender_chosen);

            int rowsInserted = insertStatement.executeUpdate();
            if (rowsInserted > 0) {
                    String departmentInsertQuery = "INSERT INTO " + department + " (student_id) VALUES (?);";
                    PreparedStatement departmentInsertStatement = connection.prepareStatement(departmentInsertQuery);
                    departmentInsertStatement.setInt(1, id);

                    int departmentRowsInserted = departmentInsertStatement.executeUpdate();

                    if (departmentRowsInserted <= 0) {
                        JOptionPane.showMessageDialog(frame,"Account Creation Failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            } else {
                JOptionPane.showMessageDialog(frame, "Account Creation Failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}


