package application;

public class Car {
	private int carID;
	private String carModel;
	private String carType;
	private String carColor;
	private String carStatus;

	public Car(int carID, String carType, String carModel, String carColor, String carStatus) {
		this.carID = carID;
		this.carType = carType;
		this.carModel = carModel;
		this.carColor = carColor;
		this.carStatus = carStatus;
	}

	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
}
