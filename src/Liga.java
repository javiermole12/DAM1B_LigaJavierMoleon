import java.util.ArrayList;
import java.util.List;

public class Liga {
    private String pais;
    public int numMaxEquipos;
    List<Equipo> listadoEquipos;

    public Liga(String pais) {
        this.pais = pais;
        this.numMaxEquipos = 20;
        this.listadoEquipos = new ArrayList<>();
    }

    public void mostrarListadoEquipos() {
        for (Equipo equipo : listadoEquipos) {
            System.out.println(equipo.getNombre());
        }
    }

    public int getNumEquipos() {
        return listadoEquipos.size();
    }

    public Equipo getEquipo(String nombreEquipo) {
        for (Equipo equipo : listadoEquipos) {
            if (equipo.getNombre().equals(nombreEquipo)) {
                return equipo;
            }
        }
        return null;
    }

    public String getPais() {
        return pais;
    }

    public void añadirEquipo(Equipo equipo) {
        if (listadoEquipos.size() < numMaxEquipos) {
            listadoEquipos.add(equipo);
        } else {
            System.out.println("La liga no puede tener más equipos.");
        }
    }

    public void eliminarEquipo(String nombreEquipo) {
        Equipo equipoAEliminar = getEquipo(nombreEquipo);
        if (equipoAEliminar != null) {
            listadoEquipos.remove(equipoAEliminar);
        } else {
            System.out.println("El equipo no se encuentra en la liga.");
        }
    }
}