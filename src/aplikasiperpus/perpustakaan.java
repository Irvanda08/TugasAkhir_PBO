/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiperpus;

import com.mysql.cj.jdbc.ConnectionWrapper;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Connection; 
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author USER
 */
public class perpustakaan extends javax.swing.JFrame {
    
    private void updateWaktu() {
    Timer timer = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            Date currentTime = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String waktu = sdf.format(currentTime);
            waktuLabel.setText("Waktu: " + waktu); // Ganti waktuLabel dengan komponen JLabel yang ditambahkan di GUI
        }
    });
    timer.start();
}

    private void cari_data(String keyword) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Buku");
        model.addColumn("Nama Buku");
        model.addColumn("Tahun Terbit");
        model.addColumn("Penulis");
        model.addColumn("Genre");

        try {
            int no = 1;
            String sql = "SELECT * FROM buku WHERE nama_buku LIKE '%" + keyword + "%'";
            Connection connect = koneksi.getKoneksi();
            Statement st = (Statement) connect.createStatement();
            java.sql.ResultSet res = st.executeQuery(sql);

            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }
            tabelbuku.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
}
    private void kosongkan_form(){
        txtid.setEditable(true);
        txtid.setText(null);
        txtnama.setText(null);
        txtpenulis.setText(null);
        txttahun.setText(null);
        cbgenre.setSelectedItem(this);
    }
    
    private void tampilkan_data(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID Buku");
        model.addColumn("Nama Buku");
        model.addColumn("Tahun Terbit");
        model.addColumn("Penulis");
        model.addColumn("Genre");
        
        try {
            int no = 1;
            String sql = "SELECT * FROM buku";
            Connection connect = koneksi.getKoneksi();
            java.sql.Statement stm = connect.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{no++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }
            tabelbuku.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
        
    }
    
    /**
     * Creates new form perpustakaan
     */
    public perpustakaan() {
        initComponents();
        tampilkan_data();
        kosongkan_form();
        updateWaktu();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtpenulis = new javax.swing.JTextField();
        txttahun = new javax.swing.JTextField();
        cbgenre = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbuku = new javax.swing.JTable();
        btnkeluar = new javax.swing.JButton();
        btnkosongkan = new javax.swing.JButton();
        btnsimpan = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        waktuLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("aplikasi perpustakaan");
        setBackground(new java.awt.Color(153, 153, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("DATA PERPUSTAKAAN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ID buku");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 84, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nama Buku");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 121, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Penulis");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 158, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tahun Terbit");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 195, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 83, 79, -1));

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });
        getContentPane().add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 120, 190, -1));

        txtpenulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpenulisActionPerformed(evt);
            }
        });
        getContentPane().add(txtpenulis, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 157, 102, -1));

        txttahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttahunActionPerformed(evt);
            }
        });
        getContentPane().add(txttahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 194, 62, -1));

        cbgenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romansa", "Sejarah", "Humor", "Edukasi" }));
        getContentPane().add(cbgenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 231, 102, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Genre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 232, -1, -1));

        tabelbuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelbuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelbukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelbuku);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 312, 493, 158));

        btnkeluar.setForeground(new java.awt.Color(255, 0, 51));
        btnkeluar.setText("KELUAR");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 449, 93, -1));

        btnkosongkan.setText("TAMBAH");
        btnkosongkan.setActionCommand("KOSONGKAN");
        btnkosongkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkosongkanActionPerformed(evt);
            }
        });
        getContentPane().add(btnkosongkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 273, 81, -1));

        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 273, 78, -1));

        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(261, 273, 84, -1));

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 273, 84, -1));

        waktuLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        waktuLabel.setText("Time");
        getContentPane().add(waktuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtpenulisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpenulisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpenulisActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void txttahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttahunActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO buku VALUES ('" + txtid.getText()+"','"+txtnama.getText()+"','"+txttahun.getText()+"','"+txtpenulis.getText()+"','"+cbgenre.getSelectedItem()+"')";
            Connection connect = koneksi.getKoneksi();
            java.sql.PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "simpan data berhasil");
            tampilkan_data();
            kosongkan_form();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE buku set nama_buku = '" +txtnama.getText()+"',tahun_terbit='"+txttahun.getText()+"',penulis='"+txtpenulis.getText()+"',Genre='"+cbgenre.getSelectedItem()+ "' WHERE id_buku = '" + txtid.getText() + "'";
            Connection connect = koneksi.getKoneksi();
            java.sql.PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "edit data berhasil");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnkosongkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkosongkanActionPerformed
        // TODO add your handling code here:
        kosongkan_form();
        txtid.setFocusable(true);
    }//GEN-LAST:event_btnkosongkanActionPerformed

    private void tabelbukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelbukuMouseClicked
        // TODO add your handling code here:
        int baris = tabelbuku.rowAtPoint(evt.getPoint());
        String id = tabelbuku.getValueAt(baris, 1).toString();
        txtid.setText(id);
        
        String nama = tabelbuku.getValueAt(baris, 2).toString();
        txtnama.setText(nama);
        
        String tahun = tabelbuku.getValueAt(baris, 3).toString();
        txttahun.setText(tahun);
        
        String penulis = tabelbuku.getValueAt(baris, 4).toString();
        txtpenulis.setText(penulis);
        
        String genre = tabelbuku.getValueAt(baris, 5).toString();
        cbgenre.setSelectedItem(genre);
    }//GEN-LAST:event_tabelbukuMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM buku WHERE id_buku = '"+txtid.getText()+"'";
            Connection connect = koneksi.getKoneksi();
            java.sql.PreparedStatement pstm = connect.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "hapus data berhasil");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        tampilkan_data();
        kosongkan_form();
    }//GEN-LAST:event_btnhapusActionPerformed

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
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(perpustakaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new perpustakaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkosongkan;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox<String> cbgenre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelbuku;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtpenulis;
    private javax.swing.JTextField txttahun;
    private javax.swing.JLabel waktuLabel;
    // End of variables declaration//GEN-END:variables
}
