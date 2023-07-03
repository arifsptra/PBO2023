/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplikasi.penjualan;


/**
 *
 * @author arif
 */
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiMysql {
    String url, usr, pwd;

    public KoneksiMysql(String dbn) {
        this.url = "jdbc:mysql://arifsaputra.id/" + dbn;
        this.usr = "arif";
        this.pwd = "Koentj1@$";
    }

    public KoneksiMysql(String host, String user, String pass, String dbn) {
        this.url = "jdbc:mysql://" + host + "/" + dbn;
        this.usr = user;
        this.pwd = pass;
    }

    public Driver getDriver() {
        Driver mysqlDriver = null;
        try {
            mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return mysqlDriver;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, usr, pwd);

            System.out.println("Connection Success!");
        }catch (SQLException e) {
            System.out.println ("Error #1 : " + e.getMessage());
        }
        return connection;
    }
}
