/*
 * (C) Copyright 2020 Fresher Academy
 * @author Admin
 * @date Mar 10, 2020
 * @version 1.0
 */
package model;

public class Bookingoffice {
	private int officeId;
	private String endContractDeadline;
	private String officeName;
	private String officePhone;
	private String officePlace;
	private int officePrice;
	private String startContractDeadline;
	private int tripId;

	public Bookingoffice() {
		super();

	}
	public Bookingoffice(int officeId, String officeName) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		
	}

	public Bookingoffice(String endContractDeadline, String officeName, String officePhone,
			String officePlace, int officePrice, String startContractDeadline, int tripId) {
		super();
		this.endContractDeadline = endContractDeadline;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.tripId = tripId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getEndContractDeadline() {
		return endContractDeadline;
	}

	public void setEndContractDeadline(String endContractDeadline) {
		this.endContractDeadline = endContractDeadline;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficePlace() {
		return officePlace;
	}

	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}

	public int getOfficePrice() {
		return officePrice;
	}

	public void setOfficePrice(int officePrice) {
		this.officePrice = officePrice;
	}

	public String getStartContractDeadline() {
		return startContractDeadline;
	}

	public void setStartContractDeadline(String startContractDeadline) {
		this.startContractDeadline = startContractDeadline;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

}
