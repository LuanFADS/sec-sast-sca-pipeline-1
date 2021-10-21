create table estado
(
    id   uuid         not null,
    nome varchar(100) not null,
    uf   char(2)      not null,
    constraint pk_estado primary key (id)
);