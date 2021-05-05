package com.cg.ofda.service;

import java.util.List;

import com.cg.ofda.exception.OrderException;
import com.cg.ofda.model.OrderDetailsModel;

public interface IOrderService {

	/* Definition of addOrder method for adding order */
	public OrderDetailsModel addOrder(OrderDetailsModel order) throws OrderException;

	/* Definition of updateOrder method for updating order */
	public OrderDetailsModel updateOrder(OrderDetailsModel order) throws OrderException;

	/* Definition of removeOrder method for removing order */
	public boolean removeOrder(Long orderId) throws OrderException;

	/* Definition of viewOrder method for viewing order */
	public OrderDetailsModel viewOrder(Long orderId) throws OrderException;

	/* Definition of viewAllOrders method return all the orders */
	List<OrderDetailsModel> viewAllOrders() throws OrderException;

}
