public class Main {
    public static void main(String[] args) {
        Toko mebel1 = new Toko();
        mebel1.getGudangBarang().tambahBahan(Gudang.Bahan.KAYU, 20);
        mebel1.getGudangBarang().tambahBahan(Gudang.Bahan.BAUT, 100);
        mebel1.getGudangBarang().tambahBahan(Gudang.Bahan.CAT, 15);
        mebel1.getGudangBarang().buatBarang(Toko.tipeBarang.KURSI, 3);
        mebel1.getGudangBarang().cekStockBahan();
        mebel1.getGudangBarang().buatBarang(Toko.tipeBarang.KURSI, 5);
        mebel1.getGudangBarang().buatBarang(Toko.tipeBarang.MEJA, 5);
        mebel1.getGudangBarang().tambahBahan(Gudang.Bahan.KAYU, 20);
        mebel1.getGudangBarang().tambahBahan(Gudang.Bahan.BAUT, 100);
        mebel1.getGudangBarang().tambahBahan(Gudang.Bahan.CAT, 15);
        mebel1.getGudangBarang().cekStockBahan();
        mebel1.getGudangBarang().buatBarang(Toko.tipeBarang.KURSI, 5);
        mebel1.getGudangBarang().cekIsiGudang();
        Pembeli pembeli1 = new Pembeli("hanif", Toko.tipeBarang.KURSI, 10);
        Pembeli pembeli2 = new Pembeli("muflih", Toko.tipeBarang.MEJA, 5);
        Pembeli pembeli3 = new Pembeli("fabih", Toko.tipeBarang.LEMARI, 3);
        mebel1.tambahAntrean(pembeli1);
        mebel1.tambahAntrean(pembeli2);
        mebel1.tambahAntrean(pembeli3);
        mebel1.cekIsiAntrean();
        mebel1.selesaikanAntrean();
        mebel1.cekIsiAntrean();
        mebel1.getGudangBarang().cekIsiGudang();
    }
}

