package ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// 오라클 데이터베이스의 접속 정보 
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "c##scott";
	private static final String DB_PASSWORD = "tiger";
	
	// 오라클 데이터베이스에 연결하는 Connection 객체
	private Connection connection;
	
	// SQL 문을 실행하는 Statement 객체
	private Statement statement;
	
	// 데이터베이스를 조회하는 결과를 담을 ResultSet 객체
	private ResultSet resultSet;
	
	// member 테이블의 레코드를 조회하는 메소드
	// -> 조회한 결과를 MemberVO 객체로 생성해서 ArrayList 객체에 담아서 반환
	public List<MemberVO> getMemberList() {
		// member 테이블에서 조회한 레코드를 저장할 ArrayList 객체
		List<MemberVO> list = new ArrayList<MemberVO>(); 
		
		try {
			// 오라클 데이터베이스에 연결
			connectDatabase();
			
			// 실행할 쿼리 작성
			String query = "SELECT * FROM member";
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
			// -> ResultSet 객체, Statement 객체, Connection 객체를 생성한 순서의 역순으로 해제
			try {
				// 아래 문장들에서도 예외가 발생할 수 있으므로, 별도의 예외 처리를 해줘야 한다.
				
				// 아래 객체들은 생성되지 않았을 수도 있기 때문에, 반드시 객체가 생성됐는지 검사한 다음 해제
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();	
			}
			catch (Exception e){
				e.printStackTrace();
			}
		}
		// 생성한 ArrayList 객체를 반환
		return list;
		
	}
	
	// 오라클 데이터베이스에 연결하는 메소드
	private void connectDatabase() {
		try {
			// 1. 오라클 JDBC 드라이버를 로딩
			Class.forName(DB_DRIVER);
			System.out.println("DB: Success to load the Oracle JDBC driver!");
			
			// 2. 오라클 데이터베이스에 연결 Connection 객체 생성
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			System.out.println("DB: Success to create the Connection object!");
			
			// 3.쿼리를 실행하기 위한 Statement 객체 생성
			statement = connection.createStatement();
			System.out.println("DB: Success to create the Statement object!");
			
		}
		catch (Exception e) {
			e.printStackTrace();			
		}
	}
	
}
