package tbkelompok5;

import java.util.Scanner;

public class penjualan {
	int jumlah;
	String noresi;
	String sku;
	String nama;
	Scanner sc= new Scanner(System.in);
	
	public penjualan () {
		
	}
	
    public void setnoresi(String noresi) {
        this.noresi = noresi;
    }

	public String noresi() {
		System.out.print("No Resi\t\t : ");
		noresi = sc.nextLine();
		return noresi;
	}
	
	public void setsku(String sku) {
        this.sku = sku;
    }
	
	public void setnama(String nama) {
        this.nama = nama;
    }
	
    public void setjumlah(int jumlah) {
    	
        this.jumlah = jumlah;
    }

	public int jumlah() {
		System.out.print("Jumlah\t\t : ");
		jumlah = sc.nextInt();
		return jumlah;
	}
	
	public penjualan (String noresi, String sku, String nama,Integer jumlah) {
		this.setnoresi(noresi);
		this.setsku(sku);
        this.setnama(nama);
        this.setjumlah(jumlah);
    }

}

