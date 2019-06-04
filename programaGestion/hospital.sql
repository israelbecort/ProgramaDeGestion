CREATE DATABASE  IF NOT EXISTS `hospital` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish2_ci */;
USE `hospital`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: hospital
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `camas`
--

DROP TABLE IF EXISTS `camas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `camas` (
  `idCama` int(11) NOT NULL AUTO_INCREMENT,
  `numCama` int(11) DEFAULT NULL,
  `idPacienteFK` int(11) DEFAULT NULL,
  `idEdificioFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCama`),
  KEY `idPacienteFK` (`idPacienteFK`),
  KEY `idEdificioFK` (`idEdificioFK`),
  CONSTRAINT `camas_ibfk_1` FOREIGN KEY (`idPacienteFK`) REFERENCES `pacientes` (`idPaciente`),
  CONSTRAINT `camas_ibfk_2` FOREIGN KEY (`idEdificioFK`) REFERENCES `edificios` (`idEdificio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camas`
--

LOCK TABLES `camas` WRITE;
/*!40000 ALTER TABLE `camas` DISABLE KEYS */;
INSERT INTO `camas` VALUES (1,1,1,1),(2,2,2,2),(3,3,3,3);
/*!40000 ALTER TABLE `camas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edificios`
--

DROP TABLE IF EXISTS `edificios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `edificios` (
  `idEdificio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEdificio` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `numEmpleadosEdificio` int(11) DEFAULT NULL,
  `direccionEdificio` varchar(150) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idEdificio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edificios`
--

LOCK TABLES `edificios` WRITE;
/*!40000 ALTER TABLE `edificios` DISABLE KEYS */;
INSERT INTO `edificios` VALUES (1,'cirugia',49,'Av. Manuel Siurot, S/n, 41013 Sevilla'),(2,'pediatría',42,'Calle Dr. Fedriani, 3, 41009 Sevilla'),(3,'podología',24,'Glorieta de Méjico, 1, 41012 Sevilla');
/*!40000 ALTER TABLE `edificios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edificiosempleados`
--

DROP TABLE IF EXISTS `edificiosempleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `edificiosempleados` (
  `idEdificiosEmpleados` int(11) NOT NULL AUTO_INCREMENT,
  `idEdificioFK` int(11) DEFAULT NULL,
  `idEmpleadoFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idEdificiosEmpleados`),
  KEY `idEdificioFK` (`idEdificioFK`),
  KEY `idEmpleadoFK` (`idEmpleadoFK`),
  CONSTRAINT `edificiosempleados_ibfk_1` FOREIGN KEY (`idEdificioFK`) REFERENCES `edificios` (`idEdificio`),
  CONSTRAINT `edificiosempleados_ibfk_2` FOREIGN KEY (`idEmpleadoFK`) REFERENCES `empleados` (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edificiosempleados`
--

LOCK TABLES `edificiosempleados` WRITE;
/*!40000 ALTER TABLE `edificiosempleados` DISABLE KEYS */;
INSERT INTO `edificiosempleados` VALUES (1,1,1),(2,2,3),(3,3,2);
/*!40000 ALTER TABLE `edificiosempleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleados` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEmpleado` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apellidosEmpleado` varchar(150) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `direccionEmpleado` varchar(150) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `emailEmpleado` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `DNIEmpleado` varchar(9) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `puestoEmpleado` varchar(150) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,'francisco','barrera garcia','sembradores, 4, 5ºc','fbarrerag@gmail.com','35487519k','cirujano'),(2,'jorge','martin de los santos','albañiles, 2, BajoºA','jmartin@gmail.com','35485401h','podologo'),(3,'oscar','reina galera','albañiles, 4, 2ºC','oreina@gmail.com','27154730z','pediatra');
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `pacientes` (
  `idPaciente` int(11) NOT NULL AUTO_INCREMENT,
  `nombrePaciente` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `apellido1` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `DNIPaciente` varchar(9) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `numSS` int(11) DEFAULT NULL,
  `direccionPaciente` varchar(150) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `emailPaciente` varchar(100) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `numTelPaciente` int(9) DEFAULT NULL,
  `apellido2` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES (1,'andres','zaragoza','25487415f',1214574584,'agricultores, 2, 3ºA','azaragoza@gmail.com',952458578,'garcia'),(2,'antonio','acal','24896318r',845213568,'estrella canopus, 4, 4ºB','aAcal@gmail.com',954921034,'muñoz'),(3,'francisca','barrera','31658517y',19874523,'corral del moro','fbarrera@gmail.com',954875463,'barragan'),(21,'asd','asd',NULL,NULL,NULL,NULL,NULL,'assd'),(22,'dd','dd',NULL,NULL,NULL,NULL,NULL,'dd'),(23,'1','2',NULL,NULL,NULL,NULL,NULL,'3');
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombreUsuario` varchar(45) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `contrasenaUsuario` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  `correoElectronico` varchar(255) COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Administrador','88245df90ff712430e642f3a7e4bfa58','administrador@gmail.com'),(2,'Usuario','88245df90ff712430e642f3a7e4bfa58','usuario@gmail.com');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-05  0:31:02
