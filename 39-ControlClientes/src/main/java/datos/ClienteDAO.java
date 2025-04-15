package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

public class ClienteDAO {

    private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class.getName());
    private static final String SQL_SELECT = "SELECT id, nombre, apellido, email, telefono, saldo FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(nombre, apellido, email, telefono, saldo) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_BY_ID = "SELECT id, nombre, apellido, email, telefono, saldo FROM clientes WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre = ?, apellido = ?, email = ?, telefono = ?, saldo = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id = ?";    

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection conexion = Conexion.getConnection(); PreparedStatement ps = conexion.prepareStatement(SQL_SELECT); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDouble("saldo")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al obtener clientes... {0}", e.getMessage());
        }
        return clientes;
    }

    public boolean insertarCliente(Cliente cliente) {
        boolean esAgregado = false;
        int inserts = 0;
        try (Connection conexion = Conexion.getConnection(); PreparedStatement ps = conexion.prepareStatement(SQL_INSERT)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setDouble(5, cliente.getSaldo());            
            
            inserts = ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al agregar cliente... {0}", e.getMessage());
        }
        return inserts == 5 ? esAgregado = true : esAgregado;
    }
    
    public Cliente encontrarCliente(Cliente cliente){
        try (Connection conexion = Conexion.getConnection(); PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_BY_ID)) {
            ps.setInt(1, cliente.getIdCliente());         
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setEmail(rs.getString("email"));                    
                    cliente.setTelefono(rs.getString("telefono"));
                    cliente.setSaldo(rs.getDouble("saldo"));
                }
            }
            LOGGER.log(Level.INFO, "Cliente encontrado: {0}", cliente.toString());
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al buscar cliente... {0}", e.getMessage());
        }
        return cliente;
    }
    
    public boolean modificarCliente(Cliente cliente){
        boolean esGuardado = false;
        int inserts = 0;
        try (Connection conexion = Conexion.getConnection(); PreparedStatement ps = conexion.prepareStatement(SQL_UPDATE)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getTelefono());
            ps.setDouble(5, cliente.getSaldo());            
            ps.setInt(6, cliente.getIdCliente());         
            
            inserts = ps.executeUpdate();
            
            LOGGER.log(Level.INFO, "Cliente guardado: {0}", cliente.toString());
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al guardar cliente... {0}", e.getMessage());
        }
        return inserts == 6 ? esGuardado = true : esGuardado;
    }
    
    public boolean eliminarCliente(int idCliente){
        boolean esEliminado = false;
        int inserts = 0;
        try (Connection conexion = Conexion.getConnection(); PreparedStatement ps = conexion.prepareStatement(SQL_DELETE)) {        
            ps.setInt(1, idCliente);         
            
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al eliminar cliente... {0}", e.getMessage());
        }
        return inserts == 1 ? esEliminado = true : esEliminado;
    }
}
