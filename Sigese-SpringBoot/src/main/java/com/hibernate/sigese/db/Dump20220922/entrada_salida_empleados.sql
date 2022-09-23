-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: entrada_salida
-- ------------------------------------------------------
-- Server version	5.7.37-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cargo_empleado` int(11) NOT NULL,
  `tipo_documento` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `identificacion` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `primer_nombre` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `segundo_nombre` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `primer_apellido` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `segundo_apellido` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `area_empleado` varchar(60) CHARACTER SET latin1 DEFAULT NULL,
  `estado_empleado` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cargo_idx` (`id_cargo_empleado`),
  CONSTRAINT `id_cargo` FOREIGN KEY (`id_cargo_empleado`) REFERENCES `cargos_empleados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Operativa','Inactivo'),(3,2,'Cédula de ciudadanía','1333311','Santiago','Fernando','Vera','Velasquez','Operativa','Activo'),(4,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Operativa','Activo'),(6,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Operativa','Activo'),(7,1,'Tarjeta de extranjería','1121871159','Edison','Fernando','Vera','Corredor','Operativa','Activo'),(8,1,'Tarjeta de extranjería','1121871159','Edison','Fernando','Vera','Corredor','Operativa','Activo'),(9,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Operativa','Activo'),(10,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Operativa','Activo'),(11,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Hseq','Activo'),(12,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Hseq','Activo'),(13,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Hseq','Activo'),(21,1,'Cédula de ciudadanía','1121871159','Edison','Fernando','Vera','Corredor','Hseq','Activo'),(22,3,'Cédula de ciudadanía','111217545','Javier','Fernando','Sanchez','Vargas','Hseq','Inactivo');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-22 21:16:50
