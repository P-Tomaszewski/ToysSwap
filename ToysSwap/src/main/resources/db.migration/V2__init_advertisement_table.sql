drop table if exists advertisement;
create table advertisement(
    id int primary key auto_increment,
    title varchar (100) not null,
    description varchar (300) not null,
    age_category varchar not null,
    photo varchar not null ,
    price NUMERIC not null,
    city varchar (100) not null,
    category varchar (100) not null,
    brand varchar (100) not null
)
