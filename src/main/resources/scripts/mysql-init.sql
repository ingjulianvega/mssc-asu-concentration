DROP DATABASE IF EXISTS concentrationservice ;
DROP USER IF EXISTS `concentration_service`@`%`;
CREATE DATABASE IF NOT EXISTS concentrationservice CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS `concentration_service`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
GRANT SELECT, INSERT, UPDATE, DELETE, CREATE, DROP, REFERENCES, INDEX, ALTER, EXECUTE, CREATE VIEW, SHOW VIEW,
CREATE ROUTINE, ALTER ROUTINE, EVENT, TRIGGER ON `concentrationservice`.* TO `concentration_service`@`%`;
FLUSH PRIVILEGES;