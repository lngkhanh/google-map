package beans;

public class db_donhang {
	private String madh;
	private String manv;
	private String makh;
	private String lat;
	private String lang;

	public db_donhang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public db_donhang(String madh, String manv, String makh, String lat, String lang) {
		super();
		this.madh = madh;
		this.manv = manv;
		this.makh = makh;
		this.lat = lat;
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "db_donhang [madh=" + madh + ", manv=" + manv + ", makh=" + makh + ", lat=" + lat + ", lang=" + lang + "]";
	}

	public String getMadh() {
		return madh;
	}

	public void setMadh(String madh) {
		this.madh = madh;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
