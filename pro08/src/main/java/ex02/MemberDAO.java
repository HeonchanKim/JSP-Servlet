package ex02;

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
	
	// ResultSet ��ü�� Statement ��ü, PreparedStatement ��ü, Connection ��ü�� ����
	private void closeConnection() {
		// ������ ������ �������� �����Ѵ�.
		// ResultSet ��ü, Statement ��ü, Connection ��ü�� ������ ������ �������� ����
		// �Ʒ� ��ü���� �������� �ʾ��� ���� �ֱ� ������, �ݵ�� ��ü�� �����ƴ��� �˻��� ���� ����
		// �Ʒ� ����鿡���� ���ܰ� �߻��� �� �����Ƿ�, ������ ���� ó���� ����� �Ѵ�.
		if (resultSet != null) try { resultSet.close(); } catch (Exception e) {}
		if (statement != null) try { statement.close(); } catch (Exception e) {}
		if (preStatement != null) try { preStatement.close(); } catch (Exception e) {}
		if (connection != null) try { connection.close(); } catch (Exception e) {}
	}
	
	/**
	 * member ���̺��� ���ڵ带 ��ȸ�ϴ� �޼ҵ�
	 * @return ��ȸ�� ����� MemberVO ��ü�� �����ؼ� ArrayList ��ü�� ��Ƽ� ��ȯ
	 * */
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
			closeConnection();
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
			closeConnection();
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
			closeConnection();
		}
	}
	
	/**
	 * ���޵� ������ ��ȿ�� ȸ�� �������� Ȯ��
	 * @param member Ȯ���ϰ��� �ϴ� ������ ��й�ȥ�� ��� �ִ� MemberVO ��ü
	 * @return ȸ�� ������ ��ȿ���� ����
	  */
	public boolean isValidLogin(MemberVO member) {
		// ȸ�� ������ �����ϴ��� ���θ� ��Ÿ���� ����
		boolean result = false;
		
		try {
			// DataSource ��ü�� �̿��� �����ͺ��̽��� ����
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// ���� �ۼ�
			String query = "SELECT DECODE(COUNT(*), 1, 'true', 'false') AS result "
						+ "FROM member WHERE account = ? AND passwd = ?";
			
			System.out.println("QUERY: " + query);
			
			// SQL ���� �����ϴ� PreparedStatedment ��ü ����
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// ������ ������ ��ġ�� ���� �߰�
			preStatement.setString(1, member.getAccount());
			preStatement.setString(2, member.getPasswd());
			
			// ������ ������ ����, ���� ����� ResultSet ��ü�� ����
			resultSet = preStatement.executeQuery();
			
			// ResultSet ��ü�� Ŀ���� ù ��° ���ڵ�� �̵�
			resultSet.next();
			
			// ���ڵ��� result �÷��� ���� Ȯ���ؼ� boolean �ڷ������� ��ȯ
			result = Boolean.parseBoolean(resultSet.getString("result"));
			System.out.println("result = " + result);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			// ����� Ȯ���� ����, connection ����
			closeConnection();
		}
		return result;
	}
	
	/**
	 * �������� ȸ�� ������ ����
	 * @param account Ȯ���ϰ��� �ϴ� ����
	 * @return ȸ�� ������ ��� �ִ� MemberVO ��ü
	 * */
	public MemberVO getMember(String account) {
		// member ���̺��� ��ȸ�� ���ڵ带 ������ MemberVO ��ü
		MemberVO member = new MemberVO();
		
		try {
			// DataSource ��ü�� �̿��� �����ͺ��̽��� ����
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// ���� �ۼ�
			String query = "SELECT * FROM member WHERE account = ?";
			System.out.println("QUERY: " + query);
			
			// SQL ���� ������ PreparedStatement ��ü ����
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// ������ ������ ��ġ�� ���� �߰�
			preStatement.setString(1, account);
			
			// ������ ������ ����, ���� ����� ResultSet ��ü�� ����
			resultSet = preStatement.executeQuery();
			
			// ResultSet ��ü�� Ŀ���� ù ��° ���ڵ�� �̵�
			resultSet.next();
			
			// �о�� ���ڵ��� �÷����� MemberVO ��ü�� ����
			member.setId(resultSet.getInt("id"));
			member.setAccount(resultSet.getString("account"));
			member.setPasswd(resultSet.getString("passwd"));
			member.setName(resultSet.getString("name"));
			member.setEmail(resultSet.getString("email"));
			member.setRegdate(resultSet.getDate("regdate"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// connection ����
			closeConnection();
		}
		
		// MemberVO ��ü ��ȯ
		return member;
	}
	
	/**
	 * �̸����� ȸ�� ����� ��ȸ
	 * @param name ��ȸ�� ȸ���� �̸�
	 * @return ȸ�� ������ ��� �ִ� ArrayList ��ü
	 **/
	
	public List<MemberVO> getMemberListByName(String name) {
		// member ���̺��� ��ȸ�� ���ڵ带 ������ ArrayList ��ü
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			// DataSource ��ü�� �̿��� �����ͺ��̽��� ����
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// connection ��ü�� ���� Statement ��ü�� ����
			statement = connection.createStatement();
			System.out.println("Success to create the Statement object!");
			
			// ���� �ۼ�
			String query = String.format("SELECT * FROM member WHERE LOWER(name) LIKE '%%%s%%'", name);
			//SELECT * FROM member WHERE LOWER(name) LIKE '%jackson%'
			System.out.println("QUERY: " + query);
			
			// ������ ������ ����, ���� ����� ResultSet ��ü�� ����
			resultSet = statement.executeQuery(query);
			
			// �ݺ��ڸ� �̿��� ���ڵ带 ���ʴ�� Ȯ��
			// ResultSet ��ü�� next �޼ҵ�� ResultSet ��ü�� Ŀ���� ���� ���ڵ�� �̵���Ű��,
			// ���� ���ڵ尡 �����ϴ� ��� true�� ��ȯ
			while (resultSet.next()) {
				// ���ڵ��� �÷����� MemberVO ��ü�� ����
				MemberVO member = new MemberVO(
						resultSet.getInt("id"),
						resultSet.getString("account"),
						resultSet.getString("passwd"),
						resultSet.getString("name"),
						resultSet.getString("email"),
						resultSet.getDate("regdate")
				);
				
				// ������ MemberVO ��ü�� ArrayList ��ü�� �߰�
				list.add(member);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// ResultSet ��ü�� Statement ��ü, Connection ��ü�� ����
			closeConnection();
		}
		// ��ȸ�� ȸ�� ������ ��ȯ
		return list;
	}
}