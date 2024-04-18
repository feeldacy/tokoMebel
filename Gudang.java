import java.util.HashMap;
import java.util.Map;

public class Gudang {

    enum Bahan {
        KAYU,
        BAUT,
        CAT
    }

    private Map<Toko.tipeBarang, Integer> isiGudang = new HashMap<>();
    private Map<Bahan, Integer> stokBahan = new HashMap<>();

    public Map<Toko.tipeBarang, Integer> getIsiGudang() {
        return isiGudang;
    }

    public void cekStockBahan(){
        System.out.println(" \nSTOK BAHAN");
        for (Bahan bahan : Bahan.values()){
            System.out.println("jumlah : " + bahan +
                    ", saat ini adalah : " + stokBahan.get(bahan) + " buah");
        }
    }

    public void cekIsiGudang(){
        System.out.println(" \nISI GUDANG");
        for (Toko.tipeBarang barang : Toko.tipeBarang.values()) {
            int jumlahBarang = isiGudang.getOrDefault(barang, 0);
            System.out.println("jumlah : " + barang + ", saat ini adalah : " +
                    jumlahBarang + " barang");
        }
        System.out.println("\n");
    }

    public void tambahBahan(Bahan bahan, int jumlah){
        stokBahan.put(bahan, stokBahan.getOrDefault(bahan, 0) + jumlah);
    }

    public void kurangiBahan(Bahan bahan, int jumlah){
        if (stokBahan.get(bahan) >= jumlah) {
            stokBahan.put(bahan, stokBahan.getOrDefault(bahan, 0)-jumlah);
        } else {
            System.out.println("Bahan minus.");
        }
    }

    public Boolean bahanPembuatanMencukupi(Toko.tipeBarang barang, int jumlah){
        int kayuDibutuhkan = 0, bautDibutuhkan = 0, catDibutuhkan = 0;
        switch (barang) {
            case MEJA:
                kayuDibutuhkan = 3 * jumlah;
                bautDibutuhkan = 20 * jumlah;
                catDibutuhkan = 2 * jumlah;

            case LEMARI:
                kayuDibutuhkan = 5 * jumlah;
                bautDibutuhkan = 30 * jumlah;
                catDibutuhkan = 3 * jumlah;

            case KURSI:
                kayuDibutuhkan = 2 * jumlah;
                bautDibutuhkan = 10 * jumlah;
                catDibutuhkan = 1 * jumlah;
        }

        if (stokBahan.get(Bahan.KAYU) >= kayuDibutuhkan &&
        stokBahan.get(Bahan.BAUT) >= bautDibutuhkan &&
        stokBahan.get(Bahan.CAT) >= catDibutuhkan) {
            stokBahan.put(Bahan.KAYU, stokBahan.get(Bahan.KAYU) - kayuDibutuhkan);
            stokBahan.put(Bahan.BAUT, stokBahan.get(Bahan.BAUT) - bautDibutuhkan);
            stokBahan.put(Bahan.CAT, stokBahan.get(Bahan.CAT) - catDibutuhkan);
            return true;
        } else {
            return false;
        }
    }

    public boolean slotTersedia(Toko.tipeBarang barang, int jumlah) {
        int maxKursi = 20, maxMeja = 10, maxLemari = 5;

        if (barang == Toko.tipeBarang.KURSI && isiGudang.getOrDefault(barang, 0) + jumlah <= maxKursi) {
            return true;
        } else if (barang == Toko.tipeBarang.MEJA && isiGudang.getOrDefault(barang, 0) + jumlah <= maxMeja) {
            return true;
        } else if (barang == Toko.tipeBarang.LEMARI && isiGudang.getOrDefault(barang, 0) + jumlah <= maxLemari) {
            return true;
        } else {
            return false;
        }
    }

    public void buatBarang(Toko.tipeBarang barang, int jumlah) {
        if (bahanPembuatanMencukupi(barang, jumlah)){
            masukanBarangKeGudang(barang, jumlah);
            System.out.println("\n" + jumlah + " " + barang + " berhasil di tambahkan ke gudang");
        } else {
            System.out.println("\nbahan tidak cukup");
        }
    }

    public void masukanBarangKeGudang(Toko.tipeBarang barang, int jumlah){
        if (slotTersedia(barang, jumlah)) {
            int jumlahBarang = isiGudang.getOrDefault(barang, 0);
            isiGudang.put(barang, jumlahBarang + jumlah);
        }
    }

    public void keluarkanBarangDariGudang(Toko.tipeBarang barang, int jumlah) {
        int jumlahBarang = isiGudang.getOrDefault(barang, 0);
        if (jumlahBarang >= jumlah) {
            isiGudang.put(barang, jumlahBarang - jumlah);
            System.out.println("\n" + jumlah + " " + barang + " berhasil di keluarkan dari gudang");
            System.out.println("Antrean terdepan berhasil di selesaikan");
        }
    }
}
