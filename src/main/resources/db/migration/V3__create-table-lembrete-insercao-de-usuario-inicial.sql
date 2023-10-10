create table lembrete (
	idlembrete bigserial primary key,
	idtarefa bigint references tarefa(idtarefa) not null,
	descricao text,
	datahora_criacao timestamp without time zone not null,
	datahora_aviso timestamp without time zone not null
);

alter table usuario add column email varchar(100);

insert into usuario (username, senha, role, ativo) values ('admin', '$2a$12$A6K1r5J6pTttM1jPECGt3eQGP6p55/eY8lNL.LWMBJ62II7sLGCZO', 'admin', true);