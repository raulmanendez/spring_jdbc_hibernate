package muk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import muk.beans.Student;

public class DAOStudent {
	private JdbcTemplate myTemplate;

	public JdbcTemplate getMyTemplate() {
		return myTemplate;
	}

	public void setMyTemplate(JdbcTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}

	public void createDataBaseForMe() {
		this.myTemplate.execute("create database spring_jdbc_db");

	}

	public void createATableForMe() {
		this.myTemplate.execute("create table student (id int not null,student_name varchar(100))");
	}
	
	public int getNewStudentID() {
		Integer count = this.myTemplate.queryForObject("select max(id) from student", Integer.class);
		return count==null?1:count+1;
	}

	public void AddDataInTableForMe(Student student) {
		this.myTemplate.update("insert into student (id,student_name,student_class,student_age) values (?,?,?,?)", getNewStudentID(), student.getStudent_name(),student.getStudent_class(),student.getStudent_age());
	}

	public int count_data_in_table() {
		int count = this.myTemplate.queryForObject("select count(*) from student", Integer.class);
		System.out.println("total Rows in table are:" + count);
		return count;
	}

	public int count_anchal_name_in_table() {
		int count = this.myTemplate.queryForObject("select count(*) from student where student_name=?", Integer.class,
				"Anchal");
		System.out.println("total Rows in table named Anchal are:" + count);
		return count;
	}

	public String get_name_with_id_from_table(int id) {
		String student_name = this.myTemplate.queryForObject("select student_name from student where id=?",
				String.class, id);
		System.out.println("The name associated with id is:" + student_name);
		return student_name;
	}

	public Student get_student_object_from_table(int id) {
		return this.myTemplate.queryForObject("select * from student where id=?", new RowMapper<Student>() {

			
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setStudent_name(rs.getString(2));
				return student;
			}

		},id);
	}
	
	public List<Student> get_students_from_table() {
		return this.myTemplate.query("select * from student", new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setStudent_name(rs.getString(2));
				student.setStudent_class(rs.getString(3));
				student.setStudent_age(rs.getInt(4));
				return student;
			}

		});
	}
	
	public List<Map<String,Object>> get_students_from_table_v2(){
		return this.myTemplate.queryForList("select * from student");
	}
}
