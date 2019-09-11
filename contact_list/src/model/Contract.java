package model;

import java.io.Serializable;

public class Contract implements Serializable {
	private int id;
	private String first_name;
	private String last_name;
	private String company_name;
	private String tel;
	private String mail_address;

	public Contract(){}
	public Contract(
			String first_name,
			String last_name,
			String company_name,
			String tel,
			String mail_address
			){
		this.first_name=first_name;
		this.last_name=last_name;
		this.company_name=company_name;
		this.tel=tel;
		this.mail_address=mail_address;
	}

	public Contract(
			int id,
			String first_name,
			String last_name,
			String company_name,
			String tel,
			String mail_address
			){
		this.id=id;		this.first_name=first_name;
		this.last_name=last_name;
		this.company_name=company_name;
		this.tel=tel;
		this.mail_address=mail_address;
	}
	public int getId(){ return id;}
	public String getFirst_name(){ return first_name; }
	public String getLast_name(){ return last_name; }
	public String getCompany_name(){ return company_name; }
	public String getTel(){ return tel; }
	public String getMail_address(){ return mail_address;}


}
