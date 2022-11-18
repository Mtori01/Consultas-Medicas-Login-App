
drop database loginapp;

CREATE DATABASE  IF NOT EXISTS  loginapp;
use loginapp;

create table departamento(
id int,
nombre varchar(20),
alias varchar(5),
primary key (id)
);


create table usuario (
login varchar(10),
password varchar(10),
id_departamento int,
primary key (login)
);

alter table usuario add FOREIGN KEY (id_departamento) references departamento(id);


insert into  departamento values (1, 'Gerencia', 'Ger');
insert into  departamento values (2, 'Personal', 'Per');
insert into  departamento values (3, 'Marketing', 'Mkt');

insert into  usuario values ('lhernandez', 'leo', 3);


insert into  usuario values ('yonex', 'nice', 2);
insert into  usuario values ('haru', 'genshin', 1);





create table areaMedica(
id int not null,
nombre varchar(10),
activa bit(1),
primary key(id)
);

create table insumoMedico(
id int AUTO_INCREMENT,
nombre varchar(10),
inyeccion real,
fechaCreacion Date,
uso varchar(1),
activo bit(1),

id_areaMedica int,
primary key(id)
);

alter table insumoMedico add foreign key (id_areaMedica) references areaMedica(id);

insert into areaMedica values(1,'psicologo',true);
insert into areaMedica values(2,'cirugia',false);
insert into areaMedica values(3,'trauma',true);
insert into areaMedica values(4,'curaciones',true);

insert into insumoMedico values(1,'eutanacia', 50.0, Date '2022-6-9','s',true ,1);
insert into insumoMedico values(2,'insulina', 20.0, Date '2022-6-9','n', true ,2);
insert into insumoMedico values(3,'nice', 25.0, Date '2022-7-10','s',true ,3);
insert into insumoMedico values(4,'rip', 30.0, Date '2023-8-15','n',false ,2);
insert into insumoMedico values(5,'aspirina', 35.0, Date '2025-8-15','s',true ,4);
insert into insumoMedico values(6,'cianuro', 45.0, Date '2020-8-15','s',true ,1);

