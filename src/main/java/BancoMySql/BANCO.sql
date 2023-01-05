/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  ygor
 * Created: 21 de fev de 2022
 */
/*CREATE DATABASE BANCO;
USE BANCO;*/

CREATE TABLE CARTAS(
    nome VARCHAR(100),
    descricao VARCHAR(5000) NOT NULL,
    implementado BOOLEAN
);
ALTER TABLE CARTAS
CONSTRAINT nome_pk 
PRIMARY KEY nome;


CREATE TABLE MONSTRO(
    nome_fk VARCHAR(100), 
    atributo VARCHAR(100),
    tipo VARCHAR(100), 
    nivel INTEGER, 
    atk INTEGER, 
    def INTEGER
);
ALTER TABLE MONSTRO 
ADD CONSTRAINT monstro_fk 
FOREIGN KEY nome_fk 
REFERENCES CARTAS(nome);

ALTER TABLE MONSTRO
ADD CONSTRAINT atributo_chk 
CHECK (atributo > 0 AND atributo <= 6);

ALTER TABLE MONSTRO
ADD CONSTRAINT nivel_chk
CHECK (nivel > 0 AND nivel <= 12);




CREATE TABLE MAGIA(
    nome_fk VARCHAR(100)
);
ALTER TABLE MAGIA 
CONSTRAINT MAGIA_FK 
FOREIGN KEY (nome_fk) 
REFERENCES CARTAS(nome);

CREATE TABLE HABILIDADE(
    nome_fk VARCHAR(100)
);
ALTER TABLE HABILIDADE
CONSTRAINT HABILIDADE_FK 
FOREIGN KEY (nome_fk) 
REFERENCES CARTAS(nome);





