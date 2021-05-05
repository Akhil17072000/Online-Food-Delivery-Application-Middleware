package com.cg.ofda.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RestaurantModel {
	
	/*
	 * All the private members are validate here with suitable datatypes
	 * 
	 */
	/*	To validate restaurantId cannot be null but can be empty*/
	@NotNull(message = "restaurant id cannot be null")
	private Long restaurantId;

	/*	To validate restaurantName cannot be null and size>0*/
	@NotEmpty(message = "restaurantNamecannot be empty")
	/*	To validate restaurantName cannot be null but can be empty*/
	@NotNull(message = "restaurantName cannot be omitted")
	private String restaurantName;

	/*To validate address*/
	@Valid
	private AddressModel address;

	/*	To validate itemList cannot be null and size>0*/
	@NotEmpty(message = "itemList cannot be empty")
	/*	To validate itemList cannot be null but can be empty*/
	@NotNull(message = "itemList cannot be omitted")
	private List<ItemModel> itemList;

	/*	To validate managerName cannot be null and size>0*/
	@NotEmpty(message = "Manager Name cannot be empty")
	/*	To validate managerName cannot be null but can be empty*/
	@NotNull(message = "Manager Name cannot be omitted")
	private String managerName;

	/*To check minimum digits of contact number*/
	@Min(value = 10, message = "contactNumber cannot be empty and should be of 10 digit")
	/*To check maximum digits of contact number*/
	@Max(value = 10, message = "contactNumber cannot be empty and should be of 10 digit")
	private String contactNumber;

	/*
	 * A default Constructor with no implementation
	 */
	public RestaurantModel() {
		// default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	
	public RestaurantModel(@NotNull(message = "restaurant id cannot be null") Long restaurantId,
			@NotEmpty(message = "restaurantNamecannot be empty") @NotNull(message = "restaurantName cannot be omitted") String restaurantName,
			@Valid AddressModel address,
			@NotEmpty(message = "itemList cannot be empty") @NotNull(message = "itemList cannot be omitted") List<ItemModel> itemList,
			@NotEmpty(message = "Manager Name cannot be empty") @NotNull(message = "Manager Name cannot be omitted") String managerName,
			@Min(value = 10, message = "contactNumber cannot be empty and should be of 10 digit") @Max(value = 10, message = "contactNumber cannot be empty and should be of 10 digit") String contactNumber) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}
	
	/* 
	 * Corresponding Getters and Setters for private members
	 * 
	 * */

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public AddressModel getAddress() {
		return address;
	}

	public void setAddress(AddressModel address) {
		this.address = address;
	}

	public List<ItemModel> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemModel> itemList) {
		this.itemList = itemList;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	/* 
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
		result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result + ((restaurantId == null) ? 0 : restaurantId.hashCode());
		result = prime * result + ((restaurantName == null) ? 0 : restaurantName.hashCode());
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
		RestaurantModel other = (RestaurantModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (restaurantId == null) {
			if (other.restaurantId != null)
				return false;
		} else if (!restaurantId.equals(other.restaurantId))
			return false;
		if (restaurantName == null) {
			if (other.restaurantName != null)
				return false;
		} else if (!restaurantName.equals(other.restaurantName))
			return false;
		return true;
	}
	/*
	 * toString() method overridden here
	 * 
	 */

	@Override
	public String toString() {
		return "RestaurantModel [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + ", itemList=" + itemList + ", managerName=" + managerName + ", contactNumber="
				+ contactNumber + "]";
	}

	
	
	

}