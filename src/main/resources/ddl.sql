CREATE TABLE IF NOT EXISTS promotion(
   id serial PRIMARY KEY,
   description VARCHAR (1000) NOT NULL,
   url VARCHAR(2000) NOT NULL,
   price DECIMAL NOT NULL
);