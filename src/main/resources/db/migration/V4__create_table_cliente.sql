create table cliente
(
    id          uuid         not null,
    cpf         varchar(11) not null,
    rg          varchar(9)  not null,
    nascimento  date        null,
    sexo        varchar(10) null,
    endereco_fk uuid         not null,
    constraint pk_cliente primary key (id),
    constraint fk_cliente_endereco FOREIGN KEY (endereco_fk) REFERENCES endereco (id),
    constraint uk_cliente_endereco unique (endereco_fk)
);