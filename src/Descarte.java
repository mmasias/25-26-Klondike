public class Descarte {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Descarte() {
        cartas = new Carta[52];
        ultima = 0;
        console = new Console();
    }

    public void mostrar() {
        if (!this.estaVacio()) {
            Carta cartaCima = cartas[ultima - 1];
            console.write("Descarte:");
            cartaCima.mostrar();
        } else {
            console.writeln("El descarte= " + "[]");
        }
    }

    private boolean estaVacio() {
        return ultima == 0;
    }

    private Carta sacar() {
        Carta carta = cartas[ultima - 1];
        ultima = ultima - 1;
        return carta;
    }

    public void moverA(Palo paloDestino) {
        if (this.estaVacio()) {
            console.write("El descarte esta vacio");
        } else {
            Carta carta = this.sacar();
            if (paloDestino.esApilable(carta)) {
                paloDestino.añadir(carta);
            } else {
                console.writeln("No se puede añadir a ese palo");
                this.añadir(carta);
            }
        }

    }

    public void moverA(Columna columnaDestino) {

        if (this.estaVacio()) {
            console.write("El descarte esta vacio");
        } else {
            Carta carta = this.sacar();

            if (columnaDestino.esApilable(carta)) {
                columnaDestino.añadir(carta);
            } else {
                console.writeln("Esa carta no es apilable en esa columna");
                this.añadir(carta);
            }

        }
    }

    public void voltear(Baraja baraja) {

        while (!this.estaVacio()) {
            Carta carta = this.sacar();
            carta.darVuelta();
            baraja.poner(carta);
        }
    }

    public void añadir(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

}
