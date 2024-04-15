-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 15-04-2024 a las 18:20:26
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestor_empleos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleo`
--

DROP TABLE IF EXISTS `empleo`;
CREATE TABLE IF NOT EXISTS `empleo` (
  `id` bigint NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `disponible` bit(1) NOT NULL,
  `salario` double NOT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleo`
--

INSERT INTO `empleo` (`id`, `descripcion`, `disponible`, `salario`, `titulo`) VALUES
(1, 'Se requiere desarrollador Java Senior con profundos conocimientos en microservicios.', b'0', 55000, 'Desarrollador Java Senior'),
(2, 'Se requiere desarrollador Front.', b'1', 5000, 'Desarrollador Front'),
(3, 'Se requiere desarrollador Backend.', b'1', 6000, 'Desarrollador Backend.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleo_seq`
--

DROP TABLE IF EXISTS `empleo_seq`;
CREATE TABLE IF NOT EXISTS `empleo_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `empleo_seq`
--

INSERT INTO `empleo_seq` (`next_val`) VALUES
(101);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
