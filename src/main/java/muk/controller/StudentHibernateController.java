package muk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import muk.beans.Student;

@Controller
@RequestMapping("/hiber_stud")
public class StudentHibernateController {

	@RequestMapping("/add")
	public String addStudent(Model model)
	{
		model.addAttribute("student_bean",new Student());
		
		return "student_form_hiber";
	}
}
