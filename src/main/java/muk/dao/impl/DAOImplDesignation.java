package muk.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import muk.beans.Designation;
import muk.dao.DAODesignation;

@Repository

public class DAOImplDesignation implements DAODesignation{

	@Autowired
	private SessionFactory factory;
	
	public void add_designation(Designation desig) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.save(desig);
		session.getTransaction().commit();
	}

	public void delete_designation(int desig_id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.createQuery("delete Designation where id="+desig_id).executeUpdate();
		session.getTransaction().commit();
	}

	public List<Designation> getAllDesignations() {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<Designation> list_desig=session.createQuery("from Designation").list();
		session.getTransaction().commit();
		return list_desig;
	}

}
