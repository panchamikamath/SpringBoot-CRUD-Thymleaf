package kamath.panchami.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kamath.panchami.crud.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		//create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//execute query and get results
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//create a query
		Employee theEmployee = entityManager.find(Employee.class,theId);
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		Employee theEmployee = entityManager.merge(employee);
		//update id from db
		employee.setId(theEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",theId);
		theQuery.executeUpdate();

	}

}
