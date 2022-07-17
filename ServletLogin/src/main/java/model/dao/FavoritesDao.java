package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.vo.FavoritesVo;
import service.MyBatisConnector;

public class FavoritesDao {
	
	SqlSessionFactory factory;
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
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<FavoritesVo> selectList(){
		List<FavoritesVo> list = null;
		
		//1. sqlsession ����
		SqlSession sqlSession = factory.openSession();
		
		//2. �۾� ����
		list = sqlSession.selectList("favor.selectList");
		
		//3. �ڿ� �ݳ�
		sqlSession.close();
		
		return list;
	}
	
	
	public FavoritesVo selectOne(int f_idx) {
		FavoritesVo vo = null;
		
		//1. sqlsession ����
		SqlSession sqlSession = factory.openSession();
		
		//2. �۾� ����
		vo = sqlSession.selectOne("favor.selectOne", f_idx);
		
		//3. �ڿ� �ݳ�
		sqlSession.close();
		
		return vo;
		
	}
	
	
	public int insertCourse(FavoritesVo vo) {//��ư�� �������ν� �ڹٿ��� ���޹��� vo
		// TODO Auto-generated method stub
		int res = 0;
		
		//1. sqlsession ����
		SqlSession sqlSession = factory.openSession(true);
		
		//2. �۾� ����
		res = sqlSession.insert("favor.insertCourse", vo);
		
		//3. �ڿ� �ݳ�
		sqlSession.close();
		
		return res;
	}
	
	public int countPlusView(int f_idx) {//��ư�� �������ν� �ڹٿ��� ���޹��� vo
		// TODO Auto-generated method stub
		int res = 0;
		
		//1. sqlsession ����
		SqlSession sqlSession = factory.openSession(true);
		
		//2. �۾� ����
		res = sqlSession.insert("favor.updateCoView", f_idx);
		
		//3. �ڿ� �ݳ�
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
