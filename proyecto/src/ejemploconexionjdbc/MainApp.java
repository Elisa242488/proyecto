package ejemploconexionjdbc;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = conexionBD.getConexion();

        if (conexion != null) {
            System.out.println("✔ Conexión exitosa a la base de datos");

            ClienteDAO clienteDAO = new ClienteDAO(conexion);

            // INSERTAR CLIENTE
            Cliente nuevoCliente = new Cliente("Carlos Pérez", LocalDate.of(1992, 5, 10), LocalDate.of(2025, 8, 20));
            clienteDAO.insertarCliente(nuevoCliente);

            // LISTAR CLIENTES
            List<Cliente> clientes = clienteDAO.listarClientes();
            for (Cliente c : clientes) {
                System.out.println(c.getIdCliente() + " - " + c.getNombreCliente() + " - " + c.getFechaNacimiento());
            }

            // ACTUALIZAR CLIENTE (ejemplo con ID 1)
            Cliente clienteActualizado = new Cliente(1, "Luis Martínez Actualizado", LocalDate.of(1990, 8, 15), LocalDate.of(2025, 8, 12));
            clienteDAO.actualizarCliente(clienteActualizado);

            // ELIMINAR CLIENTE (ejemplo con ID 2)
            clienteDAO.eliminarCliente(2);

        } else {
            System.out.println("Error al conectar a la base de datos");
        }
    }
}
