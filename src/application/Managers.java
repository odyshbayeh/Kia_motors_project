package application;

public class Managers {
	private int employeeID;
	private String monthlyReport;

	public Managers(int employeeID, String monthlyReport) {
		this.employeeID = employeeID;
		this.monthlyReport = monthlyReport;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getMonthlyReport() {
		return monthlyReport;
	}

	public void setMonthlyReport(String monthlyReport) {
		this.monthlyReport = monthlyReport;
	}
}
