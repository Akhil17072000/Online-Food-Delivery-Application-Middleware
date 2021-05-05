package com.cg.ofda.exception;

public class OrderException extends Exception {

	private static final long serialVersionUID = 1L;
	/* UserDefined Exception for Order*/
	public OrderException(String errorMessege) {
		super(errorMessege);
	}
}
	