/*
Model: gibdd-system
Database: MySQL 5.5
*/

-- Create database -------------------------------------------------

create database gibdd_system;
use gibdd_system;

-- Create users section -------------------------------------------------

-- Common user

create user gibddadmin identified by 'gibddadmin'; 
grant usage on *.* to gibddadmin@localhost identified by 'Inc54rE34dibl1eHa3rdCoR54ePas3sw65OR12d'; 
grant all privileges on gibddsystem.* to gibddadmin@localhost;

-- Create tables section -------------------------------------------------

-- Table humans

CREATE TABLE humans
(
  human_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  name Varchar(100) NOT NULL,
  passport_number Varchar(10) NOT NULL,
  address Varchar(100),
 PRIMARY KEY (human_id),
 UNIQUE human_id (human_id)
);

-- Table insperctors

CREATE TABLE insperctors
(
  inspector_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  password Varchar(20) NOT NULL,
  login Varchar(20) NOT NULL,
  human_id Int UNSIGNED,
  post_id Int UNSIGNED,
  rank_id Int UNSIGNED,
 PRIMARY KEY (inspector_id),
 UNIQUE inspector_id (inspector_id)
);

-- Table automatic_registrators

CREATE TABLE automatic_registrators
(
  automatic_registrator_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  UID Varchar(10) NOT NULL,
 PRIMARY KEY (automatic_registrator_id),
 UNIQUE automatic_registrator_id (automatic_registrator_id)
);

-- Table protocols

CREATE TABLE protocols
(
  protocol_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  date Date NOT NULL,
  violation_id Int UNSIGNED,
  patrol_inspector_id Int UNSIGNED,
  vehicle_id Int UNSIGNED,
 PRIMARY KEY (protocol_id),
 UNIQUE protocol_id (protocol_id)
);

-- Table duty_tours

CREATE TABLE duty_tours
(
  duty_tour_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  start_date Date NOT NULL,
  finish_date Date NOT NULL,
  duty_inspector_id Int UNSIGNED,
 PRIMARY KEY (duty_tour_id),
 UNIQUE duty_tour_id (duty_tour_id)
);

-- Table patrol_inspectors

CREATE TABLE patrol_inspectors
(
  patrol_inspector_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  inspector_id Int UNSIGNED,
 PRIMARY KEY (patrol_inspector_id),
 UNIQUE patrol_inspector_id (patrol_inspector_id)
);

-- Table duty_inspectors

CREATE TABLE duty_inspectors
(
  duty_inspector_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  inspector_id Int UNSIGNED,
 PRIMARY KEY (duty_inspector_id),
 UNIQUE duty_inspector_id (duty_inspector_id)
);

-- Table driver_license_inspectors

CREATE TABLE driver_license_inspectors
(
  driver_license_inspector_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  inspector_id Int UNSIGNED,
 PRIMARY KEY (driver_license_inspector_id),
 UNIQUE driver_license_inspector_id (driver_license_inspector_id)
);

-- Table vehicle_registration_certificate_inspectors

CREATE TABLE vehicle_registration_certificate_inspectors
(
  vehicle_registration_certificate_inspector_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  inspector_id Int UNSIGNED,
 PRIMARY KEY (vehicle_registration_certificate_inspector_id),
 UNIQUE vehicle_registration_certificate_inspector_id (vehicle_registration_certificate_inspector_id)
);

-- Table vehicles

CREATE TABLE vehicles
(
  vehicle_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  color Varchar(20) NOT NULL,
  EIN Varchar(20) NOT NULL,
  VIN Varchar(20) NOT NULL,
  year Date NOT NULL,
  brand_id Int UNSIGNED,
 PRIMARY KEY (vehicle_id),
 UNIQUE vehicle_id (vehicle_id)
);

-- Table vehicle_registration_certificates

CREATE TABLE vehicle_registration_certificates
(
  vehicle_registration_certificate_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  leave_date Date NOT NULL,
  registration_date Date NOT NULL,
  registration_number Char(20) NOT NULL,
  vehicle_registration_certificate_inspector_id Int UNSIGNED,
  vehicle_id Int UNSIGNED,
 PRIMARY KEY (vehicle_registration_certificate_id),
 UNIQUE vehicle_registration_certificate_id (vehicle_registration_certificate_id)
);

-- Table driver_licenses

CREATE TABLE driver_licenses
(
  driver_license_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  registration_date Date NOT NULL,
  leave_date Date NOT NULL,
  categories Varchar(10) NOT NULL,
  driver_license_inspector_id Int UNSIGNED,
  human_id Int UNSIGNED,
 PRIMARY KEY (driver_license_id),
 UNIQUE driver_license_id (driver_license_id)
);

-- Table ranks

CREATE TABLE ranks
(
  rank_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  rank Varchar(50) NOT NULL,
 PRIMARY KEY (rank_id),
 UNIQUE rans_id (rank_id)
);

-- Table posts

CREATE TABLE posts
(
  post_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  post Varchar(50) NOT NULL,
 PRIMARY KEY (post_id),
 UNIQUE post_id (post_id)
);

-- Table violations

CREATE TABLE violations
(
  violation_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  title Varchar(200) NOT NULL,
  description Varchar(1000) NOT NULL,
  punishment Varchar(1000) NOT NULL,
 PRIMARY KEY (violation_id),
 UNIQUE violation_id (violation_id)
);

-- Table brands

CREATE TABLE brands
(
  brand_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  brand Varchar(50) NOT NULL,
 PRIMARY KEY (brand_id),
 UNIQUE brand_id (brand_id)
);

-- Table duties

CREATE TABLE duties
(
  duty_tour_id Int UNSIGNED NOT NULL,
  duty_id Int UNSIGNED NOT NULL AUTO_INCREMENT,
  patrol_inspector_id Int UNSIGNED,
 UNIQUE duty_id (duty_id)
);

ALTER TABLE duties ADD PRIMARY KEY (duty_tour_id,duty_id);

-- Create relationships section ------------------------------------------------- 

ALTER TABLE insperctors ADD CONSTRAINT is_as FOREIGN KEY (human_id) REFERENCES humans (human_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE driver_license_inspectors ADD CONSTRAINT is_as4 FOREIGN KEY (inspector_id) REFERENCES insperctors (inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE patrol_inspectors ADD CONSTRAINT is_as1 FOREIGN KEY (inspector_id) REFERENCES insperctors (inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE duty_inspectors ADD CONSTRAINT is_as2 FOREIGN KEY (inspector_id) REFERENCES insperctors (inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE vehicle_registration_certificate_inspectors ADD CONSTRAINT is_as3 FOREIGN KEY (inspector_id) REFERENCES insperctors (inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE driver_licenses ADD CONSTRAINT give FOREIGN KEY (driver_license_inspector_id) REFERENCES driver_license_inspectors (driver_license_inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE driver_licenses ADD CONSTRAINT own FOREIGN KEY (human_id) REFERENCES humans (human_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE insperctors ADD CONSTRAINT takes FOREIGN KEY (post_id) REFERENCES posts (post_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE insperctors ADD CONSTRAINT is_as5 FOREIGN KEY (rank_id) REFERENCES ranks (rank_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE vehicle_registration_certificates ADD CONSTRAINT made_by FOREIGN KEY (vehicle_registration_certificate_inspector_id) REFERENCES vehicle_registration_certificate_inspectors (vehicle_registration_certificate_inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE vehicle_registration_certificates ADD CONSTRAINT have_inf FOREIGN KEY (vehicle_id) REFERENCES vehicles (vehicle_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE protocols ADD CONSTRAINT tell_about FOREIGN KEY (violation_id) REFERENCES violations (violation_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE protocols ADD CONSTRAINT is_filled FOREIGN KEY (patrol_inspector_id) REFERENCES patrol_inspectors (patrol_inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE vehicles ADD CONSTRAINT has FOREIGN KEY (brand_id) REFERENCES brands (brand_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE duties ADD CONSTRAINT contains FOREIGN KEY (duty_tour_id) REFERENCES duty_tours (duty_tour_id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE protocols ADD CONSTRAINT have_data FOREIGN KEY (vehicle_id) REFERENCES vehicles (vehicle_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE duty_tours ADD CONSTRAINT make FOREIGN KEY (duty_inspector_id) REFERENCES duty_inspectors (duty_inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;

ALTER TABLE duties ADD CONSTRAINT take_part FOREIGN KEY (patrol_inspector_id) REFERENCES patrol_inspectors (patrol_inspector_id) ON DELETE RESTRICT ON UPDATE CASCADE;
