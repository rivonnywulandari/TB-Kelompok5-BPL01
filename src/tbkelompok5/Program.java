package tbkelompok5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	static Scanner scn = new Scanner(System.in);
	static User user = new User() ;

	public static void main(String[] args) {
		try {
			switch (Laman.lamanUtama()) {
			case 1:
				user.login();
				break; 
		
			case 2:
				user.tambah();
				break;
			
			default:
				System.out.println("Pilihan tidak tersedia");
				break;
				}
			
			} catch (InputMismatchException e) {
				System.out.println("Pilihan tidak tersedia");
			}	
	}

	}
