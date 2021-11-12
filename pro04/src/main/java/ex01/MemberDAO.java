package ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// ����Ŭ �����ͺ��̽��� ���� ���� 
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "c##scott";
	private static final String DB_PASSWORD = "tiger";
	
	// ����Ŭ �����ͺ��̽��� �����ϴ� Connection ��ü
	private Connection connection;
	
	// SQL ���� �����ϴ� Statement ��ü
	private Statement statement;
	
	// �����ͺ��̽��� ��ȸ�ϴ� ����� ���� ResultSet ��ü
	private ResultSet resultSet;
	
	// member ���̺��� ���ڵ带 ��ȸ�ϴ� �޼ҵ�
	// -> ��ȸ�� ����� MemberVO ��ü�� �����ؼ� ArrayList ��ü�� ��Ƽ� ��ȯ
	public List<MemberVO> getMemberList() {
		// member ���̺��� ��ȸ�� ���ڵ带 ������ ArrayList ��ü
		List<MemberVO> list = new ArrayList<MemberVO>(); 
		
		try {
			// ����Ŭ �����ͺ��̽��� ����
			connectDatabase();
			
			// ������ ���� �ۼ�
			String query = "SELECT * FROM member";
			System.out.println("QUERY: " + query);
			
			// Statement ��ü�� �̿��� ������ ������ ����, ���� ����� ResultSet ��ü�� ����
			resultSet = statement.executeQuery(query);
			
			// �ݺ��ڸ� �̿��� ResultSet ��ü�� ����� ���ڵ带 ���ʴ�� Ȯ��
			while (resultSet.next()) {
				// getInt �޼ҵ� ���� �̿��� ���ڵ��� �� �÷��� ����
				int id = resultSet.getInt("id");
				String account = resultSet.getString("account");
				String passwd = resultSet.getString("passwd");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				Date regdate = resultSet.getDate("regdate");
				
				// MemberVO ��ü�� �����ؼ� �� �Ӽ��� ��ȸ�� ���ڵ��� �ķ����� ����
				MemberVO member = new MemberVO(id, account, passwd, name, email, regdate);
				
				// ArrayList ��ü�� MemberVO ��ü�� ����
				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();			
		}
		// ����(exception)�� �߻��ϵ� ���� �ʵ� �����ؾ� �ϴ� ������� finally ��Ͽ� �ۼ�
		finally {
			// ���ڵ带 ��� Ȯ���� ����, �����ͺ��̽� ������ �����ؾ� �Ѵ�.
			// -> ResultSet ��ü, Statement ��ü, Connection ��ü�� ������ ������ �������� ����
			try {
				// �Ʒ� ����鿡���� ���ܰ� �߻��� �� �����Ƿ�, ������ ���� ó���� ����� �Ѵ�.
				
				// �Ʒ� ��ü���� �������� �ʾ��� ���� �ֱ� ������, �ݵ�� ��ü�� �����ƴ��� �˻��� ���� ����
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();	
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		// ������ ArrayList ��ü�� ��ȯ
		return list;
		
	}
	
	// ����Ŭ �����ͺ��̽��� �����ϴ� �޼ҵ�
	private void connectDatabase() {
		try {
			// 1. ����Ŭ JDBC ����̹��� �ε�
			Class.forName(DB_DRIVER);
			System.out.println("DB: Success to load the Oracle JDBC driver!");
			
			// 2. ����Ŭ �����ͺ��̽��� ���� Connection ��ü ����
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("DB: Success to create the Connection object!");
			
			// 3.������ �����ϱ� ���� Statement ��ü ����
			statement = connection.createStatement();
			System.out.println("DB: Success to create the Statement object!");
			
		}
		catch (Exception e) {
			e.printStackTrace();			
		}
	}
	
}
