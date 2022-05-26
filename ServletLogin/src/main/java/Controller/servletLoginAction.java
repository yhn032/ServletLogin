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
		//로그인한 정보를 login_form.jsp로부터 전달받는 서블릿. 데이터를 가공해서 로그인 성공 여부를 판단한다.
		
		  //파라미터 수신. 한글이 없으니까 수신인코딩안해도 될듯. (닉네임을 메인화면에 출력하고자 한다면 해줘야 함)
		  String email = request.getParameter("email"); 
		  String pwd = request.getParameter("pwd");
		  
		  //로그인 성공여부 파악. 1 : 성공, -1 : 둘 다 틀림, 0 : 비번만 틀림
		  int result = ModelDao.getInstance().login(email, pwd);
		  
		  if(result== 1) {//로그인이 성공했다면 //로그인한 사용자의 이메일 정보로 정보 얻어오기 
			  ModelVo vo = ModelDao.getInstance().selectFromemail(email); 
			  
			  HttpSession session = request.getSession();
			  session.setAttribute("user", vo); //세션값으로 로그인한 사용자의 정보 기억
			  response.sendRedirect("main.do");
		  
		  }else { //로그인에 실패했다면 로그인 실패 정보를 가지고 다시 로그인 폼으로 이동
			  request.setAttribute("result", result);
			  RequestDispatcher disp = request.getRequestDispatcher("login_form.jsp");
			  disp.forward(request, response);
		  
		  }

	}

}

