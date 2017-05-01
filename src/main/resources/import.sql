INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area) VALUES (1,'forest.newark@gmail.com','forest','newark','admin','9194528196','music');

INSERT INTO parent(id, password, phone_number, preferred_contact_method, primary_email, primary_first_name, primary_last_name, secondary_email, secondary_first_name, secondary_last_name) VALUES (1,'password123',9194528196,'email','parent@gmail.com','Jim','Smith','forest.newark@gmail.com','Sally','Smith');

INSERT INTO student(id, grade, notes, school, student_first_name, student_last_name, parent_id) VALUES (1,'6','Very-Hyper','School Of The Arts','Johnny','Smith',1);

INSERT INTO message(id, english_message, message_name, spanish_message) VALUES (1,'Hello from Teacher Talk!','helloMessage','Hola de Teacher Talk ');