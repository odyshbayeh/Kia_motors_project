package application;

public class Advertisers {
	private int employeeID;
	private int points;

	public Advertisers(int employeeID, int points) {
		this.employeeID = employeeID;
		this.points = points;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
