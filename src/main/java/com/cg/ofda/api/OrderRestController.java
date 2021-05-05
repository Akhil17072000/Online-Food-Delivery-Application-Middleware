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

import com.cg.ofda.exception.OrderException;
import com.cg.ofda.model.OrderDetailsModel;
import com.cg.ofda.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	/*
	 * Order Service is Autowired 
     */
	
	@Autowired
	private IOrderService orderService;
	
	/*
	 * to retrieve all orders
	 * return : List<order>
	 * params : NIL
	 */
	
	@GetMapping
	public ResponseEntity<List<OrderDetailsModel>> viewAllOrders() throws OrderException {
		return new ResponseEntity<>(orderService.viewAllOrders(), HttpStatus.OK);
	}
	
	/*
	 * to add an order
	 * return : order
	 * params : NIL
	 */
	
	@PostMapping
	public ResponseEntity<OrderDetailsModel> addOrder(@RequestBody OrderDetailsModel order) throws OrderException {
		order = orderService.addOrder(order);
		return new ResponseEntity<>(order, HttpStatus.CREATED);
	}
	
	/*
	 * to modify an order
	 * return : order
	 * params : NIL
	 */
	
	@PutMapping
	public ResponseEntity<OrderDetailsModel> updateOrder(@RequestBody OrderDetailsModel order) throws OrderException {
		order = orderService.updateOrder(order);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	/*
	 * to delete an order
	 * return : void
	 * params : orderId
	 */
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<Void> removeOrder(@PathVariable("orderId") Long orderId) throws OrderException{
		ResponseEntity<Void> response = null;
		OrderDetailsModel order = orderService.viewOrder(orderId);
		if (order == null) {
			response = ResponseEntity.notFound().build();
		} else {
			orderService.removeOrder(orderId);
			response = ResponseEntity.ok().build();
		}
		return response;
	}
	
	/*
	 * to retrieve an order
	 * return : order
	 * params : orderId
	 */
	
	@GetMapping("/{orderId}")
	public ResponseEntity<OrderDetailsModel> viewOrder(@PathVariable("orderId") Long orderId) throws OrderException {
		ResponseEntity<OrderDetailsModel> response = null;
		OrderDetailsModel order = orderService.viewOrder(orderId);
		if (order == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			orderService.viewOrder(orderId);
			response = new ResponseEntity<>(order, HttpStatus.OK);
		}
		return response;
	}
}