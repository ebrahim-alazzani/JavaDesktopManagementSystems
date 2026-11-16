CREATE DATABASE  IF NOT EXISTS `bakery` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bakery`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bakery
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
-- Table structure for table `bakeryitems`
--

DROP TABLE IF EXISTS `bakeryitems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `bakeryitems` (
  `Item_ID` int NOT NULL,
  `Quantity` int NOT NULL,
  `Price` double NOT NULL,
  `ItemName` varchar(25) NOT NULL,
  `img` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`Item_ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bakeryitems`
--

LOCK TABLES `bakeryitems` WRITE;
/*!40000 ALTER TABLE `bakeryitems` DISABLE KEYS */;
INSERT INTO `bakeryitems` VALUES (1001,101,9.5,'Almond cake',NULL),(1002,132,12.5,'Bread',NULL),(1003,154,11,'Haloumi sliders',NULL),(1004,128,5.15,'Mini pizza',NULL),(1005,98,17.5,'Cookies',NULL),(2001,140,21,'Mojito',NULL),(2002,121,21.5,'MilkShake',NULL),(2003,119,19,'Lemon juice',NULL),(2004,105,20.15,'Hot chocolate',NULL),(2005,99,17.5,'Redbull',NULL),(3001,77,25,'Short cake',NULL),(3002,65,22.5,'Brownie',NULL),(3003,89,24.25,'Cupcake',NULL),(3004,36,20,'English cake',NULL),(3005,98,23.15,'Cheese cake',NULL),(4001,32,18,'Chocolate icecream',NULL),(4002,33,16.5,'Vanilla icecream',NULL),(4003,27,20,'Rainbow icecream',NULL),(4004,44,21.15,'Golden Middle icecream',NULL),(4005,21,18.5,'Oreo icecream',NULL);
/*!40000 ALTER TABLE `bakeryitems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `Customer_ID` int NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Customer_Password` varchar(50) NOT NULL,
  PRIMARY KEY (`Customer_ID`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`Customer_ID`) REFERENCES `persons` (`Person_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (102,'Noura2@hotmail.com','N12345'),(103,'Heba3@hotmail.com','H12345'),(104,'Adel4@hotmail.com','A12345'),(108,'Sara8@hotmail.com','S12345'),(110,'Abdullah10@hotmail.com','A12345');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drinks`
--

DROP TABLE IF EXISTS `drinks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `drinks` (
  `Item_ID` int NOT NULL,
  `Syrup` varchar(25) DEFAULT NULL,
  `Drink_Type` varchar(25) NOT NULL,
  PRIMARY KEY (`Item_ID`),
  CONSTRAINT `drinks_ibfk_1` FOREIGN KEY (`Item_ID`) REFERENCES `bakeryitems` (`Item_ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drinks`
--

LOCK TABLES `drinks` WRITE;
/*!40000 ALTER TABLE `drinks` DISABLE KEYS */;
INSERT INTO `drinks` VALUES (2001,'Raspberry','cold'),(2002,'strawberry','cold'),(2003,'mint','cold'),(2004,'chocolate ','hot'),(2005,'watermelon','cold');
/*!40000 ALTER TABLE `drinks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `Employee_ID` int NOT NULL,
  `Salary` int NOT NULL,
  `Manager` int DEFAULT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Manager` (`Manager`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`Employee_ID`) REFERENCES `persons` (`Person_ID`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`Manager`) REFERENCES `employees` (`Employee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (101,20000,NULL,'1','1'),(105,5000,101,'2','2'),(106,6000,101,'3','3'),(109,5000,101,'4','4');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `icecream`
--

DROP TABLE IF EXISTS `icecream`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `icecream` (
  `Item_ID` int NOT NULL,
  `Flavour` varchar(25) NOT NULL,
  PRIMARY KEY (`Item_ID`),
  CONSTRAINT `icecream_ibfk_1` FOREIGN KEY (`Item_ID`) REFERENCES `bakeryitems` (`Item_ID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `icecream`
--

LOCK TABLES `icecream` WRITE;
/*!40000 ALTER TABLE `icecream` DISABLE KEYS */;
INSERT INTO `icecream` VALUES (4001,'chocolate'),(4002,'vanilla'),(4003,'rainbow'),(4004,'golden middle'),(4005,'oreo');
/*!40000 ALTER TABLE `icecream` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `Order_ID` int NOT NULL,
  `Item_ID` int DEFAULT NULL,
  `Receipt_ID` int DEFAULT NULL,
  `Quantity` int NOT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`Order_ID`),
  KEY `Item_ID` (`Item_ID`),
  KEY `Receipt_ID` (`Receipt_ID`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`Item_ID`) REFERENCES `bakeryitems` (`Item_ID`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`Receipt_ID`) REFERENCES `receipts` (`Receipt_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1001,5001,7,NULL),(2,2002,5001,1,NULL),(3,3001,5001,2,NULL),(4,1002,5002,5,NULL),(5,1005,5002,4,NULL),(6,4004,5003,5,NULL),(7,4002,5003,3,NULL),(8,2003,5003,6,NULL),(9,3002,5004,1,NULL),(10,2004,5005,8,NULL);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `persons` (
  `Person_ID` int NOT NULL,
  `Person_Name` varchar(25) NOT NULL,
  `PhoneNumber` varchar(10) NOT NULL,
  `Person_Address` varchar(50) NOT NULL,
  PRIMARY KEY (`Person_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (0,'yyyyy','23344','10000'),(101,'Asrar','055578390','khobar'),(102,'Noura','050078391','dammam'),(103,'Heba','050678990','qatif'),(104,'Adel','051178390','khobar'),(105,'Waleed','050078222','dammam'),(106,'Salman','050012345','alahsa'),(107,'Faris','057658390','khobar'),(108,'Sara','050574560','dammam'),(109,'Salwa','050578390','khobar'),(110,'Abdullah','055578390','qatif');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipts`
--

DROP TABLE IF EXISTS `receipts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `receipts` (
  `Receipt_ID` int NOT NULL,
  `Customer_ID` int DEFAULT NULL,
  `Employee_ID` int DEFAULT NULL,
  PRIMARY KEY (`Receipt_ID`),
  KEY `Customer_ID` (`Customer_ID`),
  KEY `Employee_ID` (`Employee_ID`),
  CONSTRAINT `receipts_ibfk_1` FOREIGN KEY (`Customer_ID`) REFERENCES `customers` (`Customer_ID`),
  CONSTRAINT `receipts_ibfk_2` FOREIGN KEY (`Employee_ID`) REFERENCES `employees` (`Employee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipts`
--

LOCK TABLES `receipts` WRITE;
/*!40000 ALTER TABLE `receipts` DISABLE KEYS */;
INSERT INTO `receipts` VALUES (5001,102,106),(5002,103,109),(5003,103,105),(5004,102,109),(5005,103,106);
/*!40000 ALTER TABLE `receipts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savories`
--

DROP TABLE IF EXISTS `savories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `savories` (
  `Item_ID` int NOT NULL,
  `Flourtype` varchar(25) NOT NULL,
  PRIMARY KEY (`Item_ID`),
  CONSTRAINT `savories_ibfk_1` FOREIGN KEY (`Item_ID`) REFERENCES `bakeryitems` (`Item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savories`
--

LOCK TABLES `savories` WRITE;
/*!40000 ALTER TABLE `savories` DISABLE KEYS */;
INSERT INTO `savories` VALUES (1001,'almond flour'),(1002,'gluten free flour'),(1003,'potato flour'),(1004,'regular flour'),(1005,'oat flour');
/*!40000 ALTER TABLE `savories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sweets`
--

DROP TABLE IF EXISTS `sweets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8 */;
CREATE TABLE `sweets` (
  `Item_ID` int NOT NULL,
  `Flavour` varchar(25) NOT NULL,
  `FrostingColour` varchar(25) NOT NULL,
  PRIMARY KEY (`Item_ID`),
  CONSTRAINT `sweets_ibfk_1` FOREIGN KEY (`Item_ID`) REFERENCES `bakeryitems` (`Item_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sweets`
--

LOCK TABLES `sweets` WRITE;
/*!40000 ALTER TABLE `sweets` DISABLE KEYS */;
INSERT INTO `sweets` VALUES (3001,'strawberry','white frosting'),(3002,'chocolate','brown frosting'),(3003,'honey','yellow frosting'),(3004,'vanilla','white frosting'),(3005,'red velvet','red frosting');
/*!40000 ALTER TABLE `sweets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bakery'
--

--
-- Dumping routines for database 'bakery'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-24  4:14:27
