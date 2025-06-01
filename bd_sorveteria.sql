create database sorveteria

use sorveteria;

create table tb_funcionario(
id_funcionario int primary key auto_increment,
nome_funcionario varchar(40) not null,
cpf_funcionario varchar(14) not NULL unique
);

create table tb_cliente(
cpf_cliente VARCHAR(17) primary key not null,
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
cod_calda varchar(50) not NULL,
CONSTRAINT fk_cal FOREIGN KEY (cod_calda) REFERENCES tb_calda(id_calda)
);

create table tb_calda(
id_calda int primary key auto_increment,
descricao_calda VARCHAR(18) not null,
adicional_calda varchar(7)
);	

create table tb_venda(
id_venda int primary key auto_increment,
cod_funcionario varchar(50) not null,
cod_cliente varchar(50) not null,
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




select * from tb_funcionario
select * from tb_cliente
select * from tb_sabor
select * from tb_sorvete
select * from tb_calda
SELECT * FROM tb_venda
SELECT * FROM tb_usuario