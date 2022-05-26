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
		//�α����� ������ login_form.jsp�κ��� ���޹޴� ����. �����͸� �����ؼ� �α��� ���� ���θ� �Ǵ��Ѵ�.
		
		  //�Ķ���� ����. �ѱ��� �����ϱ� �������ڵ����ص� �ɵ�. (�г����� ����ȭ�鿡 ����ϰ��� �Ѵٸ� ����� ��)
		  String email = request.getParameter("email"); 
		  String pwd = request.getParameter("pwd");
		  
		  //�α��� �������� �ľ�. 1 : ����, -1 : �� �� Ʋ��, 0 : ����� Ʋ��
		  int result = ModelDao.getInstance().login(email, pwd);
		  
		  if(result== 1) {//�α����� �����ߴٸ� //�α����� ������� �̸��� ������ ���� ������ 
			  ModelVo vo = ModelDao.getInstance().selectFromemail(email); 
			  
			  HttpSession session = request.getSession();
			  session.setAttribute("user", vo); //���ǰ����� �α����� ������� ���� ���
			  response.sendRedirect("main.do");
		  
		  }else { //�α��ο� �����ߴٸ� �α��� ���� ������ ������ �ٽ� �α��� ������ �̵�
			  request.setAttribute("result", result);
			  RequestDispatcher disp = request.getRequestDispatcher("login_form.jsp");
			  disp.forward(request, response);
		  
		  }

	}

}

