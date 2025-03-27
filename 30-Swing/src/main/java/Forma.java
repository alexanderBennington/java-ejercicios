import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Forma extends JFrame {
    private JPanel panelPrincipal;
    private JLabel holaMundoLabel;
    private JTextField campoTexto;
    private JLabel replicadorLabel;

    public Forma(){
        inicializarForma();
        /*campoTexto.addActionListener(e -> {
            System.out.println("Se ejecuto action listener");
            this.replicadorLabel.setText(this.campoTexto.getText());
        });*/
        campoTexto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                replicarTexto();
            }
        });
    }
    private void replicarTexto(){
        this.replicadorLabel.setText(this.campoTexto.getText());
    }
    private void inicializarForma(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        FlatDarkLaf.setup();
        Forma forma = new Forma();
        forma.setVisible(true);
    }
}
