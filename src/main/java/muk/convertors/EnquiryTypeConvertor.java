package muk.convertors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import muk.beans.InquiryType;

@Component
public class EnquiryTypeConvertor implements Converter<String, List<InquiryType>>{

	public List<InquiryType> convert(String Source) {
		System.out.println("My convertor has been called !!!");
		List<InquiryType> list_enq=new ArrayList<InquiryType>();
		list_enq.add(new InquiryType(0, Source));
		
		return list_enq;
	}
}
