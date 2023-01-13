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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contrasenia` varchar(255) NOT NULL,
  `ciudad_id` int NOT NULL,
  `rol_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ciudad_id_idx` (`ciudad_id`),
  KEY `rol_id_idx` (`rol_id`),
  CONSTRAINT `ciudad_usuario` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`),
  CONSTRAINT `rol_id` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Marisabel','Albarracin','marisabel@albarracin.com','1234567',1,1),(2,'Camilo','Mortigo','camilo@mortigo.com','$2a$10$lD/Dtdr1Nyh4i./5LLvAZ.Fj9fGDP0mS4NpJrtvy7TOGI56qHpwlK',1,1),(3,'Brenda','Montero','brenda@montero.com','$2a$10$c9VurOZzg5rZxkWEERR.IOD0EFhyJMqffiTs.VP9Psd68A6eedtFW',1,2),(4,'Juan','Luque','juan@luque.com','$2a$10$CnnqvKWlyHoo.TsypntlquVNBxJ8cDdQ6VHQJAFMcypyILLx0Rxl2',1,2),(5,'test','test3','test@gmail.com','$2a$10$4duylOdQNoG95qrDMnmXR.SGMP9OdtDM9JHPDP2M05WFfg06VnNd2',1,2),(6,'test','test','test@gmail.com','$2a$10$7lQGTRcIeZRX6ssjHQdfqePTG7tDOWyKXyjmo8hhT3zLuJdK3YLze',1,2),(7,'test','test','432432','$2a$10$K0LMg76HqpxSvlazsLOH/uW1R.rMPfBQqwWE0.3qOBP98sJYX/m9G',1,2),(8,'t','t','test','$2a$10$1yH8X7Kx/e.ZsPYJcq1BSeJH6XAUreC0X9nL85QyCRX7b70Fsgaee',1,2),(9,'t','t','test@gmail.com','$2a$10$mZkl8GKsQrB4xeBCtyywOutZzfmdQNXzGt7MMzHels/ShG8viI1S.',1,2),(10,'t','t','test@gmail.com','$2a$10$jRP0BS.GveNyR67/OmnJWud0z24BrgQ79wbNMgVYhQkIk1Hb4ePyO',1,2),(11,'t','t','test@gmail.com','$2a$10$1KxsFfxNVb6Z9g82QGuhOu9GrcaTQWIDBiWDbI7I36.INQv/Pkf/6',1,2),(12,'t','t','test@gmail.com','$2a$10$QalYTJp79pCIeUZs.O2UFeO.1aSTpc.8.eoUzbbSJ7w0rvgJBCKua',1,2),(13,'christiam','alejandro','christiamchivico@gmail.com','$2a$10$LFVLDM7KV3OTKdHFSwiRl.cnTpe4j.CM6zvHCblUU77g2pNzdmM3S',1,2),(14,'Nicolas','Romero','nicolas@romero.com','$2a$10$WiToQEcSq25qLIYr0ClLY..t0q0V.x.dIi0PxM3wDW1gkckQ2DQvC',1,2),(15,'christiam','chivico','christiam@gmail.com','$2a$10$7aAj1ix5.vzRO1l7QJi1P.5SFxMSlgC2eErL2w8BVuzXgfCtyHn/u',1,2),(16,'tes','test','test@gmail.com','$2a$10$BKZ0URQ2Fs.cxZX5XZf9v.7uwfz2CpybT7/b1QQ2MkRb88ghQ27rG',1,2),(17,'test','test','test@gmail.com','$2a$10$9uv2ATPIqnZVqPc6VwXpxukegz7Op35A9YHjv2IvDBJIGO4GkzSJq',1,2),(18,'t','3','test@gmail.com','$2a$10$gYvIE31RnpsLm.CaI54oNeFunas10XGDN1p3HzcpCVJ12Vs1hjsw2',1,2),(19,'3','3','test@gmail.com','$2a$10$L9XtHhMtAUp4BFoeYvNI5uNkU41HhGQEpWxx.6ikpxDMn9PCzi1yK',1,2),(20,'d','d','test@gmail.com','$2a$10$fa.hGjAkjk27578fpDNHuOA4skjdvcmZo2eONUuQd0Npm4p282zsm',1,2),(21,'sfdsaf','fdasdfa','test@gmail.com','$2a$10$rmHRkP7FOgTtzPVNSBy/JeBl1ouQI3027.WKxI8DPn2j6JOYLIHZ2',1,2),(22,'dsafdsa','fdsadfsa','test@gmail.com','$2a$10$f4vIVUaAZREYFnybt6CBGuYX6dhZdgz6l9Je.rZsyKr/ccrQBq51q',1,2),(23,'jklsdjalk','jkljklj','test@gmail.com','$2a$10$BdaA6InXJD8giGkbI1D2ZOJ0mtbEo7gH4SkKxOnxPVuREgifR3dYW',1,2),(24,'fdsfdsafsa','fdsafdsafd','brenda@montero.com','$2a$10$g.7DTXlEsPZAPWO1s77n0O/A3w/VkD7Dc8eGrPv.xDVc2Aw6Ci8ou',1,2),(25,'fdsfdsafsa','fdsafdsafd','brenda@montero.com','$2a$10$2zeNxm6cphPRDp8pUOKewOaxfzCu9Eg3DSZoeLV0TwHSBXlCu/OES',1,2),(26,'fdsafdsa','fdsadfsa','brenda@montero.com','$2a$10$9DPN6/61q1C1HEsoz2Seb.9T/cfa9e85fM2BSKmhdF/ozLDYThn6y',1,2),(27,'fdsadfsa','fdsadfs','brenda@montero.com','$2a$10$XeWa/A6Lgyv9iCqUuTUqTeNgJkZG1Btf/ZDv7BNVpJCgYpPplWP7S',1,2),(28,'Prueba','Prueba Apellido','prueba@prueba.com','$2a$10$CWsaT557zuZynjEUC479wOOIC775uDBjuLv4Z2S669J6kWfLXlBUy',1,2),(29,'Brenda','Montero','bremonterosa@gmail.com','$2a$10$iBbQdzTUHSDSkEBS5eV8MOO95C2BHFNwAj2S8dCwEwfhfVAYtw046',1,2),(30,'','','ma@mail.com','$2a$10$iZoe3j4hS0Xos39Yq0nxPuI55w6TLI9igUIaerRa.zh6ej46wscaK',1,2),(31,'Maria','Perez','maria@perez.com','$2a$10$/uLvL4.KaqPv5edzqEBYFurJ598BYdLRpyfKqJRQCyVFfnlydT4Nq',1,2),(32,'Maria','Perez','maria@perez.com','$2a$10$LtJ/WW69FBPSi9iX1gL3Ju7ehhDuHtNkoc2lK5Ke11Mk2FNkhffQe',1,2),(33,'Maria','Perez','maria@perez.com','$2a$10$Oo5EflWIfLXIMYOdB1dzPOrnJrsS5OzwsVvRrB8BsJr8.tq0DeRpa',1,2),(34,'Brenda','Montero','brenda@montero.com','$2a$10$vL8bj8a7hdqgBR0ePAVdHu/KUeLC8.mOs/OB49mIkfIwC91cnQ9/y',1,2),(35,'jfjfjjf','gjjgj','brenda@montero.com','$2a$10$/DFcpZONv/SaL7Iw0MsQn.Ulcynr/5eGNDzMq8MkOWTwRGU8mdQ.u',1,2),(36,'pedro','perez','pedro@gmail.com','$2a$10$fGDBDV1LDPBoQ3oasAOejuTLzp5ukwDDKGLbQmhhlynq8xVPJ9UUe',1,2),(37,'pedro','perez','pedro@gmail.com','$2a$10$p7kzu7b2oUGcI0Xmt7A7Y.J1tYjl.9NdG9wtXhZqLqpjW9ma/iljq',1,2),(38,'brenda','montero','brenda@montero.com','$2a$10$J5HukUFtaTi6WbOUSV2hGegwRMRbTaaL0Cohs5lwhe8Uv9GKhGmyK',1,2),(39,'4324','4324','brenda@montero.com','$2a$10$knlLLXwxYiZLohkpuUeNU.ce/i3k6BdKTYL1pcomNnZyg5xUZdHKS',1,2),(40,'Pedro','Perez','pedro@gmail.com','$2a$10$ghb3JUCYZC.aRdlYYx/b0O.C6du/fpPZ.0.nQNyFGl4gQt7l2XAce',1,2),(41,'pedro','perez','pedro@gmail.com','$2a$10$qZUcTo6veYRry/gQHJWeTuUkc5k3b2RdAKFphFcXftL3Q9IL16W36',1,2),(42,'Natalia','Ortiz','natalia@ortiz.com','$2a$10$6BF2p8RZAzOP8rPzTF/oUe9Nh3.BStUYiT36yRkJJrcjo1Lq8XA8i',1,2),(43,'Pepito','Perez','pepito@perez.com','$2a$10$0EX5VQ0wk4VHqPRqSxmha.2rS24raSvhswcZS4pBZsgJu91pk/MRa',1,2),(44,'Juan','Rincón','juan@rincon.com','$2a$10$C43gyZwZHHA3o1kipBueu.Yps0IHRcaLYYWd4BjLXPR360EFTHpXS',1,2),(45,'nicolas','romero','nico@gmail.com','$2a$10$VBk7xWWK9RX/qXR.xKIHXuFDw3rytRtkWgSSM7A8.XhGtFJQsqKri',1,2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
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

-- Dump completed on 2022-12-16 15:08:00
