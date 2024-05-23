package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect_db {
    public static void conectDB() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/pruebabd";
        String username = "root";
        String password = "1234";

        Connection connection = null;

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Conexión exitosa!");
            } else {
                System.out.println("Fallo en la conexión.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL.");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión con la base de datos.");
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
