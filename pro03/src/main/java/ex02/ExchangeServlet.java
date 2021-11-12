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
		
		// ������ �������� MIME Ÿ�� ����
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse ��ü�� getWriter �޼ҵ带 ���� ��� ��Ʈ���� PrintWriter ��ü�� �޾ƿ�
		// PrintWriter Ŭ������ java.io ��Ű���� ���ǵǾ� �ִ�.
		PrintWriter out = response.getWriter();
		
		// Ŭ���̾�Ʈ�� ����� �����͸� HTML ������� ����
		String output = "<!doctype html>\n"
				+ "<html><head><meta charset=\"utf-8\">"
				+ "<title>Currency Exchange</title></head>"
				+ "<body><h1>Currency Exchange</h1>";
				
		// ����� �����Ϳ� �Է� ����� �߰�
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
		
		// PrintWriter ��ü�� print �޼ҵ带 �̿��� ��� ��Ʈ���� �����͸� ���
		out.print(output);
	}
}
