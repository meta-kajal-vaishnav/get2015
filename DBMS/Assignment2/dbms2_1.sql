USE library_information_system;


INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category ) VALUES (3,"Anshul","Sector 13","Udaipur","M");
INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category ) VALUES (4,"Abhishek","Sector 14","Kota","M");


-- Question 1


SELECT * FROM Members;


SELECT member_name, member_id, category FROM Members;


SELECT member_name, member_id, category FROM Members WHERE category = "F";


SELECT DISTINCT category FROM Members;


SELECT member_name, category FROM Members order by member_name DESC;


update Publishers set publisher_id = 11 where publisher_id = 1;

update Publishers set publisher_id = 12 where publisher_id = 2;



SELECT T.title_name, S.subject_name, P.publisher_name
FROM Titles T 
INNER JOIN Subjects S ON T.subject_id = S.subject_id
INNER JOIN Publishers P ON T.publisher_id = P.publisher_id;


SELECT category, count(category) from Members group by category;

INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category ) VALUES (5,"Keshav Sharma","Suraj Pole","Kota","M");


SELECT m.member_name FROM Members m INNER JOIN Members m1 ON m.category=m1.category 
AND m1.member_name="Keshav Sharma" AND m.member_name != m1.member_name;



USE library_information_system;


INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category ) VALUES (3,"Anshul","Sector 13","Udaipur","M");
INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category ) VALUES (4,"Abhishek","Sector 14","Kota","M");


-- Question 1


SELECT * FROM Members;


SELECT member_name, member_id, category FROM Members;


SELECT member_name, member_id, category FROM Members WHERE category = "F";


SELECT DISTINCT category FROM Members;


SELECT member_name, category FROM Members order by member_name DESC;


update Publishers set publisher_id = 11 where publisher_id = 1;

update Publishers set publisher_id = 12 where publisher_id = 2;



SELECT T.title_name, S.subject_name, P.publisher_name
FROM Titles T 
INNER JOIN Subjects S ON T.subject_id = S.subject_id
INNER JOIN Publishers P ON T.publisher_id = P.publisher_id;


SELECT category, count(category) from Members group by category;

INSERT INTO Members ( member_id, member_name, addressline1, addressline2, category ) VALUES (5,"Keshav Sharma","Suraj Pole","Kota","M");


SELECT m.member_name FROM Members m INNER JOIN Members m1 ON m.category=m1.category 
AND m1.member_name="Keshav Sharma" AND m.member_name != m1.member_name;



UPDATE Book_return
SET return_date = "2015-09-25" where member_id = "2";


INSERT INTO Book_Issue (issue_date, accession_number, member_id, due_date) VALUES ('2015-06-05 17:41:14',1002,3,'2015-09-23');
INSERT INTO Book_Issue (issue_date, accession_number, member_id, due_date) VALUES ('2015-05-05 17:41:14',1002,4,'2015-09-20');


SELECT bi.accession_number AS Acc_no , bi.member_id AS Mem_id, bi.issue_date AS Iss_d, IFNULL(br.return_date, " ") AS Ret_d 
FROM Book_return br
RIGHT JOIN Book_issue bi 
ON br.member_id = bi.member_id ;







