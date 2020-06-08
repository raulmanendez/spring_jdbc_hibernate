package muk.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import muk.beans.Department;
import muk.beans.Designation;
import muk.bo.BODepartment;
import muk.dao.DAODepartment;

@Service

public class ImplBoDepartment implements BODepartment{

	@Autowired
	private DAODepartment dao_department;
	public void add_department(Department dept) {
		dao_department.add_department(dept);
		
	}

	public List<Department> getAllDepartments() {
		return dao_department.getAllDepartments();
	}

	public void delete_department(int dept_id) {
		dao_department.delete_department(dept_id);
		
	}

	public List<Designation> getAllDesignation(int dept_id) {
		return dao_department.getAllDesignation(dept_id);
	}

}
