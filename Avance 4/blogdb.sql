CREATE DATABASE  IF NOT EXISTS `blogdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blogdb`;
-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: blogdb
-- ------------------------------------------------------
-- Server version	8.0.40

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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
INSERT INTO `comentario` VALUES (1,'¡Excelente artículo! Me encantó cómo explicaron la historia del T-Rex.','2024-11-25',1,2),(2,'Interesante enfoque sobre los dinosaurios. Me gustaría saber más sobre su comportamiento social.','2024-11-25',1,3),(3,'Muy informativo. Nunca había oído hablar del Brachiosaurus. ¡Qué impresionante tamaño!','2024-11-25',2,6),(4,'Me gustó mucho la descripción. Sería genial que incluyeran información sobre su alimentación.','2024-11-25',2,7),(9,'¡Impresionante el tamaño del Argentinosaurus! Es increíble cómo estos gigantes caminaban por la Tierra.','2024-11-25',5,3),(10,'Interesante artículo sobre el Argentinosaurus. ¿Cuántos de estos dinosaurios vivían en grupos?','2024-11-25',5,7),(11,'El Spinosaurus es muy intrigante, especialmente por su adaptación acuática. ¿Sabían que podría haber cazado peces?','2024-11-25',6,2),(12,'Me sorprendió saber que el Spinosaurus tenía una dieta tan variada. ¡Excelente información!','2024-11-25',6,1),(13,'Me encanta el tema de los dinosaurios. El Triceratops es mi favorito, especialmente por sus cuernos.','2024-11-25',7,5),(14,'El Triceratops es fascinante, aunque no estoy seguro de qué tan efectivos eran esos cuernos para defenderse.','2024-11-25',7,8),(15,'El Pteranodon me parece un dinosaurio muy interesante, sobre todo por su habilidad para volar.','2024-11-25',8,4),(16,'El Pteranodon es impresionante. Me encantaría saber más sobre su forma de vida en los cielos prehistóricos.','2024-11-25',8,7),(17,'El Triceratops me parece uno de los dinosaurios más imponentes. ¡Esa cabeza con tres cuernos es espectacular!','2024-11-25',9,2),(18,'Muy buena publicación sobre el Triceratops. Me gustaría saber más sobre su interacción con otros dinosaurios.','2024-11-25',9,5),(19,'El T-Rex es increíble, pero me sorprendió saber que no era tan rápido como pensaba.','2024-11-25',10,1),(20,'¡Qué artículo tan interesante sobre el T-Rex! Sería genial aprender más sobre su comportamiento y hábitat.','2024-11-25',10,6),(21,'El Velociraptor es fascinante. ¡Increíble cómo se organizaban en manadas!','2024-11-25',11,8),(22,'Gran artículo, me hizo recordar la película de Jurassic Park. Aunque me gustaría saber más sobre su inteligencia.','2024-11-25',11,1),(23,'Buen artículo, pero me hubiera gustado saber más sobre su comportamiento.','2024-11-25',12,8),(24,'Muy interesante artículo sobre el Stegosaurus. La información sobre sus placas es fascinante.','2024-11-25',12,6);
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
  `CONTENIDO` text,
  `FECHAHORACREACION` datetime DEFAULT NULL,
  `FECHAHORAEDICION` datetime DEFAULT NULL,
  `TITULO` varchar(255) DEFAULT NULL,
  `portada` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'PostComun','El T-Rex, conocido como el \"Rey de los Dinosaurios\", es uno de los dinosaurios más populares y temidos. Vivió hace 68 millones de años durante el periodo Cretácico, y se estima que alcanzaba una longitud de hasta 12 metros y un peso de aproximadamente 7 toneladas. Este dinosaurio carnívoro se caracterizaba por sus grandes mandíbulas y dientes afilados, los cuales utilizaba para cazar a sus presas, principalmente grandes herbívoros. \n    El T-Rex tenía un sentido del olfato excepcional, que le permitía detectar a sus presas a grandes distancias. Además, se cree que su poderosa mordida era capaz de generar una presión de hasta 6 toneladas, lo suficiente para romper huesos y desmembrar a sus víctimas. A pesar de su tamaño imponente, este dinosaurio no era el mejor corredor, pero su fuerza y habilidad para emboscar a su presa lo convertían en uno de los depredadores más peligrosos de su tiempo. \n    A lo largo de los años, el T-Rex ha capturado la imaginación de las personas, especialmente a través de su representación en películas como \"Jurassic Park\". Sin embargo, la realidad sobre su vida y comportamientos sigue siendo un tema de investigación y fascinación para paleontólogos y amantes de los dinosaurios.','2024-11-24 10:30:00','2024-11-24 10:30:00','El T-Rex: El Rey de los Dinosaurios','trex.jpg'),(2,'PostComun','El Velociraptor es otro de los dinosaurios más conocidos, gracias a su representación en películas como \"Jurassic Park\". A pesar de su pequeña estatura, el Velociraptor era un cazador inteligente y veloz, que se desplazaba en grupos organizados para atrapar a sus presas. Estimaciones sugieren que podía alcanzar hasta 40 km/h en su carrera, lo que lo hacía un competidor formidable en su ecosistema. \n    Este dinosaurio, conocido por su gran agilidad y garras afiladas, era un carnívoro que se alimentaba de otros dinosaurios más pequeños, e incluso de aves y mamíferos prehistóricos. Se cree que su inteligencia estaba por encima de la media, lo que le permitía cazar en manada, una táctica que aumentaba sus posibilidades de éxito.','2024-11-22 11:00:00','2024-11-22 11:00:00','El Velociraptor: Rápido y Letal','velociraptor.jpeg'),(5,'PostComun','El Brachiosaurus es uno de los dinosaurios más grandes que existieron. Este dinosaurio herbívoro se caracterizaba por su cuello extremadamente largo, lo que le permitía alcanzar las hojas de los árboles más altos. A pesar de su tamaño colosal, se alimentaba solo de vegetación y se desplazaba lentamente a través de las zonas boscosas del Jurásico. \n    El Brachiosaurus es conocido por sus dimensiones impresionantes, alcanzando hasta 25 metros de largo y un peso de hasta 80 toneladas. Su cuello largo era ideal para alcanzar ramas altas y alimentarse de plantas que otros dinosaurios no podían alcanzar.','2024-11-22 13:40:00','2024-11-22 13:40:00','Brachiosaurus: El Gigante Vegetariano','brachiosaurus.jpg'),(6,'PostComun','El Ankylosaurus era un dinosaurio blindado que vivió durante el Cretácico. Este herbívoro se caracterizaba por sus placas óseas cubriendo su cuerpo, lo que lo hacía prácticamente invulnerable a los ataques de depredadores. Además, su cola terminaba en una gran maza ósea, que utilizaba como arma para defenderse. \n    Aunque el Ankylosaurus era lento, su armadura y su fuerza lo convirtieron en un animal temido por los depredadores de la época. Vivía en bosques y llanuras, alimentándose de plantas bajas y arbustos.','2024-11-20 16:10:00','2024-11-20 16:10:00','Ankylosaurus: El Blindado Cretácico','ankylosaurus.jpg'),(7,'PostComun','El Spinosaurus es un dinosaurio carnívoro que vivió en el Cretácico y es conocido por su gran vela dorsal. Este dinosaurio, uno de los más grandes carnívoros que existieron, se especializaba en la caza de peces. Vivió en lo que hoy es el norte de África, y su gran tamaño le permitió cazar de manera eficiente en hábitats acuáticos. \n    Se estima que el Spinosaurus podía alcanzar hasta 16 metros de largo y pesar hasta 7 toneladas. Su característica más distintiva era su vela en la espalda, aunque los científicos aún debaten la función de esta estructura.','2024-11-19 08:00:00','2024-11-19 08:00:00','Spinosaurus: El Cazador Acuático','spinosaurus.jpeg'),(8,'PostComun','El Stegosaurus es otro de los dinosaurios más emblemáticos del Jurásico. Este dinosaurio herbívoro, conocido por sus placas óseas a lo largo de la espalda y su cola con púas, fue una de las criaturas más extrañas de su época. A pesar de su apariencia intimidante, el Stegosaurus era un animal tranquilo que se alimentaba de vegetación. \n    Su tamaño era considerable, alcanzando hasta 9 metros de largo. Las placas de su espalda probablemente servían para regular su temperatura, aunque también podrían haber tenido una función de defensa frente a los depredadores.','2024-11-18 17:45:00','2024-11-18 17:45:00','Stegosaurus: El Guerrero Blindado','stegosaurus.jpeg'),(9,'PostComun','El Plesiosaurio es uno de los reptiles marinos más famosos del Mesozoico. Con su largo cuello y cuerpo robusto, se ha convertido en un ícono de las criaturas prehistóricas. A pesar de vivir en el agua, el Plesiosaurio no era un dinosaurio, sino un reptil marino que se alimentaba de peces y criaturas acuáticas. \n    Su cuello largo le permitía alcanzar a sus presas en el agua y, debido a sus aletas, era un nadador muy ágil. Algunos científicos han sugerido que podría haber sido un gran depredador marino que cazaba en las aguas del Cretácico.','2024-11-17 14:30:00','2024-11-17 14:30:00','Plesiosaurio: El Maestro del Agua','plesiosaurio.jpg'),(10,'PostComun','El Allosaurus es un dinosaurio carnívoro que vivió durante el periodo Jurásico. Este depredador, que alcanzaba hasta 12 metros de largo, era uno de los principales cazadores de su época, alimentándose de otros dinosaurios más pequeños. \n    Su mandíbula poderosa y sus afilados dientes lo convirtieron en un competidor formidable para cualquier animal que se cruzara en su camino. A pesar de su tamaño, se cree que el Allosaurus era un cazador rápido y ágil, capaz de derribar presas mucho más grandes que él.','2024-11-16 11:25:00','2024-11-16 11:25:00','Allosaurus: El Cazador Jurásico','allosaurus.jpg'),(11,'PostAnclado','El Triceratops es uno de los dinosaurios herbívoros más conocidos y populares. Este dinosaurio cuadrúpedo se caracterizaba por su gran cresta ósea en la cabeza, formada por tres cuernos que utilizaba tanto para defenderse como para competir con otros Triceratops. Su tamaño era impresionante, alcanzando hasta 9 metros de largo y un peso de hasta 12 toneladas. \n    El Triceratops vivió en el periodo Cretácico y fue uno de los dinosaurios más comunes en América del Norte. Se alimentaba principalmente de plantas, utilizando su pico afilado para cortar hojas y vegetación. A pesar de su tamaño, este dinosaurio prefería mantener una vida tranquila, apartándose de los depredadores como el T-Rex.','2024-11-23 14:20:00','2024-11-23 14:20:00','Triceratops: El Herbívoro Blindado','triceratops.jpg'),(12,'PostAnclado','Los Pteranodones no eran dinosaurios, pero sí reptiles voladores que coexistieron con ellos. Estos animales, conocidos por su gran envergadura de hasta 10 metros, surcaron los cielos durante el Cretácico. Su alimentación era principalmente a base de peces, los cuales capturaban mientras volaban sobre el agua. \n    Aunque se cree que los Pteranodones no tenían la capacidad de realizar vuelos largos, sí eran excelentes planeadores, utilizando las corrientes de aire para mantenerse en el aire durante largos periodos. Su aspecto único y sus alas impresionantes los han convertido en figuras fascinantes dentro de la paleontología.','2024-11-21 09:15:00','2024-11-21 09:15:00','Pteranodón: El Rey del Cielo','pteranodon.jpg');
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
INSERT INTO `postanclado` VALUES (11,3),(12,5);
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
INSERT INTO `postcomun` VALUES (1,1),(8,1),(2,2),(9,2),(10,3),(5,6),(6,7),(7,8);
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'UsuarioNormal','jeff-hardy.jpg','Hermosillo','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','pablo@gmail.com','2024-11-21','masculino','Pablo Perez','pablo123','2222222222',2),(2,'UsuarioNormal','pancho-barraza.jpg','ObregÃ³n','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','regina@gmail.com','2024-11-18','femenino','Regina Gutierrez','regina234','2222222233',1),(3,'UsuarioNormal','pikachu.jpg','Sahuaripa','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','roberto@mail.como','2024-11-03','masculino','Roberto Torres','roberto555abc','3344221188',3),(4,'UsuarioAdministrador','jaimeharrison.jpg','Obregón','4813494d137e1631bba301d5acab6e7bb7aa74ce1185d456565ef51d737677b2','admin@mail.com','2024-11-21','mascuilino','Pedro Torres','admin','2222334455',1),(5,'UsuarioNormal','jaime-maussan.jpg','Obregón','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','jmovni@gmail.com','1958-05-30','masculino','Jaime Maussan','JaimeMaussan','8872717123',1),(6,'UsuarioNormal','rey-mysterio.jpg','Obregón','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','rm619@gmail.com','1974-03-21','masculino','Rey Mysterio','ReyMysterio619','6196196196',1),(7,'UsuarioNormal','doctor-chapatin.jpg','Obregon','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','doctorch@gmail.com','1929-02-21','masculino','Doctor Chapatin','DrChapatin','1515121431',1),(8,'UsuarioNormal','rock-lee.png','Obregón','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','rocklee@gmail.com','2004-11-27','masculino','Rock Lee','RockLee','1531231233',1),(9,'UsuarioNormal','AC_1.jpg','Obregón','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','A@gmail.coim','2001-11-11','masculino','A A','AAAAA','1232131221',1);
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
INSERT INTO `usuarionormal` VALUES (1),(2),(3),(5),(6),(7),(8),(9);
/*!40000 ALTER TABLE `usuarionormal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-02 23:25:49
