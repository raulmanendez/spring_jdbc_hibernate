package muk.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import muk.beans.Department;
import muk.beans.Designation;
import muk.dao.DAODepartment;

@Repository
public class DAOImplDepartment implements DAODepartment {
 
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public void add_department(Department dept) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.save(dept);
		session.getTransaction().commit();
	}

	@Transactional
	public List<Department> getAllDepartments() {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<Department> list_dept=session.createQuery("from Department").list();
		session.getTransaction().commit();
		 
		 return list_dept;
	}

	@Transactional
	public void delete_department(int dept_id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete Department where id="+dept_id).executeUpdate();
		session.getTransaction().commit();
	}

	public List<Designation> getAllDesignation(int dept_id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<Designation> list_desig=session.createQuery("from Designation where department.id="+dept_id).list();
		session.getTransaction().commit();
		return list_desig;
	}

}
