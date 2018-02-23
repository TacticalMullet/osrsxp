#!/bin/sh

PG_USER=osrsxp
PG_NAME=osrsxp_pg
DOCKER=sudo docker

$DOCKER run -d --name $PG_NAME -p 5432:5432 postgres
sleep 2

$DOCKER exec -it $PG_NAME bash -c "psql -U postgres -c 'CREATE DATABASE osrsxp;'"
$DOCKER exec -it $PG_NAME bash -c "psql -U postgres -c 'CREATE USER $PG_USER;'"

$DOCKER exec -it $PG_NAME bash -c "psql -U $PG_USER osrsxp -c ' \
    CREATE TABLE account( \
        id SERIAL PRIMARY KEY, \
        name VARCHAR(24), \
        created_dt TIMESTAMP DEFAULT current_timestamp \
    );'"

$DOCKER exec -it $PG_NAME bash -c "psql -U $PG_USER osrsxp -c '
    CREATE TABLE skillxp( \
        id SERIAL PRIMARY KEY, \
        name VARCHAR(24), \
        rank BIGINT, \
        level INT, \
        xp BIGINT, \
        account_id INT REFERENCES account (id), \
        created_dt TIMESTAMP DEFAULT current_timestamp \
    );'"


