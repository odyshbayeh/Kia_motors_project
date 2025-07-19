package application;

public class Customer {
	private int customarID;
	private String customarName;
	private String email;
	private String NIN;

	public Customer(int customarID, String customarName, String email, String NIN) {
		this.customarID = customarID;
		this.customarName = customarName;
		this.email = email;
		this.NIN = NIN;
	}

	public int getCustomerID() {
		return customarID;
	}

	public void setCustomerID(int customarID) {
		this.customarID = customarID;
	}

	public String getCustomerName() {
		return customarName;
	}

	public void setCustomerName(String customarName) {
		this.customarName = customarName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNIN() {
		return NIN;
	}

	public void setNIN(String NIN) {
		this.NIN = NIN;
	}
}
