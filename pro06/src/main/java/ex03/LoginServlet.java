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
		
		// ����� �����͸� HTML �������� ����
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Log-in Status</title></head><body><h1>Log-in Status</h1>"
				+ "<p>Invaild access!</p>"
				+ "<p><a href=\"\">Please log in again.</a></p></body></html>";
		
		out.print(output);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ���� ������ �������� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// Ŭ���̾�Ʈ���� ������ ���� ���ؿ�
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		// MemberVO ��ü�� ������ Ŭ���̾�Ʈ���� ���۵� ȸ�� ������ ����
		MemberVO member = new MemberVO();
		
		member.setAccount(account);
		member.setPasswd(password);
		
		// �α��� ������ Ȯ���ϱ� ���� MemberDAO ��ü ����
		MemberDAO memberDAO = new MemberDAO();
		
		
		// �����ϱ� ���� MIME Ÿ���� �����ϰ� ��� ��Ʈ���� ���ؿ´�.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ����� �����͸� HTML �������� ����
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Log-in Status</title></head><body><h1>Log-in Status</h1>";
		
		// Ŭ���̾�Ʈ���� ���۵� �α��� ������ �ùٸ��� Ȯ��
		if (memberDAO.isValidLogin(member)) {
			// �α����� �ùٸ� ���, �α��� ������ ���ǿ� �����ؼ� ���� ��û���� Ȱ��
			// HTTPServletRequest ��ü�� getSession �޼ҵ带 �̿��� HttpSession ��ü�� ����
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
