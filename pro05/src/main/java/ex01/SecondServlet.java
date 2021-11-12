package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할 데이터의 MIME 타입 설정
		response.setContentType("text/html; charset=utf-8");
		
		// HttpServletResponse 객체의 getWriter 메소드를 통해 PrintWriter 객체를 받아옴
		PrintWriter out = response.getWriter();
		
		// 클라이언트에 응답할 데이터
		String output = "<!DOCTYPE html>\n<html><head>"
				+ "<title>Dispatch Forward Test</title></head>"
				+ "<body><h1>Dispatch Forward Test</h1></body></html>";
		
		out.print(output);
		out.close();
	}
}
