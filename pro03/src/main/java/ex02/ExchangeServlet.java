package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange")
public class ExchangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: ExchangeServlet.init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: ExchangeServlet.doGet()");
		
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse 객체의 getWriter 메소드를 통해 출력 스트림의 PrintWriter 객체를 받아옴
		// PrintWriter 클래스는 java.io 패키지에 정의되어 있다.
		PrintWriter out = response.getWriter();
		
		// 클라이언트에 출력할 데이터를 HTML 양식으로 생성
		String output = "<!doctype html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Currency Exchange</title></head>"
				+ "<body><h1>Currency Exchange</h1>";
				
		// 출력할 데이터에 입력 양식을 추가
		output += "<form action=\"exchange\" method=\"get\">"
				+ "<input type=\"hidden\" name=\"command\" value=\"calculate\">"
				+ "KRW <input type=\"text\" name=\"krw\"> to "
				+ "<select name=\"currency\">"
				+ "<option value=\"usd\">US Dollar</option>"
				+ "<option value=\"eur\">Euro</option>"
				+ "<option value=\"jpy\">Japan Yen</option>"
				+ "<option value=\"cny\">China Yuan</option></select> "
				+ "<input type=\"submit\" name=\"calc\" value=\"Calculate\"></form>";
		
		output += "</body></html>";
		
		// PrintWriter 객체의 print 메소드를 이용해 출력 스트림에 데이터를 출력
		out.print(output);
	}
}
