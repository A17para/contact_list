package dao;

import java.util.List;

import model.Contract;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ContactListDAO dao = new  ContactListDAO();
		List<Contract> list = dao.findAll();
		for (Contract test : list){
			System.out.println(test.getId());
			System.out.println(test.getFirst_name());
			System.out.println(test.getLast_name());
			System.out.println(test.getCompany_name());
			System.out.println(test.getTel());
			System.out.println(test.getMail_address());

		}



	}

}
