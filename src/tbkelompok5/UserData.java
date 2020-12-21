package tbkelompok5;

public class UserData {
	
	String username;
	String password;
	String email;
	String date;
	static String user; //va
	static String pass;
	
	public UserData() {
		 
	}
	
	public UserData(String username, String date, String password) {
		this.username = username;
		this.date = date;
		this.password = password;
	}
	
	public UserData(String username, String date, String email, String password) {
		this.username = username;
		this.date = date;
		this.email = email;
		this.password = password;
	}
}
