package muk.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import muk.beans.InquiryType;
import muk.beans.RegistrationBean;
import muk.dao.DAORegistration;

@Controller
@RequestMapping("/registration")
public class FormController {
	@Autowired
	DAORegistration dao;

	@RequestMapping("/form")
	public String createRegistrationBean(Model model) {
		model.addAttribute("regis_form", new RegistrationBean());
		model.addAttribute("regis_form_map", getMeMap());
		return "registration_form";
	}
	
	public Map<String,String> getMeMap()
	{
		Map<String, String> map=new HashMap<String, String>();
		map.put("1", "Muki" );
		map.put("2", "Mohit");
		map.put("3", "Anju");
		return map;
	}

	@GetMapping
	public void form() {
	}

	@RequestMapping(method=RequestMethod.POST,value="process_action")
	public String processSubmit(@Valid @ModelAttribute("regis_form") RegistrationBean RegistrationBean,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttrs) {
		
		RegistrationBean.setInquiry(InquiryType.getList());
		
		String message=null;
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors()); 
			System.out.println("we got errors!!");
			message = "Form has errors Bound " + RegistrationBean;
			model.addAttribute("message", message);
			
			model.addAttribute("regis_form", RegistrationBean);
			model.addAttribute("regis_form_map", getMeMap());
			return "registration_form";
		}
		else
		{
			
			dao.AddRegistration(RegistrationBean);
			
			dao.AddRegistrationEnquiryList(RegistrationBean.getInquiry());
			
			dao.AddRegistrationMap(RegistrationBean.getAdditionalInfo());
			
			message = "Form submitted successfully.  Bound " + RegistrationBean;
			redirectAttrs.addFlashAttribute("message", message);

			return "redirect:/registration/form";
		}
		
	}

}
