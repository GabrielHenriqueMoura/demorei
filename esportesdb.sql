CREATE DATABASE esportesdb;

USE esportesdb;

CREATE TABLE Equipe (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50)
);

CREATE TABLE Jogador (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(50),
  equipe_id INT,
  FOREIGN KEY (equipe_id) REFERENCES Equipe(id)
);
