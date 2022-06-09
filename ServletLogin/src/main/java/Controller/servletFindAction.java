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
		  
		  //���ڵ� ����
		  request.setCharacterEncoding("utf-8");
	
		  //�Ķ���� ����
		  String email    = request.getParameter("email");
		  String name     = request.getParameter("name");
		  String question = request.getParameter("question");
		  String answer   = request.getParameter("answer");
		 
		  //�Է��� �̸��ϰ� ������ ���ڵ� ã��
		  ModelVo user = ModelDao.getInstance().selectFromemail(email);
		  
		  
		  if(user == null) {
			  //user�� null�ΰ�� -> �Է��� �̸����� Ʋ�Ȱų� �������� �ʴ� �̸���
			  response.sendRedirect("find_form.do?reason=fail_email");
			  return;
		  }
		  
		  //���� ������ ����ϸ� �̸����� �����ϴ� ����̴�. �������� �˻� ����
		  //������ �߸� ������ ��� �ٽ� ����� �����̷�Ʈ�ϱ�
		  if(!user.getQuestion().equals(question)) {
			  response.setCharacterEncoding("utf-8");
			  response.sendRedirect("find_form.do?reason=fail_question&email=" + email);
			  return;
			  
		  }
		  
		  //���� �ڵ带 ����ߴٸ� ��� �˻�
		  if(!user.getAnswer().equals(answer)) {
			  //answer���� �ٸ� ��� 
			  response.setCharacterEncoding("utf-8");
			  response.sendRedirect("find_form.do?reason=fail_answer&email=" + email); //�̸��� ���� �Ѱ��ְ� ������ �� ???�� ������? ���ڵ� ������ �ƴѰ� ������,,,
			  return;
		  }
				  
		  //���� ��� ������ ����� ���� ������ ���ٴ� ���̴�. ����� ������ ������.
		  request.setAttribute("vo", user);
		  RequestDispatcher disp = request.getRequestDispatcher("show_pwd_form.jsp");
		  disp.forward(request, response);
	  } 
}

