-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ifmlver3
-- ------------------------------------------------------
-- Server version	5.7.14-log

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
-- Table structure for table `annotation`
--

DROP TABLE IF EXISTS `annotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annotation` (
  `oid` int(11) NOT NULL,
  `confidence` int(11) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `marked` bit(1) DEFAULT NULL,
  `user_oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_annotation_user` (`user_oid`),
  CONSTRAINT `fk_annotation_user` FOREIGN KEY (`user_oid`) REFERENCES `user` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annotation`
--

LOCK TABLES `annotation` WRITE;
/*!40000 ALTER TABLE `annotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `annotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `annotationcampaign`
--

DROP TABLE IF EXISTS `annotationcampaign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annotationcampaign` (
  `oid` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `budget` double DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_annotationcampaign_user` (`user_oid`),
  CONSTRAINT `fk_annotationcampaign_user` FOREIGN KEY (`user_oid`) REFERENCES `user` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annotationcampaign`
--

LOCK TABLES `annotationcampaign` WRITE;
/*!40000 ALTER TABLE `annotationcampaign` DISABLE KEYS */;
INSERT INTO `annotationcampaign` VALUES (1,'Open',1000,'Google',2),(2,'Open',1000,'WebRatio',2);
/*!40000 ALTER TABLE `annotationcampaign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group` (
  `oid` int(11) NOT NULL,
  `groupname` varchar(255) DEFAULT NULL,
  `module_oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_group_module` (`module_oid`),
  CONSTRAINT `fk_group_module` FOREIGN KEY (`module_oid`) REFERENCES `module` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (1,'requester',1),(2,'worker',2);
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_module`
--

DROP TABLE IF EXISTS `group_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_module` (
  `group_oid` int(11) NOT NULL,
  `module_oid` int(11) NOT NULL,
  PRIMARY KEY (`group_oid`,`module_oid`),
  KEY `fk_group_module_group` (`group_oid`),
  KEY `fk_group_module_module` (`module_oid`),
  CONSTRAINT `fk_group_module_group` FOREIGN KEY (`group_oid`) REFERENCES `group` (`oid`),
  CONSTRAINT `fk_group_module_module` FOREIGN KEY (`module_oid`) REFERENCES `module` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_module`
--

LOCK TABLES `group_module` WRITE;
/*!40000 ALTER TABLE `group_module` DISABLE KEYS */;
INSERT INTO `group_module` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `group_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `oid` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `caption` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_annotation`
--

DROP TABLE IF EXISTS `item_annotation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_annotation` (
  `item_oid` int(11) NOT NULL,
  `annotation_oid` int(11) NOT NULL,
  PRIMARY KEY (`item_oid`,`annotation_oid`),
  KEY `fk_item_annotation_item` (`item_oid`),
  KEY `fk_item_annotation_annotation` (`annotation_oid`),
  CONSTRAINT `fk_item_annotation_annotation` FOREIGN KEY (`annotation_oid`) REFERENCES `annotation` (`oid`),
  CONSTRAINT `fk_item_annotation_item` FOREIGN KEY (`item_oid`) REFERENCES `item` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_annotation`
--

LOCK TABLES `item_annotation` WRITE;
/*!40000 ALTER TABLE `item_annotation` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_annotation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `module` (
  `oid` int(11) NOT NULL,
  `moduleid` varchar(255) DEFAULT NULL,
  `modulename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,'sv3','req_page'),(2,'sv2','work_page');
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `oid` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,'Data Mining'),(2,'Crypto'),(3,'Soft.Eng'),(4,'Hardware'),(5,'Web Science');
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `oid` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `reward` double DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `maximum_exec_time` time DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `annotationcampaign_oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_task_annotationcampaign` (`annotationcampaign_oid`),
  CONSTRAINT `fk_task_annotationcampaign` FOREIGN KEY (`annotationcampaign_oid`) REFERENCES `annotationcampaign` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_item`
--

DROP TABLE IF EXISTS `task_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_item` (
  `task_oid` int(11) NOT NULL,
  `item_oid` int(11) NOT NULL,
  PRIMARY KEY (`task_oid`,`item_oid`),
  KEY `fk_task_item_task` (`task_oid`),
  KEY `fk_task_item_item` (`item_oid`),
  CONSTRAINT `fk_task_item_item` FOREIGN KEY (`item_oid`) REFERENCES `item` (`oid`),
  CONSTRAINT `fk_task_item_task` FOREIGN KEY (`task_oid`) REFERENCES `task` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_item`
--

LOCK TABLES `task_item` WRITE;
/*!40000 ALTER TABLE `task_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_skill`
--

DROP TABLE IF EXISTS `task_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_skill` (
  `task_oid` int(11) NOT NULL,
  `skill_oid` int(11) NOT NULL,
  PRIMARY KEY (`task_oid`,`skill_oid`),
  KEY `fk_task_skill_task` (`task_oid`),
  KEY `fk_task_skill_skill` (`skill_oid`),
  CONSTRAINT `fk_task_skill_skill` FOREIGN KEY (`skill_oid`) REFERENCES `skill` (`oid`),
  CONSTRAINT `fk_task_skill_task` FOREIGN KEY (`task_oid`) REFERENCES `task` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_skill`
--

LOCK TABLES `task_skill` WRITE;
/*!40000 ALTER TABLE `task_skill` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `oid` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birth_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `piggy_bank` double DEFAULT NULL,
  `group_oid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `fk_user_group` (`group_oid`),
  CONSTRAINT `fk_user_group` FOREIGN KEY (`group_oid`) REFERENCES `group` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'work','work','work@work','2015-12-18 00:00:00','worker',0,0,2),(2,'req','req','req@req.com','2015-12-02 00:00:00','requester',0,0,1),(3,'req2','req2','req2','2016-09-01 00:00:00','req2',0,0,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_group`
--

DROP TABLE IF EXISTS `user_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_group` (
  `user_oid` int(11) NOT NULL,
  `group_oid` int(11) NOT NULL,
  PRIMARY KEY (`user_oid`,`group_oid`),
  KEY `fk_user_group_user` (`user_oid`),
  KEY `fk_user_group_group` (`group_oid`),
  CONSTRAINT `fk_user_group_group` FOREIGN KEY (`group_oid`) REFERENCES `group` (`oid`),
  CONSTRAINT `fk_user_group_user` FOREIGN KEY (`user_oid`) REFERENCES `user` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_group`
--

LOCK TABLES `user_group` WRITE;
/*!40000 ALTER TABLE `user_group` DISABLE KEYS */;
INSERT INTO `user_group` VALUES (1,2),(2,1),(3,1);
/*!40000 ALTER TABLE `user_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_skill`
--

DROP TABLE IF EXISTS `user_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_skill` (
  `user_oid` int(11) NOT NULL,
  `skill_oid` int(11) NOT NULL,
  PRIMARY KEY (`user_oid`,`skill_oid`),
  KEY `fk_user_skill_user` (`user_oid`),
  KEY `fk_user_skill_skill` (`skill_oid`),
  CONSTRAINT `fk_user_skill_skill` FOREIGN KEY (`skill_oid`) REFERENCES `skill` (`oid`),
  CONSTRAINT `fk_user_skill_user` FOREIGN KEY (`user_oid`) REFERENCES `user` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_skill`
--

LOCK TABLES `user_skill` WRITE;
/*!40000 ALTER TABLE `user_skill` DISABLE KEYS */;
INSERT INTO `user_skill` VALUES (2,1),(2,2),(2,3),(2,4),(2,5);
/*!40000 ALTER TABLE `user_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_task`
--

DROP TABLE IF EXISTS `user_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_task` (
  `user_oid` int(11) NOT NULL,
  `task_oid` int(11) NOT NULL,
  PRIMARY KEY (`user_oid`,`task_oid`),
  KEY `fk_user_task_user` (`user_oid`),
  KEY `fk_user_task_task` (`task_oid`),
  CONSTRAINT `fk_user_task_task` FOREIGN KEY (`task_oid`) REFERENCES `task` (`oid`),
  CONSTRAINT `fk_user_task_user` FOREIGN KEY (`user_oid`) REFERENCES `user` (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_task`
--

LOCK TABLES `user_task` WRITE;
/*!40000 ALTER TABLE `user_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-13 23:43:17
