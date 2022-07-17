package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.vo.MyCourseVo;
import model.vo.MyListVo;
import service.MyBatisConnector;

public class MyCourseDao {
	
	SqlSessionFactory factory;
	//single-ton : ��ü 1���� �����ؼ� �������!
	//����ƽ��ü�� ������ �ϳ��� ���������.
	static MyCourseDao single = null;

	//����ƽ�� ������ ����ƽ���θ�
	public static MyCourseDao getInstance() {

		//��ü�� ������ �����ض� ȣ��� �ѹ��� ��ü�� ����
		if (single == null)
			single = new MyCourseDao();

		return single;
	}

	//�ܺο��� ��ü�� �������� ���ϰ� ����
	private MyCourseDao() {
		// TODO Auto-generated constructor stub	
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	
	public int insertMyCourse(MyCourseVo vo) {//��ư�� �������ν� �ڹٿ��� ���޹��� vo
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("myList.insertMyCourse", vo);
		
		sqlSession.close();
		
		return res;
	}

	public int deleteMyCourse(MyCourseVo vo) {//��ư�� �������ν� �ڹٿ��� ���޹��� vo
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.delete("myList.deleteMyCourse", vo);
		
		sqlSession.close();
		
		return res;
	}
	
	public List<Integer> selectedCheck(int m_idx) {
		
		List<Integer> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("myList.selectedCheck", m_idx);
		
		sqlSession.close();
		
		return list;
	}

	public List<MyListVo> selectMyList(int m_idx) {
		
		List<MyListVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("myList.selectMyList", m_idx);
		
		sqlSession.close();
		
		return list;
	}
}
	


