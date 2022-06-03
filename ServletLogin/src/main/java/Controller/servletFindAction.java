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
		  String email = request.getParameter("email");
		 
		  //값 찾기
		  ModelVo vo = ModelDao.getInstance().selectFromemail(email);
		  
		  request.setAttribute("vo", vo);
		  RequestDispatcher disp = request.getRequestDispatcher("show_pwd_form.jsp");
		  disp.forward(request, response);
		  
		  } 
	 
	}

