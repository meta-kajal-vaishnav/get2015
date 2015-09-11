-- Creating Database zipcode
CREATE DATABASE zipcode;

-- Use Database zipcode
USE zipcode;

-- Creating table stateInfo
CREATE TABLE stateInfo
(
	-- to store state id and state Name
	state_id int PRIMARY KEY AUTO_INCREMENT,
	state_name varchar(20)
);

-- Creating table cityInfo
CREATE TABLE cityInfo
(
	-- To store state id and city name
	city_id int PRIMARY KEY AUTO_INCREMENT,
	city_name varchar(20),
  state_id int,
	FOREIGN KEY (state_id) REFERENCES stateInfo (state_id) 
);

-- creating table Zipcode
 CREATE TABLE zipcodeInfo
(
	zipcode_number int PRIMARY KEY AUTO_INCREMENT,
  city_id int NOT NULL,
  FOREIGN KEY (city_id) REFERENCES cityInfo (city_id)
);


 -- Inserting values in stateInfo table
 INSERT INTO stateInfo (state_id, state_name) VALUES (1,'Gujarat');
 INSERT INTO stateInfo (state_name) VALUES ('Rajasthan');
 INSERT INTO stateInfo (state_name) VALUES ('Delhi');
 INSERT INTO stateInfo (state_name) VALUES ('West Bengal');

-- Inserting values in cityInfo table
 INSERT INTO cityInfo (city_id, city_name, state_id) VALUES (1,'Ahmedabad',1);
 INSERT INTO cityInfo (city_name, state_id) VALUES ('Udaipur',2);
 INSERT INTO cityInfo (city_name, state_id) VALUES ('Delhi',3);
 INSERT INTO cityInfo (city_name, state_id) VALUES ('Kota',2);
 INSERT INTO cityInfo (city_name, state_id) VALUES ('Kolkata',4);

-- Inserting values in zipcodeInfo table
 INSERT INTO zipcodeInfo (zipcode_number, city_id) VALUES (1, 1);
 INSERT INTO zipcodeInfo (city_id) VALUES (2);
 INSERT INTO zipcodeInfo (city_id) VALUES (3);
 INSERT INTO zipcodeInfo (city_id) VALUES (4);
 INSERT INTO zipcodeInfo (city_id) VALUES (5);


  -- Query to find the zip code, city name and stateName
 SELECT z.zipcode_number, c.city_name, s.state_name 
 from zipcodeInfo z
 INNER JOIN cityInfo c ON z.city_id = c.city_id
 INNER JOIN stateInfo s ON c.state_id = s.state_id
 ORDER BY state_name, city_name;
 
 
 
 
 
 
 
 
 