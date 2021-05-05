package com.cg.ofda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import com.cg.ofda.entity.OrderDetailsEntity;
import com.cg.ofda.exception.OrderException;
import com.cg.ofda.model.AddressModel;
import com.cg.ofda.model.CustomerModel;
import com.cg.ofda.model.FoodCartModel;
import com.cg.ofda.model.OrderDetailsModel;
import com.cg.ofda.repository.IOrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

	/* Mocking the Repository */
	@Mock
	private IOrderRepository orderRepo;

	/*
	 * injecting package repository marked as @Mock into package service
	 * implementation
	 */
	@InjectMocks
	private OrderServiceImpl osImpl;

	AddressModel address = new AddressModel("Guru Kripa", "krishna Nagar", "Shankar Vihar", "Mathura", "UP", "indi",
			"281004");

	/*
	 * For Getting all the orders
	 */
	@Test
	@DisplayName("OrderServiceImpl::getAllOrder should return list of existing orders")
	void testGetAllOrders() throws OrderException {

		List<OrderDetailsEntity> testdata = Arrays.asList(new OrderDetailsEntity[] {
				new OrderDetailsEntity(1000L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartEntity(101L,
								new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
										"arpit@gmail.com")),
						"Booked"),
				new OrderDetailsEntity(1001L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartEntity(101L, new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210",
								address, "arpit@gmail.com")),
						"Booked") });

		Mockito.when(orderRepo.findAll()).thenReturn(testdata);

		List<OrderDetailsModel> expected = Arrays.asList(new OrderDetailsModel[] {
				new OrderDetailsModel(1000L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartModel(101L,
								new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
										"arpit@gmail.com")),
						"Booked"),
				new OrderDetailsModel(1001L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartModel(101L, new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210",
								address, "arpit@gmail.com")),
						"Booked") });

		List<OrderDetailsModel> actual = osImpl.viewAllOrders();

		assertEquals(expected, actual);

	}

	/*
	 * For Adding the order
	 */

	@Test
	@DisplayName("OrderServiceImpl::addOrder should return added order")
	void testAddOrder() throws OrderException {
		OrderDetailsEntity testData = new OrderDetailsEntity(1001L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartEntity(101L, new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");
		OrderDetailsModel expected = new OrderDetailsModel(1001L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartModel(101L, new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");

		Mockito.when(orderRepo.save(testData)).thenReturn(testData);
		OrderDetailsModel actual = osImpl.addOrder(expected);
		assertEquals(expected, actual);
	}

	/*
	 * For Updating the order
	 */

	@Test
	@DisplayName("OrderServiceImpl::updateOrder should return updated order")
	void testUpdateOrder() throws OrderException {
		OrderDetailsEntity testData = new OrderDetailsEntity(1001L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartEntity(101L, new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");
		OrderDetailsModel expected = new OrderDetailsModel(1002L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartModel(101L, new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");

		testData.setOrderId(1002L);
		Mockito.when(orderRepo.save(testData)).thenReturn(testData);
		OrderDetailsModel actual = osImpl.addOrder(expected);
		assertEquals(expected, actual);

	}

	/*
	 * For removing the order
	 */

	@Test
	@DisplayName("OrderServiceImpl::removeOrder should return the removed Order")
	void testRemoveOrder() throws OrderException {
		OrderDetailsEntity testData = new OrderDetailsEntity(1001L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartEntity(101L, new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");
		OrderDetailsModel expected = new OrderDetailsModel(1001L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartModel(101L, new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");

		Mockito.when(orderRepo.findById(testData.getOrderId())).thenReturn(Optional.of(testData));
		boolean result = osImpl.removeOrder(expected.getOrderId());
		assertTrue(result);
	}

	/*
	 * For retrieving the order data
	 */

	@Test
	@DisplayName("OrderServiceImpl::viewOrder should return an existing order ")
	void testViewOrder() throws OrderException {
		OrderDetailsEntity testData = new OrderDetailsEntity(1001L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartEntity(101L, new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");
		OrderDetailsModel expected = new OrderDetailsModel(1001L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
				new FoodCartModel(101L, new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
						"arpit@gmail.com")),
				"Booked");

		Mockito.when(orderRepo.findById(testData.getOrderId())).thenReturn(Optional.of(testData));
		OrderDetailsModel actual = osImpl.viewOrder(expected.getOrderId());
		assertEquals(expected, actual);

	}

}