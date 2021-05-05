package com.cg.ofda.service;

import java.util.List;

import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.model.CategoryModel;

public interface ICategoryService {

	/* Definition for addCategory method for adding category */
	public CategoryModel addCategory(CategoryModel cat) throws CategoryException;

	/* Definition for updateCategory method for updating category */
	public CategoryModel updateCategory(CategoryModel cat) throws CategoryException;

	/* Definition for removeCategory method for removing category */
	public boolean removeCategory(Long catId) throws CategoryException;

	/* Definition for viewCategory method for viewing a particular category */
	public CategoryModel viewCategory(Long catId) throws CategoryException;

	/* Definition for viewAllCategory method for viewing all categories */
	public List<CategoryModel> viewAllCategory() throws CategoryException;
}
