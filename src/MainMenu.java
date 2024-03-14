// MainMenu.java
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

    private JButton botonIngresar;
    private JButton botonVerInfo;
    private Persona[] vectorPersona;
    private int contador;
    private JButton btnBorrar;
    
    public Persona getPersona() {
        if (contador > 0) {
            return vectorPersona[contador - 1]; // Devuelve la última persona agregada
        } else {
            return null; // No hay ninguna persona ingresada
        }
    }


    public MainMenu() {
        setTitle("Menú Principal");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar el arreglo de personas
        vectorPersona = new Persona[10];
        contador = 0;

        // Crear componentes
        botonIngresar = new JButton("Ingresar Información");
        botonVerInfo = new JButton("Ver Información");

        // Crear panel y añadir componentes
        JPanel panel = new JPanel();
        panel.add(botonIngresar);
        panel.add(botonVerInfo);

        // Añadir panel al JFrame
        getContentPane().add(panel);
        
        btnBorrar = new JButton("Borrar");
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Solicitar al usuario el índice de la persona a borrar
                String input = JOptionPane.showInputDialog(MainMenu.this, "Ingrese el índice de la persona a borrar:");

                // Verificar si se ingresó algún valor y si es un número válido
                if (input != null && !input.isEmpty()) {
                    try {
                        int indice = Integer.parseInt(input);
                        borrarPersona(indice - 1);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(MainMenu.this, "Ingrese un número válido para el índice", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(btnBorrar);

        // Configurar acción para el botón "Ingresar Información"
        botonIngresar.addActionListener(e -> {
            // Mostrar el formulario para ingresar la información
            Formulario formulario = new Formulario(this);
            formulario.setVisible(true);
        });

        // Configurar acción para el botón "Ver Información"
        botonVerInfo.addActionListener(e -> {
            // Mostrar la ventana para ver la información
            mostrarInformacion();
        });

        setVisible(true);
    }

    public void agregarPersona(Persona persona) {
        if (contador < vectorPersona.length) {
            vectorPersona[contador++] = persona;
            JOptionPane.showMessageDialog(this, "Persona agregada correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "No se pueden agregar más personas (límite de 10 alcanzado)",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarInformacion() {
        if (contador == 0) {
            JOptionPane.showMessageDialog(this, "No hay información ingresada.", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < contador; i++) {
                sb.append("Nombre: ").append(vectorPersona[i].getNombre()).append(", Apellido: ").append(vectorPersona[i].getApellido()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString(), "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void borrarPersona(int indice) {
        if (indice >= 0 && indice < contador) {
            // Mover todas las personas después del índice hacia atrás en el arreglo
            for (int i = indice; i < contador - 1; i++) {
                vectorPersona[i] = vectorPersona[i + 1];
            }
            // Eliminar la última posición y disminuir el contador
            vectorPersona[contador - 1] = null;
            contador--;
            JOptionPane.showMessageDialog(this, "Persona eliminada correctamente");
        } else {
            JOptionPane.showMessageDialog(this, "Índice inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        new MainMenu();
    }
}
