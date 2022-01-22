package kamath.panchami.crud.service;

import java.util.List;

import kamath.panchami.crud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void deleteById(int theId);
}
