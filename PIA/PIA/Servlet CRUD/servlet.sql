-- Crear la base de datos
CREATE DATABASE agenda_db;
GO

-- Usar la base de datos
USE agenda_db;
GO

-- Crear la tabla de contactos
CREATE TABLE contactos (
    id INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido_paterno VARCHAR(100) NOT NULL,
    apellido_materno VARCHAR(100) NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    tipo_contacto VARCHAR(50) NOT NULL,
    fecha_registro DATETIME DEFAULT GETDATE()
);
GO

-- Insertar datos de prueba
INSERT INTO contactos (nombre, apellido_paterno, apellido_materno, sexo, telefono, direccion, tipo_contacto) 
VALUES 
('Juan', 'Pérez', 'García', 'M', '8112345678', 'Av. Principal 123', 'CASA'),
('María', 'López', 'Martínez', 'F', '8187654321', 'Calle Secundaria 456', 'TRABAJO');
GO

-- Verificar que se crearon los datos
SELECT * FROM contactos;
GO