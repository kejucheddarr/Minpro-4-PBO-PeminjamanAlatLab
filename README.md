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
Saat program pertama kali di run, sistem akan memberikan output menu utama yang terdiri dari enam pilihan:
1. Tampilkan Alat
2. Tambah Peminjaman
3. Tampilkan Riwayat Peminjaman
4. Kembalikan Alat
5. Hapus Peminjaman
6. Keluar

<img width="589" height="310" alt="image" src="https://github.com/user-attachments/assets/b302f995-f759-4169-bf79-e29fed09a370" />

---

### 1. Tampilkan Alat
<p>Petugas dapat melihat daftar alat yang tersedia di laboratorium melalui pilihan menu 1. Alat yang ditampilkan dikelompokkan berdasarkan kategorinya, yaitu alat gelas, alat bedah, dan alat ukur. Setelah daftar alat ditampilkan, program akan otomatis kembali ke menu utama.</p>

<img width="542" height="775" alt="image" src="https://github.com/user-attachments/assets/caf33d9a-9a15-4683-a931-4c58fef0c7d8" />
<img width="559" height="789" alt="image" src="https://github.com/user-attachments/assets/8b040aca-9a44-4648-8343-dc53854ff7ce" />


---


### 2. Tambah Peminjaman
<p>Saat petugas ingin meminjam alat, mereka dapat memilih menu 2. Mereka lalu harus mengisi detail-detail seperti ID peminjaman, nama petugas, nama alat, dan jumlah yang dipinjam. Setelah data tersebut berhasil di input, sistem akan menampilkan pesan “Peminjaman berhasil ditambahkan” beserta pemberitahuan bahwa stok alat berhasil diperbarui, lalu balik ke menu awal.</p>

<img width="550" height="458" alt="image" src="https://github.com/user-attachments/assets/dc8e658d-1043-42ec-b2b9-517ab34904a4" />


<p>Setiap peminjaman alat akan memengaruhi stok. Dapat dilihat sebagai contoh, setelah petugas meminjam 7 labu erlenmeyer, stoknya berubah dari 10 menjadi 3.</p>

---

## Penjelasan penerapan encapsulation dan Inheritance
## Penjelasan penerapan polymorphism dan abstraction
## Penjelasan penerapan JDBC
