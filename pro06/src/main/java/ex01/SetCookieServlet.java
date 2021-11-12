package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set-cookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키의 이름과 값
		String name = "course";
		String value = "JSP Programming";
		
		// Cookie 객체 생성
		// -> 쿠키는 HTTP 헤더에 추가되어 전송되므로, 쿠키 값에 한글이나 빈칸, 특수 문자 등이 포함된 경우에는
		//    반드시 URL 인코딩을 해야 한다.
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		
		// 쿠키의 유효 기간을 초 단위로 설정
		// -> 유효 기간을 설정하면 영구 쿠기(persistence cookie)로 저장된다.
		cookie.setMaxAge(24 * 60 * 60);
		
		// HttpServletResponse 객체 쿠키를 추가
		response.addCookie(cookie);
		
		// 디버그 메시지
		System.out.println("cookie = " + cookie);
		
		// 응답할 데이터를 HTML 양식으로 생성
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Set cookie</title></head><body><h1>Set cookie</h1>"
				+ "<ul><li>Cookie Name: " + name + "</li>"
				+ "<li>Cookie Value: " + value + "</li></ul>"
				+ "</body></html>";
		
		// 출력 스트림에 데이터를 출력하고, 스트림을 닫는다.
		out.print(output);
		out.close();
	}
}
