package model.conn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	DataSource ds;
	
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
		try {
			//1. InitialContext ���� 
			InitialContext ic = new InitialContext();
			
			//2. Resource�� ����� Context���� ���ϱ� (���� ���ο��� ������ �� �ִ� ��� => java:comp/env)
			Context context = (Context)ic.lookup("java:comp/env");//lookup�Լ��� ��ȯ���� Object�̹Ƿ� ������ ����ȯ ����� �Ѵ�.
			
			//3. Context���� Resource ������ ȹ���Ѵ�.
			ds = (DataSource)context.lookup("jdbc/oracle_test");//(���� ����ȯ)
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		
		return ds.getConnection();
		
	}
}
