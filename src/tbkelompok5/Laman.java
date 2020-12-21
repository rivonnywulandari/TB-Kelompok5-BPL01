package tbkelompok5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Laman {
	static Date date = new Date();
	static Scanner scn = new Scanner(System.in);
	
	public static Integer lamanUtama() {
		
		Integer pilihan = 0;
		
		System.out.println("+============================+");
		System.out.println("|      SUPERMARKET XYZ       |");
		System.out.println("+============================+");
		System.out.println("|"+date+"|");
		System.out.println("+----------------------------+");
		System.out.println("| 1. Login                   |");
		System.out.println("| 2. Register                |");
		System.out.println("+============================+");
		System.out.print("Masukkan Pilihan ('1'|'2') : ");
		pilihan = scn.nextInt();
		
		return pilihan;
	}
	
	
	public static void lamanFasilitas() {
		
		System.out.println(" ");
		System.out.println("+----------------------Fasilitas----------------------+");
		System.out.println("| 1. Fasilitas Pengelolaan User                       |");
		System.out.println("| 2. Fasilitas Pengelolaan Data Master Barang         |");
		System.out.println("| 3. Fasilitas Restock Barang                         |");
		System.out.println("| 4. Fasilitas Pengelolaan Transaksi Penjualan Barang |");
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
					
				case 5:
					
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
		
		System.out.println("+---------------------------------+");
		System.out.println("|   PENGELOLAAN RESTOCK BARANG    |");
		System.out.print("+---------------------------------+");
		
		Restock rstck = new Restock();
		
		rstck.restock();
		
	}
	public static void pengelolaanTransaksi(){
		Integer option = 0;
		Scanner scanner = new Scanner (System.in);
		Transaksi transaksi = new Transaksi();
		
		do {
			System.out.print("\n");
			System.out.println("+---------------------------------------+");
			System.out.println("|          PENGELOLAAN TRANSAKSI        |");
			System.out.println("+---------------------------------------+");
			
			option = Integer.parseInt(scanner.nextLine());
			
			switch(option) {
			case 1:
				System.out.print(">>LIHAT TRANSAKSI");
				transaksi.penjualan();
				break;
//			case 2:
//				transaksi.tambah();
//				break;
//			case 3:
//				transaksi.hapus();
//				break;
//			case 4:
//				transaksi.updateTransaksi();
//				break;
//			case 5:
//				transaksi.cari();
//				break;
			case 0:
				lamanFasilitas();
				break;
			default:
				System.out.println("Input Tidak Valid");
				
			}
			tungguuu();
		
		} while (option !=0);
	}

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
			pengelolaanTransaksi();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
