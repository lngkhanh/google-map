package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.db_khachhang;
import beans.db_donhang;
import beans.db_nhanvien;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/map" })
public class Map_load extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Map_load() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// Kiểm tra người dùng login chưa
		db_nhanvien loginedUser = MyUtils.getLoginedUser(session);

		// Chưa login.
		if (loginedUser == null) {
			// Chuyển hướng về trang login.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		// Ghi thông tin vào request trước khi forward.
		request.setAttribute("user", loginedUser);

		// ---lay danh sach cac toado
		Connection conn = MyUtils.getStoredConnection(request);

		String errorString = null;
		List<db_donhang> list = null;
		try {
			list = DBUtils.queryToado(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Lưu thông tin vào request attribute trước khi forward sang views.
		request.setAttribute("errorString", errorString);
		request.setAttribute("ToadoList", list);

		// danh sach khach hang

		String errorStringKH = null;
		List<db_khachhang> listKH = null;
		try {
			listKH = DBUtils.queryKhachhang(conn);
		} catch (SQLException e) {
			e.printStackTrace();
			errorStringKH = e.getMessage();
		}
		// Lưu thông tin vào request attribute trước khi forward sang views.
		request.setAttribute("errorString", errorStringKH);
		request.setAttribute("KhachhangList", listKH);

		// Forward toi trang map
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/map.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
