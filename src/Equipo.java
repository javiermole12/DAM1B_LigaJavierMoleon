import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String ciudad;
    private int numMaxJugadores;
    List<Jugador> listaJugadores;

    public Equipo(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.numMaxJugadores = 20;
        this.listaJugadores = new ArrayList<>();
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getNumJugadores() {
        return listaJugadores.size();
    }

    public void mostrarListaJugadores() {
        for (Jugador jugador : listaJugadores) {
            System.out.println(jugador.getNombre());
        }
    }

    public void adquirirJugador(Jugador jugador) {
        if (listaJugadores.size() < numMaxJugadores) {
            listaJugadores.add(jugador);
        } else {
            System.out.println("El equipo no puede tener más jugadores.");
        }
    }

    public void venderJugador(String nombreJugador) {
        for (Jugador jugador : listaJugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                listaJugadores.remove(jugador);
                return;
            }
        }
        System.out.println("El jugador no se encuentra en el equipo.");
    }
}