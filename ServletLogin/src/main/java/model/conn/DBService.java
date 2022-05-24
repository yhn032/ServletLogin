package model.conn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	DataSource ds;
	
	//single-ton : 객체 1개만 생성해서 사용하자
	static DBService single = null;
	
	public static DBService getInstance() {
	
		//객체가 생성되어 있지 않으면 만들어라.
		if (single == null) {
			single = new DBService();
		}
		//이전에 만들어 놨던 객체를 그대로 반환한다.
		return single;
	}
	
	//외부에서 생성하지 못하도록 접근제한. 객체는 getInstance메소드를 통해서만 생성가능.
	private DBService() {
		// TODO Auto-generated constructor stub
		try {
			//1. InitialContext 생성 
			InitialContext ic = new InitialContext();
			
			//2. Resource의 저장소 Context정보 구하기 (서버 내부에서 접근할 수 있는 상수 => java:comp/env)
			Context context = (Context)ic.lookup("java:comp/env");//lookup함수의 반환값이 Object이므로 강제로 형변환 해줘야 한다.
			
			//3. Context내의 Resource 정보를 획득한다.
			ds = (DataSource)context.lookup("jdbc/oracle_test");//(강제 형변환)
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
		
	}
}
