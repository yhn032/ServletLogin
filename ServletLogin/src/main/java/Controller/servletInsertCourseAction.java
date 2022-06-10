package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FavoritesDao;
import model.vo.FavoritesVo;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletInsertCourseAction
 */
@WebServlet("/favorites/insert_course.do")
public class servletInsertCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//�α��� ���� �о����
		ModelVo user = (ModelVo)request.getSession().getAttribute("user");
		
		if(user == null) { //������ ����� ���
			response.sendRedirect("../member/login_form.do?reason=session_timeout");
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		
		String coId    = request.getParameter("coId");
		String coTitle = request.getParameter("coTitle");
		String coText  = request.getParameter("coText");
		
		coTitle = coTitle.replaceAll("\r\n", "<br>");
		
		FavoritesVo vo = new FavoritesVo();
		vo.setCoId(coId);
		vo.setCoTitle(coTitle);
		vo.setCoText(coText);
		
		int res = FavoritesDao.getInstance().insertCourse(vo);
		
		
		response.sendRedirect("course.do");
	}

}
