

-- TEACHER INSERT
INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area) VALUES (1,'forest.newark@gmail.com','forest','newark','admin','9194528196','music');

--PARENT INSERT

--STUDENT INSERT

--MESSAGE TEMPLATES

-- LOG INSERT
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES (1,CURRRENT_TIMESTAMP,'','Suzie Johnson','Bill Johnson','Minor Discipline');
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES (1,CURRRENT_TIMESTAMP,'','Nathan Poling','Cole Poling','Absent');
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES (1,CURRRENT_TIMESTAMP,'','Elijah Ellis','Niki Ellis','Late');
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES (1,CURRRENT_TIMESTAMP,'','Joe Smith','John Smith','Missing Work');
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES (1,CURRRENT_TIMESTAMP,'','Jason Bourne','Sarah Bourne','Positive Message');

