-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 20, 2018 at 05:08 AM
-- Server version: 5.7.19
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventario`
--

-- --------------------------------------------------------

--
-- Table structure for table `lineas_de_venta`
--

DROP TABLE IF EXISTS `lineas_de_venta`;
CREATE TABLE IF NOT EXISTS `lineas_de_venta` (
  `id_linea` int(4) NOT NULL AUTO_INCREMENT,
  `Linea` varchar(30) NOT NULL,
  PRIMARY KEY (`id_linea`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lineas_de_venta`
--

INSERT INTO `lineas_de_venta` (`id_linea`, `Linea`) VALUES
(1, 'Linea Blanca'),
(2, 'Electronica'),
(3, 'Ferreteria'),
(4, 'Hogar');

-- --------------------------------------------------------

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
CREATE TABLE IF NOT EXISTS `ventas` (
  `id_venta` int(4) NOT NULL AUTO_INCREMENT,
  `id_linea` int(4) NOT NULL,
  `fecha_venta` date NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `id_linea` (`id_linea`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ventas`
--

INSERT INTO `ventas` (`id_venta`, `id_linea`, `fecha_venta`, `descripcion`) VALUES
(13, 2, '2018-08-16', 'qsiohg0ad9g8ihadg'),
(14, 4, '2018-08-01', 'prueba de esta cosa'),
(15, 3, '2018-08-09', 'prueba '),
(16, 1, '2018-08-08', 'ramirez'),
(17, 1, '2018-08-01', 'ramirez');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_linea`) REFERENCES `lineas_de_venta` (`id_linea`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
