import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;



public class App implements ActionListener {

	private JFrame frame;
	private JLabel random_motivation;
	private JPanel dashboard_panel;
	private JPanel menu_options;
	private JPanel info_panel;
	private JPanel grade_panel;
	private JPanel assignment;
	private JPanel search_user_panel;
	private JPanel search_panel;
	private String[] motivatingPhrases = {
		    "Believe in yourself.",
		    "Hard work pays off.",
		    "Keep learning.",
		    "Embrace challenges.",
		    "Make an impact.",
		    "Inspire greatness.",
		    "Never give up.",
		    "Shape young minds.",
		    "Dream big.",
		    "Change lives.",
		    "Build a bright future."
		};

	private Random generator = new Random();
	private int randomIndex = generator.nextInt(motivatingPhrases.length);
	private JPanel gpa_pane;
	private JLabel gpa_label;
	private JLabel gpa;
	private JPanel info_pane;
	private JLabel welcome_back_label;
	private JLabel name_label;
	private JLabel image_label;
	private JLabel departament_label;
	private JPanel panel;
	private JLabel date_label;
	private JButton grade_button;
	private JPanel Inspiration_pane;
	private JLabel Inspiration_label;
	private JPanel assignment_panel;
	private JTable timetable;
	private JTextArea homework_desc;
	private Student student;
	private JTabbedPane tabbedPane;
	JLabel current_time_label;
	private JButton log_out_button;
	private JButton info_button;
	private JTextArea bio_writing;
	private JLabel role_label;
	private JButton edit_profile;
	private JLabel friends_label;
	JPasswordField oldpass;
	JPasswordField newpass;
	private String enteredNewPassword;
	private String enteredOldPass;
	private JButton edit_bio;
	private JButton go_back_1;
	private JButton gradeButton;
	private JLabel grade_label;
	private JLabel department_class_grades_label;
	private JPanel subject_1_pane;
	private JLabel subject_1_label;
	private JLabel subject_1_grade;
	private JPanel subject_2_panel;
	private JLabel subject_2_label;
	private JLabel subject_2_grade;
	private JPanel subject_3_panel;
	private JLabel subject_3_label;
	private JLabel subject_3_grade;
	private JPanel subject_4_panel;
	private JLabel subject_4_label;
	private JLabel subject_4_grade;
	private JPanel subject_5_panel;
	private JLabel subject_5_label;
	private JLabel subject_5_grade;
	private JLabel name_grade_label;
	private JPanel gpa_grade_pane;
	private JLabel gpa_grade_label;
	private JLabel gpa_grade_grade;
	private JButton go_back_2;
	private String subject_1;
	private String subject_2;
	private String subject_3;
	private String subject_4;
	private String subject_5;
	private String db_url = "jdbc:mysql://localhost:3306/student_java_app";
    private String db_username = "root";
    private String db_password = "11112003";
    private String grade_1;
    private String grade_2;
    private String grade_3;
    private String grade_4;
    private String grade_5;
    private String gpa_grade;
    private double grade;
    private JButton assigment_button;
    private JButton go_back;
    private JLabel assignment_panel_label;
    private String dateString;
    private JButton go_back_3;
    private JButton search_button;
    private JLabel search_user_label;
    private JTextField search_input_field;
    private JButton search_user_button;
    private JButton reset_search_user_button;
    private JPanel search_user_results;
    private String query;
    private DefaultTableModel userTableModel;
    private JTable user_info_table;
    private Student searched_user_s;
    private Teacher searched_user_t;
    private JButton search_users_button;
    private String name_of_searched_user;
    private String surName_of_searched_user;
    private String age_of_selected_user;
    private String gender_of_selected_user;
    private String department_of_selected_user;
    private String date_of_birth_searched;
    private int studentId;
    private String bio;
	private String date_joined;
	private String email;
	private String password;
    private JTextArea searched_bio_writing;
    private JLabel searched_friends_label;
    private JPanel searched_horizontal_Photo;
    private JLabel searched__profile_label;
    private JLabel user_profile_photo;
    private JLabel searched_full_name_label;
    private JLabel search_department_label;
    private JLabel searched_joined_label;
    private JPanel searched_bio_panel;
    private JLabel searched_bio_label;
    private JLabel searched_role_label;
    private JButton add_friend;
    private JButton go_back_4;
    private JButton notification_button;
    private JPanel notification_window;
    private int checker = 0;
    private DefaultTableModel NotiTableModel;
    private JTable Noti_table;
    private JScrollPane NotiscrollPane;
    private String name_sender;
	private String surname_sender;
	private int age_sender;
	private String department_sender;
	private String gender_sender;
	private int request_Id ;
	private JPanel friends_panel;
	private JButton friends_button;
	private JLabel friend_requests_label;
	private DefaultTableModel friend_request_table_model;
	private JTable friend_request_table;
	private JScrollPane friend_request_scroll_pane; 
	private String seen;
	private HashMap<Integer, List<String>> notis = new HashMap<>();
	private JButton accept_friend;
	private JButton reject_friend;
	private JButton go_back_5;
	private int student_id;
	private DefaultTableModel friend_table_model;
	private JTable friend_table;
	private JScrollPane friend_scroll_pane;
	private JButton remove_friend;
    private JLabel friends_number_label;
    private HashMap<Integer, List<String>> friends = new HashMap<>();
    private JPanel messaging_panel;
    private JButton messaging_button;
    private JButton go_back_6;
    private DefaultTableModel messaging_table_model;
    private JTable messaging_table;
    private JScrollPane messaging_scroll;
    private JTextPane message_area;
    private HashMap<Integer, Integer> friends_id = new HashMap<>();
    private int friend_id;
    private int selected_friend;
    private String message_friend_name;
    private JTextField message_input;
    private JButton send_message_button_ ;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private String sr_role;
    private JLabel subject_assigment_1;
    private JLabel choose_file_label;
    private JButton choose_file_button;
    private JTextArea assigment_area;
    private JLabel to_be_delivered;
    private JLabel teacher_name_assigment;
    private JLabel assigment_tittle_label;
	public App(int studentId , String name , String surname , int age , Date date_of_birth , String department,String  gender , String email , String password , String bio , String date_joined) {
		student = new Student(name , surname , age , date_of_birth , department ,studentId , gender , email , password , bio , date_joined);
		initialize();
		updateTime();
		checkForFriendRequest();
		checkForNewMessages();
	}
	public void initialize() {
		
		scheduler.scheduleAtFixedRate(this::checkForNewMessages, 0, 5, TimeUnit.SECONDS);
		getSubjectNames();
		student.getAssignment();
		student.getGrades();
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(0, 100, 1500, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("School App");
		frame.getContentPane().setLayout(null);
		

		menu_options = new JPanel();
		menu_options.setBackground(new Color(85, 107, 47));
		menu_options.setBounds(0, 0, 236, 1200);
		menu_options.setLayout(null);
		frame.getContentPane().add(menu_options);
		
		dashboard_panel = new JPanel();
    	dashboard_panel.setBackground(Color.WHITE);
    	dashboard_panel.setBounds(235, 0, 1511, 1200);
    	
    	info_panel = new JPanel();
    	info_panel.setBackground(Color.WHITE);
    	info_panel.setBounds(235, 0, 1511, 1200);
    	info_panel.setLayout(null);
    	
    	search_panel = new JPanel();
    	search_panel.setBackground(Color.WHITE);
    	search_panel.setBounds(235, 0, 1511, 1200);
    	search_panel.setLayout(null);
    	
    	grade_panel = new JPanel();
    	grade_panel.setBackground(Color.WHITE);
    	grade_panel.setBounds(235, 0, 1511, 1200);
    	grade_panel.setLayout(null);
    	
    	assignment = new JPanel();
    	assignment.setBackground(Color.WHITE);
    	assignment.setBounds(235, 0, 1511, 1200);
    	assignment.setLayout(null);
    	
    	search_user_panel = new JPanel();
    	search_user_panel.setBackground(Color.WHITE);
    	search_user_panel.setBounds(235, 0, 1511, 1200);
    	
    	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(-11, -26, 1522, 1226);
        tabbedPane.add(dashboard_panel);
        tabbedPane.add(info_panel);
        tabbedPane.add(grade_panel);
        
        friends_panel = new JPanel();
        friends_panel.setBackground(Color.WHITE);
        friends_panel.setBounds(235, 0, 1511, 1200);
        friends_panel.setLayout(null);
        tabbedPane.add(friends_panel);
        
        
        friends_number_label = new JLabel();
        friends_number_label.setForeground(new Color(85, 107, 47));
        friends_number_label.setText("Friends: " + student.get_numberOfFriends());
        friends_number_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        friends_number_label.setBounds(279, 59, 259, 38);
        friends_panel.add(friends_number_label);
        
        friend_requests_label = new JLabel("Friend Request:");
        friend_requests_label.setForeground(new Color(85, 107, 47));
        friend_requests_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        friend_requests_label.setBounds(877, 72, 259, 38);
        friends_panel.add(friend_requests_label);
        friend_request_table = new JTable(friend_request_table_model);
        friend_request_table.setBackground(new Color(192, 192, 192));
        friend_request_table.setBounds(334, 219, 592, 420);
        friend_request_table.setGridColor(Color.BLACK);
        friend_request_table.setRowHeight(50);
        friend_request_table.setDefaultEditor(Object.class, null);
        friend_request_table.setSelectionBackground(new Color(238 , 238 , 238));
        friend_request_table.setSelectionForeground(Color.black);
        friend_request_table.setFocusable(false);
        JTableHeader friend_request_header = friend_request_table.getTableHeader();
        friend_request_scroll_pane = new JScrollPane(friend_request_table);
        friend_request_scroll_pane.setBounds(877, 169, 475, 420);
        friends_panel.add(friend_request_scroll_pane);
        
        
        friend_table_model = new DefaultTableModel();
		friend_table_model.addColumn("Name");
		friend_table_model.addColumn("Surname");
		friend_table_model.addColumn("Age");
		friend_table_model.addColumn("Department");
		friend_table_model.addColumn("Gender");
		friend_table_model.addColumn("Role");
        friend_table = new JTable(friend_table_model);
        friend_table.setBackground(new Color(192, 192, 192));
        friend_table.setBounds(334, 219, 592, 420);
        friend_table.setGridColor(Color.BLACK);
        friend_table.setRowHeight(50);
        friend_table.setDefaultEditor(Object.class, null);
        friend_table.setSelectionBackground(new Color(238 , 238 , 238));
        friend_table.setSelectionForeground(Color.black);
        friend_table.setFocusable(false);
        JTableHeader friend_header = friend_table.getTableHeader();
        friend_header.setBackground(new Color(192, 192, 192));
		friend_header.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		friend_header.setForeground(Color.black);
        friend_scroll_pane = new JScrollPane(friend_table);
        friend_scroll_pane.setBounds(279, 169, 475, 420);
        friends_panel.add(friend_scroll_pane);
        
        accept_friend = new JButton("Accept Friend Request");
        accept_friend.setForeground(new Color(85, 107, 47));
        accept_friend.setBounds(877, 601, 174, 29);
        accept_friend.setFocusable(false);
        accept_friend.addActionListener(this);
        friends_panel.add(accept_friend);
        
        reject_friend = new JButton("Reject Friend Request");
        reject_friend.setForeground(new Color(128, 0, 0));
        reject_friend.setBounds(1178, 601, 174, 29);
        reject_friend.setFocusable(false);
        reject_friend.addActionListener(this);
        friends_panel.add(reject_friend);
        
        go_back_5 = new JButton("Go Back");
        go_back_5.setForeground(new Color(85, 107, 47));
        go_back_5.setBounds(281, 670, 174, 29);
        go_back_5.setFocusable(false);
        go_back_5.addActionListener(this);
        friends_panel.add(go_back_5);
        
        remove_friend = new JButton("Remove Friend");
        remove_friend.setForeground(new Color(128, 0, 0));
        remove_friend.addActionListener(this);
        remove_friend.setFocusable(false);
        remove_friend.setBounds(580, 601, 174, 29);
        friends_panel.add(remove_friend);
        
        
        messaging_panel = new JPanel();
        messaging_panel.setBackground(Color.WHITE);
        messaging_panel.setBounds(0, 0, 1501, 1180);
        messaging_panel.setLayout(null);
        tabbedPane.add(messaging_panel);
        
        messaging_table_model = new DefaultTableModel();
		messaging_table_model.addColumn("Friends");
        messaging_table = new JTable(messaging_table_model);
        messaging_table.setBackground(new Color(192, 192, 192));
        messaging_table.setBounds(334, 219, 250, 420);
        messaging_table.setGridColor(Color.BLACK);
        messaging_table.setRowHeight(50);
        messaging_table.setDefaultEditor(Object.class, null);
        messaging_table.setSelectionBackground(new Color(238 , 238 , 238));
        messaging_table.setSelectionForeground(Color.black);
        messaging_table.setFocusable(false);
        messaging_table.addMouseListener(new MouseAdapter()  {
        	 public void mouseClicked(MouseEvent e) {
        	selected_friend = messaging_table.getSelectedRow();
        	message_friend_name = messaging_table.getModel().getValueAt(selected_friend, 0).toString();
        	getMessages(friends_id.get(selected_friend),message_friend_name);
        	message_input.setEnabled(true);
        	message_input.setVisible(true);
        	send_message_button_.setEnabled(true);
        	send_message_button_.setVisible(true);
        	 }
        });
        JTableHeader messaging_header = messaging_table.getTableHeader();
        messaging_header.setBackground(new Color(192, 192, 192));
		messaging_header.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		messaging_header.setForeground(Color.black);
        messaging_scroll = new JScrollPane(messaging_table);
        messaging_scroll.setBounds(279, 169, 200, 420);
        messaging_scroll.setBorder(BorderFactory.createLineBorder(Color.black));
        messaging_panel.add(messaging_scroll);
        
        
        go_back_6 = new JButton("Go Back");
        go_back_6.addActionListener(this);
        go_back_6.setForeground(new Color(85, 107, 47));
        go_back_6.setFocusable(false);
        go_back_6.setBounds(290, 698, 174, 29);
        messaging_panel.add(go_back_6);
        
        JLabel messaging_label = new JLabel();
        messaging_label.setText("Messages:");
        messaging_label.setForeground(new Color(85, 107, 47));
        messaging_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        messaging_label.setBounds(290, 79, 259, 38);
        messaging_panel.add(messaging_label);
        
        message_area = new JTextPane();
        message_area.setBounds(482, 169, 869, 420);
        message_area.setEditable(false);
        message_area.setCaretColor(Color.WHITE);
        JScrollPane message_scroll = new JScrollPane();
        message_scroll.setBounds(482, 169, 869, 420);
        message_scroll.setBorder(BorderFactory.createLineBorder(Color.black));
        message_scroll.setViewportView(message_area);
        
        
        messaging_panel.add(message_scroll);
        
        message_input = new JTextField();
        message_input.setBounds(482, 590, 800, 44);
        message_input.setBorder(BorderFactory.createLineBorder(Color.black));
        messaging_panel.add(message_input);
        message_input.setColumns(10);
        message_input.setEnabled(false);
        message_input.setVisible(false);
        
        send_message_button_ = new JButton("");
        send_message_button_.setIcon(new ImageIcon("/Users/regiloshi/Downloads/output-onlinepngtools-24.png"));
        send_message_button_.addActionListener(this);
        send_message_button_.setBounds(1279, 590, 72, 44);
        send_message_button_.setContentAreaFilled(false);
        send_message_button_.setFocusable(false); 
        send_message_button_.setBorderPainted(false);
        send_message_button_.setFocusPainted(false);
        send_message_button_.setEnabled(false);
        send_message_button_.setVisible(false);
        messaging_panel.add(send_message_button_);
        tabbedPane.add(assignment);
        tabbedPane.add(search_user_panel);
        tabbedPane.add(search_panel);
        search_user_panel.setLayout(null);
        
        go_back_3 = new JButton("Go Back");
        go_back_3.setForeground(new Color(85, 107, 47));
        go_back_3.setBounds(334, 682, 174, 29);
        go_back_3.addActionListener(this);
        search_user_panel.add(go_back_3);
        
        notification_window = new JPanel();
        notification_window.setBounds(1150, 68, 300, 400);
        notification_window.setBorder(BorderFactory.createLineBorder(Color.black));
        dashboard_panel.add(notification_window);
        notification_window.setVisible(false);
        
        
        NotiTableModel = new DefaultTableModel();
        NotiTableModel.addColumn("Notifications");
        
        search_user_label = new JLabel("SEARCH FOR A USER");
        search_user_label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        search_user_label.setForeground(new Color(85, 107, 47));
        search_user_label.setHorizontalAlignment(SwingConstants.CENTER);
        search_user_label.setBounds(487, 6, 717, 40);
        search_user_panel.add(search_user_label);
        
        search_input_field = new JTextField();
        search_input_field.setBounds(334, 87, 340, 26);
        search_user_panel.add(search_input_field);
        search_input_field.setColumns(10);
        
        JLabel serach_name_label = new JLabel("Search:");
        serach_name_label.setBounds(334, 59, 61, 16);
        search_user_panel.add(serach_name_label);
        
        search_user_button = new JButton("Submit");
        search_user_button.setForeground(new Color(85, 107, 47));
        search_user_button.addActionListener(this);
        search_user_button.setBounds(686, 87, 117, 26);
        search_user_panel.add(search_user_button);
        
        reset_search_user_button = new JButton("Reset");
        reset_search_user_button.setForeground(new Color(85, 107, 47));
        reset_search_user_button.setBounds(809, 87, 117, 26);
        reset_search_user_button.addActionListener(this);
        search_user_panel.add(reset_search_user_button);
        
        userTableModel = new DefaultTableModel();
        userTableModel.addColumn("Name");
        userTableModel.addColumn("Surname");
        userTableModel.addColumn("Age");
        userTableModel.addColumn("Gender");
        userTableModel.addColumn("Department");
        userTableModel.addColumn("Date Of Birth");
		user_info_table = new JTable(userTableModel);
		user_info_table.setBackground(new Color(192, 192, 192));
		user_info_table.setBounds(334, 219, 592, 420);
		user_info_table.setGridColor(Color.BLACK);
		user_info_table.setRowHeight(50);
		user_info_table.setDefaultEditor(Object.class, null);
		user_info_table.setSelectionBackground(new Color(238 , 238 , 238));
		user_info_table.setSelectionForeground(Color.black);
		user_info_table.setFocusable(false);
		JTableHeader user_header = user_info_table.getTableHeader();
		user_header.setBackground(new Color(192, 192, 192));
		user_header.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		user_header.setForeground(Color.black);
		JScrollPane UserscrollPane = new JScrollPane(user_info_table);
		UserscrollPane.setBounds(0, 0, 592, 420);
        
		
		friend_request_table_model = new DefaultTableModel();
		friend_request_table_model.addColumn("Name");
		friend_request_table_model.addColumn("Surname");
		friend_request_table_model.addColumn("Age");
		friend_request_table_model.addColumn("Department");
		friend_request_table_model.addColumn("Gender");
		friend_request_table_model.addColumn("Role");
		friend_request_header.setBackground(new Color(192, 192, 192));
		friend_request_header.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		friend_request_header.setForeground(Color.black);
		
		
		
        search_user_results = new JPanel();
        search_user_results.setBounds(334, 219, 592, 420);
        search_user_results.setLayout(null);
        search_user_results.add(UserscrollPane);
        search_user_panel.add(search_user_results);
        
        JScrollPane scrollPane_search_user = new JScrollPane();
        search_user_results.add(scrollPane_search_user);
        
        search_users_button = new JButton("Search");
        search_users_button.setForeground(new Color(85, 107, 47));
        search_users_button.setBounds(752, 682, 174, 29);
        search_users_button.addActionListener(this);
        search_user_panel.add(search_users_button);
        
        
        go_back = new JButton("Go Back");
        go_back.setForeground(new Color(85, 107, 47));
        go_back.setBounds(305, 634, 174, 29);
        go_back.addActionListener(this);
        go_back.setFocusable(false);
        assignment.add(go_back);
        
        assignment_panel_label = new JLabel("Upcoming Assignment");
        assignment_panel_label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        assignment_panel_label.setHorizontalAlignment(SwingConstants.CENTER);
        assignment_panel_label.setForeground(new Color(85, 107, 47));
        assignment_panel_label.setBounds(443, 6, 540, 51);
        assignment.add(assignment_panel_label);
        
        
        assigment_area = new JTextArea();
        assigment_area.setBackground(new Color(211, 211, 211));
        assigment_area.setBounds(305, 260, 689, 154);
        assigment_area.setEditable(false);
        assigment_area.setLineWrap(true); 
        assigment_area.setWrapStyleWord(true);
        assigment_area.setBackground(new Color(238 , 238 , 238));
        assigment_area.append(student.getAssignmentDesc());
        assigment_area.setColumns(10);
        assigment_area.setCaretColor(new Color(238 , 238 , 238));
        assignment.add(assigment_area);
        
        to_be_delivered = new JLabel("To Be Delivered By: " + student.getDeliveryDatetime());
        to_be_delivered.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        to_be_delivered.setForeground(new Color(85, 107, 47));
        to_be_delivered.setBackground(new Color(85, 107, 47));
        to_be_delivered.setBounds(305, 68, 368, 29);
        assignment.add(to_be_delivered);
        
        teacher_name_assigment = new JLabel("Teacher: " + student.getTeacherName());
        teacher_name_assigment.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        teacher_name_assigment.setForeground(new Color(85, 107, 47));
        teacher_name_assigment.setBounds(305, 109, 345, 34);
        assignment.add(teacher_name_assigment);
        
        assigment_tittle_label = new JLabel("Assignment Title: " + student.getAssignmentTitle());
        assigment_tittle_label.setBackground(new Color(255, 255, 255));
        assigment_tittle_label.setForeground(new Color(85, 107, 47));
        assigment_tittle_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        assigment_tittle_label.setBounds(305, 207, 678, 41);
        assignment.add(assigment_tittle_label);
        
        subject_assigment_1 = new JLabel("Subject: " + student.getAssignmentSubject());
        subject_assigment_1.setForeground(new Color(85, 107, 47));
        subject_assigment_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        subject_assigment_1.setBounds(305, 149, 678, 41);
        assignment.add(subject_assigment_1);
        
        choose_file_label = new JLabel("Submit File:");
        choose_file_label.setForeground(new Color(85, 107, 47));
        choose_file_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        choose_file_label.setBounds(305, 454, 689, 48);
        assignment.add(choose_file_label);
        
        choose_file_button = new JButton("Submit Assignment");
        choose_file_button.addActionListener(this);
        choose_file_button.setForeground(new Color(85, 107, 47));
        choose_file_button.setBounds(305, 514, 187, 41);
        assignment.add(choose_file_button);
        if(student.getAssignment() > 0) {
			choose_file_button.setEnabled(true);
		}else {
			choose_file_button.setEnabled(false);
		}
        
        grade_label = new JLabel("Grades");
        grade_label.setForeground(new Color(85, 107, 47));
        grade_label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        grade_label.setHorizontalAlignment(SwingConstants.CENTER);
        grade_label.setBounds(488, 6, 744, 55);
        grade_panel.add(grade_label);
        
        department_class_grades_label = new JLabel(student.getDepartment());
        department_class_grades_label.setForeground(new Color(85, 107, 47));
        department_class_grades_label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        department_class_grades_label.setBounds(276, 73, 468, 47);
        grade_panel.add(department_class_grades_label);
        
        subject_1_pane = new JPanel();
        subject_1_pane.setLayout(null);
        subject_1_pane.setBounds(780, 216, 279, 200);
        grade_panel.add(subject_1_pane);
        
        subject_1_label = new JLabel(subject_1);
        subject_1_label.setHorizontalAlignment(SwingConstants.CENTER);
        subject_1_label.setForeground(new Color(85, 107, 47));
        subject_1_label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        subject_1_label.setBounds(6, 9, 267, 55);
        subject_1_pane.add(subject_1_label);
        

        subject_1_grade = new JLabel();
        subject_1_grade.setHorizontalAlignment(SwingConstants.CENTER);
        subject_1_grade.setForeground(new Color(85, 107, 47));
        subject_1_grade.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
        subject_1_grade.setBounds(6, 60, 267, 121);
        
        
        grade = student.getGrade1();
        if (grade > 0) {
            if (grade >= 9) {
            	subject_1_grade.setForeground(Color.GREEN);
            } else if (grade >= 7.5) {
            	subject_1_grade.setForeground(Color.YELLOW);
            } else if (grade >= 6) {
            	subject_1_grade.setForeground(Color.ORANGE);
            } else {
            	subject_1_grade.setForeground(Color.RED);
            }

            grade_1 = Double.toString(grade);
        } else {
        	grade_1 = "Not Assigned";
        }

        subject_1_grade.setText("Grade: " + grade_1);
        subject_1_pane.add(subject_1_grade);
        
        subject_2_panel = new JPanel();
        subject_2_panel.setLayout(null);
        subject_2_panel.setBounds(1145, 216, 279, 200);
        grade_panel.add(subject_2_panel);
        
        subject_2_label = new JLabel(subject_2);
        subject_2_label.setHorizontalAlignment(SwingConstants.CENTER);
        subject_2_label.setForeground(new Color(85, 107, 47));
        subject_2_label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        subject_2_label.setBounds(6, 9, 267, 55);
        subject_2_panel.add(subject_2_label);
        

        subject_2_grade = new JLabel();
        subject_2_grade.setHorizontalAlignment(SwingConstants.CENTER);
        subject_2_grade.setForeground(new Color(85, 107, 47));
        subject_2_grade.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
        subject_2_grade.setBounds(6, 60, 267, 121);
        
        grade = student.getGrade2();
        if (grade > 0) {
            if (grade >= 9) {
            	subject_2_grade.setForeground(Color.GREEN);
            } else if (grade >= 7.5) {
            	subject_2_grade.setForeground(Color.YELLOW);
            } else if (grade >= 6) {
            	subject_2_grade.setForeground(Color.ORANGE);
            } else {
            	subject_2_grade.setForeground(Color.RED);
            }

            grade_2 = Double.toString(grade);
        } else {
        	grade_2 = "Not Assigned";
        }

        subject_2_grade.setText("Grade: " + grade_2);
        
        subject_2_panel.add(subject_2_grade);
        
        subject_3_panel = new JPanel();
        subject_3_panel.setLayout(null);
        subject_3_panel.setBounds(397, 500, 279, 200);
        grade_panel.add(subject_3_panel);
        
        subject_3_label = new JLabel(subject_3);
        subject_3_label.setHorizontalAlignment(SwingConstants.CENTER);
        subject_3_label.setForeground(new Color(85, 107, 47));
        subject_3_label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        subject_3_label.setBounds(6, 9, 267, 55);
        subject_3_panel.add(subject_3_label);
        

        subject_3_grade = new JLabel();
        subject_3_grade.setHorizontalAlignment(SwingConstants.CENTER);
        subject_3_grade.setForeground(new Color(85, 107, 47));
        subject_3_grade.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
        subject_3_grade.setBounds(6, 60, 267, 121);
        
        grade = student.getGrade3();
        if (grade > 0) {
            if (grade >= 9) {
            	subject_3_grade.setForeground(Color.GREEN);
            } else if (grade >= 7.5) {
            	subject_3_grade.setForeground(Color.YELLOW);
            } else if (grade >= 6) {
            	subject_3_grade.setForeground(Color.ORANGE);
            } else {
            	subject_3_grade.setForeground(Color.RED);
            }
            grade_3 = Double.toString(grade);
        } else {
        	grade_3 = "Not Assigned";
        }

        subject_3_grade.setText("Grade: " + grade_3);
        
        subject_3_panel.add(subject_3_grade);
        
        subject_4_panel = new JPanel();
        subject_4_panel.setLayout(null);
        subject_4_panel.setBounds(780, 500, 279, 200);
        grade_panel.add(subject_4_panel);
        
        subject_4_label = new JLabel(subject_4);
        subject_4_label.setHorizontalAlignment(SwingConstants.CENTER);
        subject_4_label.setForeground(new Color(85, 107, 47));
        subject_4_label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        subject_4_label.setBounds(6, 9, 267, 55);
        subject_4_panel.add(subject_4_label);
        
        
        subject_4_grade = new JLabel();
        subject_4_grade.setHorizontalAlignment(SwingConstants.CENTER);
        subject_4_grade.setForeground(new Color(85, 107, 47));
        subject_4_grade.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
        subject_4_grade.setBounds(6, 60, 267, 121);
        
        grade = student.getGrade4();
        if (grade > 0) {
            if (grade >= 9) {
            	subject_4_grade.setForeground(Color.GREEN);
            } else if (grade >= 7.5) {
            	subject_4_grade.setForeground(Color.YELLOW);
            } else if (grade >= 6) {
            	subject_4_grade.setForeground(Color.ORANGE);
            } else {
            	subject_4_grade.setForeground(Color.RED);
            }

            grade_4 = Double.toString(grade);
        } else {
        	grade_4 = "Not Assigned";
        }

        subject_4_grade.setText("Grade: " + grade_4);
        subject_4_panel.add(subject_4_grade);
        
        subject_5_panel = new JPanel();
        subject_5_panel.setLayout(null);
        subject_5_panel.setBounds(1145, 500, 279, 200);
        grade_panel.add(subject_5_panel);
        
        subject_5_label = new JLabel(subject_5);
        subject_5_label.setHorizontalAlignment(SwingConstants.CENTER);
        subject_5_label.setForeground(new Color(85, 107, 47));
        subject_5_label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        subject_5_label.setBounds(6, 9, 267, 55);
        subject_5_panel.add(subject_5_label);
        

        subject_5_grade = new JLabel();
        subject_5_grade.setHorizontalAlignment(SwingConstants.CENTER);
        subject_5_grade.setForeground(new Color(85, 107, 47));
        subject_5_grade.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
        subject_5_grade.setBounds(6, 61, 267, 121);
        
        grade = student.getGrade5();
        if (grade > 0) {
            if (grade >= 9) {
            	subject_5_grade.setForeground(Color.GREEN);
            } else if (grade >= 7.5) {
            	subject_5_grade.setForeground(Color.YELLOW);
            } else if (grade >= 6) {
            	subject_5_grade.setForeground(Color.ORANGE);
            } else {
            	subject_5_grade.setForeground(Color.RED);
            }

            grade_5 = Double.toString(grade);
        } else {
        	grade_5 = "Not Assigned";
        }

        subject_5_grade.setText("Grade: " + grade_5);
        
        subject_5_panel.add(subject_5_grade);
        
        name_grade_label = new JLabel(student.getName() + " " + student.getSurname());
        name_grade_label.setForeground(new Color(85, 107, 47));
        name_grade_label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        name_grade_label.setBounds(276, 157, 468, 47);
        grade_panel.add(name_grade_label);
                

        gpa_grade_pane = new JPanel();
        gpa_grade_pane.setLayout(null);
        gpa_grade_pane.setBounds(397, 216, 279, 200);
        grade_panel.add(gpa_grade_pane);
        
        gpa_grade_label = new JLabel("GPA:");
        gpa_grade_label.setHorizontalAlignment(SwingConstants.CENTER);
        gpa_grade_label.setForeground(new Color(85, 107, 47));
        gpa_grade_label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        gpa_grade_label.setBounds(47, 9, 168, 55);
        gpa_grade_pane.add(gpa_grade_label);
        
        
        
        gpa_grade_grade = new JLabel();
        gpa_grade_grade.setHorizontalAlignment(SwingConstants.CENTER);
        gpa_grade_grade.setForeground(new Color(85, 107, 47));
        gpa_grade_grade.setFont(new Font("Lucida Grande", Font.PLAIN, 33));
        gpa_grade_grade.setBounds(6, 60, 267, 121);
        
        grade = student.getGpa();
        if (grade > 0) {
            if (grade >= 9) {
                gpa_grade_grade.setForeground(Color.GREEN);
            } else if (grade >= 7.5) {
                gpa_grade_grade.setForeground(Color.YELLOW);
            } else if (grade >= 5) {
                gpa_grade_grade.setForeground(Color.ORANGE);
            } else {
                gpa_grade_grade.setForeground(Color.RED);
            }

            gpa_grade = Double.toString(grade);
        } else {
            gpa_grade = "Not Assigned";
        }

        gpa_grade_grade.setText(gpa_grade);
        
        
        gpa_grade_pane.add(gpa_grade_grade);
        
        
        go_back_2 = new JButton("Go Back");
        go_back_2.addActionListener(this);
        go_back_2.setForeground(new Color(85, 107, 47));
        go_back_2.setBounds(276, 734, 174, 29);
        grade_panel.add(go_back_2);
        
        JPanel horizontal_Photo = new JPanel();
        horizontal_Photo.setBounds(230, -13, 1241, 204);
        info_panel.add(horizontal_Photo);
        horizontal_Photo.setLayout(null);
        
        ///////
        searched_horizontal_Photo = new JPanel();
        searched_horizontal_Photo.setBounds(230, -13, 1241, 204);
        search_panel.add(searched_horizontal_Photo);
        searched_horizontal_Photo.setLayout(null);
        
        JLabel my_profile_label = new JLabel("MY PROFILE");
        my_profile_label.setBounds(276, 6, 744, 55);
        horizontal_Photo.add(my_profile_label);
        my_profile_label.setForeground(new Color(85, 107, 47));
        my_profile_label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        my_profile_label.setHorizontalAlignment(SwingConstants.CENTER);
        
        ///////////////
        searched__profile_label = new JLabel("MY PROFILE");
        searched__profile_label.setBounds(276, 6, 744, 55);
        searched_horizontal_Photo.add(searched__profile_label);
        searched__profile_label.setForeground(new Color(85, 107, 47));
        searched__profile_label.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
        searched__profile_label.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel profile_photo = new JLabel("");
        profile_photo.setIcon(new ImageIcon("/Users/regiloshi/Downloads/logo_woth_colors_student-2.png"));
        profile_photo.setBounds(371, 189, 150, 143);
        info_panel.add(profile_photo);
        
        /////////////////////
        user_profile_photo = new JLabel("");
        user_profile_photo.setIcon(new ImageIcon("/Users/regiloshi/Downloads/logo_woth_colors_student-2.png"));
        user_profile_photo.setBounds(371, 189, 150, 143);
        search_panel.add(user_profile_photo);
        
        JLabel full_name_label = new JLabel(student.getName() + " " + student.getSurname());
        full_name_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        full_name_label.setBounds(533, 227, 254, 29);
        info_panel.add(full_name_label);
        
        //////////////////////
        searched_full_name_label = new JLabel();
        searched_full_name_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        searched_full_name_label.setBounds(533, 227, 254, 29);
        search_panel.add(searched_full_name_label);
        
        
        JLabel department_label = new JLabel("Department: " + student.getDepartment());
        department_label.setBounds(533, 274, 174, 16);
        info_panel.add(department_label);
        
        ///////////////////
        search_department_label = new JLabel();
        search_department_label.setBounds(533, 274, 174, 16);
        search_panel.add(search_department_label);
        
        JLabel joined_label = new JLabel("Joined: " + student.getDateJoined());
        joined_label.setBounds(533, 316, 140, 16);
        info_panel.add(joined_label);
        
        /////////////////////
        searched_joined_label = new JLabel();
        searched_joined_label.setBounds(533, 316, 140, 16);
        search_panel.add(searched_joined_label);
        
        JPanel bio_panel = new JPanel();
        bio_panel.setBounds(371, 363, 1052, 224);
        info_panel.add(bio_panel);
        bio_panel.setLayout(null);
        
        /////////////////////
        searched_bio_panel = new JPanel();
        searched_bio_panel.setBounds(371, 363, 1052, 224);
        search_panel.add(searched_bio_panel);
        searched_bio_panel.setLayout(null);
        
        
        bio_writing = new JTextArea();
        bio_writing.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        bio_writing.setLineWrap(true); 
        bio_writing.setWrapStyleWord(true);
        bio_writing.setEditable(false);
        bio_writing.append(student.getBio());
        bio_writing.setBounds(6, 40, 1040, 178);
        bio_panel.add(bio_writing);
        bio_writing.setColumns(10);
        bio_writing.setCaretColor(Color.WHITE);
        
        ///////////////
        searched_bio_writing = new JTextArea();
        searched_bio_writing.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        searched_bio_writing.setLineWrap(true); 
        searched_bio_writing.setWrapStyleWord(true);
        searched_bio_writing.setEditable(false);
        searched_bio_writing.setBounds(6, 40, 1040, 178);
        searched_bio_panel.add(searched_bio_writing);
        searched_bio_writing.setColumns(10);
        searched_bio_writing.setCaretColor(Color.WHITE);
        
        
        JLabel bio_label = new JLabel("Bio:");
        bio_label.setForeground(new Color(85, 107, 47));
        bio_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        bio_label.setBounds(6, 12, 138, 27);
        bio_panel.add(bio_label);
        
        /////////////////
        searched_bio_label = new JLabel("Bio:");
        searched_bio_label.setForeground(new Color(85, 107, 47));
        searched_bio_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        searched_bio_label.setBounds(6, 12, 138, 27);
        searched_bio_panel.add(searched_bio_label);
        
       
        role_label = new JLabel("Student");
        role_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        role_label.setBounds(533, 199, 129, 16);
        info_panel.add(role_label);
        
        
        /////////////
        searched_role_label = new JLabel();
        searched_role_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        searched_role_label.setBounds(533, 199, 129, 16);
        search_panel.add(searched_role_label);
        
        edit_profile = new JButton("Edit Profile");
        edit_profile.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String securityCheck = JOptionPane.showInputDialog("Enter Access Code");
            	if(securityCheck.equals("1234")) {
        		JFrame edit_frame = new JFrame();
        		edit_frame.setBounds(350, 200, 500, 500);
        		edit_frame.setVisible(true);
        		edit_frame.setTitle("Edit Profile");

        		JPanel panel = new JPanel();
        		panel.setLayout(new GridLayout(10, 2));


        		JLabel nameLabel = new JLabel("Change Name:");
        		JLabel surnameLabel = new JLabel("Change Surname:");
        		JLabel genderLabel = new JLabel("Change Gender:");
        		JLabel departmentLabel = new JLabel("Change Department:");
        		JLabel emailLabel = new JLabel("Change Email:");
        		JLabel oldpass_label = new JLabel("Old Password:");
        		JLabel newpass_label = new JLabel("New Password:");

        		JTextField nameField = new JTextField(student.getName());
        		JTextField surnameField = new JTextField(student.getSurname());
        		JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Male", "Female", "I prefer not to say"});
        		genderComboBox.setSelectedItem(student.getGender());
        		JComboBox<String> departmentField = new JComboBox<>(new String[] {"SWE1", "SWE2", "SWE3", "CEN1", "CEN2", "CEN3", "ECE1", "ECE2", "ECE3"});
        		departmentField.setSelectedItem(student.getDepartment());
        		JTextField emailField = new JTextField(student.getEmail());
        		oldpass = new JPasswordField();
        		newpass = new JPasswordField();
        		
                
        		panel.add(nameLabel);
        		panel.add(nameField);
        		panel.add(surnameLabel);
        		panel.add(surnameField);
        		panel.add(genderLabel);
        		panel.add(genderComboBox);
        		panel.add(departmentLabel);
        		panel.add(departmentField);
        		panel.add(emailLabel);
        		panel.add(emailField);
        		panel.add(oldpass_label);
        		panel.add(oldpass);
        		panel.add(newpass_label);
        		panel.add(newpass);

        		JButton updateButton = new JButton("Update Profile");
                updateButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	 String selectedGender = (String) genderComboBox.getSelectedItem();
                    	 String selectedDep = (String) departmentField.getSelectedItem();
                    	 
                    	 
                    	 char[] old_pass_arr = oldpass.getPassword();
                         enteredOldPass = String.copyValueOf(old_pass_arr);
                         enteredOldPass = enteredOldPass.trim();
                         
                         
                         char[] charNewPassword = newpass.getPassword();
                         enteredNewPassword = String.copyValueOf(charNewPassword);
                         enteredNewPassword = enteredNewPassword.trim();
                         
                         
                        if (!(nameField.getText().toLowerCase().equals(student.getName().toLowerCase()))) {
                            student.setName(edit_frame , nameField.getText());
                            full_name_label.setText(student.getName() + " " + student.getSurname());
                            
                        }
                        if (!(surnameField.getText().toLowerCase().equals(student.getSurname().toLowerCase()))) {
                            student.setSurname(edit_frame , surnameField.getText());
                            full_name_label.setText(student.getName() + " " + student.getSurname());
                        }
                        if (!selectedDep.toLowerCase().equals(student.getDepartment().toLowerCase())) {
                            student.setDepartment(edit_frame , selectedDep);
                            department_label.setText("Department: " + student.getDepartment());
                        }
                        if (!selectedGender.toLowerCase().equals(student.getGender().toLowerCase())) {
                            student.setGender(edit_frame , selectedGender);
                        }
                        if (!(emailField.getText().toLowerCase().equals(student.getEmail().toLowerCase()))){
                        	if(!(emailField.getText().contains("@"))) {
                        	JOptionPane.showMessageDialog(frame, "Enter a valid new email address!", "Alert", JOptionPane.WARNING_MESSAGE);
                	    }else {
                        	student.setEmail(edit_frame, emailField.getText());
                        }
                        if(!(enteredOldPass.isEmpty()) && enteredNewPassword.isEmpty()) {
                        	JOptionPane.showMessageDialog(frame, "Enter New Password", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        if(enteredOldPass.isEmpty() && !(enteredNewPassword.isEmpty())) {
                        	JOptionPane.showMessageDialog(frame, "Enter Old Password", "Alert", JOptionPane.WARNING_MESSAGE);
                        }
                        }if(!(enteredOldPass.isEmpty()) && !(enteredNewPassword.isEmpty())) {
                        	if(enteredOldPass.equals(student.getPassword())) {
                        		if (enteredNewPassword.length() >= 8) {
                        			student.setPasssord(edit_frame, enteredNewPassword);
                        	    }else {
                        	    	JOptionPane.showMessageDialog(frame, "Password Length must be minimum 8", "Alert", JOptionPane.WARNING_MESSAGE);
                        	    }
                        	}else {
                        		JOptionPane.showMessageDialog(frame, "Wrong Old Password", "Alert", JOptionPane.WARNING_MESSAGE);
                        	}
                        }
                        edit_frame.dispose();
                    }
                    });
                
        		panel.add(updateButton);
        		edit_frame.getContentPane().add(panel);
        	}else{
            	JOptionPane.showMessageDialog(frame, "Wrong Access Code!", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }});
        edit_profile.setForeground(new Color(85, 107, 47));
        edit_profile.setBounds(1249, 311, 174, 29);
        info_panel.add(edit_profile);
        
        /////////////////
        searched_friends_label = new JLabel();
        searched_friends_label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        searched_friends_label.setForeground(new Color(85, 107, 47));
        searched_friends_label.setBounds(933, 308, 135, 16);
        search_panel.add(searched_friends_label);
        
        friends_label = new JLabel("Friends: " + student.get_numberOfFriends());
        friends_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
        friends_label.setForeground(new Color(85, 107, 47));
        friends_label.setBounds(927, 316, 140, 16);
        info_panel.add(friends_label);
        
        add_friend = new JButton("Send Friend Request");
        add_friend.addActionListener(this);
        add_friend.setForeground(new Color(85, 107, 47));
        add_friend.setBounds(1185, 303, 238, 29);
        search_panel.add(add_friend);
        
        go_back_4 = new JButton("Go Back");
        go_back_4.addActionListener(this);
        go_back_4.setForeground(new Color(85, 107, 47));
        go_back_4.setBounds(372, 627, 174, 29);
        search_panel.add(go_back_4);
        
        edit_bio = new JButton("Edit Bio");
        edit_bio.setForeground(new Color(85, 107, 47));
        edit_bio.setBackground(new Color(255, 255, 255));
        edit_bio.setBounds(1249, 612, 174, 29);
        edit_bio.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		JFrame edit_bio_frame = new JFrame();
        		edit_bio_frame.setBounds(350, 200, 500, 500);
        		edit_bio_frame.setVisible(true);
        		edit_bio_frame.setTitle("Edit Bio");

        		JPanel panel = new JPanel();
        		panel.setLayout(new BorderLayout());

        		JLabel edit_bio_label = new JLabel("Change Bio:");
        		JTextArea changed_bio = new JTextArea(student.getBio());
        		JButton submit = new JButton("Submit");
        		submit.addActionListener(new ActionListener() {
                	@Override
                	public void actionPerformed(ActionEvent e) {
                		student.setBio(edit_bio_frame, changed_bio.getText());
                		bio_writing.setText(changed_bio.getText());
                		edit_bio_frame.dispose();
                	}
        		});

        		panel.add(edit_bio_label, BorderLayout.NORTH);
        		panel.add(changed_bio, BorderLayout.CENTER);
        		panel.add(submit, BorderLayout.SOUTH);

        		edit_bio_frame.getContentPane().add(panel);

        		
        		
        	}
        });
        info_panel.add(edit_bio);
        
        go_back_1 = new JButton("Go Back");
        go_back_1.setForeground(new Color(85, 107, 47));
        go_back_1.setBounds(264, 612, 174, 29);
        go_back_1.addActionListener(this);
        info_panel.add(go_back_1);
        frame.getContentPane().add(tabbedPane);
        
        
		log_out_button = new JButton(new ImageIcon("/Users/regiloshi/Downloads/log_out_final_logo-2-modified-2.png"));
		log_out_button.setBounds(43, 665, 154, 98);
		log_out_button.setContentAreaFilled(false);
		log_out_button.setFocusable(false); 
        log_out_button.setBorderPainted(false);
        log_out_button.setFocusPainted(false);
		menu_options.add(log_out_button);
		
		info_button = new JButton("");
		info_button.setIcon(new ImageIcon("/Users/regiloshi/Downloads/output-onlinepngtools-8-2-modified.png"));
		info_button.setBounds(56, 6, 126, 98);
		info_button.addActionListener(this);
		info_button.setContentAreaFilled(false);
		info_button.setFocusable(false); 
		info_button.setBorderPainted(false);
		info_button.setFocusPainted(false);
		menu_options.add(info_button);
		
		gradeButton = new JButton("");
		gradeButton.setIcon(new ImageIcon("/Users/regiloshi/Downloads/output-onlinepngtools-9-2-modified-2.png"));
		gradeButton.setBounds(41, 129, 154, 98);
		gradeButton.addActionListener(this);
		gradeButton.setContentAreaFilled(false);
		gradeButton.setFocusable(false); 
		gradeButton.setBorderPainted(false);
		gradeButton.setFocusPainted(false);
		menu_options.add(gradeButton);
		
		assigment_button = new JButton("");
		assigment_button.setIcon(new ImageIcon("/Users/regiloshi/Downloads/output-onlinepngtools-11.png"));
		assigment_button.setBounds(56, 239, 148, 82);
		assigment_button.addActionListener(this);
		assigment_button.setContentAreaFilled(false);
		assigment_button.setFocusable(false); 
		assigment_button.setBorderPainted(false);
		assigment_button.setFocusPainted(false);
		menu_options.add(assigment_button);
		
		search_button = new JButton("");
		search_button.setIcon(new ImageIcon("/Users/regiloshi/Downloads/search_logo.png"));
		search_button.setContentAreaFilled(false);
		search_button.setFocusable(false); 
		search_button.setBorderPainted(false);
		search_button.setFocusPainted(false);
		search_button.addActionListener(this);
		search_button.setBounds(41, 347, 154, 98);
		menu_options.add(search_button);
		
		friends_button = new JButton("");
		friends_button.setIcon(new ImageIcon("/Users/regiloshi/Downloads/output-onlinepngtools-22.png"));
		friends_button.setContentAreaFilled(false);
		friends_button.setFocusable(false); 
		friends_button.setBorderPainted(false);
		friends_button.setFocusPainted(false);
		friends_button.addActionListener(this);
		friends_button.setBounds(41, 457, 154, 98);
		menu_options.add(friends_button);
		
		messaging_button = new JButton("");
		messaging_button.setBackground(new Color(255, 255, 255));
		messaging_button.setIcon(new ImageIcon("/Users/regiloshi/Downloads/messaging_logo-2.png"));
		messaging_button.setBounds(41, 555, 170, 98);
		messaging_button.setContentAreaFilled(false);
		messaging_button.setFocusable(false); 
		messaging_button.setBorderPainted(false);
		messaging_button.setFocusPainted(false);
		messaging_button.addActionListener(this);
		menu_options.add(messaging_button);
		
		
		log_out_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login_Or_SignUp();
            }
        });
		
		
		dashboard_panel.setLayout(null);
		
		gpa_pane = new JPanel();
		gpa_pane.setBounds(757, 81, 279, 200);
		gpa_pane.setLayout(null);
		dashboard_panel.add(gpa_pane);
		
		gpa_label = new JLabel("GPA");
		gpa_label.setForeground(new Color(85, 107, 47));
		gpa_label.setBounds(55, 6, 146, 23);
		gpa_label.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		gpa_label.setHorizontalAlignment(SwingConstants.CENTER);
		gpa_pane.add(gpa_label);
		
		gpa = new JLabel();
		gpa.setForeground(new Color(85, 107, 47));
		gpa.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		gpa.setHorizontalAlignment(SwingConstants.CENTER);
		gpa.setBounds(6, 41, 267, 71);
		
		grade = student.getGpa();
        if (grade > 0) {
            if (grade >= 9) {
            	gpa.setForeground(Color.GREEN);
            } else if (grade >= 7.5) {
            	gpa.setForeground(Color.YELLOW);
            } else if (grade >= 5) {
            	gpa.setForeground(Color.ORANGE);
            } else {
            	gpa.setForeground(Color.RED);
            }

            gpa_grade = Double.toString(grade);
        } else {
            gpa_grade = "Not Assigned";
        }

        gpa.setText(gpa_grade);
        
        gpa_pane.add(gpa);
		
		grade_button = new JButton("Go To Grades");
		grade_button.setFocusable(false);
		grade_button.setBackground(new Color(255, 255, 255));
		grade_button.setForeground(new Color(85, 107, 47));
		grade_button.setBounds(74, 132, 117, 45);
		grade_button.addActionListener(this);
		gpa_pane.add(grade_button);
		
		info_pane = new JPanel();
		info_pane.setBounds(1181, 81, 258, 240);
		info_pane.setLayout(null);
		dashboard_panel.add(info_pane);
		
		name_label = new JLabel(student.getName() + " " + student.getSurname());
		name_label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		name_label.setHorizontalAlignment(SwingConstants.CENTER);
		name_label.setForeground(new Color(85, 107, 47));
		name_label.setBounds(34, 167, 187, 21);
		info_pane.add(name_label);
		
		image_label = new JLabel("");
		image_label.setIcon(new ImageIcon("/Users/regiloshi/Downloads/logo_woth_colors_student-2.png"));
		image_label.setHorizontalAlignment(SwingConstants.CENTER);
		image_label.setBounds(49, 20, 156, 140);
		info_pane.add(image_label);
		
		departament_label = new JLabel("Department: " + student.getDepartment());
		departament_label.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		departament_label.setForeground(new Color(85, 107, 47));
		departament_label.setHorizontalAlignment(SwingConstants.CENTER);
		departament_label.setBounds(34, 200, 187, 16);
		info_pane.add(departament_label);
		
		welcome_back_label = new JLabel("Welcome Back " + student.getName() + "!");
		welcome_back_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_back_label.setBounds(354, 6, 861, 62);
		welcome_back_label.setForeground(new Color(85, 107, 47));
		welcome_back_label.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
		dashboard_panel.add(welcome_back_label);
		
		panel = new JPanel();
		panel.setBounds(1181, 367, 258, 146);
		panel.setLayout(null);
		dashboard_panel.add(panel);
		
		SimpleDateFormat year_format = new SimpleDateFormat("dd MMMM yyyy");
		String date_today = year_format.format(Calendar.getInstance().getTime());
		date_label = new JLabel(date_today);
		date_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		date_label.setForeground(new Color(85, 107, 47));
		date_label.setHorizontalAlignment(SwingConstants.CENTER);
		date_label.setBounds(8, 6, 246, 38);
		panel.add(date_label);
		
		Date currentDateAndTime = new Date();
		SimpleDateFormat dayOfWeekFormat = new SimpleDateFormat("EEEE");
		String dayOfWeek = dayOfWeekFormat.format(currentDateAndTime);
		JLabel week_label = new JLabel(dayOfWeek);
		week_label.setForeground(new Color(85, 107, 47));
		week_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		week_label.setHorizontalAlignment(SwingConstants.CENTER);
		week_label.setBounds(6, 56, 248, 38);
		panel.add(week_label);
		
		current_time_label = new JLabel("");
		current_time_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		current_time_label.setForeground(new Color(85, 107, 47));
		current_time_label.setHorizontalAlignment(SwingConstants.CENTER);
		current_time_label.setBounds(4, 105, 248, 38);
		panel.add(current_time_label);
		
		Inspiration_pane = new JPanel();
		Inspiration_pane.setBounds(281, 81, 279, 200);
		Inspiration_pane.setLayout(null);
		dashboard_panel.add(Inspiration_pane);
		
		Inspiration_label = new JLabel("Inspiration");
		Inspiration_label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Inspiration_label.setForeground(new Color(85, 107, 47));
		Inspiration_label.setHorizontalAlignment(SwingConstants.CENTER);
		Inspiration_label.setBounds(47, 9, 168, 55);
		Inspiration_pane.add(Inspiration_label);
		random_motivation = new JLabel(motivatingPhrases[randomIndex]);
		random_motivation.setBounds(6, 60, 267, 121);
		Inspiration_pane.add(random_motivation);
		random_motivation.setHorizontalAlignment(SwingConstants.CENTER);
		random_motivation.setForeground(new Color(85, 107, 47));
		random_motivation.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		
		assignment_panel = new JPanel();
		assignment_panel.setBounds(1181, 576, 258, 219);
		assignment_panel.setLayout(null);
		dashboard_panel.add(assignment_panel);
		
		JLabel assignment_label = new JLabel("Upcoming Assignment");
		assignment_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		assignment_label.setHorizontalAlignment(SwingConstants.CENTER);
		assignment_label.setForeground(new Color(85, 107, 47));
		assignment_label.setBounds(30, 6, 207, 31);
		assignment_panel.add(assignment_label);
		
		JLabel assignment_name = new JLabel("Department: " + student.getDepartment());
		assignment_name.setForeground(new Color(85, 107, 47));
		assignment_name.setHorizontalAlignment(SwingConstants.CENTER);
		assignment_name.setBounds(12, 38, 246, 31);
		assignment_panel.add(assignment_name);
		
		homework_desc = new JTextArea();
		homework_desc.setEditable(false);
		homework_desc.setBounds(16, 94, 225, 119);
		homework_desc.setLineWrap(true); 
		homework_desc.setWrapStyleWord(true);
		homework_desc.setBackground(new Color(238 , 238 , 238));
		homework_desc.setForeground(new Color(85, 107, 47));
		homework_desc.append(student.getAssignmentDesc());
		homework_desc.setCaretColor(new Color(238 , 238 , 238));
		homework_desc.setColumns(10);
		assignment_panel.add(homework_desc);
		
		
		if(student.getDeliveryDatetime() == null) {
			 dateString = "";
		}else {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateString = dateFormat.format(student.getDeliveryDatetime());
		}
		JLabel due_date_label = new JLabel(dateString);
		due_date_label.setForeground(new Color(85, 107, 47));
		due_date_label.setHorizontalAlignment(SwingConstants.CENTER);
		due_date_label.setBounds(6, 76, 252, 16);
		assignment_panel.add(due_date_label);

		DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {
		    {"9:00 - 10:00", "", "", "", "", "", "", "", "", "", ""},
		    {"10:00 - 11:00", "", "", "", "", "", "", "", "", "", ""},
		    {"11:00 - 12:00", "", "", "", "", "", "", "", "", "", ""},
		    {"12:00 - 13:00", "", "", "", "", "", "", "", "", "", ""},
		    {"13:00 - 14:00", "", "", "", "", "", "", "", "", "", ""},
		    {"14:00 - 15:00", "", "", "", "", "", "", "", "", "", ""},
		    {"15:00 - 16:00", "", "", "", "", "", "", "", "", "", ""},
		    {"16:00 - 17:00", "", "", "", "", "", "", "", "", "", ""},
		    {"17:00 - 18:00", "", "", "", "", "", "", "", "", "", ""},
		}, new String[] {"Time", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});

		timetable = new JTable(tableModel);
		timetable.setBackground(new Color(192, 192, 192));
		timetable.setBounds(284, 300, 800, 500);
		timetable.setGridColor(Color.BLACK);
		timetable.setRowHeight(50);
		timetable.setDefaultEditor(Object.class, null);
		timetable.setSelectionBackground(new Color(238 , 238 , 238));
		timetable.setSelectionForeground(Color.black);
		timetable.setFocusable(false);
		JTableHeader header = timetable.getTableHeader();
		header.setBackground(new Color(192, 192, 192));
		header.setForeground(Color.black);
		header.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		JScrollPane scrollPane = new JScrollPane(timetable);
		scrollPane.setBounds(277, 326, 762, 469);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setFocusable(false);
		dashboard_panel.add(scrollPane);
		
		notification_button = new JButton("");
		notification_button.addActionListener(this);
		notification_button.setContentAreaFilled(false);
		notification_button.setFocusable(false); 
		notification_button.setBorderPainted(false);
		notification_button.setFocusPainted(false);
		notification_button.setIcon(new ImageIcon("/Users/regiloshi/Downloads/output-onlinepngtools-14.png"));
		notification_button.setBounds(1242, 16, 117, 53);
		dashboard_panel.add(notification_button);
		Noti_table = new JTable(NotiTableModel);
		Noti_table.setBackground(new Color(192, 192, 192));
		Noti_table.setBounds(1150, 68, 100, 400);
		Noti_table.setGridColor(Color.BLACK);
		Noti_table.setRowHeight(50);
		Noti_table.setDefaultEditor(Object.class, null);
		Noti_table.setSelectionBackground(new Color(238 , 238 , 238));
		Noti_table.setSelectionForeground(Color.black);
		Noti_table.setFocusable(false);
		NotiscrollPane = new JScrollPane(Noti_table);
		NotiscrollPane.setBounds(1150, 62, 300, 400);
		notification_window.add(NotiscrollPane);
		NotiscrollPane.setPreferredSize(new Dimension(300 , 400));
		JTableHeader noti_header = Noti_table.getTableHeader();
		noti_header.setBackground(new Color(192, 192, 192));
		noti_header.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		noti_header.setForeground(Color.black);

		getFriends();

	}
	private void updateTime() {
        Thread timeUpdater = new Thread(() -> {
            try {
                while (true) {
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    String time = timeFormat.format(Calendar.getInstance().getTime());

                    javax.swing.SwingUtilities.invokeLater(() -> {
                    	current_time_label.setText(time);
                    });

                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        timeUpdater.start();
    }
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == info_button) {
        	tabbedPane.setSelectedComponent(info_panel);
        }else if(e.getSource() == gradeButton || e.getSource() == grade_button){
        	tabbedPane.setSelectedComponent(grade_panel);
        }else if(e.getSource() == go_back_1 || e.getSource() == go_back_2 || e.getSource() == go_back || e.getSource() == go_back_3 || e.getSource() == go_back_5 || e.getSource() == go_back_6) {
        	tabbedPane.setSelectedComponent(dashboard_panel);
        }else if(e.getSource() == go_back_4) {
        	tabbedPane.setSelectedComponent(search_user_panel);
        }else if(e.getSource() == friends_button) {
        	tabbedPane.setSelectedComponent(friends_panel);
        }
        else if(e.getSource() == assigment_button) {
        	tabbedPane.setSelectedComponent(assignment);
        }else if(e.getSource()==messaging_button) {
        	tabbedPane.setSelectedComponent(messaging_panel);
        }
        else if(e.getSource() == search_button) {
        		tabbedPane.setSelectedComponent(search_user_panel);
        	}else if(e.getSource()==search_user_button)  {
        		try{
        			if(search_input_field.getText().length() == 0) {
        				JOptionPane.showMessageDialog(frame, "Field is empty!", "Alert", JOptionPane.WARNING_MESSAGE);
        			}else {
        			userTableModel.setRowCount(0);
        			HashMap<Integer, List<String>> users = new HashMap<>();
            		Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            	    String searched_name = search_input_field.getText().trim();
            	    String[] name_and_surname = searched_name.split("\\s+");
            	    int wordCount = name_and_surname.length;
                    if(wordCount == 2) {
                    	String searched_user_name = name_and_surname[0];
                        String searched_surnamee = name_and_surname[1];
                    	query = "SELECT * FROM students WHERE name LIKE CONCAT('%', ?, '%') AND surname LIKE CONCAT('%', ?, '%')";
                    	PreparedStatement preparedStatement = connection.prepareStatement(query);
                    	preparedStatement.setString(1, searched_user_name);
                    	preparedStatement.setString(2, searched_surnamee);
                    	ResultSet result = preparedStatement.executeQuery();
                    	Integer i;
                    	i = 1;
                    	if (!result.next()) {
                    		 searched_user_name = name_and_surname[0];
                             searched_surnamee = name_and_surname[1];
                        	query = "SELECT * FROM teachers WHERE name LIKE CONCAT('%', ?, '%') AND surname LIKE CONCAT('%', ?, '%')";
                        	 preparedStatement = connection.prepareStatement(query);
                        	preparedStatement.setString(1, searched_user_name);
                        	preparedStatement.setString(2, searched_surnamee);
                        	 result = preparedStatement.executeQuery();
                        	 i = 1;
                        	 if(!result.next()) {
                        		 JOptionPane.showMessageDialog(frame, "No Accounts Found!", "Alert", JOptionPane.WARNING_MESSAGE);
                        	 }else {
                        		 do {
                                     List<String> user_info = new ArrayList<>();

                                     String name = result.getString("name");
                                     String surname = result.getString("surname");
                                     int age = result.getInt("age");
                                     java.sql.Date date_of_birth = result.getDate("birthdate");
                                     String department = result.getString("departament");
                                     String gender = result.getString("gender");
                                     String agee = String.valueOf(age);
                                     String datee = String.valueOf(date_of_birth);
                                     
                                     user_info.add(name);
                                     user_info.add(surname);
                                     user_info.add(agee);
                                     user_info.add(gender);
                                     user_info.add(department);
                                     user_info.add(datee);
                                     
                                     users.put(i, user_info);
                                     i++;
                                 } while (result.next());
                        	 }
                        } else {
                            do {
                                List<String> user_info = new ArrayList<>();

                                String name = result.getString("name");
                                String surname = result.getString("surname");
                                int age = result.getInt("age");
                                java.sql.Date date_of_birth = result.getDate("birthdate");
                                String department = result.getString("departament");
                                String gender = result.getString("gender");
                                String agee = String.valueOf(age);
                                String datee = String.valueOf(date_of_birth);
                                
                                user_info.add(name);
                                user_info.add(surname);
                                user_info.add(agee);
                                user_info.add(gender);
                                user_info.add(department);
                                user_info.add(datee);
                                
                                users.put(i, user_info);
                                i++;
                            } while (result.next());
                        }
                    	for(int element : users.keySet()) {
                    		List<String> info = users.get(element);
                    		String name = String.valueOf(info.get(0));
                    		String surname = String.valueOf(info.get(1));
                    		String age = String.valueOf(info.get(2));
                    		String gender = String.valueOf(info.get(3));
                    		String department_user = String.valueOf(info.get(4));
                    		String dob = String.valueOf(info.get(5));
                    		userTableModel.addRow(new Object[] {name , surname , age , gender , department_user , dob});
                    	}
                    }else if(wordCount == 1) {
                    	query = "SELECT * FROM students WHERE name LIKE CONCAT('%', ?, '%') OR surname LIKE CONCAT('%', ?, '%')";
                    	PreparedStatement preparedStatement = connection.prepareStatement(query);
                    	preparedStatement.setString(1, searched_name);
                    	preparedStatement.setString(2, searched_name);
                    	ResultSet result = preparedStatement.executeQuery();
                    	Integer i;
                    	i = 1;
                    	if (!result.next()) {
                    		query = "SELECT * FROM teachers WHERE name LIKE CONCAT('%', ?, '%') OR surname LIKE CONCAT('%', ?, '%')";
                        	preparedStatement = connection.prepareStatement(query);
                        	preparedStatement.setString(1, searched_name);
                        	preparedStatement.setString(2, searched_name);
                        	result = preparedStatement.executeQuery();
                       	 i = 1;
                       	 if(!result.next()) {
                       		 JOptionPane.showMessageDialog(frame, "No Accounts Found!", "Alert", JOptionPane.WARNING_MESSAGE);
                       	 }else {
                       		 do {
                                    List<String> user_info = new ArrayList<>();

                                    String name = result.getString("name");
                                    String surname = result.getString("surname");
                                    int age = result.getInt("age");
                                    java.sql.Date date_of_birth = result.getDate("birthdate");
                                    String department = result.getString("departament");
                                    String gender = result.getString("gender");
                                    String agee = String.valueOf(age);
                                    String datee = String.valueOf(date_of_birth);
                                    
                                    user_info.add(name);
                                    user_info.add(surname);
                                    user_info.add(agee);
                                    user_info.add(gender);
                                    user_info.add(department);
                                    user_info.add(datee);
                                    
                                    users.put(i, user_info);
                                    i++;
                                } while (result.next());
                       	 }
                        } else {
                            do {
                                List<String> user_info = new ArrayList<>();

                                String name = result.getString("name");
                                String surname = result.getString("surname");
                                int age = result.getInt("age");
                                java.sql.Date date_of_birth = result.getDate("birthdate");
                                String department = result.getString("departament");
                                String gender = result.getString("gender");
                                String agee = String.valueOf(age);
                                String datee = String.valueOf(date_of_birth);
                                
                                user_info.add(name);
                                user_info.add(surname);
                                user_info.add(agee);
                                user_info.add(gender);
                                user_info.add(department);
                                user_info.add(datee);
                                
                                users.put(i, user_info);
                                i++;
                            } while (result.next());
                        }
                    	for(int element : users.keySet()) {
                    		List<String> info = users.get(element);
                    		String name = String.valueOf(info.get(0));
                    		String surname = String.valueOf(info.get(1));
                    		String age = String.valueOf(info.get(2));
                    		String gender = String.valueOf(info.get(3));
                    		String department_user = String.valueOf(info.get(4));
                    		String dob = String.valueOf(info.get(5));
                    		userTableModel.addRow(new Object[] {name , surname , age , gender , department_user , dob});
                    	}
                    }else {
                    	JOptionPane.showMessageDialog(frame, "Maximum 2 values", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
            	}}catch(SQLException l) {
            		l.printStackTrace();
            		
            	} 
        	}else if(e.getSource() == reset_search_user_button) {
        		search_input_field.setText("");
        		userTableModel.setRowCount(0);
        	}else if(e.getSource() == search_users_button) {
        		if(user_info_table.getSelectedRow() == -1) {
        			JOptionPane.showMessageDialog(frame, "No user selected", "Alert", JOptionPane.WARNING_MESSAGE);
        		}else {
        		int selected_row = user_info_table.getSelectedRow();
        		name_of_searched_user = String.valueOf(user_info_table.getValueAt(selected_row, 0));
        		surName_of_searched_user = String.valueOf(user_info_table.getValueAt(selected_row, 1));
        		age_of_selected_user = String.valueOf(user_info_table.getValueAt(selected_row, 2));
        		gender_of_selected_user = String.valueOf(user_info_table.getValueAt(selected_row, 3));
        		department_of_selected_user = String.valueOf(user_info_table.getValueAt(selected_row, 4));
        		date_of_birth_searched = String.valueOf(user_info_table.getValueAt(selected_row, 5));
        		try{
            	Connection connection = DriverManager.getConnection(db_url, db_username , db_password);
            	query = "SELECT student_id FROM students where name = ? AND surname = ? AND  age = ? AND  birthdate = ? and  departament = ? AND  gender = ?";
            	PreparedStatement preparedStatement = connection.prepareStatement(query);
            	preparedStatement.setString(1, name_of_searched_user);
            	preparedStatement.setString(2, surName_of_searched_user);
            	preparedStatement.setString(3, age_of_selected_user);
            	preparedStatement.setString(4, date_of_birth_searched);
            	preparedStatement.setString(5, department_of_selected_user);
            	preparedStatement.setString(6, gender_of_selected_user);
            	ResultSet result = preparedStatement.executeQuery();
            	if(result.next()) {
                	studentId = result.getInt("student_id");
                	query = "SELECT * from login where id = ?";
                	preparedStatement = connection.prepareStatement(query);
                	preparedStatement.setInt(1, studentId);
                	result = preparedStatement.executeQuery();
                	if(studentId == student.getId()) {
                		tabbedPane.setSelectedComponent(info_panel);
                	}else {
                	while(result.next())
                	{
                		email = result.getString("email");
                		password = result.getString("pass");
                		sr_role = result.getString("role");
                		bio = result.getString("bio");
                		date_joined = result.getString("date_joined");
                	}
                	}
            	}
            	else{
                	connection = DriverManager.getConnection(db_url, db_username , db_password);
                	query = "SELECT teacher_id FROM teachers where name = ? AND surname = ? AND  age = ? AND  birthdate = ? and  departament = ? AND  gender = ?";
                	preparedStatement = connection.prepareStatement(query);
                	preparedStatement.setString(1, name_of_searched_user);
                	preparedStatement.setString(2, surName_of_searched_user);
                	preparedStatement.setString(3, age_of_selected_user);
                	preparedStatement.setString(4, date_of_birth_searched);
                	preparedStatement.setString(5, department_of_selected_user);
                	preparedStatement.setString(6, gender_of_selected_user);
                	result = preparedStatement.executeQuery();
                	if(result.next()) {
                    studentId = result.getInt("teacher_id");
                    query = "SELECT * from login where id = ?";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, studentId);
                    result = preparedStatement.executeQuery();
                    while(result.next())
                    {
                    	email = result.getString("email");
                    	password = result.getString("pass");
                    	sr_role = result.getString("role");
                    	bio = result.getString("bio");
                    	date_joined = result.getString("date_joined");
                    }
                    }
            	}
            	if(sr_role.equals("student")) {
            		if(studentId == student.getId()) {
            			tabbedPane.setSelectedComponent(info_panel);
            		}else {
            		searched_user_s = new Student(name_of_searched_user , surName_of_searched_user , age_of_selected_user ,  date_of_birth_searched , department_of_selected_user , studentId ,  gender_of_selected_user , email , password , bio , date_joined );
                	searched_full_name_label.setText(searched_user_s.getName() + " " + searched_user_s.getSurname());
                	search_department_label.setText("Department" + searched_user_s.getDepartment());
                	searched_joined_label.setText("Date Joined: " + searched_user_s.getDateJoined());
                	searched_bio_writing.setText(searched_user_s.getBio());
                	searched__profile_label.setText(searched_user_s.getName() + " " + searched_user_s.getSurname() + "'s Profile");
                	searched_role_label.setText(sr_role.substring(0, 1).toUpperCase() + sr_role.substring(1));
                	searched_friends_label.setText("Friends: " + searched_user_s.get_numberOfFriends());
            	try (Connection connectiont = DriverManager.getConnection(db_url, db_username, db_password)) {
            		String friend_query = "SELECT * FROM friends WHERE (user_1 = ? AND user_2 = ?) OR (user_1 = ? AND user_2 = ?)";
    	        	PreparedStatement preparedStatementtt = connectiont.prepareStatement(friend_query);
    	        	preparedStatementtt.setInt(1, studentId);
    	        	preparedStatementtt.setInt(2, student.getId());
    	        	preparedStatementtt.setInt(3, studentId);
    	        	preparedStatementtt.setInt(4, student.getId());
    	        	ResultSet resulttt = preparedStatementtt.executeQuery();
            		if(resulttt.next()) {
            			add_friend.setText("Friends");
    	        	    add_friend.setEnabled(false);
            		}else {
            			String friendRequestQuery = "SELECT * FROM friend_request WHERE (receiver_id = ? AND sender_id = ?) OR (receiver_id = ? AND sender_id = ?)";
            			PreparedStatement friendRequestStatement = connection.prepareStatement(friendRequestQuery);
            			friendRequestStatement.setInt(1, student.getId());
            			friendRequestStatement.setInt(2, studentId);
            			friendRequestStatement.setInt(3, studentId);
            			friendRequestStatement.setInt(4, student.getId());
            			ResultSet friendRequestResult = friendRequestStatement.executeQuery();
    	        	if (friendRequestResult.next()) {
    	        	    add_friend.setText("Pending Friend Request");
    	        	    add_friend.setEnabled(false);
    	        	}else {
    	        		add_friend.setText("Send Friend Request");
    	        	    add_friend.setEnabled(true);
    	        	} }
				}catch(SQLException l) {
					l.printStackTrace();
				}
            	tabbedPane.setSelectedComponent(search_panel);
            		}
            	}else if(sr_role.equals("teacher")) {
            		if(studentId == student.getId()) {
            			tabbedPane.setSelectedComponent(info_panel);
            		}else {
            		searched_user_t = new Teacher(name_of_searched_user , surName_of_searched_user , age_of_selected_user ,  date_of_birth_searched , department_of_selected_user , studentId ,  gender_of_selected_user , email , password , bio , date_joined );
                	searched_full_name_label.setText(searched_user_t.getName() + " " + searched_user_t.getSurname());
                	search_department_label.setText("Department" + searched_user_t.getDepartment());
                	searched_joined_label.setText("Date Joined: " + searched_user_t.getDateJoined());
                	searched_bio_writing.setText(searched_user_t.getBio());
                	searched__profile_label.setText(searched_user_t.getName() + " " + searched_user_t.getSurname() + "'s Profile");
                	searched_role_label.setText(sr_role.substring(0, 1).toUpperCase() + sr_role.substring(1));
                	searched_friends_label.setText("Friends: " + searched_user_t.get_numberOfFriends());
                	try (Connection connectiont = DriverManager.getConnection(db_url, db_username, db_password)) {
                		String friend_query = "SELECT * FROM friends WHERE (user_1 = ? AND user_2 = ?) OR (user_1 = ? AND user_2 = ?)";
        	        	PreparedStatement preparedStatementtt = connectiont.prepareStatement(friend_query);
        	        	preparedStatementtt.setInt(1, studentId);
        	        	preparedStatementtt.setInt(2, student.getId());
        	        	preparedStatementtt.setInt(3, studentId);
        	        	preparedStatementtt.setInt(4, student.getId());
        	        	ResultSet resulttt = preparedStatementtt.executeQuery();
                		if(resulttt.next()) {
                			add_friend.setText("Friends");
        	        	    add_friend.setEnabled(false);
                		}else {
                			String friendRequestQuery = "SELECT * FROM friend_request WHERE (receiver_id = ? AND sender_id = ?) OR (receiver_id = ? AND sender_id = ?)";
                			PreparedStatement friendRequestStatement = connection.prepareStatement(friendRequestQuery);
                			friendRequestStatement.setInt(1, student.getId());
                			friendRequestStatement.setInt(2, studentId);
                			friendRequestStatement.setInt(3, studentId);
                			friendRequestStatement.setInt(4, student.getId());
                			ResultSet friendRequestResult = friendRequestStatement.executeQuery();
        	        	if (friendRequestResult.next()) {
        	        	    add_friend.setText("Pending Friend Request");
        	        	    add_friend.setEnabled(false);
        	        	}else {
        	        		add_friend.setText("Send Friend Request");
        	        	    add_friend.setEnabled(true);
        	        	} }
    				}catch(SQLException l) {
    					l.printStackTrace();
    				}
                	tabbedPane.setSelectedComponent(search_panel);
            	} }
            	}catch(SQLException l) {
        		l.printStackTrace();
        	}
	}
        	}else if(e.getSource() == add_friend) {
        		try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {    
                     String insertQuery = "INSERT INTO friend_request (sender_id, receiver_id , role) VALUES (?, ? , 'student')";
                     PreparedStatement insertStatement = connection.prepareStatement(insertQuery , Statement.RETURN_GENERATED_KEYS);
                    insertStatement.setInt(1, student.getId());
                    if(searched_user_s == null) {
                    insertStatement.setInt(2, searched_user_t.getId());
                    }else {
                    	insertStatement.setInt(2, searched_user_s.getId());
                    }
                      int rowsAffected = insertStatement.executeUpdate();

                      if (rowsAffected > 0) {
                      	JOptionPane.showMessageDialog(frame, "Friend Request Successfully Sent.", "Successful", JOptionPane.DEFAULT_OPTION);
                      	add_friend.setText("Friend Request Already Sent");
      	        	    add_friend.setEnabled(false);
                   }else {
                    	JOptionPane.showMessageDialog(frame, "Friend Request Failed To Send!", "Alert", JOptionPane.WARNING_MESSAGE);
                   }
	}catch(SQLException l) {
		l.printStackTrace();
	}
        	}else if(e.getSource() == notification_button) {
        		if(checker == 0) {
        			NotiscrollPane.setVisible(true);
        			Noti_table.setVisible(true);
        			notification_window.setVisible(true);
        			checker = 1;
        		}
        		else if(checker == 1) {
        			notification_window.setVisible(false);
        			NotiscrollPane.setVisible(false);
        			Noti_table.setVisible(false);
        			checker = 0;
        		}
        	}else if (e.getSource() == reject_friend) {
        	    if (friend_request_table.getSelectedRow() == -1) {
        	        JOptionPane.showMessageDialog(frame, "No Friend Request Selected", "Alert", JOptionPane.WARNING_MESSAGE);
        	    } else {
        	        int selected_row = friend_request_table.getSelectedRow();
        	        String name_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 0));
        	        String surName_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 1));
        	        String age_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 2));
        	        String gender_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 4));
        	        String department_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 3));
        	        String role1 = String.valueOf(friend_request_table.getValueAt(selected_row, 5));
        	        
        	        try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
        	            if (role1.equals("student")) {
        	                String selectQuery = "SELECT student_id FROM students WHERE name = ? AND surname = ? AND age = ? AND departament = ? AND gender = ?";
        	                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
        	                selectStatement.setString(1, name_of_fr);
        	                selectStatement.setString(2, surName_of_fr);
        	                selectStatement.setString(3, age_of_fr);
        	                selectStatement.setString(4, department_of_fr);
        	                selectStatement.setString(5, gender_fr);
        	                
        	                ResultSet result = selectStatement.executeQuery();
        	               
        	                if (result.next()) {
        	                    student_id = result.getInt("student_id");
        	                }
        	                
        	                String deleteQuery = "DELETE FROM friend_request WHERE sender_id = ? AND receiver_id = ?";
        	                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
        	                deleteStatement.setInt(1, student_id);
        	                deleteStatement.setInt(2, student.getId());
        	                
        	                int rowsAffected = deleteStatement.executeUpdate();
        	                
        	                if (rowsAffected > 0) {
        	                    JOptionPane.showMessageDialog(frame, "Friend Request Removed.", "Successful", JOptionPane.DEFAULT_OPTION);
        	                    friend_request_table_model.removeRow(selected_row);
        	                } else {
        	                    JOptionPane.showMessageDialog(frame, "Friend Request Failed To Remove!", "Alert", JOptionPane.WARNING_MESSAGE);
        	                }
        	            }
        	            else if(role1.equals("teacher")) {
        	                String selectQuery = "SELECT teacher_id FROM students WHERE name = ? AND surname = ? AND age = ? AND departament = ? AND gender = ?";
        	                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
        	                selectStatement.setString(1, name_of_fr);
        	                selectStatement.setString(2, surName_of_fr);
        	                selectStatement.setString(3, age_of_fr);
        	                selectStatement.setString(4, department_of_fr);
        	                selectStatement.setString(5, gender_fr);
        	                
        	                ResultSet result = selectStatement.executeQuery();
        	               
        	                if (result.next()) {
        	                    student_id = result.getInt("teacher_id");
        	                }
        	                
        	                String deleteQuery = "DELETE FROM friend_request WHERE sender_id = ? AND receiver_id = ?";
        	                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
        	                deleteStatement.setInt(1, student_id);
        	                deleteStatement.setInt(2, student.getId());
        	                
        	                int rowsAffected = deleteStatement.executeUpdate();
        	                
        	                if (rowsAffected > 0) {
        	                    JOptionPane.showMessageDialog(frame, "Friend Request Removed.", "Successful", JOptionPane.DEFAULT_OPTION);
        	                    friend_request_table_model.removeRow(selected_row);
        	                } else {
        	                    JOptionPane.showMessageDialog(frame, "Friend Request Failed To Remove!", "Alert", JOptionPane.WARNING_MESSAGE);
        	                }
        	            }
        	        } catch (SQLException l) {
        	            l.printStackTrace();
        	        }
        	    } }else if (e.getSource() == accept_friend) {
            	    if (friend_request_table.getSelectedRow() == -1) {
            	        JOptionPane.showMessageDialog(frame, "No Friend Request Selected", "Alert", JOptionPane.WARNING_MESSAGE);
            	    } else {
            	        int selected_row = friend_request_table.getSelectedRow();
            	        String name_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 0));
            	        String surName_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 1));
            	        String age_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 2));
            	        String gender_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 4));
            	        String department_of_fr = String.valueOf(friend_request_table.getValueAt(selected_row, 3));
            	        String role1 = String.valueOf(friend_request_table.getValueAt(selected_row, 5));
            	        
            	        try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
            	            if (role1.equals("student")) {
            	                String selectQuery = "SELECT student_id FROM students WHERE name = ? AND surname = ? AND age = ? AND departament = ? AND gender = ?";
            	                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            	                selectStatement.setString(1, name_of_fr);
            	                selectStatement.setString(2, surName_of_fr);
            	                selectStatement.setString(3, age_of_fr);
            	                selectStatement.setString(4, department_of_fr);
            	                selectStatement.setString(5, gender_fr);
            	                
            	                ResultSet result = selectStatement.executeQuery();
            	               
            	                if (result.next()) {
            	                    student_id = result.getInt("student_id");
            	                }
            	                
            	                String deleteQuery = "INSERT INTO friends (user_1 , user_2) VALUE (? , ?)";
            	                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            	                deleteStatement.setInt(1, student_id);
            	                deleteStatement.setInt(2, student.getId());
            	                
            	                int rowsAffected = deleteStatement.executeUpdate();
            	                
            	                if (rowsAffected > 0) {
            	                    JOptionPane.showMessageDialog(frame, "Friend Request Accepted.", "Successful", JOptionPane.DEFAULT_OPTION);
            	                    friend_request_table_model.removeRow(selected_row);
            	                    friend_table_model.addRow(new Object[] {name_of_fr , surName_of_fr , age_of_fr , department_of_fr ,gender_fr , role1 });
            	                    messaging_table_model.addRow(new Object[] {name_of_fr + " "  + surName_of_fr});
            	                    friends_number_label.setText("Friends: " + student.get_numberOfFriends());
            	                    friends_label.setText("Friends: " + student.get_numberOfFriends());
            	                    String deleteQueryy = "DELETE FROM friend_request WHERE sender_id = ? AND receiver_id = ?";
                	                PreparedStatement deleteStatementt = connection.prepareStatement(deleteQueryy);
                	                deleteStatementt.setInt(1, student_id);
                	                deleteStatementt.setInt(2, student.getId());
                	                deleteStatementt.executeUpdate();
            	                } else {
            	                    JOptionPane.showMessageDialog(frame, "Friend Request Failed To Accept!", "Alert", JOptionPane.WARNING_MESSAGE);
            	                }
            	            }
            	            else if(role1.equals("teacher")) {
            	                String selectQuery = "SELECT teacher_id FROM teachers WHERE name = ? AND surname = ? AND age = ? AND departament = ? AND gender = ?";
            	                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            	                selectStatement.setString(1, name_of_fr);
            	                selectStatement.setString(2, surName_of_fr);
            	                selectStatement.setString(3, age_of_fr);
            	                selectStatement.setString(4, department_of_fr);
            	                selectStatement.setString(5, gender_fr);
            	                
            	                ResultSet result = selectStatement.executeQuery();
            	               
            	                if (result.next()) {
            	                    student_id = result.getInt("teacher_id");
            	                }
            	                
            	                String deleteQuery = "INSERT INTO friends (user_1 , user_2) VALUE (? , ?)";
            	                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
            	                deleteStatement.setInt(1, student_id);
            	                deleteStatement.setInt(2, student.getId());
            	                
            	                int rowsAffected = deleteStatement.executeUpdate();
            	                
            	                if (rowsAffected > 0) {
            	                    JOptionPane.showMessageDialog(frame, "Friend Request Accepted.", "Successful", JOptionPane.DEFAULT_OPTION);
            	                    friend_request_table_model.removeRow(selected_row);
            	                    friend_table_model.addRow(new Object[] {name_of_fr , surName_of_fr , age_of_fr , department_of_fr ,gender_fr , role1 });
            	                    messaging_table_model.addRow(new Object[] {name_of_fr + " "  + surName_of_fr});
            	                    friends_number_label.setText("Friends: " + student.get_numberOfFriends());
            	                    String deleteQueryy = "DELETE FROM friend_request WHERE sender_id = ? AND receiver_id = ?";
                	                PreparedStatement deleteStatementt = connection.prepareStatement(deleteQueryy);
                	                deleteStatementt.setInt(1, student_id);
                	                deleteStatementt.setInt(2, student.getId());
                	                deleteStatementt.executeUpdate();
            	                } else {
            	                    JOptionPane.showMessageDialog(frame, "Friend Request Failed To Accept!", "Alert", JOptionPane.WARNING_MESSAGE);
            	                }
            	            }
            	        } catch (SQLException l) {
            	            l.printStackTrace();
            	        }
            	    } }else if(e.getSource() == remove_friend) {
            	    	 if (friend_table.getSelectedRow() == -1) {
                 	        JOptionPane.showMessageDialog(frame, "No Friend", "Alert", JOptionPane.WARNING_MESSAGE);
                 	    } else {
                 	        int selected_row = friend_table.getSelectedRow();
                 	        String name_of_fr = String.valueOf(friend_table.getValueAt(selected_row, 0));
                 	        String surName_of_fr = String.valueOf(friend_table.getValueAt(selected_row, 1));
                 	        String age_of_fr = String.valueOf(friend_table.getValueAt(selected_row, 2));
                 	        String gender_fr = String.valueOf(friend_table.getValueAt(selected_row, 4));
                 	        String department_of_fr = String.valueOf(friend_table.getValueAt(selected_row, 3));
                 	        String role1 = String.valueOf(friend_table.getValueAt(selected_row, 5));
                 	        
                 	        try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
                 	            if (role1.equals("student")) {
                 	                String selectQuery = "SELECT student_id FROM students WHERE name = ? AND surname = ? AND age = ? AND departament = ? AND gender = ?";
                 	                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                 	                selectStatement.setString(1, name_of_fr);
                 	                selectStatement.setString(2, surName_of_fr);
                 	                selectStatement.setString(3, age_of_fr);
                 	                selectStatement.setString(4, department_of_fr);
                 	                selectStatement.setString(5, gender_fr);
                 	                
                 	                ResultSet result = selectStatement.executeQuery();
                 	               
                 	                if (result.next()) {
                 	                    student_id = result.getInt("student_id");
                 	                }
                 	                
                 	                String deleteQuery = "DELETE FROM friends WHERE user_1 = ? OR user_2 = ? AND user_1 = ? OR user_2 = ?";
                 	                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 	                deleteStatement.setInt(1, student_id);
                 	                deleteStatement.setInt(2, student.getId());
                 	               deleteStatement.setInt(3, student.getId());
                	                deleteStatement.setInt(4, student_id);
                 	                
                 	                int rowsAffected = deleteStatement.executeUpdate();
                 	                
                 	                if (rowsAffected > 0) {
                 	                    JOptionPane.showMessageDialog(frame, "Friend Removed.", "Successful", JOptionPane.DEFAULT_OPTION);
                 	                    friend_table_model.removeRow(selected_row);
                 	                    friends_number_label.setText("Friends: " + student.get_numberOfFriends());
                 	                    friends_label.setText("Friends: " + student.get_numberOfFriends());
                 	                } else {
                 	                    JOptionPane.showMessageDialog(frame, "Friend Failed To Remove!", "Alert", JOptionPane.WARNING_MESSAGE);
                 	                }
                 	            }
                 	            else if(role1.equals("teacher")) {
                 	                String selectQuery = "SELECT teacher_id FROM teachers WHERE name = ? AND surname = ? AND age = ? AND departament = ? AND gender = ?";
                 	                PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                 	                selectStatement.setString(1, name_of_fr);
                 	                selectStatement.setString(2, surName_of_fr);
                 	                selectStatement.setString(3, age_of_fr);
                 	                selectStatement.setString(4, department_of_fr);
                 	                selectStatement.setString(5, gender_fr);
                 	                
                 	                ResultSet result = selectStatement.executeQuery();
                 	               
                 	                if (result.next()) {
                 	                    student_id = result.getInt("teacher_id");
                 	                }
                 	                
                 	               String deleteQuery = "DELETE FROM friends WHERE (user_1 = ? AND user_2 = ?) OR (user_1 = ? AND user_2 = ?)";
                	                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                	                deleteStatement.setInt(1, student_id);
                	                deleteStatement.setInt(2, student.getId());
	                	            deleteStatement.setInt(3, student.getId());
	               	                deleteStatement.setInt(4, student_id);
                 	                
                 	                int rowsAffected = deleteStatement.executeUpdate();
                 	                
                 	                if (rowsAffected > 0) {
                	                    JOptionPane.showMessageDialog(frame, "Friend Removed.", "Successful", JOptionPane.DEFAULT_OPTION);
                	                    friend_table_model.removeRow(selected_row);
                	                    
                	                    friends_number_label.setText("Friends: " + student.get_numberOfFriends());
                	                } else {
                	                    JOptionPane.showMessageDialog(frame, "Friend Failed To Remove!", "Alert", JOptionPane.WARNING_MESSAGE);
                	                }
                 	            }
                 	        } catch (SQLException l) {
                 	            l.printStackTrace();
                 	        }
            	    }
            	    }else if(e.getSource() == send_message_button_) {
            	    	try(Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
            	    		String message = message_input.getText();
            	    		message_input.setText("");
            	    		String sendmessagequery = "INSERT INTO messages (sender_id, receiver_id , message ) VALUES (? , ? , ?)";
         	                PreparedStatement sendmessagestatement = connection.prepareStatement(sendmessagequery);
         	                sendmessagestatement.setInt(1, student.getId());
         	                sendmessagestatement.setInt(2, friends_id.get(selected_friend));
         	               sendmessagestatement.setString(3, message);
         	                int rowsAffected = sendmessagestatement.executeUpdate();
         	          
         	                if (rowsAffected > 0) {
         	                	message_area.setText("");
         	                	getMessages(friends_id.get(selected_friend),message_friend_name);
         	                } else {
         	                    JOptionPane.showMessageDialog(frame, "Message Failed To Send!", "Alert", JOptionPane.WARNING_MESSAGE);
         	                
            	    	}
            	    }catch (SQLException l) {
         	            l.printStackTrace();
         	        } }else if(e.getSource() == choose_file_button) {
         	        	JFileChooser assingment_chooser = new JFileChooser();
         	        	int response = assingment_chooser.showOpenDialog(null);
         	        	if(response == JFileChooser.APPROVE_OPTION) {
         	        		try(Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
         	        			String filePath = assingment_chooser.getSelectedFile().getAbsolutePath();
         	        			FileInputStream inputStream = new FileInputStream(new File(filePath));
         	        			String assingment_query = "INSERT INTO delivered_assignment (student_id, teacher_id, assignment_file , assignment_id) VALUES (? , ? , ? , ?)";
         	        			PreparedStatement statement = connection.prepareStatement(assingment_query);
         	        			statement.setInt(1, student.getId());
         	        			statement.setInt(2, student.getTeacherId());
         	        			statement.setBinaryStream(3, inputStream);
         	        			statement.setInt(4, student.getAssignmentId());
         	   
         	        			int row = statement.executeUpdate();
         	        			if (row < 0) {
                 	                    JOptionPane.showMessageDialog(frame, "Failed To Upload File!", "Alert", JOptionPane.WARNING_MESSAGE);
         	        			}else {
         	        				student.getAssignment();
         	        				assigment_area.setText(student.getAssignmentDesc());
         	        		        to_be_delivered.setText("To Be Delivered By: " + student.getDeliveryDatetime());
         	        		        teacher_name_assigment.setText("Teacher: " + student.getTeacherName());
         	        		        assigment_tittle_label.setText("Assignment Title: " + student.getAssignmentTitle());
         	        		        subject_assigment_1.setText("Subject: Not Found");
         	        		       if(student.getAssignment() > 0) {
         	        					choose_file_button.setEnabled(true);
         	        				}else {
         	        					choose_file_button.setEnabled(false);
         	        				}
         	        				JOptionPane.showMessageDialog(frame, "Successfully Uploaded File!");
         	        			}
         	        			connection.close();
         	        		
         	        	}catch (SQLException l) {
             	            l.printStackTrace();
             	        } catch (FileNotFoundException l2) {
							l2.printStackTrace();
						}
         	        }
        	}
	}
       
	public void getSubjectNames() {
		try{
    		Connection connection = DriverManager.getConnection(db_url, db_username , db_password);
    	Statement statement = connection.createStatement();
    	String query = "SELECT * FROM " + student.getDepartment().substring(0, student.getDepartment().length() - 1);
    	ResultSet result = statement.executeQuery (query);
    	while(result.next())
    	{
    		subject_1 = result.getString("year_" + student.getYear() + "_subject_1");
    		subject_2 = result.getString("year_" + student.getYear() + "_subject_2");
    		subject_3 = result.getString("year_" + student.getYear() + "_subject_3");
    		subject_4 = result.getString("year_" + student.getYear() + "_subject_4");
    		subject_5 = result.getString("year_" + student.getYear() + "_subject_5");
    	}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	public void checkForFriendRequest() {
	    try {
	    	int cnt = 0;
	        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
	        query = "SELECT * from friend_request where receiver_id = ? AND status = 'Not Accepted'";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, student.getId());
	        ResultSet result = preparedStatement.executeQuery();
	        while (result.next()) {
	            List<String> user_noti = new ArrayList<>();
	            seen = result.getString("seen");
	            String role = result.getString("role");
	            int sender_id = result.getInt("sender_id");
	            request_Id = result.getInt("requestId");
	            if (role.equals("student")) {
	                String new_query = "SELECT * from students where student_id = ?";
	                PreparedStatement preparedStatementt = connection.prepareStatement(new_query);
	                preparedStatementt.setInt(1, sender_id);
	                ResultSet resultt = preparedStatementt.executeQuery();
	                while (resultt.next()) {
	                    name_sender = resultt.getString("name");
	                    surname_sender = resultt.getString("surname");
	                    age_sender = resultt.getInt("age");
	                    department_sender = resultt.getString("departament");
	                    gender_sender = resultt.getString("gender");
	                }
	                String agee = String.valueOf(age_sender);
	                user_noti.add(name_sender);
	                user_noti.add(surname_sender);
	                user_noti.add(agee);
	                user_noti.add(department_sender);
	                user_noti.add(gender_sender);
	                user_noti.add(role);
	            } else if (role.equals("teacher")) {
	                query = "SELECT * from teachers where teacher_id = ?";
	                preparedStatement = connection.prepareStatement(query);
	                preparedStatement.setInt(1, sender_id);
	                ResultSet resultt = preparedStatement.executeQuery();
	                while (resultt.next()) {
	                    name_sender = resultt.getString("name");
	                    surname_sender = resultt.getString("surname");
	                    age_sender = resultt.getInt("age");
	                    department_sender = resultt.getString("departament");
	                    gender_sender = resultt.getString("gender");
	                }
	                String agee = String.valueOf(age_sender);
	                user_noti.add(name_sender);
	                user_noti.add(surname_sender);
	                user_noti.add(agee);
	                user_noti.add(department_sender);
	                user_noti.add(gender_sender);
	                user_noti.add(role);
	            }
	            notis.put(request_Id, user_noti);
	        }

	        for (int requestKey : notis.keySet()) {
	            List<String> info = notis.get(requestKey);
	            String name = String.valueOf(info.get(0));
	            String surname = String.valueOf(info.get(1));
	            String age = String.valueOf(info.get(2));
	            String department = String.valueOf(info.get(3));
	            String gender = String.valueOf(info.get(4));
	            String rolee = String.valueOf(info.get(5));
	            if (seen.equals("No")) {
	               cnt = -1;
	                NotiTableModel.addRow(new Object[]{"New Friend Request By : " + name + " " + surname});
	            }
	            friend_request_table_model.addRow(new Object[]{name, surname, age, department, gender, rolee});
	            if(cnt != 0 ) {
	            	 JOptionPane.showMessageDialog(frame, "You Have A New Friend Request", "Alert", JOptionPane.INFORMATION_MESSAGE);
	            }
	        }

	        query = "UPDATE friend_request SET seen = 'yes' WHERE requestId = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(query);
	        updateStatement.setInt(1, request_Id);
	        updateStatement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	public void checkForNewMessages() {
	    try {
	        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
	        String query = "SELECT * FROM messages WHERE receiver_id = ? AND status = 'Not Seen'";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, student.getId());
	        ResultSet result = preparedStatement.executeQuery();
	        int cnt = 0;
	        while (result.next()) {
	        	cnt = 1;
	            int sender_id = result.getInt("sender_id");
	            
	            
	            String roleQuery = "SELECT role FROM login WHERE id = ?";
	            PreparedStatement roleStatement = connection.prepareStatement(roleQuery);
	            roleStatement.setInt(1, sender_id);
	            ResultSet roleResult = roleStatement.executeQuery();
	            
	            if (roleResult.next()) {
	                String role = roleResult.getString("role");

	                String senderName = "";
	                String senderSurname = "";

	                if (role.equals("student")) {
	                    String studentQuery = "SELECT name, surname FROM students WHERE student_id = ?";
	                    PreparedStatement studentStatement = connection.prepareStatement(studentQuery);
	                    studentStatement.setInt(1, sender_id);
	                    ResultSet studentResult = studentStatement.executeQuery();
	                    
	                    if (studentResult.next()) {
	                        senderName = studentResult.getString("name");
	                        senderSurname = studentResult.getString("surname");
	                    }
	                } else if (role.equals("teacher")) {
	                    String teacherQuery = "SELECT name, surname FROM teachers WHERE teacher_id = ?";
	                    PreparedStatement teacherStatement = connection.prepareStatement(teacherQuery);
	                    teacherStatement.setInt(1, sender_id);
	                    ResultSet teacherResult = teacherStatement.executeQuery();
	                    
	                    if (teacherResult.next()) {
	                        senderName = teacherResult.getString("name");
	                        senderSurname = teacherResult.getString("surname");
	                    }
	                }
	                getMessages(sender_id , senderName + " " +  senderSurname);
	                NotiTableModel.addRow(new Object[]{"New Message From " + senderName + " " + senderSurname});
	            }
	        }
	        if(cnt!= 0) {
	        	JOptionPane.showMessageDialog(frame, "You Have A New Message", "Alert", JOptionPane.INFORMATION_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	private void getFriends() {
	    try {
	        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
	        String query = "SELECT * FROM friends WHERE user_1 = ? OR user_2 = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setInt(1, student.getId());
	        preparedStatement.setInt(2, student.getId());
	        ResultSet result = preparedStatement.executeQuery();
	        int i = 1;
	        int j = 0;

	        while (result.next()) {
	            int user_1 = result.getInt("user_1");
	            int user_2 = result.getInt("user_2");

	            int friendUserId = (user_1 != student.getId()) ? user_1 : user_2;

	            List<String> friends_list = new ArrayList<>();
	            String role = null; 
	            String queryUserInfo = "SELECT * FROM login WHERE id = ?";
	            PreparedStatement preparedStatementUserInfo = connection.prepareStatement(queryUserInfo);
	            preparedStatementUserInfo.setInt(1, friendUserId);
	            ResultSet resultUserInfo = preparedStatementUserInfo.executeQuery();

	            if (resultUserInfo.next()) {
	                role = resultUserInfo.getString("role");
	                if ("student".equals(role)) {
	                    String queryStudentInfo = "SELECT * FROM students WHERE student_id = ?";
	                    PreparedStatement preparedStatementStudentInfo = connection.prepareStatement(queryStudentInfo);
	                    preparedStatementStudentInfo.setInt(1, friendUserId);
	                    ResultSet resultStudentInfo = preparedStatementStudentInfo.executeQuery();

	                    if (resultStudentInfo.next()) {
	                        String friend_name = resultStudentInfo.getString("name");
	                        String friend_surname = resultStudentInfo.getString("surname");
	                        int friends_age = resultStudentInfo.getInt("age");
	                        String friend_department = resultStudentInfo.getString("departament");
	                        String friend_gender = resultStudentInfo.getString("gender");
	                        friend_id = resultStudentInfo.getInt("student_id");
	                        String friend_age = String.valueOf(friends_age);
	                        
	                        friends_list.add(friend_name);
	                        friends_list.add(friend_surname);
	                        friends_list.add(friend_age);
	                        friends_list.add(friend_department);
	                        friends_list.add(friend_gender);
	                        friends_list.add(role);
	                    }
	                }else if("teacher".equals(role)) {
	                	String queryStudentInfo = "SELECT * FROM teachers WHERE teacher_id = ?";
	                    PreparedStatement preparedStatementStudentInfo = connection.prepareStatement(queryStudentInfo);
	                    preparedStatementStudentInfo.setInt(1, friendUserId);
	                    ResultSet resultStudentInfo = preparedStatementStudentInfo.executeQuery();

	                    if (resultStudentInfo.next()) {
	                        String friend_name = resultStudentInfo.getString("name");
	                        String friend_surname = resultStudentInfo.getString("surname");
	                        int friends_age = resultStudentInfo.getInt("age");
	                        String friend_department = resultStudentInfo.getString("departament");
	                        String friend_gender = resultStudentInfo.getString("gender");
	                        friend_id = resultStudentInfo.getInt("teacher_id");
	                        String friend_age = String.valueOf(friends_age);

	                        friends_list.add(friend_name);
	                        friends_list.add(friend_surname);
	                        friends_list.add(friend_age);
	                        friends_list.add(friend_department);
	                        friends_list.add(friend_gender);
	                        friends_list.add(role);
	                }
	                }
	                friends.put(i, friends_list);
	                friends_id.put(j, friend_id);
	                i++;
	                j++;
	                friend_table_model.addRow(new Object[]{
	                    friends_list.get(0),
	                    friends_list.get(1),
	                    friends_list.get(2),
	                    friends_list.get(3),
	                    friends_list.get(4),
	                    role
	                });
	                messaging_table_model.addRow(new Object[] {friends_list.get(0) + " "  + friends_list.get(1)});
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void getMessages(int friend_id, String name) {
	    try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
	    	String seen_query = "SELECT * FROM MESSAGES WHERE sender_id = ? AND receiver_id = ? AND status = 'Not Seen'";
	    	PreparedStatement checkStatementt = connection.prepareStatement(seen_query);
	    	checkStatementt.setInt(1, friend_id);
	        checkStatementt.setInt(2, student.getId());
	        ResultSet resultSet = checkStatementt.executeQuery();
	        if(resultSet.next()) {
	        	seen_query = "UPDATE MESSAGES SET status = 'Seen' WHERE sender_id = ? AND receiver_id = ? AND status = 'Not Seen'";
		    	checkStatementt = connection.prepareStatement(seen_query);
		    	checkStatementt.setInt(1, friend_id);
		        checkStatementt.setInt(2, student.getId());
		        checkStatementt.executeUpdate();
	        }
	        
	     
	        String checkQuery = "SELECT * FROM messages where sender_id = ? AND receiver_id = ? OR sender_id = ? AND receiver_id = ? ORDER BY time_sent DESC";
	        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
	        checkStatement.setInt(1, student.getId());
	        checkStatement.setInt(2, friend_id);
	        checkStatement.setInt(3, friend_id);
	        checkStatement.setInt(4, student.getId());

	        ResultSet result = checkStatement.executeQuery();

	        StringBuilder messageText = new StringBuilder();
	        while (result.next()) {
	            String message = result.getString("message");
	            int sender_id = result.getInt("sender_id");
	            Timestamp timestamp = result.getTimestamp("time_sent");
	            String status = result.getString("status");
	            String alignmentClass = (sender_id == student.getId()) ? "right" : "left";
	            String time = timestamp.toString();
	            time = time.substring(0, time.length()-2);
	            String messageContent;
	            if (sender_id == student.getId()) {
	                messageContent = message;
	            } else {
	            	messageContent = "<b>" + name + ":</b> " + message;
	            }
	            
	            String timestampStyle = "font-size: smaller; color: gray;";
	            
	            
	            String messageHTML = "<div class='" + alignmentClass + "'>" +
	                    messageContent +
	                    "<br><span style='" + timestampStyle + "'>" +
	                    "<b>" + status + "</b>\t" + time + "</span></div>\n";
	            
	            messageText.insert(0, messageHTML);
	        }
	        if (messageText.length() > 0) {
	            message_area.setContentType("text/html");
	            message_area.setText("<html><head><style>" +
	                ".left { text-align: left; }" +
	                ".right { text-align: right; }" +
	                "</style></head><body>" +
	                messageText.toString() +
	                "</body></html>");
	        } else {
	            SimpleAttributeSet centerAlignment = new SimpleAttributeSet();
	            StyleConstants.setAlignment(centerAlignment, StyleConstants.ALIGN_CENTER);
	            message_area.setParagraphAttributes(centerAlignment, false);
	            message_area.setText("No Messages Found!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	
	}
