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
		
		//ó�� ��������(�α��� ȭ�鿡 ó�� ���� ���)
		if(email ==null || pwd == null) {//���޹��� parameter���� ����
			RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
			disp.forward(request, response);
		}
		
		int result = ModelDao.getInstance().login(email, pwd);
		System.out.println(result);
		//~�� ȯ���մϴٿ��� ~�� sessionid���� ����ϸ� ���� �Ͱ���
		if(result == 1) {//�α����� �����ߴٸ�
			//�α����� ������� ���̵� ������ ���� ������
			ModelVo vo = ModelDao.getInstance().selectFromemail(email);
			String nickname = vo.getNickname();
			HttpSession session = request.getSession();
			session.setAttribute("sessionID", nickname); //���ǰ����� �α����� ������� �г��� ���� ���
			response.sendRedirect("main.do");
			
		}else { //�α��ο� �����ߴٸ�
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

