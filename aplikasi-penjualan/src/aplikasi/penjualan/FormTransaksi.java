/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi.penjualan;

import java.sql.*;
import java.util.Calendar;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arif
 */
public class FormTransaksi extends javax.swing.JFrame {
    Connection Con;
    ResultSet RsBrg;
    ResultSet RsKons;
    Statement stm;
    double total=0;
    String tanggal;
    Boolean edit=false;
    DefaultTableModel tableModel = new DefaultTableModel(
        new Object [][] {},
        new String [] {
        "Kd Barang", "Nama Barang", "Harga Barang", "Jumlah", "Total"
    });

    /**
     * Creates new form FormTransaksi
     */
    public FormTransaksi() {
        initComponents();
        open_db();
        inisialisasi_tabel();
        aktif(false);
        setTombol(true);
        txtTglJual.setEditor(new JSpinner.DateEditor(txtTglJual, "yyyy/MM/dd"));
    }
    
    //method hitung penjualan
    private void hitung_jual() {
        double xtot,xhrg;
        int xjml;
        xhrg=Double.parseDouble(txtHrgBrg.getText());
        xjml=Integer.parseInt(txtJmlBrg.getText());
        xtot=xhrg*xjml;
        String xtotal=Double.toString(xtot);
        txtTotHrg.setText(xtotal);
        total=total+xtot;
        txtTotal.setText(Double.toString(total));
    }
    //method buka database
    private void open_db() {
        try{
            KoneksiMysql kon = new KoneksiMysql("localhost","arif","Koentj1@$","db_pbo_penjualan");
            Con = kon.getConnection();
        System.out.println("Berhasil ");
        } catch (Exception e) {
            System.out.println("Error : "+e);
        }
    }
    //methohd baca data konsumen
    private void baca_konsumen() {
        try {
            stm=Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stm.executeQuery("select kd_kons, nm_kons from konsumen");
            rs.beforeFirst();
            while(rs.next()) {
                cmbKons.addItem(rs.getString(1).trim());
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error : "+e);
        }
    }
    //method baca data barang
    private void baca_barang() {
        try {
            stm=Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stm.executeQuery("select * from barang");
            rs.beforeFirst();
            while(rs.next()) {
                cmbBrg.addItem(rs.getString(1).trim());
            }
                rs.close();
        } catch(SQLException e) {
            System.out.println("Error : "+e);
        }
    }
    //method baca barang setelah combo barang di klik
    private void detail_barang(String xkode) {
        try{
            stm=Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stm.executeQuery("select * from barang where kd_brg='"+xkode+"'");
            rs.beforeFirst();
            while(rs.next()) {
                txtNamaBrg.setText(rs.getString(2).trim());
                txtHrgBrg.setText(Double.toString((Double)rs.getDouble(4)));
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error : "+e);
        }
    }
    //method baca konsumen setelah combo konsumen di klik
    private void detail_konsumen(String xkode) {
        try{
            stm=Con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs=stm.executeQuery("select * from konsumen where kd_kons='"+xkode+"'");
            rs.beforeFirst();
            while(rs.next()) {
                txtNamaKons.setText(rs.getString(2).trim());
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error : "+e);
        }
    }
    //method set model tabel
    public void inisialisasi_tabel() {
        tblJual.setModel(tableModel);
    }
    
    //method pengkosongan isian
    //----
    private void kosong() {
        txtNoJual.setText("");
        txtNamaBrg.setText("");
        txtHrgBrg.setText("");
        txtTotal.setText("");
    }
    //---
    //method kosongkan detail jual
    private void kosong_detail() {
        txtNamaKons.setText("");
        txtHrgBrg.setText("");
        txtJmlBrg.setText("");
        txtTotHrg.setText("");
    }
    //method aktif on/off isian
    private void aktif(boolean x) {
        cmbKons.setEnabled(x);
        cmbBrg.setEnabled(x);
        txtTglJual.setEnabled(x);
        txtJmlBrg.setEditable(x);
    }
    //method set tombol on/off
    private void setTombol(boolean t) {
        btnTambah.setEnabled(t);
        btnSimpan.setEnabled(!t);
        btnBatal.setEnabled(!t);
        btnKeluar.setEnabled(t);
        btnHapusItem.setEnabled(!t);
    }
    //method buat nomor jual otomatis
    private void nomor_jual() {
        try{
            stm=Con.createStatement();
            ResultSet rs=stm.executeQuery("select no_jual from jual");
            int brs=0;
            while(rs.next()) {
                brs=rs.getRow();
            }
            if(brs==0) {
                txtNoJual.setText("1");
            } else {
                int nom=brs+1;
                txtNoJual.setText(Integer.toString(nom));
            }
            rs.close();
        } catch(SQLException e) {
            System.out.println("Error : "+e);
        }
    }
    
    //method simpan detail jual di tabel
    private void simpan_ditabel() {
        try{
            String tKode=cmbBrg.getSelectedItem().toString();
            String tNama=txtNamaBrg.getText();
            double hrg=Double.parseDouble(txtHrgBrg.getText());
            int jml=Integer.parseInt(txtJmlBrg.getText());
            double tot=Double.parseDouble(txtTotHrg.getText());
            tableModel.addRow(new Object[]{tKode,tNama,hrg,jml,tot});
            inisialisasi_tabel();
        } catch(Exception e) {
            System.out.println("Error : "+e);
        }
    }
    
    //method simpan transaksi penjualan pada table di MySql
    private void simpan_transaksi() {
        try{
            String xnojual=txtNoJual.getText();
            format_tanggal();
            String xkode=cmbKons.getSelectedItem().toString();
            String msql="insert into jual values('"+xnojual+"','"+xkode+"','"+tanggal+"')";
            stm.executeUpdate(msql);
            for(int i=0;i<tblJual.getRowCount();i++) {
                String xkd=(String)tblJual.getValueAt(i,0);
                double xhrg=(Double)tblJual.getValueAt(i,2);
                int xjml=(Integer)tblJual.getValueAt(i,3);
                String zsql="insert into djual values('"+xnojual+"','"+xkd+"',"+xhrg+","+xjml+")";
                stm.executeUpdate(zsql);
            }
        } catch(SQLException e) {
            System.out.println("Error : "+e);
        }
    }
    
    //method membuat format tanggal sesuai dengan MySQL
    private void format_tanggal() {
        String DATE_FORMAT = "yyyy-MM-dd";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int year=c1.get(Calendar.YEAR);
        int month=c1.get(Calendar.MONTH)+1;
        int day=c1.get(Calendar.DAY_OF_MONTH);
        tanggal=Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
    }
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNoJual = new javax.swing.JTextField();
        txtTglJual = new javax.swing.JSpinner();
        cmbKons = new javax.swing.JComboBox<>();
        txtNamaKons = new javax.swing.JTextField();
        cmbBrg = new javax.swing.JComboBox<>();
        txtNamaBrg = new javax.swing.JTextField();
        txtHrgBrg = new javax.swing.JTextField();
        txtJmlBrg = new javax.swing.JTextField();
        txtTotHrg = new javax.swing.JTextField();
        btnHapusItem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblJual = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("No Jual");

        jLabel2.setText("Tgl Jual");

        jLabel3.setText("Kode Konsumen");

        jLabel4.setText("Nama Konsumen");

        txtNoJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoJualActionPerformed(evt);
            }
        });

        txtTglJual.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1690523520000L), null, null, java.util.Calendar.DAY_OF_WEEK_IN_MONTH));

        cmbKons.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKonsItemStateChanged(evt);
            }
        });
        cmbKons.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cmbKonsAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        cmbKons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKonsActionPerformed(evt);
            }
        });

        cmbBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBrgActionPerformed(evt);
            }
        });

        txtHrgBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHrgBrgActionPerformed(evt);
            }
        });

        txtJmlBrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJmlBrgActionPerformed(evt);
            }
        });

        btnHapusItem.setText("Hapus Item");
        btnHapusItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusItemActionPerformed(evt);
            }
        });

        tblJual.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblJual);

        jLabel5.setText("Total");

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNamaBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNoJual)
                                            .addComponent(txtTglJual, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtHrgBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtJmlBrg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(28, 28, 28)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNamaKons, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotHrg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbKons, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapusItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtNoJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbKons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtTglJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaKons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHrgBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJmlBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotHrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaBrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnHapusItem)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal)
                    .addComponent(btnCetak)
                    .addComponent(btnKeluar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNoJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoJualActionPerformed

    private void txtHrgBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHrgBrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHrgBrgActionPerformed

    private void cmbBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBrgActionPerformed
        // TODO add your handling code here:
        detail_barang(cmbBrg.getSelectedItem().toString());
    }//GEN-LAST:event_cmbBrgActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        aktif(true);
        setTombol(false);
        baca_konsumen();
        baca_barang();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusItemActionPerformed
        // TODO add your handling code here:
        kosong();
        kosong_detail();
    }//GEN-LAST:event_btnHapusItemActionPerformed

    private void cmbKonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKonsActionPerformed
        // TODO add your handling code here:
        detail_konsumen(cmbKons.getSelectedItem().toString());
    }//GEN-LAST:event_cmbKonsActionPerformed

    private void cmbKonsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKonsItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKonsItemStateChanged

    private void cmbKonsAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmbKonsAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKonsAncestorAdded

    private void txtJmlBrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJmlBrgActionPerformed
        // TODO add your handling code here:
        hitung_jual();
    }//GEN-LAST:event_txtJmlBrgActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        simpan_ditabel();
        simpan_transaksi();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        aktif(false);
        setTombol(true);
        kosong();
        kosong_detail();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapusItem;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbBrg;
    private javax.swing.JComboBox<String> cmbKons;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblJual;
    private javax.swing.JTextField txtHrgBrg;
    private javax.swing.JTextField txtJmlBrg;
    private javax.swing.JTextField txtNamaBrg;
    private javax.swing.JTextField txtNamaKons;
    private javax.swing.JTextField txtNoJual;
    private javax.swing.JSpinner txtTglJual;
    private javax.swing.JTextField txtTotHrg;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
