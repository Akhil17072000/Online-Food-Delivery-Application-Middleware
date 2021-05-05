package com.cg.ofda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ofda.entity.LoginEntity;
import com.cg.ofda.exception.LoginException;
import com.cg.ofda.model.LoginModel;
import com.cg.ofda.repository.ILoginRepository;

@ExtendWith(MockitoExtension.class)
public class LoginServiceImplTest {

	/* Mocking the Repository */
	@Mock
	private ILoginRepository loginRepository;

	/*
	 * injecting package repository marked as @Mock into package service
	 * implementation
	 */
	@InjectMocks
	private LoginServiceImpl loginService;

	/*
	 * For SignIn a user
	 */
	@Test
	@DisplayName("LoginServiceImpl : signIn method to signIn a user by validating his details")
	public void testSignIn() throws LoginException {

		LoginEntity testData = new LoginEntity(101L, "Ramesh1010", "Ramesh1010");
		LoginModel expected = new LoginModel(101L, "Ramesh1010", "Ramesh1010");

		String expectedStr = "Welcome User Login Successfull";
		Mockito.when(loginRepository.findById(testData.getUserid())).thenReturn(Optional.of(testData));
		String result = loginService.signIn(expected.getUserid());
		assertEquals(expectedStr, result);
	}

}
