package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ �������� MIME Ÿ�� ����
		response.setContentType("text/html; charset=utf-8");
		
		// first2 �������� ���ε��� �����͸� ������
		// getAttribute �޼ҵ尡 ��ȯ�ϴ� ���� Object �ڷ����̹Ƿ� �ʿ��� �ڷ������� ��ȯ�� ���� ����
		String name = (String)request.getAttribute("name");
		
		// HttpServletResponse ��ü�� getWriter �޼ҵ带 ���� PrintWriter ��ü�� �޾ƿ�
		PrintWriter out = response.getWriter();
		
		// Ŭ���̾�Ʈ�� ������ ������
		String output = "<!DOCTYPE html>\n<html><head>"
				+ "<title>Dispatch Forward Test</title></head>"
				+ "<body><h1>Dispatch Forward Test</h1>"
				+ "<ul><li>Name: " + name + "</li></ul>"
				+ "</body></html>";
		
		out.print(output);
		out.close();
	}
}
