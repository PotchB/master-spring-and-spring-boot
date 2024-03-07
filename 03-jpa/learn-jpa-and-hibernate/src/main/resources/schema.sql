-- Whenever you're making use of Spring Data JPA starter, it would automatically pick up the file called schema.sql and create the table in H2

CREATE TABLE course (
    id BIGINT NOT NULL,             -- bigint type maps to long type in Java
    name VARCHAR(255) NOT NULL,     -- varchar(255) maps to String type in Java
    author VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)    
);