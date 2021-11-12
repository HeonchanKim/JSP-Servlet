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
		
		// ServletContext 객체에 바인딩할 ArrayList 객체를 생성
		List<String> members = new ArrayList<String>();
		
		members.add("Harry Potter");
		members.add("John Doe");
		members.add("Clark Kent");
		
		// GenericServlet 클래스의 getServletContext 메소드를 이용해 ServletContext 객체를 가져옴
		ServletContext context = getServletContext();
		
		// ServletContext 객체의 setAttribute 메소드를 이용해 ArrayList 객체를 바인딩
		context.setAttribute("members", members);

		// 클라이언트에 응답할 데이터
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
