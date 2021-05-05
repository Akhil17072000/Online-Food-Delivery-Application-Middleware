package com.cg.ofda.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class BillModel{
	 

	/*
	 * All the private members are validate here with suitable datatypes
	 * 
	 */
	/*	To validate billId cannot be null but can be empty*/
	@NotNull(message="bill id cannot be null")
    private Long billId;
	
	/*	To validate order cannot be null and size>0*/
	@NotEmpty(message="OrderDetails cannot be empty")
	/*	To validate order cannot be null but can be empty*/
	@NotNull(message="OrderDetails cannot be omitted")
    private OrderDetailsModel order;
    
	/*	To validate totalItem cannot be null but can be empty*/
	@NotNull(message=" total Item cannot be null")
    private int totalItem;
    
	/*	To validate totalCost cannot be null but can be empty*/
	@NotNull(message=" total cost cannot be null")
    private BigDecimal totalCost;

	/*To format date/time*/
	@DateTimeFormat(iso=ISO.DATE)
	/*To check date is not a future date*/
	@PastOrPresent(message="disbursement date cannot be future date")
    LocalDateTime billDate;

	
	
	/*
	 * A default Constructor with no implementation
	 * */
	public BillModel() {
		//default
	}
	
	
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 * */
	
	public BillModel(@NotNull(message = "bill id cannot be null") Long billId,
			@NotEmpty(message = "OrderDetails cannot be empty") @NotNull(message = "OrderDetails cannot be omitted") OrderDetailsModel order,
			@NotNull(message = " total Item cannot be null") int totalItem,
			@NotNull(message = " total cost cannot be null") BigDecimal totalCost,
			@PastOrPresent(message = "disbursement date cannot be future date") LocalDateTime billDate) {
		super();
		this.billId = billId;
		this.order = order;
		this.totalItem = totalItem;
		this.totalCost = totalCost;
		this.billDate = billDate;
	}


	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */

	public Long getBillId() {
		return billId;
	}


	public @NotEmpty(message = "OrderDetails cannot be empty") @NotNull(message = "OrderDetails cannot be omitted") OrderDetailsModel getOrder() {
		return order;
	}

	public void setOrder
	(@NotEmpty(message = "OrderDetails cannot be empty") 
	@NotNull(message = "OrderDetails cannot be omitted") OrderDetailsModel order) {
		this.order = order;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}
	
	/* 
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
		result = prime * result + totalItem;
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
		BillModel other = (BillModel) obj;
		if (billDate == null) {
			if (other.billDate != null)
				return false;
		} else if (!billDate.equals(other.billDate))
			return false;
		if (billId == null) {
			if (other.billId != null)
				return false;
		} else if (!billId.equals(other.billId))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		if (totalItem != other.totalItem)
			return false;
		return true;
	}

	


	/* 
	 *toString() method overridden here
	 * 
	 * */
	@Override
	public String toString() {
		return "BillModel [billId=" + billId + ", order=" + order + ", totalItem=" + totalItem + ", totalCost="
				+ totalCost + ", billDate=" + billDate + "]";
	}



	
	
	
	
	
}