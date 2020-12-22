package tbkelompok5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Transaksi {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/tugasbesarbpl";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	
	static Connection conn;
	static Statement stmt;
	static PreparedStatement statement;
	BarangData barangData;
	Barang barang;
	TransaksiData transaksiData;
	TransaksiManager transaksiManager;
	private static DateFormat tahun;
	private static Date date;
	
	
	public static void Transaksi(){
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Koneksi tidak tersambung");
		}
		
	}
		


	
	public  void penjualan()  {
		Transaksi();
		try {
			
		penjualan penj = new penjualan();
		Scanner sc = new Scanner (System.in);
		penj.noresi();
		
		Date tgl = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Tanggal Transaksi\t : "+format.format(tgl));
		String tanggal = String.valueOf(format.format(tgl));
		
		System.out.println("---Transaksi Penjualan---");
		System.out.print("SKU Barang\t : ");
		String sku_brg = sc.nextLine();
		ResultSet rs1 = null;
		String sql = "SELECT * FROM barang WHERE sku = '"+sku_brg+"'";
		stmt=conn.createStatement();
		 
	     rs1=stmt.executeQuery(sql);
		
		
		int sisabarang = 0;
		int total=0;
		int jual=0;
		while (rs1.next()) {
			String sku = rs1.getString("sku");
			String nama= rs1.getString("nama");
			Integer stock= rs1.getInt("stock");
			Integer harga_jual = rs1.getInt("harga_jual");
			System.out.println("Nama Barang\t : "+nama);
		
			if (stock>0 && penj.jumlah<stock) {
				System.out.println("Harga Barang : Rp "+harga_jual);
				penj.jumlah();
				sisabarang = Integer.valueOf(stock)-Integer.valueOf(penj.jumlah);
				total = Integer.valueOf(harga_jual)*Integer.valueOf(penj.jumlah);
				jual+=Integer.valueOf(penj.jumlah);
				System.out.println("Total Belanja : Rp "+total);
				String sql3="INSERT INTO transaksi VALUES ('"+penj.noresi+"',now(),'"+UserData.user+"')";
				String sql2="INSERT INTO transaksi_detail (sku,noresi,jumlah,harga) VALUES ('"+sku+"','"+penj.noresi+"','"+penj.jumlah+"','"+total+"')";
				String sql4="UPDATE barang SET stock='"+sisabarang+"' WHERE sku='"+sku+"'";	

				
			stmt.execute(sql3);
				do {
					stmt= conn.createStatement();
					stmt.execute(sql2);			
				}		
				while ( stmt.execute(sql4)); {
						stmt= conn.createStatement();
//					stmt.execute(sql4);
					//stmt.close();
					//result.close();	
					System.out.println("\n        TRANSAKSI BERHASIL      ");
					System.out.println("+---------------------------------------+");

					}
				
			}
				
				else {
				System.out.println("!!-----------------Maaf Stock Barang telah habis---------------------!!");
				
			}
		}
		}
		catch (Exception e) {
//			e.printStackTrace();
		}
Laman.tungguuu();
	}
}
	
	




