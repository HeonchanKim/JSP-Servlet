package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;


@WebServlet("/check-duplicate")
public class CheckDuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ŭ���̾�Ʈ���� ���۵� �������� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest ��ü�� getParameter �޼ҵ带 �̿��� Ajax�� ���۵� ��û �Ű������� �о��
		String account = (String)request.getParameter("account");
		System.out.println("account = " + account);
		
		// MemberDAO ��ü�� �����ؼ� account�� �ߺ��ƴ��� Ȯ��
		MemberDAO memberDAO = new MemberDAO();
		boolean result = memberDAO.isDuplicateAccount(account);
		
		// JSON.simple ���̺귯���� �̿��� JSON ��ü ����
		JSONObject json = new JSONObject();
		
		// JSON ��ü�� �Ӽ� ����
		json.put("success", true);
		json.put("duplicate", result);
		
		// JSON ��ü�� �̿��� JSON ������ ����
		String jsonString = json.toJSONString();
		System.out.println("jsonString = " + jsonString);
		
		// ������ �������� �̵�� ����(MIME Ÿ��) ����
		response.setContentType("application/json; charset=utf-8");
		
		// ��� ��Ʈ���� �����ؼ� ���
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.close();
	}
}
