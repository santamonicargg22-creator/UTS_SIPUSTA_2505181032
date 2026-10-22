/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo Thinkpad
 */
public class BerkasDigital extends Koleksi {
    private final double ukuranMB;
    private final String tautanUnduh;

    public BerkasDigital(String kodeKoleksi, String judul, int tahunTerbit, double ukuranMB, String tautanUnduh) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean isLayakDipinjam() {
        return true; // Berkas digital selalu layak dipinjam
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + String.format(" | Berkas Digital - Ukuran: %.1f MB | URL: %s", ukuranMB, tautanUnduh);
    }
}