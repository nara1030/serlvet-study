package hje.user.service;

import java.util.ArrayList;
import java.util.List;

public class Users {
	List<User> users;
	
	public Users() {
		users = new ArrayList<>();
		users.add(new User("user1", "user1", "회원", true));
		users.add(new User("user2", "user2", "비회원", false));
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public class User {
		private String id;
		private String password;
		private String name;
		private boolean isEmployee;
		
		public User(String id, String password, String name, boolean isEmployee) {
			this.id = id;
			this.password = password;
			this.name = name;
			this.isEmployee = isEmployee;
		}
		
		public String getId() {
			return id;
		}
		
		public String getPassword() {
			return password;
		}
		
		public String getName() {
			return name;
		}
		
		public boolean isEmployee() {
			return isEmployee;
		}
	}
}
