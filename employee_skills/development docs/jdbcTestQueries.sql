--SKILL getAllSkillsByEmployeeId
SELECT e.id, e.firstname, e.lastname, s.id, s.name skill_name, s.description, es.experience
FROM employee e
INNER JOIN employee_skill es ON e.id = es.employee_id 
INNER JOIN skill s ON  s.id = es.skill_id
WHERE e.id =6;

--SKILL getSkillByIdFromEmployeeById
SELECT e.id, e.firstname, e.lastname, s.name skill_name, s.description
FROM employee e
INNER JOIN employee_skill es ON e.id = es.employee_id 
INNER JOIN skill s ON  s.id = es.skill_id
WHERE e.id =3 AND s.id = 2;

--createSkillByEmployeeId
-- create skill
INSERT INTO skill (name, description)
VALUES ('.NET', '.Net Programming')
RETURNING id;

--add skill to employee
INSERT INTO employee_skill (employee_id, skill_id, experience)
VALUES ('3', '9', '24');

--check SELECT
SELECT e.id, e.firstname, e.lastname, s.name skill_name, s.description
FROM employee e
INNER JOIN employee_skill es ON e.id = es.employee_id 
INNER JOIN skill s ON  s.id = es.skill_id
WHERE e.id =3;

--update updateSkillByIdFromEmployeeById
UPDATE employee_skill SET experience = 18 WHERE employee_id = 6 AND skill_id = 4;

-----------------------------------------------------
--EMPLOYEE getAllEmployees
SELECT e.id, e.firstname, e.lastname, a.street, a.suite, a.city, a.state_region, a.zip, a.country, e.birthdate, e.hiredate, r.name, r.description
FROM employee e
INNER JOIN address a ON e.address_id = a.id
INNER JOIN role r ON e.role_id = r.id;

--getEmployeeById
SELECT e.id, e.firstname, e.lastname, a.street, a.suite, a.city, a.state_region, a.zip, a.country, e.birthdate, e.hiredate, r.name
FROM employee e
INNER JOIN address a ON e.address_id = a.id
INNER JOIN role r ON e.role_id = r.id
WHERE e.id = 2;

--INSERT createEmployee (address)       
INSERT INTO address (street, suite, city, state_region, zip, country)
VALUES ('123 Beech St.', '', 'Livonia','MI', '48206', 'US')
RETURNING id;

SELECT * FROM address;

-- INSERT createEmployee (employee)
INSERT INTO employee (firstname, lastname, address_id, birthdate, hiredate, role_id)
VALUES ('Benjamin', 'Button', '8','01-01-1988', '9-9-2020', 1);

SELECT * FROM employee;

--UPDATE AND SELECT updateEmployee
UPDATE employee SET firstname ='James', lastname = 'Jamerson', address_id ='8', birthdate ='01-01-1988' , hiredate = '9-9-2020', role_id = '1' WHERE id = 10;

UPDATE address SET street = '123 Walnut Ln.', suite = 'penthouse', city = 'Detroit', state_region = 'MI', zip = '48206', country = 'US' WHERE id = 8;

SELECT address_id FROM employee WHERE id = 10;

-- DELETE
DELETE FROM address WHERE id = 7;
DELETE FROM employee WHERE id = 7;