package model;

import dao.ContactListDAO;

public class DeleteContactListLogic {

	public void execute(String strDelId){
		ContactListDAO dao = new ContactListDAO();
		dao.delete(strDelId);

	}

}
