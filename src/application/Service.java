package application;

public class Service {
	private int serviceID;
	private int customarID;
	private int carID;
	private String serviceDescription;

	public Service(int serviceID, int customarID, int carID, String serviceDescription) {
		this.serviceID = serviceID;
		this.customarID = customarID;
		this.carID = carID;
		this.serviceDescription = serviceDescription;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
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

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
}
