	CREATE TABLE salesman (
    salesman_id int,
    salesman_name varchar2(32),
    salesman_city varchar2(32),
    commission int
);

INSERT ALL
    INTO SALESMAN VALUES(5002, 'Nail Knite', 'Paris', 13)
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
	INTO SALESMAN VALUES(5001, 'James Hoog', 'new York', 15) 	
SELECT 1 FROM DUAL;

SELECT * FROM SALESMAN

--Show data from the salesman_id and salesman_city columns
SELECT SALESMAN_ID, SALESMAN_CITY FROM SALESMAN

--Show data of salesman from Paris
SELECT * FROM SALESMAN WHERE SALESMAN_CITY='Paris'

--Show salesman_id and commission of Paul Adam
SELECT salesman_id,commission FROM SALESMAN WHERE SALESMAN_NAME='Paul Adam'

