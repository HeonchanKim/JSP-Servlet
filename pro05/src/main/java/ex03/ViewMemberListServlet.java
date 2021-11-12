package ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMemberList")
public class ViewMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ �������� MIME Ÿ�� ����
		response.setContentType("text/html; charset=utf-8");
				
		// HttpServletResponse ��ü�� getWriter �޼ҵ带 ���� ��� ��Ʈ���� PrintWriter ��ü�� �޾ƿ�
		PrintWriter out = response.getWriter();
		
		// HttpServletRequest ��ü�� ���ε� �Ǿ� �ִ� ȸ�� ����� �����´�.
		// -> Collection ��ü�� ���ε��Ѱ��, �̸� �޾ƿ� ���� ���ϵ� ī��(?) ���׸��� �̿��� �޾ƿ´�.
		//    �׷� ���� ���߿� Collection ��ü�� ��ҿ� ������ �� �� ��ȯ�ؼ� �����Ѵ�.
		List<?> memberList = (List<?>)request.getAttribute("memberList");
		
		// Ŭ���̾�Ʈ�� ����� ������
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Member List</title></head><body><h1>Member List</h1>";
						
						
				
		output += "<table border=\"1\"><thead><tr>"
				+ "<th>ID</th><th>Account</th><th>Password</th><th>Name</th>"
				+ "<th>Email</th><th>Registration date</th><th>Delete</th></tr></thead><tbody>";
				
		// ArrayList ��ü�� ����� MemberVO ��ü���� �����͸� ������ ǥ�� ����
		for (Object item : memberList) {
			MemberVO member = (MemberVO)item;
			output += "<tr><td>" + member.getId() + "</td>"
					+ "<td>" + member.getAccount() + "</td>"
					+ "<td>" + member.getPasswd() + "</td>"
					+ "<td>" + member.getName() + "</td>"
					+ "<td>" + member.getEmail() + "</td>"
					+ "<td>" + member.getRegdate() + "</td>"
					+ "<td><a href=\"member4?command=delete&id=" + member.getId()
					+ "\">[X]</a></td></tr>";
		}
				
		output += "</tbody></table></body></html>";
				
		// PrintWriter ��ü�� print �޼ҵ带 �̿��� ��� ��Ʈ���� �����͸� ���
		// �̷�������� �����͸� Ŭ���̾�Ʈ�� ���۵ȴ�.
		out.print(output);
				
		// ��� ��Ʈ�� �ݱ�
		out.close();
	}
}
