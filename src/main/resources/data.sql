-- INSERT INTO countries (id, name) VALUES (1, 'USA');
-- INSERT INTO countries (id, name) VALUES (2, 'France');
-- INSERT INTO countries (id, name) VALUES (3, 'Brazil');
-- INSERT INTO countries (id, name) VALUES (4, 'Italy');
-- INSERT INTO countries (id, name) VALUES (5, 'Canada');
CREATE TABLE person (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  age INT
);


CREATE TABLE bookSave (
  id INT AUTO_INCREMENT PRIMARY KEY,
  isbn VARCHAR(255),
  name VARCHAR(255),
  author VARCHAR(255)
);
