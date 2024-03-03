CREATE DATABASE  IF NOT EXISTS `hr_application` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hr_application`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hr_application
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
-- Table structure for table `additional_info`
--

DROP TABLE IF EXISTS `additional_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `additional_info` (
  `additional_info_id` int NOT NULL AUTO_INCREMENT,
  `relocation` tinyint(1) DEFAULT NULL,
  `expected_salary` double DEFAULT NULL,
  `notice_period` int DEFAULT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`additional_info_id`),
  KEY `fk_applicant_addsInfo` (`fk_applicant_id`),
  KEY `fk_employee_addsInfo` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_addsInfo` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_addsInfo` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_info`
--

LOCK TABLES `additional_info` WRITE;
/*!40000 ALTER TABLE `additional_info` DISABLE KEYS */;
INSERT INTO `additional_info` VALUES (2,NULL,NULL,NULL,NULL,NULL),(3,1,NULL,NULL,NULL,9);
/*!40000 ALTER TABLE `additional_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `country` varchar(150) NOT NULL,
  `state` varchar(150) NOT NULL,
  `postcode` int NOT NULL,
  `address_line1` varchar(150) NOT NULL,
  `address_line2` varchar(150) DEFAULT NULL,
  `address_line3` varchar(150) DEFAULT NULL,
  `city` varchar(150) NOT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `fk_applicant_address` (`fk_applicant_id`),
  KEY `fk_employee_address` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_address` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_address` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (3,'Malaysia','Negeri Sembilan',70300,'Jalan','Taman',NULL,'Seremban',NULL,9);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicant` (
  `applicant_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
INSERT INTO `applicant` VALUES (2,'amirul@gmail.com','dasda');
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicant_status`
--

DROP TABLE IF EXISTS `applicant_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicant_status` (
  `applicant_status_id` int NOT NULL AUTO_INCREMENT,
  `application_date` date NOT NULL,
  `status` varchar(150) NOT NULL DEFAULT 'Your application has been submitted',
  `fk_applicant_id` int NOT NULL,
  `fk_job_post_id` int NOT NULL,
  PRIMARY KEY (`applicant_status_id`),
  KEY `fk_applicant_status` (`fk_applicant_id`),
  KEY `fk_job_post_status` (`fk_job_post_id`),
  CONSTRAINT `fk_applicant_status` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_job_post_status` FOREIGN KEY (`fk_job_post_id`) REFERENCES `job_posting` (`job_post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant_status`
--

LOCK TABLES `applicant_status` WRITE;
/*!40000 ALTER TABLE `applicant_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicant_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `certificate` (
  `certificate_id` int NOT NULL AUTO_INCREMENT,
  `certificate_location` varchar(150) NOT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`certificate_id`),
  KEY `fk_applicant_certs` (`fk_applicant_id`),
  KEY `fk_employee_certs` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_certs` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_certs` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES (2,'/sijil.pdf',NULL,9),(3,'/volunteer.pdf',NULL,9);
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `department_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (2,'Design Department');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education`
--

DROP TABLE IF EXISTS `education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `education` (
  `education_id` int NOT NULL AUTO_INCREMENT,
  `education_level` varchar(150) NOT NULL,
  `major` varchar(150) NOT NULL,
  `school` varchar(150) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `cgpa` varchar(50) DEFAULT NULL,
  `graduation_year` year DEFAULT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`education_id`),
  KEY `fk_applicant_edu` (`fk_applicant_id`),
  KEY `fk_employee_edu` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_edu` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_edu` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education`
--

LOCK TABLES `education` WRITE;
/*!40000 ALTER TABLE `education` DISABLE KEYS */;
INSERT INTO `education` VALUES (12,'Degree','Automotive Engineer','UIA','2018-09-01','2023-08-15','4.00',2023,NULL,9),(13,'Foundation','Mechanical Engineer','UIA','2018-09-01','2019-06-15','4.00',2023,NULL,9);
/*!40000 ALTER TABLE `education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(150) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (9,'help');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_interview`
--

DROP TABLE IF EXISTS `employee_interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_interview` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fk_employee_id` int DEFAULT NULL,
  `fk_interview_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee_interview` (`fk_employee_id`),
  KEY `fk_interview` (`fk_interview_id`),
  CONSTRAINT `fk_employee_interview` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `fk_interview` FOREIGN KEY (`fk_interview_id`) REFERENCES `interview` (`interview_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_interview`
--

LOCK TABLES `employee_interview` WRITE;
/*!40000 ALTER TABLE `employee_interview` DISABLE KEYS */;
INSERT INTO `employee_interview` VALUES (3,9,1);
/*!40000 ALTER TABLE `employee_interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_position`
--

DROP TABLE IF EXISTS `employee_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_position` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fk_employee_id` int DEFAULT NULL,
  `fk_position_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_employee` (`fk_employee_id`),
  KEY `fk_position` (`fk_position_id`),
  CONSTRAINT `fk_employee` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `fk_position` FOREIGN KEY (`fk_position_id`) REFERENCES `job_position` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_position`
--

LOCK TABLES `employee_position` WRITE;
/*!40000 ALTER TABLE `employee_position` DISABLE KEYS */;
INSERT INTO `employee_position` VALUES (2,9,3);
/*!40000 ALTER TABLE `employee_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `experience` (
  `experience_id` int NOT NULL AUTO_INCREMENT,
  `employer_name` varchar(150) NOT NULL,
  `job_title` varchar(150) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `employer_address` varchar(150) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `job_description` varchar(150) DEFAULT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`experience_id`),
  KEY `fk_applicant_experience` (`fk_applicant_id`),
  KEY `fk_employee_experience` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_experience` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_experience` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES (2,'GSE Sdn Bhd','Design Engineer','2022-07-12','2022-09-15','Kota Kemuning',900,'Design Machine Line-Up',NULL,9);
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interview` (
  `interview_id` int NOT NULL AUTO_INCREMENT,
  `appointment_date` date NOT NULL,
  `appointment_time` time NOT NULL,
  `platform` varchar(150) DEFAULT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  PRIMARY KEY (`interview_id`),
  KEY `fk_applicant_interview` (`fk_applicant_id`),
  CONSTRAINT `fk_applicant_interview` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES (1,'2024-03-04','15:30:00','Zoom',2);
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_position`
--

DROP TABLE IF EXISTS `job_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_position` (
  `position_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `job_description` varchar(150) NOT NULL,
  `requirement` varchar(150) NOT NULL,
  `fk_department_id` int DEFAULT NULL,
  PRIMARY KEY (`position_id`),
  KEY `fk_position_department` (`fk_department_id`),
  CONSTRAINT `fk_position_department` FOREIGN KEY (`fk_department_id`) REFERENCES `department` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_position`
--

LOCK TABLES `job_position` WRITE;
/*!40000 ALTER TABLE `job_position` DISABLE KEYS */;
INSERT INTO `job_position` VALUES (2,'Designer','Buat design','Reti melukis',2),(3,'Designer','Buat design','Reti melukis',2);
/*!40000 ALTER TABLE `job_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_posting`
--

DROP TABLE IF EXISTS `job_posting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job_posting` (
  `job_post_id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(150) NOT NULL,
  `vacancy` int NOT NULL,
  `close_date` date DEFAULT NULL,
  `upload_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `salary_offer` double DEFAULT NULL,
  `status` varchar(150) NOT NULL DEFAULT 'Open',
  `fk_position_id` int DEFAULT NULL,
  PRIMARY KEY (`job_post_id`),
  KEY `fk_position_posting` (`fk_position_id`),
  CONSTRAINT `fk_position_posting` FOREIGN KEY (`fk_position_id`) REFERENCES `job_position` (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_posting`
--

LOCK TABLES `job_posting` WRITE;
/*!40000 ALTER TABLE `job_posting` DISABLE KEYS */;
INSERT INTO `job_posting` VALUES (3,'Seremban',2,'2024-03-15',NULL,10000,'Open',2);
/*!40000 ALTER TABLE `job_posting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reference`
--

DROP TABLE IF EXISTS `reference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reference` (
  `reference_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `position` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `contact_number` varchar(150) DEFAULT NULL,
  `fk_additional_info_id` int DEFAULT NULL,
  PRIMARY KEY (`reference_id`),
  KEY `fk_employee_reference` (`fk_additional_info_id`),
  CONSTRAINT `fk_employee_reference` FOREIGN KEY (`fk_additional_info_id`) REFERENCES `additional_info` (`additional_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reference`
--

LOCK TABLES `reference` WRITE;
/*!40000 ALTER TABLE `reference` DISABLE KEYS */;
INSERT INTO `reference` VALUES (2,'Syuk','Senior Design Engineer','syuk@gse-m.com','012434232',3);
/*!40000 ALTER TABLE `reference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `skill` (
  `skill_id` int NOT NULL AUTO_INCREMENT,
  `skill` varchar(150) NOT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`skill_id`),
  KEY `fk_applicant_skill` (`fk_applicant_id`),
  KEY `fk_employee_skill` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_skill` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_skill` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (2,'Java',NULL,9),(3,'Solidworks',NULL,9);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_diversity`
--

DROP TABLE IF EXISTS `user_diversity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_diversity` (
  `user_diversity_id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(40) NOT NULL,
  `birth_date` date NOT NULL,
  `marital_status` varchar(150) NOT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`user_diversity_id`),
  KEY `fk_applicant_divers` (`fk_applicant_id`),
  KEY `fk_employee_divers` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_divers` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_divers` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_diversity`
--

LOCK TABLES `user_diversity` WRITE;
/*!40000 ALTER TABLE `user_diversity` DISABLE KEYS */;
INSERT INTO `user_diversity` VALUES (2,'male','2000-06-15','single',NULL,9);
/*!40000 ALTER TABLE `user_diversity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_documents`
--

DROP TABLE IF EXISTS `user_documents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_documents` (
  `user_docs_id` int NOT NULL AUTO_INCREMENT,
  `resume_location` varchar(150) NOT NULL,
  `cover_letter_location` varchar(150) DEFAULT NULL,
  `link` varchar(150) DEFAULT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`user_docs_id`),
  KEY `fk_applicant_docs` (`fk_applicant_id`),
  KEY `fk_employee_docs` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_docs` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_docs` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_documents`
--

LOCK TABLES `user_documents` WRITE;
/*!40000 ALTER TABLE `user_documents` DISABLE KEYS */;
INSERT INTO `user_documents` VALUES (2,'/resume.pdf','/CoverLetter.pdf','Linkedin.com',NULL,9);
/*!40000 ALTER TABLE `user_documents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_information`
--

DROP TABLE IF EXISTS `user_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_information` (
  `user_info_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(150) NOT NULL,
  `middle_name` varchar(150) DEFAULT NULL,
  `last_name` varchar(150) DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `title` varchar(45) NOT NULL,
  `contact_number` varchar(150) NOT NULL,
  `fk_applicant_id` int DEFAULT NULL,
  `fk_employee_id` int DEFAULT NULL,
  PRIMARY KEY (`user_info_id`),
  KEY `fk_applicant_info` (`fk_applicant_id`),
  KEY `fk_employee_info` (`fk_employee_id`),
  CONSTRAINT `fk_applicant_info` FOREIGN KEY (`fk_applicant_id`) REFERENCES `applicant` (`applicant_id`),
  CONSTRAINT `fk_employee_info` FOREIGN KEY (`fk_employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_information`
--

LOCK TABLES `user_information` WRITE;
/*!40000 ALTER TABLE `user_information` DISABLE KEYS */;
INSERT INTO `user_information` VALUES (2,'Amirul',NULL,NULL,'amirulacacia@gmail.com','Dr.','0121232454',NULL,NULL),(3,'Amirul',NULL,NULL,'amirulacacia@gmail.com','Ir. Ts.','0121232454',NULL,9);
/*!40000 ALTER TABLE `user_information` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-03 23:00:55
