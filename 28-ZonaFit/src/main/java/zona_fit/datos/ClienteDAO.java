package zona_fit.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

public class ClienteDAO implements IClienteDAO{
    private static final Logger LOGGER = Logger.getLogger(ClienteDAO.class.getName());

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Connection conexion = Conexion.getConexion();
        var sql = "SELECT * FROM cliente ORDER BY id ASC";
        try (PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));                
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al listar clientes: " + sql + " {0}", e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
        return clientes;
    }

    @Override
    public void buscarClientePorId(Cliente cliente) {
        Connection conexion = Conexion.getConexion();
        var sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, cliente.getId());
            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setMembresia(rs.getInt("membresia"));
                }
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al buscar cliente: " + sql + " {0}", e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        Connection conexion = Conexion.getConexion();
        var sql = "INSERT INTO cliente (nombre, apellido, membresia) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.execute();
            LOGGER.log(Level.INFO, "Se ha agregado el cliente! " + cliente);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al insertar cliente: " + sql + " {0}", e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        Connection conexion = Conexion.getConexion();
        var sql = "UPDATE cliente SET nombre = ?, apellido = ?, membresia = ? WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            LOGGER.log(Level.INFO, "Se ha modificado el cliente! " + cliente);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al modificar cliente: " + sql + " {0}", e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        Connection conexion = Conexion.getConexion();
        var sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)){
            ps.setInt(1, cliente.getId());
            ps.execute();
            LOGGER.log(Level.INFO, "Se ha eliminado el cliente! " + cliente.getId());
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al eliminar cliente: " + sql + " {0}", e.getMessage());
        } finally {
            Conexion.cerrarConexion(conexion);
        }
    }
}
