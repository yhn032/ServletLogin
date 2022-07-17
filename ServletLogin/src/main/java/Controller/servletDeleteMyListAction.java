package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.FavoritesDao;
import model.dao.MyCourseDao;
import model.vo.ModelVo;
import model.vo.MyCourseVo;

/**
 * Servlet implementation class servletDeleteMyListAction
 */
@WebServlet("/favorites/delete_mylist.do")
public class servletDeleteMyListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ModelVo user = (ModelVo) request.getSession().getAttribute("user");
		int f_idx = Integer.parseInt(request.getParameter("f_idx"));
		int m_idx = user.getM_idx();
		
		MyCourseVo vo = new MyCourseVo();
		vo.setF_idx(f_idx);
		vo.setM_idx(m_idx);
		
		
		int res = MyCourseDao.getInstance().deleteMyCourse(vo);
		
		JSONObject json = new JSONObject();
		
		if(res == 0 ) {
			json.put("res", false);
		}else {
			json.put("res", true);
		}
		
		String json_str = json.toJSONString();
		
		response.setContentType("text/json; charset=utf-8");
		response.getWriter().print(json_str);
	}

}
