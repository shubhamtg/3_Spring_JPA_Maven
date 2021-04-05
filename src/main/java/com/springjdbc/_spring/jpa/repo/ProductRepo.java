package com.springjdbc._spring.jpa.repo;


import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springjdbc._spring.jpa.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	
	@Transactional
	
	
	//1.identify list of products which are not sold
	
	@Query(value = "select a.* from product a left join cust_prod b on a.id = b.prod_id where b.prod_id is null", nativeQuery = true)
	List<Product> findByIdNotIn();

	//2.get all products which are purchased by particular customers
	
	@Query(value = "select a.id,a.name cust_name,b.id prod_id,b.name from customer a,product b,cust_prod c where a.id = c.cust_id and "
			+ "b.id = c.prod_id and a.id = ?1", nativeQuery = true)
	List<Map<String,Object>> findProdPurchase(Integer custId);

}
