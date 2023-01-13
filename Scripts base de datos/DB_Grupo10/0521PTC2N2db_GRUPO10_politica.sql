CREATE DATABASE  IF NOT EXISTS `0521PTC2N2db_GRUPO10` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `0521PTC2N2db_GRUPO10`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: db-restore.cnyqegjgetrv.us-east-2.rds.amazonaws.com    Database: 0521PTC2N2db_GRUPO10
-- ------------------------------------------------------
-- Server version	8.0.23

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Table structure for table `politica`
--

DROP TABLE IF EXISTS `politica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `politica` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `tipo_politica_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tipo_politica_idx` (`tipo_politica_id`),
  CONSTRAINT `tipo_politica` FOREIGN KEY (`tipo_politica_id`) REFERENCES `tipo_politica` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `politica`
--

LOCK TABLES `politica` WRITE;
/*!40000 ALTER TABLE `politica` DISABLE KEYS */;
INSERT INTO `politica` VALUES (1,'Check-in: De 15:00 a 20:00',1),(2,'Check-out: 11:00',1),(3,'Check-in sin restricción de horario con personal del edificio',1),(4,'No se permiten fiestas ni eventos',1),(6,'Apto para fumadores',1),(7,'Esta reserva no es reembolsable.',2),(8,'Cámara de seguridad/dispositivo de grabación',3),(9,'Detector de monóxido de carbono',3),(10,'Detector de humo',3),(11,'No apto para niños o bebés',1),(12,'Política de prueba',1),(13,'Política de prueba 2',1),(14,'Política de prueba 2',1),(17,'Check-in: De 15:00 a 20:00',1),(18,'Politica de prueba',1),(19,'Politica de prueba',1),(20,'Check-in: De 15:00 a 20:00',1),(21,'Politica de prueba',1),(22,'Politica de prueba',1),(23,'Politica de prueba',1),(24,'Politica de prueba',1),(25,'Check-in: De 15:00 a 20:00',1),(26,'Politica de prueba',1),(27,'Politica de prueba',1),(28,'Check-in: De 15:00 a 20:00',1),(29,'Politica de prueba',1),(30,'Politica de prueba',1),(31,'Check-in: De 15:00 a 20:00',1),(32,'Politica de prueba',1);
/*!40000 ALTER TABLE `politica` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-16 15:07:45
