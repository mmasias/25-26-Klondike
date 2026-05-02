public class Palo {
    private Carta[] cartas;
    private int numeroCartas;
    private Console console = new Console();

    public Palo() {
        this.cartas = new Carta[13];
        this.numeroCartas = 0;
    }
    public void mostrar() {
        if (numeroCartas == 0) {
            console.writeln("[vacía]");
        }
        for (int i = 0; i < numeroCartas; i++) {
            cartas[i].mostrar();
        }
    }

    public void moverA(Columna columnaA) {
        Carta cartaAMover = cartas[numeroCartas - 1];
        columnaA.poner(cartaAMover);
        numeroCartas--;
    }

    public boolean completo() {
        return numeroCartas == 13;
    }

    public void poner(Carta cartaAMover) {
        this.cartas[numeroCartas] = cartaAMover;
        this.numeroCartas++;
    }
}