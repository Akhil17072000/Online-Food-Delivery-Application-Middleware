package com.cg.ofda.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofda.exception.CategoryException;
import com.cg.ofda.model.CategoryModel;
import com.cg.ofda.service.ICategoryService;


@RestController
@RequestMapping(path="/category")
public class CategoryRestController {
	
	/*
	 * Category Service is Autowired 
     */
	
	@Autowired
	private ICategoryService categoryService;
	
	/*
	 * to add a category
	 * return : category
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<CategoryModel>addCategory(@RequestBody CategoryModel category)throws CategoryException{
		category=categoryService.addCategory(category);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	/*
	 * to modify a category
	 * return : category
	 * params : NIL
	 */
	@PutMapping
	public ResponseEntity<CategoryModel> updateCategory(@RequestBody CategoryModel category) throws CategoryException {
		category = categoryService.updateCategory(category);
		 return new ResponseEntity<>(category, HttpStatus.OK);
		
	}
	/*
	 * to remove a category
	 * return : category
	 * params : catId
	 */
	@DeleteMapping("/{catId}")
	public ResponseEntity<Void> removeCategory(@PathVariable("catId") Long catId) throws CategoryException{
		ResponseEntity<Void> response = null;
		CategoryModel category = categoryService.viewCategory(catId);
		if (category == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			categoryService.removeCategory(catId);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		}
		return response;
	}
	/*
	 * to retrieve a category
	 * return : category
	 * params : catId
	 */
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryModel> viewCategory(@PathVariable("catId") Long catId) throws CategoryException {
		ResponseEntity<CategoryModel> response = null;
		CategoryModel category = categoryService.viewCategory(catId);
		
		if (category == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			response = ResponseEntity.ok(category);
		}
		return response;
	}
	
	/*
	 * to retrieve all categories
	 * return : List<categories>
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<CategoryModel>> viewAllCategory() throws CategoryException {
		 return new ResponseEntity<>(categoryService.viewAllCategory(), HttpStatus.OK);
		
	}
	
	
	
	
}