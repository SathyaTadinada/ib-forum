DROP TABLE IF EXISTS users;

CREATE TABLE users (
    users_id INT AUTO_INCREMENT,
    first_name VARCHAR(35) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(200) NOT NULL,
    phone VARCHAR(30) NOT NULL,
    username VARCHAR(30) NOT NULL,
    password_hash VARCHAR(100) NOT NULL,
    salt VARCHAR(100) NOT NULL
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


