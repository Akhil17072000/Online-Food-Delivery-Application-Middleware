	package com.cg.ofda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* This is an Entity class
 * 
 * 
 */

@Entity
/*To set table name as "food_cart"*/
@Table(name="food_cart")
public class FoodCartEntity implements Serializable{
	



	private static final long serialVersionUID = 1L;
	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	
	@Id
	/*To create cart_id column */
	@Column(name="cart_id",length=19)
	private Long cartId;
	
	/*To specify OneToOne relationship*/
	@OneToOne
	@JoinColumn(name="cust_id")
	private CustomerEntity customer;
	
	/*To specify OneToMany relationship*/
	@OneToMany(mappedBy = "foodCart",cascade=CascadeType.ALL)
	private List<ItemEntity> itemList;
	
	/*To specify OneToOne relationship*/
	@OneToOne(mappedBy ="cart",cascade=CascadeType.PERSIST)
	private OrderDetailsEntity orderDetails;
	
	/*
	 * A default Constructor with no implementation
	 * */
	
	public FoodCartEntity() {
		//default
	}
	
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 * */
	

	public FoodCartEntity(Long cartId,CustomerEntity customer) {
		super();
		this.cartId=cartId;
		this.customer = customer;
	}

	
	/* 
	 * Corresponding Getters and Setters for private members
	 * 
	 * */
	
	public Long getCartId() {
		return cartId;
	}
	

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	
	public List<ItemEntity> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemEntity> itemList) {
		this.itemList = itemList;
	}

	/* Corresponding HashCode and Equals */
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((itemList == null) ? 0 : itemList.hashCode());
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
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
		FoodCartEntity other = (FoodCartEntity) obj;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (itemList == null) {
			if (other.itemList != null)
				return false;
		} else if (!itemList.equals(other.itemList))
			return false;
		if (orderDetails == null) {
			if (other.orderDetails != null)
				return false;
		} else if (!orderDetails.equals(other.orderDetails))
			return false;
		return true;
	}

	
	
	
	/*
	 * toString() method overridden here
	 * 
	 */
	
	
	
	
	@Override
	public String toString() {
		return String.format("cartId=%s, customer=%s, ", cartId, customer);
	}

	
	
	

}
