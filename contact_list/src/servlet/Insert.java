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
import model.PostContactListLogic;

/**
 * Servlet implementation class NewRegistration
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Creat.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

//		リクエストパラメーターの取得
		request.setCharacterEncoding("UTF-8");


		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String company_name = request.getParameter("company_name");
		String tel = request.getParameter("tel");
		String mail_address = request.getParameter("mail_address");

//		リストを追加
			Contract entry =  new Contract
					(first_name, last_name, company_name, tel, mail_address);
		PostContactListLogic postContactListLogic = new PostContactListLogic();
		postContactListLogic.execute(entry);


//	リストを取得して、リクエストスコープに保存
	GetContactListLogic getContactListLogic =
			new GetContactListLogic();
	List<Contract> list = getContactListLogic.execute();
	request.setAttribute("list", list);

//	リダイレクト
	response.sendRedirect("/contact_list/Main");


	}

}



