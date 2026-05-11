CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE marks (
    roll_no INT,
    subject VARCHAR(50),
    marks INT,
    FOREIGN KEY (roll_no) REFERENCES students(roll_no)
);

INSERT INTO students VALUES (101, 'John', '123');

INSERT INTO marks VALUES (101, 'Maths', 85);
INSERT INTO marks VALUES (101, 'Science', 90);
INSERT INTO marks VALUES (101, 'English', 88);

-- Step 3: Fetch Student Details using JOIN
-- Use SQL JOIN to combine student + marks
-- SELECT s.name, s.roll_no, m.subject, m.marks
-- FROM students s
-- JOIN marks m ON s.roll_no = m.roll_no
-- WHERE s.roll_no = ?