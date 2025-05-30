-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: lant_de_librarii
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `carte_librarie`
--

DROP TABLE IF EXISTS `carte_librarie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carte_librarie` (
  `id_relatie` int NOT NULL AUTO_INCREMENT,
  `id_carte` int DEFAULT NULL,
  `id_librarie` int DEFAULT NULL,
  PRIMARY KEY (`id_relatie`),
  KEY `id_carte` (`id_carte`),
  KEY `id_librarie` (`id_librarie`),
  CONSTRAINT `id_carte` FOREIGN KEY (`id_carte`) REFERENCES `carti` (`id`),
  CONSTRAINT `id_librarie` FOREIGN KEY (`id_librarie`) REFERENCES `librarii` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carte_librarie`
--

LOCK TABLES `carte_librarie` WRITE;
/*!40000 ALTER TABLE `carte_librarie` DISABLE KEYS */;
INSERT INTO `carte_librarie` VALUES (2,3,5),(4,11,5),(5,11,2),(6,10,1),(7,10,4),(8,9,4),(9,8,3),(10,7,3),(11,7,5),(13,6,2),(14,6,1),(15,6,4),(16,5,4),(17,5,3),(18,4,3),(19,4,5),(20,6,5),(21,13,5),(22,14,2);
/*!40000 ALTER TABLE `carte_librarie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-24 12:20:02
