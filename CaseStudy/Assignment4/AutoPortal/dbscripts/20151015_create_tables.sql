

//

USE vehicle_management_system;

CREATE TABLE USER(
 userId INT PRIMARY KEY AUTO_INCREMENT,
 userName VARCHAR(50) UNIQUE,
 password VARCHAR(50)
);



INSERT INTO `vehicle_management_system`.`user` (`userId`, `userName`, `password`) VALUES (1, 'riddhi@gmail.com', 'riddhi');

INSERT INTO `vehicle_management_system`.`user` (`userId`, `userName`, `password`) VALUES (2, 'kajal@gmail.com', 'kajal');

ALTER TABLE `vehicle_management_system`.`vehicle` ADD COLUMN `image` BLOB NULL DEFAULT NULL  AFTER `created_time` ;

ALTER TABLE vehicle MODIFY image VARCHAR(50);