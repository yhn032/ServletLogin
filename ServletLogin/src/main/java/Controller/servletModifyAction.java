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
 * Servlet implementation class servletModifyAction
 */
@WebServlet("/member/modify.do")
public class servletModifyAction extends HttpServlet {
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

		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		String answer = request.getParameter("answer");
		String question = request.getParameter("question");

		ModelVo vo = new ModelVo();
		
		vo.setEmail(email);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setNickname(nickname);
		vo.setBirth(birth);
		vo.setTel(tel);
		vo.setAnswer(answer);
		
	    ModelDao.getInstance().update(vo);

	    vo.setQuestion(question);
	    
	    HttpSession session = request.getSession();
		session.setAttribute("user", vo); 
		response.sendRedirect("member_inform.jsp");

	
	}

}
