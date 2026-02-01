/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package foodordering;

public class Makanan extends Menu {
    private String tingkatPedas;
    // Wrapper Class

    public Makanan(String id, String nama, Double harga, String tingkatPedas) {
        super(id, nama, harga);
        this.tingkatPedas = tingkatPedas;
    }

    @Override
    public String getKategori() { return "MAKANAN"; }

    @Override
    public void tampilkanDetail() {
        System.out.println("[" + getKategori() + "] " + getNama() + " | Pedas: " + tingkatPedas + " | Rp" + getHarga());
    }

    @Override
    public double hitungTotal(int jumlah) {
        return (getHarga() * jumlah) + 2000; // Biaya packing 2000
    }
}