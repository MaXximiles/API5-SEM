###################  BASE DE DADOS DO PROJETO FIND DATA  #################
####  ULTIMA MODIFICAÇÃO FEITA EM 28/03/2022 AS 20:40 POR MAXIMILES  #####
##########################################################################

USE find_data;

CREATE TABLE empresas 
(
	emp_id LONG,
    emp_nome VARCHAR(80),
    emp_cnpj VARCHAR(20),
	cid_id LONG,
    cnae_id LONG,
    emp_origem VARCHAR(40)
 );

CREATE TABLE consumo
(
	cons_id LONG,
    cons_mes VARCHAR(40),
    cons_qtdconsumo LONG,
    emp_id LONG
);

CREATE TABLE cidade 
(
	cid_id LONG,
    cid_cidade VARCHAR(80),
    cid_estado CHAR(3),
    cid_regiaoibge VARCHAR(30)
);

CREATE TABLE cnae
(
	cnae_id LONG,
    cnae_codigo VARCHAR(10),
    cnae_descricao VARCHAR(255)
);

CREATE TABLE vendedor
(
	ven_id LONG,
    ven_nome VARCHAR(80),
    ven_cpf VARCHAR(20),
    ven_email VARCHAR(80),
    ven_senha VARCHAR(255)
);

############# FIM DA CRIAÇÃO DE TABELAS ################

SELECT * FROM empresas;