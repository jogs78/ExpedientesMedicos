-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 27-02-2021 a las 02:45:47
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ExpedientesMedicos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antecedentes`
--

CREATE TABLE `antecedentes` (
  `idAntecedente` int(11) NOT NULL,
  `nombreAntecedente` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `antecedentes`
--

INSERT INTO `antecedentes` (`idAntecedente`, `nombreAntecedente`) VALUES
(1, 'Aparato respiratorio'),
(2, 'Aparato cardiovascular'),
(3, 'Aparato digestivo'),
(4, 'Sistema nervioso'),
(5, 'Problemas de Goagulacion'),
(6, 'Vertigo y Mareos'),
(7, 'Diabetes'),
(8, 'Tiroides'),
(9, 'Fiebre reumatica'),
(10, 'Hipertension'),
(11, 'Fumador'),
(12, 'Bebe alcohol'),
(13, 'Consume drogas'),
(14, 'Buena Higiene bucal'),
(15, 'Mala Higiene bucal'),
(16, '-1 mes de Embarazo'),
(17, '1 mes de Embarazo'),
(18, '2 meses de Embarazo'),
(19, '3 meses de Embarazo'),
(20, '4 meses de Embarazo'),
(21, '5 meses de Embarazo'),
(22, '6 meses de Embarazo'),
(23, '7 meses de Embarazo'),
(24, '8 meses de Embarazo'),
(25, '9 meses de Embarazo'),
(26, 'Desmayos'),
(27, 'Sin Embarazo'),
(29, 'gripe 3'),
(30, 'pruebasi');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anticonseptivos`
--

CREATE TABLE `anticonseptivos` (
  `idAnticonsep` int(11) NOT NULL,
  `tipoAnt` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `anticonseptivos`
--

INSERT INTO `anticonseptivos` (`idAnticonsep`, `tipoAnt`) VALUES
(1, 'Anticoncepción reversible'),
(2, 'Métodos hormonales'),
(3, 'Métodos de barrera'),
(4, 'Anticonceptivos de emergencia'),
(5, 'Esterilización'),
(6, 'Otro'),
(7, 'NO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `blandos`
--

CREATE TABLE `blandos` (
  `idBlando` int(11) NOT NULL,
  `nombreBlando` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `blandos`
--

INSERT INTO `blandos` (`idBlando`, `nombreBlando`) VALUES
(1, 'Encia'),
(2, 'Insercion epitelial'),
(3, 'Lengua'),
(4, 'Pulpa(Alteraciones)'),
(5, 'Velo del paladar'),
(6, 'Carrillos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `folio` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `fechaCita` date NOT NULL,
  `idTipoConsulta` int(11) NOT NULL,
  `saldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`folio`, `idCliente`, `fechaCita`, `idTipoConsulta`, `saldo`) VALUES
(6, 19, '2021-02-16', 5, 9400),
(7, 20, '2021-02-19', 4, 2000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_alergia`
--

CREATE TABLE `cita_alergia` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `alergia` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_alergia`
--

INSERT INTO `cita_alergia` (`id`, `folio`, `alergia`) VALUES
(1, 6, 'prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_antecedentes`
--

CREATE TABLE `cita_antecedentes` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idAntecedente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_antecedentes`
--

INSERT INTO `cita_antecedentes` (`id`, `folio`, `idAntecedente`) VALUES
(1, 6, 1),
(2, 6, 27),
(3, 6, 2),
(4, 6, 27),
(5, 6, 4),
(6, 6, 4),
(7, 6, 3),
(8, 6, 4),
(9, 6, 13),
(16, 7, 1),
(17, 7, 5),
(18, 7, 9),
(20, 7, 29),
(21, 7, 30),
(22, 7, 11),
(23, 7, 12),
(24, 7, 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_anticonseptivos`
--

CREATE TABLE `cita_anticonseptivos` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idAnticonseptivo` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_anticonseptivos`
--

INSERT INTO `cita_anticonseptivos` (`id`, `folio`, `idAnticonseptivo`) VALUES
(1, 6, 2),
(2, 6, 4),
(7, 7, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_blandos`
--

CREATE TABLE `cita_blandos` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idBlando` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_blandos`
--

INSERT INTO `cita_blandos` (`id`, `folio`, `idBlando`) VALUES
(1, 6, 2),
(2, 6, 6),
(5, 7, 1),
(6, 7, 3),
(7, 7, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_cuidados`
--

CREATE TABLE `cita_cuidados` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idCuidado` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_cuidados`
--

INSERT INTO `cita_cuidados` (`id`, `folio`, `idCuidado`) VALUES
(1, 6, 1),
(2, 6, 4),
(3, 6, 12),
(4, 6, 2),
(11, 7, 1),
(12, 7, 3),
(13, 7, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_cuidadosF`
--

CREATE TABLE `cita_cuidadosF` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `vecesCepilla` int(2) NOT NULL,
  `idCuidado` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_cuidadosF`
--

INSERT INTO `cita_cuidadosF` (`id`, `folio`, `vecesCepilla`, `idCuidado`) VALUES
(1, 6, 6, 9),
(5, 7, 3, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_duros`
--

CREATE TABLE `cita_duros` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idDuro` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_duros`
--

INSERT INTO `cita_duros` (`id`, `folio`, `idDuro`) VALUES
(1, 6, 1),
(2, 6, 1),
(4, 7, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_habitos`
--

CREATE TABLE `cita_habitos` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idHabito` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_habitos`
--

INSERT INTO `cita_habitos` (`id`, `folio`, `idHabito`) VALUES
(1, 6, 1),
(2, 6, 6),
(3, 6, 8),
(9, 6, 8),
(10, 7, 2),
(11, 7, 7),
(12, 7, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_habitosF`
--

CREATE TABLE `cita_habitosF` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idHabito` int(3) NOT NULL,
  `frecuencia` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_habitosF`
--

INSERT INTO `cita_habitosF` (`id`, `folio`, `idHabito`, `frecuencia`) VALUES
(1, 6, 4, '5 veces'),
(2, 6, 5, '5 veces'),
(5, 7, 4, '5 VECES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_obcervaciones`
--

CREATE TABLE `cita_obcervaciones` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `obcervaciones` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_obcervaciones`
--

INSERT INTO `cita_obcervaciones` (`id`, `folio`, `obcervaciones`) VALUES
(1, 6, 'prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_oclusion`
--

CREATE TABLE `cita_oclusion` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idOclusion` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_oclusion`
--

INSERT INTO `cita_oclusion` (`id`, `folio`, `idOclusion`) VALUES
(1, 6, 3),
(2, 6, 5),
(3, 6, 1),
(7, 7, 3),
(8, 7, 4),
(9, 7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita_rx`
--

CREATE TABLE `cita_rx` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idRx` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita_rx`
--

INSERT INTO `cita_rx` (`id`, `folio`, `idRx`) VALUES
(1, 6, 1),
(3, 7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuidados`
--

CREATE TABLE `cuidados` (
  `idCuidado` int(11) NOT NULL,
  `nombreCuidado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cuidados`
--

INSERT INTO `cuidados` (`idCuidado`, `nombreCuidado`) VALUES
(1, 'Rechina o Aprieta los dientes '),
(2, 'Se hizo tratamiento de encias'),
(3, 'tuvo orientacion de higiene bucal'),
(4, 'Se ha hecho cirugia de encias'),
(5, 'Ha tenido Hemorragias en la boca'),
(6, 'Cepillo duro'),
(7, 'Cepillo suave'),
(8, 'Cepillo medio'),
(9, 'Cepillo Ultrasuave'),
(12, 'Ningun cuidado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosCliente`
--

CREATE TABLE `datosCliente` (
  `idCliente` int(5) NOT NULL,
  `nombreCliente` varchar(25) NOT NULL,
  `apellidoPat` varchar(15) NOT NULL,
  `apellidoMat` varchar(15) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `contacto` varchar(15) NOT NULL,
  `fechaRegistro` date NOT NULL,
  `fechaInicia` date NOT NULL,
  `fechaTermina` date NOT NULL,
  `edad` int(4) NOT NULL,
  `sexo` varchar(20) NOT NULL,
  `saldo` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datosCliente`
--

INSERT INTO `datosCliente` (`idCliente`, `nombreCliente`, `apellidoPat`, `apellidoMat`, `domicilio`, `contacto`, `fechaRegistro`, `fechaInicia`, `fechaTermina`, `edad`, `sexo`, `saldo`) VALUES
(19, 'eloisa marroquin', 'cruz', 'perez', 'conocido', '919 122', '2021-08-22', '0018-08-14', '0025-08-13', 41, 'Femenino', 9400),
(20, 'carlos josue ', 'perez', 'perez', 'conocido', '9191110989', '2021-02-18', '2021-02-19', '2021-02-28', 24, 'Masculino', 0),
(23, 'Moises de Jesus', 'Velasco', 'Gomez', 'Av. Gnral. Francisco I. madero', '9191235135', '2021-02-26', '2021-02-26', '2021-02-27', 22, 'Masculino', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datosMedico`
--

CREATE TABLE `datosMedico` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `tipoTratamiento` varchar(20) NOT NULL,
  `nombreMedico` varchar(60) NOT NULL,
  `contacto` varchar(30) NOT NULL,
  `tomaMedicamento` varchar(30) NOT NULL,
  `hospitalizado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `datosMedico`
--

INSERT INTO `datosMedico` (`id`, `idCliente`, `tipoTratamiento`, `nombreMedico`, `contacto`, `tomaMedicamento`, `hospitalizado`) VALUES
(1, 19, 'MEDICO', 'moises de jesus velasco gomes', '9191235135', 'NO', 'desmayo'),
(2, 20, 'DENTAL', 'MOISES DE JESUS', '9191235135', 'NO', 'CORTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dientes`
--

CREATE TABLE `dientes` (
  `idDiente` int(11) NOT NULL,
  `nombreDiente` varchar(40) NOT NULL,
  `simboloDiente` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dientes`
--

INSERT INTO `dientes` (`idDiente`, `nombreDiente`, `simboloDiente`) VALUES
(1, 'Muela del Juicio Dcha. sup.', '1a'),
(2, 'Segunda Molar Dcha. sup.', '2a'),
(3, 'Primer Molar Dcha. sup.', '3a'),
(4, 'Segundo Premolar Dcha. sup.', '4a'),
(5, 'Primer Premolar Dcha. sup.', '5a'),
(6, 'Canino Dcha. sup.', '6a'),
(7, 'Incisivo Lateral Dcha. sup.', '7a'),
(8, 'Incisivo Central Dcha. sup.', '8a'),
(9, 'Muela del Juicio Izq. sup.', '1b'),
(10, 'Segunda Molar Izq. sup.', '2b'),
(11, 'Primer Molar Izq. sup.', '3b'),
(12, 'Segundo Premolar Izq. sup.', '4b'),
(13, 'Primer Premolar Izq. sup.', '5b'),
(14, 'Canino Izq. sup.', '6b'),
(15, 'Incisivo Lateral Izq. sup.', '7b'),
(16, 'Incisivo Central Izq. sup.', '8b'),
(17, 'Muela del Juicio Izq. inf.', '1c'),
(18, 'Segunda Molar Izq. inf.', '2c'),
(19, 'Primer Molar Izq. inf.', '3c'),
(20, 'Segundo Premolar Izq. inf.', '4c'),
(21, 'Primer Premolar Izq. inf.', '5c'),
(22, 'Canino Izq. inf.', '6c'),
(23, 'Incisivo Lateral Izq. inf.', '7c'),
(24, 'Incisivo Central Izq. inf.', '8c'),
(25, 'Muela del Juicio Dcha. inf.', '1d'),
(26, 'Segunda Molar Dcha. inf.', '2d'),
(27, 'Primer Molar Dcha. inf.', '3d'),
(28, 'Segundo Premolar Dcha. inf.', '4d'),
(29, 'Primer Premolar Dcha. inf.', '5d'),
(30, 'Canino Dcha. inf.', '6d'),
(31, 'Incisivo Lateral Dcha. inf.', '7d'),
(32, 'Incisivo Central Dcha. inf.', '8d');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dientes_padecimiento`
--

CREATE TABLE `dientes_padecimiento` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idDiente` int(3) NOT NULL,
  `idPadecimiento` int(3) NOT NULL,
  `color` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dientes_padecimiento`
--

INSERT INTO `dientes_padecimiento` (`id`, `folio`, `idDiente`, `idPadecimiento`, `color`) VALUES
(1, 6, 6, 1, 'A:2'),
(2, 6, 15, 2, 'B:1'),
(3, 6, 1, 1, 'A:4'),
(6, 6, 1, 3, 'A:1'),
(7, 7, 1, 1, 'A:5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `duros`
--

CREATE TABLE `duros` (
  `idDuro` int(11) NOT NULL,
  `nombreDuro` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `duros`
--

INSERT INTO `duros` (`idDuro`, `nombreDuro`) VALUES
(1, 'Esmalte'),
(2, 'Dentina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitos`
--

CREATE TABLE `habitos` (
  `idHabito` int(11) NOT NULL,
  `nombreHabito` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `habitos`
--

INSERT INTO `habitos` (`idHabito`, `nombreHabito`) VALUES
(1, 'Bricomania'),
(2, 'Contracciones musculares'),
(3, 'Chupador de Labios'),
(4, 'Chupador de Lengua'),
(5, 'Chupador de Dedos'),
(6, 'Habito de Mordida'),
(7, 'Respiracion bucal'),
(8, 'Buena alimentacion'),
(9, 'Mala alimentacion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oclusion`
--

CREATE TABLE `oclusion` (
  `idOclusion` int(11) NOT NULL,
  `nombreOclusion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oclusion`
--

INSERT INTO `oclusion` (`idOclusion`, `nombreOclusion`) VALUES
(1, 'Sobre mordida Horizontal'),
(2, 'Sobre mordida Vertical'),
(3, 'Mordida abierta'),
(4, 'Desgaste bruxismo'),
(5, 'Anoclusion'),
(7, '\"NINGUNO\"');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `padecimiento`
--

CREATE TABLE `padecimiento` (
  `idPadecimiento` int(4) NOT NULL,
  `nombrePadecimiento` varchar(40) NOT NULL,
  `simbolo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `padecimiento`
--

INSERT INTO `padecimiento` (`idPadecimiento`, `nombrePadecimiento`, `simbolo`) VALUES
(1, 'Caries', 'cr'),
(2, 'Profilaxis', 'O'),
(3, 'muela', 'Ml');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(5) NOT NULL,
  `nombreProductos` varchar(50) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `existencia` int(4) NOT NULL,
  `fechaCaducidad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombreProductos`, `codigo`, `existencia`, `fechaCaducidad`) VALUES
(4, 'luis', '23', 2, 'efqew'),
(5, 'paracetamol', '21928', 12, '12'),
(6, 'paracetamol', '12345678', 2, '120720'),
(16, 'paracetamol', '21928', 12, '12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rx`
--

CREATE TABLE `rx` (
  `idRx` int(11) NOT NULL,
  `nombreRx` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rx`
--

INSERT INTO `rx` (`idRx`, `nombreRx`) VALUES
(1, 'Raiz'),
(2, 'Huesos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoConsulta`
--

CREATE TABLE `tipoConsulta` (
  `idTipoConsulta` int(11) NOT NULL,
  `nombreConsulta` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipoConsulta`
--

INSERT INTO `tipoConsulta` (`idTipoConsulta`, `nombreConsulta`) VALUES
(1, 'Emergencia'),
(2, 'Revision'),
(3, 'Lesion caries'),
(4, 'Limpieza'),
(5, 'Puente'),
(6, 'Protodoncia'),
(7, 'Extraccion');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `idTratamiento` int(4) NOT NULL,
  `nombreTratamiento` varchar(50) NOT NULL,
  `simboloTratamiento` varchar(10) NOT NULL,
  `precioTratamiento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`idTratamiento`, `nombreTratamiento`, `simboloTratamiento`, `precioTratamiento`) VALUES
(1, 'Blanqueamiento', 'Bq', 200),
(2, 'protesis fija de tres unidades', 'pf3', 4500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento_dientes`
--

CREATE TABLE `tratamiento_dientes` (
  `id` int(11) NOT NULL,
  `folio` int(11) NOT NULL,
  `idDiente` int(3) NOT NULL,
  `idTratamiento` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tratamiento_dientes`
--

INSERT INTO `tratamiento_dientes` (`id`, `folio`, `idDiente`, `idTratamiento`) VALUES
(1, 6, 6, 2),
(2, 6, 15, 1),
(3, 6, 1, 1),
(6, 6, 1, 2),
(7, 7, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(4) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `user` varchar(30) NOT NULL,
  `contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `telefono`, `user`, `contraseña`) VALUES
(1, 'Migel angel', 'Suarez', '919123513', 'admin1', 'suarez');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `antecedentes`
--
ALTER TABLE `antecedentes`
  ADD PRIMARY KEY (`idAntecedente`);

--
-- Indices de la tabla `anticonseptivos`
--
ALTER TABLE `anticonseptivos`
  ADD PRIMARY KEY (`idAnticonsep`);

--
-- Indices de la tabla `blandos`
--
ALTER TABLE `blandos`
  ADD PRIMARY KEY (`idBlando`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`folio`),
  ADD KEY `idTipoConsulta` (`idTipoConsulta`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `cita_alergia`
--
ALTER TABLE `cita_alergia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`);

--
-- Indices de la tabla `cita_antecedentes`
--
ALTER TABLE `cita_antecedentes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idAntecedente` (`idAntecedente`);

--
-- Indices de la tabla `cita_anticonseptivos`
--
ALTER TABLE `cita_anticonseptivos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idAnticonseptivo` (`idAnticonseptivo`);

--
-- Indices de la tabla `cita_blandos`
--
ALTER TABLE `cita_blandos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idBlando` (`idBlando`),
  ADD KEY `folio` (`folio`);

--
-- Indices de la tabla `cita_cuidados`
--
ALTER TABLE `cita_cuidados`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idCuidado` (`idCuidado`);

--
-- Indices de la tabla `cita_cuidadosF`
--
ALTER TABLE `cita_cuidadosF`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idCuidado` (`idCuidado`);

--
-- Indices de la tabla `cita_duros`
--
ALTER TABLE `cita_duros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idDuro` (`idDuro`);

--
-- Indices de la tabla `cita_habitos`
--
ALTER TABLE `cita_habitos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idHabito` (`idHabito`);

--
-- Indices de la tabla `cita_habitosF`
--
ALTER TABLE `cita_habitosF`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idHabito` (`idHabito`);

--
-- Indices de la tabla `cita_obcervaciones`
--
ALTER TABLE `cita_obcervaciones`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`);

--
-- Indices de la tabla `cita_oclusion`
--
ALTER TABLE `cita_oclusion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idOclusion` (`idOclusion`);

--
-- Indices de la tabla `cita_rx`
--
ALTER TABLE `cita_rx`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idRx` (`idRx`);

--
-- Indices de la tabla `cuidados`
--
ALTER TABLE `cuidados`
  ADD PRIMARY KEY (`idCuidado`);

--
-- Indices de la tabla `datosCliente`
--
ALTER TABLE `datosCliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `datosMedico`
--
ALTER TABLE `datosMedico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `dientes`
--
ALTER TABLE `dientes`
  ADD PRIMARY KEY (`idDiente`);

--
-- Indices de la tabla `dientes_padecimiento`
--
ALTER TABLE `dientes_padecimiento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idDiente` (`idDiente`),
  ADD KEY `idPadecimiento` (`idPadecimiento`);

--
-- Indices de la tabla `duros`
--
ALTER TABLE `duros`
  ADD PRIMARY KEY (`idDuro`);

--
-- Indices de la tabla `habitos`
--
ALTER TABLE `habitos`
  ADD PRIMARY KEY (`idHabito`);

--
-- Indices de la tabla `oclusion`
--
ALTER TABLE `oclusion`
  ADD PRIMARY KEY (`idOclusion`);

--
-- Indices de la tabla `padecimiento`
--
ALTER TABLE `padecimiento`
  ADD PRIMARY KEY (`idPadecimiento`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `rx`
--
ALTER TABLE `rx`
  ADD PRIMARY KEY (`idRx`);

--
-- Indices de la tabla `tipoConsulta`
--
ALTER TABLE `tipoConsulta`
  ADD PRIMARY KEY (`idTipoConsulta`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`idTratamiento`);

--
-- Indices de la tabla `tratamiento_dientes`
--
ALTER TABLE `tratamiento_dientes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `folio` (`folio`),
  ADD KEY `idDiente` (`idDiente`),
  ADD KEY `idTratamiento` (`idTratamiento`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `antecedentes`
--
ALTER TABLE `antecedentes`
  MODIFY `idAntecedente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `anticonseptivos`
--
ALTER TABLE `anticonseptivos`
  MODIFY `idAnticonsep` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `blandos`
--
ALTER TABLE `blandos`
  MODIFY `idBlando` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `folio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `cita_alergia`
--
ALTER TABLE `cita_alergia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `cita_antecedentes`
--
ALTER TABLE `cita_antecedentes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `cita_anticonseptivos`
--
ALTER TABLE `cita_anticonseptivos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cita_blandos`
--
ALTER TABLE `cita_blandos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `cita_cuidados`
--
ALTER TABLE `cita_cuidados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `cita_cuidadosF`
--
ALTER TABLE `cita_cuidadosF`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cita_duros`
--
ALTER TABLE `cita_duros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `cita_habitos`
--
ALTER TABLE `cita_habitos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `cita_habitosF`
--
ALTER TABLE `cita_habitosF`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `cita_obcervaciones`
--
ALTER TABLE `cita_obcervaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `cita_oclusion`
--
ALTER TABLE `cita_oclusion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `cita_rx`
--
ALTER TABLE `cita_rx`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cuidados`
--
ALTER TABLE `cuidados`
  MODIFY `idCuidado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `datosCliente`
--
ALTER TABLE `datosCliente`
  MODIFY `idCliente` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `datosMedico`
--
ALTER TABLE `datosMedico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `dientes`
--
ALTER TABLE `dientes`
  MODIFY `idDiente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `dientes_padecimiento`
--
ALTER TABLE `dientes_padecimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `duros`
--
ALTER TABLE `duros`
  MODIFY `idDuro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `habitos`
--
ALTER TABLE `habitos`
  MODIFY `idHabito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `oclusion`
--
ALTER TABLE `oclusion`
  MODIFY `idOclusion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `padecimiento`
--
ALTER TABLE `padecimiento`
  MODIFY `idPadecimiento` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `rx`
--
ALTER TABLE `rx`
  MODIFY `idRx` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipoConsulta`
--
ALTER TABLE `tipoConsulta`
  MODIFY `idTipoConsulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `idTratamiento` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tratamiento_dientes`
--
ALTER TABLE `tratamiento_dientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`idTipoConsulta`) REFERENCES `tipoConsulta` (`idTipoConsulta`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `datosCliente` (`idCliente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_alergia`
--
ALTER TABLE `cita_alergia`
  ADD CONSTRAINT `cita_alergia_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_antecedentes`
--
ALTER TABLE `cita_antecedentes`
  ADD CONSTRAINT `cita_antecedentes_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE,
  ADD CONSTRAINT `cita_antecedentes_ibfk_2` FOREIGN KEY (`idAntecedente`) REFERENCES `antecedentes` (`idAntecedente`);

--
-- Filtros para la tabla `cita_anticonseptivos`
--
ALTER TABLE `cita_anticonseptivos`
  ADD CONSTRAINT `cita_anticonseptivos_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE,
  ADD CONSTRAINT `cita_anticonseptivos_ibfk_2` FOREIGN KEY (`idAnticonseptivo`) REFERENCES `anticonseptivos` (`idAnticonsep`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_blandos`
--
ALTER TABLE `cita_blandos`
  ADD CONSTRAINT `cita_blandos_ibfk_1` FOREIGN KEY (`idBlando`) REFERENCES `blandos` (`idBlando`),
  ADD CONSTRAINT `cita_blandos_ibfk_2` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_cuidados`
--
ALTER TABLE `cita_cuidados`
  ADD CONSTRAINT `cita_cuidados_ibfk_1` FOREIGN KEY (`idCuidado`) REFERENCES `cuidados` (`idCuidado`),
  ADD CONSTRAINT `cita_cuidados_ibfk_2` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_cuidadosF`
--
ALTER TABLE `cita_cuidadosF`
  ADD CONSTRAINT `cita_cuidadosf_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE,
  ADD CONSTRAINT `cita_cuidadosf_ibfk_2` FOREIGN KEY (`idCuidado`) REFERENCES `cuidados` (`idCuidado`);

--
-- Filtros para la tabla `cita_duros`
--
ALTER TABLE `cita_duros`
  ADD CONSTRAINT `cita_duros_ibfk_1` FOREIGN KEY (`idDuro`) REFERENCES `duros` (`idDuro`),
  ADD CONSTRAINT `cita_duros_ibfk_2` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_habitos`
--
ALTER TABLE `cita_habitos`
  ADD CONSTRAINT `cita_habitos_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE,
  ADD CONSTRAINT `cita_habitos_ibfk_2` FOREIGN KEY (`idHabito`) REFERENCES `habitos` (`idHabito`);

--
-- Filtros para la tabla `cita_habitosF`
--
ALTER TABLE `cita_habitosF`
  ADD CONSTRAINT `cita_habitosf_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE,
  ADD CONSTRAINT `cita_habitosf_ibfk_2` FOREIGN KEY (`idHabito`) REFERENCES `habitos` (`idHabito`);

--
-- Filtros para la tabla `cita_obcervaciones`
--
ALTER TABLE `cita_obcervaciones`
  ADD CONSTRAINT `cita_obcervaciones_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_oclusion`
--
ALTER TABLE `cita_oclusion`
  ADD CONSTRAINT `cita_oclusion_ibfk_1` FOREIGN KEY (`idOclusion`) REFERENCES `oclusion` (`idOclusion`),
  ADD CONSTRAINT `cita_oclusion_ibfk_2` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE;

--
-- Filtros para la tabla `cita_rx`
--
ALTER TABLE `cita_rx`
  ADD CONSTRAINT `cita_rx_ibfk_1` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE,
  ADD CONSTRAINT `cita_rx_ibfk_2` FOREIGN KEY (`idRx`) REFERENCES `rx` (`idRx`);

--
-- Filtros para la tabla `datosMedico`
--
ALTER TABLE `datosMedico`
  ADD CONSTRAINT `datosmedico_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `datosCliente` (`idCliente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `dientes_padecimiento`
--
ALTER TABLE `dientes_padecimiento`
  ADD CONSTRAINT `dientes_padecimiento_ibfk_1` FOREIGN KEY (`idPadecimiento`) REFERENCES `padecimiento` (`idPadecimiento`),
  ADD CONSTRAINT `dientes_padecimiento_ibfk_2` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE,
  ADD CONSTRAINT `dientes_padecimiento_ibfk_3` FOREIGN KEY (`idDiente`) REFERENCES `dientes` (`idDiente`);

--
-- Filtros para la tabla `tratamiento_dientes`
--
ALTER TABLE `tratamiento_dientes`
  ADD CONSTRAINT `tratamiento_dientes_ibfk_1` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`idTratamiento`),
  ADD CONSTRAINT `tratamiento_dientes_ibfk_2` FOREIGN KEY (`idDiente`) REFERENCES `dientes` (`idDiente`),
  ADD CONSTRAINT `tratamiento_dientes_ibfk_3` FOREIGN KEY (`folio`) REFERENCES `citas` (`folio`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
