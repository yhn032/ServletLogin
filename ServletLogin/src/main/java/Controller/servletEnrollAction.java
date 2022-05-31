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
		//enroll_form.jsp���� ���޹��� �Ķ���͸� ����
		//1. insert����� parameter�� client���� �������⶧����
		//���ڵ� ������ �������
		request.setCharacterEncoding("utf-8");

		//2. �Ķ���� �ޱ�
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		
		
		//3.������ ������ ���� vo�� ����
		ModelVo vo = new ModelVo(email, pwd, name, nickname,
				                 birth, tel, question, answer);
		
		//4.insert����
		ModelDao.getInstance().enroll(vo);
		
		//5.ȸ������������ �α����� ����ȭ�� ȣ��
		vo = ModelDao.getInstance().selectFromemail(email); 
		  
		  HttpSession session = request.getSession();
		  session.setAttribute("user", vo); //���ǰ����� �α����� ������� ���� ���
		  response.sendRedirect("main.do");
	
	}

}
