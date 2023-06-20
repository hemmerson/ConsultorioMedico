CREATE DATABASE  IF NOT EXISTS `ConsultorioMedico` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ConsultorioMedico`;
-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: ConsultorioMedico
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

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
-- Table structure for table `Anamnese`
--

DROP TABLE IF EXISTS `Anamnese`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Anamnese` (
  `idAnamnese` int NOT NULL AUTO_INCREMENT,
  `exameFisico` varchar(500) DEFAULT NULL,
  `examesComplementares` varchar(500) DEFAULT NULL,
  `hipoteseDiagnostico` varchar(500) DEFAULT NULL,
  `diagnostico` varchar(500) DEFAULT NULL,
  `tratamento` varchar(500) DEFAULT NULL,
  `dataHora` datetime DEFAULT NULL,
  `Medico_idMedico` int NOT NULL,
  `Paciente_idPaciente` int NOT NULL,
  PRIMARY KEY (`idAnamnese`),
  KEY `fk_Anamnese_Medico1_idx` (`Medico_idMedico`),
  KEY `fk_Anamnese_Paciente1_idx` (`Paciente_idPaciente`),
  CONSTRAINT `fk_Anamnese_Medico1` FOREIGN KEY (`Medico_idMedico`) REFERENCES `Medico` (`idMedico`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_Anamnese_Paciente1` FOREIGN KEY (`Paciente_idPaciente`) REFERENCES `Paciente` (`idPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Anamnese`
--

LOCK TABLES `Anamnese` WRITE;
/*!40000 ALTER TABLE `Anamnese` DISABLE KEYS */;
INSERT INTO `Anamnese` VALUES (1,'Ausculta pulmonar com estertores crepitantes, febre, tosse produtiva','Raio-X do tórax, hemograma completo, cultura de escarro','Pneumonia','Pneumonia bacteriana','Antibióticos (Amoxicilina) por 7 dias, repouso, hidratação adequada','2023-06-09 19:40:00',1,1),(2,'Dor abdominal localizada no quadrante inferior direito, sinal de Blumberg positivo','Hemograma completo, ultrassonografia abdominal','Apendicite aguda','Apendicite aguda','Cirurgia de apendicectomia laparoscópica, antibióticos (Ceftriaxona e Metronidazol) antes e após a cirurgia, analgesia.','2023-06-09 20:14:24',1,1),(3,'Obesidade, sede excessiva, poliúria, glicemia elevada','Glicemia de jejum, hemoglobina glicada, perfil lipídico','Diabetes tipo 2','Diabetes tipo 2','Mudanças no estilo de vida (dieta equilibrada e atividade física regular), metformina, monitoramento regular da glicemia.','2023-06-10 01:21:13',3,2),(4,'Obesidade, sede excessiva, poliúria, glicemia elevada','Glicemia de jejum, hemoglobina glicada, perfil lipídico','Diabetes tipo 2','Diabetes tipo 2','Mudanças no estilo de vida (dieta equilibrada e atividade física regular), metformina, monitoramento regular da glicemia.','2023-06-16 01:05:33',1,1),(5,'Obesidade, sede excessiva, poliúria, glicemia elevada','Glicemia de jejum, hemoglobina glicada, perfil lipídico','Diabetes tipo 2','Diabetes tipo 2','Mudanças no estilo de vida (dieta equilibrada e atividade física regular), metformina, monitoramento regular da glicemia.','2023-06-20 00:22:36',1,2);
/*!40000 ALTER TABLE `Anamnese` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medico`
--

DROP TABLE IF EXISTS `Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Medico` (
  `idMedico` int NOT NULL AUTO_INCREMENT,
  `especializacao` varchar(45) DEFAULT NULL,
  `Usuario_idUsuario` int NOT NULL,
  PRIMARY KEY (`idMedico`),
  KEY `fk_Medico_Usuario_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Medico_Usuario` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `Usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medico`
--

LOCK TABLES `Medico` WRITE;
/*!40000 ALTER TABLE `Medico` DISABLE KEYS */;
INSERT INTO `Medico` VALUES (1,'Cardiologista',1),(2,'Nutricionista',3),(3,'Cirurgião',4),(4,'Cirurgião Plástico',5),(5,'Pneumologista',7),(6,'Pediatra',8),(7,'Cardiologista',9);
/*!40000 ALTER TABLE `Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paciente`
--

DROP TABLE IF EXISTS `Paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Paciente` (
  `idPaciente` int NOT NULL AUTO_INCREMENT,
  `sexo` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `nomeMae` varchar(45) DEFAULT NULL,
  `naturalidadeCidade` varchar(45) DEFAULT NULL,
  `naturalidadeEstado` varchar(45) DEFAULT NULL,
  `endereco` varchar(45) DEFAULT NULL,
  `Usuario_idUsuario` int NOT NULL,
  PRIMARY KEY (`idPaciente`),
  KEY `fk_Paciente_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Paciente_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `Usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paciente`
--

LOCK TABLES `Paciente` WRITE;
/*!40000 ALTER TABLE `Paciente` DISABLE KEYS */;
INSERT INTO `Paciente` VALUES (1,'masculino','2017-11-19T00:00','Thaize Macedo Rosa','Palmas','TO','Quadra 806 Sul, Alameda 06, lote 30, casa 01',2),(2,'masculino','2001-05-10T00:00','Maria Macedo','São Luis','MA','Q. 704 sul, alameda 15',6);
/*!40000 ALTER TABLE `Paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `is_medico` tinyint DEFAULT '0',
  `nome` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'hemmerson','1234',1,'Hemmerson Luis Rosa','022.222.222-22'),(2,'miguel','123',0,'Miguel Barros Rosa','888.222.111-33'),(3,'pauloh','1234',1,'Paulo Henrique','333.222.222-21'),(4,'thaize','123',1,'Thaize Rosa','333.222.111-41'),(5,'pedro','123',1,'Pedro Rosa','222.333.444-55'),(6,'carlos','123',0,'Carlos Henrique','123.123.123-21'),(7,'thaize1','123',1,'Thaize Macedo','123.421.421-12'),(8,'lalade','123',1,'Lalade Priscila','322.233.122-21'),(9,'miguel1','1234',1,'Miguel Macedo','888.888.333-22');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ConsultorioMedico'
--

--
-- Dumping routines for database 'ConsultorioMedico'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-20  2:14:01
