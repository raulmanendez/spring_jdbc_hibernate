package muk.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import muk.beans.Address;
import muk.beans.Employee;
import muk.dao.DAOEmployee;

@Repository

public class DAOImplEmployee implements DAOEmployee {

	@Autowired
	private SessionFactory factory;

	public Employee getEmployee(int emp_id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Employee emp= session.get(Employee.class, emp_id);
		session.getTransaction().commit();
		return emp;
	}
	
	public void addEmployee(Employee emp) {
		for(Address address:emp.getList_address())
			address.setEmployee(emp);
		
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();

	}

	public List<Employee> getListofEmployee() {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<Employee> list_emp=session.createQuery("from Employee").list();
		session.getTransaction().commit();
		return list_emp;
	}

	public void deleteEmployee(int emp_id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Employee emp=session.get(Employee.class, emp_id);
		if(emp!=null)
		session.delete(emp);
		session.getTransaction().commit();

	}

}
