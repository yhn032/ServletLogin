package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	
	static {
		// driver �� ����ƽ �ʱ�ȭ�� ���� �ҷ�����
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static DBConnection single = null;

	public static DBConnection getInstance() { 
		// �̱������� getInstance �޼��� ����
		if(single == null) {
			single = new DBConnection();
		}
		return single;
		
	}
	
	private DBConnection() {
		// �̱��ϰ�ü�� ��������� �ʵ��� private ������ �����
	}
	
	public Connection getConnection() throws SQLException{
		// connection ������
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		String user = "test"; 
		String pwd = "test"; 
		
		Connection connection = DriverManager.getConnection(url,user,pwd);
		return connection;
	}

}
