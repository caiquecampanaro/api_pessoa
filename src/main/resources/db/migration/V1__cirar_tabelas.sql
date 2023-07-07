CREATE SEQUENCE pessoa_sequence START 1;
CREATE SEQUENCE endereco_sequence START 1;
CREATE SEQUENCE contato_sequence START 1;

CREATE TABLE pessoa (
  id int default NEXTVAL ('pessoa_sequence') PRIMARY KEY,
  nome VARCHAR(50),
  sobrenome VARCHAR(100)
);

CREATE TABLE endereco (
	id int default NEXTVAL ('endereco_sequence') PRIMARY KEY, 
	pessoa_id int,
	cidade VARCHAR(50),
	estado VARCHAR(50),
	bairro VARCHAR(100),
	rua VARCHAR(50),
	complemento VARCHAR(100),
	numero VARCHAR(5),
	CONSTRAINT fk_pessoa
		FOREIGN KEY(pessoa_id)
			REFERENCES pessoa(id)
);

CREATE TABLE contato (
	id int default NEXTVAL ('contato_sequence') PRIMARY KEY,
	pessoa_id int,
	tipo VARCHAR(100), 
	valor VARCHAR(100), 
	CONSTRAINT fk_pessoa
		FOREIGN KEY(pessoa_id)
			REFERENCES pessoa(id) 
);


