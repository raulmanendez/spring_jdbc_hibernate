package muk.beans;

import java.util.ArrayList;

public class InquiryType {
	
	
	public InquiryType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}


	private int id=1;
	private String type="Suggestion";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public static ArrayList<InquiryType> getList()
	{
		ArrayList<InquiryType> list_arr=new ArrayList<InquiryType>();
		
		list_arr.add(new InquiryType(1, "comment"));
		list_arr.add(new InquiryType(2, "Suggestions"));
		list_arr.add(new InquiryType(3, "Gaali"));
		
		return list_arr;
	}
	
	
	@Override
	public String toString() {
		return "InquiryType [id=" + id + ", type=" + type + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
	
}