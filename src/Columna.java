public class Columna {

    private Carta[] cartas;
    private int ultima;
    private int posicion;
    private Console console;

    public Columna(Baraja baraja, int posicion) {
        this.posicion = posicion;
        ultima = 0;
        cartas = new Carta[19];
        for (int i = 0; i < posicion; i++) {
            Carta carta = baraja.sacar();
            if (i == posicion - 1) {
                carta.voltear();
            }
            this.poner(carta);
        }
        console = new Console();
    }

    private void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        console.write("Columna [" + posicion + "]: ");
        if (this.vacia()) {
            console.write("NADA");
        } else {
            for (int i = 0; i < ultima; i++) {
                cartas[i].mostrar();
            }
        }
        console.writeln();
    }

    private boolean vacia() {
        return ultima == 0;
    }

    public void moverA(Palo palo) {
        if (this.vacia()) {
            console.writeln("No se puede");
        } else {
            Carta carta = this.sacar();
            if (palo.apilable(carta)) {
                palo.poner(carta);
            } else {
                this.poner(carta);
                console.writeln("No se puede!");
            }
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            console.writeln("no se puede!");
        } else {
            Carta carta = sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                this.poner(carta);
                System.out.println("No se puede!");
            }
        }
    }

    private boolean apilable(Carta carta) {
        return this.vacia() && carta.esRey() ||
                !this.vacia()
                        && this.cima().bocaArriba()
                        && this.cima().siguiente(carta)
                        && this.cima().distintoColor(carta);

    }

    private Carta cima() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cima'");
    }

}
