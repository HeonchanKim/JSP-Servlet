package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 응답할 타입과 미디어 형식(MIME 타입)을 담고 있는 맵
	@SuppressWarnings("serial")
	private static final Map<String, String> mediaTypes = new HashMap<String, String>() {{
		put("text", "text/plain; charset=utf-8");
		put("html", "text/html; charset=utf-8");
		put("xml", "application/xml; charset=utf-8");
		put("json", "application/json; charset=utf-8");
	}};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest 객체의 getParameter 메소드를 이용해 Ajax로 전송된
		// 요청 매개변수를 읽어옴
		String type = (String)request.getParameter("type");
		System.out.println("type = " + type);
		
		// 응답할 데이터의 미디어 형식(MIME 타입) 지정
		// 요청 매개변수 type에 따라 응답할 데이터의 미디어 형식을 결정
		// HttpServletResponse 객체의 getWriter 메소드를 호출하기 전에 미디어 형식을
		// 지정해야 한다.
		if (mediaTypes.containsKey(type))
			response.setContentType(mediaTypes.get(type));
		else
			response.setContentType("text/html; charset=utf-8");
		
		// 출력 스트림 생성
		PrintWriter out = response.getWriter();
		
		// 응답 데이터
		String output;
		
		// 응답할 데이터는 요청 매개변수 type에 따라 다른 값이 된다.
		if(type.equals("text"))
			output = "type = TEXT";
		else if(type.equals("xml"))
			output = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
				+ "<response><success>true</success><type>XML</type></response>";
		else if (type.equals("json"))
			output = "{ \"success\": true, \"type\": \"JSON\" }";
		else
			output = "<!doctype html>\n<html><head><meta charset=\"utf-8\">"
				+ "<title>Something is Wrong!</title></head><body>"
				+ "<h1>Something is Wrong!</h1></body></html>";
		
		// 클라이언트에게 응답
		out.print(output);
		out.close();
		
	}
}