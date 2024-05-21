CREATE TABLE reservas_db.reserva (
                                     id  bigint(20) NOT NULL AUTO_INCREMENT,
                                     nombre varchar(255) DEFAULT '',
                                     turno varchar(255) DEFAULT '',
                                     numComensales int DEFAULT 0,
                                     fecha varchar(255) DEFAULT '',
                                     numeroTelefono int DEFAULT 0,
                                     PRIMARY KEY (id)
);