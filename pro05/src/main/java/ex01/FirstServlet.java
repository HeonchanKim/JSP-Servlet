package ex01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: � �۾������� �𸣰����� �ƹ�ư ������ �۾��� ����!
		
		// RequestDispatcher ��ü�� �����ϰ�, forward �޼ҵ带 �̿��� second �������� ������
		// RequestDispatcher dispatcher = request.getRequestDispatcher("second");
		// dispatcher.forward(request, response);
		request.getRequestDispatcher("second").forward(request, response);
	}
}
