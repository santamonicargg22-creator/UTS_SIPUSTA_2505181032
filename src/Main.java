/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo Thinkpad
 */
import model.*;
import layanan.*;
import eksepsi.*;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Data Uji Wajib (Sesuai Naskah Ujian)
        katalog.tambahKoleksi(new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", false));
        katalog.tambahKoleksi(new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "B-04", true));
        katalog.tambahKoleksi(new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "B-04", false));
        katalog.tambahKoleksi(new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15.0, "unduh.polmed.ac.id/bd001"));
        katalog.tambahKoleksi(new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8.0, "unduh.polmed.ac.id/bd002"));

        // 1. Cetak Status Awal secara Polimorfik
        System.out.println("--- STATUS AWAL KATALOG ---");
        katalog.cetakStatus();

        // 2. Demonstrasi Pengurutan (Layak Dipinjam Dulu -> Judul)
        System.out.println("--- PENGURUTAN KATALOG (LAYAK PINJAM -> JUDUL) ---");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        // 3. Demonstrasi Peminjaman & Penanganan Eksepsi
        System.out.println("--- UJI COBA PEMINJAMAN ---");
        // Uji peminjaman koleksi yang layak
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.err.println(e.getMessage());
        }

        // Uji coba meminjam kembali koleksi yang sudah dipinjam
        try {
            katalog.pinjam("BK-001");
        } catch (PustakaException e) {
            System.err.println(e.getMessage());
        }

        // Uji coba meminjam koleksi yang tidak layak (Buku dalam perbaikan)
        try {
            katalog.pinjam("BK-002");
        } catch (PustakaException e) {
            System.err.println(e.getMessage());
        }

        System.out.println();

        // 4. Ekspor Katalog ke Berkas Teks (katalog.txt)
        System.out.println("--- EKSPOR KATALOG ---");
        EksporKatalog.simpanKeFile(katalog.getDaftarKoleksi(), "katalog.txt");
    }
}