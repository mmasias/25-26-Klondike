public class Columna {

    private int numeroCartas;
    private Carta[] cartas;

    public Columna(Baraja baraja, int i) {
        this.numeroCartas = i;
        this.cartas = new Carta[i];

        for (int j = 0; j < i; j++) {
            this.cartas[j] = baraja.sacarCarta(); 
        }
    }

    public void mostrar() {
        if (numeroCartas == 0) {
            System.out.println("[vacía]");
            return;
        }
        for (int j = 0; j < numeroCartas - 1; j++) {
            System.out.println("[Carta boca abajo]");
        }
        System.out.println(cartas[numeroCartas - 1]);
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
    private void poner(Carta cartaAMover) {
        this.cartas[numeroCartas] = cartaAMover;
        this.numeroCartas++;
    }
}