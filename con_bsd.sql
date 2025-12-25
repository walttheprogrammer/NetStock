PRINT 'NetStock Server - NetStockDB - Diciembre, 2025'
USE master;
GO
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'NetStockDB')
BEGIN
    CREATE DATABASE [NetStockDB];
    PRINT 'NetStockDB ha sido creada exitosamente.';
END
ELSE
BEGIN
    PRINT 'NetStockDB existe. Conectando...';
END
GO

USE NetStockDB;
GO

--Creamos un usuario y su clave maestra
USE master;
GO

IF EXISTS (SELECT * FROM sys.server_principals WHERE name = 'admin')
BEGIN
    DROP LOGIN [admin];
END
GO

CREATE LOGIN [admin] 
    WITH PASSWORD = 'tu_contraseña',
	CHECK_POLICY = OFF;
GO

GO
USE NetStockDB;
GO

IF EXISTS (SELECT * FROM sys.database_principals WHERE name = 'admin')
BEGIN
    DROP USER [admin];
END
GO

CREATE USER [admin] 
    FOR LOGIN [admin];
GO

ALTER ROLE db_owner ADD MEMBER [admin];
GO
PRINT 'Usuario maestro configurado exitosamente.';

--Crearemos las tablas correspondientes, y si existen, las sobreescribiremos
IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'Usuarios') AND type in (N'U'))
DROP TABLE Usuarios
GO
CREATE TABLE Usuarios (       --Cuentas de usuario y sus respectivas contraseñas
ID int IDENTITY(1,1) PRIMARY KEY,
Usuario varchar(50) NOT NULL UNIQUE,
[Password] varchar(50) NOT NULL
);
GO
PRINT 'Tabla Usuarios creada con éxito.' 

SET NOCOUNT ON;
INSERT INTO Usuarios (Usuario, [Password]) VALUES ('admin1945', 'Admin@64');   --Cuentas predeterminadas para cada usuario registrado
INSERT INTO Usuarios (Usuario, [Password]) VALUES ('juanrodriguez', 'Pr1n31P41');   --Estas cuentas son totalmente modificables
INSERT INTO Usuarios (Usuario, [Password]) VALUES ('PradaLIM', 'S3CUnD4R10');   --Cada una tiene acceso privilegiado al iniciar sesión
INSERT INTO Usuarios (Usuario, [Password]) VALUES ('Ocampo3421', '94@SJMSMP%');
INSERT INTO Usuarios (Usuario, [Password]) VALUES ('LKSánchez156', '19c0Ntr4SEN495');
PRINT 'Cuentas creadas correctamente.'
GO
PRINT 'Usuarios ingresados correctamente.'

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'Productos') AND type in (N'U'))
DROP TABLE Productos
GO
CREATE TABLE Productos (      --Productos de la bodega destinada
ID int IDENTITY(1,1) PRIMARY KEY,
Nombre varchar(255) NOT NULL UNIQUE,
Precio decimal(10,2) NOT NULL,
Stock int NOT NULL,
Fecha varchar(255) NULL
);
GO
PRINT 'Tabla Productos creada correctamente.'

IF EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'Fiados') AND type in (N'U'))
DROP TABLE Fiados
GO
CREATE TABLE Fiados (          --Clientes fiados (cuentas por cobrar)
ID int IDENTITY(1,1) PRIMARY KEY,
Cliente varchar(255),
Producto varchar(255),
Monto decimal(10,2),
Fecha varchar(255)
);
GO
PRINT 'Tabla Fiados creada correctamente.'