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
@WebServlet("/member/login.do")
public class servletLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		//처음 포워딩시(로그인 화면에 처음 들어온 경우)
		if(email ==null || pwd == null) {//전달받은 parameter값이 없음
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
		}
		
		int result = ModelDao.getInstance().login(email, pwd);
		System.out.println(result);
		//~님 환영합니다에서 ~를 sessionid값을 사용하면 좋을 것같음
		if(result == 1) {//로그인이 성공했다면
			//로그인한 사용자의 아이디 정보로 정보 얻어오기
			ModelVo vo = ModelDao.getInstance().selectFromemail(email);
			String nickname = vo.getNickname();
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", nickname); //세션값으로 로그인한 사용자의 닉네임 정보 기억
			response.sendRedirect("main.do");
			
		}else { //로그인에 실패했다면
			request.setAttribute("result", result);
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
			
		}
		
		
		
		/*
		 * //forward String forward_page = "login.jsp"; RequestDispatcher disp =
		 * request.getRequestDispatcher(forward_page); disp.forward(request, response);
		 */
	}

}

