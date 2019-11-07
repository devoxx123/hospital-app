
DROP TABLE IF EXISTS doctor_tbl;

CREATE TABLE doctor_tbl (
id           BIGINT   NOT NULL, 
address               VARCHAR(255), 
contact_number        VARCHAR(255),
date_of_joining       VARCHAR(255), 
degree                VARCHAR(255), 
department            VARCHAR(255), 
designation           VARCHAR(255), 
doctor_id             VARCHAR(255), 
doctor_name           VARCHAR(255),
email                 VARCHAR(255), 
experience            INTEGER NOT NULL, 
password              VARCHAR(255), 
profile               VARCHAR(255), 
PRIMARY KEY (id)) 
ENGINE=MyISAM


DROP TABLE IF EXISTS appointment_tbl;

CREATE TABLE appointment_tbl (
id             BIGINT   NOT NULL, 
appointment_id          VARCHAR(255), 
disease                 VARCHAR(255), 
doctor_name             VARCHAR(255), 
patient_name            VARCHAR(255),
symptons                VARCHAR(255),
preferred_date          VARCHAR(255),
preferred_day           VARCHAR(255), 
preferred_time          VARCHAR(255), 
description             VARCHAR(255),  
PRIMARY KEY (id)) 
ENGINE=MyISAM


DROP TABLE IF EXISTS prescription_tbl;

create table prescription_tbl (
id           BIGINT     NOT NULL,
case_history            VARCHAR(255), 
description             VARCHAR(255), 
doctor_name             VARCHAR(255), 
medication              VARCHAR(255), 
patient_name            VARCHAR(255), 
pharma_medication       VARCHAR(255),
prescription_date       VARCHAR(255), 
prescription_id         VARCHAR(255), 
PRIMARY KEY (id)) 
ENGINE=MyISAM

DROP TABLE IF EXISTS report_tbl;

create table report_tbl (
id           BIGINT     NOT NULL, 
doctor_name             VARCHAR(255), 
patient_name            VARCHAR(255), 
report_date             VARCHAR(255), 
report_desc             VARCHAR(255), 
report_id               VARCHAR(255), 
report_type             VARCHAR(255), 
PRIMARY KEY (id)) 
ENGINE=MyISAM