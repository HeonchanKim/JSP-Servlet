package ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{
	// init 메소드: 서블릿의 실행될 때 초기화 작업 수행
	@Override
	public void init() throws ServletException {
		System.out.println("CALL: SecondServlet.init()");
	}
	
	// doGet 메소드: GET 방식의 요청을 처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CALL: SecondServlet.doGet()");
	}
	// destroy 메소드: 서블릿이 종료될 때 뒤처리 작업 수행
	@Override
	public void destroy() {
		System.out.println("CALL: SecondServlet.destroy()");
	}
}
