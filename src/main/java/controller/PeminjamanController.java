/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.AlatLab;
import model.Peminjaman;
import service.PeminjamanService;
import view.PeminjamanView;

/**
 *
 * @author HP
 */
public class PeminjamanController {
    private final PeminjamanService service;
    private final PeminjamanView view;
    
    public PeminjamanController(PeminjamanService service, PeminjamanView view){
        this.service = service;
        this.view = view;
    }
    
    public void tampilkanAlat(){
        ArrayList<AlatLab> daftar = service.getDaftarAlat();
        if(daftar.isEmpty()){
            System.out.println(">> Data alat tidak tersedia.");
            return;
        }
        view.tampilkanDaftarAlat(daftar);
    }
    
    public void tambahPeminjaman(Peminjaman peminjaman){
        service.tambahPeminjaman(peminjaman);
    }
    
    public void tampilkanPeminjaman(){
        ArrayList<Peminjaman> daftar = service.getDaftarPeminjaman();
        
        if(daftar.isEmpty()){
            System.out.println(">> Belum ada data peminjaman.");
            return;
        }
        for (Peminjaman p : daftar){
            view.tampilkanPeminjaman(p);
        }
    }
    
    public void kembalikanAlat(int idTarget){
        service.kembalikanAlat(idTarget);
    }
    
    public void hapusPeminjaman(int idTarget){
        service.hapusPeminjaman(idTarget);
    }
}
