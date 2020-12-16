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
	
	
	//	Menambah stock barang
	public Integer restock(String sku, Integer restock) {
		
		Integer masuk = 0;
		Restock rstck = new Restock();
			
		try {
			
			//	Cek SKU barang
			String cek = "SELECT * FROM barang WHERE sku=?";
			statement = conn.prepareStatement(cek);
			statement.setString(1, sku);
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				
				String query = "UPDATE barang SET stock=? WHERE sku=?";
				statement = conn.prepareStatement(query);
				statement.setInt(1, result.getInt("stock") + restock);
				statement.setString(2, sku);
				masuk = statement.executeUpdate();
				

			} else {
				
				System.out.println("SKU Barang Tidak Tersedia, Restock Barang Gagal");
				rstck.restock();
				
			}
			
		} catch (SQLException e) {
			System.out.println("Terjadi kesalahan");
		}
		
		return masuk;
	}

}
