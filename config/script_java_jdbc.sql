create sequence usersequence
increment 1
minvalue 1
maxvalue 9223372036854775807
start 5;


alter table userposjava ALTER column id set default nextval('usersequence'::regclass);
alter table telefone ALTER column id set default nextval('telefonesequence'::regclass);
--deixando o id com o valor unico 
alter table userposjava add unique(id);

-- criando a tabela de telefone 
create table telefone
( id bigint not null,
numero character varying(255) not null,
tipo  character varying(255) not null,
usuariopessoa bigint not null,
constraint telefone_id primary key (id)
)

alter table telefone add foreign key (usuariopessoa) references userposjava(id)	