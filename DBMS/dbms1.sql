CREATE DATABASE library_information_system;


USE library_information_system;


CREATE TABLE Members
(
member_id INT AUTO_INCREMENT PRIMARY KEY,
member_name VARCHAR(20) ,
addressline1 VARCHAR(50),
addressline2 VARCHAR(50),
category VARCHAR(20)
);


CREATE TABLE Subjects
(
subject_id INT AUTO_INCREMENT PRIMARY KEY,
subject_name VARCHAR(20)
);


CREATE TABLE Publishers
(
publisher_id INT AUTO_INCREMENT PRIMARY KEY,
publisher_name VARCHAR(20)
);


CREATE TABLE Authors
(
author_id INT AUTO_INCREMENT PRIMARY KEY,
author_name VARCHAR(20)
);


CREATE TABLE Titles
(
title_id INT AUTO_INCREMENT PRIMARY KEY,
title_name VARCHAR(20),
publisher_id INT,
subject_id INT,
CONSTRAINT `pub_id` FOREIGN KEY (publisher_id) REFERENCES Publishers (publisher_id) ON DELETE CASCADE,
CONSTRAINT `sub_id` FOREIGN KEY (subject_id) REFERENCES Subjects (subject_id) ON DELETE CASCADE
);


CREATE TABLE Books
(
accession_number INT AUTO_INCREMENT PRIMARY KEY,
title_id INT ,
purchase_date DATE,
price INT,
status VARCHAR(20),
Foreign key (title_id) references Titles (title_id) ON DELETE CASCADE
);


CREATE TABLE Book_Issue
(
issue_date DATE,
accession_number INT,
member_id INT,
due_date DATE,
PRIMARY KEY (issue_date, accession_number,member_id),
CONSTRAINT `accession_num_key` FOREIGN KEY (accession_number) REFERENCES Books(accession_number) ON DELETE CASCADE,
CONSTRAINT `member_id_issue` FOREIGN KEY (member_id) REFERENCES Members(member_id) ON DELETE CASCADE
);


CREATE TABLE Book_Return
(
return_date DATE,
accession_number INT,
member_id INT,
issue_date DATE,
PRIMARY KEY (return_date, accession_number,member_id),
CONSTRAINT `accession_num` FOREIGN KEY (accession_number) REFERENCES Books(accession_number) ON DELETE CASCADE,
CONSTRAINT `member_id_return` FOREIGN KEY (member_id) REFERENCES Members(member_id) ON DELETE CASCADE
);


CREATE TABLE Title_Author
(
title_id INT,
author_id INT,
PRIMARY KEY (title_id, author_id),
CONSTRAINT `title_id_key` FOREIGN KEY (title_id) REFERENCES Titles (title_id) ON DELETE CASCADE,
CONSTRAINT `author_id_key` FOREIGN KEY (author_id) REFERENCES Authors (author_id) ON DELETE CASCADE
);


show tables;


ALTER TABLE book_issue MODIFY COLUMN issue_date TIMESTAMP NOT NULL DEFAULT NOW();


DELIMITER $$

CREATE TRIGGER set_default_duedate 
BEFORE INSERT ON Book_Issue
FOR EACH ROW
BEGIN
  SET NEW.due_date = NOW() + INTERVAL 15 DAY;
END$$

DELIMITER ;



ALTER TABLE book_issue DROP FOREIGN KEY `member_id_issue`;


ALTER TABLE book_return DROP FOREIGN KEY `member_id_return`;


drop table Members;


CREATE TABLE Members
(
member_id INT AUTO_INCREMENT PRIMARY KEY,
member_name VARCHAR(20) ,
addressline1 VARCHAR(50),
addressline2 VARCHAR(50),
category VARCHAR(20)
);


ALTER TABLE book_issue
ADD CONSTRAINT `member_id_issue` FOREIGN KEY (member_id) REFERENCES Members(member_id);


ALTER TABLE book_return
ADD CONSTRAINT `member_id_return` FOREIGN KEY (member_id) REFERENCES Members(member_id);



