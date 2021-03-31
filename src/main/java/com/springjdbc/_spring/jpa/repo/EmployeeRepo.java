package com.springjdbc._spring.jpa.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springjdbc._spring.jpa.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	List<Employee> findByNameAndCity(String name,String city);
	
	@Transactional
	@Modifying
	
	//@Query(value = "update employee set name = :name where city = :city", nativeQuery = true)
	//void updateEmployeeNameByCity(@Param("name") String name, @Param("city") String city);
	
	@Query(value = "update employee set name = ?1 where city = ?2", nativeQuery = true)
	void updateEmployeeNameByCity(String name,String city);

}
