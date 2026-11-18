import java.util.Scanner;
public class DespertarNoMuerto 
{

    public static void main(String[] args) 
    {

    // Crear scanner y la variable opcion
    Scanner teclado = new Scanner(System.in);
    int opcion;
    
    // Título del Juego
    do {
    System.out.println("EL Despertar del No Muerto");
    System.out.println("Cenizas del Reino");

    // Menú Principal
    System.out.println();
    System.out.println("1. Nueva Partida");
    System.out.println("2. Registro de No Muertos");
    System.out.println("3. Ayuda");
    System.out.println("4. Salir");
    System.out.println();

    // Solicitar opción al Jugador
    System.out.print("Elige una opción: ");

    if(teclado.hasNextInt()) {

        opcion = teclado.nextInt();

    } else {
        
        opcion = 0;
    }

    teclado.nextLine();

    
    switch (opcion) {
        case 1:
            System.out.println("El reino te llama, No Muerto...");

            String nombre;

            do {
            
                System.out.print("Introduce el nombre de tu personaje: ");
                nombre = teclado.nextLine().trim();

                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }

                
            } while (nombre.isEmpty());
            
            // Estadísticas iniciales del personaje
            int vidaMaxima = 100;
            int vida = vidaMaxima;
            int pociones = 3;

            // Mostrar información del personaje
            System.out.println("Bienvenido al Reino de las cenizas, " + nombre);
            System.out.println(" Vida: " + vida + " / " + vidaMaxima + " PV");
            System.out.println(" Pociones: " + pociones);


            break;
        case 2:
            System.out.println("Has elegido Registro de No Muertos");
            break;
        case 3:
            System.out.println("Has elegido Ayuda");
            break;
        case 4:
            System.out.println("Has elegido Salir");
            break;
        default:
            System.out.println("Opción no válida. Introduce un número del 1 al 4");
            break;
    
        }
    
    } while (opcion != 4);

    // Cerrar Scanner
    teclado.close();
}
}

