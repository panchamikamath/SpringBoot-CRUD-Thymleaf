package kamath.panchami.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kamath.panchami.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
