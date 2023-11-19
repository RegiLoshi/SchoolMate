import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Student {
	private String name;
	private String surname;
	private String department;
	private double gpa;
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
	private char year;
    private String db_url = "jdbc:mysql://localhost:3306/student_java_app";
    private String db_username = "root";
    private String db_password = "11112003";
    private String assignmentTitle = "";
    private String assignmentDesc = "";
    private Date deliveryDatetime;
    private int teacher_id;
    private double grade_1;
    private double grade_2;
    private double grade_3;
    private double grade_4;
    private double grade_5;    
    private String teacher_name = "";
    private String teacher_Surname = "";
    private int number;
    private int assignment_id;
    private String assignment_subject;
	public Student(String first_name, String last_name , int agee , Date dob , String school_department,int std_id , String gen , String emaill , String passwordd , String bioo , String date_joinedd){
		this.name = first_name;
		this.surname = last_name;
		this.department = school_department;
		this.date_of_birth = dob;
		this.age = agee;
		this.id = std_id;
		this.gender = gen;
		this.email = emaill;
		this.password = passwordd;
		this.bio = bioo;
		this.date_joined = date_joinedd;
		year = department.charAt(department.length() - 1);
	};
	public Student(String first_name, String last_name , String agee , String dob , String school_department,int std_id , String gen , String emaill , String passwordd , String bioo , String date_joinedd){
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
		year = department.charAt(department.length() - 1);
	};
	public String getName() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
	public char getYear() {
		return year;
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
    public double getGrade1() {
    		return grade_1;
    		
    }
    public double getGrade2() {
		return grade_2;
		
}
    public double getGrade3() {
		return grade_3;
		
}
    public double getGrade4() {
		return grade_4;
		
}
    public double getGrade5() {
		return grade_5;
}
    public double getGpa() {
    	gpa = (grade_1 + grade_2 + grade_3 + grade_4 + grade_5)/5;
    	return gpa;
    }
    public String getAssignmentTitle() {
    	return assignmentTitle;
    }
    public String getAssignmentDesc() {
    	return assignmentDesc;
    }
    public Date getDeliveryDatetime() {
    	return deliveryDatetime;
    }
    public String getTeacherName() {
    	return teacher_name + " " + teacher_Surname;
    }
    public String getAssignmentSubject() {
    	return assignment_subject;
    }
    public int getAssignmentId() {
    	return assignment_id;
    }
    public int getTeacherId(){
    	return teacher_id;
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
            String updateQuery = "UPDATE students SET name = ? WHERE student_id = ?";
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
            String updateQuery = "UPDATE students SET surname = ? WHERE student_id = ?";
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
             String updateQuery = "UPDATE students SET departament = ? WHERE student_id = ?";
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
             String updateQuery = "UPDATE students SET gender = ? WHERE student_id = ?";
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
            String checkQuery = "SELECT id FROM login WHERE email = ? AND role = 'student'";
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
            preparedStatement.setInt(2, this.id); // Assuming studentId is a field in your Student class
            
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
    public void getGrades() {
		try{
    		Connection connection = DriverManager.getConnection(db_url, db_username , db_password);
    	Statement statement = connection.createStatement();
    	String query = "SELECT * FROM " + department + " where student_id = " + id;
    	ResultSet result = statement.executeQuery (query);
    	while(result.next())
    	{
    		grade_1 = result.getDouble(2);
    		grade_2 = result.getDouble(3);
    		grade_3 = result.getDouble(4);
    		grade_4 = result.getDouble(5);
    		grade_5 = result.getDouble(6);
    	}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
    public int getAssignment() {
        int flag = 0;
        try {
            Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
            String query = "SELECT * FROM assignment WHERE department = ? AND assignment_id NOT IN " +
                           "(SELECT assignment_id FROM delivered_assignment WHERE student_id = ?) " +
                           "ORDER BY delivery_datetime ASC LIMIT 1";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.getDepartment());
            preparedStatement.setInt(2, this.getId());
            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                assignmentTitle = result.getString("assignment_title");
                assignmentDesc = result.getString("assignment_dec");
                deliveryDatetime = result.getDate("delivery_datetime");
                teacher_id = result.getInt("teacher_id");
                assignment_id = result.getInt("assignment_id");
                assignment_subject = result.getString("subject");

                String teacher_query = "SELECT name, surname FROM teachers WHERE teacher_id = ?";
                preparedStatement = connection.prepareStatement(teacher_query);
                preparedStatement.setInt(1, teacher_id);
                result = preparedStatement.executeQuery();
                
                if (result.next()) {
                    teacher_name = result.getString("name");
                    teacher_Surname = result.getString("surname");
                }
                
                flag = 1;
            } else {
                assignmentTitle = "No Upcoming Assignment";
                assignmentDesc = "No Assignment"; 
                deliveryDatetime = null; 
                teacher_name = "Not";
                teacher_Surname = "Found";
                flag = 0;
            }
            
            result.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public void getNumberOfFriends() {
    	try {
 	        Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
 	        String query = "SELECT COUNT(*) As number FROM friends WHERE user_1 = ? OR user_2 = ?";
 	        int studentId = this.getId();
 	        PreparedStatement preparedStatement = connection.prepareStatement(query);
 	        preparedStatement.setInt(1, studentId);
 	        preparedStatement.setInt(2, studentId);
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
    
    }
