package signupcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.Function;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String repeatPass = request.getParameter("repeatPass");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.getSession(true).invalidate();
		// make sure that email evalid
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		// collect data from a login form
		HttpSession session = request.getSession(true);
		if (!pass.matches(regex) || !user.matches(regexMail)) {
			session.setAttribute("error", "invalid syntax");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		Function fc = new Function();
		if(!pass.equalsIgnoreCase(repeatPass)) {
			request.setAttribute("mess", "Password incorrect");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}else {
			try {
				if(fc.exists(user)) {
					request.setAttribute("mess", "Account existed !!!");
					request.getRequestDispatcher("signup.jsp").forward(request, response);
				}else {
					fc.createAccount(user, pass);
					request.setAttribute("mess", "Create successful !!!");
					request.getRequestDispatcher("signupsuccess.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
