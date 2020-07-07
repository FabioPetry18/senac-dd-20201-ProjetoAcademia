drop database if exists projeto;
create database projeto;

use PROJETO;

CREATE TABLE PESSOA(
	idPessoa int not null auto_increment,
    cpf varchar(11) not null,
    nome varchar(255) not null,
    dtNascimento date not null,
    sexo char(1) not null,
    telefone varchar(20) not null,
    celular varchar(20) not null,
    email varchar(255) not null,
    endereco varchar(150) not null,
    bairro varchar(255) not null,
    cidade varchar (100) not null,
    uf char (2) not null,
    cep varchar(10) not null,
	idModalidade int not null,
    primary key(idPessoa),
	foreign key(idModalidade) references MODALIDADE(idModalidade)
);  

CREATE TABLE ALUNO(
	idAluno int not null,
    observacoes varchar(600),
    dtMatricula date not null,
	situacao boolean not null,
	dtCancelamento date,
    primary key (idAluno),
    foreign key(idAluno) references PESSOA(idPessoa)
);

CREATE TABLE INSTRUTOR(
    idInstrutor int not null,
    formacao varchar(255) not null,
    dtAdmissao date not null,
    valSalario double not null,
    primary key (idInstrutor),
    foreign key(idInstrutor) references PESSOA(idPessoa)
);

CREATE TABLE MODALIDADE (
	idModalidade int not null auto_increment,
    nomeModalidade varchar(55) not null,
    valorModalidade double not null,
    primary key(idModalidade)
);

insert into modalidade (nomeModalidade, valorModalidade) values ("Musculação", 200);
insert into modalidade (nomeModalidade, valorModalidade) values ("Natação", 100);
insert into modalidade (nomeModalidade, valorModalidade) values ("Dança", 150);