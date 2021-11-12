package ex04;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	// DBCP�� �����ϴ� DataSource ��ü
	private DataSource dataSource;
	
	// ����Ŭ �����ͺ��̽��� �����ϴ� Connection ��ü
	private Connection connection;
	
	// SQL ���� �����ϴ� Statement ��ü
	private Statement statement;
	
	// SQL ���� �����ϴ� PreparedStatement ��ü
	private PreparedStatement preStatement;
	
	// �����ͺ��̽��� ��ȸ�ϴ� ����� ���� ResultSet ��ü
	private ResultSet resultSet;
	
	// ������
	public MemberDAO() {
		try {
			// Context ��ü ����
			Context context = new InitialContext();
			
			// Context ��ü�� ���� JNDI�� �����ؼ�, ��Ĺ �����̳ʰ� ������ DataSource ��ü�� �޾ƿ´�.
			// -> Context ��ü�� lookup �޼ҵ带 �̿��� context.xml ���Ͽ� ������ Resource �±׿�
			//    ������ ������ �о�´�.
			//    lookup �޼ҵ�� Object ��ü�� ��ȯ�ϹǷ� DataSource �ڷ������� ��ȯ�ؼ� ����
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// member ���̺��� ���ڵ带 ��ȸ�ϴ� �޼ҵ�
	// -> ��ȸ�� ����� MemberVO ��ü�� �����ؼ� ArrayList ��ü�� ��Ƽ� ��ȯ
	public List<MemberVO> getMemberList() {
		// member ���̺��� ��ȸ�� ���ڵ带 ������ ArrayList ��ü
		List<MemberVO> list = new ArrayList<MemberVO>(); 
		
		try {
			// DataSource ��ü�� �̿��� �����ͺ��̽��� ����
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// ������ ������ Statement ��ü ����
			statement = connection.createStatement();
			System.out.println("Succes to create the Statement object!");
			
			// ������ ���� �ۼ�
			String query = "SELECT * FROM member ORDER BY id DESC";
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
	
	// member ���̺� ���ο� ȸ�� ������ �߰�
	public void insertMember(MemberVO member) {
		try {
			// DataSource ��ü�� �̿��� �����ͺ��̽��� ����
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// ���� �ۼ�
			// �̶� ���� �ֱ� ���� �ڸ��� '?'�� �ִ´�.
			String query = "INSERT INTO member (id, account, passwd, name, email) "
						 + "VALUES (SEQ_MEMBER_ID.NEXTVAL, ?, ?, ?, ?)";
			System.out.println("QUERY: " + query);
			
			// SQL ���� �����ϴ� PreparedStatement ��ü�� ����
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// ������ ������ ��ġ�� ���� �߰�
			// -> PreparedStatement ��ü�� setString, setInt ���� �޼ҵ带 �̿�
			preStatement.setString(1, member.getAccount());
			preStatement.setString(2, member.getPasswd());
			preStatement.setString(3, member.getName());
			preStatement.setString(4, member.getEmail());
			
			// ������ ����
			preStatement.executeQuery();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// ������ ������ ���� PreparedStatement ��ü�� Connection ��ü�� ����
			try {
				if (preStatement != null) preStatement.close();
				if (connection != null) connection.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// member ���̺��� ȸ�� ���� ����
	public void deleteMember(String id) {
		// ���ڿ��� ���޵� id�� �������� �˻�
		int intId = 0;
		
		// ���� ���°� �ƴ� ���ڿ��� ��� parseInt �޼ҵ忡���� NumberFormatException�� �߻��Ѵ�.
		// ���� �ݵ�� �� ���ܸ� ó���ؾ� �Ѵ�.
		try {
			intId = Integer.parseInt(id);			
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			// DataSource ��ü�� �̿��� �����ͺ��̽��� ����
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// ���� �ۼ�
			String query = "DELETE FROM member WHERE id = ?";
			System.out.println("QUERY: " + query);
			
			// SQL ���� �����ϴ� PreparedStatement ��ü�� ����
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// ������ ������ ��ġ�� ���� �߰�
			// preStatement.setString(1, id);
			 preStatement.setInt(1, intId);
			 
			 // ���� ����
			 preStatement.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// ������ ������ ���� PreparedStatement ��ü�� Connection ��ü�� ����
			try {
				if (preStatement != null) preStatement.close();
				if (connection != null) connection.close();				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}