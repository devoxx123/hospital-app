CREATE TABLE IF NOT EXISTS `appointment` (
  `doctor` varchar(100) NOT NULL,
  `patient` varchar(100) NOT NULL,
  `registrationNumber` int(10) NOT NULL,
  `day` varchar(10) NOT NULL,
  `time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `appointment` (`doctor`, `patient`, `registrationNumber`, `day`, `time`) VALUES
('Dr. Rupak Das ( General Physician ) ', 'Anubhav Saxena', 120546520, 'wednesday', '10-10:30 AM');

CREATE TABLE `hospi_room` (
  `room_id` int(11) NOT NULL,
  `room_name` varchar(100) NOT NULL,
  `room_avilabl` varchar(20) DEFAULT NULL,
  `rc_time_mo` varchar(10) NOT NULL DEFAULT '11.30 AM',
  `rc_time_ev` varchar(10) DEFAULT '06.30 PM',
  `room_drid` int(11) DEFAULT NULL,
  `eroom_drid` int(11) DEFAULT NULL,
  `room_petID` varchar(11) DEFAULT 'No Patient'
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


 Dumping data for table `hospi_room`

INSERT INTO `room` (`room_id`, `room_name`, `room_avilabl`, `rc_time_mo`, `rc_time_ev`, `room_drid`, `eroom_drid`, `room_petID`) VALUES
(1, 'Room No: 1', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(2, 'Room No: 2', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(3, 'Room No: 3', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(4, 'Room No: 4', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(5, 'Room No: 5', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(6, 'Room No: 6', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(7, 'Room No: 7', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(8, 'Room No: 8', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(9, 'Room No: 9', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient'),
(10, 'Room No: 10', 'AV', '11.30 AM', '06.30 PM', NULL, NULL, 'No Patient');





CREATE TABLE `appointment` (
  `appointmentId` int(11) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) NOT NULL,
  `doctorId` int(11) DEFAULT NULL,
  `isClosed` int(11) DEFAULT '0',
  `dateCreated` double DEFAULT NULL,
  `symptons` varchar(45) DEFAULT NULL,
  `disease` varchar(45) DEFAULT NULL,
  `preferredDate` double DEFAULT NULL,
  `allocatedDate` double DEFAULT '0',
  `title` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`appointmentId`),
  KEY `appointment_ibfk_1_idx` (`patientId`),
  KEY `appointment_ibfk_2_idx` (`doctorId`),
  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`patientId`) REFERENCES `patient` (`patientId`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`doctorId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;


INSERT INTO `appointment` VALUES (1,1,12,1,1492426867320,'Cough',' Tubercolosis',1492426867320,1492426867320,'Tubercolosis in Cough'),
(2,1,11,0,1492427049030,'Heart Pain',' Heart Attack',1492427049030,1492427049030,'Heart Attack and pain'),
(3,2,12,1,1492427176793,'Headache',' Brain Tumor',1492427176793,1492427176793,'Tumour in Brain'),
(4,2,11,0,1492427265008,'Headache','Migraine',1492427265008,1492427265008,'Migraine'),
(5,3,12,1,1492427355113,'Pain in Bones',' Bone Fracture',1492427355113,1492427355113,'Bone Broken'),
(6,3,11,0,1492427586601,'Pain in Left Ear','Ear Drum Rupture',1492427586601,1492427586601,'Left Ear Damage'),
(7,4,12,1,1492427777615,'Pain in eye','Eye Infection',1492427777615,1492427777615,'Eye Problem'),
(8,4,11,0,1492519085680,'Sneezing','Cold',1492519085680,1492519085680,'Cold and Sneeze'),
(9,5,12,1,1492620672132,'Nose Bleeding','Nose Cancer',1492540200020,1492519085681,'Nose Problem'),
(10,5,11,0,1492633630915,'Constipation','Mental Pressure',1492540200040,1492519089681,'Acute Constipation Problem'),
(11,1,14,0,1492722733367,'the ache in the stomach','Worms',1492972200000,1492972200000,'Stomach'),
(12,1,15,0,1492723131704,'Headache','Migrane',1492713000000,1492713000000,'Headache');
