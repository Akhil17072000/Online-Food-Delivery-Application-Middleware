package com.cg.ofda.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.FoodCartEntity;
import com.cg.ofda.model.FoodCartModel;
import com.cg.ofda.repository.ICartRepository;

@Service
public class EMParserFoodCart {
	
	/*
	 * Cart Repository is Autowired
     */
	
	@Autowired
	private ICartRepository cartRepo;
	
	/*
	 * EMParserCustomer is Autowired
     */
	
	@Autowired
	private EMParserCustomer customerParser;
	
	/*
	 * Default constructor 
     */
	
	public EMParserFoodCart() {
		this.customerParser= new EMParserCustomer();
	}
	
	/*
	 * Parameterized constructor 
     */
	
	public EMParserFoodCart(ICartRepository cartRepo) {
		super();
		this.cartRepo = cartRepo;
		this.customerParser= new EMParserCustomer();
	}

	/*
	 * Method to parse Entity to Model
     */

	public FoodCartModel parse(FoodCartEntity source) {
		return source==null ? null:
			new FoodCartModel (source.getCartId(),
					customerParser.parse(source.getCustomer()));
	}
	
	/*
	 * Method to parse Model to Entity
     */
	
	public FoodCartEntity parse(FoodCartModel source) {
		return source==null ? null:
			new FoodCartEntity (source.getCartId(),
					customerParser.parse(source.getCustomer()));
	}

}
