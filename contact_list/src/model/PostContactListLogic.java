package model;

import dao.ContactListDAO;

public class PostContactListLogic {
	public void execute(Contract list){
		ContactListDAO dao = new ContactListDAO();
		dao.create(list);

	}

}
