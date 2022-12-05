SELECT 'CREATE DATABASE arch_spring'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'arch_spring')\gexec

\c arch_spring;

CREATE TABLE IF NOT EXISTS notes
(

    name TEXT PRIMARY KEY,
    note TEXT NOT NULL
);