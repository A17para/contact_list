package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeleteContactListLogic;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータ(Stringで配列）の取得
		String StrDelId =request.getParameter("getDelId");

		DeleteContactListLogic delete = new DeleteContactListLogic();
		delete.execute(StrDelId);

//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Delete.jsp");
//		dispatcher.forward(request, response);

//		リダイレクト
		response.sendRedirect("/contact_list/Main");


	}
}
