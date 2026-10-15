/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Peminjaman;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class PeminjamanDAO {
    public boolean simpan(Connection conn, Peminjaman p, int idAlat){
        String sql = """
                     INSERT INTO peminjaman (id_peminjaman, nama_petugas, id_alat, jumlah_pinjam, status)
                     VALUES (?, ?, ?, ?, 'Dipinjam')
                     """;
        if (conn == null || p == null){
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, p.getIdPeminjaman());
            ps.setString(2, p.getNamaPetugas());
            ps.setInt(3, idAlat);
            ps.setInt(4, p.getJumlahPinjam());
            
            return ps.executeUpdate() == 1;
        }catch(SQLException e){
            System.out.println(">> Gagal menyimpan peminjaman: " + e.getMessage());
            return false;
        }
    }
    public ArrayList<Peminjaman> getSemuaPeminjaman(){
        ArrayList<Peminjaman> daftar = new ArrayList<>();
        
        String sql = """
                     SELECT p.id_peminjaman, p.nama_petugas, a.nama_alat, p.jumlah_pinjam, p.status
                     FROM peminjaman p
                     JOIN alat_lab a ON p.id_alat = a.id_alat
                     ORDER BY p.id_peminjaman
                     """;
        
        Connection conn = Koneksi.getConnection();
        
        if(conn == null){
            System.out.println(">> Koneksi database gagal.");
            return daftar;
        }
        try(PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()){
            while (rs.next()){
                Peminjaman p = new Peminjaman(
                rs.getInt("id_peminjaman"),
                rs.getString("nama_petugas"),
                rs.getString("nama_alat"),
                rs.getInt("jumlah_pinjam"));
                
                p.setStatus(rs.getString("status"));
                daftar.add(p);
            }
        }catch(SQLException e){
            System.out.println(">> Gagal mengambil riwayat peminjaman: " + e.getMessage());
        }
        return daftar;
    }
    public Peminjaman cariPeminjaman(Connection conn, int idTarget){
        String sql = """
                     SELECT p.id_peminjaman, p.nama_petugas, a.nama_alat, p.jumlah_pinjam, p.status
                     FROM peminjaman p
                     JOIN alat_lab a ON p.id_alat = a.id_alat
                     WHERE p.id_peminjaman = ?
                     """;
        if (conn == null){
            return null;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idTarget);
            
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Peminjaman p = new Peminjaman(
                    rs.getInt("id_peminjaman"),
                    rs.getString("nama_petugas"),
                    rs.getString("nama_alat"),
                    rs.getInt("jumlah_pinjam"));
                    
                    p.setStatus(rs.getString("status"));
                    return p;
                }
            }
        }catch(SQLException e){
            System.out.println(">> Gagal mencari peminjaman: " + e.getMessage());
        }
        return null;
    }
    public boolean ubahStatusDikembalikan(Connection conn, int idTarget){
        String sql = """
                     UPDATE peminjaman
                     SET status = 'Dikembalikan'
                     WHERE id_peminjaman = ?
                     AND status= 'Dipinjam'
                     """;
        if(conn == null){
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idTarget);
            
            return ps.executeUpdate() == 1;
            
        }catch(SQLException e){
            System.out.println(">> Gagal mengubah status peminjaman: " + e.getMessage());
            return false;
        }
    }
    public boolean hapus(Connection conn, int idTarget){
        String sql = """
                     DELETE FROM peminjaman
                     WHERE id_peminjaman = ?
                     AND status = 'Dikembalikan'
                     """;
        if (conn == null){
            return false;
        }
        try (PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, idTarget);
            
            return ps.executeUpdate() == 1;
        }catch (SQLException e){
            System.out.println(">> Gagal menghapus peminjaman: " + e.getMessage());
            return false;
        }
    }
}
