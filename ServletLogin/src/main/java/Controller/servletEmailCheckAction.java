package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.dao.ModelDao;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletEmailCheckAction
 */
@WebServlet("/member/email_check.do")
public class servletEmailCheckAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		
		ModelVo vo = ModelDao.getInstance().selectFromemail(email);
		
		//클라이언트 측에 m_id 사용 유무 알려주기 위한 boolean생성
		boolean bResult = false; //기본 false를 주고, 
		
		if(vo == null) {         //없을때만 true를 주기
			bResult = true;
		}
		
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String json_str = json.toJSONString();
		
		response.setContentType("text/json; charset=utf-8");
		
		response.getWriter().print(json_str);
		
	}

}

