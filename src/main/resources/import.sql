INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area) VALUES (1,'forest.newark@gmail.com','forest','newark','admin','9194528196','music');

INSERT INTO parent(id, password, phone_number, preferred_contact_method, primary_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name) VALUES (1,'password123',9194528196,'email','forest.newark@gmail.com','Jim','Smith','forest.newark@gmail.com','Sally','Smith');
INSERT INTO parent(id, password, phone_number, preferred_contact_method, primary_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name) VALUES (2,'password123',9195555555,'email', 'chrisoliver08@live.com','Chris','Mitchell','none','Wife','Mitchell');
INSERT INTO parent(id, password, phone_number, preferred_contact_method, primary_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name) VALUES (3,'password123',9195553255,'email', 'cwolf0913@gmail.com','Chris','Tang','none','none', 'none');

INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (1,'6','Very-Hyper','School Of The Arts','Johnny','Smith',1);
INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (2,'7','Very Bright','School of the Arts','Sean','Mitchell',2);


INSERT INTO message(id, english_message, message_name, spanish_message) VALUES (1,'Hello from Teacher Talk!','helloMessage','Hola de Teacher Talk ');
INSERT INTO message(id, english_message, message_name, spanish_message) VALUES (2,'Your child was absent from class today','Absent','Su hijo estuvo ausente hoy');


INSERT INTO log(id, local_date, message_sent_to, notes, parent_name, student_name, template_sent) VALUES(4, '2/5/2005','ruder','Will','ruder', 'Berry', '4 days ago');
INSERT INTO log(id, local_date, message_sent_to, notes, parent_name, student_name, template_sent) VALUES(1, '4/5/2005','sweetheart','Chris','ruder', 'Miles', '3 days ago');
INSERT INTO log(id, local_date, message_sent_to, notes, parent_name, student_name, template_sent) VALUES(2, '7/5/2005','wanted to sue me','Forest','ruder', 'Chuck', '1 days ago');
INSERT INTO log(id, local_date, message_sent_to, notes, parent_name, student_name, template_sent) VALUES(3, '1/5/2005','very loud','Rasputin','ruder', 'King', '7 days ago');