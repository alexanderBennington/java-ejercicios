package gm.zona_fit.gui;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.IClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class ZonaFitForma extends JFrame {

    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JTextField nombreTexto;
    private JTextField apellidoTexto;
    private JTextField membresiaTexto;
    private JButton agregarBoton;
    private JButton eliminarBoton;
    private JButton limpiarBoton;
    private final IClienteServicio CLIENTE_SERVICIO;
    private DefaultTableModel tablaModeloClientes;
    private Integer idCliente;

    @Autowired
    public ZonaFitForma(IClienteServicio clienteServicio){
        this.CLIENTE_SERVICIO = clienteServicio;
        inicializarForma();
        agregarBoton.addActionListener(e -> guardarCliente());
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        eliminarBoton.addActionListener(e -> eliminarCliente());
        limpiarBoton.addActionListener(e -> limpiarFormulario());
    }

    private void inicializarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
    }

    private void createUIComponents() {
        this.tablaModeloClientes = new DefaultTableModel(0, 4){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] cabeceros = {"Id", "Nombre", "Apellido", "Membresia"};
        this.tablaModeloClientes.setColumnIdentifiers(cabeceros);
        this.clientesTabla = new JTable(tablaModeloClientes);
        this.clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listarClientes();
    }

    private void listarClientes(){
        this.tablaModeloClientes.setRowCount(0);
        var clientes = this.CLIENTE_SERVICIO.listarClientes();
        clientes.forEach(cliente -> {
            Object[] renglonCliente = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembresia()
            };
            this.tablaModeloClientes.addRow(renglonCliente);
        });
    }

    private void guardarCliente(){
        if(nombreTexto.getText().isEmpty() || apellidoTexto.getText().isEmpty() || membresiaTexto.getText().isEmpty()){
            mostrarMensaje("Favor de llenar todos los campos");
            return;
        } else {
            try {
                var nombre = nombreTexto.getText();
                var apellido = apellidoTexto.getText();
                var membresia = Integer.parseInt(membresiaTexto.getText());

                var cliente = new Cliente(this.idCliente, nombre, apellido, membresia);
                /*cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setMembresia(membresia);*/

                this.CLIENTE_SERVICIO.guardarCliente(cliente);
                if(this.idCliente == null)
                    mostrarMensaje("Se ha agregado un nuevo cliente");
                else
                    mostrarMensaje("Se ha modificado un cliente");
                limpiarFormulario();
                listarClientes();
            } catch (NumberFormatException e) {
                mostrarMensaje("El campo membresía debe ser un número válido...");
            }
        }
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void limpiarFormulario(){
        this.nombreTexto.setText("");
        this.apellidoTexto.setText("");
        this.membresiaTexto.setText("");
        this.idCliente = null;
        this.clientesTabla.getSelectionModel().clearSelection();
    }

    private void cargarClienteSeleccionado(){
        var renglon = clientesTabla.getSelectedRow();
        if(renglon != -1){
            var id = clientesTabla.getModel().getValueAt(renglon, 0).toString();
            this.idCliente = Integer.parseInt(id);
            var nombre = clientesTabla.getModel().getValueAt(renglon, 1).toString();
            this.nombreTexto.setText(nombre);
            var apellido = clientesTabla.getModel().getValueAt(renglon, 2).toString();
            this.apellidoTexto.setText(apellido);
            var membresia = clientesTabla.getModel().getValueAt(renglon, 3).toString();
            this.membresiaTexto.setText(membresia);
        }
    }

    private void eliminarCliente(){
        var renglon = clientesTabla.getSelectedRow();
        if(renglon != -1){
            var id = clientesTabla.getModel().getValueAt(renglon, 0).toString();
            this.idCliente = Integer.parseInt(id);
            var cliente = new Cliente();
            cliente.setId(this.idCliente);
            this.CLIENTE_SERVICIO.eliminarCliente(cliente);
            mostrarMensaje("Cliente con id: " + this.idCliente + " eliminado!");
            limpiarFormulario();
            listarClientes();
        }
    }
}
