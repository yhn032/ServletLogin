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
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	//email 중복체크용 메소드
	public ModelVo selectFromemail(String email) {
		ModelVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.selectFromemail", email);
		
		sqlSession.close();
		
		return vo;
	}

	

	//password 중복체크 메소드
	public ModelVo passwordCheck(String email) {
		ModelVo vo = null;
		
		SqlSession sqlSession = factory.openSession();
		
		vo = sqlSession.selectOne("member.passwordCheck", email);
		
		sqlSession.close();
		
		return vo;
	}
	
	
	//회원가입 메소드
	public int enroll(ModelVo vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub	
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("member.enroll", vo);
		
		sqlSession.close();
		
		return res;
	}
	
	public int update(ModelVo vo) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("member.update", vo);
		
		sqlSession.close();
		
		return res;
	}
	
	
	public int delete(String email) { // 호출한 사용자가 전달한 값
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("member.delete", email);
		
		sqlSession.close();
		
		return res;
	}

	
}
	


