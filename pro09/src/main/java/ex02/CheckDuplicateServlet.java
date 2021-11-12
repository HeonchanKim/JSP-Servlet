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
		// 클라이언트에서 전송된 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest 객체의 getParameter 메소드를 이용해 Ajax로 전송된 요청 매개변수를 읽어옴
		String account = (String)request.getParameter("account");
		System.out.println("account = " + account);
		
		// MemberDAO 객체를 생성해서 account가 중복됐는지 확인
		MemberDAO memberDAO = new MemberDAO();
		boolean result = memberDAO.isDuplicateAccount(account);
		
		// JSON.simple 라이브러리를 이용해 JSON 객체 생성
		JSONObject json = new JSONObject();
		
		// JSON 객체에 속성 설정
		json.put("success", true);
		json.put("duplicate", result);
		
		// JSON 객체를 이용해 JSON 데이터 생성
		String jsonString = json.toJSONString();
		System.out.println("jsonString = " + jsonString);
		
		// 응답할 데이터의 미디어 형식(MIME 타입) 설정
		response.setContentType("application/json; charset=utf-8");
		
		// 출력 스트림을 생성해서 출력
		PrintWriter out = response.getWriter();
		out.print(jsonString);
		out.close();
	}
}
