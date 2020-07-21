package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Touroku
 */
@WebServlet("/Touroku")
public class Touroku extends HttpServlet {
	
	
		public void doGet(HttpServletRequest request, HttpServletResponse response) {
	        try {
	            
	            
	            
	            request.getRequestDispatcher("/student.jsp").forward(request, response);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

}
