package org.javachina.filter.view;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter {
	private String encode = null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("filter的destroy方法被调用了");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("doFilter方法被访问了");
		//设置请求体编码
		request.setCharacterEncoding(this.encode);
		//设置响应体编码
		response.setCharacterEncoding(this.encode);
		//设置响应浏览器时编码
		response.setContentType("text/html; charset="+this.encode);
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.encode = config.getInitParameter("encoding");
		System.out.println("filter的init方法被调用了"+encode);
	}

}
