package alexander.tareas.controlador;

import alexander.tareas.modelo.Tarea;
import alexander.tareas.servicio.TareaServicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;

@Component
public class IndexControlador implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(IndexControlador.class);

    @Autowired
    private TareaServicio tareaServicio;

    @FXML
    private TableView<Tarea> tareaTabla;

    @FXML
    private TableColumn<Tarea, Integer> idTareaColumna;

    @FXML
    private TableColumn<Tarea, String> tareaTareaColumna;

    @FXML
    private TableColumn<Tarea, String> responsableTareaColumna;

    @FXML
    private TableColumn<Tarea, String> estatusTareaColumna;

    private final ObservableList<Tarea> tareaLista = FXCollections.observableArrayList();

    @FXML
    private TextField tareaTareaTexto;

    @FXML
    private TextField responsableTareaTexto;

    @FXML
    private TextField estatusTareaTexto;

    private Integer idTareaInterno;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logger.info("Vista Inicializada correctamente!");
        tareaTabla.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configurarColumnas();
        listarTareas();
    }

    private void configurarColumnas() {
        idTareaColumna.setCellValueFactory(new PropertyValueFactory<>("idTarea"));
        tareaTareaColumna.setCellValueFactory(new PropertyValueFactory<>("nombreTarea"));
        responsableTareaColumna.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        estatusTareaColumna.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }

    private void listarTareas() {
        logger.info("Ejecutando lista de tareas...");
        tareaLista.clear();
        tareaLista.addAll(tareaServicio.listarTareas());
        tareaTabla.setItems(tareaLista);
    }


    @FXML
    private void agregarTarea() {
        if (tareaTareaTexto.getText().isEmpty() || responsableTareaTexto.getText().isEmpty() || estatusTareaTexto.getText().isEmpty()) {
            mostrarMensaje("Error de validación", "Favor de llenar todos los campos");
            //tareaTareaTexto.requestFocus();
            return;
        } else {
            var tarea = new Tarea();
            recolectarDatosFormulario(tarea);
            tarea.setIdTarea(null);
            tareaServicio.guardarTarea(tarea);
            mostrarMensaje("Información", "Tarea Agregada!");
            limpiarFormulario();
            listarTareas();
        }
    }

    @FXML
    private void cargarTareaFormulario() {
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if (tarea != null) {
            idTareaInterno = tarea.getIdTarea();
            tareaTareaTexto.setText(tarea.getNombreTarea());
            responsableTareaTexto.setText(tarea.getResponsable());
            estatusTareaTexto.setText(tarea.getEstatus());
        }
    }

    private void mostrarMensaje(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void recolectarDatosFormulario(Tarea tarea) {
        if (idTareaInterno != null)
            tarea.setIdTarea(idTareaInterno);
        tarea.setNombreTarea(tareaTareaTexto.getText());
        tarea.setResponsable(responsableTareaTexto.getText());
        tarea.setEstatus(estatusTareaTexto.getText());
    }

    @FXML
    public void limpiarFormulario() {
        idTareaInterno = null;
        tareaTareaTexto.clear();
        responsableTareaTexto.clear();
        estatusTareaTexto.clear();
    }

    @FXML
    public void modificarTarea() {
        if (idTareaInterno == null) {
            mostrarMensaje("Información", "Debe seleccionar alguna tarea de la tabla");
            return;
        }
        if (tareaTareaTexto.getText().isEmpty() || responsableTareaTexto.getText().isEmpty() || estatusTareaTexto.getText().isEmpty()) {
            mostrarMensaje("Error de validación", "Favor de llenar todos los campos");
            return;
        } else {
            var tarea = new Tarea();
            recolectarDatosFormulario(tarea);
            tareaServicio.guardarTarea(tarea);
            mostrarMensaje("Información", "Tarea modificada");
            limpiarFormulario();
            listarTareas();
        }
    }

    @FXML
    public void eliminarTarea() {
        var tarea = tareaTabla.getSelectionModel().getSelectedItem();
        if (tarea != null){
            logger.info("Registro a eliminar: " + tarea.toString());
            tareaServicio.eliminarTarea(tarea);
            mostrarMensaje("Información", "Tarea eliminada: " + tarea.getIdTarea());
            limpiarFormulario();
            listarTareas();
        } else {
            mostrarMensaje("Error", "No se ha seleccionado ninguna tarea!");
        }
    }
}
