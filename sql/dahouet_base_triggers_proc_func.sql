-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 07 Mars 2017 à 13:38
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

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchEquipage` (IN `regId` VARCHAR(7), IN `numVoile` INT(1))  BEGIN


DECLARE v_finished INTEGER DEFAULT 0;
DECLARE v_numLicence INTEGER;
DECLARE v_name VARCHAR(50);

    select equi.numLicence_Concurrent as 'Numéro de licence', p.nomPersonne, part.numLicence_Concurrent as 'Skipper'  FROM participation part 
    inner join equipage equi
    on part.id = equi.id_Participation
    inner join `concurrent` c 
    ON c.numLicence = equi.numLicence_Concurrent
    inner join personne p
    on p.id = c.id_Personne
    WHERE part.id_Regate = regId
    AND part.numVoile_Voilier = numVoile;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getCommissarActions` (IN `startDate` DATE, IN `endDate` DATE)  BEGIN

declare v_finish integer default 0;
declare v_regId varchar(7);

DECLARE regate_cursor CURSOR 
	FOR 
		select r.id from regate r 
		WHERE r.dateReg < endDate 
		AND r.dateReg > startDate
        ORDER BY r.dateReg ASC;

DECLARE CONTINUE HANDLER
	FOR NOT FOUND SET v_finish = 1;
    
OPEN regate_cursor;
	
    get_commissars: LOOP
        
    FETCH regate_cursor INTO v_regId;
    
    IF v_finish = 1 THEN
		LEAVE get_commissars;
	END IF;
    
    SELECT r.dateReg AS 'Date Regate' FROM regate r 
    WHERE r.id = v_regId;  
    
    SELECT p.nomPersonne, comit.nomComite FROM juger j
	INNER JOIN comissaire comis 
	ON j.id_Comissaire = comis.id
	INNER JOIN personne p
	ON comis.id_Personne = p.id
	INNER JOIN comite_regional comit
	ON comit.id = comis.id_Comite_Regional
	WHERE j.id_Regate = v_regId;
      
    END LOOP get_commissars;
    
CLOSE regate_cursor;

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `moyDistReg` (IN `idChal` VARCHAR(5), OUT `moy` NUMERIC(4,2))  BEGIN

declare idReg VARCHAR(7);

select AVG(r.distance) into moy from regate r
where r.id_Challenge = idChal;

END$$

--
-- Fonctions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `setNewIdReg` (`idReg` VARCHAR(7)) RETURNS VARCHAR(9) CHARSET latin1 BEGIN

DECLARE dateReg DATE;
DECLARE monthReg,numReg, increment int(2);
DECLARE idChal varchar(5);
DECLARE newIdReg varchar(9);

SELECT r.id_Challenge INTO idChal from regate r WHERE r.id = idReg;

SELECT r.dateReg into dateReg FROM regate r where idReg = r.id;
SET monthReg = MONTH(dateReg);

SELECT count(r.id) INTO numReg from regate r 
WHERE r.id_Challenge = idChal;

set increment = numReg + 1;

IF increment < 10 THEN 

SET newIdReg = concat(idChal, 0 ,monthReg, increment);

ELSE 
SET newIdReg = concat(idChal ,monthReg, increment);
END IF;

RETURN newIdReg;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `challenge`
--

CREATE TABLE `challenge` (
  `id` varchar(5) NOT NULL,
  `debChal` date NOT NULL,
  `finChal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id` int(11) NOT NULL,
  `typeSerie` char(1) NOT NULL,
  `nomClasse` varchar(50) NOT NULL,
  `coefClasse` decimal(4,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `club_nautique`
--

CREATE TABLE `club_nautique` (
  `id` int(11) NOT NULL,
  `nomClub` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `codes_resultats`
--

CREATE TABLE `codes_resultats` (
  `code` varchar(3) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comissaire`
--

CREATE TABLE `comissaire` (
  `id` int(11) NOT NULL,
  `id_Personne` int(11) DEFAULT NULL,
  `id_Comite_Regional` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `comite_regional`
--

CREATE TABLE `comite_regional` (
  `id` int(11) NOT NULL,
  `nomComite` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `concurrent`
--

CREATE TABLE `concurrent` (
  `numLicence` int(11) NOT NULL,
  `anneeLic` year(4) NOT NULL,
  `id_Personne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `equipage`
--

CREATE TABLE `equipage` (
  `id_Participation` int(11) NOT NULL,
  `numLicence_Concurrent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `juger`
--

CREATE TABLE `juger` (
  `id_Comissaire` int(11) NOT NULL,
  `id_Regate` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id` int(11) NOT NULL,
  `tpsComp` time DEFAULT NULL,
  `rangReg` int(11) DEFAULT NULL,
  `scrReg` int(11) DEFAULT NULL,
  `id_Regate` varchar(7) NOT NULL,
  `numVoile_Voilier` int(11) NOT NULL,
  `numLicence_Concurrent` int(11) NOT NULL,
  `id_Codes_Resultats` int(11) NOT NULL,
  `tpsReel` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déclencheurs `participation`
--
DELIMITER $$
CREATE TRIGGER `participation_BEFORE_UPDATE` BEFORE UPDATE ON `participation` FOR EACH ROW BEGIN

DECLARE numPart, rank INTEGER;
DECLARE out_of_range_rank CONDITION FOR SQLSTATE '22000';

DECLARE EXIT HANDLER FOR out_of_range_rank
RESIGNAL SET message_text = 'Rank of participant cannot be greater than total number of participants';

SELECT COUNT(p.id) INTO numPart FROM participation p
INNER JOIN regate r 
ON r.id = p.id_Regate
WHERE p.id_Regate = OLD.id_Regate;

SET rank = NEW.rangReg;

IF rank > numPart THEN
SIGNAL out_of_range_rank;
END IF;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `id` int(11) NOT NULL,
  `nomPersonne` varchar(50) NOT NULL,
  `prenomPersonne` varchar(50) NOT NULL,
  `dateNaissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `id_Personne` int(11) DEFAULT NULL,
  `id_Club_Nautique` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `regate`
--

CREATE TABLE `regate` (
  `id` varchar(7) NOT NULL,
  `dateReg` date NOT NULL,
  `distance` decimal(4,1) NOT NULL,
  `id_Challenge` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déclencheurs `regate`
--
DELIMITER $$
CREATE TRIGGER `regate_BEFORE_DELETE` BEFORE DELETE ON `regate` FOR EACH ROW BEGIN

DECLARE endChal, dateReg DATE;
DECLARE challenge_unfinished CONDITION FOR sqlstate '22000';

DECLARE EXIT HANDLER FOR challenge_unfinished
RESIGNAL SET MESSAGE_TEXT = 'Deleting regate associated to an unfinished challenge is forbidden';

SET dateReg = OLD.dateReg;
SELECT finChal INTO endChal from challenge  c WHERE c.id = OLD.id_Challenge;

IF endChal > NOW() THEN

SIGNAL challenge_unfinished;

END IF;

END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `regate_BEFORE_INSERT` BEFORE INSERT ON `regate` FOR EACH ROW BEGIN
DECLARE startChal, endChal DATE;
DECLARE dates_mismatch CONDITION FOR sqlstate '22000';
DECLARE EXIT HANDLER FOR dates_mismatch
RESIGNAL SET MESSAGE_TEXT = 'Regate date is not defined between starting and ending dates of challenge';

SELECT debChal INTO startChal FROM challenge chal WHERE NEW.id_Challenge = chal.id;
SELECT finChal INTO endChal FROM challenge chal WHERE NEW.id_Challenge = chal.id;
 
IF (NEW.dateReg < startChal) OR (NEW.dateReg > endChal) THEN

SIGNAL dates_mismatch;

END IF;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `resultat_challenge`
--

CREATE TABLE `resultat_challenge` (
  `scrChal` int(11) DEFAULT NULL,
  `rangChal` int(11) DEFAULT NULL,
  `id_Challenge` varchar(5) NOT NULL,
  `numVoile_Voilier` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `voilier`
--

CREATE TABLE `voilier` (
  `numVoile` int(11) NOT NULL,
  `nomVoilier` varchar(50) NOT NULL,
  `id_Proprietaire` int(11) DEFAULT NULL,
  `id_Classe` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `challenge`
--
ALTER TABLE `challenge`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `club_nautique`
--
ALTER TABLE `club_nautique`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `codes_resultats`
--
ALTER TABLE `codes_resultats`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `comissaire`
--
ALTER TABLE `comissaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Comissaire_id_Personne` (`id_Personne`),
  ADD KEY `FK_Comissaire_id_Comite_Regional` (`id_Comite_Regional`);

--
-- Index pour la table `comite_regional`
--
ALTER TABLE `comite_regional`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `concurrent`
--
ALTER TABLE `concurrent`
  ADD PRIMARY KEY (`numLicence`),
  ADD KEY `FK_Concurrent_id_Personne` (`id_Personne`);

--
-- Index pour la table `equipage`
--
ALTER TABLE `equipage`
  ADD PRIMARY KEY (`id_Participation`,`numLicence_Concurrent`),
  ADD KEY `FK_Equipage_numLicence_Concurrent` (`numLicence_Concurrent`);

--
-- Index pour la table `juger`
--
ALTER TABLE `juger`
  ADD PRIMARY KEY (`id_Comissaire`,`id_Regate`),
  ADD KEY `FK_Juger_id_Regate` (`id_Regate`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Participation_id_Regate` (`id_Regate`),
  ADD KEY `FK_Participation_numVoile_Voilier` (`numVoile_Voilier`),
  ADD KEY `FK_Participation_numLicence_Concurrent` (`numLicence_Concurrent`),
  ADD KEY `FK_Participation_id_Codes_Resultats` (`id_Codes_Resultats`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Proprietaire_id_Personne` (`id_Personne`),
  ADD KEY `FK_Proprietaire_id_Club_Nautique` (`id_Club_Nautique`);

--
-- Index pour la table `regate`
--
ALTER TABLE `regate`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Regate_id_Challenge` (`id_Challenge`);

--
-- Index pour la table `resultat_challenge`
--
ALTER TABLE `resultat_challenge`
  ADD PRIMARY KEY (`id_Challenge`,`numVoile_Voilier`),
  ADD KEY `FK_Resultat_Challenge_numVoile_Voilier` (`numVoile_Voilier`);

--
-- Index pour la table `voilier`
--
ALTER TABLE `voilier`
  ADD PRIMARY KEY (`numVoile`),
  ADD KEY `FK_Voilier_id_Proprietaire` (`id_Proprietaire`),
  ADD KEY `FK_Voilier_id_Classe` (`id_Classe`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `club_nautique`
--
ALTER TABLE `club_nautique`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `codes_resultats`
--
ALTER TABLE `codes_resultats`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `comissaire`
--
ALTER TABLE `comissaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `comite_regional`
--
ALTER TABLE `comite_regional`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `participation`
--
ALTER TABLE `participation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `voilier`
--
ALTER TABLE `voilier`
  MODIFY `numVoile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `comissaire`
--
ALTER TABLE `comissaire`
  ADD CONSTRAINT `FK_Comissaire_id_Comite_Regional` FOREIGN KEY (`id_Comite_Regional`) REFERENCES `comite_regional` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Comissaire_id_Personne` FOREIGN KEY (`id_Personne`) REFERENCES `personne` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `concurrent`
--
ALTER TABLE `concurrent`
  ADD CONSTRAINT `FK_Concurrent_id_Personne` FOREIGN KEY (`id_Personne`) REFERENCES `personne` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `equipage`
--
ALTER TABLE `equipage`
  ADD CONSTRAINT `FK_Equipage_id_Participation` FOREIGN KEY (`id_Participation`) REFERENCES `participation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Equipage_numLicence_Concurrent` FOREIGN KEY (`numLicence_Concurrent`) REFERENCES `concurrent` (`numLicence`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `juger`
--
ALTER TABLE `juger`
  ADD CONSTRAINT `FK_Juger_id_Comissaire` FOREIGN KEY (`id_Comissaire`) REFERENCES `comissaire` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Juger_id_Regate` FOREIGN KEY (`id_Regate`) REFERENCES `regate` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `FK_Participation_id_Codes_Resultats` FOREIGN KEY (`id_Codes_Resultats`) REFERENCES `codes_resultats` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Participation_id_Regate` FOREIGN KEY (`id_Regate`) REFERENCES `regate` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Participation_numLicence_Concurrent` FOREIGN KEY (`numLicence_Concurrent`) REFERENCES `concurrent` (`numLicence`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Participation_numVoile_Voilier` FOREIGN KEY (`numVoile_Voilier`) REFERENCES `voilier` (`numVoile`);

--
-- Contraintes pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD CONSTRAINT `FK_Proprietaire_id_Club_Nautique` FOREIGN KEY (`id_Club_Nautique`) REFERENCES `club_nautique` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Proprietaire_id_Personne` FOREIGN KEY (`id_Personne`) REFERENCES `personne` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `regate`
--
ALTER TABLE `regate`
  ADD CONSTRAINT `FK_Regate_id_Challenge` FOREIGN KEY (`id_Challenge`) REFERENCES `challenge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `resultat_challenge`
--
ALTER TABLE `resultat_challenge`
  ADD CONSTRAINT `FK_Resultat_Challenge_id_Challenge` FOREIGN KEY (`id_Challenge`) REFERENCES `challenge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Resultat_Challenge_numVoile_Voilier` FOREIGN KEY (`numVoile_Voilier`) REFERENCES `voilier` (`numVoile`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `voilier`
--
ALTER TABLE `voilier`
  ADD CONSTRAINT `FK_Voilier_id_Classe` FOREIGN KEY (`id_Classe`) REFERENCES `classe` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_Voilier_id_Proprietaire` FOREIGN KEY (`id_Proprietaire`) REFERENCES `proprietaire` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
