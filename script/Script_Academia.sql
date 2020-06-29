drop database if exists projeto;
create database projeto;

use PROJETO;

CREATE TABLE PESSOA(
	idPessoa int not null auto_increment,
    cpf varchar(11) not null,
    nome varchar(255) not null,
    idade int(30) not null,
    sexo char(1) not null,
    telefone varchar(20),
    celular varchar(20) not null,
    email varchar(255) not null,
    bairro varchar(255) not null,
    cidade varchar (100) not null,
    estado char (2) not null,
    cep varchar(10) not null,
    atuacao varchar(255) not null,
    primary key(idPessoa)
);  

CREATE TABLE MODALIDADE (
	idModalidade int not null auto_increment,
    nomeModalidade varchar(55) not null,
    valorModalidade double not null,
    idMensalidade int not null,
    primary key(idModalidade)
);
    
CREATE TABLE ALUNO(
	idAluno int not null auto_increment,
    idPessoa int not null,
    observacoes varchar(600),
    dtMatricula date not null,
	matricula varchar(10),
	situacao boolean not null,
	dtCancelamento date,
	idModalidade int not null,
    primary key (idaluno),
    foreign key(idPessoa) references PESSOA(idPessoa),
    foreign key(idModalidade) references MODALIDADE(idModalidade)
);
    
CREATE TABLE INSTRUTOR(
	idInstrutor int not null auto_increment,
    idPessoa int not null,
    formacao varchar(255) not null,
    dtAdmissao date not null,
    dtPagamentoSalario date not null,
    valSalario float not null,
    primary key (idInstrutor),
    foreign key(idPessoa) references PESSOA(idPessoa)
);

CREATE TABLE TURNO(
	idTurno int not null auto_increment,
    nome varchar(55) not null,
    horario time not null,
    quantidadeVagas int(3) not null,
    idAluno int not null,
    idInstrutor int not null,
	primary key(idTurno),
    foreign key(idAluno) references ALUNO(idAluno),
    foreign key(idInstrutor) references INSTRUTOR(idInstrutor)
);

