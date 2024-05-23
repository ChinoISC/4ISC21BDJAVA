package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
     public static void mostrarUsuarios() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/pruebabd";
        String username = "root";
        String password = "1234";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Crear la consulta SQL
            String sql = "SELECT * FROM usuarios WHERE idUsuarios = ?";

            // Crear el PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);  // Ejemplo de uso de un parámetro

            // Ejecutar la consulta
            resultSet = preparedStatement.executeQuery();

            // Procesar los resultados
            while (resultSet.next()) {
                int id = resultSet.getInt("idUsuarios");
                String nombre = resultSet.getString("Nombre");
                String apellido = resultSet.getString("Apellidos");
                String email = resultSet.getString("Email");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido+", Email"+ email);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión con la base de datos o al ejecutar la consulta.");
            e.printStackTrace();
        } finally {
            // Cerrar los recursos en orden inverso a su apertura
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
