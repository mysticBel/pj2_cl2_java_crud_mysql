CREATE DATABASE  IF NOT EXISTS `bd_maza_maribel` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_maza_maribel`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_maza_maribel
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `tb_equipos`
--

DROP TABLE IF EXISTS `tb_equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_equipos` (
  `idequipo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idequipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_equipos`
--

LOCK TABLES `tb_equipos` WRITE;
/*!40000 ALTER TABLE `tb_equipos` DISABLE KEYS */;
INSERT INTO `tb_equipos` VALUES (1,'Peru'),(2,'Argentina'),(3,'Mexico');
/*!40000 ALTER TABLE `tb_equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_jugadores`
--

DROP TABLE IF EXISTS `tb_jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_jugadores` (
  `idjugador` int NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `sueldo` double DEFAULT NULL,
  `idequipo` int DEFAULT NULL,
  PRIMARY KEY (`idjugador`),
  KEY `fk_jugador_equipo1_idx` (`idequipo`),
  CONSTRAINT `fk_jugador_equipo1` FOREIGN KEY (`idequipo`) REFERENCES `tb_equipos` (`idequipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_jugadores`
--

LOCK TABLES `tb_jugadores` WRITE;
/*!40000 ALTER TABLE `tb_jugadores` DISABLE KEYS */;
INSERT INTO `tb_jugadores` VALUES (1,'Renato','Tapia','68854524','1995-07-28',8500,1),(2,'Pedro','Gallese','77522369','1995-05-23',7500,1),(3,'Bob','Esponja','15915995','2022-11-10',5000,3),(4,'Giovanni','Simeone','74156984','2022-11-10',8500,2),(5,'Leo','Messi','94156984','2022-11-09',9500,2);
/*!40000 ALTER TABLE `tb_jugadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_maza_maribel'
--

--
-- Dumping routines for database 'bd_maza_maribel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-10 14:45:31
