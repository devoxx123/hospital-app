DROP TABLE IF EXISTS patient_tbl;

CREATE TABLE patient_tbl(
id        BIGINT  PRIMARY KEY NOT NULL,, 
address           VARCHAR(255), 
age               INTEGER not null, 
blood_group       VARCHAR(255),
date_of_birth     VARCHAR(255), 
date_of_joining   VARCHAR(255), 
disease           VARCHAR(255),
email             VARCHAR(255), 
gender            VARCHAR(255),
patient_name      VARCHAR(255), 
patient_number    VARCHAR(255), 
phone_number      VARCHAR(255), 
PRIMARY KEY (id)) 
ENGINE=MyISAM