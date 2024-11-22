CREATE DATABASE  IF NOT EXISTS `blogdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blogdb`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: blogdb
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
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentario` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `CONTENIDO` varchar(255) DEFAULT NULL,
  `FECHAHORA` date DEFAULT NULL,
  `post_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_COMENTARIO_usuario_id` (`usuario_id`),
  KEY `FK_COMENTARIO_post_id` (`post_id`),
  CONSTRAINT `FK_COMENTARIO_post_id` FOREIGN KEY (`post_id`) REFERENCES `post` (`ID`),
  CONSTRAINT `FK_COMENTARIO_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (6,'Mi dinosaurio favorito es el cuello largo.','2024-11-21',9,2),(7,'Mi dinosaurio favorito es el T-Rex.','2024-11-21',9,1),(8,'No me gustan los dinosaurios carnívoros.','2024-11-21',9,3),(9,'Interesante post!.','2024-11-21',10,3),(10,'Me gusta este post!.','2024-11-21',10,2),(11,'Un post muy útil!.','2024-11-21',11,1),(12,'La paleontología es interesante.','2024-11-21',11,2);
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Sonora'),(2,'Jalisco'),(3,'Chiapas'),(4,'Guerrero');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `municipio` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `estado_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MUNICIPIO_estado_id` (`estado_id`),
  CONSTRAINT `FK_MUNICIPIO_estado_id` FOREIGN KEY (`estado_id`) REFERENCES `estado` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES (1,'Cajeme',1),(2,'Hermosillo',1),(3,'Sauaripa',1);
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `tipoPost` varchar(31) DEFAULT NULL,
  `CONTENIDO` varchar(255) DEFAULT NULL,
  `FECHAHORACREACION` datetime DEFAULT NULL,
  `FECHAHORAEDICION` datetime DEFAULT NULL,
  `TITULO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (4,'PostAnclado','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.','2024-11-21 21:44:30','2024-11-21 21:44:30','Dinosaurios Populares'),(5,'PostAnclado','Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?','2024-11-21 21:46:58','2024-11-21 21:46:58','Dinosaurios Populares'),(9,'PostComun','Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.','2024-11-21 22:23:37','2024-11-21 22:23:37','Dinosaurios Favoritos'),(10,'PostComun','Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?','2024-11-21 22:23:37','2024-11-21 22:23:37','Tipos de Dinosaurios'),(11,'PostComun','Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?','2024-11-21 22:23:37','2024-11-21 22:23:37','Dinosaurios Carnívoros');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postanclado`
--

DROP TABLE IF EXISTS `postanclado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postanclado` (
  `ID` bigint NOT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_POSTANCLADO_usuario_id` (`usuario_id`),
  CONSTRAINT `FK_POSTANCLADO_ID` FOREIGN KEY (`ID`) REFERENCES `post` (`ID`),
  CONSTRAINT `FK_POSTANCLADO_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postanclado`
--

LOCK TABLES `postanclado` WRITE;
/*!40000 ALTER TABLE `postanclado` DISABLE KEYS */;
INSERT INTO `postanclado` VALUES (4,4),(5,4);
/*!40000 ALTER TABLE `postanclado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postcomun`
--

DROP TABLE IF EXISTS `postcomun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postcomun` (
  `ID` bigint NOT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_POSTCOMUN_usuario_id` (`usuario_id`),
  CONSTRAINT `FK_POSTCOMUN_ID` FOREIGN KEY (`ID`) REFERENCES `post` (`ID`),
  CONSTRAINT `FK_POSTCOMUN_usuario_id` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postcomun`
--

LOCK TABLES `postcomun` WRITE;
/*!40000 ALTER TABLE `postcomun` DISABLE KEYS */;
INSERT INTO `postcomun` VALUES (11,1),(10,2),(9,3);
/*!40000 ALTER TABLE `postcomun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `tipoUsuario` varchar(31) DEFAULT NULL,
  `AVATAR` varchar(255) DEFAULT NULL,
  `CIUDAD` varchar(255) DEFAULT NULL,
  `CONTRASENIA` varchar(255) DEFAULT NULL,
  `CORREO` varchar(255) DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `GENERO` varchar(255) DEFAULT NULL,
  `NOMBRECOMPLETO` varchar(255) DEFAULT NULL,
  `NOMBREUSUARIO` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  `municipio_id` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_USUARIO_municipio_id` (`municipio_id`),
  CONSTRAINT `FK_USUARIO_municipio_id` FOREIGN KEY (`municipio_id`) REFERENCES `municipio` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'UsuarioNormal','imagen.png','Hermosillo','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','pablo@gmail.com','2024-11-21','masculino','Pablo Perez','pablo123','2222222222',2),(2,'UsuarioNormal','imagen.png','ObregÃ³n','114bd151f8fb0c58642d2170da4ae7d7c57977260ac2cc8905306cab6b2acabc','regina@gmail.com','2024-11-18','femenino','Regina Gutierrez','regina234','2222222233',1),(3,'UsuarioNormal','imagen.png','Sahuaripa','f04687820731ddb4d4fec0166bc6192cce597b9899dac70bc93fe24309485496','roberto@mail.como','2024-11-03','masculino','Roberto Torres','roberto555abc','3344221188',3),(4,'UsuarioAdministrador','imagen.png','Obregón','4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2','admin@mail.com','2024-11-21','mascuilino','Pedro Torres','admin','2222334455',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarioadministrador`
--

DROP TABLE IF EXISTS `usuarioadministrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarioadministrador` (
  `ID` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_USUARIOADMINISTRADOR_ID` FOREIGN KEY (`ID`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarioadministrador`
--

LOCK TABLES `usuarioadministrador` WRITE;
/*!40000 ALTER TABLE `usuarioadministrador` DISABLE KEYS */;
INSERT INTO `usuarioadministrador` VALUES (4);
/*!40000 ALTER TABLE `usuarioadministrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarionormal`
--

DROP TABLE IF EXISTS `usuarionormal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarionormal` (
  `ID` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `FK_USUARIONORMAL_ID` FOREIGN KEY (`ID`) REFERENCES `usuario` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarionormal`
--

LOCK TABLES `usuarionormal` WRITE;
/*!40000 ALTER TABLE `usuarionormal` DISABLE KEYS */;
INSERT INTO `usuarionormal` VALUES (1),(2),(3);
/*!40000 ALTER TABLE `usuarionormal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'blogdb'
--

--
-- Dumping routines for database 'blogdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-21 23:08:56
