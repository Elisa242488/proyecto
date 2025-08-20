package ejemploconexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/proyecto"; // cambia "proyecto" por el nombre de tu BD
    private static final String USUARIO = "root";  // tu usuario
    private static final String PASSWORD = "pipe12"; // tu contraseña

    // MÉTODO PARA OBTENER LA CONEXIÓN
    public Connection getConexion() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e.getMessage());
            return null;
        }
    }
}

