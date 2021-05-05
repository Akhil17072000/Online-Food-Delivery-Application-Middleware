package com.cg.ofda.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* This is an Entity class
 * 
 * 
 */
@Entity
/*To create table "items"*/
@Table(name="items")
public class ItemEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;


	/* All the private members are defined here with suitable datatypes
	 * 
	 */
	
	@Id
	/*For creating item_id column*/
	@Column(name="item_id",length=19)
	private Long itemId;
	
	/*For creating item_name column*/
	@Column(name="item_name",length=30)
	private String itemName;
	
	/*Specifies ManyToOne relationship*/
	@ManyToOne
	@JoinColumn(name="cat_id")
	private CategoryEntity category;
	
	/*For creating quantity column*/
	@Column(name="quantity")
	private Integer quantity;
	
	/*For creating cost column*/
	@Column(name="cost")
	private BigDecimal cost;
	
	/*Specifies ManyToMany relationship*/ 
	@ManyToMany(mappedBy="itemList" ,cascade= CascadeType.ALL)
	private List<RestaurantEntity> restaurants;
	
	/*Specifies ManyToOne relationship*/
	@ManyToOne
	@JoinColumn(name="cart_id")
	private FoodCartEntity foodCart;
	
	
	/*
	 * A default Constructor with no implementation
	 * */
	public ItemEntity() {
		//default
	}


	/*
	 * A Parameterized Constructor for assigning the values to private members
	 * */
	
	public ItemEntity(Long itemId, String itemName,CategoryEntity category,Integer quantity, BigDecimal cost,
			List<RestaurantEntity> restaurants,FoodCartEntity foodCart) {
		super();
		this.itemId=itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurants = restaurants;
		this.foodCart=foodCart;
	}

	

	/* 
	 * Corresponding Getters and Setters for private members
	 * 
	 * */
	
	public Long getItemId() {
		return itemId;
	}

	
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public List<RestaurantEntity> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<RestaurantEntity> restaurants) {
		this.restaurants = restaurants;
	}

	

	
	public FoodCartEntity getFoodCart() {
		return foodCart;
	}


	public void setFoodCart(FoodCartEntity foodCart) {
		this.foodCart = foodCart;
	}
	
	
	
	/* HashCode and Equals */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((foodCart == null) ? 0 : foodCart.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((restaurants == null) ? 0 : restaurants.hashCode());
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
		ItemEntity other = (ItemEntity) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (foodCart == null) {
			if (other.foodCart != null)
				return false;
		} else if (!foodCart.equals(other.foodCart))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (restaurants == null) {
			if (other.restaurants != null)
				return false;
		} else if (!restaurants.equals(other.restaurants))
			return false;
		return true;
	}

	
	
	/* 
	 *toString() method overridden here
	 * 
	 * */
	

	

	@Override
	public String toString() {
		return String.format(
				"ItemEntity [itemId=%s, itemName=%s, category=%s, quantity=%s, cost=%s, restaurants=%s, foodCart=%s]",
				itemId, itemName, category, quantity, cost, restaurants, foodCart);
	}


}
