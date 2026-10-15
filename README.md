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
<p>Saat petugas ingin meminjam alat, mereka dapat memilih menu 2. Mereka lalu harus mengisi detail-detail seperti ID peminjaman, nama petugas, nama alat, dan jumlah yang dipinjam. Setelah data tersebut berhasil di input, sistem akan menampilkan pesan “Peminjaman berhasil ditambahkan” beserta pemberitahuan bahwa stok alat berhasil dikurangi dan menampilkan sisa stok alatnya, lalu balik ke menu awal.</p>

<img width="541" height="485" alt="image" src="https://github.com/user-attachments/assets/c353da76-93dc-4c5c-9a1d-bd0f1537896b" />

<p>Setiap peminjaman alat akan memengaruhi stok. Dapat dilihat sebagai contoh, setelah petugas meminjam 3 termometer, stoknya berubah dari 4 menjadi 1.</p>
<img width="378" height="155" alt="image" src="https://github.com/user-attachments/assets/58381420-38f0-421c-8234-5ff028921710" />
<img width="342" height="151" alt="image" src="https://github.com/user-attachments/assets/64cc958d-60e8-4f0f-b216-9e20864daac3" />


<p>Program ini memiliki pembatasan dalam proses peminjaman alat. Jika petugas mencoba meminjam alat yang tidak ada dalam daftar alat pada menu 1, sistem akan menampilkan pemberitahuan bahwa alat tersebut tidak ditemukan.</p>
<img width="470" height="433" alt="image" src="https://github.com/user-attachments/assets/b984b7b7-a767-4683-84aa-0a9648b476d9" />

<p>Selain itu juga, jika petugas memasukkan jumlah peminjaman yang melebihi stok yang tersedia, sistem akan menampilkan peringatan bahwa stok alat tidak mencukupi dan menunjukkan jumlah stok yang tersedia.</p>
<img width="489" height="481" alt="image" src="https://github.com/user-attachments/assets/d06dda30-35fd-4803-bd77-dd6850832e5b" />

---


### 3. Tampilkan Riwayat Peminjaman
<p>Petugas dapat melihat riwayat peminjaman alat di laboratorium pada menu 3. Menu ini akan menampilkan ID peminjaman, nama petugas, nama alat, dan jumlah alat yang telah dipinjam, serta status "Dipinjam" yang secara otomatis diberikan oleh sistem. Setelah menampilkan riwayat, program akan balik ke menu awal.</p>

<img width="556" height="699" alt="image" src="https://github.com/user-attachments/assets/4af6726c-954a-486e-b2e1-9c0fa6910233" />


---

### 4. Kembalikan Alat
<p>Setelah alat dikembalikan, petugas dapat memilih menu 4 untuk mencatat pengembalian alat tersebut. Setelah memasukkan ID peminjaman, sistem akan mencatat bahwa alat telah dikembalikan, dan balik ke menu awal.</p>

<img width="465" height="340" alt="image" src="https://github.com/user-attachments/assets/9ff8571c-a5d5-4052-a77a-2633e30e7e0e" />

<p>Habis melakukan pengembalian, status peminjaman alat dapat dilihat kembali melalui menu riwayat, dengan status yang otomatis diperbarui menjadi “Dikembalikan”.</p>

<img width="422" height="140" alt="image" src="https://github.com/user-attachments/assets/618d0e5e-eb34-4e2e-b9b1-6330a26e3aa9" />

---

### 5. Hapus Peminjaman
<p>Pada menu 5, riwayat peminjaman yang sudah lama dapat dihapus agar data yang tersimpan dalam program tidak terlalu banyak. Penghapusan dilakukan dengan memasukkan ID peminjaman, kemudian sistem akan menghapus data tersebut secara otomatis.</p>

<img width="487" height="316" alt="image" src="https://github.com/user-attachments/assets/9a8bfe97-e644-4cc0-bdd3-707db4e18034" />


---
## Penjelasan penerapan encapsulation dan Inheritance
## Penjelasan penerapan polymorphism dan abstraction
## Penjelasan penerapan JDBC
