CREATE DATABASE  IF NOT EXISTS `aistos_serre` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `aistos_serre`;
-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: aistos_serre
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `frequence`
--

DROP TABLE IF EXISTS `frequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frequence` (
  `id_frequence` int(11) NOT NULL,
  `label_frequence` varchar(255) NOT NULL,
  PRIMARY KEY (`id_frequence`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frequence`
--

LOCK TABLES `frequence` WRITE;
/*!40000 ALTER TABLE `frequence` DISABLE KEYS */;
INSERT INTO `frequence` VALUES (1,'quotidien'),(2,'tous les 2 jours');
/*!40000 ALTER TABLE `frequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historique`
--

DROP TABLE IF EXISTS `historique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historique` (
  `id_historique` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `debut_heure` time(3) NOT NULL,
  `fin_heure` time(3) NOT NULL,
  `id_serre` int(11) NOT NULL,
  `id_ligne_irrigation` int(11) NOT NULL,
  `id_statut` int(11) NOT NULL,
  PRIMARY KEY (`id_historique`),
  KEY `fk_historique_1_idx` (`id_serre`),
  KEY `fk_historique_2_idx` (`id_ligne_irrigation`),
  KEY `fk_historique_3_idx` (`id_statut`),
  CONSTRAINT `fk_historique_1` FOREIGN KEY (`id_serre`) REFERENCES `serre` (`id_serre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_historique_2` FOREIGN KEY (`id_ligne_irrigation`) REFERENCES `ligne_irrigation` (`id_ligne_irrigation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_historique_3` FOREIGN KEY (`id_statut`) REFERENCES `statut` (`id_statut`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historique`
--

LOCK TABLES `historique` WRITE;
/*!40000 ALTER TABLE `historique` DISABLE KEYS */;
INSERT INTO `historique` VALUES (33,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',1,1,1),(34,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',1,1,1),(35,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',2,2,1),(36,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',3,3,1),(37,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',4,4,1),(38,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',4,4,1),(39,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',6,6,1),(41,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',5,5,1),(42,'2018-02-06 15:35:10','15:35:10.000','00:00:00.000',6,6,1),(43,'2018-02-06 15:35:15','00:00:00.000','15:35:15.000',1,1,2),(44,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',1,1,2),(45,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',2,2,2),(46,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',3,3,2),(47,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',4,4,2),(48,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',4,4,2),(49,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',6,6,2),(51,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',5,5,2),(52,'2018-02-06 15:35:17','00:00:00.000','15:35:15.000',6,6,2),(53,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',1,1,1),(54,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',2,2,1),(55,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',3,3,1),(56,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',4,4,1),(57,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',4,4,1),(58,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',6,6,1),(60,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',5,5,1),(61,'2018-02-06 16:53:10','16:53:10.000','00:00:00.000',6,6,1),(62,'2018-02-06 16:53:20','00:00:00.000','16:53:20.000',1,1,2),(63,'2018-02-06 16:53:21','00:00:00.000','16:53:20.000',2,2,2),(64,'2018-02-06 16:53:21','00:00:00.000','16:53:20.000',3,3,2),(65,'2018-02-06 16:53:21','00:00:00.000','16:53:20.000',4,4,2),(66,'2018-02-06 16:53:24','00:00:00.000','16:53:20.000',4,4,2),(67,'2018-02-06 16:53:24','00:00:00.000','16:53:20.000',6,6,2),(69,'2018-02-06 16:53:24','00:00:00.000','16:53:20.000',5,5,2),(70,'2018-02-06 16:53:24','00:00:00.000','16:53:20.000',6,6,2),(71,'2018-02-06 18:37:10','18:37:10.000','00:00:00.000',6,6,1),(72,'2018-02-06 18:37:20','00:00:00.000','18:37:20.000',6,6,2),(73,'2018-02-07 11:34:10','11:34:10.000','00:00:00.000',6,6,1),(74,'2018-02-07 11:34:20','00:00:00.000','11:34:20.000',6,6,2),(75,'2018-02-07 16:25:10','16:25:10.000','00:00:00.000',6,6,1),(76,'2018-02-07 16:25:20','00:00:00.000','16:25:20.000',6,6,2),(77,'2018-02-07 18:05:00','18:05:00.000','00:00:00.000',5,5,1),(78,'2018-02-07 18:05:10','00:00:00.000','18:05:10.000',5,5,2),(79,'2018-02-09 21:39:17','16:53:10.000','16:53:20.000',1,1,999),(80,'2018-02-09 21:39:18','16:53:10.000','16:53:20.000',1,1,999),(81,'2018-02-12 15:31:07','16:53:10.000','15:31:06.000',1,1,999),(82,'2018-02-12 15:31:08','16:53:10.000','15:31:08.000',1,1,999),(83,'2018-02-12 15:31:09','16:53:10.000','15:31:09.000',1,1,999),(84,'2018-02-12 15:31:10','16:53:10.000','15:31:10.000',1,1,999),(85,'2018-02-13 11:43:35','16:53:10.000','11:43:35.000',1,1,999),(86,'2018-02-13 11:43:36','16:53:10.000','11:43:36.000',1,1,999),(87,'2018-02-13 11:43:37','16:53:10.000','11:43:37.000',1,1,999),(88,'2018-02-13 11:43:39','16:53:10.000','11:43:39.000',1,1,999),(89,'2018-02-13 11:43:40','16:53:10.000','11:43:40.000',1,1,999),(90,'2018-02-13 11:43:41','16:53:10.000','11:43:41.000',1,1,999),(91,'2018-02-13 11:43:42','16:53:10.000','11:43:42.000',1,1,999),(92,'2018-02-13 11:43:43','16:53:10.000','11:43:43.000',1,1,999),(93,'2018-02-13 11:43:44','16:53:10.000','11:43:44.000',1,1,999),(94,'2018-02-13 11:43:45','16:53:10.000','11:43:45.000',1,1,999);
/*!40000 ALTER TABLE `historique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ligne_irrigation`
--

DROP TABLE IF EXISTS `ligne_irrigation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ligne_irrigation` (
  `id_ligne_irrigation` int(11) NOT NULL AUTO_INCREMENT,
  `variete` varchar(255) DEFAULT NULL,
  `id_serre` int(11) NOT NULL,
  PRIMARY KEY (`id_ligne_irrigation`),
  KEY `fk_ligne_irrigation_1_idx` (`id_serre`),
  CONSTRAINT `fk_ligne_irrigation_1` FOREIGN KEY (`id_serre`) REFERENCES `serre` (`id_serre`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ligne_irrigation`
--

LOCK TABLES `ligne_irrigation` WRITE;
/*!40000 ALTER TABLE `ligne_irrigation` DISABLE KEYS */;
INSERT INTO `ligne_irrigation` VALUES (1,'kiwano',1),(2,'concombre',2),(3,'poivrons - aubergines',3),(4,'tomates',4),(5,'courge',5),(6,'courgette',6),(7,'légumes feuilles',7),(10,'test',1);
/*!40000 ALTER TABLE `ligne_irrigation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `machin`
--

DROP TABLE IF EXISTS `machin`;
/*!50001 DROP VIEW IF EXISTS `machin`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `machin` AS SELECT 
 1 AS `id_historique`,
 1 AS `id_serre`,
 1 AS `label_serre`,
 1 AS `id_ligne_irrigation`,
 1 AS `variete`,
 1 AS `id_statut`,
 1 AS `label_statut`,
 1 AS `date`,
 1 AS `debut_heure`,
 1 AS `fin_heure`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `planning`
--

DROP TABLE IF EXISTS `planning`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planning` (
  `id_planning` int(11) NOT NULL AUTO_INCREMENT,
  `debut_heure` time NOT NULL,
  `fin_heure` time NOT NULL,
  `id_frequence` int(11) NOT NULL,
  `id_ligne_irrigation` int(11) NOT NULL,
  PRIMARY KEY (`id_planning`),
  KEY `fk_arrosage_type1_idx` (`id_frequence`),
  KEY `fk_planning_ligne_irrigation1_idx` (`id_ligne_irrigation`),
  CONSTRAINT `fk_arrosage_type1` FOREIGN KEY (`id_frequence`) REFERENCES `frequence` (`id_frequence`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_planning_ligne_irrigation1` FOREIGN KEY (`id_ligne_irrigation`) REFERENCES `ligne_irrigation` (`id_ligne_irrigation`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planning`
--

LOCK TABLES `planning` WRITE;
/*!40000 ALTER TABLE `planning` DISABLE KEYS */;
INSERT INTO `planning` VALUES (1,'16:53:00','17:53:00',1,1),(2,'18:50:10','19:35:15',1,1),(3,'16:53:10','16:53:20',1,2),(4,'16:53:10','16:53:20',1,3),(5,'16:53:10','16:53:20',1,4),(6,'16:53:10','16:53:20',1,4),(7,'16:53:10','16:53:20',1,6),(10,'11:45:00','11:45:10',2,6),(11,'18:30:00','18:00:00',1,6),(12,'18:30:00','18:00:00',1,6),(13,'18:30:00','18:00:00',1,6),(14,'18:30:00','18:00:00',1,6);
/*!40000 ALTER TABLE `planning` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serre`
--

DROP TABLE IF EXISTS `serre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serre` (
  `id_serre` int(11) NOT NULL AUTO_INCREMENT,
  `label_serre` varchar(255) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_serre`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serre`
--

LOCK TABLES `serre` WRITE;
/*!40000 ALTER TABLE `serre` DISABLE KEYS */;
INSERT INTO `serre` VALUES (1,'petite serre 1',NULL),(2,'petite serre 2',NULL),(3,'serre 1',NULL),(4,'serre 2',NULL),(5,'parcelle 1',NULL),(6,'parcelle 2',NULL),(7,'parcelle 3','extérieur');
/*!40000 ALTER TABLE `serre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statut`
--

DROP TABLE IF EXISTS `statut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statut` (
  `id_statut` int(11) NOT NULL,
  `label_statut` varchar(255) NOT NULL,
  PRIMARY KEY (`id_statut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statut`
--

LOCK TABLES `statut` WRITE;
/*!40000 ALTER TABLE `statut` DISABLE KEYS */;
INSERT INTO `statut` VALUES (1,'en cours'),(2,'termine'),(999,'probleme');
/*!40000 ALTER TABLE `statut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `testleftJoin`
--

DROP TABLE IF EXISTS `testleftJoin`;
/*!50001 DROP VIEW IF EXISTS `testleftJoin`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `testleftJoin` AS SELECT 
 1 AS `id_ligne_irrigation`,
 1 AS `variete`,
 1 AS `id_planning`,
 1 AS `debut_heure`,
 1 AS `fin_heure`,
 1 AS `id_frequence`,
 1 AS `label_frequence`,
 1 AS `id_serre`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'aistos_serre'
--

--
-- Final view structure for view `machin`
--

/*!50001 DROP VIEW IF EXISTS `machin`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `machin` AS select `historique`.`id_historique` AS `id_historique`,`historique`.`id_serre` AS `id_serre`,`serre`.`label_serre` AS `label_serre`,`historique`.`id_ligne_irrigation` AS `id_ligne_irrigation`,`ligne_irrigation`.`variete` AS `variete`,`historique`.`id_statut` AS `id_statut`,`statut`.`label_statut` AS `label_statut`,`historique`.`date` AS `date`,`historique`.`debut_heure` AS `debut_heure`,`historique`.`fin_heure` AS `fin_heure` from (((`serre` join `historique`) join `statut`) join `ligne_irrigation`) where ((`serre`.`id_serre` = `historique`.`id_serre`) and (`historique`.`id_ligne_irrigation` = `ligne_irrigation`.`id_ligne_irrigation`) and (`historique`.`id_statut` = `statut`.`id_statut`) and (`historique`.`date` >= (curdate() - interval 30 day))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `testleftJoin`
--

/*!50001 DROP VIEW IF EXISTS `testleftJoin`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `testleftJoin` AS select `ligne_irrigation`.`id_ligne_irrigation` AS `id_ligne_irrigation`,`ligne_irrigation`.`variete` AS `variete`,`planning`.`id_planning` AS `id_planning`,`planning`.`debut_heure` AS `debut_heure`,`planning`.`fin_heure` AS `fin_heure`,`planning`.`id_frequence` AS `id_frequence`,`frequence`.`label_frequence` AS `label_frequence`,`ligne_irrigation`.`id_serre` AS `id_serre` from ((`ligne_irrigation` left join `planning` on((`ligne_irrigation`.`id_ligne_irrigation` = `planning`.`id_ligne_irrigation`))) left join `frequence` on((`planning`.`id_frequence` = `frequence`.`id_frequence`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-19 13:58:55
