package com.cg.ofda.model;

import javax.validation.constraints.Pattern;

public class LoginModel {

	
	/*
	 * All the private members are validate here with suitable datatypes
	 * 
	 */
	/*For checking the pattern of userid*/
	@Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = "UserId should be valid")
	private Long userid;

	/*For checking the pattern of userName*/
	@Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = "Username should be valid")
	private String userName;

	/*For checking the pattern of password*/
	@Pattern(regexp = "[a-zA-Z0-9]{8,14}", message = "Password should be valid")
	private String password;

	/*
	 * A default Constructor with no implementation
	 */
	public LoginModel() {
		// default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */
	public LoginModel(@Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = "UserId should be valid") Long userid,
			@Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = "Username should be valid") String userName,
			@Pattern(regexp = "[a-zA-Z0-9]{8,14}", message = "Password should be valid") String password) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.password = password;
	}

	/*
	 * Corresponding Getters and Setters for private members
	 * 
	 */
	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * Corresponding HashCode and Equals methods
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
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
		LoginModel other = (LoginModel) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}

	/*
	 * toString() method overridden here
	 * 
	 */

	@Override
	public String toString() {
		return "LoginModel [userid=" + userid + ", userName=" + userName + ", password=" + password + "]";
	}

}