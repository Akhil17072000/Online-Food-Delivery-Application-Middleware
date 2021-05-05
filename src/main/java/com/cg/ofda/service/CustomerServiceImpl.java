package com.cg.ofda.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.CustomerEntity;
import com.cg.ofda.exception.CustomerException;
import com.cg.ofda.model.CustomerModel;
import com.cg.ofda.repository.ICustomerRepository;
import com.cg.ofda.util.EMParserCustomer;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	public static final String NOT_FOUND = "no customer with id #";
	public static final String PRESENT = "present";
	
	/*
	 * Customer Repository is Autowired 
     */

	@Autowired
	private ICustomerRepository customerRepo;
	
	/*
	 * EMParserCustomer is Autowired 
     */

	@Autowired
	private EMParserCustomer parser;
	
	/*
	 * Default constructor
     */

	public CustomerServiceImpl() {
		this.parser = new EMParserCustomer();
	}

	/*
	 * Parameterized for assigning
	 */

	public CustomerServiceImpl(ICustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
		this.parser = new EMParserCustomer();
	}

	/*
	 * Implementation of addCustomer method to add a customer
	 */

	@Transactional
	@Override
	public CustomerModel addCustomer(CustomerModel customer) throws CustomerException {
		if (customer != null) {
			if (customerRepo.existsById(customer.getCustomerId())) {
				throw new CustomerException("Customer with this id already exists");
			}

			
				customer = parser.parse(customerRepo.save(parser.parse(customer)));	
		}

		return customer;
	}

	/*
	 * Implementation of updateCustomer method to update existing customer
	 */

	@Transactional
	@Override
	public CustomerModel updateCustomer(CustomerModel customer) throws CustomerException {
		CustomerEntity oldCustomer = customerRepo.findById(customer.getCustomerId()).orElse(null);
		if (oldCustomer == null) {
			throw new CustomerException(NOT_FOUND + customer.getCustomerId() + PRESENT);
		} else {
	
			customer = parser.parse(customerRepo.save(parser.parse(customer)));
		}
		return customer;
	}

	/*
	 * Implementation of removeCustomer method to remove existing customer
	 */

	@Transactional
	@Override
	public boolean removeCustomer(Long customerId) throws CustomerException {
		CustomerEntity oldCustomer = customerRepo.findById(customerId).orElse(null);
		boolean isDeleted = false;
		if (oldCustomer == null) {
			throw new CustomerException(NOT_FOUND + customerId + PRESENT);
		} else {
			customerRepo.deleteById(customerId);
			isDeleted = true;
		}
		return isDeleted;
	}

	/*
	 * Implementation of findCustomer method to view a customer
	 */

	@Override
	public CustomerModel findCustomer(Long id) throws CustomerException {
		CustomerEntity oldCustomer = customerRepo.findById(id).orElse(null);
		if (oldCustomer == null) {
			throw new CustomerException(NOT_FOUND + id + PRESENT);
		}
		return parser.parse(customerRepo.findById(id).orElse(null));
	}

	/*
	 * Implementation of findAllCustomer method to view all the customers
	 */

	@Override
	public List<CustomerModel> findAllCustomer() throws CustomerException {

		return customerRepo.findAll().stream().map(parser::parse).collect(Collectors.toList());

	}

}
