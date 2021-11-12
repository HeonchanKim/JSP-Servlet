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
		
		// Ŭ���̾�Ʈ���� ������ �������� ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest ��ü�� geParameter �޼ҵ带 �̿��� Ŭ���̾�Ʈ���� ������ ���� ����
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		// Ŭ���̾�Ʈ���� ������ �����͸� ���
		System.out.println("Account: " + account);
		System.out.println("Password: " + password);
		
		// TODO: �α��� ó��
		
		// ������ �������� MIME Ÿ�� ����
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse ��ü�� getWriter �޼ҵ带 ���� ��� ��Ʈ���� PrintWriter ��ü�� �޾ƿ�
		// PrintWriter Ŭ������ java.io ��Ű���� ���ǵǾ� �ִ�.
		PrintWriter out = response.getWriter();
		
		// ����� �����͸� HTML �������� ����
		String output = "<!doctype html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Your Request</title></head>"
				+ "<body><ul><li>Account: " + account + "</li>"
				+ "<li>Password: " + password + "</li></ul></body></html>";
		
		// PrintWriter ��ü�� print �޼ҵ带 �̿��� ��� ��Ʈ���� ������ �����͸� ���
		// �� �����ʹ� Ŭ���̾�Ʈ�� ���۵ȴ�.
		out.print(output);
	}
}
