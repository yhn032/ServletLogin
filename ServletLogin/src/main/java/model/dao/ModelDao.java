package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.conn.DBService;
import model.vo.ModelVo;

public class ModelDao {

	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static ModelDao single = null;

	//스태틱은 무조건 스태틱으로만
	public static ModelDao getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new ModelDao();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private ModelDao() {
		// TODO Auto-generated constructor stub	
	}
	
	
	//login메소드
	public int login(String email, String pwd) {
	      
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from member2 where email=?";

		try {
			//1. connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			//3. ResultSet 얻어오기 
			rs = pstmt.executeQuery();

			//4. 포장
			if(rs.next()) {//email과 동일한 값이 있다면,,,
				if(rs.getString("pwd").equals(pwd)) {//id와 pwd모두 같은 경우 1 리턴
					return 1;
				}else {//id는 같고 pwd는 다른 경우 0 리턴
					return 0;
				}
        
			}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();//
			} finally {//반드시 실행하는 구문

				try {

					//연결되어 있는 상태면 끊어라.(생성 역순으로)

					if (rs != null)
						rs.close(); //3
					if (pstmt != null)
						pstmt.close();//2
					if (conn != null)
						conn.close();//1

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

		return -1; //위의 조건에서 걸리지 않는다면 -1리턴 -> id와 비번 모두 틀림
	}
	
	//email 중복체크용 메소드
	public ModelVo selectFromemail(String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ModelVo vo = null;
		String sql = "select * from member2 where email=?";
		try {
			//1.connection 얻어오기
			//				 커낵션 객체생성, DB에게 커낵션얻기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			
			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			//4.포장(record -> Vo -> list)

			while (rs.next()) {
				//rs가 가리키는 행(레코드)의 값을 읽어온다.

				//Vo로 포장
				vo = new ModelVo();
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setNickname(rs.getString("nickname"));
				vo.setPwd(rs.getString("pwd"));
				vo.setBirth(rs.getString("birth"));
				vo.setTel(rs.getString("tel"));
				vo.setQuestion(rs.getString("question"));
				vo.setAnswer(rs.getString("answer"));
			
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//연결(생성) 되었으면 닫아라.(생성 역순으로 닫기)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}

	

//password 중복체크 메소드
	public ModelVo passwordCheck(String email) {
		
		ModelVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from member2 where email=?";
		
		try {
			//1.connection 얻어오기
			//				 커낵션 객체생성, DB에게 커낵션얻기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			//3.ResultSet 얻어오기
			
			rs = pstmt.executeQuery();
			
			//4.포장(record -> Vo -> list)
			
			while (rs.next()) {
				//rs가 가리키는 행(레코드)의 값을 읽어온다.
				
				//Vo로 포장
				vo = new ModelVo();
				vo.setEmail(rs.getString("email"));
				vo.setNickname(rs.getString("nickname"));
				vo.setPwd(rs.getString("pwd"));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				//연결(생성) 되었으면 닫아라.(생성 역순으로 닫기)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	
	//회원가입 메소드
	public int enroll(ModelVo vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		//										1  2  3  4  5  6  7  8
		String sql = "insert into member2 values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//파라미터만들기
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNickname());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getQuestion());
			pstmt.setString(8, vo.getAnswer());
			
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	public int update(ModelVo vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
										  // 1      2           3        4      5	    6		  7             
		String sql = "update member2 set pwd=?, name=?, nickname=?, birth=?, tel=?, answer=? where email=?";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNickname());
			pstmt.setString(4, vo.getBirth());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getAnswer());
			pstmt.setString(7, vo.getEmail());
	
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return res;
	}
	
	
	public int delete(String email) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "delete from member2 where email=?";
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql); // 캐싱
			
			//3.pstmt의 변수처리된 parameter 설정과정
			pstmt.setString(1,email);
			
			//4.DML(insert/update/delete)명령 실행, res는 처리된 행수를반환
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//닫기 (열린 역순)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//리턴을 0으로 받으면 명령 실패!
		return res;
	}
	
	//회원가입용 email중복체크
	public int emailcheck(String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int emailCheck = 0 ;
		
		String sql = "select * from member2 where email=?";
		try {
			//1.connection 얻어오기
			//				 커낵션 객체생성, DB에게 커낵션얻기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement 얻어오기
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			
			//3.ResultSet 얻어오기
			rs = pstmt.executeQuery();

			if(rs.getString("email").equals(email)) {
				emailCheck = 0; //email사용불가
			}else {
				emailCheck = 1; //email사용가능
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//연결(생성) 되었으면 닫아라.(생성 역순으로 닫기)
				if (rs != null)
					rs.close(); // 3
				if (pstmt != null)
					pstmt.close(); // 2
				if (conn != null)
					conn.close(); // 1

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return emailCheck;
	}
	
}
	


