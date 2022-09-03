create database viagens
default collate utf8mb4_general_ci;

use viagens;

create table `cliente`(
`id` int not null,
`nome` varchar (30) not null,
`cpf` varchar (11) not null,
`nascimento` date,
`login` varchar (30) not null,
`senha` varchar (50) not null,
primary key (cpf)
);

create table `empresa`(
`id` int not null,
`cnpj` varchar (14) not null
`localidade` varchar (30) not null,
`proprietario` varchar (30) not null,
`login` varchar (30) not null,
`senha` varchar (50) not null,
primary key (cnpj)
);

create table `destino`(
`codDestino` int not null auto_increment,
`nome` varchar(30) not null,
`valor` real not null,
`localidade` varchar(30) not null,
`proprietario` varchar(40) not null,
primary key (codDestino)
);

insert into cliente
(id, nome, cpf, nascimento, login, senha)
values
('1', 'Pedro', '12345678901', '1986-09-23', 'pedro12', '123');

insert into empresa
(id, cnpj, localidade, proprietario, login, senha)
values
('1', '12345678901234', 'Porto - Portugual', 'Maria', 'portohotel', 'maria43');

insert into destino
(codDestino, nome, valor, localidade, proprietario)
values
('1', 'Porto', '1000.00', 'Porto - Portugual', 'Maria');
