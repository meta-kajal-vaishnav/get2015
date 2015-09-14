USE library_information_system;


-- Question 1
SELECT member_name 
FROM Members 
WHERE category = 
(
    SELECT category 
    FROM Members 
    WHERE member_name = "Keshav Sharma"
)
AND member_name != "Keshav Sharma";


-- Question 2
SET SQL_SAFE_UPDATES = 0;
UPDATE book_return SET issue_date = "2015-09-10";


SELECT bi.issue_date,t.title_name,m.member_name,bi.due_date 
FROM book_issue bi
INNER JOIN Books b ON bi.accession_number = b.accession_number
INNER JOIN Members m ON m.member_id = bi.member_id
INNER JOIN titles t ON t.title_id = b.title_id
WHERE NOT EXISTS 
(
    SELECT member_id,issue_date,accession_number 
    FROM book_return 
    WHERE issue_date = DATE(bi.issue_date) 
    AND member_id = bi.member_id 
    AND accession_number = bi.accession_number
);


-- Question 3
UPDATE book_return SET return_date = "2015-11-10" WHERE member_id = 2;

SELECT bi.issue_date,t.title_name,m.member_name,bi.due_date FROM book_issue bi
INNER JOIN Books b ON bi.accession_number = b.accession_number
INNER JOIN Members m ON m.member_id = bi.member_id
INNER JOIN titles t ON t.title_id = b.title_id
WHERE EXISTS 
(
    SELECT member_id,issue_date,accession_number 
    FROM book_return 
    WHERE DATEDIFF(return_date,DATE(bi.due_date))>0 
    AND member_id = bi.member_id 
    AND accession_number = bi.accession_number
);


-- Question 4
SELECT accession_number, title_id, purchase_date, price, status FROM books WHERE PRICE = 
(
    SELECT MAX(price) FROM books
);


-- Question 5
SELECT MAX(price) AS secondPrice 
FROM books 
WHERE price != 
(
    SELECT MAX(price) 
    FROM books
);

