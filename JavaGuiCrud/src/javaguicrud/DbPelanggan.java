/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaguicrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Yoga
 */
public class DbPelanggan {

    private Connection conn;
    private final koneksi k = new koneksi();

    // get data
    public ArrayList<Pelanggan> getPelanggan() throws SQLException{
        ArrayList<Pelanggan> daftar = new ArrayList<>();

        conn = k.getKoneksi();
        
        String query = "SELECT * FROM pelanggan";
        PreparedStatement ps = conn.prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nama = rs.getString("nama");
            String jenis = rs.getString("jenisMember");
            String tahunLahir = rs.getString("tahunLahir");

            Pelanggan p = new Pelanggan(id, nama, jenis, Integer.parseInt(tahunLahir));
            daftar.add(p);
            
        }
        rs.close();
        ps.close();
        conn.close();
        return daftar;
    }

    // insert data
    public boolean insertPelanggan(Pelanggan p) throws SQLException{
        conn = k.getKoneksi();
        
        String query = "INSERT INTO pelanggan VALUES(?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, p.getId());
        ps.setString(2, p.getNama());
        ps.setString(3, p.getJenis());
        ps.setInt(4, p.getTahunLahir());

        int row = ps.executeUpdate();

        ps.close();
        conn.close();
        return row > 0;
    }

    
    
}
