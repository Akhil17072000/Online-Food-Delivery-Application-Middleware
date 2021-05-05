package com.cg.ofda.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.CategoryEntity;
import com.cg.ofda.model.CategoryModel;
import com.cg.ofda.repository.ICategoryRepository;

@Service
public class EMParserCategory {
	
	/*
	 * Category Repository is Autowired
     */
	
	@Autowired
	private ICategoryRepository catRepo;
	
	/*
	 * Default constructor 
     */
	
	public EMParserCategory() {
		
	}
	
	/*
	 * Parameterized constructor 
     */
	
	public EMParserCategory(ICategoryRepository catRepo) {
		super();
		this.catRepo = catRepo;
	}
	
	/*
	 * Method to parse Entity to Model
     */

	public CategoryModel parse (CategoryEntity source) {
		return source==null ? null:
			new CategoryModel(source.getCatId(),
					source.getCategoryName());
	}
	
	/*
	 * Method to parse Model to Entity
     */
	
	public CategoryEntity parse (CategoryModel source) {
		return source==null ? null:
			new CategoryEntity(source.getCatId(),
					source.getCategoryName());
	}

}
