

-- TEACHER INSERT
INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area) VALUES (1,'forest.newark@gmail.com','forest','newark','admin','9194528196','music');
INSERT INTO teacher(id, email, first_name, last_name, password, phone_number, subject_area) VALUES (2,'chris.tang0913@gmail.com','chris','tang','helloworld','9194528873','photography');


--PARENT INSERT

--STUDENT INSERT

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
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (3,now(),'John Doe','Elijah Ellis','Niki Ellis','Late Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (4,now(),'Jane Emmeth','Joe Smith','John Smith','Missing Work Message');
INSERT INTO log(id, created, sent_by, parent_name, student_name, template_sent) VALUES (5,now(),'Curtis Brown','Jason Bourne','Sarah Bourne','Positive Message');


