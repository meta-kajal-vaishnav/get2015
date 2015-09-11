USE library_information_system;


-- Question 1
SELECT 
COUNT(IF (category = 'F', category , null)) AS Count_F,
COUNT(IF (category = 'M', category , null)) AS Count_M,
COUNT(IF (category = 'O', category , null)) AS Count_Others
FROM Members;


-- Question 2
SELECT t.title_name
FROM Book_issue as bi
INNER JOIN Books as bo ON bi.accession_number= bo.accession_number
INNER JOIN Titles as t ON bo.title_id = t.title_id
GROUP BY bi.accession_number HAVING COUNT(bi.accession_number)>2;


-- Question 3
SELECT t.title_name 
FROM Book_issue as bi
INNER JOIN Members as m ON bi.member_id = m.member_id
INNER JOIN Books as bo ON bi.accession_number= bo.accession_number
INNER JOIN Titles as t ON bo.title_id = t.title_id
WHERE m.category  != "F";


-- Question 4
SELECT distinct a.author_name
FROM Books b
INNER JOIN Titles t ON b.title_id = t.title_id
INNER JOIN Title_author ta ON ta.title_id = t.title_id
INNER JOIN Authors a ON ta.author_id = a.author_id;