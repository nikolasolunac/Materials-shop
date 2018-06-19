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
  `ArtikalID` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) DEFAULT NULL,
  `Cena` double DEFAULT '0',
  `Opis` varchar(45) DEFAULT NULL,
  `JedinicaMere` varchar(45) DEFAULT NULL,
  `TipArtiklaID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ArtikalID`),
  KEY `tipartikla_fk_idx` (`TipArtiklaID`),
  CONSTRAINT `tipartikla_fk` FOREIGN KEY (`TipArtiklaID`) REFERENCES `tipartikla` (`TipArtiklaID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `artikal` */

insert  into `artikal`(`ArtikalID`,`Naziv`,`Cena`,`Opis`,`JedinicaMere`,`TipArtiklaID`) values (1,'Kartonska lepenka',450,'Dimenzije 100x100','kom',1),(2,'Matirana folija',300,'Dimenzije 42x30','kom',3),(3,'Karton pena',400,'Dimenzije 100x100','kom',1);

/*Table structure for table `kupac` */

DROP TABLE IF EXISTS `kupac`;

CREATE TABLE `kupac` (
  `KupacID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(45) DEFAULT NULL,
  `Prezime` varchar(45) DEFAULT NULL,
  `Telefon` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `MestoID` int(11) DEFAULT NULL,
  PRIMARY KEY (`KupacID`),
  KEY `mesto_fk_idx` (`MestoID`),
  CONSTRAINT `mesto_fk` FOREIGN KEY (`MestoID`) REFERENCES `mesto` (`MestoID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `kupac` */

insert  into `kupac`(`KupacID`,`Ime`,`Prezime`,`Telefon`,`Email`,`MestoID`) values (1,'Stefan','Jaksic','064/333444','sjaksic@yahoo.com',1),(2,'Andrija','Bogunovic','060/555444','abogunovic@gmail.com',4),(3,'Slobodan','Milosavljevic','065/555777','smilosavljevic@yahoo.com',2),(4,'Marko','Maricic','062/555111','mmaricic@yahoo.com',1);

/*Table structure for table `mesto` */

DROP TABLE IF EXISTS `mesto`;

CREATE TABLE `mesto` (
  `MestoID` int(11) NOT NULL AUTO_INCREMENT,
  `PTT` int(11) NOT NULL,
  `Naziv` varchar(45) NOT NULL,
  PRIMARY KEY (`MestoID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `mesto` */

insert  into `mesto`(`MestoID`,`PTT`,`Naziv`) values (1,11000,'Beograd'),(2,21000,'Novi Sad'),(3,34000,'Kragujevac'),(4,26000,'Pancevo');

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `RacunID` int(11) NOT NULL AUTO_INCREMENT,
  `Datum` date DEFAULT NULL,
  `Vrednost` double DEFAULT '0',
  `KupacID` int(11) DEFAULT NULL,
  `RadnikID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RacunID`),
  KEY `kupac_fk_idx` (`KupacID`),
  KEY `radnik_fk_idx` (`RadnikID`),
  CONSTRAINT `kupac_fk` FOREIGN KEY (`KupacID`) REFERENCES `kupac` (`KupacID`) ON DELETE NO ACTION,
  CONSTRAINT `radnik_fk` FOREIGN KEY (`RadnikID`) REFERENCES `radnik` (`RadnikID`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `racun` */

insert  into `racun`(`RacunID`,`Datum`,`Vrednost`,`KupacID`,`RadnikID`) values (1,NULL,0,NULL,NULL),(2,NULL,0,NULL,NULL);

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `RadnikID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(45) DEFAULT NULL,
  `Prezime` varchar(45) DEFAULT NULL,
  `KorisnickoIme` varchar(45) DEFAULT NULL,
  `Lozinka` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`RadnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `radnik` */

insert  into `radnik`(`RadnikID`,`Ime`,`Prezime`,`KorisnickoIme`,`Lozinka`) values (1,'Nikola','Solunac','nsolunac','123'),(2,'Marko','Maricic','mmaricic','123');

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `RacunID` int(11) NOT NULL,
  `RedniBroj` int(11) NOT NULL AUTO_INCREMENT,
  `Kolicina` int(11) DEFAULT '0',
  `Cena` double DEFAULT '0',
  `Vrednost` double DEFAULT '0',
  `ArtikalID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RedniBroj`,`RacunID`),
  KEY `racun_fk_idx` (`RacunID`),
  KEY `artikal_fk_idx` (`ArtikalID`),
  CONSTRAINT `artikal_fk` FOREIGN KEY (`ArtikalID`) REFERENCES `artikal` (`ArtikalID`) ON DELETE NO ACTION,
  CONSTRAINT `racun_fk` FOREIGN KEY (`RacunID`) REFERENCES `racun` (`RacunID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stavkaracuna` */

/*Table structure for table `tipartikla` */

DROP TABLE IF EXISTS `tipartikla`;

CREATE TABLE `tipartikla` (
  `TipArtiklaID` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TipArtiklaID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tipartikla` */

insert  into `tipartikla`(`TipArtiklaID`,`Naziv`) values (1,'Kartoni'),(2,'Drvo'),(3,'Folije'),(4,'Lepak'),(5,'Boje'),(6,'Gips');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
