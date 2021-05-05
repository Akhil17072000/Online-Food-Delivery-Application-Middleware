package com.cg.ofda.exception;

public class CartException extends Exception {

	private static final long serialVersionUID = 1L;
	/* UserDefined Exception for Cart*/
	public CartException(String errorMessege) {
		super(errorMessege);
	}
}
