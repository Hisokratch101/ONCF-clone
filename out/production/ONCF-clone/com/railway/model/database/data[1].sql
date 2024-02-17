-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: oncf
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrateur` (
  `id` int NOT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `motDePasse` varchar(45) DEFAULT NULL,
  `trajets` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrateur`
--

LOCK TABLES `administrateur` WRITE;
/*!40000 ALTER TABLE `administrateur` DISABLE KEYS */;
/*!40000 ALTER TABLE `administrateur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `billet`
--

DROP TABLE IF EXISTS `billet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billet` (
  `id` int NOT NULL,
  `trajet` int NOT NULL,
  `voyageur` int NOT NULL,
  `prix` int DEFAULT NULL,
  PRIMARY KEY (`id`,`trajet`,`voyageur`),
  KEY `id_idx` (`voyageur`),
  KEY `id___idx` (`trajet`),
  CONSTRAINT `id` FOREIGN KEY (`voyageur`) REFERENCES `voyageur` (`id`),
  CONSTRAINT `idTrajets` FOREIGN KEY (`trajet`) REFERENCES `trajets` (`idTrajets`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billet`
--

LOCK TABLES `billet` WRITE;
/*!40000 ALTER TABLE `billet` DISABLE KEYS */;
INSERT INTO `billet` VALUES (1,4,1,12);
/*!40000 ALTER TABLE `billet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartedereduction`
--

DROP TABLE IF EXISTS `cartedereduction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartedereduction` (
  `id` int NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `reduction` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartedereduction`
--

LOCK TABLES `cartedereduction` WRITE;
/*!40000 ALTER TABLE `cartedereduction` DISABLE KEYS */;
INSERT INTO `cartedereduction` VALUES (1,'SMART\' NAVETTE',20),(2,'SMART\' NAVETTE',35),(3,'Carte Senior',15),(4,'Carte Jeune',15),(5,'Carte Attalib',30),(6,'Carte 10’ZEN',10);
/*!40000 ALTER TABLE `cartedereduction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trajets`
--

DROP TABLE IF EXISTS `trajets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trajets` (
  `idTrajets` int NOT NULL,
  `depart` varchar(45) DEFAULT NULL,
  `arriver` varchar(45) DEFAULT NULL,
  `dateDepart` time DEFAULT NULL,
  `dateArrivee` time DEFAULT NULL,
  `prix` int DEFAULT NULL,
  PRIMARY KEY (`idTrajets`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trajets`
--

LOCK TABLES `trajets` WRITE;
/*!40000 ALTER TABLE `trajets` DISABLE KEYS */;
INSERT INTO `trajets` VALUES (1,'MARRAKECH','FES','15:50:00','22:20:00',234),(2,'MARRAKECH','FES','06:50:00','13:20:00',195),(3,'FES','MARRAKECH','11:40:00','18:14:00',195),(4,'CASA VOYAGEURS','TANGER','08:00:00','10:10:00',224),(5,'CASA VOYAGEURS','TANGER','14:00:00','16:10:00',224),(6,'TANGER','CASA VOYAGEURS','09:00:00','11:10:00',224),(7,'TANGER','CASA VOYAGEURS','16:00:00','18:10:00',224),(8,'CASA PORT','KENITRA','10:10:00','11:51:00',55),(9,'KENITRA','CASA PORT','12:10:00','13:51:00',55),(10,'RABAT AGDAL','SETTAT','10:40:00','12:30:00',77),(11,'SETTAT','RABAT AGDAL','12:40:00','14:30:00',77),(12,'OUJDA','FES','11:05:00','17:00:00',105),(13,'FES','OUJDA','08:05:00','14:00:00',105),(14,'BENGUERIR','SAFI','11:55:00','14:00:00',29),(15,'SAFI','BENGUERIR','13:00:00','14:05:00',29),(16,'EL JADIDA','CASA PORT ','07:30:00','09:04:00',37),(17,'CASA PORT','EL JADIDA','10:00:00','12:34:00',37),(18,'KHOURIBGA','CASA VOYAGEURS','07:35:00','10:18:00',29),(19,'CASA VOYAGEURS','KHOURIBGA','10:35:00','13:18:00',29),(20,'RABAT AGDAL','NADOR VILLE','06:31:00','16:11:00',99);
/*!40000 ALTER TABLE `trajets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voyageur`
--

DROP TABLE IF EXISTS `voyageur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voyageur` (
  `id` int NOT NULL,
  `nomComplet` varchar(45) DEFAULT NULL,
  `carteDeReduction` int DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `motDePasse` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cartevoy_idx` (`carteDeReduction`),
  KEY `voy_idx` (`id`),
  CONSTRAINT `cartevoy` FOREIGN KEY (`carteDeReduction`) REFERENCES `cartedereduction` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voyageur`
--

LOCK TABLES `voyageur` WRITE;
/*!40000 ALTER TABLE `voyageur` DISABLE KEYS */;
INSERT INTO `voyageur` VALUES (1,'KONAMI',4,'EMAIL','ROOT');
/*!40000 ALTER TABLE `voyageur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-17  9:31:30
