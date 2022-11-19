drop table poseidonRecord.macchine;
drop table poseidonRecord.macchine_utenti;


CREATE TABLE poseidonRecord.macchine (
	id_macchina INT NOT null primary key AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	posti_andata INT not null,
	posti_ritorno INT not null,
	tipo INT not null,
	note VARCHAR(100) NOT NULL,
	proprietario INT not null,
	andata boolean not null,
	ritorno boolean not null,
		  CONSTRAINT `fk_macchina_utente`
    FOREIGN KEY (proprietario) REFERENCES utenti (id_utente),
	CONSTRAINT macchina_unique_utente UNIQUE (proprietario)
);



CREATE TABLE poseidonRecord.macchine_utenti (
	id_macchina_utente INT NOT null primary key AUTO_INCREMENT,
	macchina INT not null,
	passeggero INT NOT NULL,
	andata boolean not null,
	ritorno boolean not null,
		  CONSTRAINT `fk_macchina`
    FOREIGN KEY (macchina) REFERENCES macchine (id_macchina),
    		  CONSTRAINT `fk_macchina_utente_passeggero`
    FOREIGN KEY (passeggero) REFERENCES utenti (id_utente)
);