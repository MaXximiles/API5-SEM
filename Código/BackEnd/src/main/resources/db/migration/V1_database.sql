###################  BASE DE DADOS DO PROJETO FIND DATA  #################
####  ULTIMA MODIFICAÇÃO FEITA EM 13/05/2022 AS 08:50 POR MAXIMILES  #####
##########################################################################

USE find_data;

CREATE TABLE IF NOT EXISTS empresas 
(
	emp_id INT AUTO_INCREMENT,
    emp_nome VARCHAR(80),
    emp_cnpj VARCHAR(20),
	cid_id VARCHAR(20),
    cnae_id VARCHAR(20),
    emp_origem VARCHAR(40),
    cart_id VARCHAR(45),
    PRIMARY KEY(emp_id)
 );
 
 CREATE TABLE IF NOT EXISTS usuarios
(
	usu_id INT AUTO_INCREMENT,
    usu_nome VARCHAR(80),
    usu_email VARCHAR(80),
    usu_senha VARCHAR(255),
    usu_nivel VARCHAR(40),
    usu_cidade VARCHAR(20),
    PRIMARY KEY(usu_id)
);

CREATE TABLE IF NOT EXISTS consumo
(
	cons_id LONG,
    cons_mes VARCHAR(40),
    cons_qtdconsumo LONG,
    emp_id LONG
);

CREATE TABLE IF NOT EXISTS cidade 
(
	cid_id LONG,
    cid_cidade VARCHAR(80),
    cid_estado CHAR(3),
    cid_regiaoibge VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS cnae
(
	cnae_id LONG,
    cnae_codigo VARCHAR(10),
    cnae_descricao VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS carteira_vendedor
(
	cart_id INT AUTO_INCREMENT,
    usu_id INT,
    emp_id INT,
    cart_status VARCHAR(40),
    cart_data_ini VARCHAR(40),
    PRIMARY KEY(cart_id)
);

############# FIM DA CRIAÇÃO DE TABELAS ###########################
########## INSERTS NAS TABELAS ####################################

## Usuarios
INSERT INTO usuarios (usu_nome, usu_email, usu_senha, usu_nivel) VALUES ("Maximiles","maxx.sbr@gmail.com","123456","Administrador");
INSERT INTO usuarios (usu_nome, usu_email, usu_senha, usu_nivel) VALUES ("Administrador","administrador@gmail.com","123456","Administrador");
INSERT INTO usuarios (usu_nome, usu_email, usu_senha, usu_nivel) VALUES ("Inteligência","inteligencia@gmail.com","123456","Inteligencia");
INSERT INTO usuarios (usu_nome, usu_email, usu_senha, usu_nivel) VALUES ("Vendedor","vendedor@gmail.com","123456","Vendedor");

############# FIM DA CRIAÇÃO DE TABELAS ################