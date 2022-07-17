package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FavoritesDao;
import model.vo.FavoritesVo;

/**
 * Servlet implementation class servletModifyCourseFormAction
 */
@WebServlet("/favorites/modify_form.do")
public class servletModifyCourseFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int f_idx = Integer.parseInt(request.getParameter("f_idx"));
		
		FavoritesVo vo = FavoritesDao.getInstance().selectOne(f_idx);
		
		request.setAttribute("list", vo);
		
		//forward
		String forward_page = "modify_course_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

