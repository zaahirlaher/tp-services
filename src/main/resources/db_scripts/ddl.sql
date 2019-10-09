-- drop table parentLearnerLink;
-- drop table learner;
-- drop table formclass;
-- drop table parent;
-- drop table user_role_link;
-- drop table user;
-- drop table role;


create table formclass (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    grade VARCHAR(30) NOT NULL,
    year INT(4) NOT NULL
);

create table formclass_teacher_link (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    formClassId INT(10) NOT NULL,
    teacherId bigint(20) NOT NULL,
    FOREIGN KEY (formClassId) REFERENCES formclass(id),
    FOREIGN KEY (teacherId) REFERENCES user(id)
);

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


create table parentLearnerLink (
    id INT(10) AUTO_INCREMENT PRIMARY KEY,
    learnerId INT(10) NOT NULL,
    parentId INT(10) NOT NULL,
    relationshipToLearner VARCHAR(30) NOT NULL,
    FOREIGN KEY (learnerId) REFERENCES learner(id),
    FOREIGN KEY (parentId) REFERENCES parent(id)
);

CREATE TABLE role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  username varchar(255) NOT NULL UNIQUE,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user_role_link (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  CONSTRAINT FK859n2jvi8ivhui0rl0esws6o FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES role (id)
);
