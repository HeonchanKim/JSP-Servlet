package ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange3")
public class ExchangeServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 환율 정보를 담고 있는 정적 상수
	private static final double USD_RATE = 0.00084;
	private static final double EUR_RATE = 0.00072;
	private static final double JPY_RATE = 0.095;
	private static final double CNY_RATE = 0.00054;
	
	// 환율 정보를 저장할 HashMap 객체
	private Map<String, Double> rateList = new HashMap<>();

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: ExchangeServlet3.init()");
		
		// 서블릿의 쓰레드가 처음 생성될 때 환율 정보를 HashMap 객체에 저장
		rateList.put("usd", USD_RATE);
		rateList.put("eur", EUR_RATE);
		rateList.put("jpy", JPY_RATE);
		rateList.put("cny", CNY_RATE);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: ExchangeServlet3.doGet()");
		
		// 클라이언트에서 전송한 데이터의 문자 인코딩 설정
		request.setCharacterEncoding("utf-8");
				
		// HttpServletRequest 객체의 geParameter 메소드를 이용해 클라이언트에서 전송한 값을 참조
		String command = request.getParameter("command");
		String krw = request.getParameter("krw");
		String currency = request.getParameter("currency");
		
		
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
				
		// 입력 양식에서 값을 전송한 경우에는 계산해서 출력
		if (command != null && command.equals("calculate")) {
			
			
			// 출력할 데이터에 계산한 값을 추가
			// -> HashMap 객체에 저장되어 있는 환율 정보를 이용해 환전 금액을 계산
			output += String.format("<p>KRW %s = %s %.2f</p>", 
					krw,currency.toUpperCase(), 
					Integer.parseInt(krw) * rateList.get(currency));
		}
		
		// 출력할 데이터에 입력 양식을 추가
		output += "<form action=\"exchange3\" method=\"get\">"
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
