package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.FavoritesDao;
import model.dao.MyCourseDao;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletCheckSelectAction
 */
@WebServlet("/favorites/check_select.do")
public class servletCheckSelectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		ModelVo user = (ModelVo) request.getSession().getAttribute("user");
		if(user == null) {
			json.put("ses", "false");
			
			String json_str = json.toJSONString();
			//System.out.println(json_str);
			response.setContentType("text/json; charset=utf-8;");
			response.getWriter().print(json_str);
			return;
		}
		
		int m_idx = user.getM_idx();
		
		List<Integer> list = MyCourseDao.getInstance().selectedCheck(m_idx);
		
		
		if(list.size() > 0) {
			
			try {
				JSONArray jarr = new JSONArray();
				
				for(int i=0; i<list.size();i++) {
					JSONObject arrobj = new JSONObject();//배열 내에 들어갈 json
					
					arrobj.put("f_idx", list.get(i));
					
					jarr.add(arrobj);
				}
				
				json.put("f_idx_arr", jarr);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}else {//list.size() == 0
			json.put("f_idx", -1);
		}
		
		String json_str = json.toJSONString();
		//System.out.println(json_str);
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json_str);
		
	}

}

