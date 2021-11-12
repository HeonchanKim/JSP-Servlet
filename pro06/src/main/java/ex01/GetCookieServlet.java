package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/get-cookie")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest 객체의 getCookes 메소드를 이용해 쿠키를 가져온다.
		Cookie[] cookies = request.getCookies();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 응답할 데이터를 HTML 양식으로 생성
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Get cookie</title></head><body><h1>Get Cookie</h1><ul>";
				
		// Cookie 객체의 배열에서 쿠키를 차례대로 확인
		for (Cookie cookie : cookies)
			output += "<li>" + cookie.getName() + " = \""
				+ URLDecoder.decode(cookie.getValue(), "utf-8") + "\"</li>";

		output +="</body></html>";
		
		// 출력 스트림에 데이터를 출력하고, 스트림을 닫는다.
		out.print(output);
		out.close();
	}
}
