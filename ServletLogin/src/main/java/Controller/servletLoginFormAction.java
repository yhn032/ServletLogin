package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ModelDao;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletLoginAction
 */
@WebServlet("/member/login_form.do")
public class servletLoginFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//main에서 로그인 버튼을 누르면 호출되는 서블릿 -> 로그인 form을 forward한다.
		

		//forward 
		String forward_page = "login_form.jsp"; 
		RequestDispatcher disp =request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
