package hje.employee;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hje.employee.service.Employees;
import hje.employee.service.Employees.Employee;

public class EmployeeInit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		
		System.out.println("***** 직원 관리 화면 로드 *****");		
		doGetProcess(req, resp);
	}
	
	/**
	 * doGet 메소드의 비즈니스 로직을 처리한다.
	 * 
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doGetProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employees employees = new Employees();
		req.setAttribute("employees", employees.getEmployees());
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/employee/employee.jsp");
		requestDispatcher.forward(req, resp);
	}
}
