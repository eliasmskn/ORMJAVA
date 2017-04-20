drop database if exists gestion_planning;
create database gestion_planning;

use gestion_planning;
create table salle(
	id_salle int(3)  auto_increment,
	numero_salle varchar(55) not null,
	capacite int (3) not null,	
	primary key (id_salle)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table classe(
	id_classe int(3) auto_increment,
	nb_eleve int(3) not null,
	niveau varchar(100) not null,
	primary key (id_classe)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table professeur(
	id_prof int(3)  auto_increment,
	nom varchar(100) not null,
	prenom varchar(100) not null,
	identifiant varchar(100) not null,
	mdp varchar(55) not null,
	primary key (id_prof)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table matiere(
	id_matiere int(3)  auto_increment,
	libelle varchar(100) not null,
	primary key (id_matiere)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table affectation(
	id_affectation int(3)  auto_increment,
	id_prof int(3) not null,
	id_matiere int(3) not null,
	primary key (id_affectation),
	foreign key (id_prof) references professeur (id_prof),
	foreign key (id_matiere) references matiere (id_matiere)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table cours(
	id_cours int(3)  auto_increment,
	libelle varchar (55) not null,
	id_salle int(3) not null,
	id_classe int(3) not null,
	id_affectation int(3) not null,
	primary key (id_cours),
	foreign key (id_affectation) references professeur (id_prof),
	foreign key (id_salle) references salle (id_salle),
	foreign key (id_classe) references classe (id_classe)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table Admin(
	id_admin int(3)  auto_increment,
	nom varchar(100) not null,
	prenom varchar(100) not null,
	identifiant varchar(100) not null,
	mdp varchar(55) not null,
	primary key (id_admin)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;