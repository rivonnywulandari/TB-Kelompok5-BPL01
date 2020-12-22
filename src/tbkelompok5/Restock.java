package tbkelompok5;

import java.util.Scanner;

public class Restock {

	Scanner scn = new Scanner(System.in);
	RestockManager restockManager;
	
	public Restock() {
		try {
			
			restockManager = new RestockManager();
			
		} catch (NullPointerException e) {
			
			System.out.println("Masukkan Data Terlebih Dahulu");
			
		}
	}
	
	
	//	Restock
	public void restock() {
		
		Barang barang = new Barang();
		barang.lihat();
		
		System.out.println(" ");
		System.out.println("-------------------------RESTOCK BARANG------------------------");
		
		System.out.print("Masukkan SKU Yang Akan Di Restock : ");
		String sku = scn.nextLine();
		
		System.out.print("Masukkan Jumlah Restock Barang    : ");
		Integer restock = scn.nextInt();
		
		if(restock > 0) {
			
			if(restockManager.restock(sku, restock) > 0) {
			
				System.out.println("                  >  Restock Barang Berhasil  <                ");
				System.out.println("---------------------------------------------------------------");
				Laman.lamanFasilitas();
			
			}
			
		}
		
		else {
			
			System.out.println("                > Restock Barang Tidak Berhasil <              ");
			System.out.println("---------------------------------------------------------------");
			Laman.lamanFasilitas();
		}
		
	}
}
