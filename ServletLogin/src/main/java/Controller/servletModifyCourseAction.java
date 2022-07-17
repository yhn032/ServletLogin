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
 * Servlet implementation class servletModfiyCourseAction
 */
@WebServlet("/favorites/modify_course.do")
public class servletModifyCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//1. 수신 인코딩 
		//request.setCharacterEncoding("utf-8");
		
		String coTitle = request.getParameter("coTitle");
		String coText = request.getParameter("coText");
		
		System.out.println(coTitle);
		System.out.println(coText);
		int f_idx = Integer.parseInt(request.getParameter("f_idx"));
		
		FavoritesVo vo = new FavoritesVo();
		vo.setCoTitle(coTitle);
		vo.setCoText(coText);
		
		int res = FavoritesDao.getInstance().updateFavor(vo);
		
		System.out.println(res);

		response.sendRedirect("detail.do?f_idx="+f_idx);

	}

}

