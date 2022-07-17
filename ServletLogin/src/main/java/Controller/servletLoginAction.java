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
		//로그인한 정보를 login_form.jsp로부터 전달받는x 서블릿. 데이터를 가공해서 로그인 성공 여부를 판단한다.
		
		  //파라미터 수신. 한글이 없으니까 수신인코딩안해도 될듯. (닉네임을 메인화면에 출력하고자 한다면 해줘야 함)
		  String email = request.getParameter("email"); 
		  String pwd = request.getParameter("pwd");
		  
		  //로그인 성공여부 파악. 1 : 성공, -1 : 둘 다 틀림, 0 : 비번만 틀림
		  ModelVo vo2 = ModelDao.getInstance().selectFromemail(email);
		  
		  if(vo2 != null) {//이메일에 해당하는 값이 존재한다면 -> 아이디는 맞음
			  if(!vo2.getPwd().equals(pwd)) {
				  //입력한 비밀번호와 db에 저장된 비밀번호가 다르다면
				  response.sendRedirect("login_form.do?reason=failPwd&email="+vo2.getEmail());
				  return;
			  }else {
				  //로그인애 성공한 경우
				  request.getSession().setAttribute("user", vo2);
				  response.sendRedirect("main.do");
			  }
			  
		  }else {
			  //존재하지 않는 아이디 
			  response.sendRedirect("login_form.do?reason=failId");
			  return;
		  }

	}

}

