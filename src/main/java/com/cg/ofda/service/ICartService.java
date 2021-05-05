package com.cg.ofda.service;

import java.util.List;

import com.cg.ofda.exception.CartException;
import com.cg.ofda.model.FoodCartModel;

public interface ICartService {

	
	/* Definition of addCart for adding cart*/
	public FoodCartModel addCart(FoodCartModel cart) throws CartException;
	
	
	/* Definition of updateCart for updating cart */
	public FoodCartModel updateCart(FoodCartModel cart) throws CartException;
	

	
	/* Definition of removeItem method for removing items from FoodCart */
	public boolean removeCart(Long cartId) throws CartException;
	
	
	/*Definition of view cart method for viewing a cart using cartId */
	public FoodCartModel viewCart(Long cartId) throws CartException;
	
	/*Definition of cart method for viewing all carts */
	public List<FoodCartModel> viewAllCarts() throws CartException;

	/* Definition of clearCart method for clearing FoodCart */
	public FoodCartModel clearCart(FoodCartModel cart) throws CartException;
	
	
	

}