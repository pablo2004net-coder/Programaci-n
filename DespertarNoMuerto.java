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
            String nombreEnemigo = "Caballero Hueco";
            int vidaEnemigo = 40;
        

            // Mostrar información del personaje
            System.out.println("Bienvenido al Reino de las cenizas, " + nombre);
            System.out.println(" Vida: " + vida + " / " + vidaMaxima + " PV");
            System.out.println(" Pociones: " + pociones);

            System.out.println();
            System.out.println(" Un enemigo aparece entre las cenizas...");
            System.out.println("Enemigo: " + nombreEnemigo);
            System.out.println(" Vida del enemigo: " + vidaEnemigo + " PV");

            boolean abandonar = false;

            while (vidaEnemigo > 0 && vida > 0 && !abandonar) {
                System.out.println();
                System.out.println("¿Que quieres hacer?");
                System.out.println("1. Atacar");
                System.out.println("2. Usar poción");
                System.out.println("3. Abandonar el combate");

            System.out.print("Elige una opción: ");

            int opcionCombate = teclado.nextInt();
            teclado.nextLine();

        switch (opcionCombate) {

            case 1:
                int dano = 10;

                    vidaEnemigo = vidaEnemigo - dano;

                    System.out.println("Has atacado al " + nombreEnemigo);
                    System.out.println("El " + nombreEnemigo + " ha recibido " + dano + " puntos de daño.");
                    System.out.println("Vida restante del enemigo " + vidaEnemigo + " PV");

                    if (vidaEnemigo > 0) {

                        int danoEnemigo = 5;

                        vida = vida - danoEnemigo;

                        if (vida < 0) {
                            vida = 0;
                        }

                        System.out.println("El " + nombreEnemigo + " contraataca.");
                        System.out.println("Has recibido " + danoEnemigo + " puntos de daño.");
                        System.out.println("Tu vida: " + vida + "/" + vidaMaxima + " PV");
                    }
                    break;
            case 2:
                System.out.println("Has elegido usar una poción.");
                break;
            case 3:
                System.out.println("Has abandonado el combate.");
                abandonar = true;
                break;
            default:
                System.out.println("Opción no válida. Introduce un número del 1 al 3");
                break;
            
       
        } // Cierra el switch del combate

    } // Cierra el while del combate

        if (vidaEnemigo <= 0) {
            System.out.println();
            System.out.println("¡Has derrotado al " + nombreEnemigo + "!");
            System.out.println("Las cenizas del enemigo se desvanecen...");
        }

        if (vida <= 0) {
            System.out.println();
            System.out.println("HAS MUERTO");
            System.out.println("Tu aventura ha terminado en las cenizas del reino.");
        }
            break; // Termina el case 1 del menú principal
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

