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

import com.cg.ofda.exception.RestaurantException;
import com.cg.ofda.model.RestaurantModel;
import com.cg.ofda.service.IRestaurantService;

@RestController
@RequestMapping(path="/restaurant")
public class RestaurantRestController {
	
	/*
	 * Restaurant Service is Autowired 
     */
	
	@Autowired
	private IRestaurantService restaurantService;
	
	/*
	 * to add a restaurant
	 * return : rest
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<RestaurantModel>addRestaurant(@RequestBody RestaurantModel rest)throws RestaurantException{
		rest=restaurantService.addRestaurant(rest);
		return new ResponseEntity<>(rest, HttpStatus.CREATED);
		
	}
	
	/*
	 * to remove a restaurant
	 * return : void
	 * params : restaurantId
	 */
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<Void> removeRestaurant(@PathVariable("restaurantId")  Long restaurantId) throws RestaurantException{
		ResponseEntity<Void> response = null;
		RestaurantModel rest = restaurantService.viewRestaurant(restaurantId);
		if ( rest== null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			restaurantService.removeRestaurant(restaurantId);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		}
		return response;
	}
	/*
	 * to modify a restaurant
	 * return : rest
	 * params : NIL
	 */
	@PutMapping
	public ResponseEntity<RestaurantModel> updateRestaurant(@RequestBody RestaurantModel rest) throws RestaurantException {
		rest = restaurantService.updateRestaurant(rest);
		 return new ResponseEntity<>(rest, HttpStatus.OK);
		
	}
	/*
	 * to retrieve an restaurant
	 * return : rest
	 * params : restId
	 */
	@GetMapping("/{restId}")
	public ResponseEntity<RestaurantModel> viewRestaurant(@PathVariable("restId") Long restId) throws RestaurantException {
		ResponseEntity<RestaurantModel> response = null;
		RestaurantModel rest = restaurantService.viewRestaurant(restId);
		
		if (rest == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			response = ResponseEntity.ok(rest);
		}
		return response;
	}
	/*
	 * to retrieve all restaurants
	 * return : List<restaurants>
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<RestaurantModel>> viewAllRestaurants() throws RestaurantException {
		 return new ResponseEntity<>(restaurantService.viewAllRestaurants(), HttpStatus.OK);
		
	}
	
	

}