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

@WebServlet("/set-context")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ServletContext ��ü�� ���ε��� ArrayList ��ü�� ����
		List<String> members = new ArrayList<String>();
		
		members.add("Harry Potter");
		members.add("John Doe");
		members.add("Clark Kent");
		
		// GenericServlet Ŭ������ getServletContext �޼ҵ带 �̿��� ServletContext ��ü�� ������
		ServletContext context = getServletContext();
		
		// ServletContext ��ü�� setAttribute �޼ҵ带 �̿��� ArrayList ��ü�� ���ε�
		context.setAttribute("members", members);

		// Ŭ���̾�Ʈ�� ������ ������
		String output = "<!DOCTYPE html>\n<html><head>"
				+ "<title>Set ServletContext</title></head>"
				+ "<body><h1>Set ServletContext</h1><ul>";
		
		for (String item : members)
			output += "<li>" + item + "</li>";
		
		output += "</ul></body></html>";
		
		out.print(output);
		out.close();
	}
}
