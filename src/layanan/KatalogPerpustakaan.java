/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
/**
 *
 * @author Lenovo Thinkpad
 */
public class KatalogPerpustakaan {
    private final List<Koleksi> daftarKoleksi;

    public KatalogPerpustakaan() {
        this.daftarKoleksi = new ArrayList<>();
    }

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    // Method polimorfik tanpa instanceof
    public void cetakStatus() {
        System.out.println("=== STATUS KATALOG PERPUSTAKAAN ===");
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi());
        }
        System.out.println();
    }

    // Method urut dengan Comparator kustom
    public void urut(Comparator<Koleksi> comparator) {
        daftarKoleksi.sort(comparator);
    }

    // Method pinjam yang melempar eksepsi
    public void pinjam(String kodeKoleksi) throws KoleksiSedangDipinjamException, KoleksiTidakLayakException {
        Koleksi target = null;
        for (Koleksi k : daftarKoleksi) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kodeKoleksi)) {
                target = k;
                break;
            }
        }

        if (target != null) {
            if (!target.isLayakDipinjam()) {
                throw new KoleksiTidakLayakException(target.getJudul());
            }
            if (target.isSedangDipinjam()) {
                throw new KoleksiSedangDipinjamException(target.getJudul());
            }

            target.setSedangDipinjam(true);
            System.out.println("Berhasil meminjam koleksi: " + target.getJudul());
        } else {
            System.out.println("Koleksi dengan kode " + kodeKoleksi + " tidak ditemukan.");
        }
    }
}
