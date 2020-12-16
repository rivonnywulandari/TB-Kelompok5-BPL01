package tbkelompok5;

import java.util.Scanner;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Barang implements PengelolaanData{

	static Scanner scn = new Scanner(System.in);
	BarangData barangData;
	BarangManager barangManager;
	
	public Barang() {
		try {
			
			barangManager = new BarangManager();
			
		} catch (NullPointerException e) {
			
			System.out.println("Masukkan Data Terlebih Dahulu");
		}
	}
	
	@Override
	public void tambah() {
		lihat();
		System.out.println(" ");
		System.out.println("-------TAMBAH BARANG--------");
		
		System.out.print("SKU: ");
		String sku = scn.nextLine();
		
		System.out.print("Nama Barang: ");
		String nama = scn.nextLine();
		
		System.out.print("Stock: ");
		Integer stock = Integer.parseInt(scn.nextLine());
		
		System.out.print("Harga Beli: Rp");
		Integer harga_beli = Integer.parseInt(scn.nextLine());
		
		System.out.print("Harga Jual: Rp");
		Integer harga_jual = Integer.parseInt(scn.nextLine());
		
		BarangData barangData = new BarangData(sku, nama, stock, harga_beli, harga_jual);
		
		if(barangManager.tambahBarang(barangData) > 0) {
			System.out.println("Barang berhasil ditambahkan");

		}
		
	}

	@Override
	public void edit() {
	lihat();  
		System.out.println("-------EDIT BARANG--------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan SKU yang akan diedit: ");
        String sku = scanner.nextLine();
        	        
        BarangData barangData = barangManager.get(sku);

        System.out.print("Nama Barang ["+barangData.getNama()+"]: ");
        String nama = scanner.nextLine();
        
        System.out.print("Stock ["+barangData.getStock()+"]: ");
        Integer stock = Integer.parseInt(scanner.nextLine());

        System.out.print("Harga Beli ["+barangData.getHarga_beli()+"]: Rp");
        Integer harga_beli = Integer.parseInt(scanner.nextLine());

        System.out.print("Harga Jual ["+barangData.getHarga_jual()+"]: Rp");
        Integer harga_jual = Integer.parseInt(scanner.nextLine());

        BarangData barangUpdate = new BarangData(nama, stock, harga_beli, harga_jual);

        if(barangManager.update(sku, barangUpdate) > 0){
            System.out.println("Berhasil mengupdate data");
        }else {
			System.out.println("SKU tidak ditemukan");
		}
		
	}

	@Override
	public void hapus() {
		
		System.out.println(" ");
		System.out.println("-------HAPUS BARANG--------");
		lihat();
		System.out.print("SKU : ");
		String sku = scn.next();
		
		if(barangManager.hapusBarang(sku) == 1) {
			System.out.println("Data berhasil dihapus");

		} else {
			System.out.println("SKU tidak ditemukan");

		}
		
	}

	@Override
	
	public void cari(){
		System.out.println(">>PENCARIAN BARANG");
		
		System.out.print("Masukkan Kunci (Nama): ");
		String keyword = scn.nextLine();
		
		ArrayList<BarangData> listBarang = barangManager.cari(keyword);
		System.out.println("\n");
		System.out.println("+===================================================================+");
       	System.out.println("|                 PENCARIAN BARANG SUPERMARKET XYZ                  |");
		System.out.println("+===================================================================+");
		String format1 = "|%-4s| %-20s | %-6s | %-13s |%-13s |\n";
		System.out.printf(format1, "SKU", " Nama Barang", "Stok", "Harga Beli", "  Harga Jual" );
		System.out.println("+===================================================================+");
		
		for(BarangData barangData : listBarang) {
			
		String format = "|%-4s| %-20s | %-6s | Rp%-11s | Rp%-11s|\n";
		System.out.printf(format, barangData.getSku(), barangData.getNama(), barangData.getStock(), barangData.getHarga_beli(), barangData.getHarga_jual());
		System.out.println("|-------------------------------------------------------------------|");

		}
	
	}

	@Override
	public void lihat() {

		ArrayList<BarangData> listBarang = barangManager.getAll();
			System.out.println("\n");
			System.out.println("+===================================================================+");
	       	System.out.println("|                  DATA BARANG SUPERMARKET XYZ                      |");
			System.out.println("+===================================================================+");
			String format1 = "|%-4s| %-20s | %-6s | %-13s |%-13s |\n";
			System.out.printf(format1, "SKU", " Nama Barang", "Stok", "Harga Beli", "  Harga Jual" );
			System.out.println("+===================================================================+");
		

		for(BarangData barangData : listBarang) {
	
			String format = "|%-4s| %-20s | %-6s | Rp%-11s | Rp%-11s|\n";
			System.out.printf(format, barangData.getSku(), barangData.getNama(), barangData.getStock(), barangData.getHarga_beli(), barangData.getHarga_jual());
			System.out.println("|-------------------------------------------------------------------|");
	}
		
	}

}

