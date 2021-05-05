package com.cg.ofda.exception;

public class LoginException extends Exception {

	private static final long serialVersionUID = 1L;
	/* UserDefined Exception for Login*/
	public LoginException(String errorMessege) {
		super(errorMessege);
	}
}
	
