CREATE DATABASE turismo;
USE turismo;

CREATE TABLE pontostur (
	idPonto int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50),
    cidade varchar(50),
    ingresso varchar(10),
    guia tinyint,
    chuva tinyint
    );