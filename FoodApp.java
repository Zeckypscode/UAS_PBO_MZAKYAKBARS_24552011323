package foodordering;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FoodApp extends JFrame {
    private static List<Pesanan> daftarPesanan = new ArrayList<>();
    private DefaultTableModel tableModel;
    private JTable table;

    public FoodApp() {
        setTitle("Aplikasi Kasir Food OOP");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Sistem Manajemen Pesanan", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 18));
        add(header, BorderLayout.NORTH);

        // Tabel untuk menampilkan data
        String[] columns = {"ID Transaksi", "Item", "Harga", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel Tombol
        JPanel panelTombol = new JPanel();
        JButton btnTambah = new JButton("Tambah Pesanan");
        JButton btnUbah = new JButton("Ubah Harga");
        JButton btnRefresh = new JButton("Refresh Tabel");

        panelTombol.add(btnTambah);
        panelTombol.add(btnUbah);
        panelTombol.add(btnRefresh);
        add(panelTombol, BorderLayout.SOUTH);

        // Event Listeners
        btnTambah.addActionListener(e -> tambahDataGUI());
        btnUbah.addActionListener(e -> ubahHargaGUI());
        btnRefresh.addActionListener(e -> refreshTable());
    }

    private void tambahDataGUI() {
        try {
            String id = JOptionPane.showInputDialog("Masukkan ID Transaksi:");
            String nama = JOptionPane.showInputDialog("Nama Makanan:");
            double harga = Double.parseDouble(JOptionPane.showInputDialog("Harga:"));

            Pesanan p = new Pesanan(id);
            p.tambahItem(new Makanan(id + "-M", nama, harga, "Sedang"));
            p.simpanKeFile();
            daftarPesanan.add(p);

            refreshTable();
            JOptionPane.showMessageDialog(this, "Pesanan Berhasil Disimpan!");
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input tidak valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ubahHargaGUI() {
        String id = JOptionPane.showInputDialog("Masukkan ID Transaksi yang akan diubah:");
        for (Pesanan p : daftarPesanan) {
            if (p.getId().equalsIgnoreCase(id)) {
                String hargaBaru = JOptionPane.showInputDialog("Masukkan Harga Baru:");
                p.getItemPesanan().get(0).setHarga(Double.valueOf(hargaBaru));
                refreshTable();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "ID tidak ditemukan.");
    }

    private void refreshTable() {
        tableModel.setRowCount(0); // Bersihkan tabel
        for (Pesanan p : daftarPesanan) {
            Menu m = p.getItemPesanan().get(0);
            Object[] row = {p.getId(), m.getNama(), m.getHarga(), p.getStatus()};
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FoodApp().setVisible(true);
        });
    }
}