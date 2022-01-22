package kamath.panchami.springboot.thymleaf.service;

import java.util.List;

import kamath.panchami.springboot.thymleaf.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void deleteById(int theId);
}
