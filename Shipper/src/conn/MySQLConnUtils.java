package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

	public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {

		String hostName = "localhost";
		String dbName = "shipper";
		String userName = "root";
		String password = "root";

//		 String hostName = "node171687-giaohangnhanh.jelastic.servint.net";
//		 String dbName = "shipper";
//		 String userName = "root";
//		 String password = "LGBstb83338";

		return getMySQLConnection(hostName, dbName, userName, password);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");

		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
//		 String connectionURL ="jdbc:mysql://"+hostName+"/"+dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}