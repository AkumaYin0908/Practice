
public class Province {

	private String provName;
	private int provCode;
	private int regCode;
	public Province(int provCode, String provName, int regCode) {
	
		this.provCode = provCode;
		this.provName = provName;
		this.regCode=regCode;
	}
	
	
	public String getProvName() {
		return provName;
	}
	public int getProvCode() {
		return provCode;
	}
	public void setProvName(String provName) {
		this.provName = provName;
	}
	public void setProvCode(int provCode) {
		this.provCode = provCode;
	}


	public int getRegCode() {
		return regCode;
	}


	public void setRegCode(int regCode) {
		this.regCode = regCode;
	}

	
	
	
}
