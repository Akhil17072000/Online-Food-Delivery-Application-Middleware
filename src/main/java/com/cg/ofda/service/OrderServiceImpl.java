package com.cg.ofda.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.OrderDetailsEntity;
import com.cg.ofda.exception.OrderException;
import com.cg.ofda.model.OrderDetailsModel;
import com.cg.ofda.repository.IOrderRepository;
import com.cg.ofda.util.EMParserOrderDetails;

@Service
public class OrderServiceImpl implements IOrderService {
	
	public static final String NOT_FOUND = "no order with id #";
	public static final String PRESENT = " present";
	
	/*
	 * Order Repository is Autowired 
     */

	@Autowired
	private IOrderRepository orderRepository;
	
	/*
	 * EMParserOrderDetails is Autowired 
     */

	@Autowired
	private EMParserOrderDetails parser;
	
	/*
	 * Default constructor
     */

	public OrderServiceImpl() {
		this.parser = new EMParserOrderDetails();
	}

	/*
	 * Parameterized for assigning
	 */

	public OrderServiceImpl(IOrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
		this.parser = new EMParserOrderDetails();
	}

	/*
	 * Implementation of addOrder method to add an order
	 */

	@Transactional
	@Override
	public OrderDetailsModel addOrder(OrderDetailsModel order) throws OrderException {
		if (order != null) {
			if (orderRepository.existsById(order.getOrderId())) {
				throw new OrderException("Order with this id already exists");
			}

			order = parser.parse(orderRepository.save(parser.parse(order)));
		}

		return order;
	}

	/*
	 * Implementation of updateOrder method to update existing order
	 */

	@Transactional
	@Override
	public OrderDetailsModel updateOrder(OrderDetailsModel order) throws OrderException {
		OrderDetailsEntity oldOrder = orderRepository.findById(order.getOrderId()).orElse(null);
		if (oldOrder == null) {
			throw new OrderException(NOT_FOUND + order.getOrderId() + PRESENT);
		} else {
			order = parser.parse(orderRepository.save(parser.parse(order)));
		}
		return order;
	}

	/*
	 * Implementation of removeOrder method to remove existing order
	 */

	@Transactional
	@Override
	public boolean removeOrder(Long orderId) throws OrderException {
		boolean isDeleted = false;
		OrderDetailsEntity oldOrder = orderRepository.findById(orderId).orElse(null);
		if (oldOrder == null) {
			throw new OrderException(NOT_FOUND + orderId + PRESENT);
		} else {
			orderRepository.deleteById(orderId);
			isDeleted = true;
		}
		return isDeleted;
	}

	/*
	 * Implementation of viewOrder method to view an order
	 */

	@Override
	public OrderDetailsModel viewOrder(Long orderId) throws OrderException {
		OrderDetailsEntity oldOrder = orderRepository.findById(orderId).orElse(null);
		if (oldOrder == null) {
			throw new OrderException(NOT_FOUND + orderId + PRESENT);
		}
		return parser.parse(orderRepository.findById(orderId).orElse(null));
	}

	/*
	 * Implementation of viewAllOrders method to view all orders
	 */

	@Override
	public List<OrderDetailsModel> viewAllOrders() throws OrderException {

		return orderRepository.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

}