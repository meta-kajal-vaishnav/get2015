USE library_information_system;


INSERT INTO Subjects ( subject_id, subject_name )  VALUES (103,"Data Structure");
INSERT INTO Subjects ( subject_id, subject_name )  VALUES (104,"Maths");
INSERT INTO Subjects ( subject_id, subject_name )  VALUES (105,"Compiler");


INSERT INTO Publishers ( publisher_id, publisher_name )  VALUES (13,"Arihant");


INSERT INTO Authors ( author_id, author_name ) VALUES (504,"Lipshuz");
INSERT INTO Authors ( author_id, author_name ) VALUES (505,"Sumitra");
INSERT INTO Authors ( author_id, author_name ) VALUES (506,"Shawm");


INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (24,"Learning DS",11,103);
INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (25,"Learning Maths",13,104);
INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (26,"Learning Compiler",13,105);
INSERT INTO Titles ( title_id, title_name, publisher_id, subject_id ) VALUES (27,"Mastering Compiler",13,105);


INSERT INTO Title_Author ( title_id, author_id ) VALUES (24,504);
INSERT INTO Title_Author ( title_id, author_id ) VALUES (25,505);
INSERT INTO Title_Author ( title_id, author_id ) VALUES (26,504);
INSERT INTO Title_Author ( title_id, author_id ) VALUES (27,506);


INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1004,24,"2010-04-02",890,"Available");
INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1005,25,"2010-05-03",400,"Available");
INSERT INTO Books ( accession_number, title_id, purchase_date, price, status ) VALUES (1006,26,"2010-02-08",980,"Available");


INSERT INTO Book_Issue ( accession_number, member_id ) VALUES (1004,3);
INSERT INTO Book_Issue ( accession_number, member_id ) VALUES (1005,4);
INSERT INTO Book_Issue ( accession_number, member_id ) VALUES (1006,5);


-- Question 1
SELECT m.member_id, m.member_name, t.title_name, 
bi.accession_number, bi.issue_date, bi.due_date, 
period_diff(date_format(NOW(), '%Y%m'), date_format(bi.issue_date, '%Y%m')) AS Num_Of_Months_Issued
FROM Book_issue AS bi
INNER JOIN Members AS m ON m.member_id = bi.member_id
INNER JOIN Books AS bo ON bi.accession_number = bo.accession_number
INNER JOIN Titles AS t ON bo.title_id = t.title_id
WHERE period_diff(date_format(NOW(), '%Y%m'), date_format(bi.issue_date, '%Y%m'))>2;


-- Question 2
SELECT member_name, LENGTH(member_name) AS Length FROM Members 
WHERE LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM Members);


-- Question 3
SELECT COUNT(issue_date) FROM book_issue;



