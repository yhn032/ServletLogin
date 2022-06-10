package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.vo.ModelVo;

/**
 * Servlet implementation class servletInformFormAction
 */
@WebServlet("/member/inform_form.do")
public class servletInformFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//로그인 정보 읽어오기
		ModelVo user = (ModelVo)request.getSession().getAttribute("user");
		
		if(user == null) { //세션이 만료된 경우
			response.sendRedirect("../member/login_form.do?reason=session_timeout");
			return;
		}

		//forward
		String forward_page = "member_modify.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}

