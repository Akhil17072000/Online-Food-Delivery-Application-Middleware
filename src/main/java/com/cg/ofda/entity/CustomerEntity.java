package com.cg.ofda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.ofda.model.AddressModel;

/* This is an Entity class
 * 
 * 
 */
@Entity
/*For specifying name of table as "customers"*/
@Table(name = "customers")
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */

	@Id
	/*For creating "cust_id" column*/
	@Column(name = "cust_id", length = 19)
	private Long customerId;

	/*For creating "first_name" column*/
	@Column(name = "first_name", length = 50)
	private String firstName;

	/*For creating "last_name" column*/
	@Column(name = "last_name", length = 50)
	private String lastName;

	/*For creating "gender" column*/
	@Column(name = "gender", length = 50)
	private String gender;

	/*For creating "age" column*/
	@Column(name = "age", length = 50)
	private String age;

	/*For creating "mobile" column*/
	@Column(name = "mobile", length = 50)
	private String mobileNumber;

	/*Here address is embedded from AddressModel*/
	@Embedded
	private AddressModel address;

	/*To specify OneToOne relationship*/
	@OneToOne(mappedBy = "customer")
	private FoodCartEntity foodCart;

	/*For creating "email" column*/
	@Column(name = "email", length = 50)
	private String email;

	/*
	 * A default Constructor with no implementation
	 */
	public CustomerEntity() {
//		default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public CustomerEntity( Long customerId, String firstName, String lastName, String gender, String age,
			String mobileNumber, AddressModel address, String email) {
		super();
		this.customerId=customerId;
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
	 */

	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	
	/*hashcode and equals
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
		CustomerEntity other = (CustomerEntity) obj;
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

	/*
	 * toString() method overridden here
	 * 
	 */
	@Override
	public String toString() {
		return String.format(
				"CustomerEntity [customerId=%s, firstName=%s, lastName=%s, gender=%s, age=%s, mobileNumber=%s, address=%s, foodCart=%s, email=%s]",
				customerId, firstName, lastName, gender, age, mobileNumber, address, foodCart, email);
	}
	
	

}
