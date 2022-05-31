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
 * Servlet implementation class servletEnrollAction
 */
@WebServlet("/member/insert.do")
public class servletEnrollAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//enroll_form.jsp에서 전달받은 파라미터를 가공
		//1. insert명령이 parameter로 client에서 가져오기때문에
		//인코딩 설정을 해줘야함
		request.setCharacterEncoding("utf-8");

		//2. 파라미터 받기
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		
		//3.데이터 삽입을 위해 vo로 포장
		ModelVo vo = new ModelVo(email, pwd, name, nickname,
				                 birth, tel, question, answer);
		
		//4.insert수행
		ModelDao.getInstance().enroll(vo);
		
		//5.회원가입정보로 로그인한 메인화면 호출
		vo = ModelDao.getInstance().selectFromemail(email); 
		  
		  HttpSession session = request.getSession();
		  session.setAttribute("user", vo); //세션값으로 로그인한 사용자의 정보 기억
		  response.sendRedirect("main.do");
	
	}

}
