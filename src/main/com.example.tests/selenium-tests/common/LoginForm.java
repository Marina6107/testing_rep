package common;

public class LoginForm {

	public String password;
	public String username;

	public LoginForm() {
	}

	public LoginForm(LoginForm oldGroup) {
		this.username = oldGroup.username;
		this.password = oldGroup.password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public LoginForm setPassword(String password) {
		this.password = password;
		return this;
	}

	public LoginForm setUsername(String username) {
		this.username = username;
		return this;
	}

	@Override
	public String toString() {
		return "Group [" + username + ": " + password + "]";
	}

}