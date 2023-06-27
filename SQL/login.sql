DROP TABLE USERS

CREATE TABLE USERS (
	userId INTEGER NOT NULL,
	login VARCHAR(80) NOT NULL,
	password CHAR(32) NOT NULL,
	tipo VARCHAR(13) NOT NULL,
	idOriginal INT NOT NULL,
	
	CONSTRAINT PK_USERS PRIMARY KEY(userId),
	CONSTRAINT CK_TIPO_USUARIO CHECK (tipo IN ('Administrador', 'Escuderia', 'Piloto'))
);

INSERT INTO USERS VALUES (1, 'joaozinho', md5('senhadojoaozinho'), 'Administrador', 5);

INSERT INTO USERS VALUES (2, 'pedrinhopiloto', md5('pedrinhopiloto'), 'Piloto', 5);

SELECT * FROM USERS 
WHERE login = 'joaozinho';

CREATE TABLE RACES (
	RACES_ID INT NOT NULL,
  	YEAR_SEASON INT,
  	ROUND INT,
  	CIRCIT_ID INT,
	NAME VARCHAR(40),
  	DATE DATE,
  	TIME INTERVAL,
	URL VARCHAR(100),
  	FP1_DATE DATE,
	  	
	CONSTRAINT PK_RACES PRIMARY KEY(RACES_ID),
  	FOREIGN KEY (YEAR_SEASON) REFERENCES SEASONS (YEAR) ON DELETE SET NULL
  
);
