public class Columna {

    private final int NUMERO_MAXIMO_DE_CARTAS = 52;
    private int numeroCartas;
    private Carta[] cartas;

    public Columna(Baraja baraja, int i) {
        this.numeroCartas = i;
        this.cartas = new Carta[NUMERO_MAXIMO_DE_CARTAS];

        for (int j = 0; j < i; j++) {
            this.cartas[j] = baraja.sacarCarta();
        }
    }

    public void mostrar() {
        if (numeroCartas == 0) {
            System.out.print("[vacía]");
            return;
        }
        for (int j = 0; j < numeroCartas - 1; j++) {
            System.out.print(" [Carta boca abajo]");
        }
        cartas[numeroCartas - 1].mostrar();
    }

    public void moverA(Palo paloA) {
        if (numeroCartas > 0) {
            Carta cartaAMover = cartas[numeroCartas - 1];
            paloA.poner(cartaAMover);
            numeroCartas--;
        }
    }

    public void moverA(Columna escogerColumna) {
        if (numeroCartas > 0) {
            Carta cartaAMover = cartas[numeroCartas - 1];
            escogerColumna.poner(cartaAMover);
            numeroCartas--;
        }
    }

    public void poner(Carta cartaAMover) {
        this.cartas[numeroCartas] = cartaAMover;
        this.numeroCartas++;
    }
}