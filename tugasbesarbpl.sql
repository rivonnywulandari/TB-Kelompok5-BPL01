-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 21 Des 2020 pada 11.05
-- Versi Server: 10.1.30-MariaDB
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugasbesarbpl`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `sku` varchar(45) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `stock` int(45) NOT NULL,
  `harga_beli` int(45) NOT NULL,
  `harga_jual` int(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`sku`, `nama`, `stock`, `harga_beli`, `harga_jual`) VALUES
('B001', 'Hatomugi Toner', 6, 100000, 110000),
('B002', 'St. Ives', 6, 50000, 55000),
('B003', 'Nivea Face Oil', 7, 45000, 50000),
('B004', 'Emina Cheeklit', 7, 30000, 33000),
('B005', 'Wardah Refil', 7, 40000, 46000),
('B006', 'Makeover Silky', 7, 100000, 105000),
('B007', 'Elsheskin Serum', 7, 150000, 180000),
('B008', 'Vaseline Lotion', 7, 28000, 30000),
('B009', 'Pinky Milky', 7, 9000, 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `noresi` varchar(45) NOT NULL,
  `tanggal` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`noresi`, `tanggal`, `username`) VALUES
('R1', '2020-12-21', 'admin'),
('R100', '21-12-2020', 'admin'),
('R101', '21-12-2020', 'admin'),
('R102', '21-12-2020', 'admin'),
('R11', '2020-12-21', 'admin'),
('R12', '2020-12-21', 'admin'),
('R13', '2020-12-21', 'admin'),
('r14', '2020-12-21', 'admin'),
('R15', '2020-12-21', 'admin'),
('R16', '2020-12-21', 'admin'),
('R17', '2020-12-21', 'admin'),
('R18', '2020-12-21', 'admin'),
('R19', '2020-12-21', 'admin'),
('R2', '2020-12-21', 'admin'),
('R20', '2020-12-21', 'admin'),
('R22', '2020-12-21', 'admin'),
('R3', '2020-12-21', 'admin'),
('R4', '2020-12-21', 'admin'),
('R5', '2020-12-21', 'admin'),
('R54', '21-12-2020', 'admin'),
('R55', '21-12-2020', 'admin'),
('R6', '2020-12-21', 'admin'),
('R61', '21-12-2020', 'manajer'),
('R7', '2020-12-21', 'admin'),
('R77', '21-12-2020', 'admin'),
('R98', '21-12-2020', 'admin'),
('T1', '0000-00-00', 'admin'),
('T2', '2020-12-21', 'admin'),
('T3', '2020-12-21', 'admin'),
('T4', '2020-12-21', 'admin'),
('T5', '2020-12-21', 'admin'),
('T79', '21-12-2020', 'admin'),
('T96', '21-12-2020', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_detail`
--

CREATE TABLE `transaksi_detail` (
  `id` int(45) NOT NULL,
  `sku` varchar(45) NOT NULL,
  `noresi` varchar(45) NOT NULL,
  `jumlah` int(45) NOT NULL,
  `harga` int(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi_detail`
--

INSERT INTO `transaksi_detail` (`id`, `sku`, `noresi`, `jumlah`, `harga`) VALUES
(1, 'B001', 'T1', 1, 110000),
(5, 'B003', 'T4', 2, 100000),
(6, 'B006', 'T5', 1, 105000),
(7, 'B002', 'R1', 2, 110000),
(8, 'B001', 'R2', 1, 110000),
(9, 'B002', 'R3', 3, 165000),
(10, 'B004', 'R4', 2, 66000),
(11, 'B004', 'R5', 3, 99000),
(12, 'B007', 'R6', 1, 180000),
(13, 'B007', 'R7', 1, 180000),
(16, 'B001', 'R11', 2, 220000),
(18, 'B001', 'R13', 1, 110000),
(19, 'B003', 'r14', 1, 50000),
(20, 'B006', 'R15', 1, 105000),
(21, 'B002', 'R16', 2, 110000),
(22, 'B002', 'R17', 1, 55000),
(23, 'B005', 'R18', 2, 92000),
(24, 'B008', 'R19', 1, 30000),
(25, 'B003', 'R20', 1, 50000),
(27, 'B001', 'R98', 1, 110000),
(28, 'B003', 'R55', 2, 100000),
(29, 'B002', 'R54', 1, 55000),
(30, 'B001', 'R77', 1, 110000),
(31, 'B003', 'R61', 2, 100000),
(32, 'B005', 'T96', 1, 46000),
(33, 'B002', 'T79', 1, 55000),
(34, 'B001', 'R100', 1, 110000),
(35, 'B001', 'R101', 1, 110000),
(36, 'B002', 'R102', 1, 55000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `username` varchar(45) NOT NULL,
  `login_terakhir` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`username`, `login_terakhir`, `email`, `password`) VALUES
('admin', '2020-12-21', 'admin@gmail.com', 'admin'),
('manajer', '2020-12-21', 'manajer@gmail.com', 'manajer'),
('rivonny', '2020-12-16', 'rivonny@gmail.com', 'R14dduFEyKsTwSx'),
('vonny', '2020-12-17', 'vonny@gmail.com', 'dh1I78jdNQehGqj');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`sku`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`noresi`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sku` (`sku`),
  ADD KEY `noresi` (`noresi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  MODIFY `id` int(45) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Ketidakleluasaan untuk tabel `transaksi_detail`
--
ALTER TABLE `transaksi_detail`
  ADD CONSTRAINT `transaksi_detail_ibfk_1` FOREIGN KEY (`sku`) REFERENCES `barang` (`sku`),
  ADD CONSTRAINT `transaksi_detail_ibfk_2` FOREIGN KEY (`noresi`) REFERENCES `transaksi` (`noresi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
