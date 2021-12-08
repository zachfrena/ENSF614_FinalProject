DROP DATABASE IF EXISTS TicketApp;
CREATE DATABASE TicketApp;
USE TicketApp;

DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE (
	MovieID		integer not null,
    Title		varchar(50) not null,
    primary key(MovieID)
);

INSERT INTO MOVIE(MovieID, Title)
VALUES
(1, "Monty Python and the Holy Grail"),
(2, "Dune"),
(3, "Ghostbusters: Afterlife"),
(4, "The Princess Bride");

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS(
    Username varchar(15) not null,
    FName varchar(15) not null,
    LName varchar(15) not null,
    Email varchar(30) not null,
    IsRegistered boolean not null,
    AccountBalance integer not null,
    CcNum     varchar(25) not null,
    primary key (Username)
);

INSERT INTO USERS(Username, FName, LName, Email, IsRegistered, AccountBalance, CcNum)
VALUES
("dunefan", "Evan", "Cooksley", "ecooksley@aol.com", True, 180, 123456789),
("kelten2", "Kelten", "Falez", "kfalez@aol.com", False, 40, 987654321),
("MP4Lyfe", "David", "Cooksley", "d.cook@yahoo.com", True, 120, 456789123),
("user2", "Greg", "Gregory", "greg@greg.greg", False, 66, 741456963),
("vvKool", "KKona", "Kappa", "pog@champ.lul", False, 420, 777777777),
("ghostbuster", "Zach", "Frena", "zfrena@aol.com", True, 0, 963852741);

DROP TABLE IF EXISTS SHOWING;
CREATE TABLE SHOWING (
	ShowingID		integer not null auto_increment,
    MovieID			integer,
    TheDate			date,
    ShowingTime		time,
    Theatre			varchar(30),
    primary key (ShowingID),
    foreign key (MovieID) references MOVIE(MovieID)
    );

INSERT INTO SHOWING(MovieID, TheDate, ShowingTime, Theatre)
VALUES
(1, "2021-12-22", "14:00:00", "Theatre 1"), -- Monty Python > 2
(1, "2021-12-23", "18:00:00", "Theatre 1"), -- Monty Python > 2
(1, "2022-01-06", "12:00:00", "Theatre 2"), -- Monty Pyton > 3
(2, "2021-12-10", "10:00:00", "Theatre 3"), -- Dune < 72
(2, "2021-12-15", "20:00:00", "Theatre 3"), -- Dune < 2
(2, "2021-12-24", "10:00:00", "Theatre 4"), -- Dune > 3
(2, "2021-12-17", "15:00:00", "Theatre 4"), -- Dune < 2
(3, "2021-12-9", "9:00:00", "Theatre 5"), -- Ghostbusters < 72
(3, "2021-12-9", "12:00:00", "Theatre 5"), -- Ghostbusters < 72
(3, "2021-12-9", "15:00:00", "Theatre 5"), -- Ghostbusters < 72
(3, "2021-12-9", "18:00:00", "Theatre 5"), -- Ghostbusters < 72
(4, "2021-12-25", "19:00:00", "Theatre 6"); -- Princess Bride > 2

    
DROP TABLE IF EXISTS TICKET;
CREATE TABLE TICKET (
	TicketID		integer auto_increment not null ,
    ShowingID		integer not null,
    Username		varchar(15) not null,
    Seat			integer not null,
    primary key(TicketID),
    foreign key (ShowingID) references SHOWING(ShowingID),
    foreign key (Username) references USERS(Username)
);

INSERT INTO TICKET(ShowingID, Username, Seat)
VALUES
(1, "MP4Lyfe", 7), -- Monty Python Theatre 1 14:00
(2, "MP4Lyfe", 7), -- Monty Python Theatre 1 18:00
(1, "ghostbuster", 10), -- Monty Python Theatre 1 14:00
(4, "vvKool", 16), -- Dune Theatre 3 10:00
(4, "dunefan", 8), -- Dune Theatre 3 10:00
(4, "kelten2", 5), -- Dune Theatre 3 10:00
(9, "user2", 12); -- Ghostbusters Theatre 5 12:00

    