package tbkelompok5;

public class UserData {
	
	String username;
	String password;
	String email;
	String date;
	static String user; 
	static String pass;
	
	public UserData() {
		 
	}
	
	public UserData(String username, String date, String email) {
		this.username = username;
		this.date = date;
		this.email = email;
	}
	
	
	public UserData(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserData(String username, String date, String email, String password) {
		this.username = username;
		this.date = date;
		this.email = email;
		this.password = password;
	}
}
