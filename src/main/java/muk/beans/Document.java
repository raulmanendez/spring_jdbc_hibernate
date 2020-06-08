package muk.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Entity
public class Document {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String doc_type;
	private String doc_name;
	
	@Size(min=1,message="Employee Name is Required !")
	private String emp_name;
	
	@Transient
	private MultipartFile multi_doc;
	
	@Lob
	private byte[] doc;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoc_type() {
		return doc_type;
	}
	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}
	public String getDoc_name() {
		return doc_name;
	}
	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public MultipartFile getMulti_doc() {
		return multi_doc;
	}
	public void setMulti_doc(MultipartFile multi_doc) {
		this.multi_doc = multi_doc;
	}
	public byte[] getDoc() {
		return doc;
	}
	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

}
