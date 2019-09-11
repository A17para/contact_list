package model;

import dao.ContactListDAO;

public class DeleteContactListLogic {

	public void execute(int[] delId){
		ContactListDAO dao = new ContactListDAO();
		dao.delete(delId);

	}

}
