package gm.zona_fit;

import gm.zona_fit.modelo.Cliente;
import gm.zona_fit.servicio.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger LOGGER = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		LOGGER.info("Iniciando Aplicación");
		SpringApplication.run(ZonaFitApplication.class, args);
		LOGGER.info("Finalizando Aplicación");
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info(nl + "*** ZONA FIT GYM ***" + nl);
		zonaFitApp();
	}

	private void zonaFitApp() {
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir) {
			try {
				var opcion = mostrarMenu(consola);
				salir = ejecutarOpciones(consola, opcion);
			} catch (Exception e) {
				LOGGER.warn("Error al ejecutar opciones: " + e.getMessage());
			}
		}
	}

	private static int mostrarMenu(Scanner consola) {
		int opcion = 0;
		while (opcion <= 0) {
			try {
				LOGGER.info("""
						1. Listar Clientes
						2. Buscar Cliente
						3. Agregar Cliente
						4. Modificar Cliente
						5. Eliminar Cliente
						6. Salir
						Elija una opción:\s""");
				opcion = Integer.parseInt(consola.nextLine());
			} catch (NumberFormatException e) {
				LOGGER.warn("Entrada inválida. Debe ser un número..." + e.getMessage());
			}
		}
		return opcion;
	}

	private boolean ejecutarOpciones(Scanner consola, int opcion){
		//List<Cliente> cliente = new ArrayList<>();
		var salir = false;
		switch (opcion) {
			case 1 -> {
				LOGGER.info(nl +"--- Lista de clientes ---" + nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				//clientes.forEach(cliente -> LOGGER.info(clientes.toString() + nl));
				LOGGER.info(clientes.toString() + nl);
			}
			case 2 -> {
				LOGGER.info(nl + "Buscar Cliente por ID---" + nl);
				LOGGER.info("Introduzca ID de cliente a buscar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				LOGGER.info(nl);
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					LOGGER.info("Cliente encontrado! : "+ cliente + nl);
				} else {
					LOGGER.info("Cliente NO encontrado! : "+ cliente + nl);
				}
				LOGGER.info(nl);
			}
			case 3 -> {
				LOGGER.info(nl + "--- Agregar Cliente ---" + nl);
				LOGGER.info(nl + "Nombre: ");
				var nombre = consola.nextLine();
				LOGGER.info(nl + "Apellido: ");
				var apellido = consola.nextLine();
				LOGGER.info(nl + "Membresia: ");
				var membresia =  Integer.parseInt(consola.nextLine());
				Cliente cliente = new Cliente();
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setMembresia(membresia);
				clienteServicio.guardarCliente(cliente);
				LOGGER.info("Cliente Agregado! : " + cliente + nl);
			}
			case 4 -> {
				LOGGER.info(nl + "--- Modificar Cliente ---" + nl);
				LOGGER.info(nl + "Introduzca ID de cliente a modificar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					LOGGER.info(nl + "Nombre: ");
					var nombre = consola.nextLine();
					LOGGER.info(nl + "Apellido: ");
					var apellido = consola.nextLine();
					LOGGER.info(nl + "Membresia: ");
					var membresia =  Integer.parseInt(consola.nextLine());
					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);
					clienteServicio.guardarCliente(cliente);
					LOGGER.info("Cliente Modificado! : " + cliente + nl);
				} else {
					LOGGER.error(nl + "Cliente NO encontrado" + cliente + nl);
				}

			}
			case 5 -> {
				LOGGER.info(nl + "--- Eliminar Cliente --- " + nl);
				LOGGER.info(nl + "Introduzca ID de cliente a eliminar: ");
				var idCliente = Integer.parseInt(consola.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					clienteServicio.eliminarCliente(cliente);
					LOGGER.info(nl + "Cliente Eliminado!: " + cliente + nl);
				} else {
					LOGGER.error(nl + "Cliente NO encontrado" + cliente + nl);
				}

			}
			case 6 -> {
				LOGGER.info(nl + "Hasta luego!" + nl);
				salir = true;
			}
			default -> {
				LOGGER.error(nl + "Opción invalida: " + opcion);
			}
		}
		return salir;
	}
}
