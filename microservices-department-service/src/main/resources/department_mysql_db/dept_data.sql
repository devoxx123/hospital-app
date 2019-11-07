DELETE FROM department_tbl;

INSERT INTO `department_tbl` (`id`,`dept_Id`,`dept_name`,`dept_incharge_name`,`dept_staff`,`dept_floor`,`dept_description`) VALUES
(1 ,  "63634676" ,  "General Physician","RupakDas","5","2th floor","treats acute and chronic illnesses"),
(2 ,  "63634677" ,  "ENT Specialist"  ,   "Gnana Haokip"  , "4" , "5th floor"  , "manage and treat disorders of the head and neck"),
(3 ,  "63634678" ,  "Cardiologist"    ,   "Dana Lepcha"   , "3" , "3th floor"  , "diagnosing and treating diseases"),
(4 ,  "63634679" ,  "Neurologist"     ,   "Akash Saxena"  , "6" , "4th floor"  , "treat disorders that affect the brain, spinal cord,nerves"),
(5 ,  "63634680" ,  "Child Specialist",   "Sudha Bharti"  , "1" , "8th floor"  , "health care settings to help infants, children, adolescents"),
(6 ,  "63634681" ,  "Pathologist"     ,   "Byomkesh Dutt" , "2" , "5th floor"  , "laboratory tests on body fluids, such as blood"),
(7 ,  "63634682" ,  "Dermatologist"   ,   "Tara Sarkar"   , "3" , "6th floor"  , "treating conditions of the skin"),
(8 ,  "63634684" ,  "Surgeon"         ,   "Chateerjee"    , "1" , "1th floor"  , "diagnose and treat injuries or illnesses"),
(9 ,  "63634685" ,  "Gynaecologist"   ,   "Ajay Yadav"    , "5" , "10th floor" , "related to pregnancy or childbirth and those who diagnose"),
(10,  "63634669"  , "Gastroenterologist", "Neha Gupta"   , "5" , "9th floor"  , "diagnosis and treatment of disorders of the digestive system");




INSERT INTO `billing_tbl`(`id`,`bill_number`,`patient_type`,`doctor_charge`,`medicine_charge`,`room_charge`,`no_of_days`,`nursing_charge`,`advance_charge`,`payment_mode`,`payment_mode_details`,`lab_charge`,`billing_date`)
VALUES 
(1 ,  "02935489" ,  "Brain Tumors" ,    "500" ,  "1500" ,  "500" ,  "4" ,  "200" ,  "1000" ,  "By Cash"  ,  "Payment not done" ,  "100" , "2019-09-18 12:04:54"),
(2 ,  "71475375" ,  "Adenovirus" ,      "700" ,  "2000" ,  "250" ,  "3" ,  "550" ,  "1500" ,  "By Check" ,  "Server Issue"     ,  "200" , "2019-10-20 10:45:18"),
(3 ,  "83253123" ,  "Jaundice" ,        "1000",  "1200" ,  "350" ,  "5" ,  "400" ,  "2000" ,  "Transfer" ,  "Payment done"     ,  "150" , "2019-08-10 19:58:21"),
(4 ,  "51704987" ,  "Allergy" ,         "300" ,  "3000" ,  "600" ,  "1" ,  "300" ,  "2500" ,  "PhonePay" ,  "Payment not done" ,  "300" , "2019-12-08 08:35:11"),
(5 ,  "18535022" ,  "Flu(Influenza)" ,  "400" ,  "2500" ,  "350" ,  "4" ,  "800" ,  "3000" ,  "GPay"     ,  "Payment done"     ,  "500" , "2019-07-30 03:10:09"),
(6 ,  "60077551" ,  "Appendicitis" ,    "600" ,  "1500" ,  "700" ,  "8" ,  "200" ,  "1000" ,  "By Cash"  ,  "Payment not done" ,  "150" , "2019-06-25 08:25:16"),
(7 ,  "40065885" ,  "Crohn's Disease" , "450" ,  "900"  ,  "560" ,  "6" ,  "550" ,  "1500" ,  "PhonePay" ,  "Payment done"     ,  "250" , "2019-02-28 11:45:28"),
(8 ,  "11655114" ,  "Schizophrenia" ,   "350" ,  "1700" ,  "900" ,  "2" ,  "400" ,  "2000" ,  "By Check" ,  "Server Issue"     ,  "300" , "2019-11-19 10:30:56"),
(9 ,  "33174507" ,  "Arthritis" ,       "250" ,  "1800" ,  "560" ,  "1" ,  "350" ,  "2500" ,  "Transfer" ,  "Payment not done" ,  "100" , "2019-09-20 09:20:45"),
(10,  "12971632" ,  "Ovarian Cancer" ,  "550" ,  "1050" ,  "750" ,  "5" ,  "450" ,  "3000" ,  "GPay"     ,  "Payment done"     ,  "200" , "2019-05-30 12:18:30");

