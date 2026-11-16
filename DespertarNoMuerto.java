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
    System.out.println("EL Despertar del no Muerto");
    System.out.println("Cenizas del Reino");

    // Menú Principal
    System.out.println();
    System.out.println("1. Nueva Partida");
    System.out.println("2. Registro de No Muertos");
    System.out.println("3. Ayuda");
    System.out.println("4. Salir");
    System.out.println();

    // Solicitar Opción al Jugador
    System.out.print("Elige una opción: ");
    opcion = teclado.nextInt();

    // Evaluar la opción seleccionada
    switch (opcion) {
        case 1:
            System.out.println("Has elegido Nueva Partida");
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
            System.out.println("Opción no válida");
            break;
    
        }
    
    } while (opcion != 4);

    // Cerrar Scanner
    teclado.close();
    }

}