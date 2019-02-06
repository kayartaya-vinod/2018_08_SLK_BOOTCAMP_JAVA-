drop table if exists categories;

create table categories(
id int primary key auto_increment,
name varchar(255) not null unique,
description varchar(255)
);

-- adding a new column
alter table categories
add column created_at datetime;

-- select <column-list> from <table-list>
-- to indicate all columns of a row, use *
select * from categories;

-- DML: Data Manipulation Language
-- includes INSERT, UPDATE, and DELETE commands
-- They do not affec the structure of the table,
-- but manipulates the content of the table

-- insert into <table-name> [<column-list>] values (<value-list>)
insert into categories values (null, 'Electronics', null, sysdate());
insert into categories(name) values ('Computer accessories'), 
	('Kitchen stuffs'),
	('Clothing..');

select * from categories;

drop table if exists products;
create table products(
	id int primary key auto_increment,
	name varchar(255) not null,
	description varchar(255),
	unit_price double,
	category_id int,
	constraint chk_unit_price check (unit_price>0),
	constraint fk_cat_id foreign key (category_id) references categories(id)
);

insert into products(name, unit_price, category_id) 
values ('Sigma Calculator', 700, 1);

-- UPDATE <TABLE-NAME> 
--	SET COL1=VAL1 [, COL2=VAL2, ..., COLn=VALn]
--	[WHERE <CONDITION>]

UPDATE CATEGORIES 
SET NAME = 'Electronics and Mobile accessories'
WHERE ID = 1;

-- DELETE FROM <TABLE-NAME> [ WHERE <CONDITION> ]
DELETE FROM CATEGORIES WHERE ID = 3;