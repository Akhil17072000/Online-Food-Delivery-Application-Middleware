//package com.cg.ofda.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.cg.ofda.entity.CategoryEntity;
//import com.cg.ofda.entity.CustomerEntity;
//import com.cg.ofda.entity.FoodCartEntity;
//import com.cg.ofda.entity.ItemEntity;
//import com.cg.ofda.entity.RestaurantEntity;
//import com.cg.ofda.exception.ItemException;
//import com.cg.ofda.model.AddressModel;
//import com.cg.ofda.model.CategoryModel;
//import com.cg.ofda.model.CustomerModel;
//import com.cg.ofda.model.FoodCartModel;
//import com.cg.ofda.model.ItemModel;
//import com.cg.ofda.model.RestaurantModel;
//import com.cg.ofda.repository.IItemRepository;
//
//@ExtendWith(MockitoExtension.class)
//public class ItemServiceImplTest {
//
//	/* Mocking the Repository */
//	@Mock
//	private IItemRepository itemRepo;
//
//	/*
//	 * injecting package repository marked as @Mock into package service
//	 * implementation
//	 */
//	@InjectMocks
//	private ItemServiceImpl isImpl;
//
//	/* For getting the list */
//	ItemEntity ie = new ItemEntity();
//	ItemModel ie1 = new ItemModel();
//	List<RestaurantEntity> listRest = ie.getRestaurants();
//	List<RestaurantModel> listRest1 = ie1.getRestaurants();
//
//	AddressModel address = new AddressModel("Guru Kripa", "krishna Nagar", "Shankar Vihar", "Mathura", "UP", "india",
//			"281004");
//	BigDecimal cost = new BigDecimal("100.00");
//
//	/*
//	 * For Getting all the customers in a restaurant
//	 */
//	@Test
//	@DisplayName("ItemServiceImpl::getAllItems should return list of existing items")
//	void testGetAllItems() throws ItemException {
//
//		List<ItemEntity> testData = Arrays.asList(new ItemEntity[] {
//				new ItemEntity(101L, "Burger", new CategoryEntity(100L, "fries"), 10, cost, listRest,
//						new FoodCartEntity(101L,
//								new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
//										"arpit@gmail.com"))),
//				new ItemEntity(102L, "Burger", new CategoryEntity(100L, "fries"), 10, cost, listRest,
//						new FoodCartEntity(102L, new CustomerEntity(2L, "Arpit", "Tailong", "male", "21", "9876543210",
//								address, "arpit@gmail.com"))), });
//
//		Mockito.when(itemRepo.findAll()).thenReturn(testData);
//
//		List<ItemModel> expected = Arrays.asList(new ItemModel[] {
//				new ItemModel(101L, "Burger", new CategoryModel(100L, "fries"), 10, cost, listRest1,
//						new FoodCartModel(101L,
//								new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
//										"arpit@gmail.com"))),
//				new ItemModel(102L, "Burger", new CategoryModel(100L, "fries"), 10, cost, listRest1,
//						new FoodCartModel(102L, new CustomerModel(2L, "Arpit", "Tailong", "male", "21", "9876543210",
//								address, "arpit@gmail.com"))), });
//		List<ItemModel> actual = isImpl.viewAllItems();
//		assertEquals(expected, actual);
//
//	}
//
//	/*
//	 * For Adding the customer
//	 */
//
//	@Test
//	@DisplayName("ItemServiceImpl::addItem should return added item")
//	void testAddItem() throws ItemException {
//		ItemEntity testData = new ItemEntity(101L, "Burger", new CategoryEntity(100L, "fries"), 10, cost, listRest,
//				new FoodCartEntity(101L, new CustomerEntity(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
//						"arpit@gmail.com")));
//		ItemModel expected = new ItemModel(101L, "Burger", new CategoryModel(100L, "fries"), 10, cost, listRest1,
//				new FoodCartModel(101L, new CustomerModel(1L, "Arpit", "Tailong", "male", "21", "9876543210", address,
//						"arpit@gmail.com")));
//
//		Mockito.when(itemRepo.save(testData)).thenReturn(testData);
//		ItemModel actual = isImpl.addItem(expected);
//		assertEquals(expected, actual);
//	}
//
//	/*
//	 * For Updating the customer
//	 */
//
//	@Test
//	@DisplayName("ItemServceImpl::updateItem should return updated items")
//	void testUpdateItem() throws ItemException {
//		ItemEntity testData = new ItemEntity(101L, "Burger", new CategoryEntity(100L, "fries"), 10, cost, listRest,
//				new FoodCartEntity());
//		ItemModel expected = new ItemModel(101L, "Burger", new CategoryModel(100L, "fries"), 10, cost, listRest1,
//				new FoodCartModel());
//
//		Mockito.when(itemRepo.findById(testData.getItemId())).thenReturn(Optional.of(testData));
//		ItemModel actual = isImpl.updateItem(expected);
//		assertEquals(expected, actual);
//
//	}
//
//	/*
//	 * For removing the customer
//	 */
//
//	@Test
//	@DisplayName("ItemServiceImpl::removeItem should return removed Item")
//	void testRemoveItem() throws ItemException {
//		ItemEntity testData = new ItemEntity(101L, "Burger", new CategoryEntity(100L, "fries"), 10, cost, listRest,
//				new FoodCartEntity());
//		ItemModel expected = new ItemModel(101L, "Burger", new CategoryModel(100L, "fries"), 10, cost, listRest1,
//				new FoodCartModel());
//
//		Mockito.when(itemRepo.findById(testData.getItemId())).thenReturn(Optional.of(testData));
//		Mockito.doNothing().when(itemRepo).deleteById(101L);
//		boolean actual = isImpl.removeItem(expected.getItemId());
//		assertTrue(actual);
//	}
//
//	/*
//	 * For retrieving the customer data
//	 */
//
//	@Test
//	@DisplayName("ItemServiceImpl::viewItem should return an existing item ")
//	void testViewItem() throws ItemException {
//		ItemEntity testData = new ItemEntity(101L, "Burger", new CategoryEntity(100L, "fries"), 10, cost, listRest,
//				new FoodCartEntity());
//		ItemModel expected = new ItemModel(101L, "Burger", new CategoryModel(100L, "fries"), 10, cost, listRest1,
//				new FoodCartModel());
//
//		Mockito.when(itemRepo.findById(101L)).thenReturn(Optional.of(testData));
//		ItemModel actual = isImpl.viewItem(expected.getItemId());
//		assertEquals(expected, actual);
//
//	}
//
//}
