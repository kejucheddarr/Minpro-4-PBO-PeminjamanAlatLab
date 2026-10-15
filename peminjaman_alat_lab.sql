-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 15, 2026 at 11:57 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `peminjaman_alat_lab`
--

-- --------------------------------------------------------

--
-- Table structure for table `alat_lab`
--

CREATE TABLE `alat_lab` (
  `id_alat` int NOT NULL,
  `nama_alat` varchar(100) NOT NULL,
  `kondisi_alat` varchar(50) NOT NULL,
  `stok` int NOT NULL DEFAULT '0',
  `kategori` varchar(50) NOT NULL,
  `keterangan` varchar(100) DEFAULT NULL
) ;

--
-- Dumping data for table `alat_lab`
--

INSERT INTO `alat_lab` (`id_alat`, `nama_alat`, `kondisi_alat`, `stok`, `kategori`, `keterangan`) VALUES
(1, 'Labu Erlenmeyer', 'Baik', 10, 'Alat Gelas', '250 mL'),
(2, 'Gelas Beaker', 'Baik', 5, 'Alat Gelas', '500 mL'),
(3, 'Scalpel', 'Baik', 5, 'Alat Bedah', 'Pemotong'),
(4, 'Forceps', 'Baik', 3, 'Alat Bedah', 'Penjepit'),
(5, 'Jangka Sorong', 'Baik', 1, 'Alat Ukur', 'Panjang'),
(6, 'Termometer', 'Baik', 1, 'Alat Ukur', 'Suhu');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` int NOT NULL,
  `nama_petugas` varchar(100) NOT NULL,
  `id_alat` int NOT NULL,
  `jumlah_pinjam` int NOT NULL,
  `status` varchar(30) NOT NULL DEFAULT 'Dipinjam'
) ;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `nama_petugas`, `id_alat`, `jumlah_pinjam`, `status`) VALUES
(1, 'Xiangli Yao', 5, 1, 'Dipinjam'),
(3, 'Bakugo', 6, 3, 'Dipinjam');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `alat_lab`
--
ALTER TABLE `alat_lab`
  ADD PRIMARY KEY (`id_alat`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `id_alat` (`id_alat`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`id_alat`) REFERENCES `alat_lab` (`id_alat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
