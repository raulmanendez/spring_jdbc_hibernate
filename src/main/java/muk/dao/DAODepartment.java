package muk.dao;

import java.util.List;

import muk.beans.Department;
import muk.beans.Designation;

public interface DAODepartment {
	void add_department(Department dept);
	void delete_department(int dept_id);
	List<Department> getAllDepartments();
	List<Designation> getAllDesignation(int dept_id);
}
