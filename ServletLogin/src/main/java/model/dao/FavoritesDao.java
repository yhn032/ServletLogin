package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.conn.DBService;
import model.vo.FavoritesVo;

public class FavoritesDao {
	//single-ton : ��ü 1���� �����ؼ� �������
	static FavoritesDao single = null;

	public static FavoritesDao getInstance() {

		//��ü�� �����Ǿ� ���� ������ ������.
		if (single == null) {
			single = new FavoritesDao();
		}
		//������ ����� ���� ��ü�� �״�� ��ȯ�Ѵ�.
		return single;
	}

	//�ܺο��� �������� ���ϵ��� ��������. ��ü�� getInstance�޼ҵ带 ���ؼ��� ��������.
	private FavoritesDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<FavoritesVo> selectList() {

		List<FavoritesVo> list = new ArrayList<FavoritesVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from favorites order by coView desc";

		try {
			//1. connection ������
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatement ������
			pstmt = conn.prepareStatement(sql);

			//3. ResultSet ������ 
			rs = pstmt.executeQuery();

			//4. ����
			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о� �´�.

				//Vo�� ����(�ݺ��� 1ȸ ���Ƽ� ���ο� �����͸� ���� ������ �� ���ڵ带 ������ vo�� ���� �������� �Ѵ�.)
				FavoritesVo vo = new FavoritesVo(rs.getInt("idx"), rs.getString("coTitle"), rs.getString("coId"), rs.getInt("coView"));
				
				//list�� �߰� 
				list.add(vo);

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

		return list;
	}
	
	public FavoritesVo selectOne(int idx) {

		FavoritesVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from favorites where idx=?";

		try {
			//1. connection ������
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatement ������
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			//3. ResultSet ������ 
			rs = pstmt.executeQuery();

			//4. ����
			if (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о� �´�.

				//Vo�� ����(�ݺ��� 1ȸ ���Ƽ� ���ο� �����͸� ���� ������ �� ���ڵ带 ������ vo�� ���� �������� �Ѵ�.)
				vo = new FavoritesVo(rs.getInt("idx"), rs.getString("coTitle"), rs.getString("coId"), rs.getInt("coView"));

				//list�� �߰� 

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

		return vo;
	}
	
	public void countPlusView(int idx) {//��ư�� �������ν� �ڹٿ��� ���޹��� vo
		// TODO Auto-generated method stub
		int res = 0;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update favorites set coView = coview+1 where idx=?";
		try {
			//1. Connection������
			conn = DBService.getInstance().getConnection();
			//2. ��� ó�� ��ü ������
			pstmt = conn.prepareStatement(sql);
			//3. pstmt�� �Ķ���� ����//�������� �ڷ����� ���� �ľ��϶�!//���ڴ� ���ڴ� �ڷ����� ������� ������ ������ "?"�̴�.
			pstmt.setInt(1, idx);
			
			//4. DML(insert/update/delete) : res�� ó���� ���� ���� ��ȯ�մϴ�. �ѹ��� ������ ������ 1�ٸ� ����ǹǷ� ������ �����ߴٸ� res�� �ݵ�� 1, ���࿡ res�� 0�̶�� ���Կ����� ����� ������� ���� ���̴�.
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//�ݱ�(��������)
				if(pstmt != null) pstmt.close(); //2
				if(conn  != null) conn.close();  //1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void updateForMyList(String nickname, int idx) {//��ư�� �������ν� �ڹٿ��� ���޹��� vo
		// TODO Auto-generated method stub
		int res = 0;
		Connection         conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update favorites set myNick=? where idx=?";
		try {
			//1. Connection������
			conn = DBService.getInstance().getConnection();
			//2. ��� ó�� ��ü ������
			pstmt = conn.prepareStatement(sql);
			//3. pstmt�� �Ķ���� ����//�������� �ڷ����� ���� �ľ��϶�!//���ڴ� ���ڴ� �ڷ����� ������� ������ ������ "?"�̴�.
			pstmt.setString(1, nickname);
			pstmt.setInt(2, idx);
			
			//4. DML(insert/update/delete) : res�� ó���� ���� ���� ��ȯ�մϴ�. �ѹ��� ������ ������ 1�ٸ� ����ǹǷ� ������ �����ߴٸ� res�� �ݵ�� 1, ���࿡ res�� 0�̶�� ���Կ����� ����� ������� ���� ���̴�.
			res = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				//�ݱ�(��������)
				if(pstmt != null) pstmt.close(); //2
				if(conn  != null) conn.close();  //1
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public List<FavoritesVo> selectFromNickname(String nickname) {

		List<FavoritesVo> list = new ArrayList<FavoritesVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from favorites where myNick=?";

		try {
			//1. connection ������
			conn = DBService.getInstance().getConnection();

			//2. PreparedStatement ������
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			//3. ResultSet ������ 
			rs = pstmt.executeQuery();

			//4. ����
			while (rs.next()) {
				//rs�� ����Ű�� ��(���ڵ�)�� ���� �о� �´�.

				//Vo�� ����(�ݺ��� 1ȸ ���Ƽ� ���ο� �����͸� ���� ������ �� ���ڵ带 ������ vo�� ���� �������� �Ѵ�.)
				FavoritesVo vo = new FavoritesVo(rs.getInt("idx"), rs.getString("coTitle"), rs.getString("coId"),rs.getInt("coView"));
				
			
				//list�� �߰� 
				list.add(vo);

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

		return list;
	}
}
