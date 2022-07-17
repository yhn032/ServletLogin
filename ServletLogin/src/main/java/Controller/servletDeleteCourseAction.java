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
 * Servlet implementation class servletDeleteCourseAction
 */
@WebServlet("/favorites/delete.do")
public class servletDeleteCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int f_idx = Integer.parseInt(request.getParameter("f_idx"));
		
		int res = FavoritesDao.getInstance().deleteCourse(f_idx);
		
		response.sendRedirect("course.do");

	}

}

