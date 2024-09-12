-- poseidonRecord.message definition

CREATE TABLE `message` (
  `id_messaggio` int(11) NOT NULL AUTO_INCREMENT,
  `messaggio` varchar(500) NOT NULL,
  `owner` varchar(1) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id_messaggio`)
) ENGINE=InnoDB AUTO_INCREMENT=419 DEFAULT CHARSET=utf8mb4;



-- poseidonRecord.ultimo_accesso definition

CREATE TABLE `ultimo_accesso` (
  `owner` varchar(1) NOT NULL,
  `timestamp` timestamp NOT NULL,
  PRIMARY KEY (`owner`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;