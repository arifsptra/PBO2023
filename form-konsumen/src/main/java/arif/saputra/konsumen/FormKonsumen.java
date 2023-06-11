package arif.saputra.konsumen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class FormKonsumen {
    Driver d;
    Connection c;
    ResultSet rsBrg;
    Statement stm;
    Boolean ada = false;
    String sSatuan;
    Boolean edit = false;
    private Object[][] dataTable = null;
    private String[] header = {"Kode", "Nama Konsumen", "Alamat", "Kota", "Kode Pos", "Phone", "Email"};
    private JPanel RootPane;
    private JTextField textKode;
    private JTable tableBarang;
    private JButton btnTambah;
    private JButton btnKeluar;
    private JButton btnSimpan;
    private JButton btnKoreksi;
    private JButton btnHapus;
    private JButton btnBatal;
    private JTextField textNama;
    private JTextField textKota;
    private JTextField textTelepon;
    private JTextField textEmail;
    private JTextField textKodePos;
    private JPanel rootPane;
    private JTextField textAlamat;

    public FormKonsumen() {
        connectDB();
        baca_data();
        aktif(false);
        setTombol(true);
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
                String tAlamat=textAlamat.getText();
                String tKota=textKota.getText();
                String tKodePos=textKodePos.getText();
                String tPhone=textTelepon.getText();
                String tEmail=textEmail.getText();
                try{
                    if (edit==true)
                    {
                        stm.executeUpdate("update konsumen set nm_kons='"+tNama+"',alm_kons='"+tAlamat+"',kota_kons='"+tKota+"',kd_pos='"+tKodePos+"',phone='"+tPhone+"',email='"+tEmail+"' where kd_kons='" + tKode + "'");
                    }else
                    {
                        stm.executeUpdate("INSERT into konsumen VALUES('"+tKode+"','"+tNama+"','"+tAlamat+"','"+tKota+"','"+tKodePos+"','"+tPhone+"','"+tEmail+"')");
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
                    String sql="delete from konsumen where kd_kons='" + textKode.getText() + "'";
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
        return rootPane;
    }

    // method set field form jika salah satu field tabel ditekan
    private void setField()
    {
        int row=tableBarang.getSelectedRow();
        textKode.setText((String)tableBarang.getValueAt(row,0));
        textNama.setText((String)tableBarang.getValueAt(row,1));
        textAlamat.setText((String)tableBarang.getValueAt(row,2));
        textKota.setText((String)tableBarang.getValueAt(row,3));
        textKodePos.setText((String)tableBarang.getValueAt(row,4));
        textTelepon.setText((String)tableBarang.getValueAt(row,5));
        textEmail.setText((String)tableBarang.getValueAt(row,6));
    }

    // method baca data dari Mysql dimasukkan ke table pada form
    private void baca_data() {
        try{
            stm = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rsBrg = stm.executeQuery("select * from konsumen");
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
                dataTable[x][0] = rsBrg.getString("kd_kons");
                dataTable[x][1] = rsBrg.getString("nm_kons");
                dataTable[x][2] = rsBrg.getString("alm_kons");
                dataTable[x][3] = rsBrg.getString("kota_kons");
                dataTable[x][4] = rsBrg.getString("kd_pos");
                dataTable[x][5] = rsBrg.getString("phone");
                dataTable[x][6] = rsBrg.getString("email");
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
        textAlamat.setText("");
        textKota.setText("");
        textKodePos.setText("");
        textTelepon.setText("");
        textEmail.setText("");
    }

    // mengset aktif tidak isian data
    private void aktif(boolean x) {
        textKode.setEditable(x);
        textNama.setEditable(x);
        textAlamat.setEditable(x);
        textKota.setEditable(x);
        textKodePos.setEditable(x);
        textTelepon.setEditable(x);
        textEmail.setEditable(x);
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
