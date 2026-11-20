import java.util.Scanner;

public class DespertarNoMuerto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("EL Despertar del No Muerto");
            System.out.println("Cenizas del Reino");
            System.out.println();
            System.out.println("1. Nueva Partida");
            System.out.println("2. Registro de No Muertos");
            System.out.println("3. Ayuda");
            System.out.println("4. Salir");
            System.out.println();
            System.out.print("Elige una opción: ");

            if (teclado.hasNextInt()) {
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

                    // Estadísticas iniciales del personaje.
                    int vidaMaxima = 100;
                    int vida = vidaMaxima;
                    int pociones = 3;

                    // Enemigos en el orden en que aparecen.
                    String[] enemigos = {
                        "Caballero Hueco",
                        "Guardian de las Cenizas",
                        "Señor de las Cenizas"
                    };
                    int[] vidasEnemigos = {40, 60, 80};

                    System.out.println("Bienvenido al Reino de las cenizas, " + nombre);
                    mostrarEstadisticas(vida, vidaMaxima, pociones);

                    boolean abandonar = false;

                    // Recorremos los tres enemigos, conservando vida y pociones.
                    for (int enemigoActual = 0;
                         enemigoActual < enemigos.length && vida > 0 && !abandonar;
                         enemigoActual++) {

                        String nombreEnemigo = enemigos[enemigoActual];
                        int vidaEnemigo = vidasEnemigos[enemigoActual];
                        mostrarEnemigo(nombreEnemigo, vidaEnemigo);

                        while (vidaEnemigo > 0 && vida > 0 && !abandonar) {
                            System.out.println();
                            System.out.println("¿Que quieres hacer?");
                            System.out.println("1. Atacar");
                            System.out.println("2. Usar poción");
                            System.out.println("3. Abandonar el combate");
                            System.out.print("Elige una opción: ");

                            int opcionCombate;
                            if (teclado.hasNextInt()) {
                                opcionCombate = teclado.nextInt();
                            } else {
                                opcionCombate = 0;
                            }
                            teclado.nextLine();

                            switch (opcionCombate) {
                                case 1:
                                    int dano = (int) (Math.random() * 11) + 10;
                                    vidaEnemigo = vidaEnemigo - dano;
                                    if (vidaEnemigo < 0) {
                                        vidaEnemigo = 0;
                                    }
                                    System.out.println("Has atacado al " + nombreEnemigo);
                                    System.out.println("El " + nombreEnemigo + " ha recibido " + dano + " puntos de daño.");
                                    System.out.println("Vida restante del enemigo: " + vidaEnemigo + " PV");

                                    if (vidaEnemigo > 0) {
                                        int danoEnemigo = (int) (Math.random() * 11) + 5;
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
                                    if (pociones > 0 && vida < vidaMaxima) {
                                        vida = vida + 25;
                                        pociones = pociones - 1;
                                        if (vida > vidaMaxima) {
                                            vida = vidaMaxima;
                                        }
                                        System.out.println("Has utilizado una poción.");
                                        System.out.println("Tu vida: " + vida + "/" + vidaMaxima + " PV");
                                        System.out.println("Pociones restantes: " + pociones);
                                    } else {
                                        System.out.println("No puedes usar una poción en este momento.");
                                    }
                                    break;

                                case 3:
                                    System.out.println("Has abandonado el combate.");
                                    abandonar = true;
                                    break;

                                default:
                                    System.out.println("Opción no válida. Introduce un número del 1 al 3.");
                                    break;
                            } // Fin switch del combate.
                        } // Fin while del combate actual.

                        if (vidaEnemigo <= 0) {
                            System.out.println();
                            System.out.println("¡Has derrotado al " + nombreEnemigo + "!");
                            System.out.println("Las cenizas del enemigo se desvanecen...");
                        }
                    } // Fin for de los tres enemigos.

                    if (vida <= 0) {
                        System.out.println("HAS MUERTO");
                        System.out.println("Tu aventura ha terminado en las cenizas del reino.");
                    } else if (!abandonar) {
                        System.out.println("¡Has derrotado a todos los enemigos!");
                        System.out.println("Has alcanzado la última hoguera.");
                    }
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

        teclado.close();
    }

    public static void mostrarEnemigo(String nombre, int vida) {
        System.out.println();
        System.out.println("Un enemigo aparece entre las cenizas...");
        System.out.println("Enemigo: " + nombre);
        System.out.println("Vida del enemigo: " + vida + " PV");
    }

    public static void mostrarEstadisticas(int vida, int vidaMaxima, int pociones) {
        System.out.println("Vida: " + vida + " / " + vidaMaxima + " PV");
        System.out.println("Pociones: " + pociones);
    }
}
