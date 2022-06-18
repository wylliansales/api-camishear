CREATE TABLE procedimentos
(
    id       serial primary key,
    nome     varchar(255)   not null,
    valor    decimal(10, 2) not null,
    comissao varchar(255)   not null
);
CREATE TABLE clientes
(
    id       serial primary key,
    nome     varchar(255) not null,
    telefone varchar(50)
);
CREATE TABLE atendimentos
(
    id         serial primary key,
    cliente_id int not null
);
CREATE TABLE itens_procedimentos
(
    id             serial,
    atendimento_id int            not null,
    nome           varchar(255)   not null,
    valor          decimal(10, 2) not null,
    comissao       smallint       not null,
    primary key (id),
    foreign key (atendimento_id) references atendimentos (id)
);