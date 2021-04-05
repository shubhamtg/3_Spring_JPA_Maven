package com.springjdbc._spring.jpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjdbc._spring.jpa.model.Customer;
import com.springjdbc._spring.jpa.model.Product;
import com.springjdbc._spring.jpa.repo.CustomerRepo;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepo custRepo;
	
	@PostMapping("/saveCust")
	public String saveCustomer(@RequestBody Customer cust) {
		custRepo.save(cust);
		return "Cust saved";
	}
	

	
	
	// 3.identify customers who have purchased particular product, so we can get target audience.
	
	@GetMapping("/custListByProduct/{prod_id}")
	public List<Map<String,Object>> getCustListByProduct(@PathVariable Integer prod_id){
		
		return custRepo.findCustBaseOnProduct(prod_id);
	}

}
