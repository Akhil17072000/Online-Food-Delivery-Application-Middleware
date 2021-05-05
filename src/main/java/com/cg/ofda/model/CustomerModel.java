package com.cg.ofda.model;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerModel {
	
	/*
	 * All the private members are validate here with suitable datatypes
	 * 
	 */
	
	/*	To validate customerId cannot be null but can be empty*/
	@NotNull(message="customer id cannot be null")
	private Long customerId;
	
	/*	To validate firstName cannot be null and size>0*/
	@NotEmpty(message="firstName cannot be empty")
	/*	To validate firstName cannot be null but can be empty*/
	@NotNull(message="firstName cannot be omitted")
	private String firstName;
	
	/*	To validate lastName cannot be null and size>0*/
	@NotEmpty(message="lastName cannot be empty")
	/*	To validate lastName cannot be null but can be empty*/
	@NotNull(message="lastName cannot be omitted")
	private String lastName;
	
	/*	To validate gender cannot be null and size>0*/
	@NotEmpty(message="gender cannot be empty")
	/*	To validate gender cannot be null but can be empty*/
	@NotNull(message="gender cannot be omitted")
	private String gender;
	
	/*For checking age should be more than 16*/
	@Min(value=16,message="min age should be 16")
	/*For checking age should be less than 70*/
	@Max(value=70,message="max age should be 70")
	private String age;
	
	/*To check minimum size of mobile number*/
	@Min(value=10, message="mobileNumber cannot be empty and should be of 10 digit")
	/*To check maximum size of mobile number*/
	@Max(value=10, message="mobileNumber cannot be empty and should be of 10 digit")
	private String mobileNumber;
	
	@Valid
	private AddressModel address;
	
	/*	To validate foodCart cannot be null and size>0*/
	@NotEmpty(message="foodCart cannot be empty")
	/*	To validate foodCart cannot be null but can be empty*/
	@NotNull(message="foodCart cannot be omitted")
	private FoodCartModel foodCart;
	
	/*For checking pattern of email*/
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	/*
	 * A default Constructor with no implementation
	 * */
	public CustomerModel() {
//		default
	}


	/*
	 * A Parameterized Constructor for assigning the values to private members
	 * */
	
	public CustomerModel(@NotNull(message = "customer id cannot be null") Long customerId,
			@NotEmpty(message = "firstName cannot be empty") @NotNull(message = "firstName cannot be omitted") String firstName,
			@NotEmpty(message = "lastName cannot be empty") @NotNull(message = "lastName cannot be omitted") String lastName,
			@NotEmpty(message = "gender cannot be empty") @NotNull(message = "gender cannot be omitted") String gender,
			@Min(value = 16, message = "min age should be 16") @Max(value = 70, message = "max age should be 70") String age,
			@Min(value = 10, message = "mobileNumber cannot be empty and should be of 10 digit") @Max(value = 10, message = "mobileNumber cannot be empty and should be of 10 digit") String mobileNumber,
			@Valid AddressModel address,
			@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$") String email) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
	}


	/* 
	 * Corresponding Getters and Setters for private members
	 * 
	 * */
	

	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	

	public FoodCartModel getFoodCart() {
		return foodCart;
	}


	public void setFoodCart(FoodCartModel foodCart) {
		this.foodCart = foodCart;
	}



	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public AddressModel getAddress() {
		return address;
	}


	public void setAddress(AddressModel address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Corresponding HashCode and Equals
	 * */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((foodCart == null) ? 0 : foodCart.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerModel other = (CustomerModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (foodCart == null) {
			if (other.foodCart != null)
				return false;
		} else if (!foodCart.equals(other.foodCart))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		return true;
	}

	
	/* Corresponding toString*/

	@Override
	public String toString() {
		return "CustomerModel [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", foodCart=" + foodCart + ", email=" + email + "]";
	}





	
	
	
	
	


}
