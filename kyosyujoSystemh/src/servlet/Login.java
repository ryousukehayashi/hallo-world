package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Employee;
import dao.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
		String loginId =request.getParameter("loginId");
		String password = request.getParameter("pass");
		
		Employee employee = UserDAO.findByUserIDAndPassword(loginId, password);
		
            // TODO 下記コードを、書籍一覧表示用のサーブレットにフォワードするように編集してください。
        	
		if (employee != null) {
            // TODO 下記コードを、書籍一覧表示用のサーブレットにフォワードするように編集してください。
			String userName = employee.getEmpName();
        	HttpSession session = request.getSession();
            session.setAttribute("loginId",loginId);
            session.setAttribute("userName",userName);
            request.getRequestDispatcher("/menu.jsp").forward(request, response);


        } else {
            request.setAttribute("errMessage", "ユーザID、またはパスワードが間違っています。");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
		} catch (Exception e) {
            e.printStackTrace();
        }

        
		
	}

}
