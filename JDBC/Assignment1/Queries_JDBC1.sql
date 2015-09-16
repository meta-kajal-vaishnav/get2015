use library_information_system;

UPDATE Books
SET purchase_date = "2015-07-09" WHERE title_id = 23;

INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (28,"DS algorithms",11,103);
INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (29,"Maths is fun",11,104);
INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (30,"Basics of sql",12,102);

INSERT INTO Title_Author ( title_id, author_id ) VALUES (28,504);
INSERT INTO Title_Author ( title_id, author_id ) VALUES (29,506);
INSERT INTO Title_Author ( title_id, author_id ) VALUES (30,505);

INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1007,28,"2014-01-01",720,"Available");
INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1008,29,"2013-02-02",560,"Available");
INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1009,30,"2015-03-01",280,"Available");

INSERT INTO Book_Issue ( issue_date, accession_number, member_id, due_date ) VALUES ("2013-02-03 17:41:14",1008,1,"2013-02-18");

UPDATE book_issue
SET due_date = "2013-02-18" WHERE accession_number = 1008;

INSERT INTO Book_Return ( return_date, accession_number, member_id, issue_date ) VALUES ("2013-02-15",1008,1,"2013-02-03");
