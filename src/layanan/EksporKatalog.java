/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Koleksi;
/**
 *
 * @author Lenovo Thinkpad
 */
public class EksporKatalog {
    public static void simpanKeFile(List<Koleksi> daftarKoleksi, String namaFile) {
        // Penggunaan try-with-resources untuk penutupan stream otomatis
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            writer.write(String.format("%-10s | %-30s | %-6s | %-12s | %-10s%n",
                    "KODE", "JUDUL KOLEKSI", "TAHUN", "STATUS", "LAYAK PINJAM"));
            writer.write("----------------------------------------------------------------------------------\n");

            for (Koleksi k : daftarKoleksi) {
                writer.write(String.format("%-10s | %-30s | %-6d | %-12s | %-10s%n",
                        k.getKodeKoleksi(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.isSedangDipinjam() ? "Dipinjam" : "Tersedia",
                        k.isLayakDipinjam() ? "Layak" : "Tidak Layak"));
            }
            System.out.println("Katalog berhasil diekspor ke berkas: " + namaFile);
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }
    }
}
