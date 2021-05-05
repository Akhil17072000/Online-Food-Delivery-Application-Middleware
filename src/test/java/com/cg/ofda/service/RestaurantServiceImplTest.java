//package com.cg.ofda.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
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
//import com.cg.ofda.entity.ItemEntity;
//import com.cg.ofda.entity.RestaurantEntity;
//import com.cg.ofda.exception.RestaurantException;
//import com.cg.ofda.model.AddressModel;
//import com.cg.ofda.model.ItemModel;
//import com.cg.ofda.model.RestaurantModel;
//import com.cg.ofda.repository.IRestaurantRepository;
//
//@ExtendWith(MockitoExtension.class)
//public class RestaurantServiceImplTest {
//
//	/* Mocking the Repository */
//	@Mock
//	private IRestaurantRepository resRepo;
//
//	@InjectMocks /*
//					 * injecting package repository marked as @Mock into package service
//					 * implementation
//					 */
//	private RestaurantServiceImpl rsImpl;
//
//	RestaurantEntity re = new RestaurantEntity();
//	List<ItemEntity> listItem = re.getItemList();
//
//	RestaurantModel rm = new RestaurantModel();
//	List<ItemModel> listItem1 = rm.getItemList();
//
//	AddressModel address = new AddressModel("Guru Kripa", "krishna Nagar", "Shankar Vihar", "Mathura", "UP", "indi",
//			"281004");
//
//	/*
//	 * For Getting all the restaurants
//	 */
//	@Test
//	@DisplayName("RestaurantServiceImpl::getAllRestaurants should return list of existing resaurants")
//	void testGetAllRestaurants() throws RestaurantException {
//
//		List<RestaurantEntity> testdata = Arrays.asList(
//				new RestaurantEntity[] { new RestaurantEntity(101L, "Taj", address, listItem, "ramesh", "9876543210"),
//						new RestaurantEntity(102L, "Taj", address, listItem, "ramesh", "9876543210") });
//
//		Mockito.when(resRepo.findAll()).thenReturn(testdata);
//
//		List<RestaurantModel> expected = Arrays.asList(
//				new RestaurantModel[] { new RestaurantModel(101L, "Taj", address, listItem1, "ramesh", "9876543210"),
//						new RestaurantModel(102L, "Taj", address, listItem1, "ramesh", "9876543210") });
//
//		List<RestaurantModel> actual = rsImpl.viewAllRestaurants();
//		assertEquals(expected, actual);
//
//	}
//
//	/*
//	 * For Adding the customer
//	 */
//
//	@Test
//	@DisplayName("RestaurantServiceImpl::addAll should return added restaurant")
//	void testAddRestaurant() throws RestaurantException {
//		RestaurantEntity testData = new RestaurantEntity(101L, "Taj", address, listItem, "ramesh", "9876543210");
//		RestaurantModel expected = new RestaurantModel(101L, "Taj", address, listItem1, "ramesh", "9876543210");
//
//		Mockito.when(resRepo.save(testData)).thenReturn(testData);
//		RestaurantModel actual = rsImpl.addRestaurant(expected);
//		assertEquals(expected, actual);
//	}
//
//	/*
//	 * For Updating the customer
//	 */
//
//	@Test
//	@DisplayName("RestaurantServceImpl::getAll should return updated restaurant")
//	void testUpdateRestaurant() throws RestaurantException {
//		RestaurantEntity testData = new RestaurantEntity(101L, "Taj", address, listItem, "ramesh", "9876543210");
//		RestaurantModel expected = new RestaurantModel(101L, "Taj", address, listItem1, "ramesh", "9876543210");
//
//		Mockito.when(resRepo.findById(101L)).thenReturn(Optional.of(testData));
//		RestaurantModel actual = rsImpl.updateRestaurant(expected);
//		assertEquals(expected, actual);
//
//	}
//
//	/*
//	 * For removing the customer
//	 */
//
//	@Test
//	@DisplayName("RestaurantServiceImpl::remove restaurant should return removed restaurant")
//	void testRemoveRestuarant() throws RestaurantException {
//		RestaurantEntity testData = new RestaurantEntity(101L, "Taj", address, listItem, "ramesh", "9876543210");
//		RestaurantModel expected = new RestaurantModel(101L, "Taj", address, listItem1, "ramesh", "9876543210");
//
//		Mockito.when(resRepo.findById(101L)).thenReturn(Optional.of(testData));
//		Mockito.doNothing().when(resRepo).deleteById(101L);
//		boolean result = rsImpl.removeRestaurant(expected.getRestaurantId());
//		assertTrue(result);
//	}
//
//	/*
//	 * For retrieving the customer data
//	 */
//
//	@Test
//	@DisplayName("RestaurantServiceImpl::view restaurant should return restaurant by name ")
//	void testViewRestaurant() throws RestaurantException {
//		RestaurantEntity testData = new RestaurantEntity(101L, "Taj", address, listItem, "ramesh", "9876543210");
//		RestaurantModel expected = new RestaurantModel(101L, "Taj", address, listItem1, "ramesh", "9876543210");
//
//		Mockito.when(resRepo.findById(101L)).thenReturn(Optional.of(testData));
//		RestaurantModel actual = rsImpl.viewRestaurant(expected.getRestaurantId());
//		assertEquals(expected, actual);
//
//	}
//
//}
