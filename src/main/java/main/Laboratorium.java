/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import service.PeminjamanService;
import view.PeminjamanView;
import view.PeminjamanViewImp;
import controller.PeminjamanController;

/**
 *
 * @author HP
 */
public class Laboratorium {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        PeminjamanService service = new PeminjamanService();
        
        PeminjamanView view = new PeminjamanViewImp();
        
        PeminjamanController controller = new PeminjamanController(service, view);
        
        boolean berjalan = true;
        while (berjalan) {
            view.tampilkanMenu();
            
            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();
                
                //opsii
                switch (pilihan){
                    case 1 ->{
                        controller.tampilkanAlat();
                        break;
                    }
                    case 2 ->{
                        controller.tambahPeminjaman(view.inputPeminjaman(scanner));
                        break;
                    }
                    case 3 ->{
                        controller.tampilkanPeminjaman();
                        break;
                    }
                    case 4 ->{
                        System.out.println("Masukkan ID Peminjaman: ");
                        int idKembali = view.inputIdPeminjaman(scanner);
                        controller.kembalikanAlat(idKembali);
                        break;
                    }
                    case 5 ->{
                        System.out.println("Masukkan ID Peminjaman yang ingin dihapus: ");
                        int idHapus = view.inputIdPeminjaman(scanner);
                        controller.hapusPeminjaman(idHapus);
                        break;
                    }
                    case 6 ->{
                        berjalan = false;
                        System.out.println(">> Program selesai.");
                        break;
                    }
                    default ->{
                        System.out.println(">> Pilihan menu tidak tersedia.");
                    }
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println(">> Input harus berupa angka!");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
