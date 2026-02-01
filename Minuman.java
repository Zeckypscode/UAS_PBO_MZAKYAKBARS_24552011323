/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package foodordering;

public class Minuman extends Menu {
    private String ukuran;
    // Wrapper Class

    public Minuman(String id, String nama, Double harga, String ukuran) {
        super(id, nama, harga);
        this.ukuran = ukuran;
    }

    @Override
    public String getKategori() { return "MINUMAN"; }

    @Override
    public void tampilkanDetail() {
        System.out.println("[" + getKategori() + "] " + getNama() + " | Size: " + ukuran + " | Rp" + getHarga());
    }

    @Override
    public double hitungTotal(int jumlah) {
        return getHarga() * jumlah;
    }
}