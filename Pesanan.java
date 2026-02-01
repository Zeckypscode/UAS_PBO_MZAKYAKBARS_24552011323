package foodordering;
import java.io.*;
import java.util.ArrayList;

public class Pesanan {
    private String idTransaksi;
    private ArrayList<Menu> itemPesanan; // Relasi Composition
    private StatusPesanan status;

    public Pesanan(String idTransaksi) {
        this.idTransaksi = idTransaksi;
        this.itemPesanan = new ArrayList<>();
        this.status = StatusPesanan.PENDING;
    }

    public void tambahItem(Menu m) { itemPesanan.add(m); }
    public String getId() { return idTransaksi; }
    public StatusPesanan getStatus() { return status; }
    public void setStatus(StatusPesanan s) { this.status = s; }
    public ArrayList<Menu> getItemPesanan() { return itemPesanan; }

    // File Handling: Simpan Data ke TXT
    public void simpanKeFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database_pesanan.txt", true))) {
            for (Menu m : itemPesanan) {
                writer.write(idTransaksi + "," + m.getNama() + "," + m.getHarga() + "," + status);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file: " + e.getMessage());
        }
    }
}
