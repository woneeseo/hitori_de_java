package kr.co.ezen;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class KrEncodingFilter
 */

public class KrEncodingFilter implements Filter {

    /**
     * Default constructor. 
     */
    public KrEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("요청2:::::::::::::::::::::");
		chain.doFilter(request, response); /* : 요청과 응답 코드를 구분해주는 기준점*/
		System.out.println("응답2:::::::::::::::::::::");
		// 앞으로 프로젝트 생성하면 무조건 kr인코딩 필터를 반드시 만들어줄 것
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
