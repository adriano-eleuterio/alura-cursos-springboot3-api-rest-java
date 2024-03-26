create table doctor(

    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    specialization varchar(100) not null,
    street varchar(100) not null,
    neighborhood varchar(100) not null,
    zip_code varchar(9) not null,
    city varchar(100) not null,
    state char(2) not null,
    complement varchar(100),
    number varchar(20),

    primary key(id)

);