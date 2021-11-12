package ex04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/get-context" }, loadOnStartup = 1)
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		// GenericServlet Ŭ������ getServletContext �޼ҵ带 �̿��� ServletContext ��ü�� ������
		ServletContext context = getServletContext();
		
		// ServletContext ��ü�� getAttribute �޼ҵ带 �̿��� ���ε� �Ǿ� �ִ� �ڿ��� �����´�.
		List<?> members = (ArrayList<?>)context.getAttribute("members");
		
		// Ŭ���̾�Ʈ�� ������ ������
		String output = "<!DOCTYPE html>\n<html><head>"
				+ "<title>Get ServletContext</title></head>"
				+ "<body><h1>Get ServletContext</h1><ul>";
		
		for(int i = 0; i < members.size(); i++)
			output += "<li>" + (String)members.get(i) + "</li>";

		output += "</ul></body></html>";
		
		out.print(output);
		out.close();
	}
}
