SELECT 'CREATE DATABASE graph_spring'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'graph_spring')\gexec

create sequence author_seq start 1 increment 2;
create sequence book_seq start 1 increment 2;

\c graph_spring;

CREATE TABLE IF NOT EXISTS author
(
    id INT PRIMARY KEY ,
    first_name TEXT ,
    middle_name TEXT ,
    last_name TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS book
(
    id INT PRIMARY KEY ,
    name TEXT NOT NULL,
    genre TEXT,
    author_id INT not null references author(id)
);