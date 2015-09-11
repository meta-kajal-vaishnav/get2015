USE library_information_system;


-- Question2

SELECT bi.accession_number AS Acc_no , bi.member_id AS Mem_id, bi.issue_date AS Iss_d, IFNULL(br.return_date, " ") AS Ret_d 
FROM Book_return br
RIGHT JOIN Book_issue bi 
ON br.member_id = bi.member_id 
INNER JOIN Members m  
ON m.member_id = bi.member_id 
ORDER BY bi.issue_date , m.member_name;
