/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo Thinkpad
 */
public class BukuCetak extends Koleksi implements Terarsip {
    private final int jumlahHalaman;
    private final String nomorRak;
    private final boolean sedangDiperbaiki;

    public BukuCetak(String kodeKoleksi, String judul, int tahunTerbit, int jumlahHalaman, String nomorRak, boolean sedangDiperbaiki) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "1"; // Contoh penentuan lantai
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" | Buku Cetak - Halaman: %d | %s | Perbaikan: %s",
                jumlahHalaman, ringkasanArsip(), sedangDiperbaiki ? "Ya" : "Tidak");
    }
}