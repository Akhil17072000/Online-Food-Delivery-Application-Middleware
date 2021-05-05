package com.cg.ofda.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.OrderDetailsEntity;
import com.cg.ofda.model.OrderDetailsModel;
import com.cg.ofda.repository.IOrderRepository;

@Service
public class EMParserOrderDetails {
	
	/*
	 * Order Repository is Autowired
     */
	
	@Autowired
	private IOrderRepository orderRepo;
	
	/*
	 * EMParserFoodCart is Autowired
     */
	
	@Autowired
	private EMParserFoodCart cartParser;
	
	/*
	 * Default constructor 
     */
	
	public EMParserOrderDetails() {
		this.cartParser= new EMParserFoodCart();
	}
	
	/*
	 * Parameterized constructor 
     */
	
	public EMParserOrderDetails(IOrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
		this.cartParser= new EMParserFoodCart();
	}
	
	/*
	 * Method to parse Entity to Model
     */

	public OrderDetailsModel parse(OrderDetailsEntity source) {
		return source == null ? null:
			new OrderDetailsModel(source.getOrderId(),
					source.getOrderDate(),
					cartParser.parse(source.getCart()),
					source.getOrderStatus());
	}
	
	/*
	 * Method to parse Model to Entity
     */
	
	public OrderDetailsEntity parse(OrderDetailsModel  source) {
		return source == null ? null:
			new OrderDetailsEntity(source.getOrderId(),
					source.getOrderDate(),
					cartParser.parse(source.getCart()),
					source.getOrderStatus());
	}
	

}
