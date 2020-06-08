package muk.convertors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import muk.beans.InquiryType;

@Component
public class EnquiryTypeObjectConvertor implements Converter<String, InquiryType> {

	public InquiryType convert(String Source) {
		System.out.println("My convertor has been called !!!");
		return new InquiryType(0, Source);
	}

}
