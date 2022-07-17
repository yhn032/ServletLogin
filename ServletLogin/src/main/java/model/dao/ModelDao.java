package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.conn.DBService;
import model.vo.ModelVo;
import service.MyBatisConnector;

public class ModelDao {
	
	SqlSessionFactory factory;

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
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//email �ߺ�üũ�� �޼ҵ�
	public ModelVo selectFromemail(String email) {
		ModelVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.selectFromemail", email);
		
		sqlSession.close();
		
		return vo;
	}

	

	//password �ߺ�üũ �޼ҵ�
	public ModelVo passwordCheck(String email) {
		ModelVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.passwordCheck", email);
		
		sqlSession.close();
		
		return vo;
	}
	
	
	//ȸ������ �޼ҵ�
	public int enroll(ModelVo vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub	
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("member.enroll", vo);
		
		sqlSession.close();
		
		return res;
	}
	
	public int update(ModelVo vo) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("member.update", vo);
		
		sqlSession.close();
		
		return res;
	}
	
	
	public int delete(String email) { // ȣ���� ����ڰ� ������ ��
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("member.delete", email);
		
		sqlSession.close();
		
		return res;
	}

	
}
	


