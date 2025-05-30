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
-- Table structure for table `utilizatori`
--

DROP TABLE IF EXISTS `utilizatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizatori` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `salary` varchar(255) DEFAULT NULL,
  `id_librarie` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id_librarie`),
  CONSTRAINT `id` FOREIGN KEY (`id_librarie`) REFERENCES `librarii` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizatori`
--

LOCK TABLES `utilizatori` WRITE;
/*!40000 ALTER TABLE `utilizatori` DISABLE KEYS */;
INSERT INTO `utilizatori` VALUES (10,'catalin.ardelean','catalin128','MANAGER','5000',4),(11,'alex_martari@gmail.com','alexandru111','ANGAJAT','3000',2),(13,'larisa_filimon','123456','ANGAJAT','3500',5),(14,'andreea_pop','andreea','ANGAJAT','3000',2),(15,'mihai.marc','mihai','ADMINISTRATOR','8000',3),(22,'maria_elena','maria1234','ANGAJAT','3500',1),(23,'vlad_adrian','vlad1234','ANGAJAT','4500',4),(24,'irina_fodor','irina1234','ANGAJAT','2500',1),(25,'rebecca_sas','rebe1234','ANGAJAT','2000',3),(27,'cosmin.pop','cosmin1234','ANGAJAT','5000',5),(29,'cosmin_andrei','cosmin1234','ANGAJAT','4300',4);
/*!40000 ALTER TABLE `utilizatori` ENABLE KEYS */;
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
