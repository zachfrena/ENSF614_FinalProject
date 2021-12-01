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
(3, "Ghostbusters: Afterlife");

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS(
    Username varchar(15) not null,
    FName varchar(15) not null,
    LName varchar(15) not null,
    Email varchar(30) not null,
    IsRegistered boolean not null,
    AccountBalance integer not null,
    primary key (Username)
);

INSERT INTO USERS(Username, FName, LName, Email, IsRegistered, AccountBalance)
VALUES
("dunefan", "Evan", "Cooksley", "ecooksley@aol.com", True, 0),
("kelten2", "Kelten", "Falez", "kfalez@aol.com", True, 0),
("ghostbuster", "Zach", "Frena", "zfrena@aol.com", True, 0);

DROP TABLE IF EXISTS SHOWING;
CREATE TABLE SHOWING (
	ShowingID		integer not null,
    MovieID			integer,
    TheDate			date,
    ShowingTime		time,
    Theatre			varchar(30),
    primary key (ShowingID),
    foreign key (MovieID) references MOVIE(MovieID)
    );

INSERT INTO SHOWING(ShowingID, MovieID, TheDate, ShowingTime, Theatre)
VALUES
(5, 1, "2021-12-05", "16:00:00", "One"),
(6, 2, "2021-12-04", "15:00:00", "One"),
(8, 3, "2021-12-03", "17:00:00", "One");
    
DROP TABLE IF EXISTS TICKET;
CREATE TABLE TICKET (
	TicketID		integer not null,
    ShowingID		integer not null,
    Username		varchar(15) not null,
    primary key(TicketID),
    foreign key (ShowingID) references SHOWING(ShowingID),
    foreign key (Username) references USERS(Username)
);

INSERT INTO TICKET(TicketID, ShowingID, Username)
VALUES
(1, 5, "dunefan"),
(2, 6, "kelten2"),
(3, 8, "ghostbuster");
    