package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.vo.MyCourseVo;
import model.vo.MyListVo;
import service.MyBatisConnector;

public class MyCourseDao {
	
	SqlSessionFactory factory;
	//single-ton : 객체 1개만 생성해서 사용하자!
	//스태틱객체는 무조건 하나만 만들어진다.
	static MyCourseDao single = null;

	//스태틱은 무조건 스태틱으로만
	public static MyCourseDao getInstance() {

		//객체가 없으면 생성해라 호출된 한번만 객체를 생성
		if (single == null)
			single = new MyCourseDao();

		return single;
	}

	//외부에서 객체를 생성하지 못하게 막음
	private MyCourseDao() {
		// TODO Auto-generated constructor stub	
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}

	
	public int insertMyCourse(MyCourseVo vo) {//버튼을 누름으로써 자바에게 전달받은 vo
		// TODO Auto-generated method stub
		int res = 0;
		
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("myList.insertMyCourse", vo);
		
		sqlSession.close();
		
		return res;
	}

	public int deleteMyCourse(MyCourseVo vo) {//버튼을 누름으로써 자바에게 전달받은 vo
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
	


