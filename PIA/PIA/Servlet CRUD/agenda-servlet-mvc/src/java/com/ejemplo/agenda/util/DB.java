
package com.ejemplo.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos SQL Server
 */
public class DB {
    // Configuración para SQL Server Express con Autenticación de Windows
    private static final String SERVER = "DIEGOG4RZ4\\\\SQLEXPRESS";
    private static final String PORT = "1433"; // Puerto por defecto
    private static final String DATABASE = "agenda_db";
    private static final String URL = "jdbc:sqlserver://" + SERVER + ":" + PORT + 
                                      ";databaseName=" + DATABASE + 
                                      ";integratedSecurity=true;" +
                                      ";encrypt=false;trustServerCertificate=true";
    // Con integratedSecurity=true NO se necesita usuario ni contraseña
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    /**
     * Obtiene una conexión a la base de datos
     * @return Connection objeto de conexión
     * @throws SQLException si hay error en la conexión
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            // Cargar el driver
            Class.forName(DRIVER);
            // Establecer conexión SIN usuario y contraseña (usa Autenticación de Windows)
            conn = DriverManager.getConnection(URL);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver SQL Server no encontrado");
            e.printStackTrace();
            throw new SQLException("Driver no encontrado", e);
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos");
            e.printStackTrace();
            throw e;
        }
        return conn;
    }

    /**
     * Cierra la conexión a la base de datos
     * @param conn Connection a cerrar
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión");
                e.printStackTrace();
            }
        }
    }

    /**
     * Método para probar la conexión
     */
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("¡Prueba de conexión exitosa!");
                closeConnection(conn);
            }
        } catch (SQLException e) {
            System.err.println("¡Prueba de conexión fallida!");
            e.printStackTrace();
        }
    }
}