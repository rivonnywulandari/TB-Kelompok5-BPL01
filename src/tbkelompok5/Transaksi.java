package tbkelompok5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
	
	public Transaksi(){
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Koneksi tidak tersambung");
		}
		
	}
		
	public static void laporan_penjualan () throws SQLException {
		
		boolean lap = true;
		Scanner in = new Scanner (System.in);
		System.out.println("\n+================================================+");
		System.out.println("   LAPORAN PENJUALAN SUPERMARKET SI");
		System.out.println("+=================================================+");
		System.out.print  ("Masukkan Tanggal [dd-mm-yyyy] : ");
		String tgl = in.nextLine();
		stmt = conn.createStatement();
		String sql = "SELECT transaksi.tanggal,transaksi_detail.noresi,"
				+ "transaksi_detail.sku,barang.nama,"
				+ "transaksi_detail.jumlah FROM barang "
				+ "INNER JOIN transaksi_detail "
				+ "ON barang.sku=transaksi_detail.sku "
				+ "JOIN transaksi "
				+ "ON transaksi_detail.noresi=transaksi.noresi WHERE tanggal ='"+tgl+"'";
		ResultSet result = stmt.executeQuery(sql);
		
		while (result.next()) {
			String noresi = result.getString("noresi");
			String sku = result.getString("sku");
			String nama_brg = result.getString("nama");
			Integer jumlah = result.getInt("jumlah");
			
			System.out.println("+----------------------------------------------------------+");
			System.out.println("No.Resi        : "+noresi);
			System.out.println("SKU Barang     : "+sku);
			System.out.println("Nama Barang    : "+nama_brg);
			System.out.println("Jumlah Terjual : "+jumlah);
			System.out.println("+----------------------------------------------------------+");
		} 
		System.out.println();
	}
	
	public void penjualan()  
	{
		try {
			
		penjualan penj = new penjualan();
		Scanner sc = new Scanner (System.in);
		System.out.println("\n+==========================================================+");
		System.out.println("\t\tTRANSAKSI PENJUALAN SUPERMARKET SI");
		System.out.println("+==========================================================+");
		penj.noresi();
		 
		Date tgl = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Tanggal Transaksi\t : "+format.format(tgl));
		String tanggal = String.valueOf(format.format(tgl));
		
		
		System.out.println("---Transaksi Penjualan---");
		System.out.print("SKU Barang\t : ");
		String sku_brg = sc.nextLine();
		
		String sql = "SELECT * FROM barang WHERE sku = '"+sku_brg+"'";
		stmt=conn.createStatement();
		ResultSet result=stmt.executeQuery(sql);
		
		int sisabarang = 0;
		int total=0;
		int jual=0;
		while (result.next()) {
			String sku = result.getString("sku");
			String nama_brg = result.getString("nama");
			Integer stok_brg = result.getInt("stock");
			Integer harga_jual = result.getInt("harga_jual");
			System.out.println("Nama Barang\t : "+nama_brg);
			
			if (stok_brg>0) {
				System.out.println("Harga Barang : Rp "+harga_jual);
				penj.jumlah();
				sisabarang = Integer.valueOf(stok_brg)-Integer.valueOf(penj.jml);
				total = Integer.valueOf(harga_jual)*Integer.valueOf(penj.jml);
				jual+=Integer.valueOf(penj.jml);
				System.out.println("Total Belanja : Rp "+total);
//				String sql2="INSERT INTO transaksi_detail (sku,noresi,jumlah,harga) VALUES ('"+sku+"','"+penj.noresi+"','"+penj.jml+"','"+total+"')";
				String sql3="INSERT INTO transaksi VALUES ('"+penj.noresi+"', now() ,'"+UserData.user+"')";
				String sql4="UPDATE barang SET stock='"+sisabarang+"' WHERE sku='"+sku+"'";
			stmt.execute(sql3);
				try {
					String sql2="INSERT INTO transaksi_detail (sku,noresi,jumlah,harga) VALUES ('"+sku+"','"+penj.noresi+"','"+penj.jml+"','"+total+"')";

					stmt.execute(sql2);
					
					stmt.execute(sql4);
					stmt.close();
					result.close();
					System.out.println("\n        TRANSAKSI BERHASIL      ");
					System.out.println("+---------------------------------------+");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			} else {
				System.out.println("__________________________________________________________________");
				System.out.println("!!-----------------Stock Barang telah habis---------------------!!");
				System.out.println("Silahkan melakukan re-stock barang ["+nama_brg+"] dahulu");
				System.out.println("------------------------------------------------------------------");
				Laman.lamanFasilitas();
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public static void tbstock() throws SQLException{
//		conn();
		Scanner sc = new Scanner (System.in);
		System.out.println("\nKet : Input SKU barang yang ingin diedit");
		System.out.println("<< RE-STOCK BARANG >>");
		System.out.println("___________________________");
		System.out.print  ("SKU Barang\t: ");
		int sku = sc.nextInt();
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM barang WHERE sku = '"+sku+"'";
			ResultSet result = stmt.executeQuery(sql);
			if (result.next()) {
				String id = result.getString(sku);
				Integer stok_db = result.getInt("stok");
				System.out.print("Penambahan\t : ");
				Integer tambah = sc.nextInt();
				int newstock = Integer.valueOf(stok_db)+Integer.valueOf(tambah);
				String sql2 = "UPDATE barang SET stock = '"+newstock+"' WHERE sku='"+sku+"'";
				stmt.execute(sql2);
				stmt.close();
			}
			System.out.println("___________________________");
			System.out.println("[Barang BERHASIL di TAMBAH !]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

