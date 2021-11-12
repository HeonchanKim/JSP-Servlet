package ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");
		
		// first2 서블릿에서 바인딩한 데이터를 가져옴
		// getAttribute 메소드가 반환하는 값은 Object 자료형이므로 필요한 자료형으로 변환한 다음 대입
		String name = (String)request.getAttribute("name");
		
		// HttpServletResponse 객체의 getWriter 메소드를 통해 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();
		
		// 클라이언트에 응답할 데이터
		String output = "<!DOCTYPE html>\n<html><head>"
				+ "<title>Dispatch Forward Test</title></head>"
				+ "<body><h1>Dispatch Forward Test</h1>"
				+ "<ul><li>Name: " + name + "</li></ul>"
				+ "</body></html>";
		
		out.print(output);
		out.close();
	}
}
