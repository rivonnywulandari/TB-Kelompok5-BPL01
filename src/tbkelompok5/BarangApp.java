package tbkelompok5;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class BarangApp {

	
	static Scanner scanner;
	static BarangManager barangManager;
	
	static Statement statement;
	
	static void utama() throws SQLException {
		Scanner sc = new Scanner (System.in);
		System.out.println("+--------------------------------------+");
		System.out.println("| Pilih menu dibawah berikut:          |");
		System.out.println("| [1] Menu Barang                      |");
		System.out.println("| [2] Menu User                        |");
		System.out.println("| [3] Re-Stock Barang                  |");
		System.out.println("| [4] Aplikasi Transaksi               |");
		System.out.println("| [5] Laporan Keuangan                 |");
		System.out.println("+--------------------------------------+");
		System.out.print  ("Masukkan Pilihan : ");
		int menu = sc.nextInt();
		if (menu == 1) {
			main();
		} 
		else if (menu ==2 ) {
			
		}
		else if (menu ==3 ) {
			
		}
		else if (menu ==4 ) {
			
		}
		else if (menu ==5 ) {
			
		}
		
	}
	
	
	public static void main() throws SQLException {
		
		
	//INSIALISASI
		scanner = new Scanner (System.in);
		barangManager = new BarangManager();
		Integer option = 0;
		
			
			do {
				System.out.print("\n");
				System.out.println("\t   MENU BARANG");
				System.out.println("+---------------------------------+");
				System.out.println("|1. Lihat Barang  | 4. Edit Barang|");
				System.out.println("|2. Tambah Barang | 5. Cari Barang|");
				System.out.println("|3. Hapus Barang  | 0. Keluar     |");
				System.out.println("+---------------------------------+");

//				System.out.println("4. Edit Barang");
//				System.out.println("5. Cari Barang");
//				System.out.println("0. Keluar");
				System.out.print("Pilihan Anda(1/2/3/4/5/0)? = ");
				option = Integer.parseInt(scanner.nextLine());
				
				switch(option) {
				case 1:
					lihatBarang();
					break;
				case 2:
					tambahBarang();
					break;
				case 3:
					hapusBarang();
					break;
				case 4:
					editBarang();
					break;
				case 5:
					cariBarang();
					break;
				case 0:
					break;
				default:
					System.out.println("Input Tidak Valid");
					
				}
				tunggu();
			
			} while (option !=0);
			

	}
	
	private static void cariBarang() throws SQLException {
		System.out.println("PENCARIAN BARANG");
		
		System.out.print("Masukkan Kunci (Nama): ");
		String keyword = scanner.nextLine(); 
		
		ArrayList<Barang> listBarang = barangManager.cari(keyword);
	        System.out.println("\n\t\tDATA BARANG SUPERMARKET XYZ");
			System.out.println("+===================================================================+");
			String format1 = "|%-4s| %-20s | %-6s | %-13s |%-13s |\n";
			System.out.printf(format1, "SKU", " Nama Barang", "Stok", "Harga Beli", "  Harga Jual" );
			System.out.println("+===================================================================+");		
		for(Barang barang : listBarang) {
//			System.out.println(barang.getSku());
//			System.out.println(barang.getNama());
//			System.out.println(barang.getStock());
//			System.out.println(barang.getHarga_beli());
//			System.out.println(barang.getHarga_jual());
			
			String format = "|%-4s| %-20s | %-6s | Rp%-11s | Rp%-11s|\n";
			System.out.printf(format, barang.getSku(), barang.getNama(), barang.getStock(), 
					barang.getHarga_beli(), barang.getHarga_jual());
			System.out.println("|-------------------------------------------------------------------|");
		
		}
	
	}

public static void editBarang() {

			lihatBarang();    
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Masukan SKU yang akan diedit: ");
	        String sku = scanner.nextLine();
	        	        
	        Barang barang = barangManager.get(sku);

            System.out.print("Nama Barang ["+barang.getNama()+"]: ");
            String nama = scanner.nextLine();
            
            System.out.print("Stock ["+barang.getStock()+"]: ");
            Integer stock = Integer.parseInt(scanner.nextLine());

            System.out.print("Harga Beli ["+barang.getHarga_beli()+"]: Rp");
            Integer harga_beli = Integer.parseInt(scanner.nextLine());

            System.out.print("Harga Jual ["+barang.getHarga_jual()+"]: Rp");
            Integer harga_jual = Integer.parseInt(scanner.nextLine());

            Barang barangUpdate = new Barang(nama, stock, harga_beli, harga_jual);

            if(barangManager.update(sku, barangUpdate) > 0){
                System.out.println("Berhasil mengupdate data");
            }


	}

	private static void hapusBarang() {
		System.out.println(">>>HAPUS BARANG");

			lihatBarang();
			
			System.out.print("SKU Barang yang akan dihapus: ");
	        String sku = scanner.nextLine();
			

			if(barangManager.hapus(sku) > 0) {
				System.out.println("Berhasil menghapus data barang");
				
			}

	}
	
	private static void tambahBarang() {
		System.out.println("TAMBAH BARANG");
		
		System.out.print("SKU: ");
		String sku = scanner.nextLine();
		
		System.out.print("Nama Barang: ");
		String nama = scanner.nextLine();
		
		System.out.print("Stock: ");
		Integer stock = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Harga Beli: Rp");
		Integer harga_beli = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Harga Jual: Rp");
		Integer harga_jual = Integer.parseInt(scanner.nextLine());
		
		Barang barang = new Barang(sku, nama, stock, harga_beli, harga_jual);
		
		if(barangManager.tambah(barang) > 0) {
			System.out.println("Berhasil menambah data barang");
		}

	}

	private static void lihatBarang() {
		System.out.println(">>LIHAT BARANG");
		ArrayList<Barang> listBarang = barangManager.getAll();
		
	       System.out.println("\n\t\tDATA BARANG SUPERMARKET XYZ");
			System.out.println("+===================================================================+");
			String format1 = "|%-4s| %-20s | %-6s | %-13s |%-13s |\n";
			System.out.printf(format1, "SKU", " Nama Barang", "Stok", "Harga Beli", "  Harga Jual" );
			System.out.println("+===================================================================+");
		

		for(Barang barang : listBarang) {
//			System.out.println("\nSKU: "+barang.getSku());			
//			System.out.println("Nama: "+barang.getNama());
//			System.out.println("Stock: "+barang.getStock());
//			System.out.println("Harga Beli: "+barang.getHarga_beli());
//			System.out.println("Harga Jual: "+barang.getHarga_jual());
//		}
//		
 	
		String format = "|%-4s| %-20s | %-6s | Rp%-11s | Rp%-11s|\n";
		System.out.printf(format, barang.getSku(), barang.getNama(), barang.getStock(), barang.getHarga_beli(), barang.getHarga_jual());
			System.out.println("|-------------------------------------------------------------------|");
	}
	
	}

	private static void tunggu() {
		System.out.println("Tekan Enter untuk Melanjutkan");
		scanner.nextLine();
		
	}


}
