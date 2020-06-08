package muk.controller;

import java.io.OutputStream;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import muk.beans.Employee;
import muk.bo.BODepartment;
import muk.bo.BODesignation;
import muk.bo.BOEmployee;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private BODepartment bo_dept;
	
	@Autowired
	private BODesignation bo_desig;
	
	@Autowired
	private BOEmployee bo_employee;
	
	@RequestMapping("/add")
	public String addEmp(Model model)
	{
		model.addAttribute("department_list",bo_dept.getAllDepartments());
		model.addAttribute("designation_list",bo_desig.getAllDesignations());
		
		model.addAttribute("employee_list",bo_employee.getListofEmployee());
		model.addAttribute("employee_obj",new Employee());
		return "add_emp";
	}
	
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam("emp_id") int emp_id,RedirectAttributes redirectattribute)
	{
		bo_employee.deleteEmployee(emp_id);
		redirectattribute.addFlashAttribute("message","The Employee Deleted Successfully !");
		return "redirect:add";
	}
	
	@RequestMapping("/save_employee")
	private String save_employee (
			//@RequestPart("image") MultipartFile emp_image,
			//@ModelAttribute ModelMap model_map,
			@ModelAttribute Employee emp,
			RedirectAttributes redirectattribute) throws Exception
	{
		//System.out.println("model_map::"+model_map);
		//System.out.println("emp::"+emp);
		//System.out.println("emp photo::"+emp.getImage().length);
		//System.out.println("emp name::"+emp.getName());
		//System.out.println(emp_image);
		//emp.setImage(emp_image.getBytes());
		bo_employee.addEmployee(emp);
		
		//redirectattribute.addFlashAttribute("message","The Employee Added Successfully !");
		return "redirect:add";
	}
	
	@RequestMapping("/get_employee_image")
	private void get_employee_image (
			@RequestParam("employee_id") int emp_id,
			HttpServletResponse response) throws Exception
	{
		response.setContentType("image/jpg");
		OutputStream o=response.getOutputStream();
		Employee emp=bo_employee.getEmployee(emp_id);
		if(emp.getImage()!=null)
			o.write(emp.getImage());
		//System.out.println(emp.getImage().toString());
		o.flush();
		o.close();
	}
	
}
