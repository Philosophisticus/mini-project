USE invoice_diplom;

DELIMITER $$

DROP PROCEDURE IF EXISTS TruncateTables$$

CREATE PROCEDURE TruncateTables()
BEGIN
DECLARE done BOOL DEFAULT FALSE;
DECLARE truncate_command VARCHAR(512);
DECLARE truncate_cur
 CURSOR FOR /*This is the query which selects the tables we want to truncate*/
  SELECT CONCAT('TRUNCATE TABLE ',table_name)
  FROM INFORMATION_SCHEMA.TABLES
  WHERE TABLE_SCHEMA = DATABASE();
DECLARE
  CONTINUE HANDLER FOR
  SQLSTATE '02000'
   SET done = TRUE;

SET foreign_key_checks = 0;
OPEN truncate_cur;

truncate_loop: LOOP
 FETCH truncate_cur INTO truncate_command;
 SET @truncate_command = truncate_command;

 IF done THEN
  CLOSE truncate_cur;
  LEAVE truncate_loop;
 END IF;

 /*Main part - preparing and executing the statement*/
 PREPARE truncate_command_stmt FROM @truncate_command;
 EXECUTE truncate_command_stmt;

END LOOP;
SET foreign_key_checks = 1;
END$$

DELIMITER ;

CALL TruncateTables();

SOURCE init.sql;