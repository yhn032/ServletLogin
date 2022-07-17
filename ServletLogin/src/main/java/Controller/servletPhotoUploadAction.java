package Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.FavoritesDao;
import model.vo.FavoritesVo;

/**
 * Servlet implementation class servletPhotoUploadAction
 */
@WebServlet("/favorites/photo_upload.do")
public class servletPhotoUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//1. 저장경로(절대경로)
		String path = request.getServletContext().getRealPath("/upload/");
		//2. 파일 업로드 최대 용량
		int max_size = 1024*1024*100;
		
		//3. 파일 업로드 처리 객체						  저장위치  최대크기 인코딩  동일파일 -> 이름변경
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());
		
		//4. parameter받기 
		int photo_num = Integer.parseInt(mr.getParameter("photo_num"));
		int f_idx = Integer.parseInt(mr.getParameter("f_idx"));
		String filename = mr.getOriginalFileName("coPhoto");
		
		FavoritesVo originVo = FavoritesDao.getInstance().selectOne(f_idx);
		
		String coPhoto[] = {originVo.getCoPhoto1(), originVo.getCoPhoto2(), originVo.getCoPhoto3()};
		

		if(!coPhoto[photo_num].equals("no_file")) {
			
			//이전 파일 삭제(기존에 저장된 파일의 정보를 불러와서 파일이 저장된 경로에서 삭제를 한다.)
			//								기존에 저장된 파일의 이름
			File deleteFile  = new File(path, coPhoto[photo_num]);
			deleteFile.delete();
		}
		
		//6. DB Update_filename
		FavoritesVo vo = new FavoritesVo();
		vo.setF_idx(f_idx);
		int res = 0;
		
		//System.out.println(filename);
		
		//System.out.println(photo_num);
		switch(photo_num) {
			case 1:
				vo.setCoPhoto1(filename);
				res = FavoritesDao.getInstance().updateCoPhoto1(vo);
				break;
			case 2:
				vo.setCoPhoto2(filename);
				res = FavoritesDao.getInstance().updateCoPhoto2(vo);
				break;
			case 3:
				vo.setCoPhoto3(filename);
				res = FavoritesDao.getInstance().updateCoPhoto3(vo);
				break;
		}
		
		
		//7. 결과 전송 : json{p_filename : a.jpg}
		JSONObject json = new JSONObject();
		json.put("filename", filename);
		
		String json_str = json.toJSONString();
		
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json_str);

	}

}
