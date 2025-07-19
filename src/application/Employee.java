package application;

import java.time.LocalDate;

public class Employee {
	private int employeeID;
	private String employeeName;
	private double salary;
	private LocalDate dateOfEmployment;

	public Employee(int employeeID, String employeeName, int salary, LocalDate dateOfEmployment) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.salary = salary;
		this.dateOfEmployment = dateOfEmployment;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getDateOfEmployment() {
		return dateOfEmployment;
	}

	public void setDateOfEmployment(LocalDate dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
}
