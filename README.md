# Minpro-4-PBO-PeminjamanAlatLab
## Deskripsi singkat program
<p>PeminjamanAlatLab adalah program sistem sederhana berbasis Java untuk mengelola peminjaman alat pada laboratorium biologi. Program ini menyediakan fitur untuk menampilkan daftar alat, menambah peminjaman, menampilkan riwayat peminjaman, mengembalikan alat, dan menghapus data peminjaman melalui menu yang tersedia.</p>

## Penjelasan struktur package
Project ini menggunakan struktur **Model → View → Controller → Service → Main** untuk memisahkan fungsi setiap bagian program.
- **model**: Berisi class yang merepresentasikan entitas data dan objek dalam sistem, seperti AlatLab, AlatGelas, AlatBedah, AlatUkur, dan Peminjaman.
- **view**: Bertanggung jawab atas antarmuka pengguna (user interface) dan penanganan input dari pengguna, diimplementasikan melalui PeminjamanView serta PeminjamanViewImp.
- **controller**: Berisi PeminjamanController yang bertindak sebagai perantara untuk menghubungkan View dengan Service, sekaligus mengatur alur logika berdasarkan input pengguna.
- **service**: Berisi PeminjamanService yang menangani seluruh proses bisnis utama, seperti validasi ketersediaan stok, pemrosesan peminjaman, pengembalian barang, serta pengelolaan data peminjaman.
- **main**: Berisi class Laboratorium sebagai titik awal program untuk membuat data awal, menghubungkan setiap bagian program, dan menjalankan sistem.

## Penjelasan alur program
## Penjelasan penerapan encapsulation dan Inheritance
## Penjelasan penerapan polymorphism dan abstraction
## Penjelasan penerapan JDBC
