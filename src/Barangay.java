
public class Barangay {
	private String brgyName;
	private int munCityCode;
	private int provCode;
	private int regCode;
	public Barangay(int munCityCode,String brgyName, int provCode,int regCode) {
		
		this.munCityCode = munCityCode;
		this.brgyName = brgyName;
		this.provCode=provCode;
		this.regCode=regCode;
	}

	public String getBrgyName() {
		return brgyName;
	}

	public void setBrgyName(String brgyName) {
		this.brgyName = brgyName;
	}

	public int getMunCityCode() {
		return munCityCode;
	}

	public void setMunCityCode(int munCityCode) {
		this.munCityCode = munCityCode;
	}
	public int getProvCode() {
		return provCode;
	}
	public void setProvCode(int provCode) {
		this.provCode=provCode;
	}

	public int getRegCode() {
		return regCode;
	}

	public void setRegCode(int regCode) {
		this.regCode = regCode;
	}
	
}

