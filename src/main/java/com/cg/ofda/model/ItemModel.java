package com.cg.ofda.model;

import java.math.BigDecimal;
import java.util.List;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ItemModel {

	/*
	 * All the private members are validate here with suitable datatypes
	 * 
	 */
	/*	To validate itemId cannot be null but can be empty*/
	@NotNull(message = "Item id cannot be null")
	private Long itemId;

	/*	To validate itemName cannot be null and size>0*/
	@NotEmpty(message = " item Name cannot be empty")
	/*	To validate itemName cannot be null but can be empty*/
	@NotNull(message = " item Name cannot be omitted")
	private String itemName;

	/*	To validate category cannot be null and size>0*/
	@NotEmpty(message = " category cannot be empty")
	/*	To validate category cannot be null but can be empty*/
	@NotNull(message = " category cannot be omitted")
	private CategoryModel category;

	/*To check minimum quantity*/
	@Min(value = 1, message = "min quantity should be 1")
	private int quantity;

	/*	To validate cost cannot be null but can be empty*/
	@NotNull(message = " cost cannot be null")
	private BigDecimal cost;

	/*	To validate restaurants cannot be null and size>0*/
	@NotEmpty(message = " Restaurants cannot be empty")
	/*	To validate restaurants cannot be null but can be empty*/
	@NotNull(message = " Restaurants cannot be omitted")
	private List<RestaurantModel> restaurants;

	/*	To validate foodCart cannot be null and size>0*/
	@NotEmpty(message = "foodCart cannot be empty")
	/*	To validate foodCart cannot be null but can be empty*/
	@NotNull(message = "foodCart cannot be omitted")
	private FoodCartModel foodCart;

	/*
	 * A default Constructor with no implementation
	 */
	public ItemModel() {
		// default
	}
	
	/*
	 * A Parameterized Constructor for assigning the values to private members
	 * */

	public ItemModel(@NotNull(message = "Item id cannot be null") Long itemId,
			@NotEmpty(message = " item Name cannot be empty") @NotNull(message = " item Name cannot be omitted") String itemName,
			@NotEmpty(message = " category cannot be empty") @NotNull(message = " category cannot be omitted") CategoryModel category,
			@Min(value = 1, message = "min quantity should be 1") int quantity,
			@NotNull(message = " cost cannot be null") BigDecimal cost,
			@NotEmpty(message = " Restaurants cannot be empty") @NotNull(message = " Restaurants cannot be omitted") List<RestaurantModel> restaurants,
			@NotEmpty(message = "foodCart cannot be empty") @NotNull(message = "foodCart cannot be omitted") FoodCartModel foodCart) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.cost = cost;
		this.restaurants = restaurants;
		this.foodCart = foodCart;
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

	public CategoryModel getCategory() {
		return category;
	}

	public void setCategory(CategoryModel category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public List<RestaurantModel> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<RestaurantModel> restaurants) {
		this.restaurants = restaurants;
	}

	public FoodCartModel getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCartModel foodCart) {
		this.foodCart = foodCart;
	}

	/* 
	 * Corresponding HashCode and Equals methods 
	 * 
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((foodCart == null) ? 0 : foodCart.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + quantity;
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
		ItemModel other = (ItemModel) obj;
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
		if (quantity != other.quantity)
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
		return "ItemModel [itemId=" + itemId + ", itemName=" + itemName + ", category=" + category + ", quantity="
				+ quantity + ", cost=" + cost + ", restaurants=" + restaurants + ", foodCart=" + foodCart + "]";
	}
	
	

}