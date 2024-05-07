-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: animemovies
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `commentm`
--

DROP TABLE IF EXISTS `commentm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commentm` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `movie_id` int DEFAULT NULL,
  `comment_text` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `movie_id` (`movie_id`),
  CONSTRAINT `commentm_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `viewer` (`id`),
  CONSTRAINT `commentm_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commentm`
--

LOCK TABLES `commentm` WRITE;
/*!40000 ALTER TABLE `commentm` DISABLE KEYS */;
INSERT INTO `commentm` VALUES (1,1,1,'Like'),(2,NULL,2,'Very Good'),(3,1,4,'Very Good'),(4,3,4,'Very bad'),(5,5,3,'this is my favorite');
/*!40000 ALTER TABLE `commentm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `like_numbers` int NOT NULL,
  `rating` int DEFAULT NULL,
  `preif` text,
  `videoLink` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  CONSTRAINT `rating` CHECK (((`rating` >= 1) and (`rating` <= 5)))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
INSERT INTO `movie` VALUES (1,'leo',202,4,'the good',''),(2,'the Boss',500,5,'like',''),(3,'coco',1000,4,'very',''),(4,'bell',202,3,'cool','');
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viewer`
--

DROP TABLE IF EXISTS `viewer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `viewer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `add_movie_list` json DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  CONSTRAINT `chk_email_pattern` CHECK (regexp_like(`email`,_utf8mb4'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$'))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viewer`
--

LOCK TABLES `viewer` WRITE;
/*!40000 ALTER TABLE `viewer` DISABLE KEYS */;
INSERT INTO `viewer` VALUES (1,'basmala','bas@gmail.com','123','[{\"id\": 3, \"name\": \"coco\", \"prefix\": \"very\", \"rating\": 4, \"likeNumbers\": 1000}, {\"id\": 4, \"name\": \"bell\", \"prefix\": \"cool\", \"rating\": 3, \"likeNumbers\": 202}]',NULL),(2,'Ahmed','Ahmed@gmail.com','12345678',NULL,NULL),(3,'fatma','fatma@gmail.com','$2a$10$/3u9D8p9.QRgU89KZLcgOuGMFwmDEQI6fmJs9cIQpiSlWhmlcwGOO',NULL,NULL),(4,'hapipa','hapipa@gmail.com','12345678',NULL,NULL),(5,'Alaa','Alaa@gmail.com','12345678','[{\"id\": 2, \"name\": \"the Boss\", \"prefix\": \"like\", \"rating\": 5, \"likeNumbers\": 500}]',NULL);
/*!40000 ALTER TABLE `viewer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 19:24:52
