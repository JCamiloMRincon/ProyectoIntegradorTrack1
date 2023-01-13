-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_prod
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `categoria_id` int NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `ciudad_id` int NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ciudad_id_idx` (`ciudad_id`),
  KEY `categoria_id_idx` (`categoria_id`),
  CONSTRAINT `categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  CONSTRAINT `ciudad_id` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Habitación en moderno edificio',1,'Av. Rivadavia 5000',1,'Dormitorio con cama Twin, armario y escritorio en casa remodelada, moderna y de ambientes amplios, que mezcla estética minimalista con una combinación de madera y hierro.',1),(2,'Habitación con vista a la ciudad',1,'Av. Sarmiento 700',2,'Es un ambiente fresco, soleado por la mañana, podrás tomar sol en una amplia terraza amplia. A media cuadra del tren, buses, y el icónico centro comercial Medellín Shopping. Zona de bares, cervecerías y restaurantes.',1),(3,'Hermosa cabaña en el bosque',2,'Av. Fluvial y Delta',6,'Cabaña con terminaciones de casa tradicional,excelente entorno arbolado,zona muy tranquila a sólo 4km de Piriapolis,playas espectaculares como San Francisco a 5 cuadras y la brava de Punta Colorada a 8 cuadras,también la agreste de Punta Negra a 2 km.',1),(4,'Cabaña romántica',2,'Plátanos 5100',7,'Ubicada sobre el arroyo, en un barrio tranquilo en contacto con la naturaleza pura, cuenta con un muelle propio ideal para pasar el día, disfrutar de una comida, o mirar las lanchas y los remeros pasar.',1),(5,'Moderno departamento cercano al centro',3,'Mercedes Funce 452',3,'Amplio departamento de 3 ambientes, con aire acondicionado nuevo. Excelentes medidas, con cocina y lavadero independientes. Recien pintado, piso totalmente plastificado.',1),(6,'Departamento en zona residencial',3,'Emilio Mitre 155',9,'Moderno departamento en zona residencial, ideal para parejas que buscan tranquilidad. Cercano a zona gastronómica y cine. Cuenta con 2 ambientes luminosos y silenciosos.',1),(7,'Espectacular casa familiar',4,'Caminos 1588',2,'Casa con combinación única entre acabados modernos y rústicos, combinados con lo mejor de la naturaleza. Ubicada a tan solo 300mts del puente Pizano. Cuenta con 2 salas, 4 dormitorios y un deck con jacuzzi.',1),(8,'Casa frente al mar',4,'Av. Costanera 15588',8,'Espectacular casa con vista al mar. Cuenta con 3 habitaciones, 2 baños, un living comedor y amplia cocina. Ideal para pasar las vacaciones, cercano a zona de cines y teatros.',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-04 18:17:49
