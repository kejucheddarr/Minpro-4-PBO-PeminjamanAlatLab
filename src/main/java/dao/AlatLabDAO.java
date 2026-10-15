/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.AlatLab;
import model.AlatGelas;
import model.AlatBedah;
import model.AlatUkur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class AlatLabDAO {
    public ArrayList<AlatLab> getSemuaAlat(){
        ArrayList<AlatLab> daftar = new ArrayList<>();
        String sql = """
                     SELECT id_alat, nama_alat, kondisi_alat, stok, kategori, keterangan
                     FROM alat_lab
                     ORDER BY id_alat
                     """;
        Connection conn = Koneksi.getConnection();
        
        if (conn == null){
            System.out.println(">> Koneksi database gagal.");
            return daftar;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                int id = rs.getInt("id_alat");
                String nama = rs.getString("nama_alat");
                String kondisi = rs.getString("kondisi_alat");
                int stok = rs.getInt("stok");
                String kategori = rs.getString("kategori");
                String keterangan = rs.getString("keterangan");
                
                switch(kategori){
                    case "Alat Gelas" -> daftar.add(new AlatGelas(id, nama, kondisi, stok, keterangan));
                    case "Alat Bedah" -> daftar.add(new AlatBedah(id, nama, kondisi, stok, keterangan));
                    case "Alat Ukur" -> daftar.add (new AlatUkur(id, nama, kondisi, stok, keterangan));
                    default -> System.out.println("Kategori alat tidak dikenal: " + kategori);
                }
            }
        }catch (SQLException e){
            System.out.println(">> Gagal mengambil data alat: " + e.getMessage());
        }
        return daftar;
    }
    public int cariIdAlat (Connection conn, String namaAlat){
        String sql = """
                     SELECT id_alat
                     FROM alat_lab
                     WHERE LOWER(TRIM(nama_alat)) = LOWER(TRIM(?))
                     """;
        if (conn == null || namaAlat == null){
            return -1;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, namaAlat);
            
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getInt("id_alat");
                }
            }
        }catch(SQLException e){
            System.out.println(">> Gagal mencari alat: " + e.getMessage());
        }
        return -1;
    }
    public boolean kurangiStok(Connection conn, int idAlat, int jumlah){
        String sql = """
                     UPDATE alat_lab
                     SET stok = stok - ?
                     WHERE id_alat = ?
                     AND stok >= ?
                     """;
        if (conn == null || jumlah <= 0){
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, jumlah);
            ps.setInt(2, idAlat);
            ps.setInt(3, jumlah);
            
            return ps.executeUpdate() == 1;
        }catch(SQLException e){
            System.out.println(">> Gagal mengurangi stok: " + e.getMessage());
            return false;
        }
    }
    
    public boolean kembalikanStok(Connection conn, int idAlat, int jumlah){
        String sql = """
                     UPDATE alat_lab
                     SET stok = stok + ?
                     WHERE id_alat = ?
                     """;
        if (conn == null || jumlah <= 0){
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, jumlah);
            ps.setInt(2, idAlat);
            
            return ps.executeUpdate() == 1;
        }catch(SQLException e){
            System.out.println(">> Gagal memulihkan stok alat: " + e.getMessage());
            return false;
        }
    }
}