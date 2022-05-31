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
		// 게시물의 제목을 클릭하면 -> 해당 게시물의 게시글 번호를 파라미터로 받아서 게시물에 해당하는 데이터를 detail.jsp에 출력한다.
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//조회수 +1증가시키기
		FavoritesDao.getInstance().countPlusView(idx);
		
		//idx값에 해당하는 테이블 조회하기
		FavoritesVo vo = FavoritesDao.getInstance().selectOne(idx);
		
		
		request.setAttribute("list", vo);
	    RequestDispatcher disp = request.getRequestDispatcher("detail.jsp");
	    disp.forward(request, response);
	}

}
