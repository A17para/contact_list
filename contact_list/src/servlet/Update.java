package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contract;
import model.GetContactListLogic;
import model.UpdateContactListLogic;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));

//		update,daoを通してデータベースへ接続してidをキーにテーブルデータをselect
		UpdateContactListLogic upContactListLogic = new UpdateContactListLogic();

		List<Contract> list = upContactListLogic.getCheckedDate(id);
		request.setAttribute("list", list);

//		フォワード
		RequestDispatcher disqatcher = request.getRequestDispatcher("/WEB-INF/jsp/Update.jsp");
		disqatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

//		リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String company_name = request.getParameter("company_name");
		String tel = request.getParameter("tel");
		String mail_address = request.getParameter("mail_address");
//		boolean checkResult = false;


//		必須項目の空白確認
//		if (first_name!= null && first_name.length() != 0){
//			checkResult = true;
//		}
//		if (last_name!= null && last_name.length() != 0){
//			checkResult = true;
//		}

//		入力値チェック
//		if(checkResult){

//		リストを追加  ここから！
			Contract entry =  new Contract
					(id,first_name, last_name, company_name, tel, mail_address);
		UpdateContactListLogic updateContactListLogic = new UpdateContactListLogic();
		updateContactListLogic.execute(entry);
//
//	}else{
//		request.setAttribute(("errorMsg"),"未入力欄があります");
//	}

//	リストを取得して、リクエストスコープに保存
	GetContactListLogic getContactListLogic =
			new GetContactListLogic();
	List<Contract> list = getContactListLogic.execute();
	request.setAttribute("list", list);


//	リダイレクト
	response.sendRedirect("/contact_list/Main");

//		フォワード
//		RequestDispatcher disqatcher = request.getRequestDispatcher("/WEB-INF/jsp/Registered.jsp");
//		disqatcher.forward(request, response);





	}

}
