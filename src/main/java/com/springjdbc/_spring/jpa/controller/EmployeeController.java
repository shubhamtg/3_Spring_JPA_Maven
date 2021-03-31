package com.springjdbc._spring.jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjdbc._spring.jpa.model.Employee;
import com.springjdbc._spring.jpa.repo.EmployeeRepo;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepo empRepo;

	@PostMapping("/saveEmp")
	public String saveEmployee(@RequestBody Employee empObj) {
		empRepo.save(empObj);
		return "employee saved";
	}

	@GetMapping("/getEmployee")
	public List<Employee> getEmpList(){
		return empRepo.findAll();
	}

	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id) {
		empRepo.deleteById(id);
		return "employee deleted";
	}

	@GetMapping("getEmpOnBasis/{name}/{city}") // fetch employee on name and city basis
	public List<Employee> getEmployeeNameCity(@PathVariable String name,@PathVariable String city){
		return empRepo.findByNameAndCity(name,city);
	}

	@PutMapping("/updateEmp")
	public String updateEmp(@RequestBody Employee empObj) {
		Optional<Employee> obj = empRepo.findById(empObj.getId());
		if(obj.isPresent()) {
			obj.get().setName(empObj.getName());
			obj.get().setCity(empObj.getCity());
			empRepo.save(obj.get());
			return "employee updated..";
		}
		return "employee not found";
	}
	@PutMapping("/updateAllNames")
	public String updateCities(@RequestParam String name, @RequestParam String city) {
		empRepo.updateEmployeeNameByCity(name, city);
		return "names updated";

	}

}
