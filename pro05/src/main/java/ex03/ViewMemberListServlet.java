package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMemberList")
public class ViewMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");
				
		// HttpServletResponse 객체의 getWriter 메소드를 통해 출력 스트림의 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();
		
		// HttpServletRequest 객체에 바인딩 되어 있는 회원 목록을 가져온다.
		// -> Collection 객체를 바인딩한경우, 이를 받아올 때는 와일드 카드(?) 제네릭을 이용해 받아온다.
		//    그런 다음 나중에 Collection 객체의 요소에 접근할 때 형 변환해서 접근한다.
		List<?> memberList = (List<?>)request.getAttribute("memberList");
		
		// 클라이언트에 출력할 데이터
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Member List</title></head><body><h1>Member List</h1>";
						
						
				
		output += "<table border=\"1\"><thead><tr>"
				+ "<th>ID</th><th>Account</th><th>Password</th><th>Name</th>"
				+ "<th>Email</th><th>Registration date</th><th>Delete</th></tr></thead><tbody>";
				
		// ArrayList 객체에 저장된 MemberVO 객체에서 데이터를 가져와 표를 생성
		for (Object item : memberList) {
			MemberVO member = (MemberVO)item;
			output += "<tr><td>" + member.getId() + "</td>"
					+ "<td>" + member.getAccount() + "</td>"
					+ "<td>" + member.getPasswd() + "</td>"
					+ "<td>" + member.getName() + "</td>"
					+ "<td>" + member.getEmail() + "</td>"
					+ "<td>" + member.getRegdate() + "</td>"
					+ "<td><a href=\"member4?command=delete&id=" + member.getId()
					+ "\">[X]</a></td></tr>";
		}
				
		output += "</tbody></table></body></html>";
				
		// PrintWriter 객체의 print 메소드를 이용해 출력 스트림에 데이터를 출력
		// 이렇게출력한 데이터를 클라이언트에 전송된다.
		out.print(output);
				
		// 출력 스트림 닫기
		out.close();
	}
}
