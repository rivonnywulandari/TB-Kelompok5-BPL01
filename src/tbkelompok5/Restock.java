package tbkelompok5;

import java.util.Scanner;

public class Restock {

	Scanner scn = new Scanner(System.in);
	RestockManager restockManager;
	
	public Restock() {
		try {
			restockManager = new RestockManager();
		} catch (NullPointerException e) {
			System.out.println("Masukkan data terlebih dahulu");
		}
	}
	
	
	//	Restock
	public void restock() {
		
		System.out.println(" ");
		System.out.println("-----------RESTOCK BARANG----------");
		
		System.out.print("SKU \t\t: ");
		String sku = scn.next().toUpperCase();
		
		System.out.print("Restock Barang \t: ");
		Integer restock = scn.nextInt();
		
		if(restockManager.restock(sku, restock) == 1) {
			System.out.println(" > Restock Barang Berhasil <");
			System.out.println("------------------------------------");
			Laman.lamanFasilitas();
		}
		
	}
}
