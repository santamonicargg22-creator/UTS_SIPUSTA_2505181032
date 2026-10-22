/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import java.util.Comparator;
import model.Koleksi;
/**
 *
 * @author Lenovo Thinkpad
 */
public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi k1, Koleksi k2) {
        // Mengurutkan koleksi layak pinjam lebih dulu
        Boolean layak1 = k1.isLayakDipinjam();
        Boolean layak2 = k2.isLayakDipinjam();

        int compareLayak = layak2.compareTo(layak1); // Boolean true didahulukan
        if (compareLayak != 0) {
            return compareLayak;
        }

        // Jika kelayakan sama, urutkan berdasarkan judul (A-Z)
        return k1.getJudul().compareToIgnoreCase(k2.getJudul());
    }
}