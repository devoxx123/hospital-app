DROP TABLE IF EXISTS department_tbl;

CREATE TABLE department_tbl(
id      BIGINT      PRIMARY KEY NOT NULL,
dept_description    VARCHAR(255), 
dept_floor          VARCHAR(255), 
dept_id             VARCHAR(255), 
dept_incharge_name  VARCHAR(255), 
dept_name           VARCHAR(255), 
dept_staff          VARCHAR(255), 
PRIMARY KEY (id)) 
ENGINE=MyISAM


DROP TABLE IF EXISTS billing_tbl;

CREATE TABLE billing_tbl 
(id             BIGINT NOT NULL  AUTO_INCREMENT,
advance_charge          VARCHAR(255), 
bill_number             VARCHAR(255), 
billing_date            DATETIME, 
doctor_charge           VARCHAR(255), 
lab_charge              VARCHAR(255), 
medicine_charge         VARCHAR(255), 
no_of_days              VARCHAR(255), 
nursing_charge          VARCHAR(255), 
patient_type            VARCHAR(255), 
payment_mode            VARCHAR(255), 
payment_mode_details    VARCHAR(255),
room_charge             VARCHAR(255), 
PRIMARY KEY (id))
ENGINE=MyISAM