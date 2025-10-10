Insert into staff (id , first_name , last_name , email) values (5, 'Tames' , 'Hevis', 'haves@gmail.com'),
															   (6, 'Mikel', 'Junior' , 'judev@gmail.com'),
                                                               (7, 'Camerbench' , 'Binetec', 'cam.bene@gmail.com');

                              USE IBAD;
                                                               SELECT * FROM ibad.staff;

INSERT INTO staff (ID , FIRST_NAME , EMAIL) VALUES (6, 'TOM' , 'TOM_TOMY@GMAIL.COM');

select FIRST_NAME  FROM staff; /* FOR PERTICULAR NAME COLUMN */

select first_name , last_name FROM staff;

SELECT first_name , last_name from staff;

select * from staff;

Insert into staff (id , first_name , last_name , email) values
(8, 'JAMES', 'BAKER', 'jam.bak23@gmail.com');

SELECT distinct FIRST_NAME   FROM staff;

SELECT * FROM staff WHERE ID BETWEEN 2 AND  5;

select * FROM staff WHERE FIRST_NAME IN ('JAMES', 'MARY');

select * FROM staff WHERE FIRST_NAME NOT IN ('JAMES', 'MARY');

SELECT * FROM staff WHERE email like '%gmail.com';

SELECT * FROM staff WHERE email NOT LIKE 'm___.%@%.com';

SELECT * FROM staff WHERE LAST_NAME IS NULL;

SELECT * FROM staff WHERE LAST_NAME IS NOT NULL;

SELECT * FROM staff ORDER BY LAST_NAME;

SELECT * FROM staff ORDER BY ID DESC;

SELECT * FROM staff  ORDER BY LAST_NAME DESC;

SELECT * FROM staff ORDER BY FIRST_NAME , LAST_NAME;

USE IBAD;

INSERT INTO staff (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (5,'Ashley', 'Young', 'ash.youn@gmail.com');

/* UPDATE */
SET SQL_SAFE_UPDATES =0;

UPDATE staff SET EMAIL ='cam.bene@gmail.com' WHERE ID = 8;

UPDATE staff SET LAST_NAME = 'FLORA' , EMAIL ='flora@gmail.com' WHERE ID = 6;

SELECT * FROM staff;

DELETE FROM staff WHERE ID = 8;

DELETE FROM staff WHERE EMAIL NOT LIKE '%@%.%';