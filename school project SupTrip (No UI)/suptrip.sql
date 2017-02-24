-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 13 Décembre 2015 à 19:45
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `suptrip`
--

-- --------------------------------------------------------

--
-- Structure de la table `campus`
--

CREATE TABLE IF NOT EXISTS `campus` (
  `id_campus` bigint(20) NOT NULL AUTO_INCREMENT,
  `campus_name` varchar(255) DEFAULT NULL,
  `country` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_campus`),
  KEY `FKAE79ECDFDE16A30E` (`country`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `campus`
--

INSERT INTO `campus` (`id_campus`, `campus_name`, `country`) VALUES
(1, 'Pekin', 1),
(2, 'Paris', 2),
(3, 'Bordeaux', 2),
(4, 'Caen', 2),
(5, 'Grenoble', 2),
(6, 'Lille', 2),
(7, 'Tours', 2),
(8, 'Bruxelles', 4),
(9, 'Londres', 9),
(10, 'Rome', 5),
(11, 'Montreal', 6),
(12, 'San Francisco', 3),
(13, 'île-Maurice', 7),
(14, 'Rabat', 8),
(15, 'Tianjin', 1),
(16, 'Zhenjiang', 1);

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE IF NOT EXISTS `commandes` (
  `id_commande` bigint(20) NOT NULL AUTO_INCREMENT,
  `student` bigint(20) DEFAULT NULL,
  `voyage` bigint(20) DEFAULT NULL,
  `campus_depart` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `FKA6AB45396A24FA45` (`student`),
  KEY `FKA6AB453974B1DEF1` (`voyage`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Contenu de la table `commandes`
--

INSERT INTO `commandes` (`id_commande`, `student`, `voyage`, `campus_depart`) VALUES
(34, 122112, 56, 'Paris'),
(35, 122112, 57, 'Pekin'),
(36, 122112, 115, 'Pekin'),
(37, 122112, 107, 'Bordeaux'),
(38, 213975, 66, 'Paris'),
(39, 213975, 60, 'Paris'),
(40, 213975, 125, 'Paris'),
(41, 213975, 62, 'Grenoble'),
(42, 655455, 63, 'Grenoble'),
(43, 655455, 76, 'Caen'),
(44, 655455, 63, 'Pekin');

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

CREATE TABLE IF NOT EXISTS `etudiants` (
  `idbooster` bigint(20) NOT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `universite` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`idbooster`),
  KEY `FK6EDB3A97576EC6C6` (`universite`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiants`
--

INSERT INTO `etudiants` (`idbooster`, `mail`, `mdp`, `first_name`, `last_name`, `universite`) VALUES
(213975, '213975@supinfo.com', 'essai1', 'Maximilien', 'Guillas', 1),
(545455, '545455@supinfo.com', 'triforce', 'Link', 'Link', 5),
(655455, '655455@supinfo.com', 'Mdp', 'niak', 'niak', 2);

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE IF NOT EXISTS `pays` (
  `id_pays` bigint(20) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pays`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`id_pays`, `country_name`) VALUES
(1, 'Chine'),
(2, 'France'),
(3, 'Usa'),
(4, 'Belgique'),
(5, 'Italie'),
(6, 'Canada'),
(7, 'île-Maurice'),
(8, 'Maroc'),
(9, 'Angleterre');

-- --------------------------------------------------------

--
-- Structure de la table `trip`
--

CREATE TABLE IF NOT EXISTS `trip` (
  `id_trip` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `university` bigint(20) DEFAULT NULL,
  `date_depart` varchar(255) DEFAULT NULL,
  `date_retour` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_trip`),
  KEY `FK367425576EC6DA` (`university`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=136 ;

--
-- Contenu de la table `trip`
--

INSERT INTO `trip` (`id_trip`, `content`, `name`, `university`, `date_depart`, `date_retour`) VALUES
(56, 'Voyage à Pékin', 'SupTrip Pékin en Hiver', 1, '21-02-2016 ', '06-03-2016'),
(57, 'Voyage à Paris', 'SupTrip Paris en Hiver', 2, '21-02-2016', '06-03-2016'),
(58, 'Voyage à Bordeaux', 'SupTrip Bordeaux en Hiver', 3, '21-02-2016', '06-03-2016'),
(59, 'Voyage à Caen', 'SupTrip Caen en Hiver', 4, '21-02-2016', '06-03-2016'),
(60, 'Voyage à Grenoble', 'Suptrip Grenoble en Hiver', 5, '21-02-2016', '06-03-2016'),
(61, 'Voyage à Lille', 'Suptrip Lille en Hiver', 6, '21-02-2016', '06-03-2016'),
(62, 'Voyage à Tours', 'Suptrip Tours en Hivers', 7, '21-02-2016', '06-03-2016'),
(63, 'Voyage à Bruxelle', 'SupTrip Bruxelle en Hiver', 8, '21-02-2016', '06-03-2016'),
(64, 'Voyage à Londres', 'SupTrip Londres en Hiver', 9, '21-02-2016', '06-03-2016'),
(65, 'Voyage à Rome', 'SupTrip Rome en Hiver', 10, '21-02-2016', '06-03-2016'),
(66, 'Voyage à Montreal', 'SupTrip Montreal en Hiver', 11, '21-02-2016', '06-03-2016'),
(67, 'Voyage à San Francisco', 'SupTrip San Francisco en Hiver', 12, '21-02-2016', '06-03-2016'),
(68, 'Voyage aux île-Maurice', 'SupTrip île-Maurice en Hiver', 13, '21-02-2016', '06-03-2016'),
(69, 'Voyage à Rabat', 'SupTrip Rabat en Hiver', 14, '21-02-2016', '06-03-2016'),
(70, 'Voyage à Tianjin', 'SupTrip Tianjin en Hiver', 15, '21-02-2016', '06-03-2016'),
(71, 'Voyage à Zhenjiang', 'SupTrip Zhenjiang en Hiver', 16, '21-02-2016', '06-03-2016'),
(72, 'Voyage à Pékin', 'SupTrip Pékin en Hiver', 1, '28-02-2016', '13-03-2016'),
(73, 'Voyage à Paris', 'SupTrip Paris en Hiver', 2, '28-02-2016', '13-03-2016'),
(74, 'Voyage à Bordeaux', 'SupTrip Bordeaux en Hiver', 3, '28-02-2016', '13-03-2016'),
(75, 'Voyage à Caen', 'SupTrip Caen en Hiver', 4, '28-02-2016', '13-03-2016'),
(76, 'Voyage à Grenoble ', 'SupTrip Grenoble en Hiver', 5, '28-02-2016', '13-03-2016'),
(77, 'Voyage à Lille', 'SupTrip Lille en Hiver', 6, '28-02-2016', '13-03-2016'),
(78, 'Voyage à Tours', 'SupTrip Tours en Hiver', 7, '28-02-2016', '13-03-2016'),
(79, 'Voyage à Bruxelle', 'SupTrip Bruxelle en Hiver', 8, '28-02-2016', '13-03-2016'),
(80, 'Voyage à Londre', 'SupTrip Londre en Hiver', 9, '28-02-2016', '13-03-2016'),
(81, 'Voyage à Rome', 'SupTrip Rome en Hiver', 10, '28-02-2016', '13-03-2016'),
(82, 'Voyage à Montreal', 'SupTrip Montreal en Hiver', 11, '28-02-2016', '13-03-2016'),
(83, 'Voyage à SanFrancisco', 'SupTrip San Francisco en Hiver', 12, '28-02-2016', '13-03-2016'),
(84, 'Voyage aux île-Maurice', 'SupTrip île-Maurice en Hiver', 13, '28-02-2016', '13-03-2016'),
(85, 'Voyage à Rabat', 'SupTrip Rabat en Hiver', 14, '28-02-2016', '13-03-2016'),
(86, 'Voyage à Tienjin', 'SupTrip Tianjin en Hiver', 15, '28-02-2016', '13-03-2016'),
(87, 'Voyage à Zhenjiang', 'SupTrip Zhenjiang en Hiver', 16, '28-02-2016', '13-03-2016'),
(88, 'Voyage à Pékin', 'SupTrip Pékin en été', 1, '01-07-2016', '15-07-2016'),
(89, 'Voyage à Paris', 'SupTrip Paris en été', 2, '01-07-2016', '15-07-2015'),
(90, 'Voyage à Bordeaux', 'SupTrip Bordeaux en été', 3, '01-07-2016', '15-07-2016'),
(91, 'Voyage à Caen', 'SupTrip Caen en été', 4, '01-07-2016', '15-07-2016'),
(92, 'Voyage à Grenoble', 'SupTrip Grenoble en été', 5, '01-07-2016', '15-07-2016'),
(93, 'Voyage à Lille', 'SupTrip Lille en été', 6, '01-07-2016', '15-07-2016'),
(94, 'Voyage à Tours', 'SupTrip Tours en été', 7, '01-07-2016', '15-07-2016'),
(95, 'Voyage à Bruxelle', 'SupTrip Bruxelle en été', 8, '01-07-2016', '15-07-2016'),
(96, 'Voyage à Londre', 'SupTrip Londre en été', 9, '01-07-2016', '15-07-2016'),
(97, 'Voyage à Rome', 'SupTrip Rome en été', 10, '01-07-2016', '15-07-2016'),
(98, 'Voyage à Montreal', 'SupTrip Montreal en été', 11, '01-07-2016', '15-07-2016'),
(99, 'Voyage à San Francisco', 'SupTrip San Francisco en été', 12, '01-07-2016', '15-07-2016'),
(100, 'Voyage aux île-Maurice', 'SupTrip île-Maurice en été', 13, '01-07-2016', '15-07-2016'),
(101, 'Voyageà Rabat', 'SupTrip Rabat en été', 14, '01-07-2016', '15-07-2016'),
(102, 'Voyage à Tianjin', 'SupTrip Tianjin en été', 15, '01-07-2016', '15-07-2016'),
(103, 'Voyage à Zhenjiang', 'SupTrip Zhenjiang en été', 16, '01-07-2016', '15-07-2016'),
(104, 'Voyage à Pékin', 'SupTrip Pékin en été', 1, '08-07-2016', '22-07-2016'),
(105, 'Voyage à Paris', 'SupTrip Paris en été', 2, '08-07-2016', '22-07-2016'),
(106, 'Voyage à Bordeaux', 'SupTrip Bordeaux en été', 3, '08-07-2016', '22-07-2016'),
(107, 'Voyage à Caen', 'SupTrip Caen en été', 4, '08-07-2016', '22-07-2016'),
(108, 'Voyage à Grenoble', 'SupTrip Grenoble en été', 5, '08-07-2016', '22-07-2016'),
(109, 'Voyage à Lille', 'SupTrip Lille en été', 6, '08-07-2016', '22-07-2016'),
(110, 'Voyage à Tours', 'SupTrip Tours en été', 7, '08-07-2016', '22-07-2016'),
(111, 'Voyage à Bruxelles', 'SupTrip Bruxelles en été', 8, '08-07-2016', '22-07-2016'),
(112, 'Voyage à Londre', 'Suptrip Londre en été', 9, '08-07-2016', '22-07-2016'),
(113, 'Voyage à Rome', 'SupTrip Rome en été', 10, '08-07-2016', '22-07-2016'),
(114, 'Voyage à Montreal', 'SupTrip Montreal en été', 11, '08-07-2016', '22-07-2016'),
(115, 'Voyage à San Francisco', 'SupTrip San Francisco', 12, '08-07-2016', '22-07-2016'),
(116, 'Voyage aux île-Maurice', 'SupTrip île-Maurice en été', 13, '08-07-2016', '22-07-2016'),
(117, 'Voyage à Rabat', 'SupTrip Rabat en été', 14, '08-07-2016', '22-07-2016'),
(118, 'Voyage à Tianjin', 'SupTrip Tianjin en été', 15, '08-07-2016', '22-07-2016'),
(119, 'Voyage à Zhenjiang', 'SupTrip Zhenjiang en été', 16, '08-07-2016', '22-07-2016'),
(120, 'Voyage à Pékin', 'SupTrip Pékin en été', 1, '15-07-2016', '29-07-2016'),
(121, 'Voyage à Paris', 'SupTrip Paris en été', 2, '15-07-2016', '29-07-2016'),
(122, 'Voyage à Bordeaux', 'SupTrip Bordeaux en été', 3, '15-07-2016', '29-07-2016'),
(123, 'Voyage à Caen', 'SupTrip Caen en été', 4, '15-07-2016', '29-07-2016'),
(124, 'Voyage à Grenoble', 'SupTrip Grenoble en été', 5, '15-07-2016', '29-07-2016'),
(125, 'Voyage à Lille', 'SupTrip Lille en été', 6, '15-07-2016', '29-07-2016'),
(126, 'Voyage à Tours', 'SupTrip Tours en été', 7, '15-07-2016', '29-07-2016'),
(127, 'Voyage à Bruxelles', 'SupTrip Bruxelles en été', 8, '15-07-2016', '29-07-2016'),
(128, 'Voyage à Londre', 'SupTrip Londre en été', 9, '15-07-2016', '29-07-2016'),
(129, 'Voyage à Rome', 'SupTrip Rome en été', 10, '15-07-2016', '29-07-2016'),
(130, 'Voyage à Montreal', 'SupTrip Montreal en été', 11, '15-07-2016', '29-07-2016'),
(131, 'Voyage à San Francisco', 'SupTrip San Francisco', 12, '15-07-2016', '29-07-2016'),
(132, 'Voyage aux île-Maurice', 'SupTrip île-Maurice en été', 13, '15-07-2016', '29-07-2016'),
(133, 'Voyage à Rabat', 'SupTrip Rabat en été', 14, '15-07-2016', '29-07-2016'),
(134, 'Voyage à Tianjin', 'SupTrip Tianjin en été', 15, '15-07-2016', '29-07-2016'),
(135, 'Voyage à Zhenjiang', 'SupTrip Zhenjiang en été', 16, '15-07-2016', '29-07-2016');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `campus`
--
ALTER TABLE `campus`
  ADD CONSTRAINT `FKAE79ECDFDE16A30E` FOREIGN KEY (`country`) REFERENCES `pays` (`id_pays`);

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `FKA6AB45396A24FA45` FOREIGN KEY (`student`) REFERENCES `etudiants` (`idbooster`),
  ADD CONSTRAINT `FKA6AB453974B1DEF1` FOREIGN KEY (`voyage`) REFERENCES `trip` (`id_trip`);

--
-- Contraintes pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD CONSTRAINT `FK6EDB3A97576EC6C6` FOREIGN KEY (`universite`) REFERENCES `campus` (`id_campus`);

--
-- Contraintes pour la table `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `FK367425576EC6DA` FOREIGN KEY (`university`) REFERENCES `campus` (`id_campus`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
