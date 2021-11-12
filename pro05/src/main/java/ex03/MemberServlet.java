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
		// MemberDAO 객체 생성
		MemberDAO memberDAO = new MemberDAO();
				
		// MemberDAO 객체를 통해 오라클 데이터베이스에서 회원 정보를 조회
		List<MemberVO> list = memberDAO.getMemberList();
		
		// HttpServletRequest 객체에 회원 목록을 바인딩
		request.setAttribute("memberList", list);
		
		// RequestDispatcher 객체를 생성하고, forward 메소드를 이용해 viewMemberList 서블릿으로 포워딩
		request.getRequestDispatcher("viewMemberList").forward(request, response);
	}
}
