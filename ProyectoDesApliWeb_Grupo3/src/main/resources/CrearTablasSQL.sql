DROP SCHEMA IF EXISTS hotel;
DROP USER IF EXISTS usuario_hotel;

-- Crear la base de datos
CREATE SCHEMA hotel;

-- Crear el usuario y otorgarle permisos
CREATE USER 'usuario_hotel'@'%' IDENTIFIED BY 'Hotel_Clave1';
GRANT ALL PRIVILEGES ON hotel.* TO 'usuario_hotel'@'%';
FLUSH PRIVILEGES; -- Corregido: sin caracteres adicionales

-- Seleccionar la base de datos
USE hotel;

-- Crear tabla Usuario
CREATE TABLE usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellidos VARCHAR(100) NOT NULL,
    Correo VARCHAR(100) UNIQUE NOT NULL,
    ContrasenaUsuario VARCHAR(255) NOT NULL
);

-- Crear tabla Habitacion
CREATE TABLE habitacion (
    idHabitacion INT AUTO_INCREMENT PRIMARY KEY,
    Disponibilidad BOOLEAN NOT NULL DEFAULT TRUE
);

-- Crear tabla Reservas
CREATE TABLE reservas (
idReserva INT AUTO_INCREMENT PRIMARY KEY,
idUsuario INT NOT NULL,
idHabitacion INT NOT NULL,
activa BOOLEAN NOT NULL DEFAULT TRUE,
fecha VARCHAR(100) NOT NULL,
categoriaHabitacion ENUM('Suite', 'Estandar', 'Premium') NOT NULL,
FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario) ON DELETE CASCADE,
FOREIGN KEY (idHabitacion) REFERENCES habitacion(idHabitacion) ON DELETE CASCADE
);

-- Insertar datos de ejemplo en Usuario
INSERT INTO usuario (Nombre, Apellidos, Correo, ContrasenaUsuario) VALUES
('Juan', 'Perez', 'juan.perez@example.com', 'hashed_password_1'),
('Maria', 'Gomez', 'maria.gomez@example.com', 'hashed_password_2');

-- Insertar datos de ejemplo en Habitacion
INSERT INTO habitacion (Disponibilidad) VALUES
(TRUE),
(TRUE),
(FALSE);

-- Insertar datos de ejemplo en Reservas
INSERT INTO reservas (idReserva, idUsuario, idHabitacion, activa, fecha, categoriaHabitacion) VALUES
(1, 1, 1, TRUE, '2025-03-10', 'Suite'),
(2, 2, 2, FALSE, '2025-03-12', 'Estandar');