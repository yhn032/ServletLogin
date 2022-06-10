package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.FavoritesDao;
import model.vo.FavoritesVo;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletMyListAction
 */
@WebServlet("/favorites/mylist.do")
public class servletMyListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//�α��� ���� �о����
		ModelVo user = (ModelVo)request.getSession().getAttribute("user");
		
		if(user == null) { //������ ����� ���
			response.sendRedirect("../member/login_form.do?reason=session_timeout");
			return;
		}
		
		//���� Ŭ���ؼ� ���ã���� ����Ʈ�� ��� -> �α����� ����ڸ� �̿밡��
		HttpSession session = request.getSession();
		ModelVo vo = (ModelVo)session.getAttribute("user");
		String nickname = vo.getNickname();
		
		//�α����ϰ� �ִ� ���� ������ �ִ� �г������� ���� ��ȸ
		List<FavoritesVo> list = FavoritesDao.getInstance().selectFromNickname(nickname);
		request.setAttribute("list", list);
		
		
		
		//forward
		String forward_page = "mylist.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
