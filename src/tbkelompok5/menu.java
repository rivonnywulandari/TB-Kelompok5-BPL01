package tbkelompok5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class menu {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/tugasbesarbpl";
    static String USERNAME = "root";
    static String PASSWORD = "";

    static Connection connection;

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		try {
	        Connection conn=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
	        if (conn!=null){
	            System.out.println("\t'''APLIKASI SUPERMARKET '''");
	        }
	        else {
	            System.out.println("Koneksi Gagal");
	        }
	        BarangApp.utama();
	    }
	    catch (Exception e){
	        e.printStackTrace();
	    }
	}

}
