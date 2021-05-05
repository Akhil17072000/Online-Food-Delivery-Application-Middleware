package com.cg.ofda.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.FoodCartEntity;
import com.cg.ofda.exception.CartException;
import com.cg.ofda.model.FoodCartModel;
import com.cg.ofda.repository.ICartRepository;
import com.cg.ofda.util.EMParserFoodCart;

@Service
public class CartServiceImpl implements ICartService {
	
	/*
	 * Cart Repository is Autowired 
     */

	@Autowired
	private ICartRepository cartRepo;
	
	/*
	 * EMParserFoodCart is Autowired 
     */

	@Autowired
	private EMParserFoodCart parser;
	
	/*Default Constructor*/

	public CartServiceImpl() {
		this.parser = new EMParserFoodCart();
	}
	
	/*Parameterized Constructor*/

	public CartServiceImpl(ICartRepository cartRepo) {
		super();
		this.cartRepo = cartRepo;
		this.parser = new EMParserFoodCart();
	}


	/* Implementaion of removeCart to remove the existing cart */

	@Transactional
	@Override
	public boolean removeCart(Long cartId) throws CartException {

		FoodCartEntity oldCart = cartRepo.findById(cartId).orElse(null);
		boolean isDeleted = false;
		if (oldCart == null) {
			throw new CartException("no cart with id #" + cartId + " present");
		} else {
			cartRepo.deleteById(cartId);
			isDeleted = true;
		}
		return isDeleted;
	}

	/* Implementaion of addCart to add a new cart */

	@Transactional
	@Override
	public FoodCartModel addCart(FoodCartModel cart) throws CartException {

		if (cart != null) {
			if (cartRepo.existsById(cart.getCartId())) {
				throw new CartException("Cart with this id already exists");
			}
			cart = parser.parse(cartRepo.save(parser.parse(cart)));
		}
		return cart;

	}

	/* Implementation of updateCart to update the existing cart */

	@Transactional
	@Override
	public FoodCartModel updateCart(FoodCartModel cart) throws CartException {
		FoodCartEntity cart1 = cartRepo.findById(cart.getCartId()).orElse(null);
		if (cart1 == null) {
			throw new CartException("no cart with id #" + cart.getCartId() + " present");
		}
		cart = parser.parse(cartRepo.save(parser.parse(cart)));
		return cart;
	}

	/* Implementaion of clearCart to clear all the carts */

	@Transactional
	@Override
	public FoodCartModel clearCart(FoodCartModel cart) throws CartException {
		cartRepo.deleteAll();
		return cart;
	}

	/* Implementation of viewCart to view the existing cart */

	@Transactional
	@Override
	public FoodCartModel viewCart(Long cartId) throws CartException {

		FoodCartEntity foodCart = cartRepo.findById(cartId).orElse(null);
		if (foodCart == null) {
			throw new CartException("cart with id #" + cartId + " not exists");
		}
		return parser.parse(cartRepo.findById(cartId).orElse(null));
	}

	/* Implementation of viewCart to view all the carts */

	@Transactional
	@Override
	public List<FoodCartModel> viewAllCarts() throws CartException {

		return cartRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

}