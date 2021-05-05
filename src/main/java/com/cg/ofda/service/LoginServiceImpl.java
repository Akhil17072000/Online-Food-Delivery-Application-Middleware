package com.cg.ofda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.LoginEntity;
import com.cg.ofda.exception.LoginException;
import com.cg.ofda.model.LoginModel;
import com.cg.ofda.repository.ILoginRepository;
import com.cg.ofda.util.EMParserLogin;

@Service
public class LoginServiceImpl implements ILoginService {
	
	/*
	 * Login Repository is Autowired 
     */

	@Autowired
	private ILoginRepository loginRepository;
	
	/*
	 * EMParserLogin is Autowired 
     */

	@Autowired
	private EMParserLogin parser;
	
	/*
	 * Default Constructor
     */

	public LoginServiceImpl() {
		this.parser = new EMParserLogin();
	}
	
	
	/*Parameterized constructor for assigning
	 * */

	public LoginServiceImpl(ILoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
		this.parser = new EMParserLogin();
	}

	

	/*
	 * Implementation of signIn method to signIn a user
	 */	
	@Override
	public String signIn(Long id) throws LoginException {

		LoginEntity logEn = loginRepository.findById(id).orElse(null);
		if(logEn==null)
			throw new LoginException("id not found");
		LoginModel logMod = parser.parse(logEn);

		if (logMod == null)
			throw new LoginException("Invalid User");

		Long userId = logMod.getUserid();
		String userName = logMod.getUserName();
		String password = logMod.getPassword();

		Long entityUserId = logEn.getUserid();
		String entityUserName = logEn.getUserName();
		String entityPassword = logEn.getPassword();

		if (userId.equals(entityUserId) && userName.equals(entityUserName) && password.equals(entityPassword))
			return "Welcome User Login Successfull";

		else
			throw new LoginException("Couldn't SignIn");
	}

	/*
	 * Implementation of signOut method to signOut a user
	 */

	@Override
	public boolean signOut(LoginModel login) throws LoginException {
		// implementation is done during front end
		return false;
	}

}