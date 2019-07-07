create schema museuEsquema;

create table museuEsquema.usuario
(
   cpf char(11) not null,
   nome varchar(30) not null,
   senha char(6) not null,
   tipo int not null,
   nomeMu varchar(30), 
   dataCriacao varchar(11),
   cidade varchar(30),
   estado varchar(30),
   primary key (cpf)
);

create table museuEsquema.obra
(
   identificador int not null,
   descricao varchar(60) not null,
   tipo int not null,
   primary key (identificador)
);

create table museuEsquema.acervo
(
   dataCriacao varchar(11) not null,
   descricao varchar(30) not null,
   cpf char(11) not null,
   primary key (dataCriacao),
   foreign key (cpf) references museuEsquema.usuario(cpf)
);

create table museuEsquema.solicitacao
(
	nome varchar(30),
	dataCriacao varchar(11),
	cpf char(11),
	cidade varchar(30),
	estado varchar(30),
	nomeGestor varchar(30),
	senhaGestor char(6),
	primary key (nome, dataCriacao)
);

create table museuEsquema.exposicao
(
   nome varchar(30) not null,
   dataCriacao varchar(11) not null,
   descricao varchar(30) not null,
   dias int not null,
   cpf char(11) not null,
      primary key (nome, dataCriacao),
      foreign key (cpf) references museuEsquema.usuario(cpf)
);

create table museuEsquema.acervoExposicao
(
   nome varchar(30) not null,
   dataCriacaoEx varchar(11) not null,
   dataCriacaoAc varchar(11) not null,
   primary key (nome, dataCriacaoEx, dataCriacaoAc),
   foreign key (nome, dataCriacaoEx) references museuEsquema.exposicao(nome, dataCriacao),
   foreign key (dataCriacaoAc) references museuEsquema.acervo(dataCriacao)
);


create table museuEsquema.colecao
(
   identificador int not null,
   dataCriacao varchar(11) not null,
   primary key (identificador, dataCriacao)
);

create table museuEsquema.avaliacao
(
   cpf char(11) not null,
   estado varchar(30) not null,
   primary key (cpf)
);

create table museuEsquema.avaliacaoMuseu
(	
	cpf char(11) not null,
	nomeMu varchar(30) not null,
   	dataCriacaoMu varchar(11) not null,
   	primary key (cpf,nomeMu,dataCriacaoMu),
   	foreign key (cpf) references museuEsquema.usuario(cpf)
);

create table museuEsquema.avaliacaoAcervo
(
  	cpf char(11) not null,
    dataCriacaoAc varchar(11) not null,
    primary key (cpf, dataCriacaoAc),
    foreign key (cpf) references museuEsquema.usuario(cpf),
    foreign key (dataCriacaoAc) references museuEsquema.acervo(dataCriacao)
);

create table museuEsquema.avaliacaoExp
(
 	cpf char(11) not null, 
 	nomeExp varchar(30) not null,
 	dataCriacaoExp varchar(11) not null,
 	primary key (cpf,nomeExp,dataCriacaoExp),
 	foreign key (nomeExp,dataCriacaoExp) references museuEsquema.exposicao(nome,dataCriacao),
 	foreign key (cpf) references museuEsquema.usuario(cpf)
);

create table museuEsquema.avaliacaoObra
(
   cpf char(11) not null,
   identificadorObra int not null,
   primary key (cpf,identificadorObra),
   foreign key (cpf) references museuEsquema.usuario(cpf),
   foreign key (identificadorObra) references museuEsquema.obra(identificador)
);

insert into museuEsquema.usuario values ('19793524022', 'Joao Avilar Ribeiro', 'joao12', 0,'29/06/2019', NULL, NULL, NULL);