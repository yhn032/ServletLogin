package Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.FavoritesDao;
import model.vo.FavoritesVo;
import model.vo.ModelVo;

/**
 * Servlet implementation class servletInsertCourseAction
 */
@WebServlet("/favorites/insert_course.do")
public class servletInsertCourseAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//로그인 정보 읽어오기
		ModelVo user = (ModelVo)request.getSession().getAttribute("user");
		
		if(user == null) { //세션이 만료된 경우
			response.sendRedirect("../member/login_form.do?reason=session_timeout");
			return;
		}
		
		request.setCharacterEncoding("utf-8");
		
		//웹경로 
		String web_path = "/upload/";
		//절대 경로
		String abs_path = request.getServletContext().getRealPath(web_path);
		
		//2. 최대 업로드 크기(3장의 사진 총 합이다.)
		int max_size = 1024*1024*900; //900MB
		
		MultipartRequest mr = new MultipartRequest(request, abs_path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		String filename1 = "no_file";
		String filename2 = "no_file";
		String filename3 = "no_file";
		
		File f1 = mr.getFile("coPhoto1");
		File f2 = mr.getFile("coPhoto2");
		File f3 = mr.getFile("coPhoto3");
		
		if(f1 != null){
			filename1 = f1.getName();
		}
		if(f2 != null){
			filename2 = f2.getName();
		}
		if(f3 != null){
			filename3 = f3.getName();
		}
		
		
		String coId    = mr.getParameter("coId");
		String coTitle = mr.getParameter("coTitle");
		String coText  = mr.getParameter("coText");
		
		FavoritesVo vo = new FavoritesVo();
		vo.setCoId(coId);
		vo.setCoTitle(coTitle);
		vo.setCoText(coText);
		vo.setCoPhoto1(filename1);
		vo.setCoPhoto2(filename2);
		vo.setCoPhoto3(filename3);
		
		int res = FavoritesDao.getInstance().insertCourse(vo);
		
		
		response.sendRedirect("course.do");
	}

}
