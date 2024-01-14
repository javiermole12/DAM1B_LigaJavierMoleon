import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Liga liga = crearLiga(scanner);

        int opcion;
        do {
            System.out.println("MENU DE LA LIGA");
            System.out.println("1- Insertar Equipo");
            System.out.println("2- Insertar Jugador");
            System.out.println("3- Ver equipos de la liga");
            System.out.println("4- Ver jugadores de un equipo");
            System.out.println("5- Vender jugador");
            System.out.println("6- Salir");
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    insertarEquipo(scanner, liga);
                    break;
                case 2:
                    insertarJugador(scanner, liga);
                    break;
                case 3:
                    verLiga(liga);
                    break;
                case 4:
                    verJugadores(scanner, liga);
                    break;
                case 5:
                    venderJugador(scanner, liga);
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 6);

        scanner.close();
    }

    private static Liga crearLiga(Scanner scanner) {
        System.out.print("Empiece creando una liga. Inserte el país de la liga: ");
        String pais = scanner.nextLine();
        return new Liga(pais);
    }

    private static void insertarEquipo(Scanner scanner, Liga liga) {
        System.out.print("Inserte el nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        System.out.print("Inserte la ciudad del equipo: ");
        String ciudadEquipo = scanner.nextLine();
        Equipo equipo = new Equipo(nombreEquipo, ciudadEquipo);
        System.out.println("Creando equipo...");
        liga.añadirEquipo(equipo);
        System.out.println("Insertando equipo...");
        System.out.println("Equipo " + nombreEquipo + " insertado.");
    }

    private static void insertarJugador(Scanner scanner, Liga liga) {
        System.out.print("Indique el nombre del equipo donde quiere insertar el jugador: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = liga.getEquipo(nombreEquipo);

        if (equipo != null) {
            System.out.print("Indique el nombre del jugador: ");
            String nombreJugador = scanner.nextLine();
            System.out.print("Indique la nacionalidad del jugador: ");
            String nacionalidad = scanner.nextLine();
            System.out.print("Indique la edad del jugador: ");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            System.out.print("Indique la posición del jugador: ");
            String posicion = scanner.nextLine();

            Jugador jugador = new Jugador(nombreJugador, nacionalidad, edad, posicion);
            System.out.println("Creando jugador...");
            equipo.adquirirJugador(jugador);
            System.out.println("Insertando jugador...");
            System.out.println("Jugador " + nombreJugador + " insertado en " + nombreEquipo);
        } else {
            System.out.println("El equipo indicado no existe.");
        }
    }

    private static void verLiga(Liga liga) {
        System.out.println("**********COMPOSICIÓN DE LA LIGA*************************");
        System.out.println("EQUIPO\t\tCIUDAD\t\tNUMERO JUGADORES");

        for (Equipo equipo : liga.listadoEquipos) {
            System.out.println(equipo.getNombre() + "\t\t" + equipo.getCiudad() + "\t\t" + equipo.getNumJugadores());
        }

        System.out.println("*********************************************************");
    }

    private static void verJugadores(Scanner scanner, Liga liga) {
        System.out.print("Indique el equipo que quiere visualizar: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = liga.getEquipo(nombreEquipo);

        if (equipo != null) {
            System.out.println("********* " + nombreEquipo + " ****************************");
            System.out.println("NOMBRE\t\tPOSICIÓN\tEDAD\tNAC\t\tLESIONADO");

            for (Jugador jugador : equipo.listaJugadores) {
                System.out.println(jugador.getNombre() + "\t\t" + jugador.getPosicion() + "\t\t\t" +
                        jugador.getEdad() + "\t" + jugador.getNacionalidad() + "\t" +
                        (jugador.getLesionado() ? "SI" : "NO"));
            }

            System.out.println("*********************************************");
        } else {
            System.out.println("El equipo indicado no existe.");
        }
    }

    private static void venderJugador(Scanner scanner, Liga liga) {
        System.out.print("Inserte el nombre del equipo donde quiere vender el jugador: ");
        String nombreEquipo = scanner.nextLine();
        Equipo equipo = liga.getEquipo(nombreEquipo);

        if (equipo != null) {
            System.out.print("Inserte el nombre del jugador: ");
            String nombreJugador = scanner.nextLine();
            equipo.venderJugador(nombreJugador);
            System.out.println("Jugador vendido.");
        } else {
            System.out.println("El equipo indicado no existe.");
        }
    }
}

