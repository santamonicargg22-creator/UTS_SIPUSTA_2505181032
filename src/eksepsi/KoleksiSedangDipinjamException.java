/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author Lenovo Thinkpad
 */
public class KoleksiSedangDipinjamException extends PustakaException {
    public KoleksiSedangDipinjamException(String judul) {
        super("Gagal meminjam: Koleksi '" + judul + "' saat ini sedang dipinjam oleh pengguna lain.");
    }
}
