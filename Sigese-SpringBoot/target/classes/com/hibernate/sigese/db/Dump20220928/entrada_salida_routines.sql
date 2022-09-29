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
-- Temporary view structure for view `horas_trabajadas`
--

DROP TABLE IF EXISTS `horas_trabajadas`;
/*!50001 DROP VIEW IF EXISTS `horas_trabajadas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `horas_trabajadas` AS SELECT 
 1 AS `id`,
 1 AS `tipo_documento`,
 1 AS `identificacion`,
 1 AS `primer_nombre`,
 1 AS `segundo_nombre`,
 1 AS `primer_apellido`,
 1 AS `segundo_apellido`,
 1 AS `fecha_registro`,
 1 AS `horas_trabajadas`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `horas_trabajadas`
--

/*!50001 DROP VIEW IF EXISTS `horas_trabajadas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `horas_trabajadas` AS select `e`.`id` AS `id`,`e`.`tipo_documento` AS `tipo_documento`,`e`.`identificacion` AS `identificacion`,`e`.`primer_nombre` AS `primer_nombre`,`e`.`segundo_nombre` AS `segundo_nombre`,`e`.`primer_apellido` AS `primer_apellido`,`e`.`segundo_apellido` AS `segundo_apellido`,`et`.`created` AS `fecha_registro`,(time_to_sec(timediff(`et`.`fecha_salida`,`et`.`fecha_entrada`)) / 3600) AS `horas_trabajadas` from (`empleados_tiempos` `et` join `empleados` `e` on((`e`.`id` = `et`.`id_empleado`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Dumping routines for database 'entrada_salida'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-28 19:54:07
