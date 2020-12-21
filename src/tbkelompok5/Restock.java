package tbkelompok5;

import java.util.Scanner;

public class Restock {

	Scanner scn = new Scanner(System.in);
	RestockManager restockManager;
	Barang barang = new Barang();
	 
	public Restock() {
		try {
			restockManager = new RestockManager();
		} catch (NullPointerException e) {
			System.out.println("Masukkan data terlebih dahulu");
		}
	}
	
	
	//	Restock
	public void restock() {
		
		barang.lihat();  
		
		System.out.println(" ");
		System.out.println("-----------RESTOCK BARANG----------");
		
		System.out.print("SKU \t\t: ");
		String sku = scn.next().toUpperCase();
		
		System.out.print("Restock Barang \t: ");
		Integer restock = scn.nextInt();
		
		if (restock > 0 ) {	
		
			if(restockManager.restock(sku, restock) > 0) {
				System.out.println(" > Restock Barang Berhasil <");
				System.out.println("------------------------------------");
				Laman.lamanFasilitas();
			}
		
		}
		else {
			System.out.println(" > Restock Barang Tidak Berhasil <");
			System.out.println("------------------------------------");
			Laman.pengelolaanRestock();
		}
	}
}
