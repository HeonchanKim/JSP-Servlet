package ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	// init �޼ҵ�: ������ ����� �� �ʱ�ȭ �۾� ����
	@Override
	public void init() throws ServletException {
		System.out.println("CALL: SecondServlet.init()");
	}
	
	// doGet �޼ҵ�: GET ����� ��û�� ó��
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CALL: SecondServlet.doGet()");
	}
	// destroy �޼ҵ�: ������ ����� �� ��ó�� �۾� ����
	@Override
	public void destroy() {
		System.out.println("CALL: SecondServlet.destroy()");
	}
}
