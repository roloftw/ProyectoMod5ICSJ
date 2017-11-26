-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-11-2017 a las 17:13:09
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ventas`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `cambiar_stock` (IN `new_stock` INT(11), IN `pcod` BIGINT(20))  NO SQL
UPDATE producto SET stock_producto = new_stock WHERE cod_producto = pcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `desactivar_usuario` (IN `plogin` VARCHAR(100))  NO SQL
UPDATE usuario SET estado = "Inactivo" WHERE login = plogin$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_categoria` (IN `pnombre` VARCHAR(450), IN `pcod` INT(11), IN `pdescripcion` VARCHAR(450), IN `pgrupo` INT(11))  NO SQL
UPDATE categoria SET nombre_categoria = pnombre, descripcion_categoria = pdescripcion, grupo = pgrupo WHERE cod_categoria = pcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_cliente` (IN `pcod` INT(11), IN `prut` VARCHAR(20))  NO SQL
UPDATE cliente SET cod_cliente = pcod WHERE rut_cliente = prut$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_persona` (IN `pcod` INT(11), IN `pnombre` VARCHAR(255), IN `pdireccion` VARCHAR(255), IN `ptelefono` VARCHAR(12), IN `pemail` VARCHAR(255), IN `pcontacto` VARCHAR(20), IN `pcel` VARCHAR(10), IN `pcorreo` VARCHAR(20))  NO SQL
UPDATE persona SET nombre_persona = pnombre, direccion = pdireccion, telefono = ptelefono, email = pemail, contacto = pcontacto, cel_contacto = pcel, correo_contacto = pcorreo WHERE cod_persona = pcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_producto` (IN `pcod` BIGINT(20), IN `pnombre` VARCHAR(255), IN `pdescripcion` VARCHAR(255), IN `punidad` VARCHAR(20), IN `pprecio` BIGINT(20), IN `pprecioC` BIGINT(20), IN `pstock` INT(11), IN `pubicacion` VARCHAR(250), IN `pcod_categoria` INT(11))  NO SQL
UPDATE producto SET nombre_producto = pnombre, descripcion_producto = pdescripcion, unidad_producto = punidad, precio_producto = pprecio,  	precio_compra = pprecioC, stock_producto = pstock, ubicacion_bodega = pubicacion, cod_categoria = pcod_categoria WHERE cod_producto = pcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editar_usuario` (IN `pcod` INT(11), IN `prut` VARCHAR(20), IN `plogin` VARCHAR(45), IN `ppass` VARCHAR(45), IN `pacceso` VARCHAR(45))  NO SQL
UPDATE usuario SET cod_usuario = pcod, login = plogin, contrasena = ppass, acceso = pacceso WHERE rut_usuario = prut$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_cliente` (IN `pcod` INT(11))  NO SQL
DELETE FROM cliente WHERE cod_cliente = pcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_producto` (IN `pcod` BIGINT(20))  NO SQL
DELETE FROM producto WHERE cod_producto = pcod$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `elimina_categoria` (IN `cod_cate` INT)  BEGIN
     update categoria set borrado=1 where cod_categoria=cod_cate ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_categoria` (IN `cate` VARCHAR(255), IN `grupo` INT)  BEGIN
	select cod_categoria,nombre_categoria,descripcion_categoria  from categoria where cod_categoria=cate and grupo=grupo;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_cliente` (IN `clien` VARCHAR(255))  BEGIN
	select * from cliente CL
	INNER JOIN persona P ON P.cod_persona=CL.cod_cliente
	where CL.cod_cliente=clien;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_detalle_venta` (IN `venta` VARCHAR(255))  BEGIN
	select * from detalle_venta DV 
	INNER JOIN producto P ON P.cod_producto = DV.cod_producto
	where DV.cod_venta=venta;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_producto` (IN `prod` VARCHAR(255))  BEGIN
	select * from producto P 
	LEFT JOIN categoria C ON C.cod_categoria = P.cod_categoria
	where P.cod_producto=prod;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_venta` (IN `vent` VARCHAR(255))  BEGIN
	select * from venta where cod_venta=vent;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_categoria` (IN `codigo` INT, IN `nombre` VARCHAR(150), IN `descripcion` VARCHAR(255), IN `grupo` INT)  begin
	insert into categoria (cod_categoria,nombre_categoria,descripcion_categoria,grupo,borrado) values (codigo,nombre, descripcion, grupo,0);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_cliente` (IN `codigo` VARCHAR(150), IN `rut` VARCHAR(100))  begin
	insert into cliente (cod_cliente,rut_cliente) values (codigo,rut);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_persona` (IN `codigo` VARCHAR(150), IN `dir` VARCHAR(100), IN `tele` VARCHAR(100), IN `email` VARCHAR(100), IN `contac` VARCHAR(100), IN `cel_contac` VARCHAR(100), IN `email_contac` VARCHAR(100), IN `nombre` VARCHAR(100))  begin
	insert into persona (cod_persona,nombre_persona,direccion,telefono,email,contacto,cel_contacto,correo_contacto) 
    values              (codigo,nombre,direccion,telefono,email,contacto,cel_contacto,correo_contacto);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_producto` (IN `pcod` BIGINT(20), IN `pnombre` VARCHAR(255), IN `pdescripcion` VARCHAR(255), IN `punidad` VARCHAR(20), IN `pprecio` BIGINT(20), IN `pprecioC` BIGINT(20), IN `pstock` INT(11), IN `pubicacion` VARCHAR(250), IN `pcod_categoria` INT(11))  NO SQL
INSERT INTO producto(cod_producto, nombre_producto, descripcion_producto, unidad_producto, precio_producto, precio_compra, stock_producto, ubicacion_bodega, cod_categoria) VALUES (pcod, pnombre, pdescripcion, punidad, pprecio, pprecioC, pstock, pubicacion, pcod_categoria)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_proveedor` (IN `codigo` VARCHAR(150), IN `rut` VARCHAR(100))  begin
	insert into proveedor (cod_proveedor,rut_proveedor) values (codigo,rut);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_usuario` (IN `rut` VARCHAR(100), IN `login` VARCHAR(100), IN `pass` VARCHAR(100), IN `acceso` VARCHAR(100))  insert into usuario(rut_usuario,login,contrasena,estado,acceso,cod_tipo) values(rut,login,pass,"Activo",acceso,1)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_venta` (IN `pcod` INT(11), IN `pfecha` DATE, IN `ptotal` BIGINT(20), IN `pcodUsuario` INT(11), IN `pcodCliente` INT(11), IN `ptipo` VARCHAR(10), IN `pnumFactura` BIGINT(20), IN `ppago` BIGINT(20), IN `pdescuento` INT(11))  NO SQL
INSERT INTO venta(cod_venta, fecha_venta, total_venta, cod_usuarioFK, cod_clienteFK, tipo_comprobante,  	num_factura, pago, descuento) VALUES (pcod, pfecha, ptotal, pcodUsuario, pcodCliente, ptipo, pnumFactura, ppago, pdescuento)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `purge_usuario` (IN `plogin` VARCHAR(20))  NO SQL
DELETE FROM usuario WHERE login = plogin$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `registro_historial` (IN `pcod` INT(11), IN `pcodProducto` BIGINT(20), IN `pcodUsuario` INT(11), IN `pdescripcion` VARCHAR(200), IN `preferencia` VARCHAR(100), IN `pcantidad` INT(11), IN `pfecha` DATE)  NO SQL
INSERT INTO historial(cod_historial, cod_productoFK1, cod_usuarioFK1, descripcion, referencia, cantidad, fecha) VALUES (pcod, pcodProducto, pcodUsuario, pdescripcion, preferencia, pcantidad, pfecha)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `tipo_acceso` (IN `longi` VARCHAR(50))  NO SQL
SELECT acceso FROM usuario where login = longi$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `todos_categoria` (IN `grupo` INT)  BEGIN
	select cod_categoria,nombre_categoria,descripcion_categoria from categoria where grupo=grupo;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `nombre_categoria` varchar(450) NOT NULL,
  `cod_categoria` int(11) NOT NULL,
  `descripcion_categoria` varchar(450) NOT NULL,
  `grupo` int(11) NOT NULL,
  `borrado` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`nombre_categoria`, `cod_categoria`, `descripcion_categoria`, `grupo`, `borrado`) VALUES
('Categoria 1', 1, 'Descripcion de la categoria', 1, b'0'),
('Los permisos eran', 12, 'Profe', 1, b'1'),
('panza', 13, 'Sanche', 1, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `cod_cliente` int(11) NOT NULL,
  `rut_cliente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cod_cliente`, `rut_cliente`) VALUES
(1, '787485-K');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

CREATE TABLE `detalle_venta` (
  `cod_detalle` int(11) NOT NULL,
  `cantidad_detalle` int(11) NOT NULL,
  `cod_producto` bigint(20) NOT NULL,
  `precio_producto` bigint(20) NOT NULL,
  `cod_venta` int(11) NOT NULL,
  `subtotal` bigint(20) NOT NULL,
  `subPrecioCompra` bigint(20) NOT NULL,
  `precio_compra` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `cod_historial` int(11) NOT NULL,
  `cod_productoFK1` bigint(20) NOT NULL,
  `cod_usuarioFK1` int(11) NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `referencia` varchar(100) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `cod_persona` int(11) NOT NULL,
  `nombre_persona` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `contacto` varchar(20) DEFAULT NULL,
  `cel_contacto` varchar(10) DEFAULT NULL,
  `correo_contacto` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`cod_persona`, `nombre_persona`, `direccion`, `telefono`, `email`, `contacto`, `cel_contacto`, `correo_contacto`) VALUES
(1, 'Carlos Villarroel', 'El Romeral 1234', '123456', 'carloscinco@gmail.com', 'Contacto 1', '955565643', 'carlos5@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `cod_producto` bigint(20) NOT NULL,
  `nombre_producto` varchar(255) NOT NULL,
  `descripcion_producto` varchar(255) DEFAULT NULL,
  `unidad_producto` varchar(20) NOT NULL,
  `precio_producto` bigint(20) NOT NULL,
  `precio_compra` bigint(20) NOT NULL,
  `stock_producto` int(11) NOT NULL,
  `ubicacion_bodega` varchar(250) DEFAULT NULL,
  `cod_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`cod_producto`, `nombre_producto`, `descripcion_producto`, `unidad_producto`, `precio_producto`, `precio_compra`, `stock_producto`, `ubicacion_bodega`, `cod_categoria`) VALUES
(1, '1', '11', '1', 1, 1, 1, '1', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productoescaneado`
--

CREATE TABLE `productoescaneado` (
  `cod_producto` bigint(20) NOT NULL,
  `nombre` varchar(450) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productostock`
--

CREATE TABLE `productostock` (
  `cod_producto` bigint(20) NOT NULL,
  `nombre_producto` varchar(450) NOT NULL,
  `descripcion_producto` varchar(450) DEFAULT NULL,
  `unidad_producto` varchar(450) DEFAULT NULL,
  `precio_producto` bigint(20) NOT NULL,
  `precio_compra` bigint(20) NOT NULL,
  `stock_producto` int(11) NOT NULL,
  `fecha_stock` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `cod_proveedor` int(11) NOT NULL,
  `rut_proveedor` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `cod_usuario` int(11) NOT NULL,
  `descripcion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cod_usuario` int(100) NOT NULL,
  `rut_usuario` varchar(20) NOT NULL,
  `login` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `estado` varchar(8) NOT NULL,
  `acceso` varchar(15) NOT NULL,
  `cod_tipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cod_usuario`, `rut_usuario`, `login`, `contrasena`, `estado`, `acceso`, `cod_tipo`) VALUES
(1, '11111111-1', 'admin', 'admin', 'Inactivo', 'Administrador', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `cod_venta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `total_venta` bigint(20) NOT NULL,
  `cod_usuarioFK` int(11) NOT NULL,
  `cod_clienteFK` int(11) NOT NULL,
  `tipo_comprobante` varchar(10) NOT NULL,
  `num_factura` bigint(20) DEFAULT NULL,
  `pago` bigint(20) NOT NULL,
  `descuento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`cod_categoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cod_cliente`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cod_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `cod_usuario` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
