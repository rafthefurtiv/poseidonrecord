drop table poseidonRecord.record;
drop table poseidonRecord.utenti;
drop table poseidonRecord.stili;
drop table poseidonRecord.categorie;

CREATE TABLE poseidonRecord.utenti (
	id_utente INT NOT null primary key AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	cognome VARCHAR(100) NOT NULL,
	email VARCHAR(200) not NULL,
	username VARCHAR(100) not NULL,
	password VARCHAR(100) not NULL,
	codice_sesso VARCHAR(1) not NULL,
	medaglie_oro INT not null,
	medaglie_argento INT not null,
	medaglie_bronzo INT not null,
	medaglie_oro_staffetta INT not null,
	medaglie_argento_staffetta INT not null,
	medaglie_bronzo_staffetta INT not null,
	descrizione VARCHAR(1024),
	CONSTRAINT utenti_unique_username UNIQUE (username),
	CONSTRAINT utenti_unique_email UNIQUE (email)
);

CREATE TABLE poseidonRecord.stili (
	id_stile INT NOT null primary key AUTO_INCREMENT,
	descrizione VARCHAR(48) not null,
	descrizione_breve VARCHAR(2) not null,
	CONSTRAINT stili_unique UNIQUE (descrizione)
);

CREATE TABLE poseidonRecord.categorie (
	id_categoria INT NOT null primary key AUTO_INCREMENT,
	codice_categoria VARCHAR(3) not null,
	CONSTRAINT categoria_unique UNIQUE (codice_categoria)
);

CREATE TABLE poseidonRecord.record (
	id_record INT NOT null primary key AUTO_INCREMENT,
	utente INT not NULL,
	metri INT not NULL,
	stile INT not NULL,
	flag_vasca_corta INT not NULL,
	flag_societario INT,
	tempo FLOAT not null,
	categoria int not null,
	  CONSTRAINT `fk_record_stile`
    FOREIGN KEY (stile) REFERENCES stili (id_stile),
	  CONSTRAINT `fk_record_utente`
    FOREIGN KEY (utente) REFERENCES Utenti (id_utente),
    	  CONSTRAINT `fk_record_categoria`
    FOREIGN KEY (categoria) REFERENCES categorie (id_categoria),
    CONSTRAINT record_unique UNIQUE (utente, metri, stile, flag_vasca_corta, flag_societario, categoria)
);

create or replace view poseidonrecord.v_record as
select u.username, r.metri, s.descrizione as Stile, r.flag_vasca_corta, c.codice_categoria as Categoria, r.tempo
from poseidonRecord.record r
inner join poseidonRecord.utenti u on u.id_utente = r.utente
inner join poseidonRecord.stili s on s.id_stile = r.stile
inner join poseidonRecord.categorie c on c.id_categoria = r.categoria;


-- ESEMPI DML----------------------------------------
-- UTENTI
 -- insert into poseidonRecord.Utenti (nome, cognome, email, username, password, codice_sesso, medaglie_oro, medaglie_argento,medaglie_bronzo,
 -- medaglie_oro_staffetta, medaglie_argento_staffetta, medaglie_bronzo_staffetta)
 -- values ("Test", "Test", "test@gmail.com", "Test", "Test", 1, 0, 0, 0, 0, 0, 0);


-- STILI
insert into poseidonRecord.stili (descrizione, descrizione_breve) values ("Stile", "SL");
insert into poseidonRecord.stili (descrizione, descrizione_breve) values ("Dorso", "DO");
insert into poseidonRecord.stili (descrizione, descrizione_breve) values ("Rana", "RA");
insert into poseidonRecord.stili (descrizione, descrizione_breve) values ("Farfalla", "FA");
insert into poseidonRecord.stili (descrizione, descrizione_breve) values ("Misti", "MX");

-- CATEGORIE
insert into poseidonRecord.categorie (codice_categoria) values ("U20");
insert into poseidonRecord.categorie (codice_categoria) values ("M20");
insert into poseidonRecord.categorie (codice_categoria) values ("M25");
insert into poseidonRecord.categorie (codice_categoria) values ("M30");
insert into poseidonRecord.categorie (codice_categoria) values ("M35");
insert into poseidonRecord.categorie (codice_categoria) values ("M40");
insert into poseidonRecord.categorie (codice_categoria) values ("M45");
insert into poseidonRecord.categorie (codice_categoria) values ("M50");
insert into poseidonRecord.categorie (codice_categoria) values ("M55");
insert into poseidonRecord.categorie (codice_categoria) values ("M60");
insert into poseidonRecord.categorie (codice_categoria) values ("M65");
insert into poseidonRecord.categorie (codice_categoria) values ("M70");
insert into poseidonRecord.categorie (codice_categoria) values ("M75");
insert into poseidonRecord.categorie (codice_categoria) values ("M80");
insert into poseidonRecord.categorie (codice_categoria) values ("M85");
insert into poseidonRecord.categorie (codice_categoria) values ("M90");
insert into poseidonRecord.categorie (codice_categoria) values ("M95");





-- RECORD
-- insert into poseidonRecord.record (utente, metri, stile, flag_vasca_corta, flag_societario, categoria, tempo)
-- values (1, 200, 1, 1, 1, 1, 33.54);
-- insert into poseidonRecord.record (utente, metri, stile, flag_vasca_corta, flag_societario, categoria, tempo)
-- values (1, 100, 1, 0, 0, 2, 34.54);
-- insert into poseidonRecord.record (utente, metri, stile, flag_vasca_corta, flag_societario, categoria, tempo)
-- values (2, 100, 3, 0, 1, 3, 33.54);
-- insert into poseidonRecord.record (utente, metri, stile, flag_vasca_corta, flag_societario, categoria, tempo)
-- values (3, 200, 2, 1, 0, 4, 33.54);












