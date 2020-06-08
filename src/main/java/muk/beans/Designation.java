package muk.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Designation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String desig_code;
	private String designation;
	
	@Autowired
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	@OneToMany(mappedBy="designation",targetEntity=Employee.class,cascade=CascadeType.ALL)
	private List<Employee> list_employee;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDesig_code() {
		return desig_code;
	}

	public void setDesig_code(String desig_code) {
		this.desig_code = desig_code;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Designation [id=" + id + ", desig_code=" + desig_code + ", designation=" + designation + ", department="
				+ department + "]";
	}
	
}
