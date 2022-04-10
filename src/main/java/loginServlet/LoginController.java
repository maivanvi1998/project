package loginServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import account.Function;
import dao.ListProductDAO;
import model.Product;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		request.getSession(true).invalidate();
		// make sure that email evalid
		String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
		String regex = "[a-zA-Z0-9_!@#$%^&*]+";
		// collect data from a login form
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession(true);
		if (!pass.matches(regex) || !user.matches(regexMail)) {
			session.setAttribute("error", "invalid syntax");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		Function fc = new Function();
		try {
			if (fc.login(user, pass)) {
				// set session
				ListProductDAO dao = new ListProductDAO();
				List<Product> list = dao.getAllProducts();
				request.setAttribute("listProducts", list);
				session.setAttribute("user", user);
				session.setAttribute("pass", pass);
				Cookie coUser = new Cookie("user", user);
				Cookie coPass = new Cookie("pass", pass);
				if (request.getParameter("remember") != null) {
					coUser.setMaxAge(60 * 60 * 40);
					coPass.setMaxAge(60 * 60 * 40);

				} else {
					coUser.setMaxAge(0);
					coPass.setMaxAge(0);
				}
				response.addCookie(coUser);
				response.addCookie(coPass);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "wrong username or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);

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