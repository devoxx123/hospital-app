
DELETE FROM doctor_tbl;

INSERT INTO `doctor_tbl`(`id`,`doctor_id`,`doctor_name`,`designation`,`degree`,`experience`,`address`,`email`,`contact_number`,`password`,`profile`,`department`,`date_of_joining`)
VALUES 
(1 , "555136" , "Camille"  , "MBBS"  , "FSTS"  , 12 , "Parkview Place St.Louis", "Camille@yahoo.com"    , "314-362-1291" , "123456" , "" ,  "Oncology"      , "2019-10-28"),
(2 , "297820" , "Douglas"  , "BDS"   , "FSCAI" , 10 , "1020 N.Mason Road"      , "Douglas@outlook.com"  , "314-362-7388" , "636263" , "" ,  "Dermatology"   , "2019-02-10"),
(3 , "730268" , "Rebecca"  , "OD"    , "Ph.D"  , 11 , "1040 N.Creve Coeur"     , "Rebecca@gmail.com"    , "314-996-8060" , "125453" , "" ,  "Hematology"    , "2019-05-30"),
(4 , "130051" , "Muhammad" , "DPM"   , "FAAD"  , 15 , "4200 N.Cloverleaf"      , "Muhammad@yahoo.com"   , "636-939-3362" , "984543" , "" ,  "Ophthalmology" , "2019-07-22"),
(5 , "210966" , "Jennifer" , "DPT"   , "FACS"  , 20 , "6030 N.St.Louis"        , "Jennifer@outlook.com" , "314-454-6051" , "875643" , "" ,  "Anesthesiology", "2019-12-18"),
(6 , "094416" , "MichaelS" , "DC"    , "FICS"  , 12 , "1300 N Outer Forty"     , "MichaelS@yahoo.com"   , "314-454-2694" , "231132" , "" ,  "Neurology"     , "2019-01-02"),
(7 , "969091" , "Hilary"   , "PA"    , "FSTS"  , 09 , "5201 M.Plaza"           , "Hilary@outlook.com "  , "290-314-362"  , "453245" , "" ,  "Rheumatology"  , "2019-09-19"),
(8 , "247526" , "Richard"  , "R.Ph"  , "DMD"   , 23 , "1263 O.Blvd"            , "Richard@gmail.com"    , "314-362-2901" , "985674" , "" ,  "Radiology"     , "2019-04-06"),
(9 , "538959" , "Thomas"   , "PharmD", "FACS"  , 30 , "1454 S.Drive"           , "Thomas@outlook.com"   , "314-747-1206" , "345255" , "" ,  "Cardiology"    , "2019-06-11"),
(10 ,"074296" , "David"    , "DPM"   , "FSTS"  , 10 , "5170 S.Parkview"        , "David@yahoo.com"      , "314-222-6252" , "234245" , "" ,   "Otolarygology" ,"2019-03-07");


DELETE FROM appointment_tbl;
INSERT INTO `appointment_tbl`(`id`,`appointment_id`,`disease`,`doctor_name`,`patient_name`,`symptons`,`preferred_date`,`preferred_day`,`preferred_time`,`description`)
VALUES
(1 , "5453969940" , "Tubercolosis"    , "MichaelS" , "Elboghdady"    , "Cough"        , "2019-03-07" , "Monday"   , "10:30 AM" , "Tubercolosis in Cough"),
(2 , "6661767918" , "Heart Attack"    , "Thomas"   , "Mahmoud Zaher" , "Heart Pain"   , "2019-06-11" , "Thurday"  , "12:45 PM" , "Heart Attack and pain"),
(3 , "5180836885" , "Brain Tumor"     , "Muhammad" , "Ahmed Adel"    , "Headache"     , "2019-04-06" , "Friday"   , "03:00 PM" , "Tumour in Brain"),
(4 , "4834353693" , "Migraine"        , "Camille"  , "Ahmed Adel"    , "Headache"     , "2019-09-19" , "Wednesday", "11:00 AM" , "Migraine"),
(5 , "2153020925" , "Bone Fracture"   , "Rebecca"  , "Lydia Magd"    , "Pain in Bones", "2019-01-02" , "Saterday" , "04:30 PM" , "Bone Broken"),
(6 , "9841413810" , "EarDrum Rupture" , "Douglas"  , "Shaymaa Hosni" , "Pain Left Ear", "2019-12-18" , "Thurday"  , "07:00 PM" , "Left Ear Damage"),
(7 , "7953321686" , "Eye Infection"   , "Richard"  , "Akash Agarwal" , "Pain in eye"  , "2019-07-22" , "Monday"   , "09:30 AM" , "Eye Problem"),
(8 , "5796394921" , "Cold"            , "Hilary"   , "Mohamed Yehia" , "Sneezing"     , "2019-07-22" , "Wednesday", "12:45 PM" , "Cold and Sneez"),
(9 , "6860779047" , "Nose Cancer"     , "Jennifer" , "Ashraf Mohamed", "Nose Bleeding", "2019-02-10" , "Friday"   , "05:00 PM" , "Nose Problem"),
(10 ,"9268412273" , "Mental Pressure" , "David"    , "Mohamed Emad"  , "Constipation" , "2019-10-28" , "Saterday" , "10:30 AM" , "Acute Constipation Problem");


DELETE FROM  prescription_tbl;


DELETE FROM report_tbl;

