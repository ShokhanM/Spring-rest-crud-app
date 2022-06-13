CREATE DATABASE test_db;

CREATE TABLE employees (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(15),
  surname varchar(25),
  department varchar(20),
  salary int,
  PRIMARY KEY (id)
) ;

INSERT INTO my_db.employees (name, surname, department, salary)
VALUES
	('Elon', 'Musk', 'IT', 5500),
	('Bill', 'Gates', 'IT', 4700),
	('Mark', 'Zuckerberg', 'IT', 3850);
