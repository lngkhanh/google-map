package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.db_nhanvien;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/doRegister" })
public class DoRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DoRegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = MyUtils.getStoredConnection(request);

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String tennv = request.getParameter("tenNhanVien");
		String manv = request.getParameter("codeNumber");
		String diachinv = request.getParameter("address");
		String sdtnv = request.getParameter("phone");
		String ngayvaolam = request.getParameter("dateStart");

		db_nhanvien user = new db_nhanvien(userName, password, tennv, manv, diachinv, sdtnv, ngayvaolam);
		String errorString = null;

		if (userName == null || password == null || tennv == null || manv == null || diachinv == null || sdtnv == null
				|| ngayvaolam == null || userName.length() == 0 || password.length() == 0 || tennv.length() == 0
				|| manv.length() == 0 || diachinv.length() == 0 || sdtnv.length() == 0 || ngayvaolam.length() == 0) {
			errorString = "Filled information incorrectly, please try again. !";
		}
		// Lưu thông tin vào request attribute trước khi forward sang views.

		request.setAttribute("errorString", errorString);
		request.setAttribute("nhanvien", user);

		if (errorString == null) {
			try {
				System.out.println("vao trong [errorString == null]");
				DBUtils.insertKhachHang(conn, user);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/successView.jsp");
			dispatcher.forward(request, response);
		}
		if (errorString != null) {
			System.out.println("[errorString]= " + errorString.toUpperCase().toString());
			System.out.println(" loi xuat hien [errorString != null]");
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/registerView.jsp");
			dispatcher.forward(request, response);
		}

		// if (hasError) {
		// user = new db_nhanvien();
		// user.setUserName(userName);
		// user.setPassword(password);
		//
		// // Ghi các thông tin vào request trước khi forward.
		// request.setAttribute("errorString", errorString);
		// request.setAttribute("user", user);
		//
		// // Chuyển tiếp tới trang /WEB-INF/views/login.jsp
		// RequestDispatcher dispatcher = this.getServletContext()
		// .getRequestDispatcher("/WEB-INF/views/registerView.jsp");
		//
		// dispatcher.forward(request, response);
		// }
		// Trường hợp không có lỗi.
		// Lưu thông tin người dùng vào Session.
		// Và chuyển hướng sang trang loginView.
		// else {
		// HttpSession session = request.getSession();
		// MyUtils.storeLoginedUser(session, user);
		//

		// Rồi chuyển hướng sang trang /map.
		// response.sendRedirect(request.getContextPath() + "/loginView");
		// }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
