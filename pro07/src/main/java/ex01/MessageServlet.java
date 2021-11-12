package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ���� ������ �����͸� �о��
		String message = request.getParameter("message");
		
		// ������ �������� MIME Ÿ���� �����ϰ�, ��� ��Ʈ���� ����
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ������ �����͸� HTML �������� ����
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>�޽��� �Է�</title></head>"
				+ "<body><h1>�޽��� �Է�</h1>"
				+ "<p>����� �޽����� &quot;" + message + "&quot;�Դϴ�.</p></body></html>";
		
		out.print(output);
		out.close();
	}

}
