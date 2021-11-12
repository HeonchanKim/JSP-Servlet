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

	// ServletContext 객체
	ServletContext context;
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("CALL: EncoderFilter#doFilter()");
		
		// 클라이언트에서 전송한 데이터의 인코딩 설정
		request.setCharacterEncoding("utf-8");

		// pass the request along the filter chain
		// 필터 체인에 있는 다음 필터로 요청을 전달
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("CALL: EncoderFilter#init()");
		
		// ServletContext 객체를 받아옴
		context = fConfig.getServletContext();
	}

}
