create table cidade
(
    id        uuid          not null,
    nome      varchar(100) not null,
    estado_fk uuid          not null,
    constraint pk_cidade primary key (id),
    constraint fk_cidade_estado foreign key (estado_fk) references estado (id)
);