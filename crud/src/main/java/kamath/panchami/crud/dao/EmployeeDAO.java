package kamath.panchami.crud.dao;

import java.util.List;

import kamath.panchami.crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee employee);
	
	public void deleteById(int theId);
}
