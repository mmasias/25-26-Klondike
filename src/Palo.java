public class Palo {

    private Carta[] cartas;
    private int ultima;
    private Console console;

    public Palo() {
        ultima = 0;
        cartas = new Carta[13];
        console = new Console();
    }

    public void mostrar() {
        console.write("Palo: ");
        if (this.vacia()) {
            console.writeln("No hay cartas en el palo");
        } else {
            Carta carta = this.cima();
            carta.mostrar();
            console.writeln();
        }
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    private boolean vacia() {
        return ultima == 0;
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            console.writeln("No se puede!");
        } else {
            Carta carta = this.sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                this.poner(carta);
                console.writeln("Invalido");
            }
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public boolean completo() {
        return this.cima().esRey();
    }

    public boolean apilable(Carta carta) {
        return this.vacia() && carta.esAs() ||
                !this.vacia() 
                    && carta.igualPalo(this.cima()) 
                    && carta.siguiente(this.cima());
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }
}
