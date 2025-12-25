# NetStock
Sistema de gestión de inventarios para bodegas locales. Implementa administración de ventas, manejo de precios, control de stock y un listado de clientes fiados (cuentas por cobrar), además de tener una interfaz (UX) personalizable a las preferencias del usuario. Se desarrolló originalmente para una bodega local ubicada en Los Olivos, de nombre "El Olivar".
> **Autor:** Walter Dario Maza Cuadrado
> **Versión:** 1.7.12 (Release Candidate)
> **Fecha: *21 de Diciembre de 2025*

## Características principales
Este sistema se denomina **NetStock**, el cual cuenta con módulos robustos para la administración del negocio:
* ** Gestión de inventario (CRUD):** Control total de productos (Crear, Leer, Actualizar, Eliminar).
* ** Niveles de Stock:** Algoritmo que clasifica el estado del stock en tiempo real, de forma automática (Puede variar dependiendo de los productos):
    * 🟢 **Óptima** -> Cantidad ideal para operar sin riesgo de desabastecimiento del producto.
    * 🟡 **Aceptable** -> Cantidad promedio o moderada, suficiente para la demanda habitual del producto.
    * 🔴 **Baja** -> Cantidad crítica, insuficiente para la demanda habitual del producto.
* ** Módulo de clientes fiados:** Registro y eliminación de deudas (cuentas por cobrar) por cliente, fecha y monto. 
* ** Seguridad:** Incorpora un sistema de Login con validación contra base de datos y usuario de respaldo en memoria por si no es posible conectar con la base de datos.
* ** Inicialización Automática:** El sistema detecta la base de datos y precarga automáticamente 27 productos básicos (Arroz, Azúcar, Aceite, etc.) para facilitar el inicio.

## Tecnologías implementadas
* **Lenguajes de programación:** Java (JDK 21 LTS), SQL (T-SQL)
* **Base de datos:** Microsoft SQL Server 2019/2022
* **Librerías:** Swing (JFrame), JDBC (Conectividad)
* **Herramientas:** NetBeans / IntelliJ IDEA / Git / SSMS

## Instrucciones 
Sigue estos pasos para ejecutar el proyecto en tu entorno local de forma correcta y totalmente funcional:

### 1. Configuración de Conexión
Por seguridad, las credenciales del servidor se deben configurar manualmente:
- Navega a: `src/aplicacion_1/bsd_usuarios.java`
- Busca el método `conexion()` y actualiza las variables con tu usuario local:
    ```java
    String user = "admin"; // Tu usuario de SQL Server
    String key = "TU_CONTRASEÑA"; // Tu contraseña
    ```
### 2. Modificar la base de datos
- Copie y pegue los archivos `mssql-jdbc_auth-13.2.1.x64.dll` y `mssql-jdbc_auth-13.2.1.x86.dll` desde la carpeta `librerias` a la carpeta `C:\Windows\System32`.
- Ubique el archivo `con_bsd.sql` que se encuentra en la raíz del repositorio y ábralo en SQL Server Management Studio (Preferible versión 20).
- Modifique el usuario `[admin]` y su clave maestra `[contraseña]` para permitir la comunicación entre la base de datos y el software. Deben ser los mismos que en el método `conexion()`:
  ```sql
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
  ```
- Ejecute el script (F5). Asegúrese de haberse conectado a su servidor local (Windows Authentication).

### 3. Configuración de la conectividad con TCP/IP
- Presione Windows, escriba Administrador de configuración de SQL Server y ábralo.
- Navegue a Configuración de red de SQL Server > Protocolos de `[Instancia]` > TCP/IP
- Al entrar a TCP/IP, seleccione el panel Direcciones IP
- Busque IPAll y cambie el Puerto TCP a 1433.
- Reinicie el servicio (Servicios de SQL Server > SQL Server (`[Instancia]`) > Reiniciar)
  
### 3. Ejecución
Compila y ejecuta el archivo `Inicio_1.java` (Login) para arrancar la aplicación.

> **Notas para Testing:**
> Si la base de datos no tiene usuarios creados, el sistema generará automáticamente un usuario administrador `admin` y su contraseña `1234` por defecto:
> La integridad y lógica del negocio (Stored Procedures y Funciones) se gestionan mediante la ejecución del script adjunto. No se requiere software de migración externo; basta con ejecutar el script con_bsd.sql en SQL Server Management Studio (SSMS).

## Estructura principal del proyecto
* `src/aplicacion_1/`: Código fuente y su lógica dentro del negocio. Incluye comentarios.
    * `bsd_inventario.java`: Lógica del inventario y conexión JDB con la base de datos.
    * `bsd_usuarios.java`: Gestión de accesos y seguridad privilegiados.
    * `JF_*.java`: Formularios para la administración del negocio (Ventas, Fiados, Precios, Stock).
    * `Inicio_*.java`: Formularios con propósitos generales.
* `con_bsd.sql`: Script para generar la base de datos.
* `librerias/`: Librerías y drivers JDBC (DLLs de autenticación incluidas).
  
---
Copyright (c) 2025 Waltz Systems.
Proyecto de portafolio profesional.
