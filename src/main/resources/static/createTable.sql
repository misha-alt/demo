
DROP TABLE IF EXISTS PRODUCT;
create table PRODUCT
(
id integer PRIMARY KEY,
title varchar(255),
description varchar(255) not null,
price integer not null,
city varchar(255) not null,
);

create table USER
(
id integer not null,
login varchar(255) not null,
password varchar(255) not null,
primary key (id)
);


create table ROLESOFUSERS (
id integer not null,
role_name varchar(50) not null,
primary key (id)
);

create table USER_ROLES
(
user_id integer not null,
userrole_id integer not null
);

INSERT INTO PRODUCT(id, title, description, price, city)
VALUES(1, 'Stone', 'Simple Stone', 10, 'Mogilev');

INSERT INTO USER(id, login, password)
VALUES(1, 'Jim', 'fff');

alter table USER_ROLES add constraint f123UC foreign key (user_id ) references USER;
alter table USER_ROLES add constraint fo567C foreign key (userrole_id ) references ROLESOFUSERS;