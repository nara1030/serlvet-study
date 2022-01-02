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
import javax.servlet.http.HttpSession;

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
		String currentUserId = (String) getSession(request).getAttribute("userId");
		if (!isLoginUrl(request)) {
			if (currentUserId == null) {
				// 인증 페이지로 이동 전 URL 기억
//				String referer = ((HttpServletRequest) request).getHeader("Referer");
//				((HttpServletRequest) request).getSession().setAttribute("prevPage", referer);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/login/login.jsp");
				requestDispatcher.forward(request, response);
				return;
			}
		}
		
		// 서블릿 실행
		chain.doFilter(request, response);
		
		// 로그인 성공 시 쿠키 세팅
		if (currentUserId != null) {
			System.out.println("SessionFilter: 쿠키 생성");
			request.setAttribute("cookie", currentUserId);
		}
	}
	
	@Override
	public void destroy() {
	}
	
	private HttpSession getSession(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		
		return req.getSession();
	}
	
	private boolean isLoginUrl(ServletRequest request) {
		String path = ((HttpServletRequest) request).getRequestURI();
		if (path.startsWith("/login.do")) {
			return true;
		}
		return false;
	}
}
