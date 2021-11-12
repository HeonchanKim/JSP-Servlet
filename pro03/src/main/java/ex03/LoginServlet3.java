package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	System.out.println("CALL: LoginServlet.init()");	
	}

	public void destroy() {
		System.out.println("CALL: LoginServlet.destroy()");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: LoginServlet.doPost()");	
		
		// 클라이언트에서 전송한 데이터의 문자 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest 객체의 geParameter 메소드를 이용해 클라이언트에서 전송한 값을 참조
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		// 클라이언트에서 전송한 데이터를 출력
		System.out.println("Account: " + account);
		System.out.println("Password: " + password);
		
		// TODO: 로그인 처리
		
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse 객체의 getWriter 메소드를 통해 출력 스트림의 PrintWriter 객체를 받아옴
		// PrintWriter 클래스는 java.io 패키지에 정의되어 있다.
		PrintWriter out = response.getWriter();
		
		// 출력할 데이터를 HTML 형식으로 생성
		String output = "<!doctype html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Your Request</title></head>"
				+ "<body><ul><li>Account: " + account + "</li>"
				+ "<li>Password: " + password + "</li></ul></body></html>";
		
		// PrintWriter 객체의 print 메소드를 이용해 출력 스트림에 생성한 데이터를 출력
		// 이 데이터는 클라이언트에 전송된다.
		out.print(output);
	}
}
