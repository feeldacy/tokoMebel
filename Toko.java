import java.util.ArrayList;
import java.util.List;

public class Toko {

    private List<Pembeli> antrean;
    private Gudang gudangBarang;
    private tipeBarang barang;
    enum tipeBarang{
        MEJA,
        KURSI,
        LEMARI
    }

    public Toko(){
        this.gudangBarang = new Gudang();
        antrean = new ArrayList<>();
    }


    public Gudang getGudangBarang(){
        return gudangBarang;
    }

    private boolean antreanPenuh(){
        if (antrean.size() < 5) {
            return true;
        } else {
            return false;
        }
    }

    public void tambahAntrean(Pembeli pembeli){
        if (antreanPenuh()) {
            antrean.add(pembeli);
            System.out.println("Berhasil menambah antrean");
        } else {
            System.out.println("Antrean Penuh");
        }
    }

    private boolean barangDiBeliTersedia(Pembeli pembeli) {
        int jumlahBarang = getGudangBarang().getIsiGudang().getOrDefault(pembeli.getBarangDiBeli(), 0);
        int totalBeli = pembeli.getJumlahBarang();
        if (jumlahBarang < totalBeli) {
            return false;
        }
        return true;
    }

    public void selesaikanAntrean() {
        if (antrean.isEmpty()){
            System.out.println("Antrean kosong");
            return;
        }

        Pembeli pembeli = antrean.get(0);
        if (barangDiBeliTersedia(pembeli)) {
            antrean.remove(pembeli);
            getGudangBarang().keluarkanBarangDariGudang(pembeli.getBarangDiBeli(), pembeli.getJumlahBarang());
        } else {
            System.out.println("\nAntrean dengan nama " + pembeli.getNama() + " tidak bisa diproses. Stock barang tidak mencukupi.");
        }
    }

    public void cekIsiAntrean(){
        if (antrean.isEmpty()) {
            System.out.println("Antrean Kosong");
            return;
        }

        System.out.println(" \nLIST ANTREAN");
        for (int i = 0; i < antrean.size(); i++) {
            Pembeli pembeli = antrean.get(i);
            System.out.println("Antrean ke " + (i+1) + ", nama: " +
                    pembeli.getNama() + ", barang di beli " +
                    pembeli.getBarangDiBeli() + ", jumlah barang di beli: " +
                    pembeli.getJumlahBarang());
        }
    }
}
