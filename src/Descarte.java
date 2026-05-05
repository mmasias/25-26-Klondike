public class Descarte {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Descarte() {
        ultima = 0;
        cartas = new Carta[52 - 28];
        console = new Console();
    }

    public void mostrar() {
        console.write("Descarte: ");
        if (this.vacia()) {
            console.writeln("No hay cartas en el Descarte");
        } else {
            int primeraVisible = ultima - 3;
            if (primeraVisible < 0) {
                primeraVisible = 0;
            }
            for (int i = primeraVisible; i < ultima; i++) {
                cartas[i].mostrar();
            }
            console.writeln();
        }
    }

    private boolean vacia() {
        return ultima == 0;
    }

    public void moverA(Palo palo) {
        if (this.vacia()) {
            console.writeln("No hay cartas en el descarte.");
        } else {
            Carta carta = this.sacar();
            if (palo.apilable(carta)) {
                palo.poner(carta);
            } else {
                poner(carta);
                console.writeln("Jugada inválida.");
            }
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            console.writeln("No se puede mover");
        } else {
            Carta carta = this.sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                this.poner(carta);
                console.writeln("No se puede");
            }
        }
    }

    public void voltear(Baraja baraja) {
        if (this.vacia() || !baraja.vacia()) {
            console.writeln("No se puede voltear!");
        } else {
            while (!this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                baraja.poner(carta);
            }
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;        
    }
}
