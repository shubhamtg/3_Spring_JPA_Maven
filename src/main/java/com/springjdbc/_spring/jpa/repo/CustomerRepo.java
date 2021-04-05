package com.springjdbc._spring.jpa.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springjdbc._spring.jpa.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query(value = "select a.id,a.name cust_name,b.id prod_id,b.name from customer a,product b,cust_prod c where a.id = c.cust_id and "
			+ "b.id = c.prod_id and b.id = ?1", nativeQuery = true)
	List<Map<String,Object>> findCustBaseOnProduct(Integer prodId);

}
