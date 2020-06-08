package muk.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import muk.beans.InquiryType;
import muk.beans.RegistrationBean;

public class DAORegistration {

	@Autowired
	private JdbcTemplate myTemplate;

	public JdbcTemplate getMyTemplate() {
		return myTemplate;
	}

	public void setMyTemplate(JdbcTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}

	public void AddRegistration(RegistrationBean regis) {
		System.out.println(regis);
		System.out.println(this.myTemplate);
		this.myTemplate.update("insert into regis (name,age,dob,phone,currency,percent,enquiry,subscribenewsletter) values (?,?,?,?,?,?,?,?)", 
				regis.getName(),
				regis.getAge(),
				regis.getBirthDate(),
				regis.getPhone(),
				regis.getCurrency(),
				regis.getPercent(),
				regis.getInquiry_obj().getType(),
				regis.isSubscribeNewsletter());
	}
	
	public void AddRegistrationMap(Map<String,String> my_map) {
		for(Map.Entry<String,String> entry:my_map.entrySet())
		{
		this.myTemplate.update("insert into regis_map (map_value) values (?)", 
				entry.getValue());
		}
	}
	
	public void AddRegistrationEnquiryList(List<InquiryType> enquiry_list) {
		for(InquiryType inq:enquiry_list)
		{
		this.myTemplate.update("insert into regis_enquiry_list (enquiry_id) values (?)", 
				inq.getType());
		}
		}

}
