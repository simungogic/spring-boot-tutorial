DROP USER IF EXISTS 'springstudent'@'localhost';

CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

GRANT ALL PRIVILEGES ON *.* TO 'springstudent'@'localhost';

