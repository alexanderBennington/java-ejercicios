package web;

import datos.ClienteDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(ServletControlador.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = Optional.ofNullable(request.getParameter("accion")).orElse("listar");
        switch(accion){
            case "listar" -> this.listarClientes(request, response);
            case "editar" -> this.editarCliente(request, response);
            case "eliminar" -> this.eliminarCliente(request, response);            
            default -> this.listarClientes(request, response);
        }
    }
    
    private void listarClientes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClienteDAO cliente = new ClienteDAO();
        List<Cliente> clientes = cliente.listarClientes();
        LOGGER.log(Level.INFO, "Clientes: {0}", clientes);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));        
        
        
        request.getRequestDispatcher("clientes.jsp").forward(request, response);
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
/*      
        double saldoTotal = 0.0;
        for(Cliente cliente : clientes){
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
*/
        return clientes.stream().mapToDouble(Cliente::getSaldo).sum();
    }
    
    private void editarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = new ClienteDAO().encontrarCliente(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarCliente (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        new ClienteDAO().eliminarCliente(idCliente);
        this.listarClientes(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = Optional.ofNullable(request.getParameter("accion")).orElse("listar");
        switch(accion){
            case "insertar" -> this.insertarCliente(request, response);
            case "modificar" -> this.modificarCliente(request, response);            
            default -> this.listarClientes(request, response);
        }
    }
    
    private void insertarCliente (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        new ClienteDAO().insertarCliente(cliente);
        this.listarClientes(request, response);
    }
    
    private void modificarCliente (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        double saldo = Double.parseDouble(request.getParameter("saldo"));
        Cliente cliente = new Cliente(idCliente,nombre, apellido, email, telefono, saldo);
        new ClienteDAO().modificarCliente(cliente);
        this.listarClientes(request, response);
    }
}
