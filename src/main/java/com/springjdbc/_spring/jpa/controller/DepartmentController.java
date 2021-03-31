package com.springjdbc._spring.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjdbc._spring.jpa.model.Department;
import com.springjdbc._spring.jpa.repo.DepartmentRepo;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentRepo deptRepo;
	
	@PostMapping(value = "/saveDept")
	public String saveDept(@RequestBody Department department) {
		deptRepo.save(department);
		return "Dept saved";
	}
	

}
