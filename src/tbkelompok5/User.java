package tbkelompok5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class User implements PengelolaanData {
	static Scanner scn = new Scanner(System.in);
	static Date date = new Date();
	UserData userData;
	UserManager userManager;

	
	public User() {
		try {
			
			userManager = new UserManager();
			
		} catch (NullPointerException e) {
			
			System.out.println("Masukkan Data Terlebih Dahulu");
		}
	}
	
	
	// Login
    public void login() {
    	
    	System.out.println("");
		System.out.println("-----------SIGN IN-----------");
    	
    	System.out.print("Masukkan username : ");
		String username = scn.next();
		
		System.out.print("Masukkan password : ");
		String password = scn.next();

		String dated = String.format("%tF", date);

		userData = new UserData(username, dated, password);
		
		if(userManager.login(userData) == 1) {
			System.out.println("Login berhasil");
			Laman.lamanFasilitas();
		}
		else {
			System.out.println("Masukkan Username atau Password Yang Benar");
			login();
		}
			
		
	}


	// Register data
	@Override
	public void tambah(){

		System.out.println(" ");
		System.out.println("-----------SIGN UP-----------");

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
		
		if(userManager.register(userData,confirm) == 1) {
			System.out.println("Akun berhasil dibuat");
			login();
		}

	}


	// Mengedit password akun
	@Override
	public void edit(){
		
		System.out.println(" ");
		System.out.println("-------UBAH PASSWORD-------");
		
		System.out.print("Masukkan Password Lama : ");
		String passwordLama = scn.next();

		System.out.print("Masukkan Password Baru :");
		String passwordBaru = scn.next();
		
		if(userManager.updateData(passwordLama, passwordBaru) == 1) {
			System.out.println("Password berhasil diperbarui");
			Laman.lamanFasilitas();
		} else { 
			System.out.println("Password gagal diperbarui");
			edit();
		}

		Laman.tunggu();
	}


	// Hapus akun user
	@Override
	public void hapus(){

		System.out.println(" ");
		System.out.println("--------HAPUS AKUN--------");

		System.out.print("Hapus Akun Anda ? (Y/T) :  ");
		String lanjut = scn.next();

		if (lanjut.equalsIgnoreCase("Y")) {
			if(userManager.deleteData() == 1) {
				System.out.println("Akun berhasil di hapus\n\n");
				Program.main(null);
			}
		} else{
			Laman.lamanFasilitas();
		}
		
		Laman.tunggu();
	}


	// Cari akun user
	@Override
	public void cari(){
		
		System.out.println(" ");
		System.out.println("-------CARI AKUN--------");

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
		
		Laman.tunggu();

	}


	// Lihat daftar akun user
	@Override
	public void lihat(){
		System.out.println(" ");
		System.out.println("-------LIHAT DAFTAR USER-------");

		TreeMap<String, UserData> userList = userManager.lihat();
		System.out.println("+=============================================================+");
       	System.out.println("|             DAFTAR USER SUPERMARKET XYZ                     |");
		System.out.println("+=============================================================+");
		String format1 = "|%-20s| %-15s | %-20s |\n";
		System.out.printf(format1, "Username", "Login Terakhir", "Email");
		System.out.println("+=============================================================+");
        
        for(Map.Entry list : userList.descendingMap().entrySet()){
            UserData listUser = (UserData) list.getValue();
            
        String format = "|%-20s| %-15s | %-20s |\n";
        System.out.printf(format, list.getKey(), listUser.date, listUser.email);
        System.out.println("|-------------------------------------------------------------|");
        }
		
		Laman.tunggu();

	}
}
