package com.springjdbc._spring.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjdbc._spring.jpa.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {

}
