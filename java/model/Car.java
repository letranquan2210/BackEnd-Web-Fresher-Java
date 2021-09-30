/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 10, 2020
 * @version 1.0
 */
package model;

public class Car {
	private String licensePlate;
	private String carColor;
	private String carType;
	private String company;
	private int parkId;

	public Car() {
		super();

	}

	public Car(String licensePlate, String carColor, String carType, String company, int parkId) {
		super();
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.company = company;
		this.parkId = parkId;
	}
	
	public Car(String licensePlate, String carColor, String carType, String company, int parkId, String lic) {
		super();
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.company = company;
		this.parkId = parkId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

}
