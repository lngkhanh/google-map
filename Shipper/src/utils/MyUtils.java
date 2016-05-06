package utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.db_nhanvien;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

	private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

	// Lưu trữ Connection vào một thuộc tính của request.
	// Thông tin lưu trữ chỉ tồn tại trong thời gian yêu cầu (request)
	// cho tới khi dữ liệu được trả về trình duyệt người dùng.
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}

	// Lấy đối tượng Connection đã được lưu trữ trong 1 thuộc tính của request.
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}

	// Lưu trữ thông tin người dùng đã login vào Session
	public static void storeLoginedUser(HttpSession session, db_nhanvien loginedUser) {
		// Trên JSP có thể truy cập ${loginedUser}
		session.setAttribute("loginedUser", loginedUser);
	}

	// Lấy thông tin người dùng đã login trong session.
	public static db_nhanvien getLoginedUser(HttpSession session) {
		db_nhanvien loginedUser = (db_nhanvien) session.getAttribute("loginedUser");
		return loginedUser;
	}

	// Lưu thông tin người dùng vào Cookie.
	public static void storeUserCookie(HttpServletResponse response, db_nhanvien user) {
		System.out.println("Store user cookie");
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getUserName());
		// 1 ngày (Đã đổi ra giây)
		cookieUserName.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieUserName);
	}

	public static String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Xóa Cookie của người dùng
	public static void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
		// 0 giây. (Hết hạn ngay lập tức)
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}

}