package com.cg.ofda.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
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

import com.cg.ofda.entity.BillEntity;
import com.cg.ofda.entity.CustomerEntity;
import com.cg.ofda.entity.FoodCartEntity;
import com.cg.ofda.entity.OrderDetailsEntity;
import com.cg.ofda.exception.BillException;
import com.cg.ofda.model.AddressModel;
import com.cg.ofda.model.BillModel;
import com.cg.ofda.model.CustomerModel;
import com.cg.ofda.model.FoodCartModel;
import com.cg.ofda.model.OrderDetailsModel;
import com.cg.ofda.repository.IBillRepository;

@ExtendWith(MockitoExtension.class)
public class BillServiceImplTest {

	/* Mocking the Repository */
	@Mock
	private IBillRepository billRepo;

	/*
	 * injecting package repository marked as @Mock into package service
	 * implementation
	 */
	@InjectMocks
	private BillServiceImpl bsImpl;

	AddressModel address = new AddressModel("Guru Kripa", "krishna Nagar", "Shankar Vihar", "Mathura", "UP", "indi",
			"281004");
	BigDecimal bd = new BigDecimal("10000.00");

	LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30));

	/*
	 * For Getting all the bills in a restaurant
	 */
	@Test
	@DisplayName("BillServiceImpl::getAll should return list of existing bills in a duratiion as BillModel List")
	void testGetAllBills() throws BillException {

		List<BillEntity> testdata = Arrays.asList(new BillEntity[] {
				new BillEntity(100L,
						new OrderDetailsEntity(1000L,
								LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
								new FoodCartEntity(101L,
										new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
												"arpit@gmail.com")),
								"Booked"),
						10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30))),
				new BillEntity(101L,
						new OrderDetailsEntity(1001L,
								LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
								new FoodCartEntity(102L,
										new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
												"arpit@gmail.com")),
								"Booked"),
						10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 15), LocalTime.of(11, 30))) });

		Mockito.when(billRepo.findAll()).thenReturn(testdata);

		List<BillModel> expected = Arrays.asList(new BillModel[] {
				new BillModel(
						100L,
						new OrderDetailsModel(1000L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
								new FoodCartModel(101L,
										new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
												"arpit@gmail.com")),
								"Booked"),
						10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30))),
				new BillModel(101L,
						new OrderDetailsModel(1001L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
								new FoodCartModel(102L,
										new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
												"arpit@gmail.com")),
								"Booked"),
						10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 15), LocalTime.of(11, 30))) });

		List<BillModel> actual = bsImpl.viewAllBills();

		assertEquals(expected, actual);

	}

	/*
	 * For Adding the bill
	 */

	@Test
	@DisplayName("BillServiceImpl::addBill should return added bill")
	void testAddBill() throws BillException {
		BillEntity testData = new BillEntity(100L, new OrderDetailsEntity(), 10, bd,
				LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30)));
		BillModel expected = new BillModel(100L, new OrderDetailsModel(), 10, bd,
				LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30)));

		Mockito.when(billRepo.save(testData)).thenReturn(testData);
		BillModel actual = bsImpl.addBill(expected);
		assertEquals(expected, actual);
	}

	/*
	 * For Updating the bill
	 */

	@Test
	@DisplayName("BillServiceImpl::updateBill should return updated bill")
	void testUpdateBill() throws BillException {
		BillEntity testData = new BillEntity(100L, new OrderDetailsEntity(1000L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)), new FoodCartEntity(), "Booked"), 10,
				bd, localDateTime);
		BillModel expected = new BillModel(100L, new OrderDetailsModel(1000L,
				LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)), new FoodCartModel(), "Booked"), 11,
				bd, localDateTime);
		
		testData.setTotalItem(11);
		Mockito.when(billRepo.save(testData)).thenReturn(testData);
		BillModel actual = bsImpl.addBill(expected);
		assertEquals(expected, actual);

	}

	/*
	 * For removing the bill
	 */

	@Test
	@DisplayName("BillServiceImpl::removebill should return the removed bill")
	void testRemoveBill() throws BillException {
		BillEntity testData = new BillEntity(100L,
				new OrderDetailsEntity(1000L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartEntity(), "Booked"),
				10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30)));
		BillModel expected = new BillModel(100L,
				new OrderDetailsModel(1000L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartModel(), "Booked"),
				10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30)));

		Mockito.when(billRepo.findById(testData.getBillId())).thenReturn(Optional.of(testData));
		Mockito.doNothing().when(billRepo).deleteById(100L);
		boolean result = bsImpl.removeBill(expected.getBillId());
		assertTrue(result);
	}

	/*
	 * For retrieving the bill data
	 */

	@Test
	@DisplayName("BillServiceImpl::viewBill should return existing bill ")
	void testViewBill() throws BillException {
		BillEntity testData = new BillEntity(100L,
				new OrderDetailsEntity(1000L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartEntity(101L,
								new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
										"arpit@gmail.com")),
						"Booked"),
				10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30)));
		BillModel expected = new BillModel(100L,
				new OrderDetailsModel(1000L, LocalDateTime.of(LocalDate.of(2020, 03, 02), LocalTime.of(16, 30)),
						new FoodCartModel(101L,
								new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
										"arpit@gmail.com")),
						"Booked"),
				10, bd, LocalDateTime.of(LocalDate.of(2020, 03, 12), LocalTime.of(11, 30)));

		Mockito.when(billRepo.findById(testData.getBillId())).thenReturn(Optional.of(testData));
		BillModel actual = bsImpl.viewBill(expected.getBillId());
		assertEquals(expected, actual);

	}

}