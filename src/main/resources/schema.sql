DROP TABLE IF EXISTS users;


CREATE TABLE users (
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL
);

ALTER TABLE PUBLIC.users ADD PRIMARY KEY (first_name,last_name);

DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  account_number VARCHAR(12) NOT NULL,
  account_balance DECIMAL (10,4) DEFAULT 00.0000,
  currency VARCHAR(25)
);

DROP TABLE IF EXISTS operations;

CREATE TABLE operations (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  account_id INT NOT NULL,
  total_sum DECIMAL (10,4) NOT NULL,
  operation ENUM('Income', 'Outcome') NOT NULL
);

ALTER TABLE operations ADD datetime TIMESTAMP DEFAULT NOW();

