package com.springjdbc._spring.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.springjdbc._spring.jpa.model.Employee;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ApplicationTests {
	
	@Autowired
	private TestRestTemplate template;
	
	@Test
	public void testGetAllEmployees() {
		ResponseEntity<Employee[]> entity = template.getForEntity("/getEmployee", Employee[].class);
		assertEquals(2, entity.getBody().length);
	}
	



}
