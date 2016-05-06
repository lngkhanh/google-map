package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.db_nhanvien;
import utils.MyUtils;
@WebServlet(urlPatterns = { "/logout"})
public class LogoutServlet extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Forward toi trang /WEB-INF/views/loginView.jsp
		// (Người dùng không bao giờ truy cập trực tiếp được vào các trang JSP
		// đặt trong WEB-INF)
		
		HttpSession session = request.getSession();
		 
	       // Kiểm tra người dùng login chưa
	       db_nhanvien loginedUser = MyUtils.getLoginedUser(session);
	 
	       // Chưa login.
	       if (loginedUser == null) {
	           // Chuyển hướng về trang login.
	           response.sendRedirect(request.getContextPath() + "/login");
	           return;
	       }
	      	 
	       // Đã login rồi thì chuyển tiếp sang /WEB-INF/views/userInfoView.jsp
	       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
	      
		
//		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
