-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Client :  localhost
-- Généré le :  Mer 24 Mai 2017 à 00:35
-- Version du serveur :  5.6.35
-- Version de PHP :  7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `gestion_planning`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(3) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `identifiant` varchar(100) NOT NULL,
  `mdp` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `admin`
--

INSERT INTO `admin` (`id_admin`, `nom`, `prenom`, `identifiant`, `mdp`) VALUES
(1, 'aubam', 'mams', 'gotze19', 'Tchayy');

-- --------------------------------------------------------

--
-- Structure de la table `affectation`
--

CREATE TABLE `affectation` (
  `id_affectation` int(3) NOT NULL,
  `id_prof` int(3) NOT NULL,
  `id_matiere` int(3) NOT NULL,
  `id_classe` int(3) NOT NULL,
  `id_salle` int(3) NOT NULL,
  `date` datetime NOT NULL,
  `duree` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `affectation`
--

INSERT INTO `affectation` (`id_affectation`, `id_prof`, `id_matiere`, `id_classe`, `id_salle`, `date`, `duree`) VALUES
(4, 1, 1, 2, 2, '2017-05-25 10:20:00', '01:00:00'),
(5, 1, 1, 4, 2, '2017-05-24 00:00:00', '02:30:00'),
(6, 1, 1, 3, 2, '2017-05-25 14:20:00', '02:00:00'),
(7, 2, 4, 4, 5, '2017-05-17 08:30:00', '04:00:00'),
(8, 3, 2, 3, 4, '2017-06-01 14:00:00', '04:00:00'),
(9, 2, 2, 4, 3, '2017-05-24 00:07:00', '01:00:00');

--
-- Déclencheurs `affectation`
--
DELIMITER $$
CREATE TRIGGER `insert_affectation` BEFORE INSERT ON `affectation` FOR EACH ROW BEGIN
    IF (NEW.date <= NOW()) THEN 
        SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Warning: date deja passee !';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `id_classe` int(3) NOT NULL,
  `nb_eleve` int(3) NOT NULL,
  `niveau` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `classe`
--

INSERT INTO `classe` (`id_classe`, `nb_eleve`, `niveau`) VALUES
(1, 17, 'seconde 7'),
(2, 45, 'ter S 3'),
(3, 25, 'ter ES 4'),
(4, 30, '1 ère 1');

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

CREATE TABLE `cours` (
  `id_cours` int(3) NOT NULL,
  `libelle` varchar(55) NOT NULL,
  `id_salle` int(3) NOT NULL,
  `id_classe` int(3) NOT NULL,
  `id_affectation` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `id_matiere` int(3) NOT NULL,
  `libelle` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `matiere`
--

INSERT INTO `matiere` (`id_matiere`, `libelle`) VALUES
(1, 'Algo'),
(2, 'Maths'),
(3, 'Francais'),
(4, 'Programmation'),
(5, 'Administration réseau');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `planning`
-- (Voir ci-dessous la vue réelle)
--
CREATE TABLE `planning` (
`id_prof` int(3)
,`nom` varchar(100)
,`classe` varchar(100)
,`salle` varchar(55)
,`matiere` varchar(100)
,`date` datetime
,`durée` time
);

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `id_prof` int(3) NOT NULL,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `identifiant` varchar(100) NOT NULL,
  `mdp` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `professeur`
--

INSERT INTO `professeur` (`id_prof`, `nom`, `prenom`, `identifiant`, `mdp`) VALUES
(1, 'mskn', 'elias', 'Elias934', 'tchayy'),
(2, 'Yagoubi', 'Maïssane', 'Maïssouuuuu', 'Kanye'),
(3, 'chien', 'Chienne', 'chienchein', 'merde'),
(4, 'Jouanny', 'Jerome', 'jayjay', '92i');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `id_salle` int(3) NOT NULL,
  `numero_salle` varchar(55) NOT NULL,
  `capacite` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `salle`
--

INSERT INTO `salle` (`id_salle`, `numero_salle`, `capacite`) VALUES
(1, '1', 23),
(2, '102', 34),
(3, '304', 75),
(4, 'AMPHI 1', 19),
(5, '209', 20);

-- --------------------------------------------------------

--
-- Structure de la vue `planning`
--
DROP TABLE IF EXISTS `planning`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `planning`  AS  select `professeur`.`id_prof` AS `id_prof`,`professeur`.`nom` AS `nom`,`classe`.`niveau` AS `classe`,`salle`.`numero_salle` AS `salle`,`matiere`.`libelle` AS `matiere`,`affectation`.`date` AS `date`,`affectation`.`duree` AS `durée` from ((((`professeur` join `classe`) join `salle`) join `matiere`) join `affectation`) where ((`professeur`.`id_prof` = `affectation`.`id_prof`) and (`classe`.`id_classe` = `affectation`.`id_classe`) and (`matiere`.`id_matiere` = `affectation`.`id_matiere`) and (`salle`.`id_salle` = `affectation`.`id_salle`)) ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Index pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD PRIMARY KEY (`id_affectation`),
  ADD KEY `id_prof` (`id_prof`),
  ADD KEY `id_matiere` (`id_matiere`),
  ADD KEY `id_classe` (`id_classe`),
  ADD KEY `id_salle` (`id_salle`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id_classe`);

--
-- Index pour la table `cours`
--
ALTER TABLE `cours`
  ADD PRIMARY KEY (`id_cours`),
  ADD KEY `id_affectation` (`id_affectation`),
  ADD KEY `id_salle` (`id_salle`),
  ADD KEY `id_classe` (`id_classe`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id_matiere`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id_prof`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id_salle`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `affectation`
--
ALTER TABLE `affectation`
  MODIFY `id_affectation` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `classe`
--
ALTER TABLE `classe`
  MODIFY `id_classe` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `cours`
--
ALTER TABLE `cours`
  MODIFY `id_cours` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `id_matiere` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `id_prof` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `id_salle` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `affectation`
--
ALTER TABLE `affectation`
  ADD CONSTRAINT `affectation_ibfk_1` FOREIGN KEY (`id_prof`) REFERENCES `professeur` (`id_prof`),
  ADD CONSTRAINT `affectation_ibfk_2` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id_matiere`),
  ADD CONSTRAINT `affectation_ibfk_3` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`),
  ADD CONSTRAINT `affectation_ibfk_4` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id_salle`);

--
-- Contraintes pour la table `cours`
--
ALTER TABLE `cours`
  ADD CONSTRAINT `cours_ibfk_1` FOREIGN KEY (`id_affectation`) REFERENCES `professeur` (`id_prof`),
  ADD CONSTRAINT `cours_ibfk_2` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id_salle`),
  ADD CONSTRAINT `cours_ibfk_3` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`);
