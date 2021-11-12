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
	// DBCP를 관리하는 DataSource 객체
	private DataSource dataSource;
	
	// 오라클 데이터베이스에 연결하는 Connection 객체
	private Connection connection;
	
	// SQL 문을 실행하는 Statement 객체
	private Statement statement;
	
	// SQL 문을 실행하는 PreparedStatement 객체
	private PreparedStatement preStatement;
	
	// 데이터베이스를 조회하는 결과를 담을 ResultSet 객체
	private ResultSet resultSet;
	
	// 생성자
	public MemberDAO() {
		try {
			// Context 객체 생성
			Context context = new InitialContext();
			
			// Context 객체를 통해 JNDI에 접근해서, 톰캣 컨테이너가 연결한 DataSource 객체를 받아온다.
			// -> Context 객체의 lookup 메소드를 이용해 context.xml 파일에 설정한 Resource 태그에
			//    설정한 정보를 읽어온다.
			//    lookup 메소드는 Object 객체를 반환하므로 DataSource 자료형으로 변환해서 대입
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ResultSet 객체와 Statement 객체, PreparedStatement 객체, Connection 객체를 해제
	private void closeConnection() {
		// 생성한 순서의 역순으로 해제한다.
		// ResultSet 객체, Statement 객체, Connection 객체를 생성한 순서의 역순으로 해제
		// 아래 객체들은 생성되지 않았을 수도 있기 때문에, 반드시 객체가 생성됐는지 검사한 다음 해제
		// 아래 문장들에서도 예외가 발생할 수 있으므로, 별도의 예외 처리를 해줘야 한다.
		if (resultSet != null) try { resultSet.close(); } catch (Exception e) {}
		if (statement != null) try { statement.close(); } catch (Exception e) {}
		if (preStatement != null) try { preStatement.close(); } catch (Exception e) {}
		if (connection != null) try { connection.close(); } catch (Exception e) {}
	}
	
	/**
	 * member 테이블의 레코드를 조회하는 메소드
	 * @return 조회한 결과를 MemberVO 객체로 생성해서 ArrayList 객체에 담아서 반환
	 * */
	public List<MemberVO> getMemberList() {
		// member 테이블에서 조회한 레코드를 저장할 ArrayList 객체
		List<MemberVO> list = new ArrayList<MemberVO>(); 
		
		try {
			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// 쿼리를 실행할 Statement 객체 생성
			statement = connection.createStatement();
			System.out.println("Succes to create the Statement object!");
			
			// 실행할 쿼리 작성
			String query = "SELECT * FROM member ORDER BY id DESC";
			System.out.println("QUERY: " + query);
			
			// Statement 객체를 이용해 쿼리를 실행한 다음, 실행 결과를 ResultSet 객체에 저장
			resultSet = statement.executeQuery(query);
			
			// 반복자를 이용해 ResultSet 객체에 저장된 레코드를 차례대로 확인
			while (resultSet.next()) {
				// getInt 메소드 등을 이용해 레코드의 각 컬럼을 참조
				int id = resultSet.getInt("id");
				String account = resultSet.getString("account");
				String passwd = resultSet.getString("passwd");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				Date regdate = resultSet.getDate("regdate");
				
				// MemberVO 객체를 생성해서 각 속성을 조회한 레코드의 컴럼으로 설정
				MemberVO member = new MemberVO(id, account, passwd, name, email, regdate);
				
				// ArrayList 객체에 MemberVO 객체를 저장
				list.add(member);
			}
		}
		catch (Exception e) {
			e.printStackTrace();			
		}
		// 예외(exception)가 발생하든 하지 않든 실행해야 하는 문장들은 finally 블록에 작성
		finally {
			// 레코드를 모두 확인한 다음, 데이터베이스 연결을 해제해야 한다.
			closeConnection();
		}
		
		// 생성한 ArrayList 객체를 반환
		return list;
	}
	
	// member 테이블에 새로운 회원 정보를 추가
	public void insertMember(MemberVO member) {
		try {
			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// 쿼리 작성
			// 이때 값을 넣기 위한 자리에 '?'를 넣는다.
			String query = "INSERT INTO member (id, account, passwd, name, email) "
						 + "VALUES (SEQ_MEMBER_ID.NEXTVAL, ?, ?, ?, ?)";
			System.out.println("QUERY: " + query);
			
			// SQL 문을 실행하는 PreparedStatement 객체를 생성
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// 쿼리의 지정한 위치에 값을 추가
			// -> PreparedStatement 객체의 setString, setInt 등의 메소드를 이용
			preStatement.setString(1, member.getAccount());
			preStatement.setString(2, member.getPasswd());
			preStatement.setString(3, member.getName());
			preStatement.setString(4, member.getEmail());
			
			// 쿼리를 실행
			preStatement.executeQuery();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 쿼리를 실행한 다음 PreparedStatement 객체와 Connection 객체를 해제
			closeConnection();
		}
	}
	
	// member 테이블에서 회원 정보 삭제
	public void deleteMember(String id) {
		// 문자열로 전달된 id가 정수인지 검사
		int intId = 0;
		
		// 정수 형태가 아닌 문자열인 경우 parseInt 메소드에서는 NumberFormatException이 발생한다.
		// 따라서 반드시 이 예외를 처리해야 한다.
		try {
			intId = Integer.parseInt(id);			
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// 쿼리 작성
			String query = "DELETE FROM member WHERE id = ?";
			System.out.println("QUERY: " + query);
			
			// SQL 문을 실행하는 PreparedStatement 객체를 생성
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// 쿼리의 지정한 위치에 값을 추가
			// preStatement.setString(1, id);
			 preStatement.setInt(1, intId);
			 
			 // 쿼리 실행
			 preStatement.executeQuery();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 쿼리를 실행한 다음 PreparedStatement 객체와 Connection 객체를 해제
			closeConnection();
		}
	}
	
	/**
	 * 전달된 정보가 유효한 회원 정보인지 확인
	 * @param member 확인하고자 하는 계정과 비밀번혼를 담고 있는 MemberVO 객체
	 * @return 회원 정보가 유효한지 여부
	  */
	public boolean isValidLogin(MemberVO member) {
		// 회원 정보가 존재하는지 여부를 나타내는 변수
		boolean result = false;
		
		try {
			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// 쿼리 작성
			String query = "SELECT DECODE(COUNT(*), 1, 'true', 'false') AS result "
						+ "FROM member WHERE account = ? AND passwd = ?";
			
			System.out.println("QUERY: " + query);
			
			// SQL 문을 실행하는 PreparedStatedment 객체 생성
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// 쿼리의 지정한 위치에 값을 추가
			preStatement.setString(1, member.getAccount());
			preStatement.setString(2, member.getPasswd());
			
			// 쿼리를 실행한 다음, 실행 결과를 ResultSet 객체에 저장
			resultSet = preStatement.executeQuery();
			
			// ResultSet 객체의 커서를 첫 번째 레코드로 이동
			resultSet.next();
			
			// 레코드의 result 컬럼의 값을 확인해서 boolean 자료형으로 변환
			result = Boolean.parseBoolean(resultSet.getString("result"));
			System.out.println("result = " + result);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			// 결과를 확인한 다음, connection 해제
			closeConnection();
		}
		return result;
	}
	
	/**
	 * 계정으로 회원 정보를 참조
	 * @param account 확인하고자 하는 계정
	 * @return 회원 정보를 담고 있는 MemberVO 객체
	 * */
	public MemberVO getMember(String account) {
		// member 테이블에서 조회한 레코드를 저장할 MemberVO 객체
		MemberVO member = new MemberVO();
		
		try {
			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// 쿼리 작성
			String query = "SELECT * FROM member WHERE account = ?";
			System.out.println("QUERY: " + query);
			
			// SQL 문을 실행할 PreparedStatement 객체 생성
			preStatement = connection.prepareStatement(query);
			System.out.println("Success to create the PreparedStatement object!");
			
			// 쿼리의 지정한 위치에 값을 추가
			preStatement.setString(1, account);
			
			// 쿼리를 실행한 다음, 실행 결과를 ResultSet 객체에 저장
			resultSet = preStatement.executeQuery();
			
			// ResultSet 객체의 커서를 첫 번째 레코드로 이동
			resultSet.next();
			
			// 읽어온 레코드의 컬럼들을 MemberVO 객체에 설정
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
			// connection 해제
			closeConnection();
		}
		
		// MemberVO 객체 반환
		return member;
	}
	
	/**
	 * 이름으로 회원 목록을 조회
	 * @param name 조회할 회원의 이름
	 * @return 회원 정보를 담고 있는 ArrayList 객체
	 **/
	
	public List<MemberVO> getMemberListByName(String name) {
		// member 테이블에서 조회한 레코드를 저장할 ArrayList 객체
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			// DataSource 객체를 이용해 데이터베이스에 연결
			connection = dataSource.getConnection();
			System.out.println("Success to get the Connection object!");
			
			// connection 객체를 통해 Statement 객체를 생성
			statement = connection.createStatement();
			System.out.println("Success to create the Statement object!");
			
			// 쿼리 작성
			String query = String.format("SELECT * FROM member WHERE LOWER(name) LIKE '%%%s%%'", name);
			//SELECT * FROM member WHERE LOWER(name) LIKE '%jackson%'
			System.out.println("QUERY: " + query);
			
			// 쿼리를 실행한 다음, 실행 결과를 ResultSet 객체에 저장
			resultSet = statement.executeQuery(query);
			
			// 반복자를 이용해 레코드를 차례대로 확인
			// ResultSet 객체의 next 메소드는 ResultSet 객체의 커서를 다음 레코드로 이동시키며,
			// 다음 레코드가 조재하는 경우 true를 반환
			while (resultSet.next()) {
				// 레코드의 컬럼으로 MemberVO 객체를 생성
				MemberVO member = new MemberVO(
						resultSet.getInt("id"),
						resultSet.getString("account"),
						resultSet.getString("passwd"),
						resultSet.getString("name"),
						resultSet.getString("email"),
						resultSet.getDate("regdate")
				);
				
				// 생성한 MemberVO 객체를 ArrayList 객체에 추가
				list.add(member);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			// ResultSet 객체와 Statement 객체, Connection 객체를 해제
			closeConnection();
		}
		// 조회한 회원 정보를 반환
		return list;
	}
}