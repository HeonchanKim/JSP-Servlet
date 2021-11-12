package ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first2")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: 어떤 작업인지는 모르겠지만 아무튼 열심히 작업으 수행!
		
		// HttpServletRequest 객체에 새로운 데이터를 바인딩(binding)
		request.setAttribute("name", "Harry Potter");
		// RequestDispatcher 객체를 생성하고, forward 메소드를 이용해 second 서블릿으로 포워딩
		// RequestDispatcher dispatcher = request.getRequestDispatcher("second");
		// dispatcher.forward(request, response);
		// request 공유할 정보 등
		request.getRequestDispatcher("second2").forward(request, response);
	}
}
