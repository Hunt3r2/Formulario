// Formulario.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario extends JFrame {

    private JLabel labelNombre, labelApellido;
    private JTextField campoNombre, campoApellido;
    private JButton botonConfirmar;
    private MainMenu mainMenu;

    public Formulario(MainMenu mainMenu) {
        this.mainMenu = mainMenu;

        setTitle("Formulario");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear componentes
        labelNombre = new JLabel("Nombre:");
        campoNombre = new JTextField(20);
        labelApellido = new JLabel("Apellido:");
        campoApellido = new JTextField(20);
        botonConfirmar = new JButton("Confirmar");

        // Crear panel y añadir componentes
        JPanel panel = new JPanel();
        panel.add(labelNombre);
        panel.add(campoNombre);
        panel.add(labelApellido);
        panel.add(campoApellido);
        panel.add(botonConfirmar);

        // Añadir panel al JFrame
        add(panel);

        // Configurar acción para el botón Confirmar
        botonConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarInformacion();
            }
        });

        setVisible(true);
    }

    private void guardarInformacion() {
        String nombre = campoNombre.getText();
        String apellido = campoApellido.getText();

        // Crear una instancia de Persona con la información ingresada
        Persona persona = new Persona(nombre, apellido);

        // Establecer la persona en MainMenu
        mainMenu.agregarPersona(persona);

        // Cerrar el formulario después de guardar la información
        dispose();
    }
}
