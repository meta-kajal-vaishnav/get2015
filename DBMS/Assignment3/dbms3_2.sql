USE library_information_system;


-- Question 1
SELECT s.subject_id, s.subject_name, COUNT(bo.accession_number) as booksPurchased  
FROM Books AS bo
INNER JOIN Titles as t ON bo.title_id = t.title_id
INNER JOIN Subjects as s ON t.subject_id = s.subject_id GROUP BY s.subject_id;


-- Question 2
SELECT * FROM book_issue WHERE period_diff(date_format(due_date, '%Y%m'), date_format(issue_date, '%Y%m'))>2;


-- Question 3
SELECT t.title_name, b.price 
FROM Books AS b
INNER JOIN Titles AS t 
ON t.title_id = b.title_id
WHERE b.price > (SELECT MIN(Price) FROM Books);