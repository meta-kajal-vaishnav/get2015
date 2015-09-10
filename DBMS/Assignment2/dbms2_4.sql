-- Creating Database zipcode
CREATE DATABASE zipcode;
USE zipcode;

-- creating table Zipcode
 CREATE TABLE zipcodeInfo
(
	zipcode_id int PRIMARY KEY AUTO_INCREMENT,
  zipcode_number int NOT NULL
);

-- Creating table cityInfo
CREATE TABLE cityInfo
(
	-- To store zip id and city name
	city_id int PRIMARY KEY AUTO_INCREMENT,
	city_name varchar(20),
  zipcode_id int,
	FOREIGN KEY (zipcode_id) REFERENCES zipcodeInfo (zipcode_id) 
);

-- Creating table stateInfo
CREATE TABLE stateInfo
(
	-- to store zipid and state Name
	state_id int PRIMARY KEY AUTO_INCREMENT,
	state_name varchar(20),
  city_id int,
	FOREIGN KEY (city_id) REFERENCES cityInfo (city_id) 
);
 
 -- Inserting values in zipcodeInfo table
 INSERT INTO zipcodeInfo (zipcode_id, zipcode_number) VALUES (1, 5001);
 INSERT INTO zipcodeInfo (zipcode_number) VALUES (5002);
 INSERT INTO zipcodeInfo (zipcode_number) VALUES (5003);
 INSERT INTO zipcodeInfo (zipcode_number) VALUES (5004);
 
 -- Inserting values in cityInfo table
 INSERT INTO cityInfo (city_id, city_name, zipcode_id) VALUES (1,'Ahmedabad',1);
 INSERT INTO cityInfo (city_name, zipcode_id) VALUES ('Udaipur',2);
 INSERT INTO cityInfo (city_name, zipcode_id) VALUES ('Delhi',3);
 INSERT INTO cityInfo (city_name, zipcode_id) VALUES ('Kota',2);
 INSERT INTO cityInfo (city_name, zipcode_id) VALUES ('Kolkata',4);
 
 -- Inserting values in stateInfo table
 INSERT INTO stateInfo (state_id, state_name, city_id) VALUES (1,'Gujarat',1);
 INSERT INTO stateInfo (state_name, city_id) VALUES ('Rajasthan',2);
 INSERT INTO stateInfo (state_name, city_id) VALUES ('Delhi',3);
 INSERT INTO stateInfo (state_name, city_id) VALUES ('Rajasthan',4);
 INSERT INTO stateInfo (state_name, city_id) VALUES ('West Bengal',5);
 
 
 -- Query to find the zip code, city name and stateName
 SELECT z.zipcode_number, c.city_name, s.state_name 
 from zipcodeInfo z
 INNER JOIN cityInfo c ON z.zipcode_id = c.zipcode_id
 INNER JOIN stateInfo s ON c.city_id = s.city_id
 WHERE z.zipcode_number = 5002
 ORDER BY state_name, city_name;

 
 
 
 