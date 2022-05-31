package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FavoritesDao;

/**
 * Servlet implementation class sevletUpdateMylistAction
 */
@WebServlet("/member/update_mylist.do")
public class sevletUpdateMylistAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nickname = request.getParameter("nickname");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		FavoritesDao.getInstance().updateForMyList(nickname, idx);
		
	}

}
