public class Descarte extends Mazo {

    public Descarte() {
        ultima = 0;
        cartas = new Carta[52 - 28];
        console = new Console();
    }



    protected void mostrarContenido() {
        console.write("Descarte");
        int primeraVisible = ultima - 3;
        if (primeraVisible < 0) {
            primeraVisible = 0;
        }
        for (int i = primeraVisible; i < ultima; i++) {
            cartas[i].mostrar();
        }
        console.writeln();
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

}
