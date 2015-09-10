USE library_information_system;


-- Question2

SELECT b.accession_number AS Acc_no ,b.member_id AS Mem_id, b.issue_date AS Iss_d, b.return_date AS Ret_d 
FROM Book_return b INNER JOIN Members m  ON m.member_id = b.member_id ORDER BY issue_date , m.member_name;