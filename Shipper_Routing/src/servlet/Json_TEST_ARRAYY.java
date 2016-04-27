package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import beans.db_khachhang;
import beans.db_nhanvien;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/address" })
public class Json_TEST_ARRAYY extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Json_TEST_ARRAYY() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Connection conn = MyUtils.getStoredConnection(request);
		// Kiểm tra người dùng login chưa
		db_nhanvien loginedUser = MyUtils.getLoginedUser(session);

		// Chưa login.
		if (loginedUser == null) {
			// Chuyển hướng về trang login.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		List<db_khachhang> kh = null;
		try {
			kh = DBUtils.queryKhachhang(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter pw = response.getWriter();
		JSONObject json = new JSONObject();

		try {
			json.put("Addr", kh);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		pw.println(json.toString());
		pw.flush();

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
