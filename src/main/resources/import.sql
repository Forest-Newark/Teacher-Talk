

-- TEACHER INSERT
INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area,school_name) VALUES (1,'forest.newark@gmail.com','forest','newark','admin','9194528196','Music','SCS');
INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area,school_name) VALUES (2,'chris.tang0913@gmail.com','chris','tang','helloworld','9194528873','Photography','DSA');
INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area,school_name) VALUES (3,'lyndsey.r.mitchel@gmail.com','lyndsey','mitchel','TeacherTalk','9194528873','History','SCS');

--PARENT INSERT
INSERT INTO parent(id, password, phone_number, preferred_contact_method, preferred_language, primay_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name) VALUES (1,'password1','3222342333','email','english','simmons@gmail.com','bob','simmons','joe@gmail.com', 'jess', 'simmons');
INSERT INTO parent(id, password, phone_number, preferred_contact_method, preferred_language, primay_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name) VALUES (2,'password2','2323223333','email','english','hudson@gmail.com','greg','hudson','hudson@gmail.com', 'kat', 'hudson');


--STUDENT INSERT
INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (1,'6','very-hyper','DSA','Joel','Simmons',1);
INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (2,'9','fast learner','DSA','Fionna','Simmons',1);
INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (3,'12','loves computers','DSA','Spencer','Simmons',1);
INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (4,'7','reads at a high level','SCS','Robert','Hudson',2);
INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (5,'11','needs extra supervision','SCS','Finn','Hudson',2);


--MESSAGE TEMPLATES
INSERT INTO message(id, english_message, message_name) VALUES (1,'This message is to inform you that your student was absent from class today. While I will assist your student with the content they missed, it is their responsibility to make up any missing work. If you have any questions or concerns please feel to contact me at your earliest convenience.','Absent Message');
INSERT INTO message(id, english_message, message_name) VALUES (2,'This message is to inform you that your student was late to class today without a note from another teacher or administrator. With limited classroom time it is important that students are on time to receive all the information they need in order to be successful.','Late Message');
INSERT INTO message(id, english_message, message_name) VALUES (3,'I just wanted to take a moment to let you know your student is doing an amazing job in class. They stand out among their peers and I wanted to recognize their hard work. You should be proud of them and continue to encourage them in this direction!','Positive Message');
INSERT INTO message(id, english_message, message_name) VALUES (4,'This message is to inform you that your student was a minor discipline problem during class time today. While I do not feel their actions warrant additional disciplinary procedures, I would ask that you speak to your student regarding their behavior.  Continued behavioral problems during class could result in additional disciplinary procedures following the school''s policies and procedures. If you have any questions or concerns about this please feel to contact me at your earliest convenience.','Minor Discipline Problem Message');
INSERT INTO message(id, english_message, message_name) VALUES (5,'This message is to inform you that I had to confiscate an item from your student during the school day.  Following school procedures, I have turned the item into the main office for pickup. If you have any questions or concerns about this please feel to contact me at your earliest convenience.','Confiscation of Item Message');
INSERT INTO message(id, english_message, message_name) VALUES (6,'This message is to inform you that your student currently has missing assignments in my class. They have the opportunity to complete missing work in accordance with my late work policy. If you have any questions or concerns about this please feel to contact me at your earliest convenience.','Missing work Message');


-- LOG INSERT
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (1,now(),'Forest Newark','Suzie Johnson','Bill Johnson','Minor Discipline Problem Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (2,now(),'Lyndsey Mitchel','Nathan Poling','Cole Poling','Absent Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (3,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Late Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (4,now(),'Jane Emmeth','Joe Hudson','Robert Hudson','Missing Work Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (5,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Minor Discipline Problem Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (6,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Late Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (7,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Absent Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (8,now(),'Lyndsey Mitchel','Joe Hudson','Robert Hudson','Late Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (9,now(),'Jane Emmeth','Joe Hudson','Finn Hudson','Late Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (10,now(),'Curtis Brown','Elijah Simmons','Fionna Simmons','Positive Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (11,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Absent Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (12,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Late Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (13,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Missing Work Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (14,now(),'Curtis Brown','Elijah Simmons','Joel Simmons','Absent Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (15,now(),'Jane Emmeth','Joe Hudson','Finn Hudson','Missing Work Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (16,now(),'Jane Emmeth','Joe Hudson','Finn Hudson','Late Message');


SELECT setval('hibernate_sequence',100);