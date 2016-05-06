package beans;

public class db_khachhang {
	private String makh;
	private String tenkh;
	private String diachi;
	private String sdt;
	private String ngaymua;

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNgaymua() {
		return ngaymua;
	}

	public void setNgaymua(String ngaymua) {
		this.ngaymua = ngaymua;
	}

	public db_khachhang(String makh, String tenkh, String diachi, String sdt, String ngaymua) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.ngaymua = ngaymua;
	}

	public db_khachhang() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "db_khachhang [makh=" + makh + ", tenkh=" + tenkh + ", diachi=" + diachi + ", sdt=" + sdt + ", ngaymua="
				+ ngaymua + "]";
	}

}
