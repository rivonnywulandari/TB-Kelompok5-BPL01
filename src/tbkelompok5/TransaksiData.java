package tbkelompok5;

public class TransaksiData {

	int id;
	String sku;
	String noresi;
	int jumlah;
	int harga;
//	int stock;
	int harga_beli;
	int harga_jual;
	String date;
	String nama;
	String username;
	static Integer stock;
	
	public TransaksiData() {
		
	}
	
	public TransaksiData(int id, String sku, int jumlah, int harga) {
		this.id=id;
		this.sku=sku; 
		this.jumlah=jumlah;
		this.harga=harga;
	}
	
	public TransaksiData(int id, String sku, String noresi, int jumlah, int harga) {
		this.id=id;
		this.sku=sku;
		this.noresi=noresi;
		this.jumlah=jumlah;
		this.harga=harga;
	}
	
	public TransaksiData(String sku, String noresi, int jumlah, int harga) {
		this.sku=sku;
		this.noresi=noresi;
		this.jumlah=jumlah;
		this.harga=harga;
	}
	
	public TransaksiData(String noresi, String username, String date, String nama, Integer jumlah) {
		this.noresi=noresi;
		this.username=username;
		this.date=date;
		this.nama=nama;
		this.jumlah=jumlah;
//		this.total=total;
	}
	
	public TransaksiData(String noresi, String nama, Integer jumlah) {
		this.noresi=noresi;
		this.nama=nama;
		this.jumlah=jumlah;
	}

	public Integer getHarga() {
//		harga = harga_beli * harga_jual;
		return harga;
	}



	public void setHarga(Integer harga) {
		this.harga = harga;
	}



	public Integer getJumlah() {
		return jumlah;
	}



	public void setJumlah(Integer jumlah) {
		this.jumlah = jumlah;
//		stock = stock-jumlah;
	}



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}



	public Integer getId() {
		return id;
	}


 
	public void setId(Integer id) {
		this.id = id;
	}



	public String getNoresi() {
		return noresi;
	}



	public void setNoresi(String noresi) {
		this.noresi = noresi;
	}

}
