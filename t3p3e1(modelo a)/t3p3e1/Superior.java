package t3p3e1;

public class Superior extends NivelEducativo {

    int numObligatorias;
    double numOptativas;

    public Superior(int numObligatorias, double numOptativas, String nombre, int duracion) {
        super(nombre, duracion);
        this.numObligatorias = numObligatorias;
        this.numOptativas = numOptativas;
    }

    @Override
    public String toString() {
        String res = "";
        res += "Estudio Superior : " + this.getNombre() + "," + this.getDuraccion() + " Años." + "\n";
        res += "Con: " + this.numObligatorias + " materias obligatorias y " + this.numOptativas + " materias Optativas ";
        return res;
    }

}
