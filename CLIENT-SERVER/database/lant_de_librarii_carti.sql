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
-- Table structure for table `carti`
--

DROP TABLE IF EXISTS `carti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titlu` varchar(255) DEFAULT NULL,
  `autor` varchar(255) DEFAULT NULL,
  `domeniu` varchar(255) DEFAULT NULL,
  `disponibilitate` varchar(255) DEFAULT NULL,
  `editura` varchar(255) DEFAULT NULL,
  `pret` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carti`
--

LOCK TABLES `carti` WRITE;
/*!40000 ALTER TABLE `carti` DISABLE KEYS */;
INSERT INTO `carti` VALUES (1,'Abc','Mihai','medicina','25','Mar','30'),(3,'Flori','Marius','biologie','120','Mar','40'),(4,'Animale','Marius','biologie','30','Pruna','50'),(5,'Copaci','Andreea','biologie','50','Star','45'),(6,'Munti','Maria','geografie','50','Star','50'),(7,'Podis','Maria','geografie','100','Pruna','50'),(8,'Rauri','Elena','geografie','90','Mar','55'),(9,'Lacuri','Elena','geografie','150','Pruna','30'),(10,'Campii','Elena','geografie','100','Star','40'),(11,'Plamani','Tudor','medicina','200','Star','80'),(12,'Stomac','Tudor','medicina','90','Pruna','55'),(13,'Ecuatii','Tudor','matematica','100','Mar','55'),(14,'Functii','Andrei','matematica','150','Mar','80'),(15,'Abecedar','Andrei','romana','500','ABC','25');
/*!40000 ALTER TABLE `carti` ENABLE KEYS */;
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
