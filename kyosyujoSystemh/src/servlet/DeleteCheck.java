package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import bean.StudentId;
import dao.UserDAO;

/**
 * Servlet implementation class DeleteCheck
 */
@WebServlet("/DeleteCheck")
public class DeleteCheck extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		String studentNamePhonetic = request.getParameter("studentNamePhonetic");
		String birthDayYear = request.getParameter("birthDayYear");
		String birthDayMouth = request.getParameter("birthDayMouth");
		String birthDayDays = request.getParameter("birthDayDays");
		String birthDay = request.getParameter("birthDay");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String phoneNumber1 = request.getParameter("phoneNumber1");
		String phoneNumber2 = request.getParameter("phoneNumber2");
		String requestCouse = request.getParameter("requestCourse");
		int glasses = Integer.parseInt(request.getParameter("glass"));
		String startingDate =request.getParameter("startingDate");
		String receptionDate = request.getParameter("receptionDate");
		String receptionEmpoyee = request.getParameter("receptionEmployee");
		String note = request.getParameter("note");
		

		StudentId studentid = new StudentId();
		studentid.setStudentId(studentId);
	
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentNamePhonetic(studentNamePhonetic);
		student.setBirthDay(birthDay);
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
		student.setUpdateId(receptionEmpoyee);
		UserDAO.findByUpdatecount(studentId);
		UserDAO.delete(student,studentid);
		request.getRequestDispatcher("/delete_complete.jsp").forward(request, response);
		}catch(Exception e) {
            e.printStackTrace();
        }
	}

}
