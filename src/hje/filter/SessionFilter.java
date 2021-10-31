package hje.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import hje.user.service.Users.User;

public class SessionFilter implements Filter {
	private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 세션 확인
		User user = getSession(request);
		if (user == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
			requestDispatcher.forward(request, response);
			return;
		}
		
		// 쿠키 세팅
		request.setAttribute("userId", user.getId());
		
		// 서블릿 실행
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
	}
	
	private User getSession(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		
		return user;
	}
}
