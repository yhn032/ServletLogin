package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.FavoritesDao;
import model.vo.FavoritesVo;

/**
 * Servlet implementation class servletDetailAction
 */
@WebServlet("/member/detail.do")
public class servletDetailAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �Խù��� ������ Ŭ���ϸ� -> �ش� �Խù��� �Խñ� ��ȣ�� �Ķ���ͷ� �޾Ƽ� �Խù��� �ش��ϴ� �����͸� detail.jsp�� ����Ѵ�.
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//��ȸ�� +1������Ű��
		FavoritesDao.getInstance().countPlusView(idx);
		
		//idx���� �ش��ϴ� ���̺� ��ȸ�ϱ�
		FavoritesVo vo = FavoritesDao.getInstance().selectOne(idx);
		
		
		request.setAttribute("list", vo);
	    RequestDispatcher disp = request.getRequestDispatcher("detail.jsp");
	    disp.forward(request, response);
	}

}
