package model;

import java.util.List;

import dao.ContactListDAO;
public class GetContactListLogic {

	public List<Contract> execute(){
		ContactListDAO dao = new ContactListDAO();
		List<Contract> list = dao.findAll();
		return list;

	}
}
