drop table if exists users;
create table users(
    id int primary key auto_increment,
    login varchar (100) not null,
    password varchar (100) not null,
    name varchar (100) not null,
    email varchar (100) not null,
    last_name varchar (100),
    city varchar (100)
)
