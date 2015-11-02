CREATE DATABASE Employee_details;

USE Employee_details;

CREATE TABLE Employee
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50),
    date_of_birth DATE,
    address VARCHAR(50)
);

INSERT INTO Employee VALUES (1,"Kajal","kajal@gmail.com","1993-07-05","Udaipur,Raj");

INSERT INTO Employee (name,email,date_of_birth,address) VALUES ("Parul","parul@gmail.com","1994-04-09","Bhilwara,Raj");

INSERT INTO Employee (name,email,date_of_birth,address) VALUES ("Riddhi","riddhi@gmail.com","1994-08-03","Jaipur,Raj");

