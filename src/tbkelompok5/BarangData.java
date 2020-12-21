package tbkelompok5;

public class BarangData {

	String sku;
	String nama;
	int stock;
	int harga_beli;
	int harga_jual;
	
	public BarangData() {
		
	} 
	
	public BarangData(String sku, String nama, int harga_beli, int harga_jual) {
		this.sku=sku;
		this.nama=nama;
		this.harga_beli=harga_beli;
		this.harga_jual=harga_jual;
	}
	
	public BarangData(String sku, String nama, int stock, int harga_beli, int harga_jual) {
		this.sku=sku;
		this.nama=nama;
		this.stock=stock;
		this.harga_beli=harga_beli;
		this.harga_jual=harga_jual;
	}
	
	public BarangData(String nama, int stock, int harga_beli, int harga_jual) {
		this.nama=nama;
		this.stock=stock;
		this.harga_beli=harga_beli;
		this.harga_jual=harga_jual;
	}

	public Integer getHarga_jual() {
		return harga_jual;
	}



	public void setHarga_jual(Integer harga_jual) {
		this.harga_jual = harga_jual;
	}



	public Integer getHarga_beli() {
		return harga_beli;
	}



	public void setHarga_beli(Integer harga_beli) {
		this.harga_beli = harga_beli;
	}



	public String getNama() {
		return nama;
	}



	public void setNama(String nama) {
		this.nama = nama;
	}



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}



	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
