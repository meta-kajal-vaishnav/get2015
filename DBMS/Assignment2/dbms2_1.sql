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
SET return_date = "0000-00-00" where member_id = "2";


select  * from book_return;
select  * from Members;


SELECT accession_number AS Acc_no ,member_id AS Mem_id,issue_date AS Iss_d,return_date AS Ret_d FROM Book_return;




