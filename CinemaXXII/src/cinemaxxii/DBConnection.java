/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cinemaxxii;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Yoga
 */
public class DBConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/kampus_pbotubes";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public static Connection getKoneksi() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl(DB_URL);
        dataSource.setUser(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println("Koneksi berhasil");
        } catch (SQLException ex) {
            System.out.println("Eksepsi akses data: " + ex.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = getKoneksi();
    }
}
