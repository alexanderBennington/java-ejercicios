import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class Login extends JFrame {

    private JPanel panelPrincipal;
    private JTextField usuarioTexto;
    private JButton enviarBoton;
    private JPasswordField passwordTexto;

    public Login(){
        inicializarLogin();
        enviarBoton.addActionListener(e -> validar());
    }

    private void validar(){
        var usuario = usuarioTexto.getText();
        var clave = new String(this.passwordTexto.getPassword());

        if("root".equals(usuario) && "admin".equals(clave))
            mostrarMensaje("Credenciales correctas, bienvenido!");
          else if("root".equals(usuario))
              mostrarMensaje("clave incorrecta!");
          else if ("admin".equals(clave))
              mostrarMensaje("Usuario incorrecto!");
          else
            mostrarMensaje("Credenciales incorrectas!");
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void inicializarLogin(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args){
        FlatDarkLaf.setup();
        Login login = new Login();
        login.setVisible(true);
    }
}
