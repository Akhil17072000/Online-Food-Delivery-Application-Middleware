package com.cg.ofda.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.RestaurantEntity;
import com.cg.ofda.exception.RestaurantException;
import com.cg.ofda.model.RestaurantModel;
import com.cg.ofda.repository.IRestaurantRepository;
import com.cg.ofda.util.EMParserRestaurant;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
	
	public static final String NOT_FOUND = "no restaurant with id #";
	public static final String PRESENT = " present";
	
	/*
	 * Restaurant Repository is Autowired 
     */

	@Autowired
	private IRestaurantRepository resRepo;
	
	/*
	 * EMParserRestaurant is Autowired 
     */

	@Autowired
	private EMParserRestaurant parser;
	
	/*
	 * Default constructor
     */

	public RestaurantServiceImpl() {
		this.parser = new EMParserRestaurant();
	}

	/*
	 * Parameterized for assigning
	 */
	public RestaurantServiceImpl(IRestaurantRepository resRepo) {
		super();
		this.resRepo = resRepo;
		this.parser = new EMParserRestaurant();
	}

	/*
	 * Implementation of addRestaurant method to add a Restaurant
	 */

	@Transactional
	@Override
	public RestaurantModel addRestaurant(RestaurantModel res) throws RestaurantException {
		if (res != null) {
			if (resRepo.existsById(res.getRestaurantId())) {
				throw new RestaurantException("Restaurant with this id already exists");
			}
			res = parser.parse(resRepo.save(parser.parse(res)));
		}

		return res;

	}

	/*
	 * Implementation of removeRestaurant method to remove existing Restaurant
	 */

	@Transactional
	@Override
	public boolean removeRestaurant(Long restaurantId) throws RestaurantException {
		boolean isDeleted = false;
		RestaurantEntity restaurant = resRepo.findById(restaurantId).orElse(null);
		if (restaurant == null) {
			throw new RestaurantException(NOT_FOUND + restaurantId + PRESENT);
		} else {
			resRepo.deleteById(restaurantId);
			isDeleted = true;
		}
		return isDeleted;
	}

	/*
	 * Implementation of updateRestaurant method to update existing Restaurant
	 */

	@Transactional
	@Override
	public RestaurantModel updateRestaurant(RestaurantModel res) throws RestaurantException {
		if (res != null) {
			if (!resRepo.existsById(res.getRestaurantId())) {
				throw new RestaurantException(NOT_FOUND + res.getRestaurantId() + PRESENT);

			}
			res = parser.parse(resRepo.save(parser.parse(res)));
		}
		return res;
	}

	/*
	 * Implementation of viewRestaurant method to view a Restaurant
	 */

	@Override
	public RestaurantModel viewRestaurant(Long restaurantId) throws RestaurantException {
		RestaurantEntity restaurant = resRepo.findById(restaurantId).orElse(null);
		if (restaurant == null) {
			throw new RestaurantException(NOT_FOUND + restaurantId + PRESENT);
		}
		return parser.parse(resRepo.findById(restaurantId).orElse(null));
	}

	/*
	 * Implementation of viewAllRestaurants method to view all the Restaurants
	 */

	@Override
	public List<RestaurantModel> viewAllRestaurants() throws RestaurantException {

		return parser.parseEntity(resRepo.findAll());
	}

}