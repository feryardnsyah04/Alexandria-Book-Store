-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2024 pada 09.18
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
  `price` decimal(10,2) NOT NULL
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
(1, 'KOJUJ21', 'Jujutsu Kaisen Vol. 0', 'Komik', 48, '35000.00'),
(2, 'NOIWA27', 'I Want to Eat Your Pancreas', 'Novel', 48, '78750.00'),
(3, 'NOHYO6', 'Hyouka', 'Novel', 40, '61000.00'),
(4, 'BUDUN20', 'Dunia Menurut Fisika', 'Buku', 75, '61200.00'),
(5, 'KOSOL20', 'Solo Leveling 06', 'Komik', 56, '68000.00');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT untuk tabel `cashier`
--
ALTER TABLE `cashier`
  MODIFY `id_cashier` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `storage_items`
--
ALTER TABLE `storage_items`
  MODIFY `id_products` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT untuk tabel `voucher`
--
ALTER TABLE `voucher`
  MODIFY `id_voucher` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
