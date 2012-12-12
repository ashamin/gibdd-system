/*
* Model: gibdd-system
* Database: MySQL 5.5
*/

-- Create users section --------------------------------------------------

-- Admin user

CREATE USER gibdd_admin@localhost IDENTIFIED BY 'Yos6ym25';
GRANT ALL PRIVILEGES ON gibdd_system_db.* TO gibdd_admin@localhost;

-- Default user

CREATE USER gibdd_user@localhost IDENTIFIED BY 'Iwy4Tj8i';
GRANT INSERT,UPDATE,DELETE,SELECT ON gibdd_system_db.* TO gibdd_user@localhost;