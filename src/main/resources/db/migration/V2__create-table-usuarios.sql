create table usuarios(

    id bigint not null auto_increment,
    nombre varchar(200) not null,
    login varchar(100) not null unique,
    contrasena varchar(255) not null,

    primary key(id)

);