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

	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static ModelDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static ModelDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new ModelDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private ModelDao() {
		// TODO Auto-generated constructor stub	
	}
	
	
	//login�޼ҵ�
	public int login(String email, String pwd) {
	      
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from member2 where email=?";

		try {
			//1. connection ������
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatement ������
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			//3. ResultSet ������ 
			rs = pstmt.executeQuery();

			//4. ����
			if(rs.next()) {//email�� ������ ���� �ִٸ�,,,
				if(rs.getString("pwd").equals(pwd)) {//id�� pwd��� ���� ��� 1 ����
					return 1;
				}else {//id�� ���� pwd�� �ٸ� ��� 0 ����
					return 0;
				}
        
			}

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();//
			} finally {//�ݵ�� �����ϴ� ����

				try {

					//����Ǿ� �ִ� ���¸� �����.(���� ��������)

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

		return -1; //���� ���ǿ��� �ɸ��� �ʴ´ٸ� -1���� -> id�� ��� ��� Ʋ��
	}
	
	//email �ߺ�üũ�� �޼ҵ�
	public ModelVo selectFromemail(String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ModelVo vo = null;
		String sql = "select * from member2 where email=?";
		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			
			//3.ResultSet ������
			rs = pstmt.executeQuery();

			//4.����(record -> Vo -> list)

			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.

				//Vo�� ����
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
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
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

	

//password �ߺ�üũ �޼ҵ�
	public ModelVo passwordCheck(String email) {
		
		ModelVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select pwd from member2 where email=?";
		
		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			//3.ResultSet ������
			
			rs = pstmt.executeQuery();
			
			//4.����(record -> Vo -> list)
			
			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о�´�.
				
				//Vo�� ����
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
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
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
	
	
	//ȸ������ �޼ҵ�
	public int enroll(ModelVo vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		//										1  2  3  4  5  6  7  8
		String sql = "insert into member2 values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//�Ķ���͸����
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNickname());
			pstmt.setString(5, vo.getBirth());
			pstmt.setString(6, vo.getTel());
			pstmt.setString(7, vo.getQuestion());
			pstmt.setString(8, vo.getAnswer());
			
			
			//4.DML(insert/update/delete)��� ����, res�� ó���� �������ȯ
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//�ݱ� (���� ����)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//������ 0���� ������ ��� ����!
		return res;
	}
	
	public int update(ModelVo vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
										  // 1      2           3        4      5	    6		  7             
		String sql = "update member2 set pwd=?, name=?, nickname=?, birth=?, tel=?, answer=? where email=?";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNickname());
			pstmt.setString(4, vo.getBirth());
			pstmt.setString(5, vo.getTel());
			pstmt.setString(6, vo.getAnswer());
			pstmt.setString(7, vo.getEmail());
	
			
			//4.DML(insert/update/delete)��� ����, res�� ó���� �������ȯ
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//�ݱ� (���� ����)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return res;
	}
	
	
	public int delete(String email) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		
		int res = 0;
		
		Connection		   conn  = null;
		PreparedStatement  pstmt = null;
		
		
		String sql = "delete from member2 where email=?";
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql); // ĳ��
			
			//3.pstmt�� ����ó���� parameter ��������
			pstmt.setString(1,email);
			
			//4.DML(insert/update/delete)��� ����, res�� ó���� �������ȯ
			res = pstmt.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally {
			
			try {
				//�ݱ� (���� ����)
				if(pstmt != null) pstmt.close(); // 2
				if(conn != null) conn.close();   // 1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		//������ 0���� ������ ��� ����!
		return res;
	}
	
	//ȸ�����Կ� email�ߺ�üũ
	public int emailcheck(String email) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int emailCheck = 0 ;
		
		String sql = "select * from member2 where email=?";
		try {
			//1.connection ������
			//				 Ŀ���� ��ü����, DB���� Ŀ���Ǿ��
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, email);
			
			//3.ResultSet ������
			rs = pstmt.executeQuery();

			if(rs.getString("email").equals(email)) {
				emailCheck = 0; //email���Ұ�
			}else {
				emailCheck = 1; //email��밡��
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//����(����) �Ǿ����� �ݾƶ�.(���� �������� �ݱ�)
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
	


