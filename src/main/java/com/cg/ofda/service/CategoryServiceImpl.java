package com.cg.ofda.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.CategoryEntity;
import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.model.CategoryModel;
import com.cg.ofda.repository.ICategoryRepository;
import com.cg.ofda.util.EMParserCategory;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	public static final String NOT_FOUND = "no category with id #";
	public static final String PRESENT = " present";

	
	/*
	 * Category Repository is Autowired 
     */

	@Autowired
	private ICategoryRepository categoryRepository;
	
	/*
	 * EMParserCategory is Autowired 
     */

	@Autowired
	private EMParserCategory parser;
	
	/*
	 * Default constructor
     */

	public CategoryServiceImpl() {
		this.parser = new EMParserCategory();
	}

	/*
	 * Parameterized for assigning
	 */

	public CategoryServiceImpl(ICategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.parser = new EMParserCategory();
	}

	/*
	 * Implementation of addCategory method to add a category
	 */

	@Transactional
	@Override
	public CategoryModel addCategory(CategoryModel cat) throws CategoryException {
		if (cat != null) {
			if (categoryRepository.existsById(cat.getCatId())) {
				throw new CategoryException("Category with this id already exists");
			}

			cat = parser.parse(categoryRepository.save(parser.parse(cat)));
		}

		return cat;
	}

	/*
	 * Implementation of updateCategory method to update existing category
	 */

	@Transactional
	@Override
	public CategoryModel updateCategory(CategoryModel cat) throws CategoryException {
		CategoryEntity category= categoryRepository.findById(cat.getCatId()).orElse(null);
		if(category== null)
			throw new CategoryException(NOT_FOUND + cat.getCatId() + PRESENT);
		cat = parser.parse(categoryRepository.save(parser.parse(cat)));
		return cat;
	}

	/*
	 * Implementation of removeCategory method to remove a category
	 */

	@Transactional
	@Override
	public boolean removeCategory(Long catId) throws CategoryException {
		CategoryEntity oldEntity = categoryRepository.findById(catId).orElse(null);
		boolean isDeleted = false;
		if (oldEntity == null) {
			throw new CategoryException(NOT_FOUND + catId + PRESENT);
		} else {
			categoryRepository.deleteById(catId);
			isDeleted = true;
		}
		return isDeleted;
	}

	/*
	 * Implementation of viewCategory method to view a category
	 */

	@Override
	public CategoryModel viewCategory(Long catId) throws CategoryException {
		CategoryEntity oldCategory = categoryRepository.findById(catId).orElse(null);
		if (oldCategory == null) {
			throw new CategoryException(NOT_FOUND + catId + PRESENT);
		}
		return parser.parse(categoryRepository.findById(catId).orElse(null));
	}

	/*
	 * Implementation of viewAllCategory method to view all the category
	 */

	@Override
	public List<CategoryModel> viewAllCategory() throws CategoryException {

		return categoryRepository.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

}
