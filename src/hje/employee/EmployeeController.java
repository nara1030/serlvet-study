package hje.employee;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hje.employee.service.Employees;
import hje.employee.service.Employees.Employee;
import hje.util.ResponseUtil;

public class EmployeeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// super.doGet(req, resp);
		
		System.out.println("***** 직원 데이터 갱신 *****");		
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
		
		String name = (req.getParameter("empName") == null) ? "" : URLDecoder.decode(req.getParameter("empName"), "UTF-8");
		// String rank = (req.getParameter("empRank") == null) ? "" : URLDecoder.decode(req.getParameter("empRank"), "UTF-8");
		
		List<Employee> result = new ArrayList<Employee>();
		if ("".equals(name)) {
			result = employees.getEmployees();
		} else {
			for (Employee employee : employees.getEmployees()) {
				if (employee.getName().contains(name)) {
					result.add(employee);
				}
			}
		}
		
		ResponseUtil.responseToJson(resp, result);
	}
}
