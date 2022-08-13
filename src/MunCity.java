
public class MunCity {
	
	private String munCityName;
	private int munCityCode;
	private int provCode;
	private int regDesc;
	public MunCity( int munCityCode, String munCityName,int provCode, int regDesc) {
		
		this.munCityName = munCityName;
		this.munCityCode = munCityCode;
		this.provCode = provCode;
		this.regDesc=regDesc;
	}

	public int getRegDesc() {
		return regDesc;
	}

	public void setRegDesc(int regDesc) {
		this.regDesc = regDesc;
	}

	public String getMunCityName() {
		return munCityName;
	}

	public void setMunCityName(String munCityName) {
		this.munCityName = munCityName;
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
		this.provCode = provCode;
	}
	

	
}
