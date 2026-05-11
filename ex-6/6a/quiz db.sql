CREATE DATABASE quizdb;
USE quizdb;

CREATE TABLE users (
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO users VALUES ('student1', '123');

CREATE TABLE questions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    question VARCHAR(255),
    option1 VARCHAR(100),
    option2 VARCHAR(100),
    option3 VARCHAR(100),
    option4 VARCHAR(100),
    answer VARCHAR(100)
);

INSERT INTO questions (question, option1, option2, option3, option4, answer) VALUES
('Java is?', 'Language', 'OS', 'Browser', 'Database', 'Language'),
('HTML stands for?', 'Hyper Text Markup Language', 'High Text', 'Hyper Tab', 'None', 'Hyper Text Markup Language');

