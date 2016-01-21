create database meta_hrm;
use meta_hrm;

INSERT INTO `meta_hrm`.`employee` (`emp_id`, `emp_name`, `enabled`, `password`, `username`) VALUES (1, 'Kajal', 1, '1234', 'kajal');

INSERT INTO `meta_hrm`.`employee` (`emp_id`, `emp_name`, `enabled`, `password`, `username`) VALUES (2, 'Parul', 1, '5678', 'parul');

INSERT INTO `meta_hrm`.`employee` (`emp_id`, `emp_name`, `enabled`, `password`, `username`) VALUES (3, 'Riddhi', 1, 'abcd', 'riddhi');

INSERT INTO `meta_hrm`.`employee_role` (`userRoleId`, `role`, `emp_id`) VALUES (1, 'ROLE_ADMIN', 1);

INSERT INTO `meta_hrm`.`employee_role` (`userRoleId`, `role`, `emp_id`) VALUES (2, 'ROLE_USER', 2);

INSERT INTO `meta_hrm`.`employee_role` (`userRoleId`, `role`, `emp_id`) VALUES (3, 'ROLE_SUPERVISOR', 3);

