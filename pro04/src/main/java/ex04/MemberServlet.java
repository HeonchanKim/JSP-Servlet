package ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송한 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트에서 전송한 값을 구해옴
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		
		// 매개변수 command의 값이 "delete"이고, id 매개변수가 설정된 경우, 회원정보 삭제
		if(command != null && command.equals("delete") && id != null) {
			// 회원 정보르 삭제하기 위해 MemberDAO 객체 생성
			MemberDAO memberDAO = new MemberDAO();
			
			// 전달된 id 정보로 회원 정보를 삭제
			memberDAO.deleteMember(id);
		}
		
		printMemberList(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송한 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트에서 전송한 값을 구해옴
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// TODO: 클라이언트에서 전송된 값은 반드시 검사해야한다!
		
		// 클라이언트에서 전송한 값이 제대로 된 경우에만 데이터베이스에 입력!
		if(account != null && passwd != null && name != null && email != null) {
			// 클라이언트에서 전송한 값을 MemberVO 객체에 저장
			MemberVO member = new MemberVO(0, account, passwd, name, email, null);
			
			// 새로운 회원 정보를 데이터베이스에 추가하기 위해 MemberDAO 객체를 생성
			MemberDAO memberDAO = new MemberDAO();
			
			// 새로운 회원 정보를 등록
			memberDAO.insertMember(member);
		}
		
		// 회원 목록 출력
		printMemberList(request, response);
	}
	protected void printMemberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse 객체의 getWriter 메소드를 통해 출력 스트림의 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();
		
		// MemberDAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		
		// MemberDAO 객체를 통해 오라클 데이터베이스에서 회원 정보를 조회
		List<MemberVO> list = memberDAO.getMemberList();
		
		// 클라이언트에 출력할 데이터
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Member List</title></head><body><h1>Member List</h1>";
				
				
		
		output += "<table border=\"1\"><thead><tr>"
				+ "<th>ID</th><th>Account</th><th>Password</th><th>Name</th>"
				+ "<th>Email</th><th>Registration date</th><th>Delete</th></tr></thead><tbody>";
		
		// ArrayList 객체에 저장된 MemberVO 객체에서 데이터를 가져와 표를 생성
		for (MemberVO member : list) {
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
