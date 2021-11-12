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
		
		// ��Ű�� �̸��� ��
		String name = "course";
		String value = "JSP Programming";
		
		// Cookie ��ü ����
		// -> ��Ű�� HTTP ����� �߰��Ǿ� ���۵ǹǷ�, ��Ű ���� �ѱ��̳� ��ĭ, Ư�� ���� ���� ���Ե� ��쿡��
		//    �ݵ�� URL ���ڵ��� �ؾ� �Ѵ�.
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		
		// ��Ű�� ��ȿ �Ⱓ�� �� ������ ����
		// -> ��ȿ �Ⱓ�� �����ϸ� ���� ���(persistence cookie)�� ����ȴ�.
		cookie.setMaxAge(24 * 60 * 60);
		
		// HttpServletResponse ��ü ��Ű�� �߰�
		response.addCookie(cookie);
		
		// ����� �޽���
		System.out.println("cookie = " + cookie);
		
		// ������ �����͸� HTML ������� ����
		String output = "<!DOCTYPE html>\n<html><head><meta charset=\"UTF-8\">"
				+ "<title>Set cookie</title></head><body><h1>Set cookie</h1>"
				+ "<ul><li>Cookie Name: " + name + "</li>"
				+ "<li>Cookie Value: " + value + "</li></ul>"
				+ "</body></html>";
		
		// ��� ��Ʈ���� �����͸� ����ϰ�, ��Ʈ���� �ݴ´�.
		out.print(output);
		out.close();
	}
}
