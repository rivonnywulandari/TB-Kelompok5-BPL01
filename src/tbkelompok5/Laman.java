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
		
		System.out.println("============================");
		System.out.println("     Toko BPL Kelompok 5    ");
		System.out.println("============================");
		System.out.println(date);
		System.out.println("----------------------------");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.print("Masukkan Pilihan ('1'|'2') : ");
		pilihan = scn.nextInt();
		
		return pilihan;
	}
	
	
	public static void lamanFasilitas() {
		
		System.out.println(" ");
		System.out.println("----------Fasilitas---------");
		System.out.println("1. Fasilitas Pengelolaan User");
		System.out.println("2. Fasilitas Pengelolaan Data Master Barang");
		System.out.println("3. Fasilitas Restok Barang");
		System.out.println("4. Fasilitas Pengelolaan Transaksi Penjualan Barang");
		System.out.println("5. Logout");
		System.out.print("Masukkan Pilihan ('1'|'2'|'3'|'4'|'5') : ");
		
		try {
			
			Integer pilihan = scn.nextInt();
			
			switch(pilihan) {
				case 1:
					Laman.pengelolaanUser();
					break;
					
				case 2:
//					Laman.pengelolaanBarang();
					break;
				case 3:
//					Laman.pengelolaanRestock();
					break;
				case 4:
				case 5:
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
		
		System.out.println(" ");
		System.out.println("-------Pengelolaan User-------");
		System.out.println("1. Edit Akun User (Password)");
		System.out.println("2. Hapus Akun User");
		System.out.println("3. Lihat Daftar Akun User");
		System.out.println("4. Cari Akun User");
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
	
	public static void tunggu() {
		
		InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        
        try {
        	System.out.print("\nKlik Enter Untuk Lanjut");
        	String lanjut = (bufferedReader.readLine());
			lamanFasilitas();
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
