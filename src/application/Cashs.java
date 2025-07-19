package application;

public class Cashs {
	private int saleID;
	private int processNumber;
	private double bankCash;
	private double directCash;
	private float discounts;

	public Cashs(int saleID, int processNumber, double bankCash, double directCash, float discounts) {
		this.saleID = saleID;
		this.processNumber = processNumber;
		this.bankCash = bankCash;
		this.directCash = directCash;
		this.discounts = discounts;
	}

	public int getSaleID() {
		return saleID;
	}

	public void setSaleID(int saleID) {
		this.saleID = saleID;
	}

	public int getProcessNumber() {
		return processNumber;
	}

	public void setProcessNumber(int processNumber) {
		this.processNumber = processNumber;
	}

	public double getBankCash() {
		return bankCash;
	}

	public void setBankCash(double bankCash) {
		this.bankCash = bankCash;
	}

	public double getDirectCash() {
		return directCash;
	}

	public void setDirectCash(double directCash) {
		this.directCash = directCash;
	}

	public float getDiscounts() {
		return discounts;
	}

	public void setDiscounts(float discounts) {
		this.discounts = discounts;
	}
}
