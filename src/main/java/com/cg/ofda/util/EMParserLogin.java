package com.cg.ofda.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.LoginEntity;

import com.cg.ofda.model.LoginModel;
import com.cg.ofda.repository.ILoginRepository;

@Service
public class EMParserLogin {
	
	/*
	 * Login Repository is Autowired
     */
	
	@Autowired
	private ILoginRepository loginRepo;
	
	/*
	 * Default constructor 
     */

	public EMParserLogin() {
		
	}
	
	/*
	 * Parameterized constructor 
     */

	public EMParserLogin(ILoginRepository loginRepo) {
		super();
		this.loginRepo = loginRepo;
	}
	
	/*
	 * Method to parse Entity to Model
     */

	public LoginModel parse(LoginEntity source) {
		return source == null ? null : new LoginModel(source.getUserid(), source.getUserName(), source.getPassword());

	}
	
	/*
	 * Method to parse Model to Entity
     */

	public LoginEntity parse(LoginModel source) {
		return source == null ? null : new LoginEntity(source.getUserid(), source.getUserName(), source.getPassword());
	}
}