-- Question 3

-- creating database productCategories
CREATE  DATABASE productCategories;

USE productCategories;

-- Creating table categories 
CREATE TABLE categories
(
    -- To store id , name, parent id
    category_id INTEGER AUTO_INCREMENT  NOT NULL  PRIMARY KEY , 
    category_name VARCHAR(50) NOT NULL,
    parent_id INTEGER NULL,
    FOREIGN KEY (parent_id)  REFERENCES categories (category_id)
);

-- Inserting the Top category
INSERT INTO categories(category_id,category_name) VALUES (1,'Mobiles & Tablets');
-- Inserting the sub category
INSERT INTO categories(category_name,parent_id) VALUES('MOBILES',1);
-- Inserting the last Category
INSERT INTO categories(category_name,parent_id) VALUES('Smart Phones',2);
INSERT INTO categories(category_name,parent_id) VALUES('Featured Phones',2);
-- Inserting the sub category
INSERT INTO categories(category_name,parent_id) VALUES('TABLETS',1);
-- Inserting the last Category
INSERT INTO categories(category_name,parent_id) VALUES('2G',5);
INSERT INTO categories(category_name,parent_id) VALUES('3G',5);
-- Inserting the sub category
INSERT INTO categories(category_name,parent_id) VALUES('ACCESSORIES',1);
INSERT INTO categories(category_name,parent_id) VALUES('CASE & COVERS',1);




-- Inserting the Top category
INSERT INTO categories(category_name) VALUES ('Computers');
-- Inserting the sub category
INSERT INTO categories(category_name,parent_id) VALUES('DESKTOP',10);
INSERT INTO categories(category_name,parent_id) VALUES('LAPTOP',10);
INSERT INTO categories(category_name,parent_id) VALUES('LAPTOP ACCESSORIES',10);
-- Inserting the last Category
INSERT INTO categories(category_name,parent_id) VALUES('Keyboard',13);
INSERT INTO categories(category_name,parent_id) VALUES('Mouse',13);
INSERT INTO categories(category_name,parent_id) VALUES('Headphones',13);
-- Inserting the sub category
INSERT INTO categories(category_name,parent_id) VALUES('PRINTERS',10);
-- Inserting the last Category
INSERT INTO categories(category_name,parent_id) VALUES('Inkjet',17);
INSERT INTO categories(category_name,parent_id) VALUES('Laser',17);





-- Inserting the Top category
INSERT INTO categories(category_name) VALUES ('Home Appliances');
-- Inserting the sub category
INSERT INTO categories(category_name,parent_id) VALUES('TVs',20);
-- Inserting the last Category
INSERT INTO categories(category_name,parent_id) VALUES('LED',21);
INSERT INTO categories(category_name,parent_id) VALUES('LCD',21);
INSERT INTO categories(category_name,parent_id) VALUES('PLASMA',21);
-- Inserting the sub category
INSERT INTO categories(category_name,parent_id) VALUES('Air Conditioners',20);
INSERT INTO categories(category_name,parent_id) VALUES('Washing Machines',20);
-- Inserting the sub-sub category
INSERT INTO categories(category_name,parent_id) VALUES('Full Automatic',26);
-- Inserting the last Category
INSERT INTO categories(category_name,parent_id) VALUES('Top Load',27);
INSERT INTO categories(category_name,parent_id) VALUES('Front Load',27);
-- Inserting the sub-sub category
INSERT INTO categories(category_name,parent_id) VALUES('Semi Automatic',26);




-- Query for to display all the categories along with its Parent category.
-- Result is  sorted on Parent Category.
-- Implementing self join and left outer join
select c.category_name as c_name , IFNULL(parent1.category_name,'Top Category') as parent_name , 
parent2.category_name as parent2_name , parent3.category_name as parent3_name 
from categories as c left outer join categories as parent1 on parent1.category_id = c.parent_id  
left outer join categories as parent2 on parent2.category_id = parent1.parent_id  
left outer join categories as parent3 on parent3.category_id = parent2.parent_id;
    
    
-- To select categories if it is top category
SELECT category_name FROM categories where parent_id is null ;



