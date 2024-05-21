
CREATE USER 'proy'@'localhost' IDENTIFIED BY 'password';

CREATE DATABASE reservas_db;

GRANT ALL PRIVILEGES ON reservas_db.* TO 'proy'@'localhost';

USE reservas_db;


