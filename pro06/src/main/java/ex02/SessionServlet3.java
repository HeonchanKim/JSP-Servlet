package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session3")
public class SessionServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정과 PrintWriter 객체 생성
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// HttpServletRequest 객체의 getSession 메소드를 이용해 HttpSession 객체를 생성
		HttpSession session = request.getSession(false);
		
		// 응답할 데이터를 HTML 형식으로 생성
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Session Test</title></head><body><h1>Session Test</h1>";
		
		// 새롭게 생성된 세션인지 확인
		if(session.isNew())
			output += "<p>A new session has been created.</p>";
		else
			output += "<p>Reuse the previously created session.</p>";
			
		// 세션 정보 출력
		output += "<ul><li>Session ID: " + session.getId() + "</li>"
				+ "<li>Session creation time: " + new Date(session.getCreationTime()) + "</li>"
				+ "<li>Last session access time: " + new Date(session.getLastAccessedTime()) + "</li>"
				+ "<li>Session active interval: " + session.getMaxInactiveInterval() + "</li></ul>";
		
		// 세션을 제거
		session.invalidate();
		
		output += "<h2>Invalidate the session!</h2>";
		
		output += "</body></html>";
		
		// 클라이언트에 응답
		out.print(output);
		out.close();
	}
}
