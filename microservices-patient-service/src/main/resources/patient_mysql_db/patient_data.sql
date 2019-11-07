DELETE FROM patient_tbl;

INSERT INTO patient_tbl(`id`,`patient_name`,`gender`,`age`,`phone_number`,`email`,`date_of_birth`,`address`,`date_of_joining`,`patient_number`,`blood_group`,`disease`) VALUES
(1 , "Amir Elboghdady" ,"Male"  , "32" , "7879284023" , "uraeus@msn.com"     , "12-09-1992" , "Bangalore"  ,"07-02-2019" , "65381722" , "A+" , "Fever"),
(2 , "Mahmoud Zaher"   ,"Male"  , "23" , "8889229878" , "konst@icloud.com"   , "23-04-1996" , "Mumbai"     ,"27-07-2018" , "65381733" , "O+" , "Caugh"),
(3 , "Ahmed Adel"      ,"Female", "19" , "8972697490" , "howler@aol.com"     , "03-10-2000" , "Pune"       ,"27-07-2018" , "65381645" , "AB+", "fractured knee"),
(4 , "Mohamed Emad"    ,"Male"  , "45" , "8199229239" , "chronos@me.com"     , "19-04-1988" , "New Delhi"  ,"27-07-2018" , "65381337" , "O-" , "Mild fever"),
(5 , "Mohamed Ashraf"  ,"Female", "60" , "8339229120" , "sopwith@verizon.net", "10-01-1955" , "Chennai"    ,"27-07-2018" , "65381781" , "B+" , "Vommiting"),
(6 , "Ayman Gaber"     ,"Male"  , "36" , "6309229567" , "murty@outlook.com"  , "08-08-1989" , "Patna"      ,"27-07-2018" , "65381447" , "A-" , "bleeding"),
(7 , "Mohamed Yehia"   ,"Female", "28" , "6409229980" , "fukuchi@aol.com"    , "13-05-1991" , "Gurgav"     ,"27-07-2018" , "65383373" , "AB-", "Ebola"),
(8 , "Akash Agarwal"   ,"Female", "25" , "9999229980" , "fchronos@me.com"    , "25-07-1994" , "Hyderabad"  ,"12-03-2019" , "65388898" , "B-" , "Rabies"),
(9 , "Al Shaymaa Hosni","Male"  , "38" , "8989229980" , "dexter@me.com"      , "11-09-1987" , "Kolkata"    ,"25-09-2019" , "65388360" , "A-" , "West Nile Virus"),
(10, "Lydia Magd"      ,"Female", "48" , "8029229980" , "buchana@att.net"    , "19-05-1986" , "Jaipur"     ,"20-07-2019" , "65381234" , "O-" , "Zika virus");