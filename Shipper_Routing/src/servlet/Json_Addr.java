package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import beans.db_nhanvien;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/json" })
public class Json_Addr extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Json_Addr() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// Connection conn = MyUtils.getStoredConnection(request);
		// Kiểm tra người dùng login chưa
		db_nhanvien loginedUser = MyUtils.getLoginedUser(session);

		// Chưa login.
		if (loginedUser == null) {
			// Chuyển hướng về trang login.
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter pw = response.getWriter();
		JSONObject json = new JSONObject();

		try {

			// json.put("Ten NV: ", loginedUser.getTennv());
			json.put("Addr: ", loginedUser.getDiachinv());
			// json.put("lat", dh.getLat());
			// json.put("lang", dh.getLang());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println(json.toString());
		pw.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
