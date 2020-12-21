package tbkelompok5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TransaksiManager {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/tugasbesarbpl";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	 
	static Connection conn;
	static Statement stmt;
	static PreparedStatement statement;
	TransaksiData transaksiData;
	Transaksi transaksi;
	UserData userData;
	
	public TransaksiManager(){
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Koneksi tidak tersambung");
		}
		
	}
	
	public int tambahTransaksi (TransaksiData transaksiData) {
		
		Integer tambah = 0;
		
		try {
//			String sql = "INSERT INTO transaksi VALUES (?,?,?)";
//			statement = conn.prepareStatement(sql);
//			statement.setString(1, transaksiData.noresi);
//			statement.setString(2, transaksiData.date);
//			statement.setString(3, UserData.user);
//			statement.executeUpdate();
			
//			String sql = "INSERT INTO detail_transaksi(jumlah, harga, sku, noresi) SELECT ?, ?, sku, noresi FROM barang, transaksi WHERE nama = '?', noresi='?' LIMIT 1";
//			statement = conn.prepareStatement(sql);
//			statement.setInt(1, transaksiData.jumlah);
//			statement.setInt(2, transaksiData.harga);
//			statement.setString(3, transaksiData.nama);
//			statement.setString(4, transaksiData.noresi);
			
			
		String sql = "INSERT INTO transaksi SET noresi=?, date=?, username=?" ;
		statement = conn.prepareStatement(sql);
		statement.setString(1, transaksiData.noresi);
		statement.setString(2, transaksiData.date);
		statement.setString(3, UserData.user);
		statement.executeUpdate(sql);
				
		String sqll = "INSERT INTO detail_transaksi SET jumlah=?, harga=?, sku=?, noresi=?";
		statement = conn.prepareStatement(sqll);
		statement.setInt(1, transaksiData.jumlah);
		statement.setInt(2, transaksiData.harga);
		statement.setString(3, transaksiData.nama);
		statement.setString(4, transaksiData.noresi);
		statement.executeUpdate(sqll);
		
			
//			String sqll = "INSERT INTO detail_transaksi(sku, noresi, jumlah, harga) VALUES(?,?,?,?)";
//			statement = conn.prepareStatement(sqll);
//			statement.setString(1, transaksiData.sku);
//			statement.setString(2, transaksiData.noresi);
//			statement.setInt(3, transaksiData.jumlah);
//			statement.setInt(4, transaksiData.harga);
////			tambah = statement.executeUpdate();
//			
//			String cek = "SELECT * FROM barang WHERE sku=?";
//			statement = conn.prepareStatement(cek);
//			statement.setString(1,transaksiData.sku);
//			ResultSet result = statement.executeQuery();
//			
//			//	mengurangi jumlah stock
//			String stock = "UPDATE barang SET stock=? WHERE sku=?";
//			statement = conn.prepareStatement(stock);
//			statement.setInt(1, result.getInt("stock") - transaksiData.jumlah);
//			statement.setString(2, transaksiData.sku);
//			statement.executeUpdate();

			
			tambah = statement.executeUpdate();

			System.out.println("Berhasil input data");		
		} catch (SQLException e) {
			
			System.out.println("Terjadi kesalahan");
		
		}
		
		return tambah;
		
	}
	

    public ArrayList<TransaksiData> cari(String keyword)
    {
        ArrayList<TransaksiData> listTransaksi = new ArrayList<>();

        PreparedStatement statement;
        try {

            String sql = "SELECT * FROM transaksi_detail WHERE nama LIKE ?"; 
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" +keyword + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
            	TransaksiData transaksiData = new TransaksiData(
                rs.getInt("id"),
                rs.getString("sku"),
                rs.getString("noresi"),
                rs.getInt("jumlah"),
                rs.getInt("harga")
                            );
                listTransaksi.add(transaksiData);

            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan query");
        }
        return listTransaksi;
    }
	
  
    public int update(Integer id, TransaksiData transaksiData)
    {
        Integer result = 0;
        String sql = "UPDATE transaksi_detail SET sku = ?, noresi = ?, jumlah = ?, harga = ? WHERE id = ?";
        PreparedStatement statement;
        try {
        	statement = conn.prepareStatement(sql);
            statement.setString(1, transaksiData.getSku());
            statement.setString(2, transaksiData.getNoresi());
            statement.setInt(3, transaksiData.getJumlah());
            statement.setInt(4, transaksiData.getHarga());
            statement.setInt(5, id);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan query");
        }
        return result;
    }
	
	
	//	Hapus data barang
	public int hapusTransaksi(String noresi) {
		
		Integer delete = 0;
		
		try {
			
			String query = "DELETE FROM transaksi_detail WHERE noresi=?";
			statement = conn.prepareStatement(query);
			statement.setString(1, noresi);
			delete = statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Terjadi kesalahan");
		}
		
		return delete;
		
	}
	
	//Lihat data barang
	  public ArrayList<TransaksiData> getAll()
	    {
	        Statement statement;
	        ArrayList<TransaksiData> listTransaksi = new ArrayList<>();
	        try {
	            statement = conn.createStatement();
	            String sql = "SELECT * FROM transaksi_detail";

	            ResultSet result = statement.executeQuery(sql);

	    		
	            while(result.next()){
	            	TransaksiData transaksiData = new TransaksiData(
	            		result.getInt("id"),
	                    result.getString("sku"),
	                    result.getString("noresi"),
	                    result.getInt("jumlah"),
	                    result.getInt("harga")
	 
	                );
	            	listTransaksi.add(transaksiData);
	            	
	            	}
	            
	        }catch(SQLException e){
	            System.out.println("Terjadi Kesalahan. Cek Data");
	            System.out.println(e.getMessage());
	        }
	        return listTransaksi;
	    }

	   public TransaksiData get(Integer id){
	        String sql = "SELECT * FROM transaksi_detail WHERE id = ?";
	        TransaksiData transaksiData = new TransaksiData();

	        PreparedStatement statement;
	        try {
	            statement = conn.prepareStatement(sql);
	            statement.setInt(1, id);

	            ResultSet rs = statement.executeQuery();
	            rs.next();
	            transaksiData = new TransaksiData(
	                rs.getInt("id"),
	                rs.getString("sku"),
	                rs.getString("noresi"),
	                rs.getInt("jumlah"),
	                rs.getInt("harga")
	             );
	        } catch (SQLException e) {
	            System.out.println("Terjadi kesalahan query");
	        }
	        return transaksiData;
	    }

}
