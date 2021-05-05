package com.cg.ofda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cg.ofda.model.AddressModel;

/* This is an Entity class
 * 
 * 
 */
@Entity
/*To create table "restaurants"*/
@Table(name = "restaurants")
public class RestaurantEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	@Id
	/*To create column "restaurant_id"*/
	@Column(name = "restaurant_id", length = 19)
	private Long restaurantId;

	/*To create column "restaurant_name"*/
	@Column(name = "restaurant_name", length = 30)
	private String restaurantName;

	/*To embed address from AddressModel*/
	@Embedded
	private AddressModel address;

	/*To specify ManyToMany relationship*/
	@ManyToMany
	@JoinTable(
			  name = "restaurant_item_list", 
			  joinColumns = @JoinColumn(name = "item_id"), 
			  inverseJoinColumns = @JoinColumn(name = "restaurant_id"))
	private List<ItemEntity> itemList;

	/*To create column "manager_name"*/
	@Column(name = "manager_name", length = 30)
	private String managerName;
 
	/*To create column "contact_number"*/
	@Column(name = "contact_number", length = 50)
	private String contactNumber;

	/*
	 * A default Constructor with no implementation
	 */
	public RestaurantEntity() {
		// default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public RestaurantEntity(Long restaurantId,String restaurantName, AddressModel address, List<ItemEntity> itemList,
			String managerName, String contactNumber) {
		super();
		this.restaurantId=restaurantId;
		this.restaurantName = restaurantName;
		this.address = address;
		this.itemList = itemList;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
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

	public List<ItemEntity> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemEntity> itemList) {
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

	
	
	/* hashCode and Equals*/
	
	
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
		RestaurantEntity other = (RestaurantEntity) obj;
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
		return String.format(
				"Restaurant [restaurantId=%s, restaurantName=%s, address=%s, itemList=%s, managerName=%s, contactNumber=%s]",
				restaurantId, restaurantName, address, itemList, managerName, contactNumber);
	}

	

}
