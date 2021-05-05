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

import com.cg.ofda.entity.CategoryEntity;
import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.model.CategoryModel;
import com.cg.ofda.repository.ICategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

	/* Mocking the Repository */
	@Mock
	private ICategoryRepository catRepo;

	/*
	 * injecting package repository marked as @Mock into package service
	 * implementation
	 */

	@InjectMocks
	private CategoryServiceImpl csImpl;

	/*
	 * For Viewing all the category
	 */

	@Test
	@DisplayName("CategoryServiceImpl : viewAllCategory for viewing all the category")
	public void testViewAllCategory() throws CategoryException {

		List<CategoryEntity> testData = Arrays.asList(new CategoryEntity[] {

				new CategoryEntity(100L, "fries"), new CategoryEntity(101L, "Burger")

		});

		Mockito.when(catRepo.findAll()).thenReturn(testData);

		List<CategoryModel> expected = Arrays.asList(new CategoryModel[] {

				new CategoryModel(100L, "fries"), new CategoryModel(101L, "Burger")

		});

		List<CategoryModel> actual = csImpl.viewAllCategory();
		assertEquals(expected, actual);

	}

	/*
	 * For Adding the category
	 */

	@Test
	@DisplayName("CategoryServiceImpl::addCategory should return added category")
	void testAddCategory() throws CategoryException {
		CategoryEntity testData = new CategoryEntity(100L, "fries");
		CategoryModel expected = new CategoryModel(100L, "fries");

		Mockito.when(catRepo.save(testData)).thenReturn(testData);
		CategoryModel actual = csImpl.addCategory(expected);
		assertEquals(expected, actual);
	}

	/*
	 * For Updating the category
	 */

	@Test
	@DisplayName("CategoryServiceImpl::updateCategory should return updated category")
	void testUpdateCategory() throws CategoryException {
		CategoryEntity testData = new CategoryEntity(100L, "fries");
		CategoryModel expected = new CategoryModel(100L, "burger");

		testData.setCategoryName("burger");
		Mockito.when(catRepo.save(testData)).thenReturn(testData);
		CategoryModel actual = csImpl.addCategory(expected);
		assertEquals(expected, actual);

	}

	/*
	 * For removing the category
	 */

	@Test
	@DisplayName("CategoryServiceImpl::testRemoveCategory should return the removed category")
	void testRemoveCategory() throws CategoryException {
		CategoryEntity testData = new CategoryEntity(100L, "fries");
		CategoryModel expected = new CategoryModel(100L, "fries");

		Mockito.when(catRepo.findById(testData.getCatId())).thenReturn(Optional.of(testData));
		Mockito.doNothing().when(catRepo).deleteById(100L);
		boolean result = csImpl.removeCategory(expected.getCatId());
		assertTrue(result);
	}

	/*
	 * For viewing the category
	 */

	@Test
	@DisplayName("CategoryServiceImpl::viewCategory should return existing category")
	void testViewCategory() throws CategoryException {
		CategoryEntity testData = new CategoryEntity(100L, "fries");
		CategoryModel expected = new CategoryModel(100L, "fries");

		Mockito.when(catRepo.findById(testData.getCatId())).thenReturn(Optional.of(testData));
		CategoryModel actual = csImpl.viewCategory(expected.getCatId());
		assertEquals(expected, actual);

	}

}
