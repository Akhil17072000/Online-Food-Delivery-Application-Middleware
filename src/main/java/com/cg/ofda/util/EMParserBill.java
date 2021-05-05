package com.cg.ofda.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofda.entity.BillEntity;
import com.cg.ofda.model.BillModel;
import com.cg.ofda.repository.IBillRepository;

@Service
public class EMParserBill {
	
	/*
	 * Bill Repository is Autowired 
     */
	
	@Autowired
	private IBillRepository billRepo;
	
	/*
	 * EMParserOrderDetails is Autowired 
     */
	
	@Autowired
	private EMParserOrderDetails orderParser;
	
	/*
	 * Default constructor 
     */
	
	public EMParserBill() {
		this.orderParser= new EMParserOrderDetails();
	}
	
	/*
	 * Parameterized constructor 
     */

	public EMParserBill(IBillRepository billRepo) {
		super();
		this.billRepo = billRepo;
		this.orderParser= new EMParserOrderDetails();
	}
	
	/*
	 * Method to parse Entity to Model
     */

	public BillModel parse(BillEntity source) {
		return source==null ? null:
			new BillModel (source.getBillId(),
					orderParser.parse(source.getOrder()),
					source.getTotalItem(),
					source.getTotalCost(),
					source.getBillDate());
	}
	
	/*
	 * Method to parse Model to Entity
     */
	
	public BillEntity parse(BillModel source) {
		return source==null ? null:
			new BillEntity (source.getBillId(),
					orderParser.parse(source.getOrder()),
					source.getTotalItem(),
					source.getTotalCost(),
					source.getBillDate());
	}

}
