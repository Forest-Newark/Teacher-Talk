INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area) VALUES (1,'forest.newark@gmail.com','forest','newark','admin','9194528196','music');

INSERT INTO parent(id, password, phone_number, preferred_contact_method, primary_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name,preferred_language) VALUES (1,'password123',9194528196,'email','forest.newark@gmail.com','Jim','Smith','forest.newark@gmail.com','Sally','Smith','english');
INSERT INTO parent(id, password, phone_number, preferred_contact_method, primary_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name,preferred_language) VALUES (2,'password123',9195555555,'email', 'forestjavadev@gmail.com','Chris','Mitchell','none','Wife','Mitchell','spanish');


INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (1,'6','Very-Hyper','School Of The Arts','Johnny','Smith',1);
INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (2,'7','Very Bright','School of the Arts','Sean','Mitchell',2);


INSERT INTO message(id, english_message, message_name) VALUES (1,'Hello from Teacher Talk!','helloMessage');
INSERT INTO message(id, english_message, message_name) VALUES (2,'This message is to inform you that your child was absent from class today. While I will assist your student with the content they missed, it is their responsibility to make up all missing work.','Absent Message');


INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES(4, CURRENT_TIMESTAMP, 'student was abrasive','Will', 'Berry', '4 days ago');
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES(1, CURRENT_TIMESTAMP, 'student might have lice','Chris', 'Miles', '3 days ago');
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES(2, CURRENT_TIMESTAMP, 'student read exceptional well','Forest', 'Chuck', '1 days ago');
INSERT INTO log(id, created, notes, parent_name, student_name, template_sent) VALUES(3, CURRENT_TIMESTAMP, 'consider moving student to honors','Rasputin', 'King', '7 days ago');