CREATE DATABASE IF NOT EXISTS quizdb;

-- 25 questions as before
INSERT INTO question (id, text) VALUES (1, 'What does HTML stand for?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('HyperText Markup Language', true, 1),
('HighText Markdown Language', false, 1),
('HyperTransfer Markup Language', false, 1),
('HyperText Make Language', false, 1);

INSERT INTO question (id, text) VALUES (2, 'Which CSS property changes text color?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('color', true, 2),
('font-color', false, 2),
('text-color', false, 2),
('foreground', false, 2);

INSERT INTO question (id, text) VALUES (3, 'Which HTTP method is idempotent?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('GET', true, 3),
('POST', false, 3),
('PATCH', false, 3),
('CONNECT', false, 3);

INSERT INTO question (id, text) VALUES (4, 'Which tag is used to link an external CSS file?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('<link>', true, 4),
('<style>', false, 4),
('<css>', false, 4),
('<src>', false, 4);

INSERT INTO question (id, text) VALUES (5, 'Which unit is relative to the root font-size in CSS?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('rem', true, 5),
('em', false, 5),
('px', false, 5),
('%', false, 5);

INSERT INTO question (id, text) VALUES (6, 'Which HTML element is semantic for navigation links?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('<nav>', true, 6),
('<section>', false, 6),
('<article>', false, 6),
('<aside>', false, 6);

INSERT INTO question (id, text) VALUES (7, 'Which status code means “Not Found”?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('404', true, 7),
('400', false, 7),
('401', false, 7),
('403', false, 7);

INSERT INTO question (id, text) VALUES (8, 'Which of these is a JavaScript primitive type?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('string', true, 8),
('Date', false, 8),
('Array', false, 8),
('Map', false, 8);

INSERT INTO question (id, text) VALUES (9, 'Which attribute is used in forms to link label and input?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('for', true, 9),
('link', false, 9),
('name', false, 9),
('bind', false, 9);

INSERT INTO question (id, text) VALUES (10, 'What does SQL stand for?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('Structured Query Language', true, 10),
('Simple Query Language', false, 10),
('Sequential Query Language', false, 10),
('Server Query Language', false, 10);

INSERT INTO question (id, text) VALUES (11, 'Which SQL clause filters rows after aggregation?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('HAVING', true, 11),
('WHERE', false, 11),
('GROUP BY', false, 11),
('ORDER BY', false, 11);

INSERT INTO question (id, text) VALUES (12, 'Which HTTP header is used for JSON content?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('Content-Type: application/json', true, 12),
('Accept-Language: json', false, 12),
('Cache-Control: json', false, 12),
('Type: json', false, 12);

INSERT INTO question (id, text) VALUES (13, 'In React, which hook manages state in a function component?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('useState', true, 13),
('useMemo', false, 13),
('useRef', false, 13),
('useLayoutEffect', false, 13);

INSERT INTO question (id, text) VALUES (14, 'Which JDBC URL prefix is correct for MySQL?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('jdbc:mysql://', true, 14),
('jdbc:postgres://', false, 14),
('jdbc:oracle://', false, 14),
('jdbc:maria://', false, 14);

INSERT INTO question (id, text) VALUES (15, 'Which Spring annotation creates a REST controller?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('@RestController', true, 15),
('@Controller', false, 15),
('@Service', false, 15),
('@Repository', false, 15);

INSERT INTO question (id, text) VALUES (16, 'Which Spring annotation maps HTTP GET?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('@GetMapping', true, 16),
('@PostMapping', false, 16),
('@PutMapping', false, 16),
('@PatchMapping', false, 16);

INSERT INTO question (id, text) VALUES (17, 'Which normalization form removes partial dependencies?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('2NF', true, 17),
('1NF', false, 17),
('3NF', false, 17),
('BCNF', false, 17);

INSERT INTO question (id, text) VALUES (18, 'Which CSS layout enables two-dimensional grid positioning?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('CSS Grid', true, 18),
('Flexbox', false, 18),
('Float', false, 18),
('Inline-block', false, 18);

INSERT INTO question (id, text) VALUES (19, 'Which MySQL constraint enforces uniqueness (allowing NULLs)?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('UNIQUE', true, 19),
('PRIMARY KEY', false, 19),
('FOREIGN KEY', false, 19),
('CHECK', false, 19);

INSERT INTO question (id, text) VALUES (20, 'What does CORS stand for?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('Cross-Origin Resource Sharing', true, 20),
('Cross-Origin Request Service', false, 20),
('Client-Origin Resource Sharing', false, 20),
('Cross-Object Resource Support', false, 20);

INSERT INTO question (id, text) VALUES (21, 'What is the default HTTP port?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('80', true, 21),
('8080', false, 21),
('21', false, 21),
('25', false, 21);

INSERT INTO question (id, text) VALUES (22, 'Which React prop is required when rendering lists?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('key', true, 22),
('id', false, 22),
('name', false, 22),
('index', false, 22);

INSERT INTO question (id, text) VALUES (23, 'Which SQL JOIN returns only matching rows in both tables?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('INNER JOIN', true, 23),
('LEFT JOIN', false, 23),
('RIGHT JOIN', false, 23),
('FULL OUTER JOIN', false, 23);

INSERT INTO question (id, text) VALUES (24, 'Which HTTP status means “Created”?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('201', true, 24),
('202', false, 24),
('200', false, 24),
('204', false, 24);

INSERT INTO question (id, text) VALUES (25, 'Which Spring Data interface gives CRUD methods?');
INSERT INTO option_choice (text, correct, question_id) VALUES
('JpaRepository', true, 25),
('JdbcTemplate', false, 25),
('CrudTemplate', false, 25),
('EntityManager', false, 25);option_choice
