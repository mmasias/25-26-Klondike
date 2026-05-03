public class Palo {

    private Carta[] carta;
    private Console console;
    private int ultima;
    private String nombre;
    private final int NUMERO_CARTAS_MAXIMAS = 13;

    public Palo(String nombresPalos) {
        carta = new Carta[13];
        console = new Console();
        ultima = 0;
        this.nombre = nombresPalos;
    }

    private boolean estaVacio() {
        return ultima == 0;
    }

    public void mostrar() {

        if (this.estaVacio()) {
            console.writeln(nombre + "[]");
        } else {
            Carta cima = carta[ultima - 1];
            console.write("Palo:" + nombre + "->");
            cima.mostrar();
        }
    }

    public void moverA(Columna columnaA) {
        if (!this.estaVacio()) {
            Carta cima = this.carta[ultima - 1];
            if (columnaA.esApilable(cima)) {
                columnaA.añadir(cima);
                ultima--;
            }
        }
    }

    public boolean completo() {
        return ultima == NUMERO_CARTAS_MAXIMAS;
    }

    public void añadir(Carta cartaNueva) {
        if (this.esApilable(cartaNueva)) {
            this.carta[ultima] = cartaNueva;
            ultima++;
        }
    }

    public boolean esApilable(Carta cartaNueva) {
        if (this.estaVacio()) {
            return cartaNueva.getNumero() == 0;
        } else {
            Carta cartaCima = carta[ultima - 1];
            return (cartaNueva.getPalo() == cartaCima.getPalo()
                    && cartaNueva.getNumero() == cartaCima.getNumero() + 1);
        }
    }

}
