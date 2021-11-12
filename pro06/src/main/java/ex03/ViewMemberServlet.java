package ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view-member")
public class ViewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTPSession ��ü ����
		// -> ���ڷ� false�� �Ѱܼ� ������ �������� �ʾ�����, null�� ��ȯ�ϵ��� �Ѵ�.
		HttpSession session = request.getSession(false);
		
		// ������ �����Ǿ� �ִ��� Ȯ��
		if (session == null) {
			// ������ �������� ���� ��� login.html�� ������
			response.sendRedirect("login.html");
			return;
		}
		
		// ���ǿ� ���ε��� �������� ������
		boolean isLoggedin = (Boolean)session.getAttribute("isLoggedin");
		String account = (String)session.getAttribute("account");
		
		// ���� �������� MIME Ÿ���� �����ϰ�, ��� ��Ʈ���� ����
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ������ �����͸� HTML �������� ����
		String output= "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Member Information</title></head>"
				+ "<body><h1>Member Information</h1>";
		
		// �α����� ��������� Ȯ��
		if (isLoggedin && account != null) {
			// ȸ�� ������ �������� ���� MemberDAO ��ü�� ����
			MemberDAO memberDAO = new MemberDAO();
			
			// MemberDAO ��ü�� �̿��� �����ͺ��̽����� ȸ�� ������ ��ȸ
			MemberVO member = memberDAO.getMember(account);
			
			output += "<ul><li>Account: " + member.getAccount() + "</li>"
					+ "<li>Name: " + member.getName() + "</li>"
					+ "<li>Email: " + member.getEmail() + "</li>"
					+ "<li>Registration: " + member.getRegdate() + "</li>";
		}
		else {
			output += "<p>Invalidaccess!</p>"
					+ "<p><a href=\"login.html\">Please log in again.</a></p>";
		}
		
		output += "</body></html>";
		
		out.print(output);
		out.close();
	}
}
