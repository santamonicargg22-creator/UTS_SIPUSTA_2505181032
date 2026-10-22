/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo Thinkpad
 */
public class Majalah extends Koleksi implements Terarsip {
    private final int edisi;
    private final String bulanTerbit;
    private final String nomorRak;
    private final boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit, int edisi, String bulanTerbit, String nomorRak, boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.edisiTerbaru = edisiTerbaru;
    }

    @Override
    public boolean isLayakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "2"; // Contoh penentuan lantai
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" | Majalah Edisi %d (%s) | %s | Terbaru: %s",
                edisi, bulanTerbit, ringkasanArsip(), edisiTerbaru ? "Ya" : "Tidak");
    }
}