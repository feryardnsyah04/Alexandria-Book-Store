-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Jun 2024 pada 20.24
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `alexandriadb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `code_products` varchar(10) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `category` varchar(10) NOT NULL,
  `quantity` int(100) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `code_voucher` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `cashier`
--

CREATE TABLE `cashier` (
  `id_cashier` int(3) NOT NULL,
  `nickname` varchar(10) NOT NULL,
  `full_name` varchar(40) NOT NULL,
  `work_shift` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `cashier`
--

INSERT INTO `cashier` (`id_cashier`, `nickname`, `full_name`, `work_shift`) VALUES
(1, 'Fery', 'Fery Ardiansyah', 'Pagi'),
(2, 'Nando', 'Cahya Fernando', 'Siang'),
(3, 'Nopal', 'Nopal Aditya', 'Malam');

-- --------------------------------------------------------

--
-- Struktur dari tabel `storage_items`
--

CREATE TABLE `storage_items` (
  `id_products` int(11) NOT NULL,
  `code_products` varchar(10) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `category` varchar(10) NOT NULL,
  `quantity` int(100) NOT NULL,
  `price` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `storage_items`
--

INSERT INTO `storage_items` (`id_products`, `code_products`, `product_name`, `category`, `quantity`, `price`) VALUES
(1, 'KOJUJ21', 'Jujutsu Kaisen Vol 0', 'Komik', 76, '40000.00'),
(2, 'NOIWA27', 'I Want to Eat Your Pancreas', 'Novel', 41, '78750.00'),
(3, 'NOHYO6', 'Hyouka', 'Novel', 90, '100000.00'),
(4, 'BUDUN20', 'Dunia Menurut Fisika', 'Buku', 63, '61200.00'),
(5, 'KOSOL20', 'Solo Leveling 06', 'Komik', 56, '68000.00'),
(6, 'NORAS6', 'Rasina', 'Novel', 60, '121680.00'),
(7, 'NOHEL18', 'Hello - Tere Li Ye', 'Novel', 40, '94500.00'),
(8, 'NOINI14', 'ini untuk kamu', 'Novel', 10, '115000.00'),
(9, 'NOSEC16', 'Secret the power', 'Novel', 50, '128000.00'),
(10, 'NOTEN6', 'Tenung', 'Novel', 15, '77000.00'),
(11, 'NOGAN14', 'Ganjil & Genap', 'Novel', 60, '99000.00'),
(12, 'NOSTO20', 'Stories fo Rainy day', 'Novel', 35, '97200.00'),
(13, 'NOOLE6', 'Olenka', 'Novel', 35, '75650.00'),
(14, 'NOBRO13', 'Broken Throne', 'Novel', 40, '60000.00'),
(15, 'NOTHE16', 'The perfect word', 'Novel', 10, '98000.00'),
(16, 'KODRS11', 'Dr.stone 02', 'Komik', 40, '45000.00'),
(17, 'KOMOB9', 'Mob psyco', 'Komik', 20, '40000.00'),
(18, 'KOCHA19', 'Chainsaw Man Vol 10', 'Komik', 10, '40000.00'),
(19, 'KOKIN12', 'kindaichi 37', 'Komik', 30, '42000.00'),
(20, 'KODEA16', 'Death Note Vol 2', 'Komik', 28, '88000.00'),
(21, 'KOALC9', 'Alchemist', 'Komik', 84, '99000.00'),
(22, 'KOMOR19', 'Moriaty The Patriot', 'Komik', 37, '32000.00'),
(23, 'KODRS8', 'Dr.Slump', 'Komik', 50, '75000.00'),
(24, 'KODEM15', 'Demon Slayer 12', 'Komik', 50, '40000.00'),
(25, 'KOMYH16', 'My Hero Academia', 'Komik', 75, '45000.00'),
(26, 'KOOVE14', 'Overload Vol 1', 'Komik', 65, '58000.00'),
(27, 'STONE9', 'ONE - A26', 'Stationery', 85, '8524.00'),
(28, 'STGRE18', 'GREEBEL Alat Tulis', 'Stationery', 20, '95600.00'),
(29, 'STGRE42', ' GREEBEL Paket Alat Crafing Activity Kids ', 'Stationery', 30, '55700.00'),
(30, 'STAPE12', 'A71 - Pensil', 'Stationery', 80, '2675.00'),
(31, 'STPRI24', 'Primasakti Greebel Tulis', 'Stationery', 50, '28900.00'),
(32, 'STGRE17', 'GREEBEL Paket Tas', 'Stationery', 10, '303300.00'),
(33, 'STAAL16', 'A71 - Alat Tulis', 'Stationery', 80, '5000.00'),
(34, 'STAPU12', 'A36 - Pulpen', 'Stationery', 80, '1099.00'),
(35, 'STAPE17', 'A41 - Pena Pulpen', 'Stationery', 75, '2998.00'),
(36, 'STATE16', 'A80 Tempat Tulis', 'Stationery', 50, '9199.00'),
(37, 'BUBUK32', 'Buku Ekonomi Kelas 11 Yudhistira', 'Buku', 50, '45000.00'),
(38, 'BUBUK41', 'Buku Bahasa Indonesia Kelas 11 Yudhistira', 'Buku', 50, '40000.00'),
(39, 'BUBUK29', 'Buku PPKn Kelas 11 Yudhistira', 'Buku', 40, '40000.00'),
(40, 'BUBUK36', 'Buku Informatika Kelas 11 Yudhistira', 'Buku', 80, '40000.00'),
(41, 'BUBUK33', 'Buku Sejarahi Kelas 11 Yudhistira', 'Buku', 80, '40000.00'),
(42, 'BUBUK30', 'Buku The Psychology Of Emotion', 'Buku', 20, '83000.00'),
(43, 'BUBUK19', 'Buku Berani Berubah', 'Buku', 35, '28350.00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `voucher`
--

CREATE TABLE `voucher` (
  `id_voucher` int(11) NOT NULL,
  `code_voucher` varchar(10) NOT NULL,
  `discount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `voucher`
--

INSERT INTO `voucher` (`id_voucher`, `code_voucher`, `discount`) VALUES
(1, 'DSK20OFF', 20),
(2, 'HUT10OFF', 10),
(3, 'HNY25OFF', 25);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indeks untuk tabel `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `cashier`
--
ALTER TABLE `cashier`
  ADD PRIMARY KEY (`id_cashier`);

--
-- Indeks untuk tabel `storage_items`
--
ALTER TABLE `storage_items`
  ADD PRIMARY KEY (`id_products`);

--
-- Indeks untuk tabel `voucher`
--
ALTER TABLE `voucher`
  ADD PRIMARY KEY (`id_voucher`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT untuk tabel `cashier`
--
ALTER TABLE `cashier`
  MODIFY `id_cashier` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `storage_items`
--
ALTER TABLE `storage_items`
  MODIFY `id_products` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT untuk tabel `voucher`
--
ALTER TABLE `voucher`
  MODIFY `id_voucher` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
