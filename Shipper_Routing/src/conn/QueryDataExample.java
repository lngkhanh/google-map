package conn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDataExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		System.out.println("Start Connection ....  ");
		Connection conn = ConnectionUtils.getConnection();
		String sql = "SELECT * FROM shipper.db_nhanvien;";
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			String id = rs.getString(1);
			String ma = rs.getString(2);
			String lat = rs.getString(3);
			String lang = rs.getString(4);
			System.out.println("-----------------------");
			System.out.println("ID: " + id);
			System.out.println("MAKH: " + ma);
			System.out.println("LAT: " + lat);
			System.out.println("LANG: " + lang);

		}
		conn.close();
	}

}