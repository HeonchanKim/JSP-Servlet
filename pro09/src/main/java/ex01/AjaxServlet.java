package ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// ������ Ÿ�԰� �̵�� ����(MIME Ÿ��)�� ��� �ִ� ��
	@SuppressWarnings("serial")
	private static final Map<String, String> mediaTypes = new HashMap<String, String>() {{
		put("text", "text/plain; charset=utf-8");
		put("html", "text/html; charset=utf-8");
		put("xml", "application/xml; charset=utf-8");
		put("json", "application/json; charset=utf-8");
	}};
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// HttpServletRequest ��ü�� getParameter �޼ҵ带 �̿��� Ajax�� ���۵�
		// ��û �Ű������� �о��
		String type = (String)request.getParameter("type");
		System.out.println("type = " + type);
		
		// ������ �������� �̵�� ����(MIME Ÿ��) ����
		// ��û �Ű����� type�� ���� ������ �������� �̵�� ������ ����
		// HttpServletResponse ��ü�� getWriter �޼ҵ带 ȣ���ϱ� ���� �̵�� ������
		// �����ؾ� �Ѵ�.
		if (mediaTypes.containsKey(type))
			response.setContentType(mediaTypes.get(type));
		else
			response.setContentType("text/html; charset=utf-8");
		
		// ��� ��Ʈ�� ����
		PrintWriter out = response.getWriter();
		
		// ���� ������
		String output;
		
		// ������ �����ʹ� ��û �Ű����� type�� ���� �ٸ� ���� �ȴ�.
		if(type.equals("text"))
			output = "type = TEXT";
		else if(type.equals("xml"))
			output = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n"
				+ "<response><success>true</success><type>XML</type></response>";
		else if (type.equals("json"))
			output = "{ \"success\": true, \"type\": \"JSON\" }";
		else
			output = "<!doctype html>\n<html><head><meta charset=\"utf-8\">"
				+ "<title>Something is Wrong!</title></head><body>"
				+ "<h1>Something is Wrong!</h1></body></html>";
		
		// Ŭ���̾�Ʈ���� ����
		out.print(output);
		out.close();
		
	}
}