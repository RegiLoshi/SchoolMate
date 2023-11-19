import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Teacher {
	private String name;
	private String surname;
	private String department;
	private int age;
	private Date date_of_birth;
	private String d__o__b;
	private String age_string;
	private int id;
	private String gender; 
	private String email;
	private String password;
	private String bio;
	private String date_joined;
    private String db_url = "jdbc:mysql://localhost:3306/student_java_app";
    private String db_username = "root";
    private String db_password = "11112003";
    private int number;
    
    public Teacher(String first_name, String last_name , int agee , Date dob , String school_department,int tch_id , String gen , String emaill , String passwordd , String bioo , String date_joinedd){
		this.name = first_name;
		this.surname = last_name;
		this.department = school_department;
		this.date_of_birth = dob;
		this.age = agee;
		this.id = tch_id;
		this.gender = gen;
		this.email = emaill;
		this.password = passwordd;
		this.bio = bioo;
		this.date_joined = date_joinedd;
	};
	public Teacher(String first_name, String last_name , String agee , String dob , String school_department,int std_id , String gen , String emaill , String passwordd , String bioo , String date_joinedd){
		this.name = first_name;
		this.surname = last_name;
		this.department = school_department;
		this.d__o__b = dob;
		this.age_string = agee;
		this.id = std_id;
		this.gender = gen;
		this.email = emaill;
		this.password = passwordd;
		this.bio = bioo;
		this.date_joined = date_joinedd;
	};
	public String getName() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public String getSurname() {
        return surname.substring(0, 1).toUpperCase() + surname.substring(1);
    }

    public String getDepartment() {
        return department;
    }
    public int getAge() {
        return age;
    }

    public Date getDateOfBirth() {
        return date_of_birth;
    }
    public int getId() {
        return id;
    }

    public String getGender() {
        return gender.substring(0, 1).toUpperCase() + gender.substring(1);
    }
    public String getEmail() {
    	return email;
    }
    public String getPassword() {
    	return password;
    }
    public String getBio() {
    	return bio;
    }
    public String getDateJoined() {
    	return date_joined;
    }
    public String getSearchedDob() {
    	return d__o__b;
    }
    public String getSearchedAge() {
    	return age_string;
    }
    public int get_numberOfFriends() {
    	this.getNumberOfFriends();
    	return number;
    }
    public void setName(JFrame frame , String newName) {

        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            String updateQuery = "UPDATE teachers SET name = ? WHERE teacher_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, this.id); 
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
            this.name = newName;
            JOptionPane.showMessageDialog(frame, "Name Changed!");
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(frame, "Name Change Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
    public void setSurname(JFrame frame , String newSurname) {

        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            String updateQuery = "UPDATE teachers SET surname = ? WHERE teacher_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            
            preparedStatement.setString(1, newSurname);
            preparedStatement.setInt(2, this.id);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
            this.surname = newSurname;
            JOptionPane.showMessageDialog(frame, "Surname Changed!");
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(frame, "Surname Change Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
    public void setDepartment(JFrame frame , String newDepartment) {
    	 try {
             Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
             String updateQuery = "UPDATE teachers SET departament = ? WHERE teacher_id = ?";
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
             
             preparedStatement.setString(1, newDepartment);
             preparedStatement.setInt(2, this.id);
             
             preparedStatement.executeUpdate();
             
             preparedStatement.close();
             connection.close();
             this.department = newDepartment;
             JOptionPane.showMessageDialog(frame, "Department Changed!");
         } catch (SQLException e) {
         	JOptionPane.showMessageDialog(frame, "Department Change Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
             e.printStackTrace();
         }
    }
    public void setGender(JFrame frame , String newGender) {
    	 try {
             Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
             String updateQuery = "UPDATE teachers SET gender = ? WHERE teacher_id = ?";
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
             
             preparedStatement.setString(1, newGender);
             preparedStatement.setInt(2, this.id);
             
             preparedStatement.executeUpdate();
             
             preparedStatement.close();
             connection.close();
             this.department = newGender;
             JOptionPane.showMessageDialog(frame, "Gender Changed!");
         } catch (SQLException e) {
         	JOptionPane.showMessageDialog(frame, "Gender Change Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
             e.printStackTrace();
         }
    }
    public void setEmail(JFrame frame , String newEmail) {
    	try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
            String checkQuery = "SELECT id FROM login WHERE email = ? AND role = 'teacher'";
            PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
            checkStatement.setString(1, newEmail);

            ResultSet result = checkStatement.executeQuery();

            if (result.next()) {
                JOptionPane.showMessageDialog(frame, "Email Already Exists!", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
            String updateQuery = "UPDATE login SET email = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            
            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, this.id); 
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
            this.department = newEmail;
            JOptionPane.showMessageDialog(frame, "Email Changed!");
            }
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(frame, "Email Change Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
    public void setPasssord(JFrame frame , String newPassword) {
    	try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
            String updateQuery = "UPDATE login SET pass = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, this.id);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
            this.password = newPassword;
            JOptionPane.showMessageDialog(frame, "Password Changed!");
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(frame, "Password Change Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
    public void setBio(JFrame frame , String newBio) {
    	try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
            String updateQuery = "UPDATE login SET bio = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            
            preparedStatement.setString(1, newBio);
            preparedStatement.setInt(2, this.id);
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            connection.close();
            this.bio = newBio;
            JOptionPane.showMessageDialog(frame, "Bio Changed!");
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(frame, "Bio Change Failed!", "Alert", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }
    public void getNumberOfFriends() {
    	try {
 	        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
 	        String query = "SELECT COUNT(*) As number FROM friends WHERE user_1 = ? OR user_2 = ?";
 	        int teacher_id = this.getId();
 	        PreparedStatement preparedStatement = connection.prepareStatement(query);
 	        preparedStatement.setInt(1, teacher_id);
 	        preparedStatement.setInt(2, teacher_id);
 	        ResultSet result = preparedStatement.executeQuery();
 	       if(result.next()) {
 	        number = result.getInt("number");
 	        }
 	       else {
 	    	   number = 0;
 	       }
 	    } catch (SQLException e) {
 	        e.printStackTrace();
 	    }
    }
    public String[] getSubject() {
        if (this.getDepartment().equals("SWE1")) {
            return new String[] {"Choose Subject" , "Intro To programming", "Calculus For Engineers" , "Digital Logic Design" , "Intro To Computer Science" , "Engineering Mathematics"};
        } else if (this.getDepartment().equals("SWE2")) {
        	return new String[] {"Choose Subject" , "Data Structures And Algorithms", "Object Oriented Programming", "Discrete Mathematics", "Computer Organization And Architecture", "Software Engineering Principles"};
        } else if (this.getDepartment().equals("SWE3")) {
            return new String[] {"Choose Subject" , "Database Management Systems", "Web Development", "Operating Systems", "Software Testing And Quality Assurance", "Algorithms And Complexity"};
        } else if (this.getDepartment().equals("CEN1")) {
            return new String[] {"Choose Subject" , "Intro To Computer Science", "Calculus For Engineers", "Digital Logic Design", "Programming Fundamentals", "Engineering Mathematics"};
        } else if (this.getDepartment().equals("CEN2")) {
            return new String[] {"Choose Subject" , "Data Structures And Algorithms", "Object Oriented Programming", "Computer Organization And Architecture", "Database Management Systems", "Software Engineering Principles"};
        } else if (this.getDepartment().equals("CEN3")) {
            return new String[] {"Choose Subject" , "Microprocessor Systems", "Networking And Data Communications", "Embedded Systems", "Artificial Intelligence", "Cybersecurity"};
        } else if (this.getDepartment().equals("ECE1")) {
            return new String[] {"Choose Subject" , "Intro To Electrical Engineering", "Calculus For Engineers", "Digital Logic Design", "Programming Fundamentals", "Engineering Mathematics"};
        } else if (this.getDepartment().equals("ECE2")) {
            return new String[] {"Choose Subject" , "Signals And Systems", "Electronic Circuits", "Electromagnetic Fields And Waves", "Microcontroller Programming", "Intro To Control Systems"};
        } else if (this.getDepartment().equals("ECE3")) {
            return new String[] {"Choose Subject" , "Digital Signal Processing", "Power Systems", "Communication Systems", "Vlsi Design", "Robotics And Automation"};
        }else {
            return new String[] {"Unknown Department"};
        }
    }

}
