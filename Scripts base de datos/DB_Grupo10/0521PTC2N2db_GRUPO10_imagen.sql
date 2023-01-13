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
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `id` int NOT NULL AUTO_INCREMENT,
  `producto_id` int NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKckk7k36sck5o201icob6wkc2u` (`producto_id`),
  CONSTRAINT `FKckk7k36sck5o201icob6wkc2u` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
INSERT INTO `imagen` VALUES (1,1,'Habitación compartida 1 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-1-1.jpg'),(2,1,'Habitación compartida 1 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-1-2.jpg'),(3,1,'Habitación compartida 1 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-1-3.jpg'),(4,1,'Habitación compartida 1 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-1-4.jpg'),(5,1,'Habitación compartida 1 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-1-5.jpg'),(6,2,'Habitación compartida 2 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-2/compartida-2-1.jpg'),(7,2,'Habitación compartida 2 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-2-2.jpg'),(8,2,'Habitación compartida 2 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-2-3.jpg'),(9,2,'Habitación compartida 2 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-2-4.jpg'),(10,2,'Habitación compartida 2 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Hab-compartida/hab-compartida-1/compartida-2-5.jpg'),(11,3,'Cabaña 1 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-1/cabana-1-1.jpg'),(12,3,'Cabaña 1 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-1/cabana-1-2.jpg'),(13,3,'Cabaña 1 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-1/cabana-1-3.jpg'),(14,3,'Cabaña 1 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-1/cabana-1-4.jpg'),(15,3,'Cabaña 1 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-1/cabana-1-5.jpg'),(16,4,'Cabaña 2 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-2/cabana-2-1.jpg'),(17,4,'Cabaña 2 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-2/cabana-2-2.jpg'),(18,4,'Cabaña 2 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-2/cabana-2-3.jpg'),(19,4,'Cabaña 2 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-2/cabana-2-4.jpg'),(20,4,'Cabaña 2 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Cabana/Cabana-2/cabana-2-5.jpg'),(21,5,'Casa 1 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-1/casa-1-1.jpg'),(22,5,'Casa 1 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-1/casa-1-2.jpg'),(23,5,'Casa 1 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-1/casa-1-3.jpg'),(24,5,'Casa 1 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-1/casa-1-4.jpg'),(25,5,'Casa 1 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-1/casa-1-5.jpg'),(26,6,'Casa 2 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-2/casa-2-1.jpg'),(27,6,'Casa 2 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-2/casa-2-2.jpg'),(28,6,'Casa 2 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-2/casa-2-3.jpg'),(29,6,'Casa 2 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-2/casa-2-4.jpg'),(30,6,'Casa 2 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Casa/Casa-2/casa-2-5.jpg'),(31,7,'Departamento 1 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-1/departamento-1-1.jpg'),(32,7,'Departamento 1 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-1/departamento-1-2.jpg'),(33,7,'Departamento 1 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-1/departamento-1-3.jpg'),(34,7,'Departamento 1 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-1/departamento-1-4.jpg'),(35,7,'Departamento 1 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-1/departamento-1-5.jpg'),(36,8,'Departamento 2 imagen 1','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-2/departamento-2-1.jpg'),(37,8,'Departamento 2 imagen 2','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-2/departamento-2-2.jpg'),(38,8,'Departamento 2 imagen 3','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-2/departamento-2-3.jpg'),(39,8,'Departamento 2 imagen 4','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-2/departamento-2-4.jpg'),(40,8,'Departamento 2 imagen 5','https://0521ptc2n2-grupo10-front-images.s3.us-east-2.amazonaws.com/Imagenes/Departamento/Departamento-2/departamento-2-5.jpg'),(80,26,'Casa_Imagen_Producto_26','https://images.pexels.com/photos/4916699/pexels-photo-4916699.jpeg?auto=compress&cs=tinysrgb&w=600');
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
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

-- Dump completed on 2022-12-16 15:09:10
