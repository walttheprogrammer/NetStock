package aplicacion_1;
import java.sql.*;
//Esta clase tiene como fin visualizar si existe conexion con el servidor local, y le permite visualizar los distintos errores, en caso existan
/**
 *
 * @author Walter
 */
public class testconexion {
    public static void main(String[] args) {
        System.out.println("--- DIAGNÓSTICO DE CONEXIÓN ---");
        String url1 = "jdbc:sqlserver://localhost;databaseName=NetStockDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        test("OP1: Automática", url1);
        String url2 = "jdbc:sqlserver://localhost;instanceName=SQLEXPRESS;databaseName=NetStockDB;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        test("OP2: Instancia SQLEXPRESS)", url2);
    }
    private static void test(String nombre, String url) {
        System.out.println("\nProbando: " + nombre);
        try (Connection con = DriverManager.getConnection(url)) {
            System.out.println("Conexión establecida.");
            System.out.println("Base de datos: " + con.getCatalog());
        } catch (SQLException e) {
            System.out.println("Error.");
            System.out.println("Excepción: " + e.getMessage());
            if (e.getMessage().contains("integrated authentication")) {
                System.out.println("Falta el archivo 'mssql-jdbc_auth...dll' en System32.");
            } else if (e.getMessage().contains("Cannot open database")) {
                System.out.println("Conectó al servidor, pero NO EXISTE la base de datos 'NetStockDB'. Revise el nombre en SQL.");
            } else if (e.getMessage().contains("TCP/IP")) {
                System.out.println("El servidor está apagado o TCP/IP deshabilitado (Coloque el puerto 1433 en SQL Server Configuration Manager (TCP/IP > Direcciones IP > IPAII).");
            }
        }
    }
}
