-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2020 a las 06:30:04
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_springboot_backend`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fechanacimiento` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `apellido`, `create_at`, `documento`, `email`, `fechanacimiento`, `nombre`, `tipo`) VALUES
(1, 'Guzmán', '2018-01-01', '127893456', 'profesor@bolsadeideas.com', '1967-01-01 00:00:00.000000', 'Andrés', 'cc'),
(2, 'Doe', '2018-01-02', '654389', 'john.doe@gmail.com', '1968-01-01 00:00:00.000000', 'Mr. Lenny', 'ce'),
(3, 'Torvalds', '2018-01-03', '127893457', 'linus.torvalds@gmail.com', '1988-01-01 00:00:00.000000', 'Linus', 'cc'),
(4, 'Lerdorf', '2018-01-04', '127893458', 'rasmus.lerdorf@gmail.com', '1998-01-01 00:00:00.000000', 'Rasmus', 'cc'),
(5, 'Gamma', '2018-02-01', '127893459', 'erich.gamma@gmail.com', '2008-01-01 00:00:00.000000', 'Erich', 'cc'),
(6, 'Helm', '2018-02-10', '127893450', 'richard.helm@gmail.com', '1978-01-01 00:00:00.000000', 'Richard', 'cc'),
(7, 'Johnson', '2018-02-18', '689098', 'ralph.johnson@gmail.com', '1958-01-01 00:00:00.000000', 'Ralph', 'ce'),
(8, 'Vlissides', '2018-02-28', '2898987', 'john.vlissides@gmail.com', '1948-01-01 00:00:00.000000', 'John', 'cc'),
(9, 'Gosling', '2018-03-03', '127893452', 'james.gosling@gmail.com', '1955-01-01 00:00:00.000000', 'Dr. James', 'cc'),
(10, 'Lee', '2018-03-04', '127893453', 'magma.lee@gmail.com', '1989-01-01 00:00:00.000000', 'Magma', 'cc'),
(11, 'Roe', '2018-03-05', '567890', 'tornado.roe@gmail.com', '1999-01-01 00:00:00.000000', 'Tornado', 'ce'),
(12, 'Doe', '2018-03-06', '127893454', 'jane.doe@gmail.com', '1974-01-01 00:00:00.000000', 'Jade', 'cc');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ganador`
--

CREATE TABLE `ganador` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `documento` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `idganador` varchar(255) DEFAULT NULL,
  `idpremio` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `premio` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `premio`
--

CREATE TABLE `premio` (
  `id` bigint(20) NOT NULL,
  `cantidad` bigint(20) DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `premio`
--

INSERT INTO `premio` (`id`, `cantidad`, `create_at`, `descripcion`) VALUES
(1, 5, '2020-06-08', 'Balón Blanco'),
(2, 2, '2020-06-08', 'Balón Negro'),
(3, 5, '2020-06-08', 'Dulce Blanco'),
(4, 10, '2020-06-08', 'Dulce Amarillo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ganador`
--
ALTER TABLE `ganador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `premio`
--
ALTER TABLE `premio`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `ganador`
--
ALTER TABLE `ganador`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `premio`
--
ALTER TABLE `premio`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
