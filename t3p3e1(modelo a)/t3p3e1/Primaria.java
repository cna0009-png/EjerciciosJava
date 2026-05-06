package t3p3e1;

public class Primaria extends NivelEducativo {

    private int numCentros;
    private double presupuesto;
//constructor

    public Primaria(String nombre, int numCentros, double presupuesto, int maxEstudiantes) {
        super(nombre, 6);
        this.numCentros = numCentros;
        this.presupuesto = presupuesto;
        this.maxEstudiantes = maxEstudiantes;
    }

    //calculardemanda
    public void calcularDemanda() {
        double demanda = Math.abs(100 - this.maxEstudiantes);

        if (demanda > 100) {
            demanda = 100;
        }

        this.nivelDemanda = demanda;
    }

    //absorber otronivel de primaria
    protected void absorber(Primaria otro) {

        //disminuye en 1
        this.numCentros--;

        //suma de estudiantes
        this.maxEstudiantes = this.maxEstudiantes + otro.maxEstudiantes;

        //nueva demanda
        this.nivelDemanda = (this.nivelDemanda + otro.nivelDemanda) / 2.5;

        //nuevo presupuesto
        this.presupuesto = (this.presupuesto + otro.presupuesto) / 2.25;

        //recalcular demanda
        calcularDemanda();
    }

    @Override
    public void realizarEventoAnual() {
        System.out.println("Vamos al teatro a ver Peter Pan");
    }
//Solo hereda el metodoautomaticamente

    @Override
    public boolean agregarLibro(LibroTexto nuevo) {
        return super.agregarLibro(nuevo);
    }

    @Override
    public String toString() {
        String res = "";
        res += this.getNombre() + " [ " + this.zona + this.getDuraccion() + "años ]" + "\n";
        res += "[" + this.calificacionMin + this.nivelDemanda + this.numCentros + this.maxEstudiantes + "]" + "\n";
        res += this.presupuesto + "EUROS";
        return res;
    }

}
