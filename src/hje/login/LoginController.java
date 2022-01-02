package hje.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hje.user.service.Users;
import hje.user.service.Users.User;
import hje.util.Response;
import hje.util.ResponseUtil;

public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doPost(req, resp);
		
		System.out.println("***** 로그인 *****");
		doLoginProcess(req, resp);
	}
	
	/**
	 * 로그인한다.
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLoginProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("userId")); // Form Data로 넘어온 경우
		//System.out.println(req.getReader()); // Request Payload로 넘어온 경우
		
		// 사용자 확인
		String userId = req.getParameter("userId");
		List<User> users = new Users().getUsers();
		
		// 세션 저장
		HttpSession session = req.getSession();
		for (User user : users) {
			if (userId.equals(user.getId())) {
				session.setAttribute("userId", user.getId());
				session.setAttribute("userNm", user.getName());
			}
		}
		
		// 사용자 미존재 경우
		if (session.getAttribute("userId") == null) {
			Response result = new Response("404", "Not Found User");
			ResponseUtil.responseToJson(resp, result);
			
			return;
		}
		
		// 로그인 이전 페이지 이동
		resp.sendRedirect(req.getHeader("Referer"));
	}
}
