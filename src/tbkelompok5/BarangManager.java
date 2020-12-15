package tbkelompok5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class BarangManager {

    
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static String DB_URL = "jdbc:mysql://localhost:3306/tugasbesarbpl";
    static String USERNAME = "root";
    static String PASSWORD = "";

    static Connection connection;

    public BarangManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Terjadi Kesalahan : Driver tidak ditemukan");
        }
    }

    public int tambah(Barang barang)
    {
        Integer result = 0;
        try {
            String sql = "INSERT INTO barang (sku, nama, stock, harga_beli, harga_jual) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, barang.getSku());
            statement.setString(2, barang.getNama());
            statement.setInt(3, barang.getStock());
            statement.setInt(4, barang.getHarga_beli());
            statement.setInt(5, barang.getHarga_jual());

            result = statement.executeUpdate();
            System.out.println("Berhasil input data");
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan input data");
        }
        return result;
    }

    public ArrayList<Barang> getAll()
    {
        Statement statement;
        ArrayList<Barang> listBarang = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM barang";

            ResultSet result = statement.executeQuery(sql);

    		
            while(result.next()){
            	Barang barang = new Barang(
            		result.getString("sku"),
                    result.getString("nama"),
                    result.getInt("stock"),
                    result.getInt("harga_beli"),
                    result.getInt("harga_jual")
 
                );
            	listBarang.add(barang);
            	
            	}
            
        }catch(SQLException e){
            System.out.println("Terjadi Kesalahan. Cek Data");
            System.out.println(e.getMessage());
        }
        return listBarang;
    }

    public int update(String sku, Barang barang)
    {
        Integer result = 0;
        String sql = "UPDATE barang SET nama = ?, stock = ?, harga_beli = ?, harga_jual = ? WHERE sku = ?";
        PreparedStatement statement;
        try {
        	statement = connection.prepareStatement(sql);
            statement.setString(1, barang.getNama());
            statement.setInt(2, barang.getStock());
            statement.setInt(3, barang.getHarga_beli());
            statement.setInt(4, barang.getHarga_jual());
            statement.setString(5, sku);
            result = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan query");
        }
        return result;
    }

    public int hapus(String sku)
    {
        Integer result = 0;
        String sql = "DELETE FROM barang WHERE sku = ?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, sku);

            result= statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Barang get(String sku){
        String sql = "SELECT * FROM barang WHERE sku = ?";
        Barang barang = new Barang();

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, sku);

            ResultSet rs = statement.executeQuery();
            rs.next();
            barang = new Barang(
                rs.getString("sku"),
                rs.getString("nama"),
                rs.getInt("stock"),
                rs.getInt("harga_beli"),
                rs.getInt("harga_jual")
            );
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan query");
        }
        return barang;
    }

    public ArrayList<Barang> cari(String keyword)
    {
        //Statement statement = connection.createStatement();
        ArrayList<Barang> listBarang = new ArrayList<>();

        PreparedStatement statement;
        try {

            String sql = "SELECT * FROM barang WHERE nama LIKE ?"; 
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" +keyword + "%");

            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                Barang barang = new Barang(
                rs.getString("sku"),
                rs.getString("nama"),
                rs.getInt("stock"),
                rs.getInt("harga_beli"),
                rs.getInt("harga_jual")
                            );
                listBarang.add(barang);

            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan query");
        }
        return listBarang;
    }

	
}

