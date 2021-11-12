package ex03;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// MemberDAO ��ü ����
		MemberDAO memberDAO = new MemberDAO();
				
		// MemberDAO ��ü�� ���� ����Ŭ �����ͺ��̽����� ȸ�� ������ ��ȸ
		List<MemberVO> list = memberDAO.getMemberList();
		
		// HttpServletRequest ��ü�� ȸ�� ����� ���ε�
		request.setAttribute("memberList", list);
		
		// RequestDispatcher ��ü�� �����ϰ�, forward �޼ҵ带 �̿��� viewMemberList �������� ������
		request.getRequestDispatcher("viewMemberList").forward(request, response);
	}
}
