DROP TABLE IF EXISTS users;

CREATE TABLE users (
    users_id INT AUTO_INCREMENT,
    first_name VARCHAR(35) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(200) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    username VARCHAR(30) NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    salt VARCHAR(100) NOT NULL,
    deleted BIT DEFAULT 0 NOT NULL,
    user_type INT NOT NULL
);

CREATE UNIQUE INDEX U_users_email ON users
(
    email
);
CREATE UNIQUE INDEX U_users_username ON users
(
    username
);


DROP TABLE IF EXISTS category;

CREATE TABLE category(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(35) NOT NULL,
    archived BIT DEFAULT 0 NOT NULL,
    school_year VARCHAR(9) NOT NULL
);

CREATE UNIQUE INDEX U_category_name_school_year ON category
(
    name, school_year
);

DROP TABLE IF EXISTS question;

CREATE TABLE question(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    text VARCHAR(200) NOT NULL,
    date TIMESTAMP NOT NULL,
    anonymous BIT DEFAULT 0 NOT NULL,
    approved_by INT,
    likes INT DEFAULT 0 NOT NULL

);

DROP TABLE IF EXISTS user_type;

CREATE TABLE user_type(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX U_user_type_name ON user_type
(
    name
);



DROP TABLE IF EXISTS response;

CREATE TABLE response(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    question_id INT NOT NULL,
    text VARCHAR(200) NOT NULL,
    date TIMESTAMP NOT NULL,
    anonymous BIT DEFAULT 0 NOT NULL,
    approved_by INT,
    likes INT DEFAULT 0 NOT NULL

);


DROP TABLE IF EXISTS question_category;

CREATE TABLE question_category(
    question_id INT NOT NULL,
    category_id INT NOT NULL

);
ALTER TABLE question_category
    ADD FOREIGN KEY(question_id)
    REFERENCES question(id);

ALTER TABLE question_category
    ADD FOREIGN KEY(category_id)
    REFERENCES category(id);


DROP TABLE IF EXISTS question_likes;
CREATE TABLE question_likes(
    question_id INT NOT NULL,
    user_id INT NOT NULL
);
ALTER TABLE question_likes
    ADD FOREIGN KEY(question_id)
    REFERENCES question(id);

ALTER TABLE question_likes
    ADD FOREIGN KEY(user_id)
    REFERENCES category(id);




ALTER TABLE users
    ADD FOREIGN KEY(user_type)
    REFERENCES user_type(id);

ALTER TABLE question
    ADD FOREIGN KEY(user_id)
    REFERENCES users(users_id);

ALTER TABLE response
    ADD FOREIGN KEY(user_id)
    REFERENCES users(users_id);

ALTER TABLE response
    ADD FOREIGN KEY(question_id)
    REFERENCES users(users_id);



INSERT INTO user_type (name) VALUES
  ('Admin'),
  ('Student'),
  ('Parent');