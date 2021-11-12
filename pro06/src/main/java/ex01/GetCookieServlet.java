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
		
		// HttpServletRequest ��ü�� getCookes �޼ҵ带 �̿��� ��Ű�� �����´�.
		Cookie[] cookies = request.getCookies();
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ������ �����͸� HTML ������� ����
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Get cookie</title></head><body><h1>Get Cookie</h1><ul>";
				
		// Cookie ��ü�� �迭���� ��Ű�� ���ʴ�� Ȯ��
		for (Cookie cookie : cookies)
			output += "<li>" + cookie.getName() + " = \""
				+ URLDecoder.decode(cookie.getValue(), "utf-8") + "\"</li>";

		output +="</body></html>";
		
		// ��� ��Ʈ���� �����͸� ����ϰ�, ��Ʈ���� �ݴ´�.
		out.print(output);
		out.close();
	}
}
