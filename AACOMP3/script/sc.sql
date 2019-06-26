create schema museuEsquema;

create table museuEsquema.usuario
(
   cpf char(11) not null,
   nome varchar(30) not null,
   senha char(6) not null,
   tipo int not null,
   dataCriacao date,
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

create table museuEsquema.museu
(
   nome varchar(30) not null,
   dataCriacao date not null,
   cidade varchar(30) not null,
   estado varchar(30) not null,
   primary key (nome, dataCriacao)
);

create table museuEsquema.acervo
(
   nome varchar(30) not null,
   dataCriacao date not null,
   dataCriacaoMu date not null,
   descricao varchar(30) not null,
   cpf char(11) not null,
      primary key (dataCriacao),
      foreign key (nome) references museuEsquema.museu(nome),
      foreign key (dataCriacaoMu) references museuEsquema.museu(dataCriacao),
      foreign key (cpf) references museuEsquema.usuario(cpf)
);

create table museuEsquema.solicitacao
(
   nome varchar(30),
   dataCriacao date,
   cpf char(11),
      cidade varchar(30),
      estado varchar(30),
      nomeGestor varchar(30),
      senhaGestor char(6),
      primary key (nome, dataCriacao),
      foreign key (cpf) references museuEsquema.usuario(cpf)
);

create table museuEsquema.exposicao
(
   nome varchar(30) not null,
   dataCriacao date not null,
   descricao varchar(30) not null,
   dias int not null,
   cpf char(11) not null,
      primary key (nome, dataCriacao),
      foreign key (cpf) references museuEsquema.usuario(cpf)
);

create table museuEsquema.acervoExposicao
(
   nome varchar(30) not null,
   dataCriacaoEx date not null,
   dataCriacaoAc date not null,
      primary key (nome, dataCriacaoEx, dataCriacaoAc),
      foreign key (nome) references museuEsquema.exposicao(nome),
      foreign key (dataCriacaoEx) references museuEsquema.exposicao(dataCriacao),
      foreign key (dataCriacaoAc) references museuEsquema.acervo(dataCriacao)
);

create table museuEsquema.colecao
(
   identificador int not null,
   dataCriacao date not null,
      primary key (identificador, dataCriacao)
);

create table museuEsquema.avaliacao
(
   cpf char(11) not null,
   estado varchar(30) not null,
   tipo int not null,
   nomeMu varchar(30) not null,
   dataCriacaoMu date not null,
   dataCriacaoAc date not null,
   nomeExp varchar(30) not null,
   dataCriacaoExp date not null,
   identificadorObra int not null,
   primary key (cpf),
   foreign key (nomeMu) references museuEsquema.museu(nome),
   foreign key (dataCriacaoMu) references museuEsquema.museu(dataCriacao),
   foreign key (dataCriacaoAc) references museuEsquema.acervo(dataCriacao),
   foreign key (nomeExp) references museuEsquema.exposicao(nome),
   foreign key (dataCriacaoExp) references museuEsquema.exposicao(dataCriacao),
   foreign key (identificadorObra) references museuEsquema.obra(identificador)
);


insert into museuEsquema.usuario values ('19793524022', 'Joao Avilar Ribeiro', 'joao12', 0,,,);

