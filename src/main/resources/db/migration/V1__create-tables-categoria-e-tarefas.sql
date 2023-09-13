create table categoria (
    idCategoria bigserial primary key,
    descricao varchar(255) unique,
    ativo boolean default true
);

create table usuario (
    idUsuario bigserial primary key,
    username varchar(100) unique not null,
    senha varchar(255) not null,
    role varchar(100) not null
);

create table tarefa (
    idTarefa bigserial primary key,
    idCategoria integer references categoria(idCategoria) not null,
    titulo varchar(255) not null,
    descricao text,
    status integer not null,
    prazo timestamp without time zone,
    dataCriacao timestamp without time zone,
    idUsuario integer not null references usuario(idUsuario)
);