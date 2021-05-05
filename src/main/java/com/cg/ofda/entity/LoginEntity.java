package com.cg.ofda.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* This is an Entity class
 * 
 * 
 */
@Entity
/*To create table "login"*/
@Table(name = "login")
public class LoginEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * All the private members are defined here with suitable datatypes
	 * 
	 */

	@Id
	/*To create user_id column*/
	@Column(name = "user_id", length = 19)
	private Long userid;

	/*To create user_name column*/
	@Column(name = "user_name", unique = true, length = 50)
	private String userName;

	/*To create password column*/
	@Column(name = "password", length = 50)
	private String password;

	/*
	 * A default Constructor with no implementation
	 */
	public LoginEntity() {
		// default
	}

	/*
	 * A Parameterized Constructor for assigning the values to private members
	 */

	public LoginEntity(Long userId,String userName, String password) {
		super();
		this.userid=userId;
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

	/* HashCode and Equals*/
	
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
		LoginEntity other = (LoginEntity) obj;
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
		return String.format("Login [userid=%s, userName=%s, password=%s]", userid, userName, password);
	}

	

}
