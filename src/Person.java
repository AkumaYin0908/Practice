
public class Person {
	private int id;
	private String lastName;
	private String firstName;
	private String email;
	private String gender;
	private String ipAddress;
	
	public Person(int id, String firstName,String lastName, String email,String gender,String ipAddress) {
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.email=email;
		this.gender=gender;
		this.ipAddress=ipAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Override
	public String toString() {
		return "ID: " +id + "\n"+
				"Name: " + firstName + " " + lastName + "\n" +
				"Email: " + email +"\n"+
				"IP Address: " + ipAddress;
				
				
	}
	
	
}
