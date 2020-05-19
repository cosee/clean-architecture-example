create table book
(
    id        integer       not null auto_increment primary key,
    isbn13    varchar(13)   not null,
    name      varchar(4000) not null,
    cover_url varchar(4000) not null
)
