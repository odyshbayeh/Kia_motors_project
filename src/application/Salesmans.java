package application;

public class Salesmans {
	private int employeeID;
	private int employeeTarget;

	public Salesmans(int employeeID, int employeeTarget) {
		this.employeeID = employeeID;
		this.employeeTarget = employeeTarget;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getEmployeeTarget() {
		return employeeTarget;
	}

	public void setEmployeeTarget(int employeeTarget) {
		this.employeeTarget = employeeTarget;
	}
}
