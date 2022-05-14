CREATE database music;
CREATE table music(
                      songID int,
                      songName varchar(250),
                      author varchar(250),
                      releaseYear int,
                      PRIMARY KEY (songID)
)ENGINE = INNODB