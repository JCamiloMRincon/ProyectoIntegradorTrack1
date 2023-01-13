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
-- Table structure for table `caracteristica`
--

DROP TABLE IF EXISTS `caracteristica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caracteristica` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `urlicono` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracteristica`
--

LOCK TABLES `caracteristica` WRITE;
/*!40000 ALTER TABLE `caracteristica` DISABLE KEYS */;
INSERT INTO `caracteristica` VALUES (1,'Wifi','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/atomoWifi.svg'),(2,'Bañera','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/bath.png'),(3,'Cocina','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/atomoKitchen.svg'),(4,'Vista a las montañas','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/mountain.png'),(5,'Vista al bosque','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/trees.png'),(6,'Aire acondicionado de ventana','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/atomoAir3.svg'),(7,'Ascensor','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/lift.png'),(8,'Secadora','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/dryer.png'),(9,'Zona de trabajo','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/meeting.png'),(10,'Estacionamiento gratuito en la calle','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/parking.png'),(11,'Caracteristica de prueba','Icono de prueba'),(12,'Estacionamiento gratuito en la calle','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/parking.png'),(13,'Estacionamiento gratuito en la calle','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/parking.png'),(14,'Estacionamiento gratuito en la calle','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/parking.png'),(15,'Estacionamiento gratuito en la calle','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/FeaturesIcons/parking.png');
/*!40000 ALTER TABLE `caracteristica` ENABLE KEYS */;
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

-- Dump completed on 2022-12-16 15:09:15
