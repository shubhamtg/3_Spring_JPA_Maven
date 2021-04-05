package com.springjdbc._spring.jpa.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springjdbc._spring.jpa.model.Product;
import com.springjdbc._spring.jpa.model.Employee;
import com.springjdbc._spring.jpa.repo.ProductRepo;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepo prodRepo;
	
	//1. Identify list of products which are not sold

	@GetMapping("/getUnsoldProdList")
	public List<Product> getUnsoldProdList(){
		return prodRepo.findByIdNotIn();
	}
	
	//2. Get all products which are purchased by particular customer

	@GetMapping("/prodListForCust/{cust_id}")
	public List<Map<String,Object>> getProdListForCustomer(@PathVariable Integer cust_id){
		
		return prodRepo.findProdPurchase(cust_id);
	}
	
	


}
