package muk.dao;

import java.util.List;

import muk.beans.Document;

public interface DAODoc {
	void addDoc(Document doc);
	Document getDoc(int doc_id);
	List<Document> getAllDocs();
	void deleteDoc(int doc_id);
}
