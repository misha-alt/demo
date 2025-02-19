
DROP TABLE IF EXISTS PRODUCT;
create table PRODUCT
(
id BIGINT PRIMARY KEY,
title varchar(255),
description varchar(255) not null,
price integer not null,
city varchar(255) not null,
user_id integer
);

create table USER
(
id BIGINT AUTO_INCREMENT not null,
login varchar(255) not null,
password varchar(255) not null,
primary key (id)
);


create table ROLESOFUSERS (
id BIGINT AUTO_INCREMENT not null,
rolename varchar(50) not null,
primary key (id)
);

create table USER_ROLES
(
user_id BIGINT not null,
userrole_id BIGINT not null
);

create table COMMENT
(
id integer not null,
comment varchar(255),
comment_date DATE,
loginOfCreator varchar(255),
user_id integer,
primary key (id)
);

INSERT INTO PRODUCT(id, title, description, price, city)
VALUES(1, 'Stone', 'Simple Stone', 10, 'Mogilev');

INSERT INTO USER(id, login, password)
VALUES(1, 'Jim', 'fff');

--INSERT INTO USER(id, login, password)
--VALUES(2, 'John', 'fff');


INSERT INTO USER_ROLES(user_id, userrole_id)
VALUES(1, 1);
--INSERT INTO USER_ROLES(user_id, userrole_id)
--VALUES(2, 2);

INSERT INTO ROLESOFUSERS(id, rolename)
VALUES(1, 'ROLE_EMPLOEE');
INSERT INTO ROLESOFUSERS(id, rolename)
VALUES(2, 'ROLE_ADMIN');

alter table USER_ROLES add constraint f123UC foreign key (user_id ) references USER;
alter table USER_ROLES add constraint fo567C foreign key (userrole_id ) references ROLESOFUSERS;
alter table PRODUCT add constraint wre45f foreign key (user_id)references USER;
alter table COMMENT add constraint for_UCC foreign key (user_id) references USER;