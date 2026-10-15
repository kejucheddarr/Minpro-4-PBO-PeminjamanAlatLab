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

<p>Data yang sudah dihapus tidak akan ditampilkan lagi pada menu riwayat.</p>

<img width="464" height="555" alt="image" src="https://github.com/user-attachments/assets/99abc781-b68b-467f-a62b-4832271bb62c" />

<p>Petugas tidak akan bisa menghapus riwayat peminjamannya jika mereka belum mengembalikan alat yang telah dipinjam.</p>
<img width="501" height="306" alt="image" src="https://github.com/user-attachments/assets/fdd8bc88-503c-4861-b629-7a2ae2c7ed7b" />

---

### 6. Keluar
<p>Jika petugas ingin keluar dari program, mereka dapat memilih menu 6, dan pengulangan menu akan berhenti.</p>

<img width="459" height="391" alt="image" src="https://github.com/user-attachments/assets/1347a4b8-6091-4804-a3e8-7c0e5e1afbe1" />

---

## Penjelasan penerapan Encapsulation dan Inheritance
### Encapsulation (Enkapsulasi)
<p>Enkapsulasi diterapkan pada class java pada package model, menggunakan access modifier protected pada atribut di class untuk membatasi akses langsung terhadap data dari luar class. Data tersebut kemudian hanya dapat diakses melalui method getter dan setter.</p>

<img width="374" height="144" alt="image" src="https://github.com/user-attachments/assets/caa62325-cb10-4ca4-82ec-0d270784d8eb" />
<img width="797" height="843" alt="image" src="https://github.com/user-attachments/assets/3e755e33-067f-410f-9de6-e2a3c7d98180" />

---

### Inheritance
<p>Inheritance diimplementasikan pada java class AlatLab sebagai induk/superclass, dengan AlatBedah, AlatUkur, dan AlatGelas sebagai subclass yang mewarisi atribut dan method dari AlatLab.</p>

<img width="824" height="291" alt="image" src="https://github.com/user-attachments/assets/e608d54a-e1e3-45c5-8b45-afa0945dfb06" />
<img width="1014" height="186" alt="image" src="https://github.com/user-attachments/assets/10b03cea-4052-490e-b809-ed20be451977" />
<img width="1044" height="190" alt="image" src="https://github.com/user-attachments/assets/c83174be-a3c6-4ee9-bc90-b62a3d96af56" />
<img width="1021" height="188" alt="image" src="https://github.com/user-attachments/assets/ea8fb45e-76d0-464c-a165-b3f6db2cb626" />

---

## Penjelasan penerapan Polymorphism dan Abstraction
### Polymorphism
<p>Polymorphism diterapkan dengan method overriding, yang diimplementasikan pada method tampilkanInfo() dari class AlatLab dan dioverride oleh class AlatBedah, AlatUkur, dan AlatGelas.</p>

<img width="443" height="57" alt="image" src="https://github.com/user-attachments/assets/f9180306-323f-465c-bf9b-ea3f1f7a01e9" />
<img width="597" height="202" alt="image" src="https://github.com/user-attachments/assets/478d59bb-6a6e-40ea-9723-393acdfe7669" />
<img width="572" height="215" alt="image" src="https://github.com/user-attachments/assets/c1755ce0-9ecc-4f65-9064-717b3ad7201c" />
<img width="569" height="205" alt="image" src="https://github.com/user-attachments/assets/b95649a2-6b2e-42f6-93f1-34a5d58459e3" />

---

### Abstraction
<p>Abstraction adalah teknik menyederhanakan suatu objek dengan cara menonjolkan atribut yang penting dan menyembunyikan detail implementasinya. Dalam project ini, abstraction diterapkan melalui abstract class AlatLab. Class ini berfungsi sebagai templat utama yang mendefinisikan atribut dan metode dasar untuk seluruh jenis peralatan laboratorium.</p>

<img width="382" height="131" alt="image" src="https://github.com/user-attachments/assets/562215f8-8b47-47cd-92de-50508b6338e3" />

<p>Metode tampilkanInfo() dideklarasikan sebagai abstract method, agar setiap subclass (AlatGelas, AlatBedah, dan AlatUkur) wajib mengimplementasikannya sesuai dengan karakteristik masing-masing alat.</p>

<img width="443" height="57" alt="image" src="https://github.com/user-attachments/assets/f9180306-323f-465c-bf9b-ea3f1f7a01e9" />

---

## Penjelasan penerapan Interface
<p>Interface merupakan struktur yang digunakan untuk mendefinisikan method yang harus diimplementasikan oleh suatu class. Interface diimplementasikan melalui PeminjamanView, untuk mendefinisikan method yang digunakan dalam proses tampilan dan input program. Interface tersebut kemudian diimplementasikan oleh PeminjamanViewImp menggunakan keyword implements.</p>

<img width="611" height="161" alt="image" src="https://github.com/user-attachments/assets/bbeb4e60-8dfd-4b13-b4df-3ab2f5cf18cc" />
<img width="811" height="761" alt="image" src="https://github.com/user-attachments/assets/80efc404-165a-4184-844d-7fb801a4f5a2" />

---

## Penjelasan penerapan JDBC
<p>Dalam project ini, JDBC digunakan untuk menghubungkan program Java dengan database MySQL.</p>

<img width="908" height="398" alt="image" src="https://github.com/user-attachments/assets/1c70fe0c-987d-48d6-9806-8716f532ade6" />

<p>JDBC memungkinkan program mengambil data alat laboratorium dari database, menyimpan catatan peminjaman, memperbarui jumlah stok alat ketika alat dipinjam atau dikembalikan, dan menampilkan riwayat penggunaan alat tersebut. Proses pengelolaan data dilakukan dengan menggunakan class DAO, yang menghubungkan ke database melalui PreparedStatement dan ResultSet.</p>

<img width="1081" height="858" alt="image" src="https://github.com/user-attachments/assets/806820a2-cf96-477f-a9dc-7dc5664397fa" />
<img width="1068" height="891" alt="image" src="https://github.com/user-attachments/assets/11a9fecf-4f47-47e8-b107-660d7e594728" />
<img width="423" height="282" alt="image" src="https://github.com/user-attachments/assets/1b7af84c-d8b4-4d11-8968-2678274cc6d8" />
<img width="741" height="513" alt="image" src="https://github.com/user-attachments/assets/51f159f8-81cd-4496-87c7-20c5d0a9f747" />
