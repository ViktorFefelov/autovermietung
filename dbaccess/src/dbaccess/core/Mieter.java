package dbaccess.core;

public class Mieter {
	
	private int mid;
	private String mname;
	private String mstrasse;
	private String mplz;
	private String mort;
	private String mtel;
	
	public Mieter( int mid, String mname, String mstrasse, String mplz, String mort, String mtel) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mstrasse = mstrasse;
		this.mplz = mplz;
		this.mort = mort;
		this.mtel = mtel;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMstrasse() {
		return mstrasse;
	}

	public void setMstrasse(String mstrasse) {
		this.mstrasse = mstrasse;
	}

	public String getMplz() {
		return mplz;
	}

	public void setMplz(String mplz) {
		this.mplz = mplz;
	}

	public String getMort() {
		return mort;
	}

	public void setMort(String mort) {
		this.mort = mort;
	}

	public String getMtel() {
		return mtel;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	@Override
	public String toString() {
		return "Mieter [mid=" + mid + ", mname=" + mname + ", mstrasse=" + mstrasse + ", mplz=" + mplz + ", mort="
				+ mort + ", mtel=" + mtel + "]";
	}
	

}
