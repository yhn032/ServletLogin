package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.vo.FavoritesVo;
import service.MyBatisConnector;

public class FavoritesDao {
	
	SqlSessionFactory factory;
	//single-ton : 객체 1개만 생성해서 사용하자
	static FavoritesDao single = null;

	public static FavoritesDao getInstance() {

		//객체가 생성되어 있지 않으면 만들어라.
		if (single == null) {
			single = new FavoritesDao();
		}
		//이전에 만들어 놨던 객체를 그대로 반환한다.
		return single;
	}

	//외부에서 생성하지 못하도록 접근제한. 객체는 getInstance메소드를 통해서만 생성가능.
	private FavoritesDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<FavoritesVo> selectList(){
		List<FavoritesVo> list = null;
		
		//1. sqlsession 생성
		SqlSession sqlSession = factory.openSession();
		
		//2. 작업 수행
		list = sqlSession.selectList("favor.selectList");
		
		//3. 자원 반납
		sqlSession.close();
		
		return list;
	}
	
	
	public FavoritesVo selectOne(int f_idx) {
		FavoritesVo vo = null;
		
		//1. sqlsession 생성
		SqlSession sqlSession = factory.openSession();
		
		//2. 작업 수행
		vo = sqlSession.selectOne("favor.selectOne", f_idx);
		
		//3. 자원 반납
		sqlSession.close();
		
		return vo;
		
	}
	
	
	public int insertCourse(FavoritesVo vo) {//버튼을 누름으로써 자바에게 전달받은 vo
		// TODO Auto-generated method stub
		int res = 0;
		
		//1. sqlsession 생성
		SqlSession sqlSession = factory.openSession(true);
		
		//2. 작업 수행
		res = sqlSession.insert("favor.insertCourse", vo);
		
		//3. 자원 반납
		sqlSession.close();
		
		return res;
	}
	
	public int countPlusView(int f_idx) {//버튼을 누름으로써 자바에게 전달받은 vo
		// TODO Auto-generated method stub
		int res = 0;
		
		//1. sqlsession 생성
		SqlSession sqlSession = factory.openSession(true);
		
		//2. 작업 수행
		res = sqlSession.insert("favor.updateCoView", f_idx);
		
		//3. 자원 반납
		sqlSession.close();
		
		return res;
	}

	public int deleteCourse(int f_idx) {
		// TODO Auto-generated method stub
		int res=0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("favor.deleteCourse", f_idx);
		
		sqlSession.close();
		
		return res;
	}

	public int updateCoPhoto1(FavoritesVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("favor.updateCoPhoto1", vo);
		
		sqlSession.close();
		
		return res;
	}

	public int updateCoPhoto2(FavoritesVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("favor.updateCoPhoto2", vo);
		
		sqlSession.close();
		
		return res;
	}

	public int updateCoPhoto3(FavoritesVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("favor.updateCoPhoto3", vo);
		
		sqlSession.close();
		
		return res;
	}

	public int updateFavor(FavoritesVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("favor.updateFavor", vo);
		
		sqlSession.close();
		
		return res;
	}
}
