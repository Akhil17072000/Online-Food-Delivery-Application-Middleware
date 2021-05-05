package com.cg.ofda.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.CustomerEntity;
import com.cg.ofda.model.CustomerModel;
import com.cg.ofda.repository.ICustomerRepository;

@Service
public class EMParserCustomer {
	
	/*
	 * Customer Repository is Autowired 
     */

	@Autowired
	private ICustomerRepository customerRepo;
	
	/*
	 * Default constructor 
     */
	
	public EMParserCustomer() {
		//default
	}
	
	/*
	 * Parameterized constructor 
     */
	
	public EMParserCustomer(ICustomerRepository customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	/*
	 * Method to parse Entity to Model
     */

	public CustomerModel parse(CustomerEntity source) {
		return source==null ? null:
			new CustomerModel(source.getCustomerId(),
					source.getFirstName(),
					source.getLastName(),
					source.getGender(),
					source.getAge(),
					source.getMobileNumber(),
					source.getAddress(),
					source.getEmail());
	}
	
	/*
	 * Method to parse Model to Entity
     */
	
	public CustomerEntity parse(CustomerModel source) {
		return source==null ? null:
			new CustomerEntity(source.getCustomerId(),
					source.getFirstName(),
					source.getLastName(),
					source.getGender(),
					source.getAge(),
					source.getMobileNumber(),
					source.getAddress(),
					source.getEmail());
	}
	
	

}