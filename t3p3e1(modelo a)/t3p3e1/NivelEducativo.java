package t3p3e1;

public abstract class NivelEducativo {

    //propiedades
    private String nombre;
    protected String zona;
    private int duracion;
    protected int maxEstudiantes;
    protected double nivelDemanda, calificacionMin;

    protected LibroTexto[] biblioteca;
    protected int numLibros;

    //constructor
    public NivelEducativo(String nombre, int duracion) {
        this.nombre = nombre;
        this.zona = "Andalucia";
        this.duracion = duracion;
        this.maxEstudiantes = 0;
        this.nivelDemanda = 1;
        this.calificacionMin = 0;
    }

// utilizamos este get por el tostring en primaria y superior porque nombre es privado como propiedade 
    public String getNombre() {
        return this.nombre;
    }
// utilizamos este get por el tostring en primaria y superior porque duraccion es privado como propiedade 

    public int getDuraccion() {
        return this.duracion;
    }

    //eventoanual
    public void realizarEventoAnual() {
        System.out.println("Salida al zoo de Fuengirola");
    }

    public boolean agregarLibro(LibroTexto nuevo) {

        if (numLibros < 10) {
            biblioteca[numLibros] = nuevo;
            numLibros++;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return nombre + " { zona: " + zona + ", duración: " + duracion + " años }";
    }
}
