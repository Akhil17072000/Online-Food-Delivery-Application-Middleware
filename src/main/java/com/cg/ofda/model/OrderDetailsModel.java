package com.cg.ofda.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class OrderDetailsModel {

	/*
	 * All the private members are validate here with suitable datatypes
	 * 
	 */

	/*	To validate orderId cannot be null but can be empty*/
	@NotNull(message = "Order id cannot be null")
	private Long orderId;

	/*To format as date/time*/
	@DateTimeFormat(iso = ISO.DATE)
	/*To check date is not a future date*/
	@PastOrPresent(message = "disbursement date cannot be future date")
	private LocalDateTime orderDate;

	/*	To validate cart cannot be null and size>0*/
	@NotEmpty(message = "foodCart cannot be empty")
	/*	To validate cart cannot be null but can be empty*/
	@NotNull(message = "foodCart cannot be omitted")
	private FoodCartModel cart;


	/*	To validate orderStatus cannot be null but can be empty*/
	@NotNull(message = "Order Status cannot be null")
	private String orderStatus;

	/*	To validate bill cannot be null and size>0*/
	@NotEmpty(message = "bill cannot be empty")

	/*	To validate bill cannot be null but can be empty*/
	@NotNull(message = "bill cannot be omitted")
	private BillModel bill;

	/*
	 * A default Constructor with no implementation
	 */
	public OrderDetailsModel() {
		// default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public OrderDetailsModel(@NotNull(message = "Order id cannot be null") Long orderId,
			@PastOrPresent(message = "disbursement date cannot be future date") LocalDateTime orderDate,
			@NotEmpty(message = "foodCart cannot be empty") @NotNull(message = "foodCart cannot be omitted") FoodCartModel cart,
			@NotNull(message = "Order Status cannot be null") String orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.cart = cart;
		this.orderStatus = orderStatus;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public FoodCartModel getCart() {
		return cart;
	}

	public void setCart(FoodCartModel cart) {
		this.cart = cart;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/*
	 * Corresponding HashCode and Equals methods
	 * 
	 */
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
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
		OrderDetailsModel other = (OrderDetailsModel) obj;
		if (bill == null) {
			if (other.bill != null)
				return false;
		} else if (!bill.equals(other.bill))
			return false;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderStatus == null) {
			if (other.orderStatus != null)
				return false;
		} else if (!orderStatus.equals(other.orderStatus))
			return false;
		return true;
	}
	
	
	
	/*
	 * toString() method overridden here
	 * 
	 */

	@Override
	public String toString() {
		return "OrderDetailsModel [orderId=" + orderId + ", orderDate=" + orderDate + ", cart=" + cart
				+ ", orderStatus=" + orderStatus + ", bill=" + bill + "]";
	}

	
}