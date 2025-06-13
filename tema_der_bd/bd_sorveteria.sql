create database sorveteria

use sorveteria;

create table tb_funcionario(
id_funcionario int primary key auto_increment,
nome_funcionario varchar(40) not null,
cpf_funcionario varchar(14) not null
);

create table tb_cliente(
id_cliente int not NULL PRIMARY KEY auto_increment,
cpf_cliente VARCHAR(17) not null,
nome_cliente varchar(40) NOT NULL,
endereco_cliente varchar(60),
telefone_cliente varchar(15)
);

create table tb_sorvete(
id_sorvete int primary key auto_increment,
preco_sorvete varchar(7),
sabor_sorvete varchar(15)
);

	

create table tb_venda(
id_venda int primary key AUTO_INCREMENT,
cod_funcionario int not null,
cod_cliente int not null,
data_venda VARCHAR(10),
valor_venda VARCHAR(9),
cod_sorvete INT NOT NULL,
qtd_venda INT NOT NULL,
CONSTRAINT fk_fun FOREIGN KEY (cod_funcionario) REFERENCES tb_funcionario(id_funcionario),
CONSTRAINT fk_cli FOREIGN KEY (cod_cliente) REFERENCES tb_cliente(id_cliente),
CONSTRAINT fk_sor FOREIGN KEY (cod_sorvete) REFERENCES tb_sorvete(id_sorvete)
);

CREATE TABLE tb_usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome_usuario VARCHAR(15) NOT NULL,
senha_usuario VARCHAR(15)
);



INSERT INTO tb_cliente (cpf_cliente, nome_cliente, endereco_cliente, telefone_cliente)
values("000.000.000-00", "Padrão", "xxx", "(00) 00000-0000")


select * from tb_funcionario
select * from tb_cliente
select * from tb_sabor
select * from tb_sorvete
SELECT * FROM tb_venda
SELECT * FROM tb_usuario

DROP TABLE tb_calda
