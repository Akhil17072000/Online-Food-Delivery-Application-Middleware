package com.cg.ofda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofda.exception.CartException;
import com.cg.ofda.model.FoodCartModel;
import com.cg.ofda.service.ICartService;


@RestController
@RequestMapping(path="/cart")
public class CartRestController {
	
	/*
	 * Cart Service is Autowired 
     */
	
	@Autowired
	private ICartService cartService;
	/*
	 * to retrieve all carts
	 * return : List<carts>
	 * params : NILL
	 */
	@GetMapping
	public ResponseEntity<List<FoodCartModel>> viewAllCarts() throws CartException {
		 return new ResponseEntity<>(cartService.viewAllCarts(), HttpStatus.OK);
		
	}
	
	/*
	 * to add a cart
	 * return : cart
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<FoodCartModel>addCart(@RequestBody FoodCartModel cart)throws CartException{
		cart=cartService.addCart(cart);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}
	
	/*
	 * to modify a cart
	 * return : cart
	 * params : NIL
	 */
	@PutMapping
	public ResponseEntity<FoodCartModel> updateCart(@RequestBody FoodCartModel cart) throws CartException {
		cart = cartService.updateCart(cart);
		 return new ResponseEntity<>(cart, HttpStatus.OK);
		
	}
	/*
	 * to delete a cart
	 * return : void
	 * params : cartId
	 */
	@DeleteMapping("/{cartId}")
	public ResponseEntity<Void> deleteCart(@PathVariable("cartId") Long cartId) throws CartException{
		ResponseEntity<Void> response = null;
		FoodCartModel cart = cartService.viewCart(cartId);
		/*Checking whether the cartId is valid for existing cart*/
		if (cart == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			cartService.removeCart(cartId);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		}
		return response;
	}
	/*
	 * to retrieve a cart
	 * return : cart
	 * params : cartId
	 */
	@GetMapping("/{cartId}")
	public ResponseEntity<FoodCartModel> viewCart(@PathVariable("cartId") Long cartId) throws CartException {
		ResponseEntity<FoodCartModel> response = null;
		FoodCartModel cart = cartService.viewCart(cartId);
		
		if (cart == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			response = ResponseEntity.ok(cart);
		}
		return response;
	}
	/*
	 * to clear the cart
	 * return : void
	 * params : cart
	 */
		
	@DeleteMapping()
	public ResponseEntity<FoodCartModel> clearcart(@PathVariable("cart") FoodCartModel cart) throws CartException{
		ResponseEntity<FoodCartModel> response = null;
		FoodCartModel foodCart=cartService.clearCart(cart);
		if(foodCart == null) {
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
		
	}
	
}
		
	

