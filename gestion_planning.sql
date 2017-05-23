SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE IF NOT EXISTS `gestion_planning` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gestion_planning`;

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(3) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `identifiant` varchar(100) NOT NULL,
  `mdp` varchar(55) NOT NULL,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

INSERT INTO `admin` (`id_admin`, `nom`, `prenom`, `identifiant`, `mdp`) VALUES
(1, 'aubam', 'mams', 'gotze19', 'Tchayy');

CREATE TABLE IF NOT EXISTS `affectation` (
  `id_affectation` int(3) NOT NULL AUTO_INCREMENT,
  `id_prof` int(3) NOT NULL,
  `id_matiere` int(3) NOT NULL,
  `id_classe` int(3) NOT NULL,
  `id_salle` int(3) NOT NULL,
  `date` datetime NOT NULL,
  `duree` time NOT NULL,
  PRIMARY KEY (`id_affectation`),
  KEY `id_prof` (`id_prof`),
  KEY `id_matiere` (`id_matiere`),
  KEY `id_classe` (`id_classe`),
  KEY `id_salle` (`id_salle`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

INSERT INTO `affectation` (`id_affectation`, `id_prof`, `id_matiere`, `id_classe`, `id_salle`, `date`, `duree`) VALUES
(4, 1, 1, 2, 2, '2017-05-25 10:20:00', '01:00:00'),
(5, 1, 1, 2, 2, '2017-05-24 00:00:00', '02:30:00');

CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` int(3) NOT NULL AUTO_INCREMENT,
  `nb_eleve` int(3) NOT NULL,
  `niveau` varchar(100) NOT NULL,
  PRIMARY KEY (`id_classe`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

INSERT INTO `classe` (`id_classe`, `nb_eleve`, `niveau`) VALUES
(2, 45, 'ter S 3');

CREATE TABLE IF NOT EXISTS `cours` (
  `id_cours` int(3) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(55) NOT NULL,
  `id_salle` int(3) NOT NULL,
  `id_classe` int(3) NOT NULL,
  `id_affectation` int(3) NOT NULL,
  PRIMARY KEY (`id_cours`),
  KEY `id_affectation` (`id_affectation`),
  KEY `id_salle` (`id_salle`),
  KEY `id_classe` (`id_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `matiere` (
  `id_matiere` int(3) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(100) NOT NULL,
  PRIMARY KEY (`id_matiere`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

INSERT INTO `matiere` (`id_matiere`, `libelle`) VALUES
(1, 'Algo');

CREATE TABLE IF NOT EXISTS `professeur` (
  `id_prof` int(3) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `identifiant` varchar(100) NOT NULL,
  `mdp` varchar(55) NOT NULL,
  PRIMARY KEY (`id_prof`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

INSERT INTO `professeur` (`id_prof`, `nom`, `prenom`, `identifiant`, `mdp`) VALUES
(1, 'mskn', 'elias', 'Elias934', 'tchayy'),
(3, 'chien', 'Chienne', 'chienchein', 'merde'),
(4, 'ff', '', '', '');

CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` int(3) NOT NULL AUTO_INCREMENT,
  `numero_salle` varchar(55) NOT NULL,
  `capacite` int(3) NOT NULL,
  PRIMARY KEY (`id_salle`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

INSERT INTO `salle` (`id_salle`, `numero_salle`, `capacite`) VALUES
(2, '1', 20);


ALTER TABLE `affectation`
  ADD CONSTRAINT `affectation_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `professeur` (`id_prof`),
  ADD CONSTRAINT `affectation_ibfk_2` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id_matiere`),
  ADD CONSTRAINT `affectation_ibfk_3` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `affectation_ibfk_4` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id_salle`);

ALTER TABLE `cours`
  ADD CONSTRAINT `cours_ibfk_1` FOREIGN KEY (`id_affectation`) REFERENCES `professeur` (`id_prof`),
  ADD CONSTRAINT `cours_ibfk_2` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id_salle`),
  ADD CONSTRAINT `cours_ibfk_3` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
