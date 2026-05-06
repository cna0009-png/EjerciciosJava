package t3p3e1;

public class Grado extends Superior {

    private String ramaEstudios;
    private double porcentajeExito;
    private boolean falseando;

    //guardar estos valores originales para recuperarlos
    private double porcentajeExitoOriginal;
    private double calificacionMinOriginal;

    // constructor
    public Grado(String nombre, int duracion, int numObligatorias, int numOptativas, String ramaEstudios, double porcentajeExito) {
        super(numObligatorias, numOptativas, nombre, duracion);
        this.ramaEstudios = ramaEstudios;
        this.porcentajeExito = porcentajeExito;
        this.falseando = false;

        //calificacion minima
        this.calificacionMin = (Math.random() * (10 - 2 + 1)) + 2;

        //max de estudiantes es el  triple de calificación mínima
        this.maxEstudiantes = (int) (this.calificacionMin * 3);

        //demanda
        calcularDemanda();
    }

    //calcular demanda 
    protected void calcularDemanda() {
        double demanda = Math.abs(100 - this.maxEstudiantes);
        if (demanda > 100) {
            demanda = 100;
        }
        this.nivelDemanda = demanda;
    }

    //falsear  los datos temporalmente
    public void falsearDatos() {
        if (!falseando) {
            //originales
            porcentajeExitoOriginal = porcentajeExito;
            calificacionMinOriginal = calificacionMin;
        }
        falseando = true;
        //subir el exito
        porcentajeExito += 110;
        if (porcentajeExito >= 100) {
            porcentajeExito = 99.6;
        }
        //bajar  los calificación
        calificacionMin -= 1.25;
        if (calificacionMin < 1) {
            calificacionMin = 1;
        }
        calcularDemanda();
    }

    //recuperar  los datos originales
    public void recuperarDatos() {
        if (falseando) {
            porcentajeExito = porcentajeExitoOriginal;
            calificacionMin = calificacionMinOriginal;
            falseando = false;
            calcularDemanda();
        }
    }

    //evento anual
    @Override
    public void realizarEventoAnual() {
        System.out.println("Vamos a una empresa a que nos den una charla");
    }

    //tmb lo hereda 
    @Override
    public boolean agregarLibro(LibroTexto nuevo) {
        return super.agregarLibro(nuevo);
    }

    @Override
    public String toString() {
        String res = "";
        res += "Estudio Superior" + this.getNombre() + this.getDuraccion() + " Años." + "\n";
        res += "Con: " + this.numObligatorias + "materias obligatorias y " + this.numOptativas + "materias Optativas " + "\n";
        res += "Perteneciente a la rama: " + this.ramaEstudios + "\n";
        res += "Con un " + this.porcentajeExito + "% de alumnos que lo superan" + "\n";

        return res;
    }

}
