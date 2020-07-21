package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.Employee;
import bean.Student;
import bean.StudentId;
import bean.StudentName;



public class UserDAO {
	 public static Employee findByUserIDAndPassword(String userId, String password) throws SQLException {
		 Employee employee = null;

	        
	        Connection connection = DBManager.getConnection();

	        
	        PreparedStatement preparedStatement = connection
	                .prepareStatement("SELECT * FROM m_employee WHERE employee_code = ? AND password = ?");
	        preparedStatement.setString(1, userId);
	        preparedStatement.setString(2, password);

	        // SQLの実行
	        ResultSet rs = preparedStatement.executeQuery();

	        // JavaBeansに保存
	        if (rs.next()) {
	        	employee = new Employee();
	        	employee.setEmpId(rs.getString("employee_code"));
	        	employee.setEmpName(rs.getString("employee_name"));
	        	employee.setPassword(rs.getString("password"));
	        }

	        
	        DBManager.close(preparedStatement, connection);

	        return employee;
	        
	    }
	 
	
	 public static void insert(Student student,StudentId studentId) {
		
		 Connection con = null;
		 PreparedStatement ps = null;
		 
		 try {
			 con = DBManager.getConnection();
			 ps = con.prepareStatement("INSERT INTO t_student (student_name,student_name_phonetic,birthday,zipcode,"
			 		+ "address,gender,phone_number1,phone_number2,request_course,starting_date,note,glasses,reception_date,reception_employee,"
			 		+ "student_id,delete_flg,insert_date,insert_time,insert_id,update_date,update_time,update_id,update_count)"
			 		+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0,?,?,?,?,?,?,1)");
			 
			 
			 ps.setString(1,student.getStudentName());
			 ps.setString(2,student.getStudentNamePhonetic());
			 ps.setString(3,student.getBirthDay());
			 ps.setString(4,student.getZipCode());
			 ps.setString(5,student.getAddress());
			 ps.setString(6,student.getGender());
			 ps.setString(7,student.getPhoneNumber1());
			 ps.setString(8,student.getPhoneNumber2());
			 ps.setString(9,student.getRequestCourse());
			 ps.setString(10,student.getStartingDate());
			 ps.setString(11,student.getNote());
			 ps.setInt(12,student.getGlass());
			 ps.setString(13,student.getReceptionDate());
			 ps.setString(14,student.getReceptionEmployee());
			 ps.setString(15,studentId.getStudentId());
			 Date date1 = new Date();
			 SimpleDateFormat sdformat1 = new SimpleDateFormat("yyyyMMdd");
				String fdate1 = sdformat1.format(date1);
			 ps.setString(16,fdate1);
			 SimpleDateFormat sdformat2 = new SimpleDateFormat("HHmmss");
				String fdate2 = sdformat2.format(date1);
			 ps.setString(17,fdate2);
			 ps.setString(18,student.getReceptionEmployee());
			 ps.setString(19,fdate1);
			 ps.setString(20,fdate2);
			 ps.setString(21,student.getReceptionEmployee());
			 
			 ps.executeUpdate();
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 DBManager.close(ps,con);
		 }
	 }
	 public static Student  findByStudent(String studentId){
		 Connection con = null;
		 PreparedStatement ps = null;
		 Student student = null;
		 
		 
		 try {
			 con = DBManager.getConnection();
			 ps = con.prepareStatement("SELECT * FROM t_student where student_id = ? AND delete_flg = 0");
			 ps.setString(1, studentId);
			 ResultSet rs =ps.executeQuery();
			 while(rs.next()){
				 student = new Student();
				 student.setStudentName(rs.getString("student_name"));
				 student.setStudentNamePhonetic(rs.getString("student_name_phonetic"));
				 student.setBirthDay(rs.getString("birthday"));
				 String birthday = student.getBirthDay();
				 String birthdayyear = birthday.substring(0,4);
				 String birthdaymouth = birthday.substring(4,6);
				 String birthdaydays = birthday.substring(6,8);
				 student.setBirthDayYears(birthdayyear);
				 student.setBirthDayMouth(birthdaymouth);
				 student.setBirthDayDays(birthdaydays);
				 student.setAddress(rs.getString("address"));
				 student.setGender(rs.getString("gender"));
				 student.setPhoneNumber1(rs.getString("phone_number1"));
				 student.setPhoneNumber2(rs.getString("phone_number2"));
				 student.setRequestCourse(rs.getString("request_course"));
				 student.setGlass(rs.getInt("glasses"));
				 student.setStartingDate(rs.getString("starting_date"));
				 student.setReceptionDate(rs.getString("reception_date"));
				 student.setNote(rs.getString("note"));
				 student.setStudentId(rs.getString("student_id"));
			 }
			 
		 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 DBManager.close(ps,con);
	 }
		 return student;
	 }
	 public static void update(Student student,StudentId studentId) {
		 Connection con = null;
		 PreparedStatement ps = null;
		 
		 try {
			 con = DBManager.getConnection();
			 ps = con.prepareStatement("UPDATE t_student SET student_name = ?,student_name_phonetic = ?,birthday = ?,"
			 		+ "zipcode = ?,address = ?,gender = ?,phone_number1 = ?,phone_number2 = ?,request_course = ?,"
			 		+ "starting_date = ?,note = ?,glasses = ?,reception_date = ?,reception_employee = ?,"
			 		+ "update_date = ?,update_time = ?,update_id = ?,update_count = update_count +1 WHERE student_id = ?");
			 
			 ps.setString(1,student.getStudentName());
			 ps.setString(2,student.getStudentNamePhonetic());
			 ps.setString(3,student.getBirthDay());
			 ps.setString(4,student.getZipCode());
			 ps.setString(5,student.getAddress());
			 ps.setString(6,student.getGender());
			 ps.setString(7,student.getPhoneNumber1());
			 ps.setString(8,student.getPhoneNumber2());
			 ps.setString(9,student.getRequestCourse());
			 ps.setString(10,student.getStartingDate());
			 ps.setString(11,student.getNote());
			 ps.setInt(12,student.getGlass());
			 ps.setString(13,student.getReceptionDate());
			 ps.setString(14,student.getReceptionEmployee());
			 Date date1 = new Date();
			 SimpleDateFormat sdformat1 = new SimpleDateFormat("yyyyMMdd");
				String fdate1 = sdformat1.format(date1);
			 ps.setString(15,fdate1);
			 SimpleDateFormat sdformat2 = new SimpleDateFormat("HHmmss");
				String fdate2 = sdformat2.format(date1);
			 ps.setString(16,fdate2);
			 ps.setString(17,student.getUpdateId());
//			 int updatecount = student.getUpdateCount();
//			 ps.setInt(18,updatecount+1);
			 ps.setString(18,studentId.getStudentId());
			 
			 ps.executeUpdate();
	 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 DBManager.close(ps,con);
	 }
	 }
	 public static void findByUpdatecount(String studentId) throws SQLException {
		
		 Connection con = null;
		 PreparedStatement ps = null;
	
		 

		 try {   
		 con = DBManager.getConnection();
		 ps = con.prepareStatement("SELECT * FROM t_student WHERE student_id = ?");
	        ps.setString(1, studentId);
	        

	        // SQLの実行
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	        Student	student = new Student();
	        	student.setUpdateCount(rs.getInt("update_count"));
	        	
	        }

	        
		 }catch(SQLException e) {
	   		 e.printStackTrace();
	   	 }finally {
	   		 DBManager.close(ps,con);
	   	 }
	   		
	   	 
	 }
	 public static void  delete(Student student,StudentId studentId){
		 Connection con = null;
		 PreparedStatement ps = null;
		 
		 try {
			 con = DBManager.getConnection();
			 ps = con.prepareStatement("UPDATE t_student SET delete_flg = ?,update_date = ?,update_time = ?,"
			 		+ "update_id = ?,update_count = update_count +1 WHERE student_id = ?");
			 ps.setInt(1,1);
			 Date date1 = new Date();
			 SimpleDateFormat sdformat1 = new SimpleDateFormat("yyyyMMdd");
				String fdate1 = sdformat1.format(date1);
			 ps.setString(2,fdate1);
			 SimpleDateFormat sdformat2 = new SimpleDateFormat("HHmmss");
				String fdate2 = sdformat2.format(date1);
			 ps.setString(3,fdate2);
			 ps.setString(4,student.getUpdateId());
			 //ps.setInt(5,studentId.getUpdateCount()+1);
			 ps.setString(5,studentId.getStudentId());
			 
			 ps.executeUpdate();
			 
	 }catch(SQLException e) {
		 e.printStackTrace();
	 }finally {
		 DBManager.close(ps,con);
	 }
	 }
	 public static StudentId findstudentId(String studentId) throws SQLException {
		 StudentId studentId1 = null;

	        
	        Connection connection = DBManager.getConnection();

	        
	        PreparedStatement preparedStatement = connection
	                .prepareStatement("SELECT * FROM t_student WHERE student_id = ?");
	        preparedStatement.setString(1, studentId);
	        

	        // SQLの実行
	        ResultSet rs = preparedStatement.executeQuery();

	        // JavaBeansに保存
	        if (rs.next()) {
	        	studentId1 = new StudentId();
	        	studentId1.setStudentId(rs.getString("student_id"));
	        	
	        	
	        	
	        }

	        
	        DBManager.close(preparedStatement, connection);

	        return studentId1;
	        
	    }
	 public static StudentName findstudentnames(String studentName , String phoneNumber1) throws SQLException {
		 StudentName studentn = null;

	        
	        Connection connection = DBManager.getConnection();

	        
	        PreparedStatement preparedStatement = connection
	                .prepareStatement("SELECT * FROM t_student WHERE student_name = ? AND phone_number1 = ?");
	        preparedStatement.setString(1,studentName);
	        preparedStatement.setString(2,phoneNumber1);
	        

	        // SQLの実行
	        ResultSet rs = preparedStatement.executeQuery();

	        // JavaBeansに保存
	        if (rs.next()) {
	        	studentn = new StudentName();
	        	studentn.setStudentname(rs.getString("student_name"));
	        	studentn.setPhoneNumber(rs.getString("phone_number1"));
	        	
	        	
	        	
	        }

	        
	        DBManager.close(preparedStatement, connection);

	        return studentn;
	 }
	 public static StudentId findbystyudentId(String cousedate) throws SQLException {
		 StudentId studentId = null;
		 
		 Connection connection = DBManager.getConnection();

	        
	        PreparedStatement preparedStatement = connection
	        		.prepareStatement("SELECT * FROM t_student WHERE student_id like  ? ");
	        preparedStatement.setString(1,cousedate+"%");
	        
	        ResultSet rs = preparedStatement.executeQuery();
	        int a = 0;
	        while (rs.next()) {
	        	studentId = new StudentId();
	        	studentId.setStudentId(rs.getString("student_id"));
	        	String student3 = studentId.getStudentId();
	        	String student3keta = student3.substring(10,13);
	        	
	        	int student3ketan = Integer.parseInt(student3keta);
	        	if(a<student3ketan) {
	        		a = student3ketan; 
	        	}
	        	
	        	
	        	
	        }

	        a = +1;
	        
	        studentId = new StudentId();
	        studentId.setSanketa(a);
	        DBManager.close(preparedStatement, connection);

	        return studentId;
		 
	 }
	


}
