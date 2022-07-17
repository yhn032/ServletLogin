package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisConnector {
    
	//mybatis �۾� ��ü�� ����� ����. interface(��뼳��)�̴�.
	SqlSessionFactory  factory=null;
	
	//�̱��� ������ ��ü�� �����Ѵ�.
	private static MyBatisConnector connector; 
	
	//�����ڷ� Ŀ���Ϳ�, ������ �����.
	public MyBatisConnector()
	{
		try {
			//sqlMapConfig.xml�о���δ�.
			Reader reader = 
				Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);			//�о� ���� xml������ ������� ������ �����.
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//single-ton
	public static MyBatisConnector getInstance(){
		if(connector==null)
			connector = new MyBatisConnector();
		return connector;
	}
	public SqlSessionFactory  getSqlSessionFactory()
	{
		return factory;
	}
}
