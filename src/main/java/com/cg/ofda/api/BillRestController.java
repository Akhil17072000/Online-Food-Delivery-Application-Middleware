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

import com.cg.ofda.exception.BillException;
import com.cg.ofda.model.BillModel;
import com.cg.ofda.service.IBillService;

@RestController
@RequestMapping(path="/bill")
public class BillRestController {
	
	/*
	 * Bill Service is Autowired 
     */
	
	@Autowired
	private IBillService billService;
	
	/*
	 * to add a bill
	 * return : bill
	 * params : NIL
	 */
	@PostMapping
	public ResponseEntity<BillModel>addBill(@RequestBody BillModel bill)throws BillException{
		bill=billService.addBill(bill);
		return new ResponseEntity<>(bill, HttpStatus.CREATED);
	}
	
	/*
	 * to modify a bill
	 * return : bill
	 * params : NIL
	 */
	@PutMapping
	public ResponseEntity<BillModel> updateBill(@RequestBody BillModel bill) throws BillException {
		bill = billService.updateBill(bill);
		 return new ResponseEntity<>(bill, HttpStatus.OK);
		
	}
	
	/*
	 * to delete a bill
	 * return : void
	 * params : billId
	 */
	@DeleteMapping("/{billId}")
	public ResponseEntity<Void> deleteBill(@PathVariable("billId") Long billId) throws BillException{
		ResponseEntity<Void> response = null;
		BillModel bill = billService.viewBill(billId);
		if (bill == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			billService.removeBill(billId);
			response = new ResponseEntity<>(HttpStatus.OK);
			
		}
		return response;
	}
	
	/*
	 * to retrieve a bill
	 * return : bill
	 * params : billId
	 */
	@GetMapping("/{billId}")
	public ResponseEntity<BillModel> viewBill(@PathVariable("billId") Long billId) throws BillException {
		ResponseEntity<BillModel> response = null;
		BillModel bill = billService.viewBill(billId);
		
		if (bill == null) {
			 response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		} else {
			response = ResponseEntity.ok(bill);
		}
		return response;
	}
	/*
	 * to retrieve all bills
	 * return : List<bills>
	 * params : NIL
	 */
	@GetMapping
	public ResponseEntity<List<BillModel>> viewAllBills() throws BillException {
		 return new ResponseEntity<>(billService.viewAllBills(), HttpStatus.OK);
		
	}
	
	
	
	
}