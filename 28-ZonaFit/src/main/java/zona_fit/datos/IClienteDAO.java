package zona_fit.datos;

import java.util.List;
import zona_fit.dominio.Cliente;

public interface IClienteDAO {
    List<Cliente> listarClientes();
    void buscarClientePorId(Cliente cliente);
    void agregarCliente(Cliente cliente);
    void modificarCliente(Cliente cliente);
    void eliminarCliente(Cliente cliente);
}
