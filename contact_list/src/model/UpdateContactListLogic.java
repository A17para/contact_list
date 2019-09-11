package model;

import java.util.List;

import dao.ContactListDAO;

public class UpdateContactListLogic {


	public List<Contract> getCheckedDate (int id){
		ContactListDAO dao = new ContactListDAO();
		List<Contract> list = dao.findCheckedDate(id);
		return list;

	}

	public void execute(Contract list){
		ContactListDAO dao = new ContactListDAO();
		dao.update(list);

	}
}
