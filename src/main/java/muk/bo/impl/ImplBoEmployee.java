package muk.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import muk.beans.Employee;
import muk.bo.BOEmployee;
import muk.dao.DAOEmployee;

@Service

public class ImplBoEmployee implements BOEmployee{
	
	@Autowired
	private DAOEmployee dao_employee;

	public Employee getEmployee(int emp_id) {
		return dao_employee.getEmployee(emp_id);
	}
	
	public void addEmployee(Employee emp) {
		dao_employee.addEmployee(emp);
		
	}

	public List<Employee> getListofEmployee() {
		return dao_employee.getListofEmployee();
	}

	public void deleteEmployee(int emp_id) {
		dao_employee.deleteEmployee(emp_id);
		
	}

	
}
