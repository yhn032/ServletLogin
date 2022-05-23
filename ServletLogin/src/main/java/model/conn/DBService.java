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
	//single-ton : ��ü 1���� �����ؼ� �������
	static DBService single = null;
	
	public static DBService getInstance() {
	
		//��ü�� �����Ǿ� ���� ������ ������.
		if (single == null) {
			single = new DBService();
		}
		//������ ����� ���� ��ü�� �״�� ��ȯ�Ѵ�.
		return single;
	}
	
	//�ܺο��� �������� ���ϵ��� ��������. ��ü�� getInstance�޼ҵ带 ���ؼ��� ��������.
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
