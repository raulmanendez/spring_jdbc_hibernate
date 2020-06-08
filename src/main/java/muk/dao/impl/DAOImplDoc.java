package muk.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import muk.beans.Document;
import muk.dao.DAODoc;

@Repository
public class DAOImplDoc implements DAODoc  {

	@Autowired
	private SessionFactory factory;
	
	public void addDoc(Document doc) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		session.save(doc);
		session.getTransaction().commit();
	}
	
	public List<Document> getAllDocs() {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		List<Document> list_docs=session.createQuery("from Document").list();
		session.getTransaction().commit();
		return list_docs;
	}

	public Document getDoc(int doc_id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Document doc=session.get(Document.class,doc_id);
		session.getTransaction().commit();
		return doc;
	}

	public void deleteDoc(int doc_id) {
		Session session=factory.getCurrentSession();
		session.beginTransaction();
		Document doc=session.get(Document.class,doc_id);
		session.delete(doc);
		session.getTransaction().commit();
	}

}
