package muk.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerOne {

	@GetMapping("page_one")
	public String get_page_one(
			Model model)
	{
		System.out.println("Controller get_page_one Called..");
		model.addAttribute("MyName", "Mukesh Sharma");
		model.addAttribute("MyAge", "22");
		model.addAttribute("Course", "Spring MVC");
		return "page_one";
	}
	
	@GetMapping("page_one_param")
	public String get_page_one_param(
			@RequestParam(required=false) String name,
			@RequestParam(required=false) Integer age,
			@RequestParam(required=false) String course,
			@RequestParam Map<String, Object> map,
			@RequestParam MultiValueMap<String, Object> mvmap,
			@RequestHeader MultiValueMap<String, Object> header_map,
			@CookieValue String JSESSIONID,
			Model model)
	{
		System.out.println("Controller get_page_one_param Called..");
		model.addAttribute("MyName", name);
		model.addAttribute("MyAge", age);
		model.addAttribute("Course", course);
		model.addAttribute("map", map);
		model.addAttribute("mvmap", mvmap);
		model.addAttribute("header_map", header_map);
		model.addAttribute("JSESSIONID", JSESSIONID);
		return "page_one";
	}
}
