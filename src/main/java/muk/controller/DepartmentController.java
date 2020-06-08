package muk.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import muk.beans.Department;
import muk.beans.Designation;
import muk.bo.BODepartment;

@Controller
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private BODepartment dao_department;
	
	@RequestMapping("/add")
	private String viewDept(Model model)
	{
		model.addAttribute("department_obj", new Department());
		model.addAttribute("department_list", dao_department.getAllDepartments());
		return "add_dept";
	}
	
	@RequestMapping("/delete")
	private String deleteDept(Model model,@RequestParam("dept_id") int dept_id,RedirectAttributes redirectAttribute)
	{
		dao_department.delete_department(dept_id);
		redirectAttribute.addFlashAttribute("message","Department Deleted SuccessFully !");
		return "redirect:add";
	}
	
	@RequestMapping(value="/save_department" ,method=RequestMethod.POST)
	private String addDept(@Valid @ModelAttribute Department department,
			Model model,
			BindingResult result,
			RedirectAttributes redirectAttribute)
	{
		if(result.hasErrors())
		{
			model.addAttribute("department_obj", department);
			model.addAttribute("department_list", dao_department.getAllDepartments());
			return "add_dept";
		}
		else
		{
			dao_department.add_department(department);
			redirectAttribute.addFlashAttribute("message","Department Added SuccessFully !");
			return "redirect:add";	
		}
	}
	
	@RequestMapping(value="/get_desig.json")
	private String getDesignation(@RequestParam("dept_id") int dept_id,Model model) throws Exception
	{
		System.out.println("AJAX controller called...");
		model.addAttribute("action","desig_by_dept_id");
		model.addAttribute("designations",dao_department.getAllDesignation(dept_id));
		return "AJAXUtil";
	}
}
