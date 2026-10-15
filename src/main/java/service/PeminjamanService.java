/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.Koneksi;
import dao.AlatLabDAO;
import dao.PeminjamanDAO;
import model.AlatLab;
import model.Peminjaman;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class PeminjamanService {
    private final AlatLabDAO alatDAO = new AlatLabDAO();
    private final PeminjamanDAO peminjamanDAO = new PeminjamanDAO();
    
    public ArrayList<AlatLab> getDaftarAlat(){
        return alatDAO.getSemuaAlat();
    }
    
    public ArrayList<Peminjaman> getDaftarPeminjaman(){
        return peminjamanDAO.getSemuaPeminjaman();
    }
    
    public void tambahPeminjaman(Peminjaman p){
        if(p == null){
            System.out.println(">> Data peminjaman tidak boleh kosong.");
            return;
        }
        if(p.getIdPeminjaman() <= 0){
            System.out.println("ID Peminjaman harus lebih dari 0.");
            return;
        }
        if(p.getNamaPetugas() == null || p.getNamaPetugas().trim().isEmpty()){
            System.out.println(">> Nama petugas tidak boleh kosong.");
            return;
        }
        if(p.getNamaAlat() == null || p.getNamaAlat().trim().isEmpty()){
            System.out.println(">> Nama alat tidak boleh kosong.");
            return;
        }
        if(p.getJumlahPinjam() <= 0){
            System.out.println(">> Jumlah pinjam harus lebih dari 0.");
            return;
        }
        try(Connection conn = Koneksi.getConnection()){
            if(conn == null){
                System.out.println(">> Koneksi database gagal.");
                return;
            }
            conn.setAutoCommit(false);
            try{
                int idAlat = alatDAO.cariIdAlat(conn, p.getNamaAlat());
                if (idAlat == -1){
                    conn.rollback();
                    System.out.println(">> Alat tidak ditemukan.");
                    return;
                }
                
                boolean stokBerhasil = alatDAO.kurangiStok(conn, idAlat, p.getJumlahPinjam());
                
                if(!stokBerhasil){
                    conn.rollback();
                    for (AlatLab alat : alatDAO.getSemuaAlat()){
                        if(alat.getIdAlat() == idAlat){
                            System.out.println(">> Stok tidak mencukupi.");
                            System.out.println(">> Stok tersedia: " + alat.getStok());
                            System.out.println(">> Jumlah yang ingin dipinjam: " + p.getJumlahPinjam());
                            break;
                        }
                    }
                    return;
                }
                
                boolean simpanBerhasil = peminjamanDAO.simpan(conn, p, idAlat);
                
                if(!simpanBerhasil){
                    conn.rollback();
                    System.out.println(">> Peminjaman gagal disimpan.");
                    return;
                }
                
                conn.commit();
                
                System.out.println(">> Peminjaman berhasil ditambahkan!");
                System.out.println(">> Stok alat berhasil dikurangi.");
                
                for(AlatLab alat : alatDAO.getSemuaAlat()){
                    if(alat.getIdAlat() == idAlat) {
                        System.out.println(">> Sisa stok " + alat.getNamaAlat() + ": " + alat.getStok());
                        break;
                    }
                }
            }catch(SQLException e){
                conn.rollback();
                System.out.println(">> Peminjaman gagal: " + e.getMessage());
            }finally{
                conn.setAutoCommit(true);
            }
        }catch(SQLException e){
            System.out.println(">> Koneksi database gagal: " + e.getMessage());
        }
    }
    
    public void kembalikanAlat(int idTarget){
        try(Connection conn = Koneksi.getConnection()){
            if(conn == null){
                System.out.println(">> Koneksi database gagal.");
                return;
            }
            
            conn.setAutoCommit(false);
            
            try{
                Peminjaman p = peminjamanDAO.cariPeminjaman(conn, idTarget);
                if(p == null){
                    conn.rollback();
                    System.out.println(">> ID Peminjaman tidak ditemukan.");
                    return;
                }
                if("Dikembalikan".equals(p.getStatus())){
                    conn.rollback();
                    System.out.println(">> Alat sudah dikembalikan.");
                    return;
                }
                int idAlat = alatDAO.cariIdAlat(conn, p.getNamaAlat());
                
                if(idAlat == -1){
                    conn.rollback();
                    System.out.println(">> Data alat tidak ditemukan.");
                    return;
                }
                
                boolean stokBerhasil = alatDAO.kembalikanStok(conn, idAlat, p.getJumlahPinjam());
                
                if(!stokBerhasil){
                    conn.rollback();
                    System.out.println(">> Gagal memulihkan stok alat.");
                    return;
                }
                
                boolean statusBerhasil = peminjamanDAO.ubahStatusDikembalikan(conn, idTarget);
                
                if(!statusBerhasil){
                    conn.rollback();
                    System.out.println(">> Status peminjaman gagal diperbarui.");
                    return;
                }
                conn.commit();
                
                System.out.println(">> Alat berhasil dikembalikan!");
                System.out.println(">> Stok alat berhasil dipulihkan.");
            }catch(SQLException e){
                conn.rollback();
                System.out.println(">> Pengembalian gagal: " + e.getMessage());
            }finally{
                conn.setAutoCommit(true);
            }
        }catch(SQLException e){
            System.out.println(">> Koneksi database gagal: " + e.getMessage());
        }
    }
    
    public void hapusPeminjaman(int idTarget){
        try(Connection conn = Koneksi.getConnection()){
            if(conn == null){
                System.out.println(">> Koneksi database gagal.");
                return;
            }
            
            conn.setAutoCommit(false);
            
            try{
                Peminjaman p = peminjamanDAO.cariPeminjaman(conn, idTarget);
                
                if(p == null){
                    conn.rollback();
                    System.out.println(">> ID Peminjaman tidak ditemukan.");
                    return;
                }
                if ("Dipinjam".equals(p.getStatus())){
                    conn.rollback();
                    System.out.println(">> Alat harus dikembalikan sebelum data dihapus.");
                    return;
                }
                
                boolean berhasil = peminjamanDAO.hapus(conn, idTarget);
                
                if(!berhasil){
                    conn.rollback();
                    System.out.println(">> Data peminjaman gagal dihapus.");
                    return;
                }
                
                conn.commit();
                
                System.out.println(">> Data peminjaman berhasil dihapus!");
            }catch(SQLException e){
                conn.rollback();
                System.out.println(">> Gagal menghapus peminjaman: " + e.getMessage());
            }finally{
                conn.setAutoCommit(true);
            }
        }catch(SQLException e){
            System.out.println(">> Koneksi database gagal: " + e.getMessage());
        }
    }
}