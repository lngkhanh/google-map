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

import beans.db_donhang;
import utils.DBUtils;
import utils.MyUtils;

@WebServlet(urlPatterns = { "/toadoList" })
public class ToatoListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToatoListServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		// String json = new Gson().toJson(list);
		//
		// response.setContentType("application/json");
		// response.setCharacterEncoding("UTF-8");
		// response.getWriter().write(json);

		// Forward sang /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/ToadoListView.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
