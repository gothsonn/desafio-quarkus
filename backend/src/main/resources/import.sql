CREATE DATABASE eventsdb
    WITH
    OWNER = usuarioeventos
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE institutions (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(255) NOT NULL,
                              type VARCHAR(255) NOT NULL

);

CREATE TABLE events (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        start_date TIMESTAMP,
                        end_date TIMESTAMP,
                        is_active BOOLEAN DEFAULT FALSE,
                        institution_id INTEGER NOT NULL,
                        CONSTRAINT fk_institution
                            FOREIGN KEY (institution_id)
                                REFERENCES institutions (id)
);