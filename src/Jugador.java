public class Jugador {
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String posicion;
    private boolean lesionado;

    public Jugador(String nombre, String nacionalidad, int edad, String posicion) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
        setPosicion(posicion);
        this.lesionado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public int getEdad() {
        return edad;
    }

    public String getPosicion() {
        return posicion;
    }

    public boolean getLesionado() {
        return lesionado;
    }

    public void setPosicion(String posicion) {
        // Validar que la posición sea una de las cuatro especificadas
        if (posicion.equals("POR") || posicion.equals("DEF") || posicion.equals("CTC") || posicion.equals("DEL")) {
            this.posicion = posicion;
        } else {
            System.out.println("Posición no válida. Se establecerá como 'DESC' (Desconocido).");
            this.posicion = "DESC";
        }
    }

    public void lesionarse() {
        lesionado = false;
    }

    public void recuperarse() {
        lesionado = false;
    }
}

