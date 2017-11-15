CREATE DATABASE dbrevenda;

USE dbrevenda;


CREATE TABLE Proprietario (
proprietario_id INTEGER PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(50),
telefone VARCHAR(15),
email VARCHAR(50),
rua VARCHAR (50),
bairro VARCHAR (50),
cidade VARCHAR(50),
Estado VARCHAR(50)
);

CREATE TABLE Marca (
id_marca INTEGER PRIMARY KEY AUTO_INCREMENT,
nome_marca VARCHAR(50)
);

CREATE TABLE Modelo (
id_modelo INTEGER PRIMARY KEY AUTO_INCREMENT,
nome_modelo VARCHAR(50),
id_marca INTEGER,
FOREIGN KEY(id_marca) REFERENCES Marca (id_marca)
);

CREATE TABLE Acessorio (
id_acessorio INTEGER PRIMARY KEY AUTO_INCREMENT,
nome_acessorio VARCHAR(50)
);

CREATE TABLE Carro (
id_carro INTEGER PRIMARY KEY AUTO_INCREMENT,
cor VARCHAR(50),
descricao TEXT,
estado BIT,
km DECIMAL,
id_modelo INTEGER,
FOREIGN KEY(id_modelo) REFERENCES Modelo (id_modelo)
);

CREATE TABLE Venda (
nro_venda INTEGER PRIMARY KEY AUTO_INCREMENT,
data_venda DATE,
proprietario_id INTEGER,
id_carro INTEGER,
data_pagamento DATE,
forma_pagamento CHAR(1),
nro_parcelas INTEGER,
valor DECIMAL,
liquidado BIT,
FOREIGN KEY(proprietario_id) REFERENCES Proprietario (proprietario_id),
FOREIGN KEY(id_carro) REFERENCES Carro (id_carro)
);

CREATE TABLE Parcela (
id_parcela INTEGER PRIMARY KEY AUTO_INCREMENT,
nro_venda INTEGER,
data_parcela DATE,
valor_parcela DECIMAL,
multa DECIMAL,
data_pagamento DATE,
pago BIT,
FOREIGN KEY(nro_venda) REFERENCES venda (nro_venda)
);

CREATE TABLE carro_acessorio (
id_carro_acessorio INTEGER PRIMARY KEY AUTO_INCREMENT,
id_acessorio INTEGER,
id_carro INTEGER,
FOREIGN KEY(id_acessorio) REFERENCES Acessorio (id_acessorio),
FOREIGN KEY(id_carro) REFERENCES Carro (id_carro)
);

# drop database dbrevenda;
