package tbkelompok5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Laman {
	static Date date = new Date();
	static Scanner scn = new Scanner(System.in);
	
	public static Integer lamanUtama() {
		
		Integer pilihan = 0;
		
		System.out.println("+==============================+");
		System.out.println("|        SUPERMARKET XYZ       |");
		System.out.println("+==============================+");
		System.out.println("|  "+date+"|");
		System.out.println("+------------------------------+");
		System.out.println("| 1. Login     | 2. Register   |");
		System.out.println("+==============================+");
		System.out.print("Masukkan Pilihan ('1'|'2') : ");
		pilihan = scn.nextInt();
		
		return pilihan;
	}
	
	
	public static void lamanFasilitas() {
		
		System.out.println(" ");
		System.out.println("+----------------------Fasilitas----------------------+");
		System.out.println("| 1. Fasilitas Pengelolaan User                       |");
		System.out.println("| 2. Fasilitas Pengelolaan Barang                     |");
		System.out.println("| 3. Fasilitas Restok Barang                          |");
		System.out.println("| 4. Fasilitas Pengelolaan Transaksi                  |");
		System.out.println("| 5. Fasilitas Laporan                                |");
		System.out.println("| 6. Logout                                           |");
		System.out.println("+-----------------------------------------------------+");
		System.out.print("Masukkan Pilihan ('1'|'2'|'3'|'4'|'5'|'6') : ");
		
		try {
			
			Integer pilihan = scn.nextInt();
			
			switch(pilihan) {
				case 1:
					Laman.pengelolaanUser();
					break;
					
				case 2:
					Laman.pengelolaanBarang();
					break;
				case 3:
					Laman.pengelolaanRestock();
					break;
				case 4:
					Laman.pengelolaanTransaksi();
					break;
				case 5:
					Laman.pengelolaanLaporan();
					break;
				case 6:
					System.out.println("Logout berhasil");
					System.out.println("\n");
					Program.main(null);
					break;
					
				default:
					System.out.println("Pilihan tidak tersedia");
					lamanFasilitas();
					break;
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Pilihan tidak tersedia");
			lamanFasilitas();
		}
		
	}
	
		
	public static void pengelolaanUser() {
		
		System.out.print("\n");
		System.out.println("+---------------------------------+");
		System.out.println("|        PENGELOLAAN USER         |");
		System.out.println("+---------------------------------+");
		System.out.println("| 1. Edit Akun User (Password)    |");
		System.out.println("| 2. Hapus Akun User              |");
		System.out.println("| 3. Lihat Daftar Akun User       |");
		System.out.println("| 4. Cari Akun User               |");
		System.out.println("| 5. Menu Utama                   |");
		System.out.println("+---------------------------------+");
		System.out.print("Masukkan Pilihan ('1'|'2'|'3'|'4'): ");
		
		User user = new User();
		
		try {
			Integer pilihan = scn.nextInt();
			
			switch(pilihan) {
			case 1:
				user.edit();
				break;
				
			case 2:
				user.hapus();
				break;
				
			case 3:
				user.lihat();
				break;
				
			case 4:
				user.cari();
				break;
				
			default:
				System.out.println("Pilihan tidak tersedia");
				lamanFasilitas();
				break;
			}
			
		} catch(InputMismatchException e) {
			System.out.println("Pilihan tidak tersedia");
			lamanFasilitas();
		}
		
		
	}
	
	public static void pengelolaanBarang() {
		Integer option = 0;
		Scanner scanner = new Scanner (System.in);
		Barang barang = new Barang();
		
		do {
			System.out.print("\n");
			System.out.println("+---------------------------------+");
			System.out.println("|        PENGELOLAAN BARANG       |");
			System.out.println("+---------------------------------+");
			System.out.println("|1. Lihat Barang  | 4. Edit Barang|");
			System.out.println("|2. Tambah Barang | 5. Cari Barang|");
			System.out.println("|3. Hapus Barang  | 0. Menu Utama |");
			System.out.println("+---------------------------------+");
			System.out.print("Pilihan Anda(1/2/3/4/5/0)? = ");
			option = Integer.parseInt(scanner.nextLine());
			
			switch(option) {
			case 1:
				System.out.print(">>LIHAT BARANG");
				barang.lihat();
				break;
			case 2:
				barang.tambah();
				break;
			case 3:
				barang.hapus();
				break;
			case 4:
				barang.edit();
				break;
			case 5:
				barang.cari();
				break;
			case 0:
				lamanFasilitas();
				break;
			default:
				System.out.println("Input Tidak Valid");
				
			}
			tunggu();
		
		} while (option !=0);
	}

	public static void pengelolaanRestock() {
		
		System.out.println(" ");
		System.out.println("+---------------------------------+");
		System.out.println("|   PENGELOLAAN RESTOCK BARANG    |");
		System.out.print("+---------------------------------+");
		
		Restock rstck = new Restock();
//		Barang barang = new Barang();
//		barang.lihat();
		rstck.restock();
		
	}
	
	public static void pengelolaanTransaksi(){

		Transaksi transaksi = new Transaksi();
		
		
			System.out.print("\n");
			System.out.println("+---------------------------------------+");
			System.out.println("|          PENGELOLAAN TRANSAKSI        |");
			System.out.println("+---------------------------------------+");
		
			
				
					transaksi.penjualan();
				

			
		
		
	}

	public static void pengelolaanLaporan(){
	
		}

//	public static void pengelolaanLaporan(){
//		Transaksi transaksi = new Transaksi();
//			
//			transaksi.laporan_penjualan();
//	}

	public static void tunggu() {
		
		InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        
        try {
        	System.out.print("\nKlik Enter Untuk Lanjut");
        	String lanjut = (bufferedReader.readLine());
			pengelolaanBarang();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void tungguu() {
		
		InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        
        try {
        	System.out.print("\nKlik Enter Untuk Lanjut");
        	String lanjut = (bufferedReader.readLine());
			pengelolaanUser();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void tungguuu() {
		
		InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        
        try {
        	System.out.print("\nKlik Enter Untuk Lanjut");
        	String lanjut = (bufferedReader.readLine());
			Laman.lamanFasilitas();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void tungguuuu() {
		
		InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        
        try {
        	System.out.print("\nKlik Enter Untuk Lanjut");
        	String lanjut = (bufferedReader.readLine());
			pengelolaanLaporan();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
