USE library_information_system;


INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category ) VALUES (1,"Kajal","Kumbha Marg","Pratap Nagar","F");
INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category )  VALUES (2,"Parul","Sector11","Sitapura","F");


INSERT INTO Subjects ( subject_id, subject_name ) VALUES (101,"Java");
INSERT INTO Subjects ( subject_id, subject_name )  VALUES (102,"SQL");


INSERT INTO Publishers ( publisher_id, publisher_name )  VALUES (11,"MCGraw Hills");
INSERT INTO Publishers ( publisher_id, publisher_name )  VALUES (12,"NK Publication");


INSERT INTO Authors ( author_id, author_name ) VALUES (501,"Herbert Schieldt");
INSERT INTO Authors ( author_id, author_name ) VALUES (502,"Korth");
INSERT INTO Authors ( author_id, author_name ) VALUES (503,"Bhatia");


INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (21,"Complete Reference",11,101);
INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (22,"Learning SQL",12,102);
INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (23,"Mastering SQL",12,102);


INSERT INTO Title_Author ( title_id, author_id ) VALUES (21,501);
INSERT INTO Title_Author ( title_id, author_id ) VALUES (22,502);
INSERT INTO Title_Author ( title_id, author_id ) VALUES (23,503);


INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1001,21,"2015-07-05",700,"Available");
INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1002,22,"2010-04-12",550,"Available");
INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1003,23,"2011-05-06",456,"Not Available");


INSERT INTO Book_Issue ( accession_number, member_id ) VALUES (1001,1);
INSERT INTO Book_Issue ( accession_number, member_id ) VALUES (1002,2);
INSERT INTO Book_Issue ( accession_number, member_id ) VALUES (1001,2);
INSERT INTO Book_Issue ( accession_number, member_id ) VALUES (1002,1);


INSERT INTO Book_Return ( return_date, accession_number, member_id, issue_date ) VALUES ("2015-09-23",1001,1,"2015-09-08");
INSERT INTO Book_Return ( return_date, accession_number, member_id, issue_date ) VALUES ("2015-09-23",1002,2,"2015-09-08");
INSERT INTO Book_Return ( return_date, accession_number, member_id, issue_date ) VALUES ("2015-09-23",1001,2,"2015-09-08");
INSERT INTO Book_Return ( return_date, accession_number, member_id, issue_date ) VALUES ("2015-09-23",1002,1,"2015-09-08");


SET SQL_SAFE_UPDATES = 0;
UPDATE Members
SET addressline2 = "Jaipur"; 


UPDATE Members
SET addressline1 = "EPIP, Sitapura" where category = "F"; 


ALTER TABLE Titles DROP FOREIGN KEY `pub_id`;


TRUNCATE TABLE Publishers;


set @publisher_id1 = 1, @publisher_name1 = "MCGraw Hills";
INSERT INTO Publishers ( publisher_id, publisher_name )  VALUES ( @publisher_id1, @publisher_name1  );


set @publisher_id2 = 2, @publisher_name2 = "NK Publication";
INSERT INTO Publishers ( publisher_id, publisher_name )  VALUES ( @publisher_id2, @publisher_name2 );


DELETE FROM Titles where publisher_id = 11;