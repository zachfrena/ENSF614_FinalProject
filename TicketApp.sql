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
    CcNum     varchar(25) not null,
    primary key (Username)
);

INSERT INTO USERS(Username, FName, LName, Email, IsRegistered, AccountBalance, CcNum)
VALUES
("dunefan", "Evan", "Cooksley", "ecooksley@aol.com", True, 0, 131331444687923),
("kelten2", "Kelten", "Falez", "kfalez@aol.com", True, 0, 131231444687923),
("ghostbuster", "Zach", "Frena", "zfrena@aol.com", True,0 , 131231444687923);

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
(1, 1, "2021-12-31", "16:00:00", "Theatre 1"),
(2, 2, "2021-12-18", "11:00:00", "Theatre 2"),
(3, 3, "2021-12-23", "18:00:00", "Theatre 2"),
(4, 1, "2021-12-24", "14:00:00", "Theatre 3"),
(5, 2, "2021-12-19", "15:00:00", "Theatre 3"),
(6, 3, "2021-12-17", "05:00:00", "Theatre 1");
    
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
(1, "dunefan", 1), -- MP >3 weeks theatre 1     not gunna show!
(3, "kelten2", 2), -- GB 2-3 theatre 2
(3, "kelten2", 3), -- GB 2-3 theatre 2
(4, "ghostbuster", 3); -- MP 2-3 weeks theatre 3
    