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
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.model.AddressModel;
import com.cg.ofda.model.CustomerModel;
import com.cg.ofda.repository.ICustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

	/* Mocking the Repository */
	@Mock
	private ICustomerRepository customerRepo;

	/*
	 * injecting package repository marked as @Mock into package service
	 * implementation
	 */
	@InjectMocks
	private CustomerServiceImpl csImpl;

	AddressModel address = new AddressModel("Guru Kripa", "krishna Nagar", "Shankar Vihar", "Mathura", "UP", "indi",
			"281004");

	/*
	 * For Viewing all the customers
	 */

	@Test
	@DisplayName("CustomerServiceImpl : viewAllCustomers for viewing all the customers")
	public void testViewAllCustomers() throws CustomerException {

		List<CustomerEntity> testData = Arrays.asList(new CustomerEntity[] {

				new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"),
				new CustomerEntity(2L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com")

		});

		Mockito.when(customerRepo.findAll()).thenReturn(testData);

		List<CustomerModel> expected = Arrays.asList(new CustomerModel[] {

				new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com"),
				new CustomerModel(2L, "Arpit", "Tailong", "male", "21", "9876543210", address, "arpit@gmail.com")

		});

		List<CustomerModel> actual = csImpl.findAllCustomer();
		assertEquals(expected, actual);

	}

	/*
	 * For Adding the customer
	 */

	@Test
	@DisplayName("CustomerServiceImpl::addCustomer should return added customer")
	void testAddCustomer() throws CustomerException {
		CustomerEntity testData = new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");
		CustomerModel expected = new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");

		Mockito.when(customerRepo.save(testData)).thenReturn(testData);
		CustomerModel actual = csImpl.addCustomer(expected);
		assertEquals(expected, actual);
	}

	/*
	 * For Updating the customer
	 */

	@Test
	@DisplayName("CustomerServiceImpl::updateCustomer should return updated customer")
	void testUpdateCustomer() throws CustomerException {
		CustomerEntity testData = new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");
		CustomerModel expected = new CustomerModel(1L, "Shubham", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");

		testData.setFirstName("Shubham");

		Mockito.when(customerRepo.save(testData)).thenReturn(testData);

		CustomerModel actual = csImpl.addCustomer(expected);
		assertEquals(expected, actual);

	}

	/*
	 * For removing the customer
	 */

	@Test
	@DisplayName("CustomerServiceImpl::removecustomer should return removed customer")
	void testRemoveCustomer() throws CustomerException {
		CustomerEntity testData = new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");
		CustomerModel expected = new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");

		Mockito.when(customerRepo.findById(1L)).thenReturn(Optional.of(testData));
		Mockito.doNothing().when(customerRepo).deleteById(1L);
		boolean result = csImpl.removeCustomer(expected.getCustomerId());
		assertTrue(result);
	}

	/*
	 * For retrieving the customer data
	 */

	@Test
	@DisplayName("CustomerServiceImpl::viewcustomer should return an existing customer ")
	void testViewCustomer() throws CustomerException {
		CustomerEntity testdata = new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");
		CustomerModel expected = new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
				"arpit@gmail.com");

		Mockito.when(customerRepo.findById(1L)).thenReturn(Optional.of(testdata));
		CustomerModel actual = csImpl.findCustomer(1L);
		assertEquals(expected, actual);

	}

}