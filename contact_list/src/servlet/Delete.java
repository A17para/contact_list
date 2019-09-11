package servlet;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
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

    /**
     * @see HttpServlet#HttpServlet()
     */
//    public Delete() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

//		リダイレクト
		response.sendRedirect("/contact_list/Main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

//		リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータ(Stringで配列）の取得
		String[] StrDelId =request.getParameterValues("getDelId");
//		配列をString型からint型へ変換
		int[]delId = Stream.of(StrDelId).mapToInt(Integer::parseInt).toArray();

		DeleteContactListLogic delete = new DeleteContactListLogic();
		delete.execute(delId);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Delete.jsp");
		dispatcher.forward(request, response);

	}

}
