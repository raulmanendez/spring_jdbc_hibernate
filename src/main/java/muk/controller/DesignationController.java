package muk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import muk.beans.Designation;
import muk.bo.BODepartment;
import muk.bo.BODesignation;

@Controller
@RequestMapping("/desig")
public class DesignationController {

	@Autowired
	private BODesignation dao_designation;
	
	@Autowired
	private BODepartment dao_department;
	
	@RequestMapping("/add")
	private String viewDesig(Model model)
	{
		model.addAttribute("designation_obj", new Designation());
		model.addAttribute("department_list", dao_department.getAllDepartments());
		model.addAttribute("designation_list", dao_designation.getAllDesignations());
		return "add_desig";
	}
	
	@RequestMapping("/delete")
	private String deleteDesignatio(Model model,@RequestParam("desig_id") int desig_id,RedirectAttributes redirectAttribute)
	{
		dao_designation.delete_designation(desig_id);
		redirectAttribute.addFlashAttribute("message","Designation Deleted SuccessFully !");
		return "redirect:add";
	}
	
	@RequestMapping("/save_designation")
	private String addDesignation(@ModelAttribute("designation_obj") Designation designation,RedirectAttributes redirectAttribute)
	{
		dao_designation.add_designation(designation);
		redirectAttribute.addFlashAttribute("message","Designation Added SuccessFully !");
		return "redirect:add";
	}

}
