package t3p3e1;

public class LibroTexto {

    //propiedades
    private String nombre, autor;
    private int numPag;
    private double coste;
    private boolean reciclado;

    //constructor
    public LibroTexto(String nombre, String autor, int numPag, double coste, boolean reciclado) {
        this.nombre = nombre;
        this.autor = autor;
        this.coste = coste;
        this.reciclado = reciclado;

        if (reciclado) {
            this.numPag = numPag;
        } else {
            this.numPag = (int) (Math.random() * (200 - 100 + 1) + 100);
        }
    }

    //reducircoste
    public double reducirCoste(int numR) {
        int min = Math.min(this.numPag, numR);
        int max = Math.max(this.numPag, numR);
        double nuevoCoste = (int) (Math.random() * (max - min + 1) + min) * 0.65;

        return nuevoCoste;
    }

    @Override
    public String toString() {
        String res = "";
        res += this.nombre + " (" + this.autor + ") - " + this.numPag + " páginas\n";
        if (reciclado) {
            res += "Es reciclado";
        } else {
            res += "No es reciclado";
        }
        return res;
    }
}
