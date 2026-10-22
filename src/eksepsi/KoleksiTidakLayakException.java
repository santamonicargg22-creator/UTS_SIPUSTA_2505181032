/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eksepsi;

/**
 *
 * @author Lenovo Thinkpad
 */
public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Gagal meminjam: Koleksi '" + judul + "' saat ini tidak layak untuk dipinjam (sedang dalam perbaikan atau edisi terbaru).");
    }
}
