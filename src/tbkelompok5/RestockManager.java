package tbkelompok5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RestockManager {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/tugasbesarbpl?serverTimezone=Asia/Jakarta";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	
	static Connection conn;
	static Statement stmt;
	static PreparedStatement statement;
	
	public RestockManager(){
		
		try {
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			
		} catch (SQLException | ClassNotFoundException e) {
			
			System.out.println("Koneksi tidak tersambung");
			
		}
		
	}
	
	
	//	Menambah Stock Barang
	public Integer restock(String sku, Integer restock) {
		
		Integer stock = 0;
		Restock rstck = new Restock();
			
		try {
			
			String check = "SELECT * FROM barang WHERE sku=?";
			statement = conn.prepareStatement(check);
			statement.setString(1, sku);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				
				String query = "UPDATE barang SET stock=? WHERE sku=?";
				statement = conn.prepareStatement(query);
				statement.setInt(1, result.getInt("stock") + restock);
				statement.setString(2, sku);
				stock = statement.executeUpdate();
				

			} else {
				
				System.out.println("      > SKU Barang Tidak Tersedia, Restock Barang Gagal <      ");
				System.out.println("---------------------------------------------------------------");
				rstck.restock();
				
			}
			
		} catch (SQLException e) {
			
			System.out.println("Terjadi kesalahan");
			rstck.restock();
			
		}
		
		return stock;
		
	}

}
