-- Criar uma tabela

CREATE TABLE JAVAWARS.PERSONAGEM (
	id_personagem NUMBER(38,0) PRIMARY KEY NOT NULL,
	nivel NUMBER(38,0) NOT NULL,
	nickname VARCHAR2(30) NOT NULL,
	classe_personagem VARCHAR(20) NOT NULL,
	agilidade NUMBER(38,0) NOT NULL,
	furtividade NUMBER(38,0) NOT NULL,
	forca NUMBER(38,0) NOT NULL,
	defesa NUMBER(38,0) NOT NULL,
	vida NUMBER(38,0) NOT NULL
);

-- Criar a sequence principal

CREATE SEQUENCE JAVAWARS.SEQ_PERSONAGEM
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

SELECT * FROM personagem;
-- Inserir 10 registros na tabela de personagem

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'Luke Skywalker', 8, 4, 9, 8, 60, 'Jedi');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'Leia Skywalker', 6, 4, 3, 9, 70, 'Droid');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'Grogu', 10, 2, 9, 5, 70, 'Wookie');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'R2D2', 8, 4, 2, 8, 100, 'Droid');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'Darth Vader', 8, 4, 9, 8, 100, 'Jedi');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'Mestre Yoda', 5, 3, 10, 8, 90, 'Wookie');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'R2D2', 8, 4, 9, 8, 100, 'Droid');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'Anakin', 4, 5, 4, 9, 70, 'Jedi');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'Ana Banana', 4, 4, 3, 8, 100, 'Droidi');

INSERT INTO JAVAWARS.PERSONAGEM (id_personagem, nivel, nickname, agilidade, furtividade, forca, defesa, vida, classe_personagem)
VALUES(JAVAWARS.SEQ_PERSONAGEM.NEXTVAL, 1, 'João da Silva Sauro', 10, 4, 6, 8, 100, 'Jedi');

CREATE TABLE JAVAWARS.INIMIGO (
	id_inimigo NUMBER(38.0) NOT NULL,
	nome VARCHAR2(30) NOT NULL,
	hp NUMBER(38,0) NOT NULL,
	forca NUMBER(38,0) NOT NULL,
	PRIMARY KEY (id_inimigo)
	);

CREATE SEQUENCE JAVAWARS.SEQ_INIMIGO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;


INSERT INTO JAVAWARS.INIMIGO (id_inimigo, nome, hp, forca)
VALUES(JAVAWARS.SEQ_INIMIGO.NEXTVAL, 'Soldado', 45, 10);

INSERT INTO JAVAWARS.INIMIGO (id_inimigo, nome, hp, forca)
VALUES(JAVAWARS.SEQ_INIMIGO.NEXTVAL, 'Vorian', 65, 13);

INSERT INTO JAVAWARS.INIMIGO (id_inimigo, nome, hp, forca)
VALUES(JAVAWARS.SEQ_INIMIGO.NEXTVAL,'Lady Nyx', 100, 22);

INSERT INTO JAVAWARS.INIMIGO (id_inimigo, nome, hp, forca) VALUES (JAVAWARS.SEQ_INIMIGO.NEXTVAL, 'Gorgan', 90, 17);


CREATE TABLE JAVAWARS.BATALHA (
	id_batalha NUMBER(38,0) PRIMARY KEY NOT NULL,
	id_personagem NUMBER(38,0) NOT NULL,
	id_inimigo number(38) NOT NULL,
	CONSTRAINT FK_BATALHA_PERSONAGEM FOREIGN KEY (id_personagem) REFERENCES PERSONAGEM (id_personagem),
	CONSTRAINT FK_INIMIGO FOREIGN KEY (id_inimigo) REFERENCES INIMIGO(id_inimigo)
	);


CREATE SEQUENCE JAVAWARS.SEQ_BATALHA
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

SELECT * FROM batalha;

INSERT INTO BATALHA (id_batalha, id_personagem, id_inimigo) VALUES (
SEQ_BATALHA.nextval, 6, 1
);

INSERT INTO BATALHA (id_batalha, id_personagem, id_inimigo) VALUES (
SEQ_BATALHA.nextval, 6, 2
);

INSERT INTO BATALHA (id_batalha, id_personagem, id_inimigo) VALUES (
SEQ_BATALHA.nextval, 6, 3
);

INSERT INTO BATALHA (id_batalha, id_personagem, id_inimigo) VALUES (
SEQ_BATALHA.nextval, 6, 4
);

CREATE TABLE missao (
    id_missao NUMBER(38,0) NOT NULL PRIMARY KEY,
    capitulo NUMBER(38,0) NOT NULL,
    ordem NUMBER(38,0) NOT NULL,
    nome VARCHAR2(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    atributo_necessario VARCHAR2(50) NOT NULL,
    dificuldade NUMBER(38,0) NOT NULL,
    tipo_missao VARCHAR2(50) NOT NULL
);

INSERT INTO missao (id_missao, capitulo, ordem, nome, descricao, atributo_necessario, dificuldade, tipo_missao)
VALUES (1, 1, 1, 'A Caverna do Wampa', 'Derrote a fera para entrar.', 'Força', 5, 'COMBATE_DIRETO');

INSERT INTO missao (id_missao, capitulo, ordem, nome, descricao, atributo_necessario, dificuldade, tipo_missao)
VALUES (2, 1, 2, 'O Contrabandista', 'Negocie ou lute com Vorian.', 'Agilidade', 12, 'TESTE_DE_ATRIBUTO');

INSERT INTO missao (id_missao, capitulo, ordem, nome, descricao, atributo_necessario, dificuldade, tipo_missao)
VALUES (3, 2, 1, 'Gorgan', 'Negocie ou lute com Gorgan.', 'Força', 15, 'TESTE_DE_ATRIBUTO');

INSERT INTO missao (id_missao, capitulo, ordem, nome, descricao, atributo_necessario, dificuldade, tipo_missao)
VALUES (4, 2, 2, 'O Confronto Final', 'Lute com Lady Nix.', 'Agilidade', 20, 'BOSS_FINAL');

ALTER TABLE BATALHA DROP CONSTRAINT FK_BATALHA_PERSONAGEM;
ALTER TABLE BATALHA
ADD CONSTRAINT FK_BATALHA_PERSONAGEM
FOREIGN KEY (id_personagem)
REFERENCES PERSONAGEM(id_personagem)
ON DELETE CASCADE;

/**
--- SCRIPTS PARA ALTERAÇÂO (CASO PRECISE DESCOMENTE O CÓDIGO)--

--- Para adicionar PK na tabela INIMIGO
ALTER TABLE INIMIGO ADD CONSTRAINT PK_INIMIGO PRIMARY KEY (id_inimigo);

-- Para mudar o nome e o tipo da coluna inimigo da tabela batalha --
ALTER TABLE BATALHA RENAME COLUMN inimigo TO id_inimigo;

ALTER TABLE BATALHA MODIFY id_inimigo number(38);

-- Para adicionar FK na tabela de batalha --
ALTER TABLE BATALHA ADD CONSTRAINT FK_INIMIGO FOREIGN KEY (id_inimigo) REFERENCES INIMIGO(id_inimigo);

**/