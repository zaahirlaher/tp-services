drop table parentLearnerLink;
drop table learner;
drop table formclass;
drop table parent;

create table formclass (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    grade VARCHAR(30) NOT NULL,
    year INT(4) NOT NULL
);
insert into formclass (grade, year) values ("Grade 5a", 2019);

create table parent (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    middlename  VARCHAR(30),
    email VARCHAR(50),
    address VARCHAR(200) NOT NULL,
    phone1 VARCHAR(20)  NOT NULL,
    phone2 VARCHAR(20)
);
insert into parent (firstname, lastname, email, address, phone1) values ("Zaahir", "Laher", "zaahirlaher@gmail.com", "50 Winston Road, Homestead Park, JHB, 2092", "0826908710"); 
insert into parent (firstname, lastname, email, address, phone1) values ("Fatima", "Vanker", "fatimavanker@gmail.com", "50 Winston Road, Homestead Park, JHB, 2092", "0724210398"); 

create table learner (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    middlename  VARCHAR(30),
    email VARCHAR(50),
    address VARCHAR(200) NOT NULL,
    phone VARCHAR(20),
    dateOfBirth DATE,
    formClassId INT(10) NOT NULL,
    FOREIGN KEY (formClassId) REFERENCES formclass(id)
);
insert into learner (firstname, lastname, address, dateOfBirth, formClassId) values ("Muhammad", "Laher", "50 Winston Road, Homestead Park, JHB, 2092", "2008-07-21", 1);


create table parentLearnerLink (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    learnerId INT(10) NOT NULL,
    parentId INT(10) NOT NULL,
    relationshipToLearner VARCHAR(30) NOT NULL,
    FOREIGN KEY (learnerId) REFERENCES learner(id),
    FOREIGN KEY (parentId) REFERENCES parent(id)
);
insert into parentLearnerLink(learnerId, parentId, relationshipToLearner) values (1, 1, "Father");
insert into parentLearnerLink(learnerId, parentId, relationshipToLearner) values (1, 2, "Mother");