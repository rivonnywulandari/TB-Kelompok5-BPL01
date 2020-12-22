package tbkelompok5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Random;

public class User implements PengelolaanData {
	static Scanner scn = new Scanner(System.in);
	static Date date = new Date();
	UserData userData;
	UserManager userManager;
	Random random = new Random();

	
	public User() {
		try {
			
			userManager = new UserManager();
			
		} catch (NullPointerException e) {
			
			System.out.println("Masukkan Data Terlebih Dahulu");
		}
	}
	
	
	
    public void login() {
    	boolean loginn = false;
    	for(int n=0; n <3; n++){
    	System.out.println("");
		System.out.println("-----------MASUK-----------");
		

    	System.out.print("Masukkan username : ");
		String username = scn.next();
		
		System.out.print("Masukkan password : ");
		String password = scn.next();

		userData = new UserData(username, password);
		
		if(userManager.login(userData) > 0) {
			System.out.println("Login berhasil");
			Laman.lamanFasilitas();
			loginn= true;
			break;

			
		}
		if (loginn == false){
			// If n== 2, 3 attemps made(n starts at 0) and we should exit
			if(n >= 2){ // can also say if(n==2)
				System.out.println("3 kesempatan telah terpakai");
				
			        
					if(userManager.resett(userData) == 1) {
						System.out.println("Password berhasil diperbarui");
						Laman.lamanFasilitas();
					} else { 
//						System.out.println("Password gagal diperbarui");
					}

					Laman.lamanUtama();	

			    }
			}
		}

    	}

	public String randomString() {
	    char[] randomm= "ABCDEFGHJKUVWXYZabcdefmnopqrwxyz0123456789".toCharArray();
		StringBuilder builder = new StringBuilder();
		String result = null;
		Integer x = 0;
		for(x=0; x<10; x++) {
			Character chara = randomm[random.nextInt(randomm.length)];
			builder.append(chara);
		}
		
		result = builder.toString();
		builder.delete(0, 10);
	    return result;
	}
	
	
	@Override
	public void tambah(){

		System.out.println(" ");
		System.out.println("-----------TAMBAH AKUN-----------");

		System.out.print("Masukkan username : ");
		String username = scn.next();

		String dt = String.format("%tF", date);

		System.out.print("Masukkan email : ");
		String email = scn.next();

		System.out.print("Masukkan password : ");
		String password = scn.next();
		
		System.out.print("Konfirmasi password : ");
		String confirm = scn.next();
		
		userData = new UserData(username, dt, email, password);
		
		if(userManager.register(userData,confirm) > 0) {
			System.out.println("Akun berhasil dibuat");
			login();
		}

	}


	
	@Override
	public void edit(){
		
		System.out.println(" ");
		System.out.println("-------UBAH PASSWORD-------");
		
		System.out.print("Masukkan Password Lama : ");
		String passlama = scn.next();

		System.out.print("Masukkan Password Baru :");
		String passbaru = scn.next();
		
		if(userManager.updateData(passlama, passbaru) > 0) {
			System.out.println("Password berhasil diperbarui");
			Laman.lamanFasilitas();
		} else { 
			System.out.println("Password gagal diperbarui");
			edit();
		}

		Laman.tungguu();
	}


	
	@Override
	public void hapus(){

		System.out.println(" ");
		System.out.println("--------HAPUS AKUN--------");

		System.out.print("Hapus Akun Anda ? (y/t) :  ");
		String lanjut = scn.next();

		if (lanjut.equalsIgnoreCase("y")) {
			if(userManager.deleteData() > 0) {
				System.out.println("Akun berhasil di hapus\n\n");
				Program.main(null);
			}
		} else{
			Laman.lamanFasilitas();
		}
		
		Laman.tungguu();
	}


	
	@Override
	public void cari(){
		
		System.out.println(" ");
		System.out.println(">>PENCARIAN AKUN");

		System.out.print("Masukkan username : ");
		String search = scn.next();

		ArrayList<UserData> searchList = userManager.search(search);
		
		System.out.println("+=============================================================+");
       	System.out.println("|             PENCARIAN USER SUPERMARKET XYZ                  |");
		System.out.println("+=============================================================+");
		String format1 = "|%-20s| %-15s | %-20s |\n";
		System.out.printf(format1, "Username", "Login Terakhir", "Email");
		System.out.println("+=============================================================+");

		
		for(UserData userData : searchList){
    	String format = "|%-20s| %-15s | %-20s |\n";
    	System.out.printf(format, userData.username, userData.date, userData.email );
    	System.out.println("|-------------------------------------------------------------|");

        }
		
		Laman.tungguu();

	}


	
	@Override
	public void lihat(){
		System.out.println(" ");
		System.out.println("-------LIHAT DAFTAR USER-------");

		ArrayList<UserData> listData = userManager.getAll();
		System.out.println("+=============================================================+");
       	System.out.println("|             DAFTAR USER SUPERMARKET XYZ                     |");
		System.out.println("+=============================================================+");
		String format1 = "|%-20s| %-15s | %-20s |\n";
		System.out.printf(format1, "Username", "Login Terakhir", "Email");
		System.out.println("+=============================================================+");
  	

	for(UserData userData : listData) {

	       String format = "|%-20s| %-15s | %-20s |\n";
	        System.out.printf(format, userData.username, userData.date, userData.email);
	        System.out.println("|-------------------------------------------------------------|");
	        }
		
		Laman.tungguu();

	}
}
