Create database dbloja;

use dbloja;

create table categorias (	
id int not null,
nome varchar (50),
PRIMARY KEY (id)
);

create table produtos (	
id serial,
nome character varying(50),
categoria int not null,
PRIMARY KEY (id)
);

select * from produtos;
