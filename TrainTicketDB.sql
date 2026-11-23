-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: trainticketdb
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `booking_table`
--

DROP TABLE IF EXISTS `booking_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_table` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `booking_reference` varchar(50) NOT NULL,
  `passenger_name` varchar(50) NOT NULL,
  `route_id` int NOT NULL,
  `ticket_price_at_booking` decimal(10,2) NOT NULL,
  `number_of_tickets` int NOT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `booking_date` date NOT NULL DEFAULT (curdate()),
  `departure_date` date NOT NULL,
  `booking_status` varchar(50) NOT NULL,
  PRIMARY KEY (`booking_id`),
  UNIQUE KEY `booking_reference` (`booking_reference`),
  KEY `route_id` (`route_id`),
  CONSTRAINT `booking_table_ibfk_1` FOREIGN KEY (`route_id`) REFERENCES `routes_table` (`route_id`),
  CONSTRAINT `booking_table_chk_1` CHECK ((`number_of_tickets` >= 1))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_table`
--

LOCK TABLES `booking_table` WRITE;
/*!40000 ALTER TABLE `booking_table` DISABLE KEYS */;
INSERT INTO `booking_table` VALUES (1,'TB101','Athi',7,200.00,4,800.00,'2026-11-22','2026-12-01','Confirmed'),(2,'TB59','Athi',7,200.00,2,400.00,'2026-11-23','2026-12-15','Confirmed'),(3,'TB53','Athi',7,200.00,6,1200.00,'2026-11-23','2026-12-01','Confirmed');
/*!40000 ALTER TABLE `booking_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes_table`
--

DROP TABLE IF EXISTS `routes_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes_table` (
  `route_id` int NOT NULL AUTO_INCREMENT,
  `departure_city` varchar(50) NOT NULL,
  `destination_city` varchar(50) NOT NULL,
  `ticket_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`route_id`),
  CONSTRAINT `chk_ticket_price` CHECK ((`ticket_price` >= 0))
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes_table`
--

LOCK TABLES `routes_table` WRITE;
/*!40000 ALTER TABLE `routes_table` DISABLE KEYS */;
INSERT INTO `routes_table` VALUES (1,'Pretoria','Johannesburg',50.00),(2,'Pretoria','Cape Town',300.00),(3,'Pretoria','Durban',250.00),(4,'Durban','Pretoria',250.00),(5,'Durban','Cape Town',400.00),(6,'Durban','Polokwane',300.00),(7,'Cape Town','East London',200.00);
/*!40000 ALTER TABLE `routes_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-11-23  5:33:24
