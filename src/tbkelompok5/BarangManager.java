package tbkelompok5;


import java.sql.*;
import java.util.ArrayList;

public class BarangManager {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/tugasbesarbpl";
	static final String USERNAME = "root";
	static final String PASSWORD = "";
	
	static Connection conn;
	static Statement stmt;
	static PreparedStatement statement;
	BarangData barangData;
	Barang barang;
	
	public BarangManager(){
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Koneksi tidak tersambung");
		}
		
	}
	
	public int tambahBarang (BarangData barangData) {
		
		Integer tambah = 0;
		
		try {
			String sql = "INSERT INTO barang (sku,nama,stock,harga_beli,harga_jual) VALUES (?,?,?,?,?)";
			statement = conn.prepareStatement(sql);
            statement.setString(1, barangData.getSku());
            statement.setString(2, barangData.getNama());
            statement.setInt(3, barangData.getStock());
            statement.setInt(4, barangData.getHarga_beli());
            statement.setInt(5, barangData.getHarga_jual());
			
			tambah = statement.executeUpdate();

			System.out.println("Berhasil input data");		
		} catch (SQLException e) {
			
			System.out.println("Terjadi kesalahan");
		
		}
		
		return tambah;
		
	}
	

    public ArrayList<BarangData> cari(String keyword)
    {
        ArrayList<BarangData> listBarang = new ArrayList<>();

        PreparedStatement statement;
        try {

            String sql = "SELECT * FROM barang WHERE nama LIKE ?"; 
            statement = conn.prepareStatement(sql);
            statement.setString(1, "%" +keyword + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                BarangData barangData = new BarangData(
                rs.getString("sku"),
                rs.getString("nama"),
                rs.getInt("stock"),
                rs.getInt("harga_beli"),
                rs.getInt("harga_jual")
                            );
                listBarang.add(barangData);

            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan query");
        }
        return listBarang;
    }
	
  
    public int update(String sku, BarangData barangData)
    {
        Integer result = 0;
        String sql = "UPDATE barang SET nama = ?, stock = ?, harga_beli = ?, harga_jual = ? WHERE sku = ?";
        PreparedStatement statement;
        try {
        	statement = conn.prepareStatement(sql);
            statement.setString(1, barangData.getNama());
            statement.setInt(2, barangData.getStock());
            statement.setInt(3, barangData.getHarga_beli());
            statement.setInt(4, barangData.getHarga_jual());
            statement.setString(5, sku);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan query");
        }
        return result;
    }
	
	
	//	Hapus data barang
	public int hapusBarang(String sku) {
		
		Integer delete = 0;
		
		try {
			
			String query = "DELETE FROM barang WHERE sku=?";
			statement = conn.prepareStatement(query);
			statement.setString(1, sku);
			delete = statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Terjadi kesalahan");
		}
		
		return delete;
		
	}
	
	//Lihat data barang
	  public ArrayList<BarangData> getAll()
	    {
	        Statement statement;
	        ArrayList<BarangData> listBarang = new ArrayList<>();
	        try {
	            statement = conn.createStatement();
	            String sql = "SELECT * FROM barang";

	            ResultSet result = statement.executeQuery(sql);

	    		
	            while(result.next()){
	            	BarangData barangData = new BarangData(
	            		result.getString("sku"),
	                    result.getString("nama"),
	                    result.getInt("stock"),
	                    result.getInt("harga_beli"),
	                    result.getInt("harga_jual")
	 
	                );
	            	listBarang.add(barangData);
	            	
	            	}
	            
	        }catch(SQLException e){
	            System.out.println("Terjadi Kesalahan. Cek Data");
	            System.out.println(e.getMessage());
	        }
	        return listBarang;
	    }

	   public BarangData get(String sku){
	        String sql = "SELECT * FROM barang WHERE sku = ?";
	        BarangData barangData = new BarangData();

	        PreparedStatement statement;
	        try {
	            statement = conn.prepareStatement(sql);
	            statement.setString(1, sku);

	            ResultSet rs = statement.executeQuery();
	            rs.next();
	            barangData = new BarangData(
	                rs.getString("sku"),
	                rs.getString("nama"),
	                rs.getInt("stock"),
	                rs.getInt("harga_beli"),
	                rs.getInt("harga_jual")
	            );
	        } catch (SQLException e) {
	            System.out.println("Terjadi kesalahan query");
	        }
	        return barangData;
	    }

}
