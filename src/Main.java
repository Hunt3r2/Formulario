import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
	    MainMenu mainMenu = new MainMenu();
	    mainMenu.setVisible(true);

	    // Esperar hasta que se ingrese la información
	    while (mainMenu.getPersona() == null) {
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    // Obtener la información ingresada por el usuario
	    Persona persona = mainMenu.getPersona();

	    // Utilizar la información
	    if (persona != null) {
	        System.out.println("Nombre: " + persona.getNombre());
	        System.out.println("Apellido: " + persona.getApellido());
	    }
	}
}
