/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foodordering;

public abstract class Menu implements OperasiData {
    private String idMenu;
    private String nama;
    private Double harga; // Wrapper Class

    public Menu(String idMenu, String nama, Double harga) {
        this.idMenu = idMenu;
        this.nama = nama;
        this.harga = harga;
    }

    // Abstract Method
    public abstract String getKategori();

    // Enkapsulasi (Getter/Setter)
    public String getIdMenu() { return idMenu; }
    public String getNama() { return nama; }
    public Double getHarga() { return harga; }
    public void setHarga(Double harga) { this.harga = harga; }
}