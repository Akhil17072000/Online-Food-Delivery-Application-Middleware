package com.cg.ofda.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/* This is an Entity class*/
@Entity

/* Here name of the table is set as "bill" */
@Table(name = "bill")
public class BillEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */
	/* For creating bill_id column */
	@Id
	@Column(name = "bill_id", length = 19)
	private Long billId;

	/* To specify OneToOne relationship */
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "order_id")
	private OrderDetailsEntity order;

	/* For specifying total items in bill */
	@Column(name = "total_item")
	private Integer totalItem;

	/* For specifying total cost */
	@Column(name = "total_cost")
	private BigDecimal totalCost;

	/* For specifying bill date */
	@Column(name = "bill_date")
	LocalDateTime billDate;

	/*
	 * A default Constructor with no implementation
	 */
	public BillEntity() {
		// default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public BillEntity(Long billId, OrderDetailsEntity order, Integer totalItem, BigDecimal totalCost,
			LocalDateTime billDate) {
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

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public OrderDetailsEntity getOrder() {
		return order;
	}

	public void setOrder(OrderDetailsEntity order) {
		this.order = order;
	}

	public Integer getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(Integer totalItem) {
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

	/*Generate corresponding hashCode and equals*/
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((billId == null) ? 0 : billId.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
		result = prime * result + ((totalItem == null) ? 0 : totalItem.hashCode());
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
		BillEntity other = (BillEntity) obj;
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
		if (totalItem == null) {
			if (other.totalItem != null)
				return false;
		} else if (!totalItem.equals(other.totalItem))
			return false;
		return true;
	}
	

	/*
	 * toString() method overridden here
	 * 
	 */

	@Override
	public String toString() {
		return String.format("BillEntity [billId=%s, order=%s, totalItem=%s, totalCost=%s, billDate=%s]", billId, order,
				totalItem, totalCost, billDate);
	}

	

}
