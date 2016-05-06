package beans;

public class db_nhanvien {

	private String userName;
	private String password;
	private String tennv;
	private String manv;
	private String diachinv;
	private String sdtnv;
	private String ngayvaolam;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTennv() {
		return tennv;
	}

	public void setTennv(String tennv) {
		this.tennv = tennv;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getDiachinv() {
		return diachinv;
	}

	public void setDiachinv(String diachinv) {
		this.diachinv = diachinv;
	}

	public String getSdtnv() {
		return sdtnv;
	}

	public void setSdtnv(String sdtnv) {
		this.sdtnv = sdtnv;
	}

	public String getNgayvaolam() {
		return ngayvaolam;
	}

	public void setNgayvaolam(String ngayvaolam) {
		this.ngayvaolam = ngayvaolam;
	}

	public db_nhanvien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public db_nhanvien(String userName, String password, String tennv, String manv, String diachinv, String sdtnv,
			String ngayvaolam) {
		super();
		this.userName = userName;
		this.password = password;
		this.tennv = tennv;
		this.manv = manv;
		this.diachinv = diachinv;
		this.sdtnv = sdtnv;
		this.ngayvaolam = ngayvaolam;
	}

	@Override
	public String toString() {
		return "db_nhanvien [userName=" + userName + ", password=" + password + ", tennv=" + tennv + ", manv=" + manv
				+ ", diachinv=" + diachinv + ", sdtnv=" + sdtnv + ", ngayvaolam=" + ngayvaolam + "]";
	}

}