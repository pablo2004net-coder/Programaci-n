import java.util.Scanner;

public class DespertarNoMuerto {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        String[] nombresRanking = new String[5];
        int[] puntosRanking = new int[5];
        int cantidadJugadores = 0;

        do {
            System.out.println("-----EL Despertar del No Muerto-----");
            System.out.println("-----Cenizas del Reino-----");
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
                    int puntuacion = 0;

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
                            System.out.println("4. Consultar inventario");
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

                                case 4:
                                    System.out.println();
                                    System.out.println("--- Inventario ---:");
                                    mostrarEstadisticas(vida, vidaMaxima, pociones);
                                    System.out.println("Puntuacion: " + puntuacion);
                                    break;

                                default:
                                    System.out.println("Opción no válida. Introduce un número del 1 al 4.");
                                    break;
                            } // Fin switch del combate.
                        } // Fin while del combate actual.

                        if (vidaEnemigo <= 0) {
                            puntuacion = puntuacion + 100;

                            System.out.println();
                            System.out.println("Has derrotado al " + nombreEnemigo + "!");
                            System.out.println("Has conseguido 100 puntos.");
                            System.out.println("Puntuación total: " + puntuacion);
                        }
                    } // Fin for de los tres enemigos.

                    if (vida <= 0) {
                        System.out.println("HAS MUERTO");
                        System.out.println("Tu aventura ha terminado en las cenizas del reino.");
                    } else if (!abandonar) {
                        puntuacion = puntuacion + vida;

                        System.out.println("¡Has derrotado a todos los enemigos!");
                        System.out.println("Bonus por vida restante: " + vida + " puntos.");
                    }

                    // Mostrar y guardar la puntuación, también si mueres o abandonas.
                    System.out.println("Puntuación final: " + puntuacion);
                    cantidadJugadores = guardarPuntuacion(
                        nombresRanking, puntosRanking, cantidadJugadores, nombre, puntuacion
                    );
                    break;

                case 2:
                    System.out.println();
                    System.out.println("=== REGISTRO DE NO MUERTOS ===");
                    if (cantidadJugadores == 0) {
                        System.out.println("Todavía no hay puntuaciones.");
                    } else {
                        for (int i = 0; i < cantidadJugadores; i++) {
                            System.out.println((i + 1) + ". " + nombresRanking[i]
                                + " - " + puntosRanking[i] + " puntos");
                        }
                    }
                    break;
                case 3:
                    System.out.println();
                    System.out.println("=== AYUDA DEL JUEGO ===");
                    System.out.println("Tu objetivo es derrotar a los tres enemigos.");
                    System.out.println("Comienzas con 100 puntos de vida y 3 pociones.");
                    System.out.println("Cada poción recupera 25 puntos de vida.");
                    System.out.println();
                    System.out.println("OPCIONES DEL COMBATE:");
                    System.out.println("1. Atacar: haces entre 10 y 20 puntos de daño.");
                    System.out.println("2. Usar poción: recuperas hasta 25 puntos de vida.");
                    System.out.println("3. Abandonar: terminas la partida.");
                    System.out.println("4. Consultar inventario: ves tus recursos.");
                    System.out.println();
                    System.out.println("Cada enemigo derrotado suma 100 puntos.");
                    System.out.println("Si ganas, recibes un bonus por la vida restante.");
                    System.out.println("Puedes consultar tus mejores resultados en el ranking.");
                    System.out.println("¡Buena suerte!");
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

    // Inserta la puntuación en orden descendente y mantiene solo los cinco mejores.
    // En caso de empate, los jugadores anteriores aparecen primero.
    public static int guardarPuntuacion(String[] nombres, int[] puntos,
                                       int cantidad, String nuevoNombre, int nuevosPuntos) {
        int posicion = 0;
        while (posicion < cantidad && nuevosPuntos <= puntos[posicion]) {
            posicion++;
        }

        if (posicion >= 5) {
            return cantidad;
        }

        int ultimo = Math.min(cantidad, 4);
        for (int i = ultimo; i > posicion; i--) {
            nombres[i] = nombres[i - 1];
            puntos[i] = puntos[i - 1];
        }

        nombres[posicion] = nuevoNombre;
        puntos[posicion] = nuevosPuntos;
        if (cantidad < 5) {
            cantidad++;
        }
        return cantidad;
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
