#!/bin/sh 

PG_USER=osrsxp
PG_NAME=osrsxp_pg

sudo docker run -d --name $PG_NAME -p 5432:5432 postgres
sleep 2

sudo docker exec -it $PG_NAME bash -c "psql -U postgres -c 'CREATE DATABASE osrsxp;'"
sudo docker exec -it $PG_NAME bash -c "psql -U postgres -c 'CREATE USER $PG_USER;'"

sudo docker exec -it $PG_NAME bash -c "psql -U $PG_USER osrsxp -c ' \
    CREATE TABLE account( \
        id SERIAL PRIMARY KEY, \
        name VARCHAR(24), \
        created_dt TIMESTAMP DEFAULT current_timestamp \
    );'"

sudo docker exec -it $PG_NAME bash -c "psql -U $PG_USER osrsxp -c '
    CREATE TABLE skillxp( \
        id SERIAL PRIMARY KEY, \
        name VARCHAR(24), \
        rank BIGINT, \
        level INT, \
        xp BIGINT, \
        account_id INT REFERENCES account (id) \
    );'"


