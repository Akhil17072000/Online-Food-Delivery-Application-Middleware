package com.cg.ofda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.ofda.entity.CustomerEntity;
import com.cg.ofda.entity.FoodCartEntity;
import com.cg.ofda.exception.CartException;
import com.cg.ofda.model.AddressModel;
import com.cg.ofda.model.CustomerModel;
import com.cg.ofda.model.FoodCartModel;
import com.cg.ofda.repository.ICartRepository;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

	/* Mocking the Repository */
	@Mock
	private ICartRepository cartRepo;

	@InjectMocks /*
					 * injecting package repository marked as @Mock into package service
					 * implementation
					 */
	private CartServiceImpl csImpl;

	/*
	 * For Viewing all the carts
	 */

	@Test
	@DisplayName("CartServiceImpl : viewAllCarts for viewing all the carts")
	public void testViewAllCarts() throws CartException {

		List<FoodCartEntity> testData = Arrays.asList(new FoodCartEntity[] {

				new FoodCartEntity(101L,
						new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
								"arpit@gmail.com")),
				new FoodCartEntity(102L, new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com"))

		});

		Mockito.when(cartRepo.findAll()).thenReturn(testData);

		List<FoodCartModel> expected = Arrays.asList(new FoodCartModel[] {
				new FoodCartModel(101L,
						new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
								"arpit@gmail.com")),
				new FoodCartModel(102L, new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com"))

		});

		List<FoodCartModel> actual = csImpl.viewAllCarts();
		assertEquals(expected, actual);

	}

	/*
	 * For Adding the item in cart
	 */

	AddressModel address = new AddressModel("Guru Kripa", "krishna Nagar", "Shankar Vihar", "Mathura", "UP", "indi",
			"281004");

	@Test
	@DisplayName("CartServiceImpl::addCart should return added cart")
	void testAddCart() throws CartException {
		FoodCartEntity testData = new FoodCartEntity(101L,
				new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));
		FoodCartModel expected = new FoodCartModel(101L,
				new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));

		Mockito.when(cartRepo.save(testData)).thenReturn(testData);
		FoodCartModel actual = csImpl.addCart(expected);
		assertEquals(expected, actual);
	}

	/*
	 * For Updating the cart
	 */

	@Test
	@DisplayName("CartServceImpl::updateCart should return updated Cart ")
	void testUpdateCart() throws CartException {
		FoodCartEntity testData = new FoodCartEntity(101L,
				new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));
		FoodCartModel expected = new FoodCartModel(102L,
				new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));
		
		testData.setCartId(102L);
		Mockito.when(cartRepo.save(testData)).thenReturn(testData);
		FoodCartModel actual = csImpl.addCart(expected);
		assertEquals(expected, actual);

	}

	/*
	 * For removing the cart
	 */

	@Test
	@DisplayName("CartServiceImpl::removeCart should return removed Cart")
	void testRemoveCart() throws CartException {
		FoodCartEntity testData = new FoodCartEntity(101L,
				new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));
		FoodCartModel expected = new FoodCartModel(101L,
				new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));

		Mockito.when(cartRepo.findById(testData.getCartId())).thenReturn(Optional.of(testData));
		Mockito.doNothing().when(cartRepo).deleteById(101L);
		boolean result = csImpl.removeCart(expected.getCartId());
		assertTrue(result);
	}

	/*
	 * For clearing cart data
	 */

	@Test
	@DisplayName("CartServiceImpl::clearCart should return a clear cart ")
	void testClearCart() throws CartException {
		FoodCartEntity testData = new FoodCartEntity(101L,
				new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));
		FoodCartModel expected = new FoodCartModel(101L,
				new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));

		FoodCartModel actual = csImpl.clearCart(expected);
		assertEquals(expected, actual);

	}

	/*
	 * For viewing the carts
	 */
	@Test
	@DisplayName("CartServiceImpl::viewCart should return an existing cart ")
	void testViewCart() throws CartException {
		FoodCartEntity testData = new FoodCartEntity(101L,
				new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));
		FoodCartModel expected = new FoodCartModel(101L,
				new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"));

		Mockito.when(cartRepo.findById(testData.getCartId())).thenReturn(Optional.of(testData));
		FoodCartModel actual = csImpl.viewCart(expected.getCartId());
		assertEquals(expected, actual);

	}

}
