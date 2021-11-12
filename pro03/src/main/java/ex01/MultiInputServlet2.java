package ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multi-input2")
public class MultiInputServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: MultiInputServlet2.init()");
	}

	public void destroy() {
		System.out.println("CALL: MultiInputServlet2.destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: MultiInputServlet2.doGet()");
		
		// Ŭ���̾�Ʈ���� ������ �������� ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest ��ü�� getParameterNames �޼ҵ带 �̿���, Ŭ���̾�Ʈ���� ������
		// �������� name �Ӽ����� ����
		// getParameterNames �޼ҵ�� Enumeration<String> ��ü�� ��ȯ�Ѵ�.
		Enumeration<String> names = request.getParameterNames();
		
		// �ݺ���(iterator)�� �̿��� names�� ���� �ϳ��� ����
		while(names.hasMoreElements()) {
			// names���� ���� �����ϰ� �ִ� ���� ����
			// nextElement ��ü�� Object �ڷ����� ��ȯ�ϹǷ� String �ڷ������� ��ȯ�� ���� ����Ѵ�.
			String name = (String)names.nextElement();
			
			// ���� name �Ӽ��� ���� 2�� �̻��� �����͸� ������ ���� HttpServletRequest ��ü��
			// getParameterValues �޼ҵ带 �̿��Ѵ�. �� �޼ҵ�� String[]�� ��ȯ�Ѵ�.
			String[] values = request.getParameterValues(name);
			
			// for-in ������ �̿��� �迭 subjects�� ������ ���������� Ȯ��
			for (String value : values)
				System.out.println("name = " + name + ", value = " + value);
		}
	}
}
