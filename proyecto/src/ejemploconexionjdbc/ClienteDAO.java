package ejemploconexionjdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // INSERTAR CLIENTE
    public void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (Nombre_cliente, Fecha_nacimiento, Fecha_de_venta_cliente) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombreCliente());
            ps.setDate(2, Date.valueOf(cliente.getFechaNacimiento()));
            ps.setDate(3, Date.valueOf(cliente.getFechaVentaCliente()));
            ps.executeUpdate();
            System.out.println("✔ Cliente insertado correctamente");
        } catch (SQLException e) {
            System.out.println("✘ Error al insertar cliente: " + e.getMessage());
        }
    }

    // LISTAR CLIENTES
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_NUMERO_DE_CLIENTE"),
                        rs.getString("Nombre_cliente"),
                        rs.getDate("Fecha_nacimiento").toLocalDate(),
                        rs.getDate("Fecha_de_venta_cliente") != null ?
                                rs.getDate("Fecha_de_venta_cliente").toLocalDate() : null
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(" Error al listar clientes: " + e.getMessage());
        }
        return clientes;
    }

    // ACTUALIZAR CLIENTE
    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET Nombre_cliente=?, Fecha_nacimiento=?, Fecha_de_venta_cliente=? WHERE id_NUMERO_DE_CLIENTE=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombreCliente());
            ps.setDate(2, Date.valueOf(cliente.getFechaNacimiento()));
            ps.setDate(3, Date.valueOf(cliente.getFechaVentaCliente()));
            ps.setInt(4, cliente.getIdCliente());
            ps.executeUpdate();
            System.out.println(" Cliente actualizado correctamente");
        } catch (SQLException e) {
            System.out.println(" Error al actualizar cliente: " + e.getMessage());
        }
    }

    // ELIMINAR CLIENTE
    public void eliminarCliente(int idCliente) {
        String sql = "DELETE FROM cliente WHERE id_NUMERO_DE_CLIENTE=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ps.executeUpdate();
            System.out.println("Cliente eliminado correctamente");
        } catch (SQLException e) {
            System.out.println(" Error al eliminar cliente: " + e.getMessage());
        }
    }
}
