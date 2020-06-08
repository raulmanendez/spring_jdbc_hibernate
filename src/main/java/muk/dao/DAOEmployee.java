package muk.dao;

import java.util.List;

import muk.beans.Employee;

public interface DAOEmployee {
	Employee getEmployee(int emp_id);
	void addEmployee(Employee emp);
	List<Employee> getListofEmployee();
	void deleteEmployee(int emp_id);
}

