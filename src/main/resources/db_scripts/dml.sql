insert into formclass (grade, year) values ("Grade 5a", 2019);
insert into learner (firstname, lastname, address, dateOfBirth, formClassId) values ("Muhammad", "Laher", "50 Winston Road, Homestead Park, JHB, 2092", "2008-07-21", 1);
insert into parent (firstname, lastname, email, address, phone1) values ("Zaahir", "Laher", "zaahirlaher@gmail.com", "50 Winston Road, Homestead Park, JHB, 2092", "0826908710"); 
insert into parent (firstname, lastname, email, address, phone1) values ("Fatima", "Vanker", "fatimavanker@gmail.com", "50 Winston Road, Homestead Park, JHB, 2092", "0724210398"); 
insert into parentLearnerLink(learnerId, parentId, relationshipToLearner) values (1, 1, "Father");
insert into parentLearnerLink(learnerId, parentId, relationshipToLearner) values (1, 2, "Mother");
INSERT INTO role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');

-- USER
-- non-encrypted password: 123
INSERT INTO user (id, first_name, last_name, password, username) VALUES (1, 'Fatima', 'Vanker', '{bcrypt}$2a$10$a2dz801.hk8z7uVIG9Jwbess3DwAE0AmlJnfLNxhzLew.4o/Ond8.', 'fatimavanker@gmail.com');


INSERT INTO user_role_link (user_id, role_id) VALUES(1,1);