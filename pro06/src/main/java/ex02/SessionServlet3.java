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
		// ������ �������� MIME Ÿ�� ������ PrintWriter ��ü ����
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// HttpServletRequest ��ü�� getSession �޼ҵ带 �̿��� HttpSession ��ü�� ����
		HttpSession session = request.getSession(false);
		
		// ������ �����͸� HTML �������� ����
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Session Test</title></head><body><h1>Session Test</h1>";
		
		// ���Ӱ� ������ �������� Ȯ��
		if(session.isNew())
			output += "<p>A new session has been created.</p>";
		else
			output += "<p>Reuse the previously created session.</p>";
			
		// ���� ���� ���
		output += "<ul><li>Session ID: " + session.getId() + "</li>"
				+ "<li>Session creation time: " + new Date(session.getCreationTime()) + "</li>"
				+ "<li>Last session access time: " + new Date(session.getLastAccessedTime()) + "</li>"
				+ "<li>Session active interval: " + session.getMaxInactiveInterval() + "</li></ul>";
		
		// ������ ����
		session.invalidate();
		
		output += "<h2>Invalidate the session!</h2>";
		
		output += "</body></html>";
		
		// Ŭ���̾�Ʈ�� ����
		out.print(output);
		out.close();
	}
}
