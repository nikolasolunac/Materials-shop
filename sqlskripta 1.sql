/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.20-log : Database - arhmaterijali_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`arhmaterijali_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `arhmaterijali_db`;

/*Table structure for table `artikal` */

DROP TABLE IF EXISTS `artikal`;

CREATE TABLE `artikal` (
  `ArtikalID` INT(11) NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(45) NOT NULL,
  `Cena` DOUBLE DEFAULT '0',
  `Opis` VARCHAR(45) NOT NULL,
  `JedinicaMere` VARCHAR(45) NOT NULL,
  `TipArtiklaID` INT(11) NOT NULL,
  PRIMARY KEY (`ArtikalID`),
  KEY `tip_artikla_fk_idx` (`TipArtiklaID`),
  CONSTRAINT `tip_artikla_fk` FOREIGN KEY (`TipArtiklaID`) REFERENCES `tip_artikla` (`TipArtiklaID`) ON DELETE NO ACTION
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Data for the table `artikal` */

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `KupacID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(45) NOT NULL,
  `Prezime` varchar(45) NOT NULL,
  `Telefon` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `MestoID` int(11) NOT NULL,
  PRIMARY KEY (`KupacID`),
  KEY `mesto_fk_idx` (`MestoID`),
  CONSTRAINT `mesto_fk` FOREIGN KEY (`MestoID`) REFERENCES `mesto` (`MestoID`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `kupac` */

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `MestoID` int(11) NOT NULL AUTO_INCREMENT,
  `PTT` int(11) NOT NULL,
  `Naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`MestoID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mesto` */

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `RacunID` int(11) NOT NULL AUTO_INCREMENT,
  `Datum` date NOT NULL,
  `Vrednost` double DEFAULT '0',
  `KupacID` int(11) NOT NULL,
  `RadnikID` int(11) NOT NULL,
  PRIMARY KEY (`RacunID`),
  KEY `kupac_fk_idx` (`KupacID`),
  KEY `radnik_fk_idx` (`RadnikID`),
  CONSTRAINT `kupac_fk` FOREIGN KEY (`KupacID`) REFERENCES `kupac` (`KupacID`) ON DELETE NO ACTION,
  CONSTRAINT `radnik_fk` FOREIGN KEY (`RadnikID`) REFERENCES `radnik` (`RadnikID`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `racun` */

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `RadnikID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(45) NOT NULL,
  `Prezime` varchar(45) NOT NULL,
  `KorisnickoIme` varchar(45) NOT NULL,
  `Lozinka` varchar(45) NOT NULL,
  PRIMARY KEY (`RadnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `radnik` */

/*Table structure for table `stavka_racuna` */

DROP TABLE IF EXISTS `stavka_racuna`;

CREATE TABLE `stavka_racuna` (
  `RacunID` int(11) NOT NULL,
  `RedniBroj` int(11) NOT NULL AUTO_INCREMENT,
  `Kolicina` int(11) DEFAULT '0',
  `Cena` double DEFAULT '0',
  `Vrednost` double DEFAULT '0',
  `ArtikalID` int(11) NOT NULL,
  PRIMARY KEY (`RedniBroj`,`RacunID`),
  KEY `racun_fk_idx` (`RacunID`),
  KEY `artikal_fk_idx` (`ArtikalID`),
  CONSTRAINT `artikal_fk` FOREIGN KEY (`ArtikalID`) REFERENCES `artikal` (`ArtikalID`) ON DELETE NO ACTION,
  CONSTRAINT `racun_fk` FOREIGN KEY (`RacunID`) REFERENCES `racun` (`RacunID`) ON DELETE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stavka_racuna` */

/*Table structure for table `tip_artikla` */

DROP TABLE IF EXISTS `tip_artikla`;

CREATE TABLE `tip_artikla` (
  `TipArtiklaID` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`TipArtiklaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tip_artikla` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
