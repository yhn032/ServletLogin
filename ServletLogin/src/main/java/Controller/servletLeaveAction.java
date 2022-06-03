package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ModelDao;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletLeaveAction
 */
@WebServlet("/member/leave.do")
public class servletLeaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		ModelVo vo = (ModelVo)session.getAttribute("user");
		String email = vo.getEmail();
		ModelDao.getInstance().delete(email);
	
		session.invalidate(); 

		response.sendRedirect("main.do");
	}

}

