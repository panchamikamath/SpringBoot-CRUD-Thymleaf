package kamath.panchami.springboot.thymleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kamath.panchami.springboot.thymleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//add a method to sort by lastname
	public List<Employee> findAllByOrderByLastNameAsc();
}
