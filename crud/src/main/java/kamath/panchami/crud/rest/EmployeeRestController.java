package kamath.panchami.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kamath.panchami.crud.entity.Employee;
import kamath.panchami.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//inject employee service
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employee" and return employees
	@GetMapping("employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// expose "/employee/{employeeId}" and return employees
	@GetMapping("employees/{employeeId}")
	public Employee findEmployee(@PathVariable int employeeId){
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null)
			throw new RuntimeException("Employee Id not found - " + employeeId);
		return theEmployee;
	}
	
	// expose "/employee" to save employee
	@PostMapping("employees")
	public Employee saveEmployee(@RequestBody Employee employee){
		employeeService.save(employee);
		return employee;
	}
	
	// expose "/employee/{employeeId}" to update employee
	@PutMapping("employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		employeeService.save(employee);
		return employee;
	}
	
	// expose "/employee/{employeeId}" to delete employee
	@DeleteMapping("employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null)
			throw new RuntimeException("Employee Id not found - " + employeeId);
		employeeService.deleteById(employeeId);
		return "Employee deleted with Id - " + employeeId;
	}

}
