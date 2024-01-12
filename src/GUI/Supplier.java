/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author ariff
 */
public class Supplier extends javax.swing.JFrame {

    /**
     * Creates new form Supplier
     */
    public Supplier() {
        initComponents();
        load_data();
        IDOtomatis();
    }
    
    public void load_data() {
        try {
            Connection kon = koneksi.koneksiDb();
            Object header[] = {"ID SUPPLIER", "NAMA SUPPLIER", "ALAMAT SUPPLIER", "TELEPON SUPPLIER"};
            DefaultTableModel data = new DefaultTableModel(null, header);
            jTable1.setModel(data);
            String sql_data = "SELECT * FROM master_supplier";

            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            while (rs.next()) {
                String d1 = rs.getString(1);
                String d2 = rs.getString(2);
                String d3 = rs.getString(3);
                String d4 = rs.getString(4);

                String d[] = {d1, d2, d3, d4};
                data.addRow(d);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void IDOtomatis() {
        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_id = "SELECT * FROM master_supplier ORDER BY id_supplier DESC LIMIT 1";
            ResultSet rs = st.executeQuery(sql_id);
            if (rs.next()) {
                String id_supplier = rs.getString("id_supplier");
                int counter = Integer.parseInt(id_supplier.replaceAll("[^0-9]", "")) + 1;
                String AN = String.format("%05d", counter); // Format ID dengan 5 digit angka
                jTextField1.setText("A" + AN);
            } else {
                jTextField1.setText("A00001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnTampil = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(10000, 10000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Supplier.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 165));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1184, -1));

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 620, 400));

        jLabel1.setText("ID Pelanggan");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setText("Nama");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setText("Alamat");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel4.setText("Telepon");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 190, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 190, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 190, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 190, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 980, 440));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/add.png"))); // NOI18N
        btnTambah.setText("Tambah Data");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel3.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 25, 174, 52));

        btnTampil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/eye.png"))); // NOI18N
        btnTampil.setText("Tampilkan Data");
        btnTampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTampilActionPerformed(evt);
            }
        });
        jPanel3.add(btnTampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 112, 174, 52));

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/refresh.png"))); // NOI18N
        btnUpdate.setText("Update Data");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 200, 174, 52));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/bin.png"))); // NOI18N
        btnHapus.setText("Hapus Data");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        jPanel3.add(btnHapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 287, 174, 52));

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jPanel3.add(btnKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 372, 174, 52));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        // Cek jika baris telah dipilih
        if (selectedRowIndex >= 0) {
            // Aktifkan tombol Update jika baris dipilih
            btnUpdate.setEnabled(true);

            // Ambil data dari baris yang dipilih
            String id_supplier = model.getValueAt(selectedRowIndex, 0).toString();
            String nama_supplier = model.getValueAt(selectedRowIndex, 1).toString();
            String alamat_supplier = model.getValueAt(selectedRowIndex, 2).toString();
            String telepon_supplier = model.getValueAt(selectedRowIndex, 3).toString();

            // Masukkan data ke dalam JTextField
            jTextField1.setText(id_supplier);
            jTextField2.setText(nama_supplier);
            jTextField3.setText(alamat_supplier);
            jTextField4.setText(telepon_supplier);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        String id_supplier = jTextField1.getText();
        String nama_supplier = jTextField2.getText();
        String alamat_supplier = jTextField3.getText();
        String telepon_supplier = jTextField4.getText();
        
        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql = "INSERT INTO master_supplier (id_supplier, nama_supplier, alamat_supplier, telepon_supplier) VALUES ('" + id_supplier + "', '" + nama_supplier + "', '" + alamat_supplier + "', '" + telepon_supplier + "')";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
            load_data(); // Setelah menambah data, muat ulang tabel
            IDOtomatis(); // Perbarui ID otomatis
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnTampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTampilActionPerformed
        // TODO add your handling code here:
        try {
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("Supplier.jasper"), null, koneksi.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnTampilActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id_supplier = jTextField1.getText();
        String nama_supplier = jTextField2.getText();
        String alamat_supplier = jTextField3.getText();
        String telepon_supplier = jTextField4.getText();

        try {
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql = "UPDATE master_supplier SET nama_supplier='" + nama_supplier + "', alamat_supplier='" + alamat_supplier + "', telepon_supplier='" + telepon_supplier + "' WHERE id_supplier='" + id_supplier + "'";
            int rowsAffected = st.executeUpdate(sql);

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                load_data(); // Muat ulang tabel setelah pembaruan
                btnUpdate.setEnabled(false); // Matikan kembali tombol Update setelah perubahan selesai
                clearFields(); // Panggil method clearFields untuk membersihkan JTextField
            } else {
                JOptionPane.showMessageDialog(null, "Gagal mengupdate data. Pastikan ID Supplier yang dipilih benar.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

        private void clearFields() {
            jTextField1.setText(""); // Kosongkan ID Supplier
            jTextField2.setText(""); // Kosongkan Nama Supplier
            jTextField3.setText(""); // Kosongkan Alamat Supplier
            jTextField4.setText(""); // Kosongkan Telepon Supplier
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) {
            String id_supplier = model.getValueAt(selectedRowIndex, 0).toString(); // Ambil ID dari baris yang dipilih
            try {
                Connection kon = koneksi.koneksiDb();
                Statement st = kon.createStatement();
                String sql = "DELETE FROM master_supplier WHERE id_supplier='" + id_supplier + "'";
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                load_data(); // Setelah menghapus data, muat ulang tabel
                IDOtomatis(); // Perbarui ID otomatis
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus");
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // Kembali ke HalamanUtama
        HalamanUtama halamanUtama = new HalamanUtama();
        halamanUtama.setVisible(true);
        dispose(); // Menutup JFrame Pelanggan saat ini
    }//GEN-LAST:event_btnKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTampil;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
