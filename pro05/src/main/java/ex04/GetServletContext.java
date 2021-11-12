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

		// GenericServlet 클래스의 getServletContext 메소드를 이용해 ServletContext 객체를 가져옴
		ServletContext context = getServletContext();
		
		// ServletContext 객체의 getAttribute 메소드를 이용해 바인딩 되어 있는 자원을 가져온다.
		List<?> members = (ArrayList<?>)context.getAttribute("members");
		
		// 클라이언트에 응답할 데이터
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
