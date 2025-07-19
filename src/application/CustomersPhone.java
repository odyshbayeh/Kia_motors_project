package application;

public class CustomersPhone {
	private int customerID;
	private long phone;

	public CustomersPhone(int customerID, long phone) {
		this.customerID = customerID;
		this.phone = phone;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}