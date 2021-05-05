package com.cg.ofda.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Embeddable
public class AddressModel {
	
	/*
	 * All the private members are validate here with suitable datatypes
	 * 
	 */
	/*	To validate buildingName cannot be null and size>0*/
	@NotEmpty(message="building name cannot be empty")
	/*	To validate buildingName cannot be null but can be empty*/
	@NotNull(message="building name cannot be omitted")
	private String buildingName;
	
	/*	To validate area cannot be null and size>0*/
	@NotEmpty(message="area cannot be empty")
	/*	To validate area cannot be null but can be empty*/
	@NotNull(message="area cannot be omitted")
	private String area;
	
	/*	To validate streetNo cannot be null and size>0*/
	@NotEmpty(message="streetNo cannot be empty")
	/*	To validate streetNo cannot be null but can be empty*/
	@NotNull(message="streetNo cannot be omitted")
	private String streetNo;
	
	/*	To validate city cannot be null and size>0*/
	@NotEmpty(message="city cannot be empty")
	/*	To validate city cannot be null but can be empty*/
	@NotNull(message="city cannot be omitted")
	private String city;
	
	/*	To validate state cannot be null and size>0*/
	@NotEmpty(message="state cannot be empty")
	/*	To validate state cannot be null but can be empty*/
	@NotNull(message="state cannot be omitted")
	private String state;
	
	/*	To validate country cannot be null and size>0*/
	@NotEmpty(message="country cannot be empty")
	/*	To validate country cannot be null but can be empty*/
	@NotNull(message="country cannot be omitted")
	private String country;
	
	/*To check minimum digits of pincode*/
	@Min(value=6, message="pincode should be of 6 digits")
	/*To check maximum digits of pincode*/
	@Max(value=6, message="pincode should be of 6 digits")
	private String pincode;
	
	/*
	 * A default Constructor with no implementation
	 */

	public AddressModel() {
		// default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public AddressModel(
			@NotEmpty(message = "building name cannot be empty") @NotNull(message = "building name cannot be omitted") String buildingName,
			@NotEmpty(message = "area cannot be empty") @NotNull(message = "area cannot be omitted") String area,
			@NotEmpty(message = "streetNo cannot be empty") @NotNull(message = "streetNo cannot be omitted") String streetNo,
			@NotEmpty(message = "city cannot be empty") @NotNull(message = "city cannot be omitted") String city,
			@NotEmpty(message = "state cannot be empty") @NotNull(message = "state cannot be omitted") String state,
			@NotEmpty(message = "country cannot be empty") @NotNull(message = "country cannot be omitted") String country,
			@Min(value = 6, message = "pincode should be of 6 digits") @Max(value = 6, message = "pincode should be of 6 digits") String pincode) {
		super();
		this.buildingName = buildingName;
		this.area = area;
		this.streetNo = streetNo;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	
	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	

	

}
