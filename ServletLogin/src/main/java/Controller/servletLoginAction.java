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
		//�α����� ������ login_form.jsp�κ��� ���޹޴�x ����. �����͸� �����ؼ� �α��� ���� ���θ� �Ǵ��Ѵ�.
		
		  //�Ķ���� ����. �ѱ��� �����ϱ� �������ڵ����ص� �ɵ�. (�г����� ����ȭ�鿡 ����ϰ��� �Ѵٸ� ����� ��)
		  String email = request.getParameter("email"); 
		  String pwd = request.getParameter("pwd");
		  
		  //�α��� �������� �ľ�. 1 : ����, -1 : �� �� Ʋ��, 0 : ����� Ʋ��
		  ModelVo vo2 = ModelDao.getInstance().selectFromemail(email);
		  
		  if(vo2 != null) {//�̸��Ͽ� �ش��ϴ� ���� �����Ѵٸ� -> ���̵�� ����
			  if(!vo2.getPwd().equals(pwd)) {
				  //�Է��� ��й�ȣ�� db�� ����� ��й�ȣ�� �ٸ��ٸ�
				  response.sendRedirect("login_form.do?reason=failPwd&email="+vo2.getEmail());
				  return;
			  }else {
				  //�α��ξ� ������ ���
				  request.getSession().setAttribute("user", vo2);
				  response.sendRedirect("main.do");
			  }
			  
		  }else {
			  //�������� �ʴ� ���̵� 
			  response.sendRedirect("login_form.do?reason=failId");
			  return;
		  }

	}

}

