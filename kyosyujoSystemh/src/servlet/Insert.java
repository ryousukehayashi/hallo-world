package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Mcode;
import bean.Student;
import bean.StudentId;
import bean.StudentName;
import dao.McodeDAO;
import dao.UserDAO;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("kensaku")!=null){
			try {
			
			String studentId1 = request.getParameter("studentId");
			StudentId studentId2 = UserDAO.findstudentId(studentId1);
			if(studentId2 !=null) {
			HttpSession session = request.getSession();
            session.setAttribute("studentId",studentId1);
			Student student = UserDAO.findByStudent(studentId1);
			
			request.setAttribute("student" ,student);
			request.getRequestDispatcher("/student.jsp").forward(request, response);
			StudentId studentid = new StudentId();
			studentid.setStudentId(studentId1);
			request.setAttribute("studentid",studentid);
			}else {
				request.setAttribute("errMessage", "登録がありません");
	            request.getRequestDispatcher("/student.jsp").forward(request, response);
			}
			}catch (Exception e) {
	            e.printStackTrace();
	        }

			
		}else if(request.getParameter("touroku")!=null) {
			
		try {
			String studentName = request.getParameter("studentName");	
			String phoneNumber1 = request.getParameter("phoneNumber1");
			StudentName student1 = UserDAO.findstudentnames(studentName, phoneNumber1);
			if(student1 == null) {
				
//			String studentId1 = request.getParameter("studentId");		
			String studentNamePhonetic = request.getParameter("studentNamePhonetic");
			String birthDayYear = request.getParameter("birthDayYear");
			String birthDayMouth = request.getParameter("birthDayMouth");
			String birthDayDays = request.getParameter("birthDayDays");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			
			String phoneNumber2 = request.getParameter("phoneNumber2");
			String requestCouse = request.getParameter("requestCouse");
			int glasses = Integer.parseInt(request.getParameter("glasses"));
			String startingDate =request.getParameter("startingDate");
			String receptionDate = request.getParameter("receptionDate");
			String receptionEmpoyee = request.getParameter("receptionEmpoyee");
			String note = request.getParameter("note");
			
			
			String cousedate = requestCouse+receptionDate;
			StudentId studentid2 = UserDAO.findbystyudentId(cousedate);
			int sunketa = studentid2.getSanketa();
			if(sunketa == 1) {
				String renban = "001";
				String studentid = cousedate+renban;
				StudentId studentid5 = new StudentId();
				studentid5.setStudentId(studentid);
				request.setAttribute("studentid",studentid5);
			}else {
				
				
				String sunketa1 =String.format("%03d", sunketa);
				String studentid = cousedate+sunketa1;


				
				
				StudentId studentid5 = new StudentId();
				studentid5.setStudentId(studentid);
				request.setAttribute("studentid",studentid5);
			}
			
			
			Mcode mcode = McodeDAO.findBygender(gender);
			Mcode mcode1 = McodeDAO.findByrquest_course(requestCouse);
			Mcode mcode2 = McodeDAO.findByavailable(glasses);
			
			request.setAttribute("mcode", mcode);
			request.setAttribute("mcode1", mcode1);
			request.setAttribute("mcode2", mcode2);
		
		
		
//			StudentId studentid = new StudentId();
//			studentid.setStudentId(studentId1);
		
		
	
		
		
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentNamePhonetic(studentNamePhonetic);
		student.setBirthDay(birthDayYear+birthDayMouth+birthDayDays);
		student.setAddress(address);
		student.setGender(gender);
		student.setPhoneNumber1(phoneNumber1);
		student.setPhoneNumber2(phoneNumber2);
		student.setRequestCourse(requestCouse);
		student.setGlass(glasses);
		student.setStartingDate(startingDate);
		student.setReceptionDate(receptionDate);
		student.setReceptionEmployee(receptionEmpoyee);
		student.setNote(note);

		request.setAttribute("student",student);
		request.getRequestDispatcher("/studentkakunin.jsp").forward(request, response);
			}else {
				String studentId1 = request.getParameter("studentId");		
				String studentNamePhonetic = request.getParameter("studentNamePhonetic");
				String birthDayYear = request.getParameter("birthDayYear");
				String birthDayMouth = request.getParameter("birthDayMouth");
				String birthDayDays = request.getParameter("birthDayDays");
				String address = request.getParameter("address");
				String gender = request.getParameter("gender");
				
				String phoneNumber2 = request.getParameter("phoneNumber2");
				String requestCouse = request.getParameter("requestCouse");
				int glasses = Integer.parseInt(request.getParameter("glasses"));
				String startingDate =request.getParameter("startingDate");
				String receptionDate = request.getParameter("receptionDate");
				String receptionEmpoyee = request.getParameter("receptionEmpoyee");
				String note = request.getParameter("note");
			
			
			
				StudentId studentid = new StudentId();
				studentid.setStudentId(studentId1);
			
			
		
			
			
			
			Student student = new Student();
			
			student.setStudentNamePhonetic(studentNamePhonetic);
			student.setBirthDay(birthDayYear+birthDayMouth+birthDayDays);
			student.setBirthDayDays(birthDayDays);
			student.setBirthDayMouth(birthDayMouth);
			student.setBirthDayYears(birthDayYear);
			student.setAddress(address);
			student.setGender(gender);
			
			student.setPhoneNumber2(phoneNumber2);
			student.setRequestCourse(requestCouse);
			student.setGlass(glasses);
			student.setStartingDate(startingDate);
			student.setReceptionDate(receptionDate);
			student.setReceptionEmployee(receptionEmpoyee);
			student.setNote(note);
			request.setAttribute("studentid",studentid);
			request.setAttribute("student",student);
				request.setAttribute("errMessage1", "既に登録されています");
	            request.getRequestDispatcher("/student.jsp").forward(request, response);
			}
		}catch(Exception e) {
            e.printStackTrace();
        }	
		}else if(request.getParameter("kousin")!=null){
			try {
			String studentId1 = request.getParameter("studentId");
			
			StudentId studentId2 = UserDAO.findstudentId(studentId1);
			if(studentId2 != null) {
			String studentName = request.getParameter("studentName");
			String studentNamePhonetic = request.getParameter("studentNamePhonetic");
			String birthDayYear = request.getParameter("birthDayYear");
			String birthDayMouth = request.getParameter("birthDayMouth");
			String birthDayDays = request.getParameter("birthDayDays");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String phoneNumber1 = request.getParameter("phoneNumber1");
			String phoneNumber2 = request.getParameter("phoneNumber2");
			String requestCouse = request.getParameter("requestCouse");
			int glasses = Integer.parseInt(request.getParameter("glasses"));
			String startingDate =request.getParameter("startingDate");
			String receptionDate = request.getParameter("receptionDate");
			String receptionEmpoyee = request.getParameter("receptionEmpoyee");
			String note = request.getParameter("note");
			
			Mcode mcode = McodeDAO.findBygender(gender);
			Mcode mcode1 = McodeDAO.findByrquest_course(requestCouse);
			Mcode mcode2 = McodeDAO.findByavailable(glasses);
			
			request.setAttribute("mcode", mcode);
			request.setAttribute("mcode1", mcode1);
			request.setAttribute("mcode2", mcode2);
			
			StudentId studentid = new StudentId();
			studentid.setStudentId(studentId1);
			
			Student student = new Student();
			student.setStudentName(studentName);
			student.setStudentNamePhonetic(studentNamePhonetic);
			student.setBirthDay(birthDayYear+birthDayMouth+birthDayDays);
			student.setAddress(address);
			student.setGender(gender);
			student.setPhoneNumber1(phoneNumber1);
			student.setPhoneNumber2(phoneNumber2);
			student.setRequestCourse(requestCouse);
			student.setGlass(glasses);
			student.setStartingDate(startingDate);
			student.setReceptionDate(receptionDate);
			student.setReceptionEmployee(receptionEmpoyee);
			student.setNote(note);
			request.setAttribute("studentid",studentid);
			request.setAttribute("student",student);
			request.getRequestDispatcher("/kousinkakunin.jsp").forward(request, response);
			}else {
				String studentName = request.getParameter("studentName");		
				String studentNamePhonetic = request.getParameter("studentNamePhonetic");
				String birthDayYear = request.getParameter("birthDayYear");
				String birthDayMouth = request.getParameter("birthDayMouth");
				String birthDayDays = request.getParameter("birthDayDays");
				String address = request.getParameter("address");
				String gender = request.getParameter("gender");
				String phoneNumber1 = request.getParameter("phoneNumber1");

				String phoneNumber2 = request.getParameter("phoneNumber2");
				String requestCouse = request.getParameter("requestCouse");
				int glasses = Integer.parseInt(request.getParameter("glasses"));
				String startingDate =request.getParameter("startingDate");
				String receptionDate = request.getParameter("receptionDate");
				String receptionEmpoyee = request.getParameter("receptionEmpoyee");
				String note = request.getParameter("note");
			
			
			
				StudentId studentid = new StudentId();
				studentid.setStudentId(studentId1);
			
			
		
			
			
			
			Student student = new Student();
			student.setStudentName(studentName);
			student.setStudentNamePhonetic(studentNamePhonetic);
			student.setBirthDay(birthDayYear+birthDayMouth+birthDayDays);
			student.setBirthDayDays(birthDayDays);
			student.setBirthDayMouth(birthDayMouth);
			student.setBirthDayYears(birthDayYear);
			student.setAddress(address);
			student.setGender(gender);
			student.setPhoneNumber1(phoneNumber1);
			student.setPhoneNumber2(phoneNumber2);
			student.setRequestCourse(requestCouse);
			student.setGlass(glasses);
			student.setStartingDate(startingDate);
			student.setReceptionDate(receptionDate);
			student.setReceptionEmployee(receptionEmpoyee);
			student.setNote(note);
			request.setAttribute("studentid",studentid);
			request.setAttribute("student",student);
				request.setAttribute("errMessage", "登録がありません");
	            request.getRequestDispatcher("/student.jsp").forward(request, response);
			}
			}catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}else if(request.getParameter("sakuzyo")!=null) {
			
			try {
				String studentId1 = request.getParameter("studentId");
				
				StudentId studentId2 = UserDAO.findstudentId(studentId1);
				if(studentId2 != null) {
			String studentName = request.getParameter("studentName");
			String studentNamePhonetic = request.getParameter("studentNamePhonetic");
			String birthDayYear = request.getParameter("birthDayYear");
			String birthDayMouth = request.getParameter("birthDayMouth");
			String birthDayDays = request.getParameter("birthDayDays");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String phoneNumber1 = request.getParameter("phoneNumber1");
			String phoneNumber2 = request.getParameter("phoneNumber2");
			String requestCouse = request.getParameter("requestCouse");
			int glasses = Integer.parseInt(request.getParameter("glasses"));
			String startingDate =request.getParameter("startingDate");
			String receptionDate = request.getParameter("receptionDate");
			String receptionEmpoyee = request.getParameter("receptionEmpoyee");
			String note = request.getParameter("note");
			
			Mcode mcode = McodeDAO.findBygender(gender);
			Mcode mcode1 = McodeDAO.findByrquest_course(requestCouse);
			Mcode mcode2 = McodeDAO.findByavailable(glasses);
			
			request.setAttribute("mcode", mcode);
			request.setAttribute("mcode1", mcode1);
			request.setAttribute("mcode2", mcode2);
			
			StudentId studentid = new StudentId();
			studentid.setStudentId(studentId1);
			
			Student student = new Student();
			student.setStudentName(studentName);
			student.setStudentNamePhonetic(studentNamePhonetic);
			student.setBirthDay(birthDayYear+birthDayMouth+birthDayDays);
			student.setAddress(address);
			student.setGender(gender);
			student.setPhoneNumber1(phoneNumber1);
			student.setPhoneNumber2(phoneNumber2);
			student.setRequestCourse(requestCouse);
			student.setGlass(glasses);
			student.setStartingDate(startingDate);
			student.setReceptionDate(receptionDate);
			student.setReceptionEmployee(receptionEmpoyee);
			student.setNote(note);
			request.setAttribute("studentid",studentid);
			request.setAttribute("student",student);
			request.getRequestDispatcher("/sakuzyokakunin.jsp").forward(request, response);
				}else {
					
					request.setAttribute("errMessage", "登録がありません");
		            request.getRequestDispatcher("/student.jsp").forward(request, response);
				}
				}catch (Exception e) {
		            e.printStackTrace();
		        }
		}else if(request.getParameter("syuryou")!=null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}
	

	

}
