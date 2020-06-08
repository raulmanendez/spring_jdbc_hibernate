package muk.beans;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.loader.plan.build.internal.spaces.EntityQuerySpaceImpl;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;
import muk.annotatations.MaskFormat;

public class RegistrationBean {
	
	@NotEmpty(message="You must Fill in a Name !")
	private String name;
	
	@Min(value=21,message="Age must be 21 or more than 21 !")
	private int age;

	@DateTimeFormat(iso=ISO.DATE)
	@Past(message="Date Must be less than today !")
	private Date birthDate;

	@MaskFormat("(###) ###-####")
	private String phone;

	@NumberFormat(pattern="$###,###.00")
	private BigDecimal currency;

	@NumberFormat(style=Style.PERCENT)
	private BigDecimal percent;
	
	private List<InquiryType> inquiry=InquiryType.getList();
	
	private InquiryType inquiry_obj=new InquiryType(1, "mukii");
	
	private String inquiryDetails;
	
	private boolean subscribeNewsletter;
	
	private Map<String, String> additionalInfo;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getCurrency() {
		return currency;
	}

	public void setCurrency(BigDecimal currency) {
		this.currency = currency;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public List<InquiryType> getInquiry() {
		return inquiry;
	}

	public InquiryType getInquiry_obj() {
		return inquiry_obj;
	}

	public void setInquiry_obj(InquiryType inquiry_obj) {
		this.inquiry_obj = inquiry_obj;
	}

	public void setInquiry(List<InquiryType> inquiry) {
		this.inquiry = inquiry;
	}

	public String getInquiryDetails() {
		return inquiryDetails;
	}

	public void setInquiryDetails(String inquiryDetails) {
		this.inquiryDetails = inquiryDetails;
	}

	public boolean isSubscribeNewsletter() {
		return subscribeNewsletter;
	}

	public void setSubscribeNewsletter(boolean subscribeNewsletter) {
		this.subscribeNewsletter = subscribeNewsletter;
	}

	public Map<String, String> getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(Map<String, String> additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	@Override
	public String toString() {
		return "RegistrationBean [name=" + name + ", age=" + age + ", birthDate=" + birthDate + ", phone=" + phone
				+ ", currency=" + currency + ", percent=" + percent + ", inquiry=" + inquiry.toString() + ", inquiry_obj="
				+ inquiry_obj.toString() + ", inquiryDetails=" + inquiryDetails + ", subscribeNewsletter=" + subscribeNewsletter
				+ ", additionalInfo=" + additionalInfo + "]";
	}

	

}
