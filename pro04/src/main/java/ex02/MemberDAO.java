package ex02;

import java.sql.Connection;
import java.sql.Date;
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
	
	// member 테이블의 레코드를 조회하는 메소드
	// -> 조회한 결과를 MemberVO 객체로 생성해서 ArrayList 객체에 담아서 반환
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
}