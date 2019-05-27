
create schema mercearia;

create table mercearia.produtos(
   id integer not null,
   preco float not null,
   nomeProduto varchar(20) not null,
   primary key (id)
);

select *from mercearia.produtos; 

