create table clienti(
    idnp varchar(13) primary key,
    nume varchar(100) not null,
    prenume varchar(100) not null,
    strada varchar(100),
    permanenti boolean,
    genul char,
    varsta int,
    telefon int not null unique
);