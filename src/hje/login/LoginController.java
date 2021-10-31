package hje.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hje.user.service.Users;
import hje.user.service.Users.User;

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
		System.out.println(req.getParameter("userId"));
		
		// 사용자 확인
		Users usr = new Users();
		List<User> users = usr.getUsers();
		
		
		// 세션 저장
		
	}
}
