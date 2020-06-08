package muk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import muk.beans.Student;
import muk.dao.DAOStudent;

@Controller
public class StudentController {
	@Autowired
	DAOStudent dao_student;
	
	@GetMapping("student_add")
	public String add_student(Model model) {
		model.addAttribute("student_object", new Student());
		
		List<Student> list_stud=dao_student.get_students_from_table();
		model.addAttribute("list_stud", list_stud);
		
		return "student_form";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="student_add_data")
	public String get_student_data(@Valid @ModelAttribute Student student,
			BindingResult br,
			Model model)
	{
		if(br.hasErrors())
		{
			System.out.println("Binding Result Has Some Errors..");
			
			List<Student> list_stud=dao_student.get_students_from_table();
			model.addAttribute("list_stud", list_stud);
			
			return "student_form";
		}
		else
		{
			dao_student.AddDataInTableForMe(student);
			return "redirect:student_add";
		}
		
		
		
	}
}
