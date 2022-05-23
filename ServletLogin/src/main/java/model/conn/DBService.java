package model.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
	}
	
	public Connection getConnection() throws SQLException {
		Connection conn;
		String url  = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test";
		String pwd  = "test";
		
		conn = DriverManager.getConnection(url, user, pwd);
		
		return conn;
		
	}
}
