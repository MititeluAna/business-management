create table angajati(
    idnp varchar(13) primary key,
    nume varchar(100) not null,
    prenume varchar(100) not null,
    strada varchar(100),
    salariul int,
    telefon int not null unique,
    magazin_id int,
    foreign key (magazin_id) references magazin(id)
);