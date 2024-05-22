DROP TABLE IF EXISTS Item;

CREATE TABLE IF NOT EXISTS Item (
   id INT NOT NULL,
   name varchar(250) NOT NULL,
   description varchar(250),
   quantity INT NOT NULL,
   category varchar(20) NOT NULL,
   status varchar(20) NOT NULL,
   supermarket_name varchar(20) NOT NULL,
   purchased_on timestamp NOT NULL,
   version INT,
   PRIMARY KEY (id)
);