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
		// *.do 요청 시 세션 확인(/login.do 제외)
		User user = getSession(request);
		if (!isLoginUrl(request)) {
			if (user == null) {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
		}
		
		// 서블릿 실행
		chain.doFilter(request, response);
		
		// 로그인 성공 시 쿠키 세팅
		request.setAttribute("userId", user.getId());
	}
	
	@Override
	public void destroy() {
	}
	
	private User getSession(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		User user = (User) req.getSession().getAttribute("user");
		
		return user;
	}
	
	private boolean isLoginUrl(ServletRequest request) {
		String path = ((HttpServletRequest) request).getRequestURI();
		if (path.startsWith("/login.do")) {
			return true;
		}
		return false;
	}
}
