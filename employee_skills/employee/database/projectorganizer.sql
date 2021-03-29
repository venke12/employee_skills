BEGIN TRANSACTION;

CREATE TABLE employee
(
        id serial
        ,firstname varchar(20) NOT NULL
        ,lastname varchar(25) NOT NULL
        ,address_id integer NOT NULL
        ,birthdate date NOT NULL
        ,hiredate date NOT NULL
        ,role_id integer
        ,PRIMARY KEY (id)
);
CREATE TABLE address
(
        id serial
        ,street varchar(40) NOT NULL
        ,suite varchar(20) 
        ,city varchar(35) NOT NULL
        ,state_region varchar(3) NOT NULL
        ,zip varchar(10) NOT NULL
        ,country varchar(2) NOT NULL
        ,PRIMARY KEY (id)
);
CREATE TABLE role
(
        id serial
        ,name varchar(30) NOT NULL
        ,description varchar(150)
        ,PRIMARY KEY (id)
);
CREATE TABLE skill
(
        id serial
        ,name varchar(30) NOT NULL
        ,description varchar(150)
        ,PRIMARY KEY (id)
);
CREATE TABLE business_unit
(
        id serial
        ,name varchar(30) NOT NULL
        ,description varchar(150)
        ,PRIMARY KEY (id)
);
CREATE TABLE employee_skill
(
        employee_id integer NOT NULL
        ,skill_id integer NOT NULL
        ,experience integer NOT NULL
        ,CONSTRAINT pk_employee_skill_employee_id_skill_id
        PRIMARY KEY (employee_id, skill_id)
);
CREATE TABLE employee_bus_unit
(
        employee_id integer NOT NULL
        ,bus_unit_id integer NOT NULL
        ,CONSTRAINT pk_employee_bus_unit_employee_id_bus_unit_id
        PRIMARY KEY (employee_id, bus_unit_id)
);

COMMIT;

BEGIN TRANSACTION;

ALTER TABLE employee
ADD CONSTRAINT fk_address 
FOREIGN KEY (address_id) 
REFERENCES address (id);

ALTER TABLE employee
ADD CONSTRAINT fk_role 
FOREIGN KEY (role_id) 
REFERENCES role (id);

ALTER TABLE employee_skill
ADD FOREIGN KEY(employee_id)
REFERENCES employee(id);

ALTER TABLE employee_skill
ADD FOREIGN KEY(skill_id)
REFERENCES skill(id);

ALTER TABLE employee_bus_unit
ADD FOREIGN KEY(employee_id)
REFERENCES employee(id);

ALTER TABLE employee_bus_unit
ADD FOREIGN KEY(bus_unit_id)
REFERENCES business_unit(id);

COMMIT;

BEGIN TRANSACTION;

--6 addresses
INSERT INTO address (street, suite, city, state_region, zip, country)
VALUES ('123 Oak St.', '', 'Detroit','MI', '48206', 'US');

INSERT INTO address (street, suite, city, state_region, zip, country)
VALUES ('123 Elm St.', '', 'Detroit','MI', '48206', 'US'); 

INSERT INTO address (street, suite, city, state_region, zip, country)
VALUES ('123 Maple St.', '', 'Detroit','MI', '48206', 'US'); 

INSERT INTO address (street, suite, city, state_region, zip, country)
VALUES ('123 Birch St.', '', 'Detroit','MI', '48206', 'US'); 

INSERT INTO address (street, suite, city, state_region, zip, country)
VALUES ('123 Pine St.', '', 'Detroit','MI', '48206', 'US'); 

INSERT INTO address (street, suite, city, state_region, zip, country)
VALUES ('123 East Grand Blvd.', '', 'Detroit','MI', '48206', 'US');       
        

--4 roles
INSERT INTO role (name, description)
VALUES ('Technical Consultant', 'Programming, testing, customer liaison');

INSERT INTO role (name, description)
VALUES ('Project Manager', 'Budget, planning, project management');

INSERT INTO role (name, description)
VALUES ('Director', 'Budget, strategy, major projects');

INSERT INTO role (name, description)
VALUES ('Chief', 'Corporate direction, board interaction, governance');     
        
        
--6 employees
INSERT INTO employee (firstname, lastname, address_id, birthdate, hiredate)
VALUES ('Alpha', 'Akita', '1','01-01-1980', '9-9-2006');

INSERT INTO employee (firstname, lastname, address_id, birthdate, hiredate)
VALUES ('Bravo', 'Bulldog', '2','02-02-1980', '9-9-2007');

INSERT INTO employee (firstname, lastname, address_id, birthdate, hiredate)
VALUES ('Charlie', 'Chow', '3','03-03-1980', '9-9-2008');

INSERT INTO employee (firstname, lastname, address_id, birthdate, hiredate)
VALUES ('Delta', 'Dane', '4','04-04-1980', '9-9-2009');

INSERT INTO employee (firstname, lastname, address_id, birthdate, hiredate)
VALUES ('Echo', 'Mastiff', '5','05-05-1980', '9-9-2012');

INSERT INTO employee (firstname, lastname, address_id, birthdate, hiredate)
VALUES ('Foxtrot', 'Fox', '6','06-06-1980', '9-9-2015');

--8 skills  
INSERT INTO skill (name, description)
VALUES ('Java', 'Java programming');

INSERT INTO skill (name, description)
VALUES ('JavaScript', 'JavaScript programming');

INSERT INTO skill (name, description)
VALUES ('PostgreSQL', 'PostgreSQL database setup and queries');

INSERT INTO skill (name, description)
VALUES ('VUE.JS', 'setup and develop a Vue project');

INSERT INTO skill (name, description)
VALUES ('CSS3', 'Manipulate HTML using cascading style sheets');

INSERT INTO skill (name, description)
VALUES ('Project Management', 'Manage...');

INSERT INTO skill (name, description)
VALUES ('Division Strategy', 'Develop...');

INSERT INTO skill (name, description)
VALUES ('P&L Responsibility', 'Manage...');


--4 business units
INSERT INTO business_unit (name, description)
VALUES ('Digital Experience Group', 'Manages and develops the customer/user experience');

INSERT INTO business_unit (name, description)
VALUES ('Adobe', 'Managing customer expectations...');

Insert INTO business_unit (name, description)
VALUES ('IBM NBU', 'Developing new business with IBM');

Insert INTO business_unit (name, description)
VALUES ('API Management', 'API...');

UPDATE employee SET role_id = 4 WHERE id = 1;
UPDATE employee SET role_id = 3 WHERE id = 2;
UPDATE employee SET role_id = 2 WHERE id = 3;
UPDATE employee SET role_id = 2 WHERE id = 4;
UPDATE employee SET role_id = 1 WHERE id = 5;
UPDATE employee SET role_id = 1 WHERE id = 6;


INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (1, 8, 60);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (1, 7, 72);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (1, 6, 96);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (1, 1, 120);

INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (2, 7, 24);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (2, 6, 36);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (2, 2, 48);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (2, 5, 96);

INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (3, 6, 48);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (3, 1, 48);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (3, 3, 48);

INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (4, 1, 36);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (4, 2, 36);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (4, 3, 36);

INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (5, 1, 24);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (5, 2, 24);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (5, 3, 24);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (5, 4, 24);

INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (6, 2, 12);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (6, 4, 12);
INSERT INTO employee_skill (employee_id, skill_id, experience) VALUES (6, 5, 12);

INSERT INTO employee_bus_unit (employee_id, bus_unit_id) VALUES (3, 1);
INSERT INTO employee_bus_unit (employee_id, bus_unit_id) VALUES (3, 2);
INSERT INTO employee_bus_unit (employee_id, bus_unit_id) VALUES (4, 3);
INSERT INTO employee_bus_unit (employee_id, bus_unit_id) VALUES (4, 4);
INSERT INTO employee_bus_unit (employee_id, bus_unit_id) VALUES (5, 1);
INSERT INTO employee_bus_unit (employee_id, bus_unit_id) VALUES (6, 3);

