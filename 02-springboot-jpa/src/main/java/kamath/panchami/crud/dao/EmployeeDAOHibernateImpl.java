package kamath.panchami.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kamath.panchami.crud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for Entity manager
	private EntityManager entityManager;
			
	//set constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		//create a query
		Employee employee = currentSession.get(Employee.class, theId);
		
		return employee;
	}

	@Override
	public void save(Employee employee) {
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int theId) {
		//get current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",theId);
		
		theQuery.executeUpdate();
		
	}

}
