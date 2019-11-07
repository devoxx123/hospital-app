
DROP TABLE IF EXISTS hospital_tbl;

CREATE TABLE hospital_tbl (
id               INTEGER        PRIMARY KEY NOT NULL, 
address          VARCHAR(255), 
city             VARCHAR(255), 
email            VARCHAR(255), 
fax              VARCHAR(255), 
hospital_id      VARCHAR(255), 
name             VARCHAR(255), 
rank             INTEGER, 
review           VARCHAR(255), 
state            VARCHAR(255), 
telephone        VARCHAR(255), 
type             VARCHAR(255), 
website          VARCHAR(255), 
PRIMARY KEY (id)) 
engine=MyISAM