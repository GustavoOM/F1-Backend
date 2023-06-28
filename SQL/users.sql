DROP TABLE IF EXISTS USERS;

-- Criando a tabela usuários
CREATE TABLE USERS (
	userId INTEGER NOT NULL,
	login VARCHAR(80) NOT NULL,
	password CHAR(32) NOT NULL,
	tipo VARCHAR(13) NOT NULL,
	idOriginal INT,
	
	CONSTRAINT PK_USERS PRIMARY KEY(userId),
	CONSTRAINT CK_TIPO_USUARIO CHECK (tipo IN ('Administrador', 'Escuderia', 'Piloto'))
);

-- Criando a sequence dos ids dos usuarios
CREATE SEQUENCE IF NOT EXISTS SEQ_USER_ID 
START 1 
NO CYCLE 
OWNED BY USERS.userId;

CREATE OR REPLACE FUNCTION create_constructor_user_after_insert()
RETURNS TRIGGER AS $$
BEGIN
    -- Cria um novo usuário na tabela USERS
    INSERT INTO USERS (userId, login, password, tipo, idOriginal)
    VALUES (nextval('SEQ_USER_ID'), NEW.constructorRef, md5(CONCAT(NEW.constructorRef, '_c')), 'Escuderia', NEW.constructorId);
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION create_driver_user_after_insert()
RETURNS TRIGGER AS $$
BEGIN
    -- Cria um novo usuário na tabela USERS
    INSERT INTO USERS (userId, login, password, tipo, idOriginal)
    VALUES (nextval('SEQ_USER_ID'), NEW.driverRef, md5(CONCAT(NEW.driverRef, '_d')), 'Piloto', NEW.driverId);
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Cria a trigger para a inserção na tabela CONSTRUCTORS sempre gerar um novo login
CREATE OR REPLACE TRIGGER create_constructor_user_trigger
AFTER INSERT ON CONSTRUCTORS
FOR EACH ROW
EXECUTE FUNCTION create_constructor_user_after_insert();


-- Cria a trigger para a inserção na tabela DRIVER sempre gerar um novo login
CREATE OR REPLACE TRIGGER create_driver_user_trigger
AFTER INSERT ON DRIVER
FOR EACH ROW
EXECUTE FUNCTION create_driver_user_after_insert();


CREATE OR REPLACE FUNCTION populate_all_drivers()
RETURNS VOID $$
BEGIN
    -- Cria um novo usuário na tabela USERS
    INSERT INTO USERS (userId, login, password, tipo, idOriginal)
    VALUES (nextval('SEQ_USER_ID'), NEW.driverRef, md5(CONCAT(NEW.driverRef, '_d')), 'Piloto', NEW.driverId);
    
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

SELECT COUNT(*) FROM constructors c 


-- Alguns testes


INSERT INTO constructors 
VALUES (333333, 'eduazevedo3', 'EduAzevedo3', 'Japanese', 'http://en.wikipedia.org/wiki/EduAzevedo');

SELECT * FROM DRIVER;

INSERT INTO driver 
VALUES (44444, 'eduazevedo4', '1545644', 'HEX', 'Eduardinho4', 'Azevedo4', '1985-01-07', 'Irish', 'http://en.wikipedia.org/wiki/EduAzevedo4');


SELECT login, COUNT(*) AS quantidade
FROM USERS
GROUP BY LOGIN
HAVING COUNT(*) > 1;



