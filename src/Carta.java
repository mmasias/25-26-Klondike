public class Carta {

    private int palo;
    private int numero;
    private boolean estaBocaArriba;
    private Console console;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        estaBocaArriba = false;
        console = new Console();
    }

    public void mostrar() {
        if (!estaBocaArriba) {
            console.writeln("[?] ");
        } else {
            String[] nombresPalos = { "corazones", "diamantes", "picas", "treboles" };
            String[] numero = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
            console.write("[" + numero[this.numero] + "]" + "[" + nombresPalos[this.palo] + "]");
        }
    }

    public boolean darVuelta() {
        return estaBocaArriba = !estaBocaArriba;
    }

    public boolean estaBocaArriba() {
        return estaBocaArriba;
    }

    public boolean esRoja() {
        return this.palo < 2;
    }

    public boolean esNegra() {
        return !this.esRoja();
    }

    public int getNumero() {
        return this.numero;
    }

    public int getPalo() {
        return this.palo;
    }

}
