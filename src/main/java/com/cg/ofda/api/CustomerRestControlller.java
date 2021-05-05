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

import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.model.CustomerModel;
import com.cg.ofda.service.ICustomerService;

@RestController
@RequestMapping(path="/customer")
public class CustomerRestControlller {
	
	/*
	 * Customer Service is Autowired 
     */
	
	@Autowired
	private ICustomerService customerService;

	/*
	 * to retrieve all customer
	 * return : List<customer>
	 * params : NIL
	 */
	
	@GetMapping
	public ResponseEntity<List<CustomerModel>> findAllCustomer() throws CustomerException {
		return new ResponseEntity<>(customerService.findAllCustomer(), HttpStatus.OK);
	}
	
	/*
	 * to add a customer
	 * return : customer
	 * params : NIL
	 */
	
	@PostMapping
	public ResponseEntity<CustomerModel> addCustomer(@RequestBody CustomerModel customer) throws CustomerException {
		customer = customerService.addCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
	
	/*
	 * to modify a customer
	 * return : customer
	 * params : NIL
	 */
	
	@PutMapping
	public ResponseEntity<CustomerModel> updateCustomer(@RequestBody CustomerModel customer) throws CustomerException {
		customer = customerService.updateCustomer(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	/*
	 * to delete a customer
	 * return : void
	 * params : customerId
	 */
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Void> removeCustomer(@PathVariable("customerId") Long id) throws CustomerException{
		ResponseEntity<Void> response = null;
		CustomerModel customer = customerService.findCustomer(id);
		if (customer == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			customerService.removeCustomer(id);
			response = new ResponseEntity<>(HttpStatus.OK);
		}
		return response;
	}
	
	/*
	 * to retrieve a customer
	 * return : customer
	 * params : customerId
	 */
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerModel> findCustomer(@PathVariable("customerId") Long id) throws CustomerException {
		ResponseEntity<CustomerModel> response = null;
		CustomerModel customer = customerService.findCustomer(id);
		if (customer == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			customerService.findCustomer(id);
			response = new ResponseEntity<>(customer, HttpStatus.OK);
		}
		return response;
	}
	
	
	
	
}