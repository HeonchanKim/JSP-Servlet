package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/multi-input")
public class MultiInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("CALL: MultiInputServlet.init()");
	}

	public void destroy() {
		System.out.println("CALL: MultiInputServlet.destroy()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CALL: MultiInputServlet.doGet()");
		
		// Ŭ���̾�Ʈ���� ������ �������� ���� ���ڵ� ����
		request.setCharacterEncoding("utf-8");
		
		// ���� name �Ӽ��� ���� 2�� �̻��� �����͸� ������ ���� HttpServletRequest ��ü��
		// getParameterValues �޼ҵ带 �̿��Ѵ�. �� �޼ҵ�� String[]�� ��ȯ�Ѵ�.
		String[] subjects = request.getParameterValues("subject");
		
		// for-in ������ �̿��� �迭 subjects�� ������ ���������� Ȯ��
		for (String str : subjects)
			System.out.println("Subject: " + str);
	}

}
