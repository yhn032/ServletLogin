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
@WebServlet("/member/find.do")
public class servletFindAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
		  //인코딩 설정
		  request.setCharacterEncoding("utf-8");
	
		  //파라미터 수신
		  String email    = request.getParameter("email");
		  String name     = request.getParameter("name");
		  String question = request.getParameter("question");
		  String answer   = request.getParameter("answer");
		 
		  //입력한 이메일과 동일한 레코드 찾기
		  ModelVo user = ModelDao.getInstance().selectFromemail(email);
		  
		  
		  if(user == null) {
			  //user가 null인경우 -> 입력한 이메일이 틀렸거나 존재하지 않는 이메일
			  response.sendRedirect("find_form.do?reason=fail_email");
			  return;
		  }
		  
		  //위의 조건을 통과하면 이메일이 존재하는 경우이다. 조건으로 검사 진행
		  //문제를 잘못 선택한 경우 다시 고르라고 리다이렉트하기
		  if(!user.getQuestion().equals(question)) {
			  response.setCharacterEncoding("utf-8");
			  response.sendRedirect("find_form.do?reason=fail_question&email=" + email);
			  return;
			  
		  }
		  
		  //위의 코드를 통과했다면 결과 검사
		  if(!user.getAnswer().equals(answer)) {
			  //answer값이 다른 경우 
			  response.setCharacterEncoding("utf-8");
			  response.sendRedirect("find_form.do?reason=fail_answer&email=" + email); //이름도 같이 넘겨주고 싶은데 왜 ???가 찍히지? 인코딩 문제는 아닌것 같은데,,,
			  return;
		  }
				  
		  //위의 모든 조건을 통과한 것은 문제가 없다는 뜻이다. 결과를 포워딩 해주자.
		  request.setAttribute("vo", user);
		  RequestDispatcher disp = request.getRequestDispatcher("show_pwd_form.jsp");
		  disp.forward(request, response);
	  } 
}

