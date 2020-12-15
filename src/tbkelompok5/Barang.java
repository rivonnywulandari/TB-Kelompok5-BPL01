package tbkelompok5;

public class Barang {

    public String sku;
    public String nama;
    public Integer stock;
    public Integer harga_beli;
    public Integer harga_jual;

    public Barang() {

    }


    public Barang(String sku, String nama, Integer stock, Integer harga_beli, Integer harga_jual) {
        this.setSku(sku);
        this.setNama(nama);
        this.setStock(stock);
        this.setHarga_beli(harga_beli);
        this.setHarga_jual(harga_jual);
    }


	public Barang( String nama, Integer stock, Integer harga_beli, Integer harga_jual) {
        this.setNama(nama);
        this.setStock(stock);
        this.setHarga_beli(harga_beli);
        this.setHarga_jual(harga_jual);
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
