drop database if exists projeto;
create database projeto;

use PROJETO;
    
CREATE TABLE SALARIO(
	idSalario int not null auto_increment,
    dtPagamentoSalario date not null,
    valSalario float not null,
    primary key(idSalario)
);

CREATE TABLE MATRICULA(
	idMatricula int not null auto_increment,
    dtMatrcula date not null,
    situacao tinyint not null,
    dtCancelamentoMatricula date not null,
    primary key(idMatricula)
);

CREATE TABLE MENSALIDADE(
	idMensalidade int not null auto_increment,
    valMensalidade float(3) not null,
    primary key(idMensalidade)
);

CREATE TABLE PESSOA(
	idPessoa int not null auto_increment,
    cpf varchar(11) not null,
    nome varchar(255) not null,
    idade int(30) not null,
    sexo char(1) not null,
    telefone varchar(20) not null,
    celular varchar(20) not null,
    email varchar(255) not null,
    bairro varchar(255) not null,
    cep varchar(10) not null,
    atuacao varchar(255) not null,
    primary key(idPessoa)
);

CREATE TABLE PAGAMENTO(
	idPagamento int not null auto_increment,
    idMensalidade int not null,
    dtVencimento date not null,
    dtPagamento date not null,
    dtUltimoPagamento date,
    situacao int(1) not null,
    multa int(3) not null,
    primary key(idPagamento),
    foreign key(IdMensalidade) references MENSALIDADE(idMensalidade)
);   

CREATE TABLE MODALIDADE (
	idModalidade int not null auto_increment,
    nomeModalidade varchar(55) not null,
    idMensalidade int not null,
    primary key(idModalidade),
    foreign key(idMensalidade) references Mensalidade(idMensalidade)
);
    
CREATE TABLE ALUNO(
	idAluno int not null auto_increment,
    idPessoa int not null,
    observacoes varchar(600),
    idMatricula int not null,
    idModalidade int not null,
    idPagamento int not null,
    primary key (idaluno),
    foreign key(idPessoa) references PESSOA(idPessoa),
    foreign key(idModalidade) references MODALIDADE(idModalidade),
    foreign key(IdMatricula) references MATRICULA(idMatricula),
    foreign key(idPagamento) references PAGAMENTO(idPagamento)
);
    
CREATE TABLE INSTRUTOR(
	idInstrutor int not null auto_increment,
    idPessoa int not null,
    formacao varchar(255) not null,
    dtAdmissao date not null,
    idSalario int not null,
    primary key (idInstrutor),
    foreign key(idPessoa) references PESSOA(idPessoa),
    foreign key(IdSalario) references SALARIO(idSalario)
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
