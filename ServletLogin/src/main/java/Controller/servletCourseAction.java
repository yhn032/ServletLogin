package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FavoritesDao;
import model.vo.FavoritesVo;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletCourseAction
 */
@WebServlet("/favorites/course.do")
public class servletCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		
		List<FavoritesVo> list = FavoritesDao.getInstance().selectList();
		
		request.setAttribute("list", list);
		
		
		//forward
		String forward_page = "course_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

