package muk.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import muk.beans.Student;
import muk.dao.DAOHibernateStudent;

@Repository
public class StudentHibernateDaoImpl implements DAOHibernateStudent
{
@Autowired
private SessionFactory factory;
	
	public void addStudent(Student student) {
		factory.getCurrentSession().save(student);
		
	}

}
