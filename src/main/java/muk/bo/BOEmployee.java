package muk.bo;

import java.util.List;

import muk.beans.Employee;

public interface BOEmployee {
	
	void addEmployee(Employee emp);
	Employee getEmployee(int emp_id);
	List<Employee> getListofEmployee();
	void deleteEmployee(int emp_id);
}
