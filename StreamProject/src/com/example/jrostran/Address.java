package com.example.jrostran;

import java.util.Map;

public class Address {

	private static final long serialVersionUID = -6485392252184278612L;

	private String streetName;
	private String streetNumber;
	private String apartmentNumber;
	private String cityStateZip;
	private String plus4ZipCode;

	
	//private Map<String, Link> _links;
	
	public final String getStreetName() {
		return this.streetName;
	}
	public final void setStreetName(final String streetName) {
		this.streetName = streetName;
	}
	public final String getStreetNumber() {
		return this.streetNumber;
	}
	public final void setStreetNumber(final String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public final String getApartmentNumber() {
		return this.apartmentNumber;
	}
	public final void setApartmentNumber(final String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public final String getCityStateZip() {
		return this.cityStateZip;
	}
	public final void setCityStateZip(final String cityStateZip) {
		this.cityStateZip = cityStateZip;
	}
	public final String getPlus4ZipCode() {
		return this.plus4ZipCode;
	}
	public final void setPlus4ZipCode(final String plus4ZipCode) {
		this.plus4ZipCode = plus4ZipCode;
	}
	
}
