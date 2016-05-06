package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.db_donhang;
import beans.db_khachhang;
import beans.db_nhanvien;

public class DBUtils {

	public static db_nhanvien findUser(Connection conn, String userName, String password) throws SQLException {

		String sql = "Select * from db_nhanvien where taikhoan = ? and matkhau= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String diachinv = rs.getString("diachinv");
			String sdtnv = rs.getString("sdtnv");
			String ngayvaolam = rs.getString("ngayvaolam");
			String manv = rs.getString("manv");
			String tennv = rs.getString("tennv");

			db_nhanvien user = new db_nhanvien();

			user.setUserName(userName);
			user.setPassword(password);
			user.setDiachinv(diachinv);
			user.setSdtnv(sdtnv);
			user.setNgayvaolam(ngayvaolam);
			user.setManv(manv);
			user.setTennv(tennv);
			return user;
		}
		return null;
	}

	public static db_nhanvien findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select * from db_nhanvien where taikhoan= ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String diachinv = rs.getString("diachinv");
			String sdtnv = rs.getString("sdtnv");
			String ngayvaolam = rs.getString("ngayvaolam");
			String manv = rs.getString("manv");
			String password = rs.getString("password");

			db_nhanvien user = new db_nhanvien();

			user.setUserName(userName);
			user.setPassword(password);
			user.setDiachinv(diachinv);
			user.setSdtnv(sdtnv);
			user.setNgayvaolam(ngayvaolam);
			user.setManv(manv);
			return user;
		}
		return null;
	}

	public static db_donhang findUser_nhanvien(Connection conn, String userName) throws SQLException {

		String sql = "Select* from db_donhang where manv = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String madh = rs.getString("madh");
			String makh = rs.getString("makh");
			String lat = rs.getString("diachikh");
			String lang = rs.getString("ngaymua");

			db_donhang dh = new db_donhang();

			dh.setMadh(madh);
			dh.setManv(userName);
			dh.setMakh(makh);
			dh.setLat(lat);
			dh.setLang(lang);

			return dh;
		}
		return null;
	}

	public static List<db_donhang> queryToado(Connection conn) throws SQLException {
		String sql = "Select * from db_donhang";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<db_donhang> list = new ArrayList<db_donhang>();
		while (rs.next()) {
			String madh = rs.getString("madh");
			String manv = rs.getString("manv");
			String makh = rs.getString("makh");
			String lat = rs.getString("diachikh");
			String lang = rs.getString("ngaymua");

			db_donhang toado = new db_donhang();

			toado.setMadh(madh);
			toado.setManv(manv);
			toado.setMakh(makh);
			toado.setLat(lat);
			toado.setLang(lang);

			list.add(toado);
		}
		return list;
	}

	public static List<db_khachhang> queryKhachhang(Connection conn) throws SQLException {
		String sql = "Select * from db_khachhang";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<db_khachhang> list = new ArrayList<db_khachhang>();
		while (rs.next()) {
			String makh = rs.getString("makh");
			String tenkh = rs.getString("tenkh");
			String diachi = rs.getString("diachikh");
			String sdt = rs.getString("sdtkh");
			String ngaymua = rs.getString("ngaymua");

			db_khachhang kh = new db_khachhang();
			kh.setMakh(makh);
			kh.setTenkh(tenkh);
			kh.setDiachi(diachi);
			kh.setSdt(sdt);
			kh.setNgaymua(ngaymua);

			list.add(kh);
		}
		return list;
	}

	public static void insertKhachHang(Connection conn, db_nhanvien user) throws SQLException {
		String sql = "Insert into db_nhanvien (manv,tennv,diachinv,sdtnv,ngayvaolam,taikhoan,matkhau) values (?,?,?,?,?,?,?)";

		System.out.println("User: " + user.getManv() + "; " + user.getDiachinv() + "; " + user.getNgayvaolam() + "; "
				+ user.getPassword() + "; " + user.getSdtnv() + "; " + user.getTennv() + "; " + user.getUserName());

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getManv());
		pstm.setString(2, user.getTennv());
		pstm.setString(3, user.getDiachinv());
		pstm.setString(4, user.getSdtnv());
		pstm.setString(5, user.getNgayvaolam());
		pstm.setString(6, user.getUserName());
		pstm.setString(7, user.getPassword());

		pstm.executeUpdate();
	}
}