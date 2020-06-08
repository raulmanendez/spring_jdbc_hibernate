package muk.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muk.beans.Document;
import muk.bo.BODoc;
import muk.dao.DAODoc;

@Service
public class ImplBoDoc implements  BODoc{

	@Autowired
	DAODoc dao_doc;
	
	public void addDoc(Document doc) {
		dao_doc.addDoc(doc);
	}

	public List<Document> getAllDocs()
	{
		return dao_doc.getAllDocs();
	}

	public Document getDoc(int doc_id) {
		return dao_doc.getDoc(doc_id);
	}
	
	public void deleteDoc(int doc_id) {
		dao_doc.deleteDoc(doc_id);
	}
}
