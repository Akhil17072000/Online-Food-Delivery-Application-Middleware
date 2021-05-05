package com.cg.ofda.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.ItemEntity;
import com.cg.ofda.model.ItemModel;

@Service
public class EMParserItem {
	
	/*
	 * EMParserFoodCart is Autowired
     */
	
	@Autowired
	private EMParserFoodCart cartParser;
	
	/*
	 * EMParserCategory is Autowired
     */
	
	@Autowired
	private EMParserCategory categoryParser;
	
	/*
	 * EMParserRestaurant is Autowired
     */
	
	@Autowired
	private EMParserRestaurant restaurantParser;
	
	/*
	 * Method to parse Model to Entity
     */
	
	public ItemEntity parse(ItemModel source) {
		return source == null ? null :
			new ItemEntity(source.getItemId(),
					source.getItemName(),
					categoryParser.parse(source.getCategory()),
					source.getQuantity(),
					source.getCost(),
					restaurantParser.parse(source.getRestaurants()),
					cartParser.parse(source.getFoodCart()));
	}
	
	/*
	 * Method to parse Entity to Model
     */
	
	public ItemModel parse(ItemEntity source) {
		return source == null ? null :
			new ItemModel(source.getItemId(),
					source.getItemName(),
					categoryParser.parse(source.getCategory()),
					source.getQuantity(),
					source.getCost(),
					restaurantParser.parseEntity(source.getRestaurants()),
					cartParser.parse(source.getFoodCart()));
	}
	
	public List<ItemEntity> parse(List<ItemModel> list){
		
		List<ItemEntity> rlist =new ArrayList<>();
		for(ItemModel model : list) {
			rlist.add(parse(model));
		}
		return rlist;
	}	

	public List<ItemModel> parseEntity(List<ItemEntity> list){
		
		List<ItemModel> rlist =new ArrayList<>();
		for(ItemEntity entity : list) {
			rlist.add(parse(entity));
		}
		return rlist;
	}

}
