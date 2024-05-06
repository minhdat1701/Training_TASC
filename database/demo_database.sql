-- demo phần inner join 
SELECT ID, NAME, AGE, AMOUNT, DATE
FROM test.customers
INNER JOIN test.orders
ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID
WHERE ORDERS.AMOUNT > 2000.00;
-- demo left join
SELECT ID, NAME, AMOUNT, DATE
FROM test.customers
LEFT JOIN test.orders
ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID;
-- demo right join
SELECT ID, NAME, AMOUNT, DATE
FROM test.customers
RIGHT JOIN test.orders
ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID;
-- demo full join
SELECT ID, NAME, AMOUNT, DATE
FROM test.customers
FULL JOIN test.orders
ON CUSTOMERS.ID = ORDERS.CUSTOMER_ID;
-- demo cross join
SELECT ID, NAME, AMOUNT, DATE
FROM test.customers
CROSS JOIN test.orders;
-- subquery select
SELECT * FROM test.CUSTOMERS 
WHERE ID IN (SELECT ID FROM test.CUSTOMERS WHERE SALARY > 4500);
-- subquery insert
INSERT INTO test.CUSTOMERS_BKP 
SELECT * FROM test.CUSTOMERS 
WHERE ID IN (SELECT ID FROM test.CUSTOMERS);
-- subquery update 
UPDATE test.CUSTOMERS_BKP
SET SALARY = SALARY * 1.25 
WHERE AGE IN (SELECT AGE FROM test.CUSTOMERS WHERE AGE >= 27 );
-- demo CTE 
WITH YoungCustomers AS (
    SELECT *
    FROM test.CUSTOMERS
    WHERE age < 25
)
SELECT * FROM YoungCustomers;
-- demo RANK
SELECT id, name, age, salary,
    ROW_NUMBER() OVER (ORDER BY salary DESC) AS `row_num`,
    RANK() OVER (ORDER BY salary DESC) AS `rank`,
    DENSE_RANK() OVER (ORDER BY salary DESC) AS `dense_rank`
FROM test.CUSTOMERS;
-- demo VIEW
CREATE VIEW test.CUSTOMERS_VIEW AS SELECT * FROM test.CUSTOMERS;
SELECT * FROM test.CUSTOMERS_VIEW;

UPDATE test.CUSTOMERS_VIEW 
SET AGE = 35 WHERE name = 'Ramesh';
SELECT * FROM test.CUSTOMERS_VIEW WHERE NAME ='Ramesh';
-- demo PROCEDURE
DROP PROCEDURE IF EXISTS IncreaseSalary;
DELIMITER //
CREATE PROCEDURE IncreaseSalary(IN factor DECIMAL(10, 2))
BEGIN
    UPDATE test.CUSTOMERS_BKP
    SET salary = salary * factor;
END //
DELIMITER ;
CALL IncreaseSalary(2);
SELECT * FROM test.customers_bkp;
-- demo kiểm tra 1 câu có sử dụng index
CREATE INDEX idx_age ON test.CUSTOMERS(age);
EXPLAIN SELECT * FROM test.CUSTOMERS WHERE age = 25;
-- demo partition
-- CREATE TABLE CUSTOMERS1 (
--     customer_id INT,
--     customer_name VARCHAR(50),
--     age INT,
--     city VARCHAR(50),
--     salary DECIMAL(10, 2)
-- )
-- PARTITION BY RANGE (age) (
--     PARTITION p0 VALUES LESS THAN (20),
--     PARTITION p1 VALUES LESS THAN (30),
--     PARTITION p2 VALUES LESS THAN (40),
--     PARTITION p3 VALUES LESS THAN MAXVALUE
-- );
INSERT INTO CUSTOMERS1 VALUES 
(1, 'Ramesh', 32, 'Ahmedabad', 2000.00),
(2, 'Khilan', 25, 'Delhi', 1500.00),
(3, 'Kaushik', 23, 'Kota', 2000.00),
(4, 'Chaitali', 25, 'Mumbai', 6500.00),
(5, 'Hardik', 27, 'Bhopal', 8500.00),
(6, 'Komal', 22, 'Hyderabad', 4500.00),
(7, 'Muffy', 24, 'Indore', 10000.00),
(8, 'John', 28, 'New York', 7500.00),
(9, 'Alice', 35, 'Los Angeles', 9000.00);

SHOW CREATE TABLE CUSTOMERS1;
SELECT * FROM CUSTOMERS1 PARTITION (p0);
SELECT * FROM CUSTOMERS1 PARTITION (p1);
SELECT * FROM CUSTOMERS1 PARTITION (p2);
SELECT * FROM CUSTOMERS1 PARTITION (p3);