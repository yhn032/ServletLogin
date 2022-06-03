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
		
		//Ŭ���̾�Ʈ ���� m_id ��� ���� �˷��ֱ� ���� boolean����
		boolean bResult = false; //�⺻ false�� �ְ�, 
		
		if(vo == null) {         //�������� true�� �ֱ�
			bResult = true;
		}
		
		JSONObject json = new JSONObject();
		json.put("result", bResult);
		String json_str = json.toJSONString();
		
		response.setContentType("text/json; charset=utf-8");
		
		response.getWriter().print(json_str);
		
	}

}

