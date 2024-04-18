public class Pembeli {
    private String nama;
    private Toko.tipeBarang barangDiBeli;
    private int jumlahBarang;

    public Pembeli(String nama, Toko.tipeBarang barangDiBeli, int jumlahBarang){
        this.nama = nama;
        this.barangDiBeli = barangDiBeli;
        this.jumlahBarang = jumlahBarang;
    }
    public String getNama(){
        return nama;
    }

    public Toko.tipeBarang getBarangDiBeli(){
        return barangDiBeli;
    }

    public int getJumlahBarang(){
        return jumlahBarang;
    }
}
