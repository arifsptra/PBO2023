package arif.saputra.penjualan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class FormDataBarang {
    Driver d;
    Connection c;
    ResultSet rsBrg;
    Statement stm;
    Boolean ada = false;
    String sSatuan;
    Boolean edit = false;
    private Object[][] dataTable = null;
    private String[] header = {"Kode", "Nama Barang", "Satuan", "Harga Beli", "Harga Jual", "Stok", "Stok Min"};
    private JPanel RootPane;
    private JTextField textKode;
    private JComboBox cmbSatuan;
    private JTable tableBarang;
    private JButton btnTambah;
    private JButton btnKeluar;
    private JButton btnSimpan;
    private JButton btnKoreksi;
    private JButton btnHapus;
    private JButton btnBatal;
    private JTextField textNama;
    private JTextField textHargaBeli;
    private JTextField textStok;
    private JTextField textStokMin;
    private JTextField textHargaJual;

    public FormDataBarang() {
        connectDB();
        baca_data();
        aktif(false);
        setTombol(true);
        // set cmbSatuan data
        cmbSatuan.setModel(new DefaultComboBoxModel(new String[]{"Pcs", "Pack", "Kardus", "Kg"}));
        // action btnKeluar
        btnKeluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // action btnTambah
        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aktif(true);
                setTombol(false);
                kosong();
            }
        });
        // action btnSimpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tKode=textKode.getText();
                String tNama=textNama.getText();
                sSatuan = cmbSatuan.getSelectedItem().toString();
                double hrgBeli=Double.parseDouble(textHargaBeli.getText());
                double hrgJual=Double.parseDouble(textHargaJual.getText());
                int stk=Integer.parseInt(textStok.getText());
                int stkMin=Integer.parseInt(textStokMin.getText());
                try{
                    if (edit==true)
                    {
                        stm.executeUpdate("update barang set nm_brg='"+tNama+"',satuan='"+sSatuan+"',harga_beli="+hrgBeli+",harga_jual="+hrgJual+",stok="+stk+",stok_min="+stkMin+" where kd_brg='" + tKode + "'");
                    }else
                    {
                        stm.executeUpdate("INSERT into barang VALUES('"+tKode+"','"+tNama+"','"+sSatuan+"',"+hrgBeli+","+hrgJual+","+stk+","+stkMin+")");
                    }
                    tableBarang.setModel(new DefaultTableModel(dataTable,header));
                    baca_data();
                    aktif(false);
                    setTombol(true);
                }catch(SQLException exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
            }
        });
        // action btnHapus
        btnBatal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aktif(false);
                setTombol(true);
            }
        });
        // mouse click tabel barang
        tableBarang.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setField();
            }
        });
        // action btnKoreksi
        btnKoreksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit=true;
                aktif(true);
                setTombol(false);
                textKode.setEditable(false);
            }
        });
        // action btnHapus
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String sql="delete from barang where kd_brg='" + textKode.getText() + "'";
                    stm.executeUpdate(sql);
                    baca_data();
                }
                catch(SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
    }

    // method untuk koneksi ke database
    private void connectDB() {
        KoneksiMysql kon = new KoneksiMysql ("db_pbo_penjualan");
        d = kon.getDriver();
        c = kon.getConnection();
    }

    // method untuk mengambil root Jpanel
    public JPanel getRootPane() {
        return RootPane;
    }

    // method set field form jika salah satu field tabel ditekan
    private void setField()
    {
        int row=tableBarang.getSelectedRow();
        textKode.setText((String)tableBarang.getValueAt(row,0));
        textNama.setText((String)tableBarang.getValueAt(row,1));
        cmbSatuan.setSelectedItem((String)tableBarang.getValueAt(row,2));
        String hargaJual = Double.toString((Double)tableBarang.getValueAt(row,3));
        textHargaJual.setText(hargaJual);
        String hargaBeli = Double.toString((Double)tableBarang.getValueAt(row,4));
        textHargaBeli.setText(hargaBeli);
        String stok=Integer.toString((Integer)tableBarang.getValueAt(row,5));
        textStok.setText(stok);
        String stokmin=Integer.toString((Integer)tableBarang.getValueAt(row,6));
        textStokMin.setText(stokmin);
    }

    // method baca data dari Mysql dimasukkan ke table pada form
    private void baca_data() {
        try{
            stm = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsBrg = stm.executeQuery("select * from barang");
            ResultSetMetaData meta = rsBrg.getMetaData();
            int col = meta.getColumnCount();
            int baris = 0;
            while(rsBrg.next()) {
                baris = rsBrg.getRow();
            }
            dataTable = new Object[baris][col];
            int x = 0;
            rsBrg.beforeFirst();
            while(rsBrg.next()) {
                dataTable[x][0] = rsBrg.getString("kd_brg");
                dataTable[x][1] = rsBrg.getString("nm_brg");
                dataTable[x][2] = rsBrg.getString("satuan");
                dataTable[x][3] = rsBrg.getDouble("harga_jual");
                dataTable[x][4] = rsBrg.getDouble("harga_beli");
                dataTable[x][5] = rsBrg.getInt("stok");
                dataTable[x][6] = rsBrg.getInt("stok_min");
                x++;
            }
            tableBarang.setModel(new DefaultTableModel(dataTable,header));
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // untuk mengkosongkan isian data
    private void kosong() {
        textKode.setText("");
        textNama.setText("");
        textHargaBeli.setText("");
        textHargaJual.setText("");
        textStok.setText("");
        textStokMin.setText("");
    }

    // mengset aktif tidak isian data
    private void aktif(boolean x) {
        textKode.setEditable(x);
        textNama.setEditable(x);
        //cmbSatuan.setEditable(x);
        cmbSatuan.setEnabled(x);
        textHargaBeli.setEditable(x);
        textHargaJual.setEditable(x);
        textStok.setEditable(x);
        textStokMin.setEditable(x);
    }
    // mengset tombol on/off
    private void setTombol(boolean t)
    {
        btnTambah.setEnabled(t);
        btnKoreksi.setEnabled(t);
        btnHapus.setEnabled(t);
        btnSimpan.setEnabled(!t);
        btnBatal.setEnabled(!t);
        btnKeluar.setEnabled(t);
    }
}
