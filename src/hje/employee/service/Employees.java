package hje.employee.service;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	List<Employee> employees;
	
	public Employees() {
		employees = new ArrayList<Employees.Employee>();
		employees.add(new Employee(1, "엄홍준", "대리"));
		employees.add(new Employee(2, "손흥민", "과장"));
		employees.add(new Employee(3, "박지성", "부장"));
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	/**
	 * 내부 클래스 접근 제어자를 public으로 해야 화면단에서 각 속성을 읽을 수 있음
	 */
	public class Employee {
		private int id;
		private String name;
		private String rank;
		
		Employee(int id, String name, String rank) {
			this.id = id;
			this.name = name;
			this.rank = rank;
		}
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public String getRank() {
			return rank;
		}
	}
}
