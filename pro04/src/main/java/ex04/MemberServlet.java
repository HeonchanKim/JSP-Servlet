package ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member4")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ���� ������ �������� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// Ŭ���̾�Ʈ���� ������ ���� ���ؿ�
		String command = request.getParameter("command");
		String id = request.getParameter("id");
		
		// �Ű����� command�� ���� "delete"�̰�, id �Ű������� ������ ���, ȸ������ ����
		if(command != null && command.equals("delete") && id != null) {
			// ȸ�� ������ �����ϱ� ���� MemberDAO ��ü ����
			MemberDAO memberDAO = new MemberDAO();
			
			// ���޵� id ������ ȸ�� ������ ����
			memberDAO.deleteMember(id);
		}
		
		printMemberList(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ���� ������ �������� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// Ŭ���̾�Ʈ���� ������ ���� ���ؿ�
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		// TODO: Ŭ���̾�Ʈ���� ���۵� ���� �ݵ�� �˻��ؾ��Ѵ�!
		
		// Ŭ���̾�Ʈ���� ������ ���� ����� �� ��쿡�� �����ͺ��̽��� �Է�!
		if(account != null && passwd != null && name != null && email != null) {
			// Ŭ���̾�Ʈ���� ������ ���� MemberVO ��ü�� ����
			MemberVO member = new MemberVO(0, account, passwd, name, email, null);
			
			// ���ο� ȸ�� ������ �����ͺ��̽��� �߰��ϱ� ���� MemberDAO ��ü�� ����
			MemberDAO memberDAO = new MemberDAO();
			
			// ���ο� ȸ�� ������ ���
			memberDAO.insertMember(member);
		}
		
		// ȸ�� ��� ���
		printMemberList(request, response);
	}
	protected void printMemberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ������ �������� MIME Ÿ�� ����
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse ��ü�� getWriter �޼ҵ带 ���� ��� ��Ʈ���� PrintWriter ��ü�� �޾ƿ�
		PrintWriter out = response.getWriter();
		
		// MemberDAO ��ü ����
		MemberDAO memberDAO = new MemberDAO();
		
		// MemberDAO ��ü�� ���� ����Ŭ �����ͺ��̽����� ȸ�� ������ ��ȸ
		List<MemberVO> list = memberDAO.getMemberList();
		
		// Ŭ���̾�Ʈ�� ����� ������
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Member List</title></head><body><h1>Member List</h1>";
				
				
		
		output += "<table border=\"1\"><thead><tr>"
				+ "<th>ID</th><th>Account</th><th>Password</th><th>Name</th>"
				+ "<th>Email</th><th>Registration date</th><th>Delete</th></tr></thead><tbody>";
		
		// ArrayList ��ü�� ����� MemberVO ��ü���� �����͸� ������ ǥ�� ����
		for (MemberVO member : list) {
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
