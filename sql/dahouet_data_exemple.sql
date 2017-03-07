-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 07 Mars 2017 à 13:39
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `dahouet`
--

--
-- Contenu de la table `challenge`
--

INSERT INTO `challenge` (`id`, `debChal`, `finChal`) VALUES
('E2016', '2016-05-01', '2016-09-30'),
('E2017', '2017-05-01', '2017-09-30'),
('H2016', '2015-11-01', '2016-03-30'),
('H2017', '2016-11-01', '2017-03-30');

--
-- Contenu de la table `classe`
--

INSERT INTO `classe` (`id`, `typeSerie`, `nomClasse`, `coefClasse`) VALUES
(1, 'H', 'Corsaire', '0.520'),
(2, 'H', 'Surprise', '0.320'),
(3, 'H', '8 metres', '0.750'),
(4, 'H', 'Maraudeur', '0.885'),
(5, 'H', 'Figaro', '1.100'),
(6, 'Q', 'Flying Fifteen', '0.998'),
(7, 'Q', 'Soling', '1.200'),
(8, 'Q', 'Star', '1.589'),
(9, 'Q', 'Tempest', '1.700'),
(10, 'Q', 'Yngling', '0.850');

--
-- Contenu de la table `club_nautique`
--

INSERT INTO `club_nautique` (`id`, `nomClub`) VALUES
(1, 'YC Val André'),
(2, 'YC Le Legué'),
(3, 'YC Binic'),
(4, 'YC Saint Quay'),
(5, 'YC Blop');

--
-- Contenu de la table `codes_resultats`
--

INSERT INTO `codes_resultats` (`code`, `id`) VALUES
('DNC', 1),
('DNS', 2),
('OCS', 3),
('ZFP', 4),
('BFD', 5),
('DNF', 6),
('RAF', 7),
('DSQ', 8),
('DNE', 9),
('DGM', 10),
('RAS', 11);

--
-- Contenu de la table `comissaire`
--

INSERT INTO `comissaire` (`id`, `id_Personne`, `id_Comite_Regional`) VALUES
(1, 12, 1),
(2, 13, 1),
(3, 14, 2),
(4, 15, 2);

--
-- Contenu de la table `comite_regional`
--

INSERT INTO `comite_regional` (`id`, `nomComite`) VALUES
(1, 'Bretagne'),
(2, 'Normandie');

--
-- Contenu de la table `concurrent`
--

INSERT INTO `concurrent` (`numLicence`, `anneeLic`, `id_Personne`) VALUES
(5957, 2017, 17),
(6587, 2017, 21),
(8889, 2017, 19),
(9875, 2017, 25),
(9999, 2016, 18),
(66445, 2017, 28),
(84564, 2017, 22),
(89557, 2017, 24),
(111112, 2017, 27),
(221121, 2017, 16),
(9875754, 2017, 23),
(88648648, 2017, 20),
(95752124, 2017, 26);

--
-- Contenu de la table `equipage`
--

INSERT INTO `equipage` (`id_Participation`, `numLicence_Concurrent`) VALUES
(2, 9875),
(2, 66445),
(2, 84564),
(3, 89557),
(3, 111112),
(3, 221121),
(4, 9875754),
(4, 88648648);

--
-- Contenu de la table `juger`
--

INSERT INTO `juger` (`id_Comissaire`, `id_Regate`) VALUES
(1, 'E201702'),
(2, 'E201702'),
(2, 'E201706'),
(3, 'E201706'),
(1, 'H201603'),
(3, 'H201603'),
(1, 'H201607'),
(4, 'H201607'),
(1, 'H201703'),
(4, 'H201703'),
(2, 'H201709'),
(4, 'H201709');

--
-- Contenu de la table `participation`
--

INSERT INTO `participation` (`id`, `tpsComp`, `rangReg`, `scrReg`, `id_Regate`, `numVoile_Voilier`, `numLicence_Concurrent`, `id_Codes_Resultats`, `tpsReel`) VALUES
(2, '02:39:00', 1, 1, 'H201703', 1, 5957, 11, '03:00:00'),
(3, '03:59:00', 2, 2, 'H201703', 2, 6587, 11, '04:00:00'),
(4, '04:56:00', 3, 3, 'H201703', 3, 8889, 11, '04:30:00'),
(5, NULL, NULL, NULL, 'E201702', 1, 95752124, 11, NULL),
(6, NULL, NULL, NULL, 'H201709', 1, 221121, 11, NULL),
(7, NULL, NULL, NULL, 'H201709', 4, 95752124, 11, NULL);

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`id`, `nomPersonne`, `prenomPersonne`, `dateNaissance`) VALUES
(7, 'Martin', 'Marcel', '1960-07-31'),
(8, 'de La Montagne', 'Hubert', '1970-08-15'),
(9, 'Quintin', 'Corentin', '1980-01-15'),
(10, 'du Port', 'Emilie', '1982-02-19'),
(11, 'Le Jay', 'Roger', '1975-03-10'),
(12, 'De Carquefou', 'Hélène', '1990-02-17'),
(13, 'La Poste', 'René', '1958-05-19'),
(14, 'Bellamy', 'Rémy', '1979-09-15'),
(15, 'Le Bel', 'Hector', '1965-04-05'),
(16, 'Le Fort', 'Clarisse', '1978-06-01'),
(17, 'Anne', 'Erwan', '1998-07-18'),
(18, 'Simon', 'Christophe', '1980-10-10'),
(19, 'Le Henaff', 'Gwenolé', '1985-04-10'),
(20, 'Fourteau', 'Lucas', '1990-06-12'),
(21, 'Chenier', 'Tanguy', '1986-02-15'),
(22, 'Balcon', 'Yoann', '1988-12-17'),
(23, 'Vanel', 'Rémi', '1985-05-17'),
(24, 'Callec', 'Yoann', '1992-11-01'),
(25, 'Lopez', 'Richard', '1987-01-15'),
(26, 'Lengaigne', 'Nicolas', '1985-05-30'),
(27, 'Nagepas', 'Jean-Michel', '1975-01-20'),
(28, 'Le Goff', 'Bob', '1997-11-02'),
(29, 'Bli', 'Blu', '2017-03-11');

--
-- Contenu de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `id_Personne`, `id_Club_Nautique`) VALUES
(1, 7, 1),
(2, 8, 2),
(3, 9, 3),
(4, 10, 4),
(5, 11, 5),
(6, 29, 1);

--
-- Contenu de la table `regate`
--

INSERT INTO `regate` (`id`, `dateReg`, `distance`, `id_Challenge`) VALUES
('E201702', '2017-05-19', '23.2', 'E2017'),
('E201706', '2017-07-01', '33.1', 'E2017'),
('H201603', '2015-12-02', '23.2', 'H2016'),
('H201607', '2016-06-15', '6.4', 'E2016'),
('H201703', '2017-02-20', '20.2', 'H2017'),
('H201709', '2017-03-08', '30.1', 'H2017');

--
-- Contenu de la table `voilier`
--

INSERT INTO `voilier` (`numVoile`, `nomVoilier`, `id_Proprietaire`, `id_Classe`) VALUES
(1, 'L\'Epave', 1, 4),
(2, 'L\'Endurence', 2, 6),
(3, 'Le Condor', 3, 5),
(4, 'Tempête de Bière', 4, 10),
(5, 'Jolly Roger', 5, 8);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
