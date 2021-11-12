package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/exchange2")
public class ExchangeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// ȯ�� ������ ��� �ִ� ���� ���
	private static final double USD_RATE = 0.00084;
	private static final double EUR_RATE = 0.00072;
	private static final double JPY_RATE = 0.095;
	private static final double CNY_RATE = 0.00054;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: ExchangeServlet2.init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: ExchangeServlet2.doGet()");
		
		// Ŭ���̾�Ʈ���� ������ �������� ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
				
		// HttpServletRequest ��ü�� geParameter �޼ҵ带 �̿��� Ŭ���̾�Ʈ���� ������ ���� ����
		String command = request.getParameter("command");
		String krw = request.getParameter("krw");
		String currency = request.getParameter("currency");
		
		
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
				
		// �Է� ��Ŀ��� ���� ������ ��쿡�� ����ؼ� ���
		if (command != null && command.equals("calculate")) {
			// ȯ�� �ݾ��� ������ ����
			double amount = 0;
			
			// ȯ���� ��ȭ�� ���� ȯ�� �ݾ��� ���
			if (currency.equals("usd"))
				amount = Integer.parseInt(krw) * USD_RATE;
			else if (currency.equals("eur"))
				amount = Integer.parseInt(krw) * EUR_RATE;
			else if (currency.equals("jpy"))
				amount = Integer.parseInt(krw) * JPY_RATE;
			else if (currency.equals("cny"))
				amount = Integer.parseInt(krw) * CNY_RATE;
			
			// ����� �����Ϳ� ����� ���� �߰�
			output += String.format("<p>KRW %s = %s %.2f</p>", krw,currency.toUpperCase(), amount);
		}
		
		// ����� �����Ϳ� �Է� ����� �߰�
		output += "<form action=\"exchange2\" method=\"get\">"
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
