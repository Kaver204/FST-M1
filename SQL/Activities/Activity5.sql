
-- Update the grade score of salesmen from Rome to 200.
UPDATE salesman SET grade=200 WHERE salesman_city='Rome';

-- Update the grade score of James Hoog to 300.
UPDATE SALESMAN SET GRADE=300 WHERE SALESMAN_NAME='James Hoog';

-- Update the name McLyon to Pierre.
UPDATE SALESMAN SET SALESMAN_NAME='Pierre' WHERE SALESMAN_NAME='McLyon';

-- Display modified data
SELECT * FROM SALESMAN;
