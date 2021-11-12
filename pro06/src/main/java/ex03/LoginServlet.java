package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 출력할 데이터를 HTML 형식으로 생성
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Log-in Status</title></head><body><h1>Log-in Status</h1>"
				+ "<p>Invaild access!</p>"
				+ "<p><a href=\"\">Please log in again.</a></p></body></html>";
		
		out.print(output);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트에서 전송한 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트에서 전송한 값을 구해옴
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		// MemberVO 객체를 생성해 클라이언트에서 전송된 회원 정보를 저장
		MemberVO member = new MemberVO();
		
		member.setAccount(account);
		member.setPasswd(password);
		
		// 로그인 정보를 확인하기 위해 MemberDAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
		
		
		// 응답하기 위해 MIME 타입을 설정하고 출력 스트림을 구해온다.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 출력할 데이터를 HTML 형식으로 생성
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Log-in Status</title></head><body><h1>Log-in Status</h1>";
		
		// 클라이언트에서 전송된 로그인 정보가 올바른지 확인
		if (memberDAO.isValidLogin(member)) {
			// 로그인이 올바른 경우, 로그인 정보를 세션에 저장해서 다음 요청에서 활용
			// HTTPServletRequest 객체의 getSession 메소드를 이용해 HttpSession 객체를 생성
			HttpSession session = request.getSession();
			
			session.setAttribute("isLoggedin", true);
			session.setAttribute("account", account);
			
			output += "<p>You have logged in <code>" + account + "</code>.</p>"
					+ "<p><a href=\"view-member\">View Your Information</a></p>";
		}
		else {
			output += "<p>Invaild account or password!</p>"
					+ "<p><a href=\"\">Please log in again.</a></p>";			
		}
		
		output += "</body></html>";
		
		out.print(output);
		out.close();
	}

}
