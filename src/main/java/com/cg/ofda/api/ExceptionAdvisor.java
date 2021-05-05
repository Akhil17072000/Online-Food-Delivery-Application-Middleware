package com.cg.ofda.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofda.exception.BillException;
import com.cg.ofda.exception.CartException;
import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.exception.ItemException;
import com.cg.ofda.exception.LoginException;
import com.cg.ofda.exception.OFDAException;
import com.cg.ofda.exception.OrderException;
import com.cg.ofda.exception.RestaurantException;

@RestControllerAdvice
public class ExceptionAdvisor {

	/* 
	 * For Bill Exception
	 */
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<String> handleBillExceptionAction(BillException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/* 
	 * For Cart Exception 
	 */

	@ExceptionHandler(CartException.class)
	public ResponseEntity<String> handleCartExceptionAction(CartException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/* 
	 * For Category Exception 
	 */

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<String> handleCategoryExceptionAction(CategoryException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/*
	 * For Customer Exception 
	 */
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String> handleCustomerExceptionAction(CustomerException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * For Item Exception
	 */

	@ExceptionHandler(ItemException.class)
	public ResponseEntity<String> handleItemExceptionAction(ItemException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * For Order Exception 
	 */

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<String> handleOrderExceptionAction(OrderException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/*
	 * For Restaurant Exception 
	 */

	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<String> handleRestaurantExceptionAction(RestaurantException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/* 
	 * For Login Exception 
	 */

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<String> handleLoginExceptionAction(LoginException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/* 
	 * For OFDA Exception 
	 */

	@ExceptionHandler(OFDAException.class)
	public ResponseEntity<String> handleOFDAExceptionAction(OFDAException excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/* 
	 * For internal server error 
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleExceptionAction(Exception excep) {
		return new ResponseEntity<>(excep.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
