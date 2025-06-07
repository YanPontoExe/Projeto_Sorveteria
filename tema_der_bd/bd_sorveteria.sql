create database sorveteria

use sorveteria;

create table tb_funcionario(
id_funcionario int primary key auto_increment,
nome_funcionario varchar(40) not null,
cpf_funcionario varchar(14) not null
);

create table tb_cliente(
id_cliente int primary key auto_increment,
cpf_cliente VARCHAR(17) not null,
nome_cliente varchar(40) NOT NULL,
endereco_cliente varchar(60),
telefone_cliente varchar(15)
);

create table tb_sabor(
id_sabor int primary key auto_increment,
descricao_sabor varchar(20)
);

create table tb_sorvete(
id_sorvete int primary key auto_increment,
tipo_sorvete varchar(8),
preco_sorvete varchar(7),
sabor_sorvete varchar(15),
cod_calda int,
CONSTRAINT fk_cal FOREIGN KEY (cod_calda) REFERENCES tb_calda(id_calda)
);

create table tb_calda(
id_calda int primary key auto_increment,
descricao_calda VARCHAR(18) not null,
adicional_calda varchar(7)
);	

create table tb_venda(
id_venda int primary key auto_increment,
cod_funcionario int not null,
cod_cliente int not null,
data_venda VARCHAR(10),
valor_venda VARCHAR(9),
CONSTRAINT fk_fun FOREIGN KEY (cod_funcionario) REFERENCES tb_funcionario(id_funcionario),
CONSTRAINT fk_cli FOREIGN KEY (cod_cliente) REFERENCES tb_cliente(id_cliente)
);

CREATE TABLE tb_usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
nome_usuario VARCHAR(15) NOT NULL,
senha_usuario VARCHAR(15)
);



DELETE FROM tb_cliente WHERE nome_cliente='clebinho2'

DROP TABLE tb_





alter table tb_venda modify column cod_funcionario varchar(50) not null
alter table tb_venda modify column cod_cliente varchar(50) not null
alter table tb_sorvete modify column cod_calda varchar(50) not NULL
alter table tb_funcionario modify column cpf_funcionario varchar(14) not NULL unique



select * from tb_funcionario
select * from tb_cliente
select * from tb_sabor
select * from tb_sorvete
select * from tb_calda
SELECT * FROM tb_venda
SELECT * FROM tb_usuario