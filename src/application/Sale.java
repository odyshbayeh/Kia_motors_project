package application;

public class Sale {
	private int saleID;
	private String saleDescription;
	private int customarID;
	private int carID;
	private int employeeID;

	public Sale(int saleID, String saleDescription, int customarID, int carID, int employeeID) {
		this.saleID = saleID;
		this.saleDescription = saleDescription;
		this.customarID = customarID;
		this.carID = carID;
		this.employeeID = employeeID;
	}

	public int getSaleID() {
		return saleID;
	}

	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}

	public String getSaleDescription() {
		return saleDescription;
	}

	public void setSaleDescription(String saleDescription) {
		this.saleDescription = saleDescription;
	}

	public int getCustomarID() {
		return customarID;
	}

	public void setCustomarID(int customarID) {
		this.customarID = customarID;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
}
