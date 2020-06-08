package muk.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import muk.beans.Document;
import muk.beans.Employee;
import muk.bo.BODoc;

@Controller
@RequestMapping("/doc")
public class DocController {

	@Autowired
	private BODoc bo_doc;
	
	@RequestMapping("/get_page")
	public String get_upload_page(Model model,Document doc)
	{
		model.addAttribute("doc_obj",doc==null?new Document():doc);
		model.addAttribute("doc_list_obj",bo_doc.getAllDocs());
		return "doc_upload";
	}
	
	@RequestMapping("/save_doc")
	public String save_doc(
			RedirectAttributes redirectAttribute,
			@RequestParam("multi_doc") MultipartFile multipart_file,
			@Valid @ModelAttribute("doc_obj") Document doc,
			BindingResult br,
			Model model) throws Exception
	{
		if(multipart_file.getBytes().length==0)
			{
			br.rejectValue("multi_doc", "error.multi_doc","Please select a Document !");
			}
		
		
		if(br.hasErrors())
		{
			redirectAttribute.addFlashAttribute("message","Document Contains Errors !");
			return get_upload_page(model,doc);
		}
		else
		{
			redirectAttribute.addFlashAttribute("message","Document Uploaded Successfullly !");
			doc.setDoc(multipart_file.getBytes());
			doc.setDoc_type(multipart_file.getContentType());
			doc.setDoc_name(multipart_file.getOriginalFilename());
			bo_doc.addDoc(doc);
			
			return "redirect:get_page";
		}
		
	}
	
	@RequestMapping("/get_doc")
	private void get_doc (
			@RequestParam("doc_id") int doc_id,
			HttpServletResponse response) throws Exception
	{
		response.setContentType("image/jpg");
		OutputStream o=response.getOutputStream();
		Document doc=bo_doc.getDoc(doc_id);
		if(doc!=null)
			o.write(doc.getDoc());
		o.flush();
		o.close();
	}
	
	@RequestMapping("/delete_doc")
	private String delete_doc (RedirectAttributes redirectAttribute,
			@RequestParam("doc_id") int doc_id) throws Exception
	{
		redirectAttribute.addFlashAttribute("message","Document Deleted Successfully !");
		bo_doc.deleteDoc(doc_id);
		return "redirect:get_page";
	}
}
