package muk.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import muk.beans.Student;
import muk.bo.BOStudent;
import muk.dao.impl.StudentHibernateDaoImpl;

@Service
public class ImplBoStudent implements BOStudent{

	@Autowired
	private StudentHibernateDaoImpl dao;
	
	public void addStudent(Student student) {
		dao.addStudent(student);
	}

}
