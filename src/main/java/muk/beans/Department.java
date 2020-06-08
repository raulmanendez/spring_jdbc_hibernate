package muk.beans;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message="Departmenet Code is Required !")
	private String dept_code;
	@NotEmpty(message="Departmenet Name is Required !")
	private String department;
	
	@Autowired
	@Resource
	@OneToMany(mappedBy="department",targetEntity=Designation.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Designation> list_desig;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDept_code() {
		return dept_code;
	}


	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public List<Designation> getList_desig() {
		return list_desig;
	}


	public void setList_desig(List<Designation> list_desig) {
		this.list_desig = list_desig;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", dept_code=" + dept_code + ", department=" + department + ", getId()="
				+ getId() + ", getDept_code()=" + getDept_code() + ", getDepartment()=" + getDepartment()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
