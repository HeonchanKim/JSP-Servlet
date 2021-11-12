package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
	System.out.println("CALL: LoginServlet.init()");	
	}

	public void destroy() {
		System.out.println("CALL: LoginServlet.destroy()");	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ���� ������ �������� ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest ��ü�� geParameter �޼ҵ带 �̿��� Ŭ���̾�Ʈ���� ������ ���� ����
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		// Ŭ���̾�Ʈ���� ������ �����͸� ���
		System.out.println("Account: " + account);
		System.out.println("Password: " + password);
	}

}
