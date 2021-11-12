package ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncoderFilter implements Filter {

	// ServletContext ��ü
	ServletContext context;
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CALL: EncoderFilter#doFilter()");
		
		// Ŭ���̾�Ʈ���� ������ �������� ���ڵ� ����
		request.setCharacterEncoding("utf-8");

		// pass the request along the filter chain
		// ���� ü�ο� �ִ� ���� ���ͷ� ��û�� ����
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CALL: EncoderFilter#init()");
		
		// ServletContext ��ü�� �޾ƿ�
		context = fConfig.getServletContext();
	}

}
