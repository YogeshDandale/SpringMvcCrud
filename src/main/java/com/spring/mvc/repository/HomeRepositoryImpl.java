package com.spring.mvc.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.mvc.model.Employee;

@Repository
public class HomeRepositoryImpl implements HomeRepository {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public int saveEmployee(Employee employee) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		tx.commit();
		session.close();
		return 0;
		
	}
	
	@Override
	public List<Employee> getAllEmployee() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee");
		List<Employee> result = (List<Employee>) query.list();

		tx.commit();
		session.close();
		return result;
		
	}

	@Override
	public Employee editEmployeeData(Employee employee) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee2 = session.get(Employee.class, employee.getId());
		tx.commit();
		session.close();
		return employee2;
		
	}

	@Override
	public int updateEmployeeData(Employee employee) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery(
				"update Employee set name='" + employee.getName() + "',addr='" + employee.getAddr() + "',mobno='" + employee.getMobno()
						+ "',uname='" + employee.getUname() + "',pass='" + employee.getPass() + "' where id='" + employee.getId() + "'");
		int i = query.executeUpdate();
		tx.commit();
		session.close();
		return i;
	}

	@Override
	public int deleteEmployee(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("delete from Employee where id='" + id + "'");
		int id1 = query.executeUpdate();
		tx.commit();
		session.close();
		return id1;
		
	}

	@Override
	public Employee findByName(String name) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Employee where name='" + name + "'");
		Employee result = (Employee) query.getSingleResult();
		tx.commit();
		session.close();
		return result;
		
	}
	

}
