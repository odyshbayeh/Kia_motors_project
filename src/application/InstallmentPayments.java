package application;

public class InstallmentPayments {
	private int saleID;
	private int processNumber;
	private double totalCost;
	private double firstPayment;
	private double monthlyInstallment;
	private int numberOfMonths;

	public InstallmentPayments(int saleID, int processNumber, double totalCost, double firstPayment,
			double monthlyInstallment, int numberOfMonths) {
		this.saleID = saleID;
		this.processNumber = processNumber;
		this.totalCost = totalCost;
		this.firstPayment = firstPayment;
		this.monthlyInstallment = monthlyInstallment;
		this.numberOfMonths = numberOfMonths;
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

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getFirstPayment() {
		return firstPayment;
	}

	public void setFirstPayment(double firstPayment) {
		this.firstPayment = firstPayment;
	}

	public double getMonthlyInstallment() {
		return monthlyInstallment;
	}

	public void setMonthlyInstallment(double monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}

	public int getNumberOfMonths() {
		return numberOfMonths;
	}

	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}
}
