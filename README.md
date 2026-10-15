# Minpro-4-PBO-PeminjamanAlatLab
## Deskripsi singkat program
<p>PeminjamanAlatLab adalah program sistem sederhana berbasis Java untuk mengelola peminjaman alat pada laboratorium biologi. Program ini menyediakan fitur untuk menampilkan daftar alat, menambah peminjaman, menampilkan riwayat peminjaman, mengembalikan alat, dan menghapus data peminjaman melalui menu yang tersedia.</p>

## Penjelasan struktur package
Project ini menggunakan struktur **Model → View → Controller → Service → DAO → Main** untuk memisahkan fungsi setiap bagian program.
- **model**: Berisi class yang merepresentasikan entitas data dalam sistem, seperti AlatLab, AlatGelas, AlatBedah, AlatUkur, dan Peminjaman.
- **view**: Bertanggung jawab atas antarmuka pengguna (user interface) dan penanganan input dari pengguna, yang diimplementasikan melalui PeminjamanView dan PeminjamanViewImp.
- **controller**: Berisi PeminjamanController yang menghubungkan View dengan Service serta mengatur alur program berdasarkan input pengguna.
- **service**: Berisi PeminjamanService yang menangani proses bisnis utama, seperti validasi ketersediaan stok, pemrosesan peminjaman, pengembalian alat, serta pengelolaan data peminjaman.
- **dao**: Berisi AlatLabDAO, PeminjamanDAO, dan Koneksi yang bertanggung jawab atas akses database MySQL, termasuk mengambil data alat, mencari alat dan peminjaman, menyimpan data peminjaman, memperbarui status peminjaman, mengurangi atau mengembalikan stok, serta menghapus data peminjaman yang telah dikembalikan. Koneksi digunakan untuk menghubungkan program dengan database.
- **main**: Berisi class Laboratorium sebagai titik awal program untuk menginisialisasi komponen yang diperlukan dan menjalankan sistem.


<img width="371" height="483" alt="image" src="https://github.com/user-attachments/assets/35a6ae79-fc31-41ce-aded-eb1243f19338" />

---

## Penjelasan alur program
## Penjelasan penerapan encapsulation dan Inheritance
## Penjelasan penerapan polymorphism dan abstraction
## Penjelasan penerapan JDBC
