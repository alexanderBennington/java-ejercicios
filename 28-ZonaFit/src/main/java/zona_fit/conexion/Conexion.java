package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName());
    
    public static Connection getConexion(){
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost/" + baseDatos;
        var usuario = "root";
        var clave = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, clave);
            LOGGER.log(Level.INFO, "Conexión establecida! ");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "No se encontró el driver de MySQL", e);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "No se logró realizar la conexión: {0}", e.getMessage());
        }
        return conexion;
    }

    public static void cerrarConexion(Connection conexion){
        try {
            conexion.close();
            LOGGER.log(Level.INFO, "Conexión cerrada!",conexion);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Error al cerrar conexion: {0}", e.getMessage());
        }
    }
}
